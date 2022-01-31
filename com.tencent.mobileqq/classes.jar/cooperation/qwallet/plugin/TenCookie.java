package cooperation.qwallet.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;

public class TenCookie
{
  private static final String COOKIE_TAG = "qpay";
  private static final String KEY_HOSTS = "KEY_HOSTS";
  private static final String QB_TENPAY_PAY = "qb_tenpay_cookies_";
  private static final String TAG = "TenCookie";
  private String domainPattern = "(?i)domain=[\\w\\.]+;";
  private String expirePattern = "(?i)expires=[\\w\\s:,]+;";
  private Map insCookies = new ConcurrentHashMap();
  private int mIndex = 1;
  private String qpayKPattern = String.format("%s(\\w+)?=", new Object[] { "qpay" });
  private String qpayPattern = String.format("%s(\\w+)?=[%%\\w\\$\\(\\)\\[\\]\\*\\+\\.\\^\\|@#&-]*;", new Object[] { "qpay" });
  private Map tempArgs = new HashMap();
  private String uin = "";
  
  private JSONArray List2JArray(List paramList)
  {
    return new JSONArray(paramList);
  }
  
  public static TenCookie getInstance()
  {
    return TenCookie.Instance.ins;
  }
  
  private String getShareName()
  {
    return "qb_tenpay_cookies_" + this.uin;
  }
  
  private List jArray2List(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(paramJSONArray.getString(i));
      i += 1;
    }
    return localArrayList;
  }
  
  private String prosOneHost(String paramString, List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer("");
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      String str1 = (String)paramList.get(i);
      String str3 = regGet(str1, this.expirePattern, "expires=", false);
      if (TextUtils.isEmpty(str3)) {}
      for (;;)
      {
        i -= 1;
        break;
        long l = new Date(str3).getTime();
        if (NetConnInfoCenter.getServerTimeMillis() > l)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TenCookie", 2, "cookie time out curTime = " + NetConnInfoCenter.getServerTimeMillis() + " expire = " + l + " cookie = " + str1);
          }
          try
          {
            paramList.remove(i);
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}
        }
        else
        {
          String str2 = regGet(localIndexOutOfBoundsException, this.qpayPattern, null, false);
          if (str2 != null) {
            localStringBuffer.append(str2 + ";");
          }
        }
      }
    }
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(localStringBuffer))) {
      QLog.i("TenCookie", 2, paramString + " -> " + localStringBuffer.toString());
    }
    return localStringBuffer.toString();
  }
  
  private String regGet(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int j = 0;
    paramString2 = Pattern.compile(paramString2).matcher(paramString1);
    if (paramString2.find())
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        int k = paramString2.start();
        if (paramString3 != null) {
          j = paramString3.length();
        }
        return paramString1.substring(j + k, paramString2.end() - i);
      }
    }
    return null;
  }
  
  private void repListIfExist(List paramList, String paramString1, String paramString2)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      if (((String)paramList.get(i)).contains(paramString2))
      {
        QLog.i("TenCookie", 2, "replace cookie " + paramString2);
        paramList.remove(i);
      }
      i -= 1;
    }
    paramList.add(paramString1);
  }
  
  private void timeToShare(Context paramContext)
  {
    ThreadManager.post(new TenCookie.1(this, paramContext), 2, null, true);
  }
  
  public boolean clearTempArgs(String paramString)
  {
    if (paramString == null)
    {
      this.tempArgs.clear();
      return true;
    }
    if (this.tempArgs.containsKey(paramString))
    {
      this.tempArgs.remove(paramString);
      return true;
    }
    return false;
  }
  
  public String getMsgNo(String paramString)
  {
    String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(str);
    int i = this.mIndex;
    this.mIndex = (i + 1);
    paramString = String.valueOf(i);
    int j = localStringBuilder.length();
    int k = paramString.length();
    i = 0;
    while (i < 28 - j - k)
    {
      localStringBuilder.append("0");
      i += 1;
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public String getTempArgs(String paramString)
  {
    return (String)this.tempArgs.get(paramString);
  }
  
  public String readTagCookie(Context paramContext, String paramString1, String paramString2)
  {
    QLog.i("TenCookie", 2, "readTagCookie this = " + this);
    if ((TextUtils.isEmpty(paramString2)) || (paramContext == null)) {
      return null;
    }
    setUin(paramString1);
    if (this.insCookies.size() <= 0) {}
    String str1;
    try
    {
      paramContext = paramContext.getSharedPreferences(getShareName(), 4);
      paramString1 = paramContext.getString("KEY_HOSTS", null);
      if (QLog.isColorLevel()) {
        QLog.i("TenCookie", 2, "initialize cookie from share " + paramString1);
      }
      boolean bool = TextUtils.isEmpty(paramString1);
      if (!bool) {
        try
        {
          paramString1 = new JSONArray(paramString1);
          int i = 0;
          while (i < paramString1.length())
          {
            str1 = (String)paramString1.get(i);
            String str2 = paramContext.getString(str1, null);
            if (!TextUtils.isEmpty(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.i("TenCookie", 2, "initialize sdomain = " + str1 + " : " + str2);
              }
              this.insCookies.put(str1, jArray2List(new JSONArray(str2)));
            }
            i += 1;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      QLog.i("TenCookie", 2, "readTagCookie insCookie size = " + this.insCookies.size());
      if (this.insCookies.size() <= 0) {
        return "";
      }
    }
    finally {}
    paramContext = new StringBuffer("");
    paramString1 = this.insCookies.keySet().iterator();
    while (paramString1.hasNext())
    {
      str1 = (String)paramString1.next();
      if ((paramString2.equals(str1)) || (paramString2.contains(str1)))
      {
        QLog.i("TenCookie", 2, "domain matched, append : " + str1);
        str1 = prosOneHost(paramString2, (List)this.insCookies.get(str1));
        if (!TextUtils.isEmpty(str1)) {
          paramContext.append(str1);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TenCookie", 2, paramString2 + " => " + paramContext.toString());
    }
    return paramContext.toString();
  }
  
  public String setTempArgs(String paramString1, String paramString2)
  {
    String str = null;
    if (this.tempArgs.containsKey(paramString1)) {
      str = (String)this.tempArgs.get(paramString1);
    }
    this.tempArgs.put(paramString1, paramString2);
    return str;
  }
  
  public boolean setUin(String paramString)
  {
    try
    {
      if ((TextUtils.isEmpty(paramString)) || (this.uin.equals(paramString))) {
        return false;
      }
      this.uin = paramString;
      this.insCookies.clear();
      QLog.i("TenCookie", 2, "change user...");
      return true;
    }
    finally {}
  }
  
  public void writeTagCookie(Context paramContext, String paramString, List paramList)
  {
    if ((paramContext == null) || (paramList.size() <= 0)) {
      return;
    }
    setUin(paramString);
    int i = paramList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        String str2 = (String)paramList.get(i);
        QLog.i("TenCookie", 2, "writeTagCookie cookie = " + str2 + " uin = " + this.uin);
        String str3 = regGet(str2, this.qpayKPattern, null, true);
        String str1;
        if (str3 != null)
        {
          str1 = regGet(str2, this.domainPattern, "domain=", false);
          if (TextUtils.isEmpty(str1))
          {
            QLog.i("TenCookie", 2, str1 + "writeTagCookie domain error, abort...");
            return;
          }
          QLog.i("TenCookie", 2, str1 + " <= " + str2);
          if (!this.insCookies.containsKey(str1)) {
            break label251;
          }
          paramString = (List)this.insCookies.get(str1);
        }
        try
        {
          for (;;)
          {
            repListIfExist(paramString, str2, str3);
            this.insCookies.put(str1, paramString);
            i -= 1;
            break;
            label251:
            paramString = new ArrayList();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    timeToShare(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qwallet.plugin.TenCookie
 * JD-Core Version:    0.7.0.1
 */
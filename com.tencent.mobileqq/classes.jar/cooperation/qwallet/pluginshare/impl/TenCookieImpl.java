package cooperation.qwallet.pluginshare.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.pluginshare.ITenCookie;
import java.io.UnsupportedEncodingException;
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

public class TenCookieImpl
  implements ITenCookie
{
  private static final String COOKIE_TAG = "qpay";
  private static final String KEY_HOSTS = "KEY_HOSTS";
  private static final String QB_TENPAY_HB_RANDOM = "q$WaQ3#k";
  private static final String QB_TENPAY_PAY = "qb_tenpay_cookies_";
  private static final String TAG = "TenCookie";
  private String domainPattern = "(?i)domain=[\\w\\.]+;";
  private String expirePattern = "(?i)expires=[\\w\\s:,]+;";
  private Map<String, List<String>> insCookies = new ConcurrentHashMap();
  private int mIndex = 1;
  private String qpayKPattern = String.format("%s(\\w+)?=", new Object[] { "qpay" });
  private String qpayPattern = String.format("%s(\\w+)?=[%%\\w\\$\\(\\)\\[\\]\\*\\+\\.\\^\\|@#&-]*;", new Object[] { "qpay" });
  private Map<String, String> tempArgs = new HashMap();
  private String uin = "";
  
  private JSONArray List2JArray(List<String> paramList)
  {
    return new JSONArray(paramList);
  }
  
  private String getShareName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qb_tenpay_cookies_");
    localStringBuilder.append(this.uin);
    return localStringBuilder.toString();
  }
  
  public static String getUserKeyWithUin(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramString);
    localStringBuilder2.append("_");
    localStringBuilder2.append(DeviceInfoUtil.a());
    localStringBuilder1.append(MD5.toMD5(localStringBuilder2.toString()));
    localStringBuilder1.append("q$WaQ3#k");
    return MD5.toMD5(localStringBuilder1.toString()).substring(8, 24);
  }
  
  private List<String> jArray2List(JSONArray paramJSONArray)
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
  
  private String prosOneHost(String paramString, List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return null;
      }
      StringBuffer localStringBuffer = new StringBuffer("");
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        String str = (String)paramList.get(i);
        Object localObject = regGet(str, this.expirePattern, "expires=", false);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          long l = new Date((String)localObject).getTime();
          if (NetConnInfoCenter.getServerTimeMillis() > l) {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("cookie time out curTime = ");
              ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTimeMillis());
              ((StringBuilder)localObject).append(" expire = ");
              ((StringBuilder)localObject).append(l);
              ((StringBuilder)localObject).append(" cookie = ");
              ((StringBuilder)localObject).append(str);
              QLog.i("TenCookie", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
        try
        {
          paramList.remove(i);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          label241:
          break label241;
        }
        str = regGet(str, this.qpayPattern, null, false);
        if (str != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(";");
          localStringBuffer.append(((StringBuilder)localObject).toString());
        }
        i -= 1;
      }
      if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(localStringBuffer)))
      {
        paramList = new StringBuilder();
        paramList.append(paramString);
        paramList.append(" -> ");
        paramList.append(localStringBuffer.toString());
        QLog.i("TenCookie", 2, paramList.toString());
      }
      return localStringBuffer.toString();
    }
    else
    {
      return null;
    }
  }
  
  private String regGet(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramString2 = Pattern.compile(paramString2).matcher(paramString1);
    if (paramString2.find())
    {
      int j = paramString2.start();
      int i;
      if (paramString3 != null) {
        i = paramString3.length();
      } else {
        i = 0;
      }
      return paramString1.substring(j + i, paramString2.end() - (paramBoolean ^ true));
    }
    return null;
  }
  
  private void repListIfExist(List<String> paramList, String paramString1, String paramString2)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      if (((String)paramList.get(i)).contains(paramString2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("replace cookie ");
        localStringBuilder.append(paramString2);
        QLog.i("TenCookie", 2, localStringBuilder.toString());
        paramList.remove(i);
      }
      i -= 1;
    }
    paramList.add(paramString1);
  }
  
  private void timeToShare(Context paramContext)
  {
    ThreadManager.post(new TenCookieImpl.1(this, paramContext), 2, null, true);
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
  
  public String getEncryptValue(String paramString1, String paramString2, SharedPreferences paramSharedPreferences)
  {
    String str2 = getUserKeyWithUin(paramString1);
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append("_");
    paramString1.append(str2);
    String str1 = paramSharedPreferences.getString(paramString1.toString(), "");
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("getEncryptUserValue,encryptValue:");
      paramString1.append(str1);
      paramString1.append(",userKey:");
      paramString1.append(str2);
      QLog.i("TenCookie", 2, paramString1.toString());
    }
    Cryptor localCryptor = new Cryptor();
    paramSharedPreferences = null;
    paramString1 = paramSharedPreferences;
    if (!TextUtils.isEmpty(str1))
    {
      paramString1 = paramSharedPreferences;
      if (TextUtils.isEmpty(str2)) {}
    }
    try
    {
      paramString1 = str2.getBytes("ISO8859_1");
    }
    catch (UnsupportedEncodingException paramString1)
    {
      label145:
      break label145;
    }
    paramString1 = str2.getBytes();
    try
    {
      paramString2 = str1.getBytes("ISO8859_1");
    }
    catch (UnsupportedEncodingException paramString2)
    {
      label163:
      break label163;
    }
    paramString2 = str1.getBytes();
    paramString2 = localCryptor.decrypt(paramString2, paramString1);
    paramString1 = paramSharedPreferences;
    if (paramString2 != null) {}
    try
    {
      paramString1 = new String(paramString2, "ISO8859_1");
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      label197:
      break label197;
    }
    paramString1 = new String(paramString2);
    return paramString1;
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
    if (this.tempArgs.containsKey(paramString)) {
      return (String)this.tempArgs.get(paramString);
    }
    return null;
  }
  
  public String putEncryptValue(String paramString1, String paramString2, SharedPreferences paramSharedPreferences, String paramString3)
  {
    String str = getUserKeyWithUin(paramString1);
    boolean bool = TextUtils.isEmpty(paramString3);
    paramString1 = null;
    Object localObject2 = null;
    Object localObject1 = paramString1;
    if (!bool)
    {
      localObject1 = paramString1;
      if (TextUtils.isEmpty(str)) {}
    }
    try
    {
      paramString1 = str.getBytes("ISO8859_1");
    }
    catch (UnsupportedEncodingException paramString1)
    {
      label49:
      label72:
      break label49;
    }
    paramString1 = str.getBytes();
    try
    {
      localObject1 = paramString3.getBytes("ISO8859_1");
      paramString3 = (String)localObject1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label72;
    }
    paramString3 = paramString3.getBytes();
    paramString3 = new Cryptor().encrypt(paramString3, paramString1);
    paramString1 = localObject2;
    if (paramString3 != null) {}
    try
    {
      paramString1 = new String(paramString3, "ISO8859_1");
    }
    catch (UnsupportedEncodingException paramString1)
    {
      label118:
      break label118;
    }
    paramString1 = new String(paramString3);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramSharedPreferences = paramSharedPreferences.edit();
      paramString3 = new StringBuilder();
      paramString3.append(paramString2);
      paramString3.append("_");
      paramString3.append(str);
      paramSharedPreferences.putString(paramString3.toString(), paramString1).apply();
    }
    localObject1 = paramString1;
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("putEncryptUserValue,encryptValue:");
      paramString2.append(paramString1);
      QLog.i("TenCookie", 2, paramString2.toString());
      localObject1 = paramString1;
    }
    return localObject1;
  }
  
  public String readTagCookie(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("readTagCookie this = ");
    ((StringBuilder)localObject1).append(this);
    QLog.i("TenCookie", 2, ((StringBuilder)localObject1).toString());
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramContext == null) {
        return null;
      }
      setUin(paramString1);
      Object localObject2;
      if (this.insCookies.size() <= 0) {
        try
        {
          paramContext = paramContext.getSharedPreferences(getShareName(), 4);
          paramString1 = paramContext.getString("KEY_HOSTS", null);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("initialize cookie from share ");
            ((StringBuilder)localObject1).append(paramString1);
            QLog.i("TenCookie", 2, ((StringBuilder)localObject1).toString());
          }
          boolean bool = TextUtils.isEmpty(paramString1);
          if (!bool) {
            try
            {
              paramString1 = new JSONArray(paramString1);
              int i = 0;
              while (i < paramString1.length())
              {
                localObject1 = (String)paramString1.get(i);
                localObject2 = paramContext.getString((String)localObject1, null);
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  if (QLog.isColorLevel())
                  {
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("initialize sdomain = ");
                    localStringBuilder.append((String)localObject1);
                    localStringBuilder.append(" : ");
                    localStringBuilder.append((String)localObject2);
                    QLog.i("TenCookie", 2, localStringBuilder.toString());
                  }
                  this.insCookies.put(localObject1, jArray2List(new JSONArray((String)localObject2)));
                }
                i += 1;
              }
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
            }
          }
        }
        finally {}
      }
      paramContext = new StringBuilder();
      paramContext.append("readTagCookie insCookie size = ");
      paramContext.append(this.insCookies.size());
      QLog.i("TenCookie", 2, paramContext.toString());
      if (this.insCookies.size() <= 0) {
        return "";
      }
      paramContext = new StringBuffer("");
      paramString1 = this.insCookies.keySet().iterator();
      while (paramString1.hasNext())
      {
        localObject1 = (String)paramString1.next();
        if ((paramString2.equals(localObject1)) || (paramString2.contains((CharSequence)localObject1)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("domain matched, append : ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("TenCookie", 2, ((StringBuilder)localObject2).toString());
          localObject1 = prosOneHost(paramString2, (List)this.insCookies.get(localObject1));
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            paramContext.append((String)localObject1);
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append(" => ");
        paramString1.append(paramContext.toString());
        QLog.i("TenCookie", 2, paramString1.toString());
      }
      return paramContext.toString();
    }
    return null;
  }
  
  public String setTempArgs(String paramString1, String paramString2)
  {
    String str;
    if (this.tempArgs.containsKey(paramString1)) {
      str = (String)this.tempArgs.get(paramString1);
    } else {
      str = null;
    }
    this.tempArgs.put(paramString1, paramString2);
    return str;
  }
  
  public boolean setUin(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (!this.uin.equals(paramString)))
      {
        this.uin = paramString;
        this.insCookies.clear();
        QLog.i("TenCookie", 2, "change user...");
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public void writeTagCookie(Context paramContext, String paramString, List<String> paramList)
  {
    if (paramContext != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      setUin(paramString);
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        String str2 = (String)paramList.get(i);
        paramString = new StringBuilder();
        paramString.append("writeTagCookie cookie = ");
        paramString.append(str2);
        paramString.append(" uin = ");
        paramString.append(this.uin);
        QLog.i("TenCookie", 2, paramString.toString());
        String str3 = regGet(str2, this.qpayKPattern, null, true);
        if (str3 != null)
        {
          String str1 = regGet(str2, this.domainPattern, "domain=", false);
          if (TextUtils.isEmpty(str1))
          {
            paramContext = new StringBuilder();
            paramContext.append(str1);
            paramContext.append("writeTagCookie domain error, abort...");
            QLog.i("TenCookie", 2, paramContext.toString());
            return;
          }
          paramString = new StringBuilder();
          paramString.append(str1);
          paramString.append(" <= ");
          paramString.append(str2);
          QLog.i("TenCookie", 2, paramString.toString());
          if (this.insCookies.containsKey(str1)) {
            paramString = (List)this.insCookies.get(str1);
          } else {
            paramString = new ArrayList();
          }
          try
          {
            repListIfExist(paramString, str2, str3);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          this.insCookies.put(str1, paramString);
        }
        i -= 1;
      }
      timeToShare(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qwallet.pluginshare.impl.TenCookieImpl
 * JD-Core Version:    0.7.0.1
 */
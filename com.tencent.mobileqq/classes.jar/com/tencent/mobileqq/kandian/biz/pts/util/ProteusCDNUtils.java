package com.tencent.mobileqq.kandian.biz.pts.util;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusCDNSp;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusCDNUtils
{
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[checkUpdate], bid = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", retStr = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", retCode = ");
    localStringBuilder.append(paramInt);
    QLog.i("ProteusCDNUtils", 1, localStringBuilder.toString());
    try
    {
      if (b(paramString2))
      {
        c(paramString1);
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("[checkUpdate], e = ");
      paramString2.append(paramString1);
      QLog.e("ProteusCDNUtils", 1, paramString2.toString());
    }
  }
  
  private static void b(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[reportData], eventType = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", bid = ");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("ProteusCDNUtils", 1, ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("bid", paramString2);
    }
    catch (JSONException paramString2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[reportData], e = ");
      localStringBuilder.append(paramString2);
      QLog.e("ProteusCDNUtils", 1, localStringBuilder.toString());
    }
    PublicAccountReportUtils.a(null, "", paramString1, paramString1, 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
  }
  
  private static boolean b(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1)
    {
      QLog.i("ProteusCDNUtils", 1, "[shouldDownloadByCDN], retStr is null, no need download by CDN.");
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("data");
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.length() > 0)
        {
          paramString = paramString.optJSONObject(0);
          bool1 = bool2;
          if (paramString != null)
          {
            int i = paramString.optInt("code");
            if (i < 10)
            {
              bool1 = bool2;
              if (i > 0) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    catch (Exception paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[shouldDownloadByCDN], e = ");
      localStringBuilder.append(paramString);
      QLog.e("ProteusCDNUtils", 1, localStringBuilder.toString());
      bool1 = bool2;
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[shouldDownloadByCDN] parse json exception, e = ");
      localStringBuilder.append(paramString);
      QLog.e("ProteusCDNUtils", 1, localStringBuilder.toString());
      bool1 = bool2;
    }
    paramString = new StringBuilder();
    paramString.append("[shouldDownloadByCDN], ret = ");
    paramString.append(bool1);
    QLog.i("ProteusCDNUtils", 1, paramString.toString());
    return bool1;
  }
  
  private static void c(String paramString)
  {
    if (!d(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[downloadByCDN], no need to download by cdn, bid = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("ProteusCDNUtils", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH_READINJOY_OFFLINE_TEMP_FOLDER);
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".7z");
    localObject = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    String str = e(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[downloadByCDN], bid = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", localPath = ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", cdnUrl = ");
    localStringBuilder.append(str);
    QLog.i("ProteusCDNUtils", 1, localStringBuilder.toString());
    ThreadManager.excute(new ProteusCDNUtils.1((String)localObject, paramString, str), 128, null, false);
    b("0X800ABFE", paramString);
  }
  
  private static boolean d(String paramString)
  {
    Object localObject = e(paramString);
    boolean bool2 = TextUtils.isEmpty((CharSequence)localObject);
    boolean bool1 = false;
    if ((!bool2) && (!TextUtils.equals("0", (CharSequence)localObject)))
    {
      long l2 = 0L;
      long l1;
      try
      {
        localObject = ((String)localObject).split("/");
        StringBuilder localStringBuilder;
        if (localObject.length > 0)
        {
          localObject = Pattern.compile("\\d+").matcher(localObject[(localObject.length - 1)]);
          if (((Matcher)localObject).find())
          {
            localObject = ((Matcher)localObject).group();
            try
            {
              l1 = Long.valueOf((String)localObject).longValue();
            }
            catch (NumberFormatException localNumberFormatException)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[isAbleToDownloadByCDN], e = ");
              localStringBuilder.append(localNumberFormatException);
              QLog.e("ProteusCDNUtils", 1, localStringBuilder.toString());
            }
          }
        }
        l1 = 0L;
      }
      catch (Exception localException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[isAbleToDownloadByCDN], e = ");
        localStringBuilder.append(localException);
        QLog.e("ProteusCDNUtils", 1, localStringBuilder.toString());
      }
      paramString = HtmlOffline.c(paramString);
      if (paramString != null) {
        l2 = paramString.optLong("version", 0L);
      }
      paramString = new StringBuilder();
      paramString.append("[isAbleToDownloadByCDN], urlVersion = ");
      paramString.append(l1);
      paramString.append(", localVersion = ");
      paramString.append(l2);
      QLog.i("ProteusCDNUtils", 1, paramString.toString());
      if (l1 > l2) {
        bool1 = true;
      }
      return bool1;
    }
    QLog.i("ProteusCDNUtils", 1, "[isAbleToDownloadByCDN], cdn url is null or 0.");
    return false;
  }
  
  private static String e(String paramString)
  {
    String str = (String)RIJSPUtils.b(RIJProteusCDNSp.a(paramString), "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getCDNUrl], bid = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", cdnUrl = ");
    localStringBuilder.append(str);
    QLog.i("ProteusCDNUtils", 1, localStringBuilder.toString());
    return str;
  }
  
  private static void f(String paramString)
  {
    ThreadManager.excute(new ProteusCDNUtils.2(paramString), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.ProteusCDNUtils
 * JD-Core Version:    0.7.0.1
 */
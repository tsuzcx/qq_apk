package cooperation.qzone.util;

import android.text.TextUtils;
import com.tencent.component.network.downloader.common.Utils;
import common.config.service.QzoneConfig;
import org.json.JSONArray;
import org.json.JSONException;

public class QzoneBanApkDownloadHelper
{
  private static final String TAG = "QzoneBanApkDownloadHelper";
  private static final String gApkBanlistDomainArrayConfig = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneApkBanDomainList", "douyin.com,huoshan.com,changba.com,toutiao.com,xiguaapp.cn,xiguashipin.cn,365yg.com,snssdk.com,ixigua.com,toutiaocdn.net,music.163.com,weibo.cn,autohome.com.cn");
  private static String gQzoneCallAppUrlListConfig = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneCallAppUrlList", "['https?://intent\\.music\\.163\\.com.+orpheus.*','^https?://([^/]+\\.)?thefatherofsalmon\\.com[/:].+','^https?://127\\.0\\.0\\.1[/:].+','^https?://0:0:0:0:0:0:0:1[/:].+','^https?://::1[/:].+']");
  
  private static String[] getApkBanlistDomainArray()
  {
    Object localObject = gApkBanlistDomainArrayConfig;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = ((String)localObject).split(",");
    if (localObject == null) {
      return null;
    }
    int i = 0;
    while (i < localObject.length)
    {
      if (TextUtils.isEmpty(localObject[i])) {
        localObject[i] = "";
      } else {
        localObject[i] = localObject[i].trim();
      }
      i += 1;
    }
    return localObject;
  }
  
  public static boolean isDomainInBlackList(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = Utils.getDomin(paramString);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    str = str.toLowerCase();
    Object localObject1 = getApkBanlistDomainArray();
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        return false;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = ((String)localObject2).toLowerCase();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(".");
          localStringBuilder.append((String)localObject2);
          if (str.endsWith(localStringBuilder.toString()))
          {
            if (QZLog.isDevelopLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("match domain:");
              ((StringBuilder)localObject1).append(str);
              ((StringBuilder)localObject1).append(",webviewUrl=");
              ((StringBuilder)localObject1).append(paramString);
              QZLog.d("QzoneBanApkDownloadHelper", 4, ((StringBuilder)localObject1).toString());
            }
            return true;
          }
          if (str.equals(localObject2))
          {
            if (QZLog.isDevelopLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("match domain:");
              ((StringBuilder)localObject1).append(str);
              ((StringBuilder)localObject1).append(",webviewUrl=");
              ((StringBuilder)localObject1).append(paramString);
              QZLog.d("QzoneBanApkDownloadHelper", 4, ((StringBuilder)localObject1).toString());
            }
            return true;
          }
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean isUrlInRegList(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    try
    {
      Object localObject = new JSONArray(paramString2);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        paramString2 = ((JSONArray)localObject).optString(i);
        if ((!TextUtils.isEmpty(paramString2)) && (QzoneStringMatcher.isMatch(paramString1, paramString2)))
        {
          if (QZLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isUrlInRegList match url:");
            ((StringBuilder)localObject).append(paramString1);
            ((StringBuilder)localObject).append(" ,reg=");
            ((StringBuilder)localObject).append(paramString2);
            QZLog.i("QzoneBanApkDownloadHelper", 1, ((StringBuilder)localObject).toString());
          }
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (JSONException paramString1)
    {
      QZLog.e("QzoneBanApkDownloadHelper", "isUrlInRegList json error.", paramString1);
    }
    return false;
  }
  
  public static boolean isUrlMatchQzoneCallAppUrlList(String paramString)
  {
    return isUrlInRegList(paramString, gQzoneCallAppUrlListConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.QzoneBanApkDownloadHelper
 * JD-Core Version:    0.7.0.1
 */
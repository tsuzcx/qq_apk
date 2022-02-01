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
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return null;
      localObject = ((String)localObject).split(",");
    } while (localObject == null);
    int i = 0;
    if (i < localObject.length)
    {
      if (TextUtils.isEmpty(localObject[i])) {
        localObject[i] = "";
      }
      for (;;)
      {
        i += 1;
        break;
        localObject[i] = localObject[i].trim();
      }
    }
    return localObject;
  }
  
  public static boolean isDomainInBlackList(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str1;
    String[] arrayOfString;
    do
    {
      do
      {
        return false;
        str1 = Utils.getDomin(paramString);
      } while (TextUtils.isEmpty(str1));
      str1 = str1.toLowerCase();
      arrayOfString = getApkBanlistDomainArray();
    } while ((arrayOfString == null) || (arrayOfString.length == 0));
    int j = arrayOfString.length;
    int i = 0;
    label48:
    String str2;
    if (i < j)
    {
      str2 = arrayOfString[i];
      if (!TextUtils.isEmpty(str2)) {
        break label74;
      }
    }
    label74:
    do
    {
      i += 1;
      break label48;
      break;
      str2 = str2.toLowerCase();
      if (str1.endsWith("." + str2))
      {
        if (QZLog.isDevelopLevel()) {
          QZLog.d("QzoneBanApkDownloadHelper", 4, "match domain:" + str1 + ",webviewUrl=" + paramString);
        }
        return true;
      }
    } while (!str1.equals(str2));
    if (QZLog.isDevelopLevel()) {
      QZLog.d("QzoneBanApkDownloadHelper", 4, "match domain:" + str1 + ",webviewUrl=" + paramString);
    }
    return true;
  }
  
  public static boolean isUrlInRegList(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    while (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString2 = new JSONArray(paramString2);
        i = 0;
        if (i >= paramString2.length()) {
          break;
        }
        String str = paramString2.optString(i);
        if ((!TextUtils.isEmpty(str)) && (QzoneStringMatcher.isMatch(paramString1, str)))
        {
          if (QZLog.isDevelopLevel()) {
            QZLog.i("QzoneBanApkDownloadHelper", 1, "isUrlInRegList match url:" + paramString1 + " ,reg=" + str);
          }
          return true;
        }
      }
      catch (JSONException paramString1)
      {
        QZLog.e("QzoneBanApkDownloadHelper", "isUrlInRegList json error.", paramString1);
        return false;
      }
      i += 1;
    }
  }
  
  public static boolean isUrlMatchQzoneCallAppUrlList(String paramString)
  {
    return isUrlInRegList(paramString, gQzoneCallAppUrlListConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.QzoneBanApkDownloadHelper
 * JD-Core Version:    0.7.0.1
 */
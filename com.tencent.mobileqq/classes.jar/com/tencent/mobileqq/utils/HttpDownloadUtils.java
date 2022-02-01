package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.qphone.base.util.QLog;

public class HttpDownloadUtils
{
  public static void a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (paramDownloadInfo.urlOriginal == null) || (paramDownloadInfo.urlOriginal.length() == 0)) {}
    label33:
    int i;
    int j;
    String str2;
    do
    {
      return;
      if (!paramDownloadInfo.isHttps) {
        break;
      }
      localObject = HttpDownloadUtil.PROTOCOL_HTTPS;
      i = ((String)localObject).length();
      j = paramDownloadInfo.urlOriginal.indexOf("/", i);
      str2 = paramDownloadInfo.urlOriginal.substring(i, j);
    } while ((j <= i) && (TextUtils.isEmpty(str2)));
    label86:
    String str1;
    if ("imgcache.qq.com".equalsIgnoreCase(str2))
    {
      i = 12;
      str1 = (String)localObject + "[^/\\s]*/";
      String str3 = FMTSrvAddrProvider.getInstance().getSrvAddr(i);
      if ((str3 == null) || (str3.length() <= 0)) {
        break label396;
      }
      str1 = paramDownloadInfo.urlOriginal.replaceFirst(str1, str3);
      if ((!paramDownloadInfo.isHttps) || (TextUtils.isEmpty(str1)) || (!str1.startsWith("http://"))) {
        break label454;
      }
    }
    label396:
    label454:
    for (Object localObject = (String)localObject + str1.substring("http://".length());; localObject = str1)
    {
      paramDownloadInfo.host = str2;
      paramDownloadInfo.reqUrl = ((String)localObject);
      paramDownloadInfo.isIPUrl = true;
      paramDownloadInfo.domainType = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp " + paramDownloadInfo.isIPUrl + " url[" + paramDownloadInfo.urlOriginal + "] resetIP[" + (String)localObject + "] host[" + paramDownloadInfo.host + "]");
      return;
      localObject = "http://";
      break label33;
      if ("imgcache.gtimg.cn".equalsIgnoreCase(str2))
      {
        i = 13;
        break label86;
      }
      if ("i.gtimg.cn".equalsIgnoreCase(str2))
      {
        i = 14;
        break label86;
      }
      if ("cmshow.gtimg.cn".equalsIgnoreCase(str2))
      {
        i = 17;
        break label86;
      }
      paramDownloadInfo.host = null;
      paramDownloadInfo.reqUrl = paramDownloadInfo.urlOriginal;
      paramDownloadInfo.isIPUrl = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "unknow domain url=" + paramDownloadInfo.isIPUrl);
      return;
      paramDownloadInfo.host = null;
      paramDownloadInfo.reqUrl = paramDownloadInfo.urlOriginal;
      paramDownloadInfo.isIPUrl = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp false.url[" + paramDownloadInfo.reqUrl + "]");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtils
 * JD-Core Version:    0.7.0.1
 */
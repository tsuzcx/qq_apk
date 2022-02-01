package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.qphone.base.util.QLog;

public class HttpDownloadUtils
{
  public static void a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (paramDownloadInfo.urlOriginal != null))
    {
      if (paramDownloadInfo.urlOriginal.length() == 0) {
        return;
      }
      Object localObject1;
      if (paramDownloadInfo.isHttps) {
        localObject1 = HttpDownloadUtil.PROTOCOL_HTTPS;
      } else {
        localObject1 = "http://";
      }
      int i = ((String)localObject1).length();
      int j = paramDownloadInfo.urlOriginal.indexOf("/", i);
      String str2 = paramDownloadInfo.urlOriginal.substring(i, j);
      if ((j <= i) && (TextUtils.isEmpty(str2))) {
        return;
      }
      if ("imgcache.qq.com".equalsIgnoreCase(str2))
      {
        i = 12;
      }
      else if ("imgcache.gtimg.cn".equalsIgnoreCase(str2))
      {
        i = 13;
      }
      else if ("i.gtimg.cn".equalsIgnoreCase(str2))
      {
        i = 14;
      }
      else
      {
        if (!"cmshow.gtimg.cn".equalsIgnoreCase(str2)) {
          break label462;
        }
        i = 17;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("[^/\\s]*/");
      localObject2 = ((StringBuilder)localObject2).toString();
      String str1 = FMTSrvAddrProvider.getInstance().getSrvAddr(i);
      if ((str1 != null) && (str1.length() > 0))
      {
        str1 = paramDownloadInfo.urlOriginal.replaceFirst((String)localObject2, str1);
        localObject2 = str1;
        if (paramDownloadInfo.isHttps)
        {
          localObject2 = str1;
          if (!TextUtils.isEmpty(str1))
          {
            localObject2 = str1;
            if (str1.startsWith("http://"))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(str1.substring(7));
              localObject2 = ((StringBuilder)localObject2).toString();
            }
          }
        }
        paramDownloadInfo.host = str2;
        paramDownloadInfo.reqUrl = ((String)localObject2);
        paramDownloadInfo.isIPUrl = true;
        paramDownloadInfo.domainType = i;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("replaceDomainWithIp ");
          ((StringBuilder)localObject1).append(paramDownloadInfo.isIPUrl);
          ((StringBuilder)localObject1).append(" url[");
          ((StringBuilder)localObject1).append(paramDownloadInfo.urlOriginal);
          ((StringBuilder)localObject1).append("] resetIP[");
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("] host[");
          ((StringBuilder)localObject1).append(paramDownloadInfo.host);
          ((StringBuilder)localObject1).append("]");
          QLog.d("Q.emoji.EmoDown", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        paramDownloadInfo.host = null;
        paramDownloadInfo.reqUrl = paramDownloadInfo.urlOriginal;
        paramDownloadInfo.isIPUrl = false;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("replaceDomainWithIp false.url[");
          ((StringBuilder)localObject1).append(paramDownloadInfo.reqUrl);
          ((StringBuilder)localObject1).append("]");
          QLog.d("Q.emoji.EmoDown", 2, ((StringBuilder)localObject1).toString());
        }
      }
      return;
      label462:
      paramDownloadInfo.host = null;
      paramDownloadInfo.reqUrl = paramDownloadInfo.urlOriginal;
      paramDownloadInfo.isIPUrl = false;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("unknow domain url=");
        ((StringBuilder)localObject1).append(paramDownloadInfo.isIPUrl);
        QLog.d("Q.emoji.EmoDown", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.HttpDownloadUtils
 * JD-Core Version:    0.7.0.1
 */
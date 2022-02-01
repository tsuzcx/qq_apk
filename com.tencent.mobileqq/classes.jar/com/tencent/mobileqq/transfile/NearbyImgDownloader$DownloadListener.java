package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.utils.HttpDownloadUtil.DownloadInfoListener;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class NearbyImgDownloader$DownloadListener
  implements HttpDownloadUtil.DownloadInfoListener
{
  private DownloadParams mDownloadConfig;
  private DiskCache.Editor mEditor;
  private URLDrawableHandler mHandelr;
  
  public NearbyImgDownloader$DownloadListener(NearbyImgDownloader paramNearbyImgDownloader, DiskCache.Editor paramEditor, URLDrawableHandler paramURLDrawableHandler)
  {
    this.mEditor = paramEditor;
    this.mHandelr = paramURLDrawableHandler;
  }
  
  public NearbyImgDownloader$DownloadListener(NearbyImgDownloader paramNearbyImgDownloader, DiskCache.Editor paramEditor, URLDrawableHandler paramURLDrawableHandler, DownloadParams paramDownloadParams)
  {
    this(paramNearbyImgDownloader, paramEditor, paramURLDrawableHandler);
    this.mDownloadConfig = paramDownloadParams;
  }
  
  public boolean onRespDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo.resultCode == 0)
    {
      Object localObject1 = this.mDownloadConfig;
      Object localObject2 = null;
      if ((localObject1 != null) && ((((DownloadParams)localObject1).mExtraInfo instanceof PicInfo))) {
        localObject1 = (PicInfo)this.mDownloadConfig.mExtraInfo;
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && ("type_history_head_pic".equals(((PicInfo)localObject1).g)) && (((!TextUtils.isEmpty(paramDownloadInfo.respXErrNo)) && (!paramDownloadInfo.respXErrNo.trim().equals("0"))) || ((!TextUtils.isEmpty(paramDownloadInfo.respXFailNo)) && (!paramDownloadInfo.respXFailNo.trim().equals("0")))))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("historhead download fail, url : ");
          ((StringBuilder)localObject1).append(paramDownloadInfo.reqUrl);
          ((StringBuilder)localObject1).append(" respXFailNo: ");
          ((StringBuilder)localObject1).append(paramDownloadInfo.respXFailNo);
          ((StringBuilder)localObject1).append(" respXErrNo: ");
          ((StringBuilder)localObject1).append(paramDownloadInfo.respXErrNo);
          QLog.i("NearbyImgDownloader", 2, ((StringBuilder)localObject1).toString());
        }
        paramDownloadInfo.resultCode = 32;
        return false;
      }
      if (paramDownloadInfo.conn != null)
      {
        try
        {
          localObject1 = paramDownloadInfo.conn.getInputStream();
        }
        catch (IOException localIOException)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.w("NearbyImgDownloader", 2, localIOException.toString());
            localObject1 = localObject2;
          }
        }
        if (localObject1 != null) {
          return NearbyImgDownloader.access$000(this.this$0, (InputStream)localObject1, paramDownloadInfo.respContentLength, this.mEditor, this.mHandelr);
        }
        paramDownloadInfo.resultCode = 11;
        return false;
      }
      paramDownloadInfo.resultCode = 11;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyImgDownloader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
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
    Object localObject2 = null;
    if (paramDownloadInfo.resultCode == 0) {
      if ((this.mDownloadConfig == null) || (!(this.mDownloadConfig.mExtraInfo instanceof PicInfo))) {
        break label257;
      }
    }
    label257:
    for (Object localObject1 = (PicInfo)this.mDownloadConfig.mExtraInfo;; localObject1 = null)
    {
      if ((localObject1 != null) && ("type_history_head_pic".equals(((PicInfo)localObject1).g)) && (((!TextUtils.isEmpty(paramDownloadInfo.respXErrNo)) && (!paramDownloadInfo.respXErrNo.trim().equals("0"))) || ((!TextUtils.isEmpty(paramDownloadInfo.respXFailNo)) && (!paramDownloadInfo.respXFailNo.trim().equals("0")))))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "historhead download fail, url : " + paramDownloadInfo.reqUrl + " respXFailNo: " + paramDownloadInfo.respXFailNo + " respXErrNo: " + paramDownloadInfo.respXErrNo);
        }
        paramDownloadInfo.resultCode = 32;
        return false;
      }
      if (paramDownloadInfo.conn != null) {
        try
        {
          localObject1 = paramDownloadInfo.conn.getInputStream();
          if (localObject1 != null) {
            return NearbyImgDownloader.access$000(this.this$0, (InputStream)localObject1, paramDownloadInfo.respContentLength, this.mEditor, this.mHandelr);
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.w("NearbyImgDownloader", 2, localIOException.toString());
              localObject1 = localObject2;
            }
          }
          paramDownloadInfo.resultCode = 11;
          return false;
        }
      }
      paramDownloadInfo.resultCode = 11;
      return false;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyImgDownloader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */
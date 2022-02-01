package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import ardx;
import bfvl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class NearbyImgDownloader$DownloadListener
  implements bfvl
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
  
  public boolean onRespDownloadInfo(ardx paramardx)
  {
    Object localObject2 = null;
    if (paramardx.jdField_b_of_type_Int == 0) {
      if ((this.mDownloadConfig == null) || (!(this.mDownloadConfig.mExtraInfo instanceof PicInfo))) {
        break label257;
      }
    }
    label257:
    for (Object localObject1 = (PicInfo)this.mDownloadConfig.mExtraInfo;; localObject1 = null)
    {
      if ((localObject1 != null) && ("type_history_head_pic".equals(((PicInfo)localObject1).g)) && (((!TextUtils.isEmpty(paramardx.k)) && (!paramardx.k.trim().equals("0"))) || ((!TextUtils.isEmpty(paramardx.j)) && (!paramardx.j.trim().equals("0")))))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "historhead download fail, url : " + paramardx.jdField_b_of_type_JavaLangString + " respXFailNo: " + paramardx.j + " respXErrNo: " + paramardx.k);
        }
        paramardx.jdField_b_of_type_Int = 32;
        return false;
      }
      if (paramardx.a != null) {
        try
        {
          localObject1 = paramardx.a.getInputStream();
          if (localObject1 != null) {
            return NearbyImgDownloader.access$000(this.this$0, (InputStream)localObject1, paramardx.e, this.mEditor, this.mHandelr);
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
          paramardx.jdField_b_of_type_Int = 11;
          return false;
        }
      }
      paramardx.jdField_b_of_type_Int = 11;
      return false;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyImgDownloader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */
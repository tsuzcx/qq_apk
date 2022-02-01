package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import asid;
import bhed;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class NearbyImgDownloader$DownloadListener
  implements bhed
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
  
  public boolean onRespDownloadInfo(asid paramasid)
  {
    Object localObject2 = null;
    if (paramasid.jdField_b_of_type_Int == 0) {
      if ((this.mDownloadConfig == null) || (!(this.mDownloadConfig.mExtraInfo instanceof PicInfo))) {
        break label257;
      }
    }
    label257:
    for (Object localObject1 = (PicInfo)this.mDownloadConfig.mExtraInfo;; localObject1 = null)
    {
      if ((localObject1 != null) && ("type_history_head_pic".equals(((PicInfo)localObject1).g)) && (((!TextUtils.isEmpty(paramasid.k)) && (!paramasid.k.trim().equals("0"))) || ((!TextUtils.isEmpty(paramasid.j)) && (!paramasid.j.trim().equals("0")))))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "historhead download fail, url : " + paramasid.jdField_b_of_type_JavaLangString + " respXFailNo: " + paramasid.j + " respXErrNo: " + paramasid.k);
        }
        paramasid.jdField_b_of_type_Int = 32;
        return false;
      }
      if (paramasid.a != null) {
        try
        {
          localObject1 = paramasid.a.getInputStream();
          if (localObject1 != null) {
            return NearbyImgDownloader.access$000(this.this$0, (InputStream)localObject1, paramasid.e, this.mEditor, this.mHandelr);
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
          paramasid.jdField_b_of_type_Int = 11;
          return false;
        }
      }
      paramasid.jdField_b_of_type_Int = 11;
      return false;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyImgDownloader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */
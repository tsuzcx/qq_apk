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
  private DownloadParams jdField_a_of_type_ComTencentImageDownloadParams;
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  private DiskCache.Editor jdField_a_of_type_ComTencentMobileqqTransfileDiskCache$Editor;
  
  public NearbyImgDownloader$DownloadListener(NearbyImgDownloader paramNearbyImgDownloader, DiskCache.Editor paramEditor, URLDrawableHandler paramURLDrawableHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileDiskCache$Editor = paramEditor;
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
  }
  
  public NearbyImgDownloader$DownloadListener(NearbyImgDownloader paramNearbyImgDownloader, DiskCache.Editor paramEditor, URLDrawableHandler paramURLDrawableHandler, DownloadParams paramDownloadParams)
  {
    this(paramNearbyImgDownloader, paramEditor, paramURLDrawableHandler);
    this.jdField_a_of_type_ComTencentImageDownloadParams = paramDownloadParams;
  }
  
  public boolean a(DownloadInfo paramDownloadInfo)
  {
    Object localObject2 = null;
    if (paramDownloadInfo.jdField_b_of_type_Int == 0) {
      if ((this.jdField_a_of_type_ComTencentImageDownloadParams == null) || (!(this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo instanceof PicInfo))) {
        break label257;
      }
    }
    label257:
    for (Object localObject1 = (PicInfo)this.jdField_a_of_type_ComTencentImageDownloadParams.mExtraInfo;; localObject1 = null)
    {
      if ((localObject1 != null) && ("type_history_head_pic".equals(((PicInfo)localObject1).g)) && (((!TextUtils.isEmpty(paramDownloadInfo.k)) && (!paramDownloadInfo.k.trim().equals("0"))) || ((!TextUtils.isEmpty(paramDownloadInfo.j)) && (!paramDownloadInfo.j.trim().equals("0")))))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyImgDownloader", 2, "historhead download fail, url : " + paramDownloadInfo.jdField_b_of_type_JavaLangString + " respXFailNo: " + paramDownloadInfo.j + " respXErrNo: " + paramDownloadInfo.k);
        }
        paramDownloadInfo.jdField_b_of_type_Int = 32;
        return false;
      }
      if (paramDownloadInfo.a != null) {
        try
        {
          localObject1 = paramDownloadInfo.a.getInputStream();
          if (localObject1 != null) {
            return NearbyImgDownloader.a(this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyImgDownloader, (InputStream)localObject1, paramDownloadInfo.e, this.jdField_a_of_type_ComTencentMobileqqTransfileDiskCache$Editor, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
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
          paramDownloadInfo.jdField_b_of_type_Int = 11;
          return false;
        }
      }
      paramDownloadInfo.jdField_b_of_type_Int = 11;
      return false;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NearbyImgDownloader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */
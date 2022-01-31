package com.tencent.mobileqq.hotpic;

import asqx;
import asqy;
import asqz;
import bawo;
import baxa;
import baxu;
import baxv;
import bdcv;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HotVideoData
  extends HotPicData
  implements URLDrawable.DownloadListener
{
  public static final int PREVIEWIMAGE_TYPE = 1;
  public static final String TAG = "HotVideoData";
  public static final int UNKNOW_TYPE = 0;
  public static final int VIDEO_TYPE = 2;
  public String mCertificatedIcon;
  public String mPreviewUUID;
  public String mVideoUUID;
  WeakReference<URLDrawable.DownloadListener> mWeakPreviewDownloadListener = null;
  public long videoLength;
  public String videoSource;
  
  private void GetURLByTypeAsync(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, asqy paramasqy)
  {
    if (paramasqy == null) {
      return;
    }
    for (;;)
    {
      try
      {
        asqz localasqz = new asqz();
        localasqz.jdField_a_of_type_Int = paramInt2;
        if (paramInt2 == 1)
        {
          str1 = this.mPreviewUUID;
          if (paramInt2 != 1) {
            break label92;
          }
          str2 = this.md5;
          requestUrlByUuid(paramQQAppInterface, str1, str2, paramInt1, paramInt2, paramString, new asqx(this, localasqz, paramasqy));
          break;
        }
      }
      finally {}
      String str1 = this.mVideoUUID;
      continue;
      label92:
      String str2 = this.originalMD5;
    }
  }
  
  private static boolean isIpv6()
  {
    return true;
  }
  
  private void requestUrlByUuid(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, baxv parambaxv)
  {
    bawo localbawo = new bawo();
    baxa localbaxa = new baxa();
    localbaxa.jdField_c_of_type_Int = Calendar.getInstance().get(5);
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoData", 2, "sendGetUrlReq()----busiReq.seq : " + localbaxa.jdField_c_of_type_Int);
    }
    localbaxa.jdField_c_of_type_JavaLangString = paramString3;
    localbaxa.jdField_d_of_type_JavaLangString = paramQQAppInterface.c();
    localbaxa.jdField_e_of_type_JavaLangString = paramString3;
    localbaxa.f = paramInt1;
    localbaxa.jdField_d_of_type_Int = 0;
    if (localbaxa.f == 0)
    {
      localbaxa.jdField_a_of_type_Int = 0;
      if ((localbaxa.f != 0) && (1008 != localbaxa.f)) {
        break label281;
      }
    }
    label281:
    for (localbaxa.jdField_b_of_type_JavaLangString = null;; localbaxa.jdField_b_of_type_JavaLangString = localbaxa.jdField_d_of_type_JavaLangString)
    {
      localbaxa.jdField_b_of_type_Int = 2;
      localbaxa.jdField_a_of_type_JavaLangString = paramString1;
      localbaxa.jdField_a_of_type_ArrayOfByte = bdcv.a(paramString2);
      localbaxa.jdField_e_of_type_Int = 0;
      localbaxa.j = 0;
      localbaxa.g = paramInt2;
      localbaxa.h = 1;
      localbaxa.i = 1;
      localbawo.jdField_a_of_type_Baxv = parambaxv;
      localbawo.jdField_a_of_type_JavaLangString = "short_video_dw";
      localbawo.jdField_a_of_type_JavaUtilList.add(localbaxa);
      localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = paramQQAppInterface.getProtoReqManager();
      baxu.a(localbawo);
      return;
      if (1 == localbaxa.f)
      {
        localbaxa.jdField_a_of_type_Int = 1;
        break;
      }
      if (3000 == localbaxa.f)
      {
        localbaxa.jdField_a_of_type_Int = 2;
        break;
      }
      localbaxa.jdField_a_of_type_Int = 3;
      break;
    }
  }
  
  public boolean CheckIsNeedBlurBackground()
  {
    return this.width / this.height + 0.1F < 1.777778F;
  }
  
  public void GetPreviewURLAsync(QQAppInterface paramQQAppInterface, int paramInt, String paramString, asqy paramasqy)
  {
    GetURLByTypeAsync(paramQQAppInterface, paramInt, paramString, 1, paramasqy);
  }
  
  public void GetVideoURLAsync(QQAppInterface paramQQAppInterface, int paramInt, String paramString, asqy paramasqy)
  {
    GetURLByTypeAsync(paramQQAppInterface, paramInt, paramString, 2, paramasqy);
  }
  
  public void SetPreviewDownloadListener(URLDrawable.DownloadListener paramDownloadListener)
  {
    if ((paramDownloadListener == null) || (paramDownloadListener == this))
    {
      this.mWeakPreviewDownloadListener = null;
      return;
    }
    this.mWeakPreviewDownloadListener = new WeakReference(paramDownloadListener);
  }
  
  public URLDrawable.DownloadListener TryGetPreviewDownloadListener()
  {
    if (this.mWeakPreviewDownloadListener == null) {
      return null;
    }
    return (URLDrawable.DownloadListener)this.mWeakPreviewDownloadListener.get();
  }
  
  public int getDataType()
  {
    return 2;
  }
  
  public String getVideoLengthString()
  {
    return new SimpleDateFormat("mm:ss").format(new Date(this.videoLength));
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    URLDrawable.DownloadListener localDownloadListener = TryGetPreviewDownloadListener();
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadFailed(paramInt);
    }
  }
  
  public void onFileDownloadStarted()
  {
    URLDrawable.DownloadListener localDownloadListener = TryGetPreviewDownloadListener();
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadStarted();
    }
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    URLDrawable.DownloadListener localDownloadListener = TryGetPreviewDownloadListener();
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadSucceed(paramLong);
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("hotvideo:");
    localStringBuffer.append("version:").append(this.version).append(" ");
    localStringBuffer.append("md5:").append(this.md5).append(" ");
    localStringBuffer.append("fileSize:").append(this.fileSize).append(" ");
    localStringBuffer.append("width:").append(this.width).append(" ");
    localStringBuffer.append("height:").append(this.height).append(" ");
    localStringBuffer.append("mPreviewUUID:").append(this.mPreviewUUID).append(" ");
    localStringBuffer.append("picIndex:").append(this.picIndex).append(" ");
    localStringBuffer.append("iconUrl:").append(this.iconUrl).append(" ");
    localStringBuffer.append("jumpUrl:").append(this.jumpUrl).append(" ");
    localStringBuffer.append("name:").append(this.name).append(" ");
    localStringBuffer.append("videoSource:").append(this.videoSource).append(" ");
    localStringBuffer.append("videoLength:").append(this.videoLength).append(" ");
    localStringBuffer.append("originalWidth:").append(this.originalWidth).append(" ");
    localStringBuffer.append("originalHeight:").append(this.originalHeight).append(" ");
    localStringBuffer.append("mVideoUUID:").append(this.mVideoUUID).append(" ");
    localStringBuffer.append("originalMD5:").append(this.originalMD5).append(" ");
    localStringBuffer.append("mCertificatedIcon:").append(this.mCertificatedIcon).append(" ");
    localStringBuffer.append("oringinalSize:").append(this.oringinalSize).append(" ");
    localStringBuffer.append("tag:").append(this.tag).append(" ");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoData
 * JD-Core Version:    0.7.0.1
 */
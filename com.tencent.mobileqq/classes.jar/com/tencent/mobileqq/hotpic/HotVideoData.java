package com.tencent.mobileqq.hotpic;

import asvg;
import asvh;
import asvi;
import bbax;
import bbbj;
import bbcd;
import bbce;
import bdhe;
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
  
  private void GetURLByTypeAsync(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, asvh paramasvh)
  {
    if (paramasvh == null) {
      return;
    }
    for (;;)
    {
      try
      {
        asvi localasvi = new asvi();
        localasvi.jdField_a_of_type_Int = paramInt2;
        if (paramInt2 == 1)
        {
          str1 = this.mPreviewUUID;
          if (paramInt2 != 1) {
            break label92;
          }
          str2 = this.md5;
          requestUrlByUuid(paramQQAppInterface, str1, str2, paramInt1, paramInt2, paramString, new asvg(this, localasvi, paramasvh));
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
  
  private void requestUrlByUuid(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, bbce parambbce)
  {
    bbax localbbax = new bbax();
    bbbj localbbbj = new bbbj();
    localbbbj.jdField_c_of_type_Int = Calendar.getInstance().get(5);
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoData", 2, "sendGetUrlReq()----busiReq.seq : " + localbbbj.jdField_c_of_type_Int);
    }
    localbbbj.jdField_c_of_type_JavaLangString = paramString3;
    localbbbj.jdField_d_of_type_JavaLangString = paramQQAppInterface.c();
    localbbbj.jdField_e_of_type_JavaLangString = paramString3;
    localbbbj.f = paramInt1;
    localbbbj.jdField_d_of_type_Int = 0;
    if (localbbbj.f == 0)
    {
      localbbbj.jdField_a_of_type_Int = 0;
      if ((localbbbj.f != 0) && (1008 != localbbbj.f)) {
        break label281;
      }
    }
    label281:
    for (localbbbj.jdField_b_of_type_JavaLangString = null;; localbbbj.jdField_b_of_type_JavaLangString = localbbbj.jdField_d_of_type_JavaLangString)
    {
      localbbbj.jdField_b_of_type_Int = 2;
      localbbbj.jdField_a_of_type_JavaLangString = paramString1;
      localbbbj.jdField_a_of_type_ArrayOfByte = bdhe.a(paramString2);
      localbbbj.jdField_e_of_type_Int = 0;
      localbbbj.j = 0;
      localbbbj.g = paramInt2;
      localbbbj.h = 1;
      localbbbj.i = 1;
      localbbax.jdField_a_of_type_Bbce = parambbce;
      localbbax.jdField_a_of_type_JavaLangString = "short_video_dw";
      localbbax.jdField_a_of_type_JavaUtilList.add(localbbbj);
      localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = paramQQAppInterface.getProtoReqManager();
      bbcd.a(localbbax);
      return;
      if (1 == localbbbj.f)
      {
        localbbbj.jdField_a_of_type_Int = 1;
        break;
      }
      if (3000 == localbbbj.f)
      {
        localbbbj.jdField_a_of_type_Int = 2;
        break;
      }
      localbbbj.jdField_a_of_type_Int = 3;
      break;
    }
  }
  
  public boolean CheckIsNeedBlurBackground()
  {
    return this.width / this.height + 0.1F < 1.777778F;
  }
  
  public void GetPreviewURLAsync(QQAppInterface paramQQAppInterface, int paramInt, String paramString, asvh paramasvh)
  {
    GetURLByTypeAsync(paramQQAppInterface, paramInt, paramString, 1, paramasvh);
  }
  
  public void GetVideoURLAsync(QQAppInterface paramQQAppInterface, int paramInt, String paramString, asvh paramasvh)
  {
    GetURLByTypeAsync(paramQQAppInterface, paramInt, paramString, 2, paramasvh);
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
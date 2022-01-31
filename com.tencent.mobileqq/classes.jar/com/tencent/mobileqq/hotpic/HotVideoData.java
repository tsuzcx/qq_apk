package com.tencent.mobileqq.hotpic;

import adrg;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.mobileqq.utils.HexUtil;
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
  WeakReference mWeakPreviewDownloadListener = null;
  public long videoLength;
  public String videoSource;
  
  private void GetURLByTypeAsync(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, HotVideoData.HotVideoGetUrlCallBack paramHotVideoGetUrlCallBack)
  {
    if (paramHotVideoGetUrlCallBack == null) {
      return;
    }
    for (;;)
    {
      try
      {
        HotVideoData.HotVideoGetUrlResult localHotVideoGetUrlResult = new HotVideoData.HotVideoGetUrlResult();
        localHotVideoGetUrlResult.jdField_b_of_type_Int = paramInt2;
        if (paramInt2 == 1)
        {
          str1 = this.mPreviewUUID;
          if (paramInt2 != 1) {
            break label92;
          }
          str2 = this.md5;
          requestUrlByUuid(paramQQAppInterface, str1, str2, paramInt1, paramInt2, paramString, new adrg(this, localHotVideoGetUrlResult, paramHotVideoGetUrlCallBack));
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
  
  private void requestUrlByUuid(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, RichProtoProc.RichProtoCallback paramRichProtoCallback)
  {
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.ShortVideoDownReq localShortVideoDownReq = new RichProto.RichProtoReq.ShortVideoDownReq();
    localShortVideoDownReq.jdField_c_of_type_Int = Calendar.getInstance().get(5);
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoData", 2, "sendGetUrlReq()----busiReq.seq : " + localShortVideoDownReq.jdField_c_of_type_Int);
    }
    localShortVideoDownReq.jdField_c_of_type_JavaLangString = paramString3;
    localShortVideoDownReq.jdField_d_of_type_JavaLangString = paramQQAppInterface.c();
    localShortVideoDownReq.jdField_e_of_type_JavaLangString = paramString3;
    localShortVideoDownReq.f = paramInt1;
    localShortVideoDownReq.jdField_d_of_type_Int = 0;
    if (localShortVideoDownReq.f == 0)
    {
      localShortVideoDownReq.jdField_a_of_type_Int = 0;
      if ((localShortVideoDownReq.f != 0) && (1008 != localShortVideoDownReq.f)) {
        break label281;
      }
    }
    label281:
    for (localShortVideoDownReq.jdField_b_of_type_JavaLangString = null;; localShortVideoDownReq.jdField_b_of_type_JavaLangString = localShortVideoDownReq.jdField_d_of_type_JavaLangString)
    {
      localShortVideoDownReq.jdField_b_of_type_Int = 2;
      localShortVideoDownReq.jdField_a_of_type_JavaLangString = paramString1;
      localShortVideoDownReq.jdField_a_of_type_ArrayOfByte = HexUtil.a(paramString2);
      localShortVideoDownReq.jdField_e_of_type_Int = 0;
      localShortVideoDownReq.j = 0;
      localShortVideoDownReq.g = paramInt2;
      localShortVideoDownReq.h = 1;
      localShortVideoDownReq.i = 1;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = paramRichProtoCallback;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "short_video_dw";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localShortVideoDownReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = paramQQAppInterface.getProtoReqManager();
      RichProtoProc.a(localRichProtoReq);
      return;
      if (1 == localShortVideoDownReq.f)
      {
        localShortVideoDownReq.jdField_a_of_type_Int = 1;
        break;
      }
      if (3000 == localShortVideoDownReq.f)
      {
        localShortVideoDownReq.jdField_a_of_type_Int = 2;
        break;
      }
      localShortVideoDownReq.jdField_a_of_type_Int = 3;
      break;
    }
  }
  
  public boolean CheckIsNeedBlurBackground()
  {
    return this.width / this.height + 0.1F < 1.777778F;
  }
  
  public void GetPreviewURLAsync(QQAppInterface paramQQAppInterface, int paramInt, String paramString, HotVideoData.HotVideoGetUrlCallBack paramHotVideoGetUrlCallBack)
  {
    GetURLByTypeAsync(paramQQAppInterface, paramInt, paramString, 1, paramHotVideoGetUrlCallBack);
  }
  
  public void GetVideoURLAsync(QQAppInterface paramQQAppInterface, int paramInt, String paramString, HotVideoData.HotVideoGetUrlCallBack paramHotVideoGetUrlCallBack)
  {
    GetURLByTypeAsync(paramQQAppInterface, paramInt, paramString, 2, paramHotVideoGetUrlCallBack);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoData
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.lightReply;

import aebq;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.facedetect.FaceDetector.FACE_DETECT_MODE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.nio.ByteBuffer;

public class FacePicDectect
{
  private static byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_a_of_type_Int;
  private final VideoPreviewFaceOutlineDetector jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector = VideoPreviewFaceOutlineDetector.getInstance();
  private int b;
  
  private byte[] a(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      try
      {
        if (paramDrawable.getConstantState() != null)
        {
          paramDrawable = ImageUtil.a(ImageUtil.a(paramDrawable.getConstantState().newDrawable().mutate()), 320);
          this.jdField_a_of_type_Int = paramDrawable.getWidth();
          this.b = paramDrawable.getHeight();
          ByteBuffer localByteBuffer = ByteBuffer.allocate(paramDrawable.getByteCount());
          paramDrawable.copyPixelsToBuffer(localByteBuffer);
          paramDrawable = localByteBuffer.array();
          return paramDrawable;
        }
      }
      catch (OutOfMemoryError paramDrawable)
      {
        TroopTechReportUtils.a("light_reply_face", "oom", "", "", "", "");
        return null;
      }
      catch (Exception paramDrawable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FacePicDetect", 2, "drawableToGGBBytes" + paramDrawable.getMessage());
        }
        return null;
      }
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.destroy();
      jdField_a_of_type_ArrayOfByte = null;
      LightReplyMenuManager localLightReplyMenuManager = LightReplyMenuManager.a();
      if (localLightReplyMenuManager != null) {
        localLightReplyMenuManager.a = false;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FacePicDetect", 2, "destroy failed" + localException.getMessage());
        }
      }
    }
  }
  
  public void a(Drawable paramDrawable, FacePicDectect.FaceDetectFinishedListener paramFaceDetectFinishedListener)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      jdField_a_of_type_ArrayOfByte = a(paramDrawable);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("FacePicDetect", 2, "drawable convert time is" + (l2 - l1));
      }
      ThreadManager.post(new aebq(this, paramFaceDetectFinishedListener), 5, null, true);
      return;
    }
    catch (Exception paramDrawable)
    {
      for (;;)
      {
        QLog.e("FacePicDetect", 1, "face detect failed", paramDrawable);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool3 = PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false);
    boolean bool4 = PtvFilterSoLoad.a();
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (bool4) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(Context paramContext)
  {
    try
    {
      this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.setFaceDetectMode(FaceDetector.FACE_DETECT_MODE.SINGLE);
      VideoModule.init(paramContext);
      VideoPrefsUtil.setMaterialMute(true);
      com.tencent.ttpic.util.VideoMaterialUtil.SCALE_FACE_DETECT = 0.25D;
      if (a())
      {
        long l1 = System.currentTimeMillis();
        YTCommonInterface.initAuth(BaseApplicationImpl.getContext(), "youtusdk_mqq.licence", 0, true);
        paramContext = PtvFilterSoLoad.b(BaseApplicationImpl.getContext());
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("FacePicDetect", 2, "init auth time" + (l2 - l1));
        }
        l1 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(paramContext))
        {
          this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.setModelPath(paramContext);
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "mFaceDetector path:" + paramContext);
          }
        }
        for (;;)
        {
          try
          {
            this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.init();
            this.jdField_a_of_type_ComTencentTtpicUtilYoutuVideoPreviewFaceOutlineDetector.setRefine(true);
            bool = true;
            QLog.e("FacePicDetect", 1, "model path is null");
          }
          catch (OutOfMemoryError paramContext)
          {
            try
            {
              l2 = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d("FacePicDetect", 2, "deTectorInitTime: " + (l2 - l1));
              }
              return bool;
            }
            catch (Throwable paramContext)
            {
              boolean bool;
              break;
            }
            paramContext = paramContext;
            TroopTechReportUtils.a("light_reply_face", "oom", "", "", "", "");
            bool = false;
            continue;
          }
          catch (Throwable paramContext)
          {
            QLog.e("FacePicDetect", 1, "mVideoPreviewFaceOutlineDetector init failed", paramContext);
            bool = false;
            continue;
          }
          bool = false;
        }
      }
      QLog.e("FacePicDetect", 1, "youtu SO not load");
      return false;
    }
    catch (Throwable paramContext)
    {
      bool = false;
    }
    QLog.e("FacePicDetect", 1, "init failed", paramContext);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.lightReply.FacePicDectect
 * JD-Core Version:    0.7.0.1
 */
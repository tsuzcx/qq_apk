package dov.com.qq.im;

import awjg;
import bhem;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import cooperation.qzone.util.QZLog;
import java.io.File;

public class QIMQzoneEffectsCameraCaptureUnit$3
  implements Runnable
{
  public QIMQzoneEffectsCameraCaptureUnit$3(bhem parambhem, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void run()
  {
    boolean bool = true;
    try
    {
      File localFile = new File(bhem.a(this.this$0));
      int i = awjg.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, localFile.getAbsolutePath());
      QZLog.d(bhem.b(), 1, "Video2GifConverter: convert retCode=" + i);
      bhem localbhem = this.this$0;
      if (i == 0) {}
      for (;;)
      {
        bhem.a(localbhem, bool, localFile.getAbsolutePath());
        return;
        bool = false;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QZLog.e(bhem.b(), "processNotExistVideoData: convert exception", localThrowable);
      bhem.a(this.this$0, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMQzoneEffectsCameraCaptureUnit.3
 * JD-Core Version:    0.7.0.1
 */
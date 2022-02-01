package com.tencent.mobileqq.richmedia.mediacodec;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.ttpic.video.AEEncoder;

@TargetApi(17)
public class AEVEncoder
  implements HWEncodeListener, AEEncoder
{
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig;
  private HWVideoRecorder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  
  public AEVEncoder(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig = new EncodeConfig(paramString, paramInt1, paramInt2, 5242880, 1, false, 0);
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    Matrix.setRotateM(this.jdField_a_of_type_ArrayOfFloat, 0, 180.0F, 1.0F, 0.0F, 0.0F);
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable) {}
  
  public void onEncodeFinish(String arg1)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.d();
    this.jdField_a_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame() {}
  
  public void onEncodeStart() {}
  
  public void release()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.wait();
        label21:
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label21;
    }
  }
  
  public int writeFrame(int paramInt, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.a(EGL14.eglGetCurrentContext());
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig, this);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(3553, paramInt, null, this.jdField_a_of_type_ArrayOfFloat, 1000000L * paramLong);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.AEVEncoder
 * JD-Core Version:    0.7.0.1
 */
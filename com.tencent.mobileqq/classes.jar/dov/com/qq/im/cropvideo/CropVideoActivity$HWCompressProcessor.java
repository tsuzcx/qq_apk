package dov.com.qq.im.cropvideo;

import android.os.Build.VERSION;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import dov.com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConvertConfig;
import java.io.File;

public class CropVideoActivity$HWCompressProcessor
  implements VideoConverter.Processor
{
  int jdField_a_of_type_Int = 1024000;
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  public Throwable a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 25;
  final long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  int d;
  int e;
  int f;
  
  public CropVideoActivity$HWCompressProcessor(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
  }
  
  public VideoConverter.VideoConvertConfig a(int paramInt1, int paramInt2)
  {
    VideoConverter.VideoConvertConfig localVideoConvertConfig = new VideoConverter.VideoConvertConfig();
    if (paramInt1 <= paramInt2) {}
    for (;;)
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      localVideoConvertConfig.jdField_a_of_type_JavaIoFile = localFile;
      localVideoConvertConfig.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localVideoConvertConfig.jdField_a_of_type_Float = (960.0F / paramInt2);
      localVideoConvertConfig.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localVideoConvertConfig.jdField_b_of_type_Boolean = a();
      localVideoConvertConfig.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localVideoConvertConfig.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localVideoConvertConfig.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localVideoConvertConfig.d = this.jdField_c_of_type_Boolean;
      localVideoConvertConfig.f = this.jdField_c_of_type_Int;
      localVideoConvertConfig.g = this.d;
      localVideoConvertConfig.h = this.e;
      localVideoConvertConfig.i = this.f;
      SLog.a("CropVideoActivity", "HWCompressProcessor, step: getEncodeConfig() config.setRotation = " + localVideoConvertConfig.jdField_b_of_type_Boolean + ", scaleRate=" + localVideoConvertConfig.jdField_a_of_type_Float + ", videoBitRate=" + localVideoConvertConfig.jdField_a_of_type_Int + ", videoFrameRate=" + localVideoConvertConfig.jdField_b_of_type_Int + ", beginTime=" + localVideoConvertConfig.jdField_a_of_type_Long + ", endTime=" + localVideoConvertConfig.jdField_b_of_type_Long, ", isMute=" + this.jdField_b_of_type_Boolean, ", accurateSeek=" + this.jdField_c_of_type_Boolean + ", cropX=" + this.jdField_c_of_type_Int + ", cropY=" + this.d + ", cropWidth=" + this.e + ", cropHeight=" + this.f);
      return localVideoConvertConfig;
      paramInt2 = paramInt1;
    }
  }
  
  public void a()
  {
    SLog.e("CropVideoActivity", "HWCompressProcessor, step: HWCompressProcessor onSuccessed");
  }
  
  public void a(int paramInt)
  {
    SLog.b("CropVideoActivity", "HWCompressProcessor, step: HWCompressProcessor onProgress:" + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
  }
  
  public void a(Throwable paramThrowable)
  {
    SLog.e("CropVideoActivity", "HWCompressProcessor, step: HWCompressProcessor onFailed");
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    }
    while (Build.VERSION.SDK_INT <= 19) {
      return bool;
    }
    return false;
  }
  
  public void b()
  {
    SLog.c("CropVideoActivity", "HWCompressProcessor, step: HWCompressProcessor onCanceled");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.cropvideo.CropVideoActivity.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */
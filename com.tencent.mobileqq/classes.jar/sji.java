import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConvertConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class sji
  implements VideoConverter.Processor
{
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  Throwable jdField_a_of_type_JavaLangThrowable;
  final int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  
  sji(sjh paramsjh, String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    if (paramInt2 > 0) {}
    for (this.jdField_b_of_type_Int = paramInt2;; this.jdField_b_of_type_Int = 30)
    {
      this.jdField_a_of_type_JavaLangThrowable = null;
      if (paramString != null) {
        break;
      }
      throw new IllegalArgumentException("null == outputFilePath");
    }
  }
  
  private void a()
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
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
  
  public VideoConverter.VideoConvertConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    int i = 30;
    VideoConverter.VideoConvertConfig localVideoConvertConfig = new VideoConverter.VideoConvertConfig();
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    localVideoConvertConfig.output = localFile;
    long l = sjk.a(paramInt1, paramInt2);
    int j = sjk.a(paramInt1, paramInt2);
    localVideoConvertConfig.videoBitRate = ((int)l);
    paramInt2 = Math.min(paramInt1, paramInt2);
    localVideoConvertConfig.scaleRate = (j / paramInt2);
    paramInt1 = i;
    if (this.jdField_b_of_type_Int <= 30) {
      paramInt1 = this.jdField_b_of_type_Int;
    }
    localVideoConvertConfig.videoFrameRate = paramInt1;
    localVideoConvertConfig.setRotation = a();
    localVideoConvertConfig.beginTime = this.jdField_a_of_type_Long;
    localVideoConvertConfig.endTime = this.jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask, step: getEncodeConfig()\n  sourceShortEdge:" + paramInt2 + ", dstResolution:" + j + ", scaleRate:" + localVideoConvertConfig.scaleRate + "\n  targetVideoBitRate:" + localVideoConvertConfig.videoBitRate + ", videoFrameRate:" + localVideoConvertConfig.videoFrameRate + "\n setRotation:" + localVideoConvertConfig.setRotation + ", beginTime:" + localVideoConvertConfig.beginTime + ", endTime:" + localVideoConvertConfig.endTime);
    }
    return localVideoConvertConfig;
  }
  
  public void onCanceled()
  {
    QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onCanceled:");
    a();
    if (sjh.a(this.jdField_a_of_type_Sjh) != null) {
      sjh.a(this.jdField_a_of_type_Sjh).a(6, null, null);
    }
  }
  
  public void onFailed(Throwable paramThrowable)
  {
    QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onFailed:" + paramThrowable.getMessage());
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public void onProgress(int paramInt)
  {
    if ((sjh.a(this.jdField_a_of_type_Sjh) != null) && (!this.jdField_a_of_type_Sjh.isCancelled())) {
      sjh.a(this.jdField_a_of_type_Sjh).a(paramInt / 100.0F);
    }
  }
  
  public void onSuccessed() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sji
 * JD-Core Version:    0.7.0.1
 */
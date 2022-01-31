import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class rop
  implements azhm
{
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  Throwable jdField_a_of_type_JavaLangThrowable;
  final int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  
  rop(roo paramroo, String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
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
  
  private void c()
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  public azhn a(int paramInt1, int paramInt2)
  {
    int i = 30;
    azhn localazhn = new azhn();
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    localazhn.jdField_a_of_type_JavaIoFile = localFile;
    long l = ror.a(paramInt1, paramInt2);
    int j = ror.a(paramInt1, paramInt2);
    localazhn.jdField_a_of_type_Int = ((int)l);
    paramInt2 = Math.min(paramInt1, paramInt2);
    localazhn.jdField_a_of_type_Float = (j / paramInt2);
    paramInt1 = i;
    if (this.jdField_b_of_type_Int <= 30) {
      paramInt1 = this.jdField_b_of_type_Int;
    }
    localazhn.jdField_b_of_type_Int = paramInt1;
    localazhn.jdField_b_of_type_Boolean = a();
    localazhn.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localazhn.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask, step: getEncodeConfig()\n  sourceShortEdge:" + paramInt2 + ", dstResolution:" + j + ", scaleRate:" + localazhn.jdField_a_of_type_Float + "\n  targetVideoBitRate:" + localazhn.jdField_a_of_type_Int + ", videoFrameRate:" + localazhn.jdField_b_of_type_Int + "\n setRotation:" + localazhn.jdField_b_of_type_Boolean + ", beginTime:" + localazhn.jdField_a_of_type_Long + ", endTime:" + localazhn.jdField_b_of_type_Long);
    }
    return localazhn;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if ((roo.a(this.jdField_a_of_type_Roo) != null) && (!this.jdField_a_of_type_Roo.isCancelled())) {
      roo.a(this.jdField_a_of_type_Roo).a(paramInt / 100.0F);
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onFailed:" + paramThrowable.getMessage());
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
    QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onCanceled:");
    c();
    if (roo.a(this.jdField_a_of_type_Roo) != null) {
      roo.a(this.jdField_a_of_type_Roo).a(6, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rop
 * JD-Core Version:    0.7.0.1
 */
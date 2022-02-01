import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class sck
  implements bdfl
{
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  Throwable jdField_a_of_type_JavaLangThrowable;
  final int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  
  sck(scj paramscj, String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
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
  
  public bdfm a(int paramInt1, int paramInt2)
  {
    int i = 30;
    bdfm localbdfm = new bdfm();
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    localbdfm.jdField_a_of_type_JavaIoFile = localFile;
    long l = scm.a(paramInt1, paramInt2);
    int j = scm.a(paramInt1, paramInt2);
    localbdfm.jdField_a_of_type_Int = ((int)l);
    paramInt2 = Math.min(paramInt1, paramInt2);
    localbdfm.jdField_a_of_type_Float = (j / paramInt2);
    paramInt1 = i;
    if (this.jdField_b_of_type_Int <= 30) {
      paramInt1 = this.jdField_b_of_type_Int;
    }
    localbdfm.jdField_b_of_type_Int = paramInt1;
    localbdfm.jdField_b_of_type_Boolean = a();
    localbdfm.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localbdfm.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask, step: getEncodeConfig()\n  sourceShortEdge:" + paramInt2 + ", dstResolution:" + j + ", scaleRate:" + localbdfm.jdField_a_of_type_Float + "\n  targetVideoBitRate:" + localbdfm.jdField_a_of_type_Int + ", videoFrameRate:" + localbdfm.jdField_b_of_type_Int + "\n setRotation:" + localbdfm.jdField_b_of_type_Boolean + ", beginTime:" + localbdfm.jdField_a_of_type_Long + ", endTime:" + localbdfm.jdField_b_of_type_Long);
    }
    return localbdfm;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if ((scj.a(this.jdField_a_of_type_Scj) != null) && (!this.jdField_a_of_type_Scj.isCancelled())) {
      scj.a(this.jdField_a_of_type_Scj).a(paramInt / 100.0F);
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
    if (scj.a(this.jdField_a_of_type_Scj) != null) {
      scj.a(this.jdField_a_of_type_Scj).a(6, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sck
 * JD-Core Version:    0.7.0.1
 */
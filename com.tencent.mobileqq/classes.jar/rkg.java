import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class rkg
  implements bdfl
{
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  Throwable jdField_a_of_type_JavaLangThrowable;
  final int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  
  rkg(rkf paramrkf, String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    if (paramInt2 > 0) {}
    for (this.jdField_b_of_type_Int = paramInt2;; this.jdField_b_of_type_Int = 30)
    {
      this.jdField_a_of_type_JavaLangThrowable = null;
      if (paramString == null) {}
      return;
    }
  }
  
  public bdfm a(int paramInt1, int paramInt2)
  {
    int j = 1280;
    bdfm localbdfm = new bdfm();
    Object localObject;
    int i;
    if (paramInt1 <= paramInt2)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localbdfm.jdField_a_of_type_JavaIoFile = ((File)localObject);
      i = oyu.jdField_a_of_type_Int;
      paramInt1 = bnrf.u(BaseApplicationImpl.getApplication().getRuntime());
      if (paramInt1 > 0) {
        i = paramInt1;
      }
      if (paramInt2 < 1280) {
        break label307;
      }
      localObject = "720p";
      paramInt1 = j;
      label87:
      localbdfm.jdField_a_of_type_Int = ((int)(i * 1.0F / 640.0F * paramInt1));
      localbdfm.jdField_a_of_type_Float = (paramInt1 / paramInt2);
      if (this.jdField_b_of_type_Int > 30) {
        break label336;
      }
    }
    label307:
    label336:
    for (j = this.jdField_b_of_type_Int;; j = 30)
    {
      localbdfm.jdField_b_of_type_Int = j;
      localbdfm.jdField_b_of_type_Boolean = a();
      localbdfm.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localbdfm.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: getEncodeConfig()\n quality:" + (String)localObject + ", sourceLongEdge:" + paramInt2 + ", targetLongEdge:" + paramInt1 + ", scaleRate:" + localbdfm.jdField_a_of_type_Float + "\n defaultBitRate:" + i + ", videoBitRate:" + localbdfm.jdField_a_of_type_Int + ", videoFrameRate:" + localbdfm.jdField_b_of_type_Int + "\n setRotation:" + localbdfm.jdField_b_of_type_Boolean + ", beginTime:" + localbdfm.jdField_a_of_type_Long + ", endTime:" + localbdfm.jdField_b_of_type_Long);
      }
      return localbdfm;
      paramInt2 = paramInt1;
      break;
      if (paramInt2 >= 960)
      {
        localObject = "640p";
        paramInt1 = 960;
        break label87;
      }
      paramInt1 = 640;
      localObject = "480p";
      break label87;
    }
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Rkf.a != null) && (!this.jdField_a_of_type_Rkf.isCancelled())) {
      this.jdField_a_of_type_Rkf.a.a(paramInt / 100.0F);
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    QLog.e("ReadInJoyUploadVideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onFailed:" + paramThrowable.getMessage());
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
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkg
 * JD-Core Version:    0.7.0.1
 */
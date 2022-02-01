import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

final class rme
  extends nmf
{
  rme(rmf paramrmf, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Rmf != null)
    {
      this.jdField_a_of_type_Rmf.a(paramInt, "");
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.PublishVideoHelper", 2, "moveVideo: errorCode = " + paramInt + "callback =" + this.jdField_a_of_type_Rmf);
      }
    }
    for (;;)
    {
      pkp.a().e(this.jdField_a_of_type_Int);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.PublishVideoHelper", 2, "moveVideo: errorCode = " + paramInt + "callback is null.");
      }
    }
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Rmf != null) {
      this.jdField_a_of_type_Rmf.a(paramInt, paramString);
    }
    QLog.e("RIJUGC.PublishVideoHelper", 1, "moveVideo: columnId = " + this.jdField_a_of_type_Int + "errorCode = " + paramInt + ",errorMsg =" + paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rme
 * JD-Core Version:    0.7.0.1
 */
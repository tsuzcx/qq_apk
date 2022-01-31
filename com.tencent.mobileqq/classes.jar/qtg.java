import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

final class qtg
  extends nac
{
  qtg(qth paramqth, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool;
    if (this.jdField_a_of_type_Qth != null)
    {
      paramArrayOfByte = this.jdField_a_of_type_Qth;
      if (paramInt == 0)
      {
        bool = true;
        paramArrayOfByte.a(bool, Integer.toString(paramInt));
        if (QLog.isColorLevel()) {
          QLog.d("RIJUGC.PublishVideoHelper", 2, "moveVideo: errorCode = " + paramInt + "callback =" + this.jdField_a_of_type_Qth);
        }
      }
    }
    for (;;)
    {
      if (paramInt != 0) {
        break label130;
      }
      oxb.a().e();
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.PublishVideoHelper", 2, "moveVideo: errorCode = " + paramInt + "callback is null.");
      }
    }
    label130:
    QLog.i("RIJUGC.PublishVideoHelper", 1, "moveVideo: columnId = " + this.jdField_a_of_type_Int + "errorCode = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qtg
 * JD-Core Version:    0.7.0.1
 */
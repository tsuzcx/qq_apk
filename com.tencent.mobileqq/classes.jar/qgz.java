import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class qgz
  extends nac
{
  qgz(qgy paramqgy, qgs paramqgs) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i(qgy.a(), 1, "yyy_0xe1a error code = " + paramInt);
    if (paramInt == 0)
    {
      qgy.a(this.jdField_a_of_type_Qgy, paramArrayOfByte, this.jdField_a_of_type_Qgs);
      return;
    }
    this.jdField_a_of_type_Qgs.a(-1, false, "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qgz
 * JD-Core Version:    0.7.0.1
 */
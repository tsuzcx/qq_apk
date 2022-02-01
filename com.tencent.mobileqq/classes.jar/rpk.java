import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class rpk
  extends niv
{
  rpk(rpj paramrpj, pzk parampzk) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    rpj.a(this.jdField_a_of_type_Rpj, false);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork failed.");
      }
      this.jdField_a_of_type_Pzk.a(false, true, 0, new ArrayList(), null, paramInt, "");
      return;
    }
    rpj.a(this.jdField_a_of_type_Rpj, this.jdField_a_of_type_Pzk, paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpk
 * JD-Core Version:    0.7.0.1
 */
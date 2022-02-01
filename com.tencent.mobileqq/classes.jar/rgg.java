import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class rgg
  extends nkq
{
  rgg(rgf paramrgf, prv paramprv) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    rgf.a(this.jdField_a_of_type_Rgf, false);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork failed.");
      }
      this.jdField_a_of_type_Prv.a(false, true, 0, new ArrayList(), null, paramInt, "");
      return;
    }
    rgf.a(this.jdField_a_of_type_Rgf, this.jdField_a_of_type_Prv, paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgg
 * JD-Core Version:    0.7.0.1
 */
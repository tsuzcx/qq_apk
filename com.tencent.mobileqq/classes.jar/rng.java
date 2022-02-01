import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class rng
  extends nmf
{
  rng(rnf paramrnf, pxo parampxo) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    rnf.a(this.jdField_a_of_type_Rnf, false);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork failed.");
      }
      this.jdField_a_of_type_Pxo.a(false, true, 0, new ArrayList(), null, paramInt, "");
      return;
    }
    rnf.a(this.jdField_a_of_type_Rnf, this.jdField_a_of_type_Pxo, paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rng
 * JD-Core Version:    0.7.0.1
 */
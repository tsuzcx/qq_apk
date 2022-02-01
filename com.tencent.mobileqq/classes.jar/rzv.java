import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class rzv
  extends ntf
{
  rzv(rzu paramrzu, qjs paramqjs) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    rzu.a(this.jdField_a_of_type_Rzu, false);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork failed.");
      }
      this.jdField_a_of_type_Qjs.a(false, true, 0, new ArrayList(), null, paramInt, "");
      return;
    }
    rzu.a(this.jdField_a_of_type_Rzu, this.jdField_a_of_type_Qjs, paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzv
 * JD-Core Version:    0.7.0.1
 */
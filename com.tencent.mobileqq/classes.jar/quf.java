import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class quf
  extends nac
{
  quf(que paramque, phy paramphy) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    que.a(this.jdField_a_of_type_Que, false);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork failed.");
      }
      this.jdField_a_of_type_Phy.a(false, true, 0, new ArrayList(), null, paramInt, "");
      return;
    }
    que.a(this.jdField_a_of_type_Que, this.jdField_a_of_type_Phy, paramArrayOfByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     quf
 * JD-Core Version:    0.7.0.1
 */
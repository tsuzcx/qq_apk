import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class rah
  extends niv
{
  rah(rag paramrag, raa paramraa) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i(rag.a(), 1, "yyy_0xe1a error code = " + paramInt);
    if (paramInt == 0)
    {
      rag.a(this.jdField_a_of_type_Rag, paramArrayOfByte, this.jdField_a_of_type_Raa);
      return;
    }
    this.jdField_a_of_type_Raa.a(-1, false, "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rah
 * JD-Core Version:    0.7.0.1
 */
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xc90.RspBody;

class pef
  extends mzz
{
  pef(ped paramped, sec paramsec) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      paramBundle = new oidb_0xc90.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      if (this.jdField_a_of_type_Sec != null) {
        this.jdField_a_of_type_Sec.a(true, paramInt, paramBundle);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(ped.a, 2, "requestNewCommunityMsg onResult(), exception = " + QLog.getStackTraceString(paramArrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pef
 * JD-Core Version:    0.7.0.1
 */
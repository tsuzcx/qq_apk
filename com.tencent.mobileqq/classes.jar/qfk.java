import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.protofile.cmd0xe36.cmd0xe36.RspBody;
import com.tencent.qphone.base.util.QLog;

public class qfk
  extends nac
{
  public qfk(RIJRedPacketManager paramRIJRedPacketManager, qfu paramqfu) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe36 error code: " + paramInt);
    if (paramInt == 0) {
      paramBundle = new cmd0xe36.RspBody();
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramInt = 0;
      paramArrayOfByte = "";
      if (paramBundle.code.has()) {
        paramInt = paramBundle.code.get();
      }
      if (paramBundle.wording.has()) {
        paramArrayOfByte = paramBundle.wording.get();
      }
      QLog.i("RIJRedPacketManager", 1, "yyy_0xe36 code: " + paramInt + "\nwording: " + paramArrayOfByte);
      if ((paramInt != 0) && (!TextUtils.isEmpty(paramArrayOfByte))) {
        this.jdField_a_of_type_Qfu.a(paramArrayOfByte);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.i("RIJRedPacketManager", 1, "yyy_0xe36 error: " + paramArrayOfByte.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qfk
 * JD-Core Version:    0.7.0.1
 */
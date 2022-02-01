import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.protofile.oidb_0xe1f.oidb_0xe1f.RspBody;
import com.tencent.qphone.base.util.QLog;

public class qyr
  extends niv
{
  public qyr(RIJRedPacketManager paramRIJRedPacketManager, qyx paramqyx) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("RIJRedPacketManager", 1, "yyy_0xe1f error code: " + paramInt);
    if (paramInt == 0) {
      paramBundle = new oidb_0xe1f.RspBody();
    }
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = "";
        if (!paramBundle.have_redpacket.has()) {
          break label182;
        }
        bool = paramBundle.have_redpacket.get();
        if (paramBundle.id.has()) {
          paramArrayOfByte = paramBundle.id.get();
        }
        this.jdField_a_of_type_Qyx.a(bool, paramArrayOfByte);
        QLog.i("RIJRedPacketManager", 1, "yyy_0xe1f rsp: hasRedPacket: " + bool + " \n packetId:  I can not tell you.\n");
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        this.jdField_a_of_type_Qyx.a(false, "");
        QLog.i("RIJRedPacketManager", 1, "yyy_0xe1f error: " + paramArrayOfByte.toString());
        return;
      }
      this.jdField_a_of_type_Qyx.a(false, "");
      return;
      label182:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyr
 * JD-Core Version:    0.7.0.1
 */
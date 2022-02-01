import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.IMMRRsp;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.RspBody;

public class hp
  extends nkq
{
  private hn a;
  
  public hp(boolean paramBoolean, hn paramhn)
  {
    super(paramBoolean);
    this.a = paramhn;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new oidb_0xa4d.RspBody();
    if (paramInt == 0) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("ImmersionHandler", 2, "HapticMediaPlayer request success.errorcode = " + paramInt);
        }
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (oidb_0xa4d.IMMRRsp)paramBundle.msg_immr_rsp.get();
        this.a.setConnection(new hl(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("ImmersionHandler", 2, "HapticMediaPlayer request failerrorcode = " + paramInt);
    }
    this.a.setConnection(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     hp
 * JD-Core Version:    0.7.0.1
 */
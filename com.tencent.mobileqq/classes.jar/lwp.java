import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinHandler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RspBody;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class lwp
  extends ProtoUtils.TroopProtocolObserver
{
  public lwp(ReadInJoySkinHandler paramReadInJoySkinHandler) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool = true;
    paramBundle = new oidb_0x5bd.RspBody();
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoySkinHandler", 2, "errorCode = " + paramInt + ", rspBody.msg_next_guide_info.has = " + paramBundle.msg_next_guide_info.has());
      }
      paramArrayOfByte = this.a;
      if (paramInt == 0) {}
      for (;;)
      {
        paramArrayOfByte.a(1, bool, new Object[] { paramBundle.msg_current_skin_info.get(), paramBundle.msg_next_guide_info.get(), paramBundle.msg_operation_guide_info.get(), paramBundle.msg_operation_refresh_info.get() });
        return;
        bool = false;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lwp
 * JD-Core Version:    0.7.0.1
 */
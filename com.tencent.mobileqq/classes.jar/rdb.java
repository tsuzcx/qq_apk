import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RspBody;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

class rdb
  extends niv
{
  rdb(rda paramrda) {}
  
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
      int i = paramBundle.uint32_source.get();
      paramArrayOfByte = this.a;
      if (paramInt == 0) {}
      for (;;)
      {
        paramArrayOfByte.notifyUI(1, bool, new Object[] { paramBundle.msg_now_skin_info.get(), paramBundle.msg_next_guide_info.get(), paramBundle.msg_operation_guide_info.get(), paramBundle.msg_operation_refresh_info.get(), Integer.valueOf(i) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdb
 * JD-Core Version:    0.7.0.1
 */
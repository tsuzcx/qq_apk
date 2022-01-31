import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xe1a.cmd0xe1a.ReqBody;
import tencent.im.oidb.cmd0xe1a.cmd0xe1a.RspBody;

public class qgy
  implements qgr
{
  private static String a = "RIJRedPacketModel";
  
  private void a(byte[] paramArrayOfByte, @NotNull qgs paramqgs)
  {
    try
    {
      cmd0xe1a.RspBody localRspBody = new cmd0xe1a.RspBody();
      localRspBody.mergeFrom(paramArrayOfByte);
      boolean bool1 = localRspBody.have_red_packet.get();
      boolean bool2 = localRspBody.opened_red_packet.get();
      paramArrayOfByte = localRspBody.wording.get();
      paramqgs.a(0, bool2, paramArrayOfByte, localRspBody.wording2.get(), bool1);
      QLog.i(a, 1, "yyy_0xe1a haveRedPacket = " + bool1 + " haveOpen " + bool2 + " wording1 " + paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, QLog.getStackTraceString(paramArrayOfByte));
      }
      paramqgs.a(-1, false, "", "", false);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, @NotNull qgt paramqgt)
  {
    RIJRedPacketManager.a().a(paramInt, paramString1, paramString2, new qha(this, paramqgt));
  }
  
  public void a(@NotNull qgs paramqgs)
  {
    cmd0xe1a.ReqBody localReqBody = new cmd0xe1a.ReqBody();
    localReqBody.nothing.set("nothing");
    localReqBody.nothing.setHasFlag(true);
    mzy.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), new qgz(this, paramqgs), localReqBody.toByteArray(), "OidbSvc.0xe1a", 3610, 1, new Bundle(), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qgy
 * JD-Core Version:    0.7.0.1
 */
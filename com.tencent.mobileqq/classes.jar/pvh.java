import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.CoinPresentReq;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;

public class pvh
  implements pvm
{
  public int a()
  {
    return 2;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xed4.RspBody paramRspBody, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qlr paramqlr, oidb_cmd0xed4.ReqBody paramReqBody)
  {
    if ((paramqlr == null) || (paramReqBody == null)) {
      return;
    }
    paramReqBody.meta.type.set(2);
    paramReqBody.present_req.setHasFlag(true);
    paramReqBody.present_req.uin.set(pay.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvh
 * JD-Core Version:    0.7.0.1
 */
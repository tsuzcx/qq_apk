import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.CoinPresentReq;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;

public class qgf
  implements qgk
{
  public int a()
  {
    return 2;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xed4.RspBody paramRspBody, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qxw paramqxw, oidb_cmd0xed4.ReqBody paramReqBody)
  {
    if ((paramqxw == null) || (paramReqBody == null)) {
      return;
    }
    paramReqBody.meta.type.set(2);
    paramReqBody.present_req.setHasFlag(true);
    paramReqBody.present_req.uin.set(pkh.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgf
 * JD-Core Version:    0.7.0.1
 */
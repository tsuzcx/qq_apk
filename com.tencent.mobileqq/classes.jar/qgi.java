import com.tencent.biz.pubaccount.readinjoy.model.RIJCoinInfoModule.ContentCoinCheckRequestHandler.1;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ContentCoinCheckReq;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;

public class qgi
  implements qgk
{
  public int a()
  {
    return 4;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xed4.RspBody paramRspBody, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      bjum.c(new RIJCoinInfoModule.ContentCoinCheckRequestHandler.1(this, bool, paramInt2, paramString, (String)paramToServiceMsg.getAttributes().get("RequestRowkey"), paramRspBody.content_has_coin.get()));
      return;
    }
  }
  
  public void a(qxw paramqxw, oidb_cmd0xed4.ReqBody paramReqBody)
  {
    if ((paramqxw == null) || (paramReqBody == null)) {
      return;
    }
    paramReqBody.meta.type.set(4);
    paramReqBody.content_coin_check_req.setHasFlag(true);
    paramReqBody.content_coin_check_req.uin.set(pkh.a());
    paramReqBody.content_coin_check_req.rowkey.set(paramqxw.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgi
 * JD-Core Version:    0.7.0.1
 */
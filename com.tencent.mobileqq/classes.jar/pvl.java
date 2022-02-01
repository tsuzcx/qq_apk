import com.tencent.biz.pubaccount.readinjoy.model.RIJCoinInfoModule.ContentCoinNumQueryRequestHandler.1;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ContentCoinNumQueryReq;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;

public class pvl
  implements pvm
{
  public int a()
  {
    return 5;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xed4.RspBody paramRspBody, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      bijk.c(new RIJCoinInfoModule.ContentCoinNumQueryRequestHandler.1(this, bool, paramInt2, paramString, (String)paramToServiceMsg.getAttributes().get("RequestRowkey"), paramRspBody.content_coin_num.get()));
      return;
    }
  }
  
  public void a(qlr paramqlr, oidb_cmd0xed4.ReqBody paramReqBody)
  {
    if ((paramqlr == null) || (paramReqBody == null)) {
      return;
    }
    paramReqBody.meta.type.set(5);
    paramReqBody.content_coin_num_query_req.setHasFlag(true);
    paramReqBody.content_coin_num_query_req.rowkey.set(paramqlr.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvl
 * JD-Core Version:    0.7.0.1
 */
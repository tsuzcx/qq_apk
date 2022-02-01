import com.tencent.biz.pubaccount.readinjoy.model.RIJCoinInfoModule.CoinRewardRequestHandler.1;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.CoinRewardReq;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.MetaData;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody;
import tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.RspBody;

public class qgh
  implements qgk
{
  public int a()
  {
    return 3;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xed4.RspBody paramRspBody, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      bjum.c(new RIJCoinInfoModule.CoinRewardRequestHandler.1(this, bool, paramInt2, paramString));
      return;
    }
  }
  
  public void a(qxw paramqxw, oidb_cmd0xed4.ReqBody paramReqBody)
  {
    if ((paramqxw == null) || (paramReqBody == null)) {
      return;
    }
    paramReqBody.meta.type.set(3);
    paramReqBody.reward_req.setHasFlag(true);
    paramReqBody.reward_req.rowkey.set(paramqxw.jdField_a_of_type_JavaLangString);
    paramReqBody.reward_req.from_uin.set(pkh.a());
    paramReqBody.reward_req.to_uin.set(paramqxw.jdField_a_of_type_Qxx.jdField_a_of_type_Long);
    paramReqBody.reward_req.coin_cnt.set(paramqxw.jdField_a_of_type_Qxx.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgh
 * JD-Core Version:    0.7.0.1
 */
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

public class pvj
  implements pvm
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
      bijk.c(new RIJCoinInfoModule.CoinRewardRequestHandler.1(this, bool, paramInt2, paramString));
      return;
    }
  }
  
  public void a(qlr paramqlr, oidb_cmd0xed4.ReqBody paramReqBody)
  {
    if ((paramqlr == null) || (paramReqBody == null)) {
      return;
    }
    paramReqBody.meta.type.set(3);
    paramReqBody.reward_req.setHasFlag(true);
    paramReqBody.reward_req.rowkey.set(paramqlr.jdField_a_of_type_JavaLangString);
    paramReqBody.reward_req.from_uin.set(pay.a());
    paramReqBody.reward_req.to_uin.set(paramqlr.jdField_a_of_type_Qls.jdField_a_of_type_Long);
    paramReqBody.reward_req.coin_cnt.set(paramqlr.jdField_a_of_type_Qls.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvj
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0xed4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xed4$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "meta", "query_req", "present_req", "reward_req", "content_coin_check_req", "content_coin_num_query_req", "security_info" }, new Object[] { null, null, null, null, null, null, null }, ReqBody.class);
  public oidb_cmd0xed4.ContentCoinCheckReq content_coin_check_req = new oidb_cmd0xed4.ContentCoinCheckReq();
  public oidb_cmd0xed4.ContentCoinNumQueryReq content_coin_num_query_req = new oidb_cmd0xed4.ContentCoinNumQueryReq();
  public oidb_cmd0xed4.MetaData meta = new oidb_cmd0xed4.MetaData();
  public oidb_cmd0xed4.CoinPresentReq present_req = new oidb_cmd0xed4.CoinPresentReq();
  public oidb_cmd0xed4.CoinQueryReq query_req = new oidb_cmd0xed4.CoinQueryReq();
  public oidb_cmd0xed4.CoinRewardReq reward_req = new oidb_cmd0xed4.CoinRewardReq();
  public oidb_cmd0xed4.SecurityInfo security_info = new oidb_cmd0xed4.SecurityInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.ReqBody
 * JD-Core Version:    0.7.0.1
 */
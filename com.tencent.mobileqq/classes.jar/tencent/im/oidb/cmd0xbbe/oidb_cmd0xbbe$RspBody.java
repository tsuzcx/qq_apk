package tencent.im.oidb.cmd0xbbe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbbe$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_article_id", "msg_get_recommend_account_rsp" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
  public oidb_cmd0xbbe.GetRecommendAccountRsp msg_get_recommend_account_rsp = new oidb_cmd0xbbe.GetRecommendAccountRsp();
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbe.oidb_cmd0xbbe.RspBody
 * JD-Core Version:    0.7.0.1
 */
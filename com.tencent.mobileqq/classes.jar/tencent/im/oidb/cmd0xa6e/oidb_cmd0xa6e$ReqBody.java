package tencent.im.oidb.cmd0xa6e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xa6e$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 80, 88, 96 }, new String[] { "rpt_topiclist", "uint32_req_pv", "uint32_req_followed_count", "uint32_req_ugc_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatField<Long> rpt_topiclist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_req_followed_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pv = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_ugc_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa6e.oidb_cmd0xa6e.ReqBody
 * JD-Core Version:    0.7.0.1
 */
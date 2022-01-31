package tencent.im.oidb.cmd0x908;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x908$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_uin", "uint32_parent_channel_id", "rpt_child_channel_list", "uint32_req_channel_subscription_count", "uint32_req_channel_header_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatField rpt_child_channel_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_parent_channel_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_channel_header_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_channel_subscription_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x908.oidb_cmd0x908.ReqBody
 * JD-Core Version:    0.7.0.1
 */
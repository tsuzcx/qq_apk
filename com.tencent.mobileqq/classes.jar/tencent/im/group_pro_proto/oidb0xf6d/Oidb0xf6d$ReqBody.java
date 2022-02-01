package tencent.im.group_pro_proto.oidb0xf6d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb0xf6d$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_member_id", "rpt_msg_my_channel_list", "uint32_type" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatMessageField<Oidb0xf6d.MyChannelInfo> rpt_msg_my_channel_list = PBField.initRepeatMessage(Oidb0xf6d.MyChannelInfo.class);
  public final PBEnumField uint32_type = PBField.initEnum(0);
  public final PBUInt64Field uint64_member_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.oidb0xf6d.Oidb0xf6d.ReqBody
 * JD-Core Version:    0.7.0.1
 */
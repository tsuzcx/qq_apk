package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class servtype$VoiceChannelInfoFilter
  extends MessageMicro<VoiceChannelInfoFilter>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_member_max_num" }, new Object[] { Integer.valueOf(0) }, VoiceChannelInfoFilter.class);
  public final PBUInt32Field uint32_member_max_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.VoiceChannelInfoFilter
 * JD-Core Version:    0.7.0.1
 */
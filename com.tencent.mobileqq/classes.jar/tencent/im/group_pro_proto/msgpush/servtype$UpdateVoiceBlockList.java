package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class servtype$UpdateVoiceBlockList
  extends MessageMicro<UpdateVoiceBlockList>
{
  public static final int ADD = 1;
  public static final int DEL = 2;
  public static final int INVALID = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_action", "uint64_object_tinyid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, UpdateVoiceBlockList.class);
  public final PBUInt32Field uint32_action = PBField.initUInt32(0);
  public final PBUInt64Field uint64_object_tinyid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.UpdateVoiceBlockList
 * JD-Core Version:    0.7.0.1
 */
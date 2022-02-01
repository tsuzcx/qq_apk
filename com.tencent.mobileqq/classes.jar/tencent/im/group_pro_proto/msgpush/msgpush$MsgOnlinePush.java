package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.group_pro_proto.common.common.Msg;

public final class msgpush$MsgOnlinePush
  extends MessageMicro<MsgOnlinePush>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field compress_flag = PBField.initUInt32(0);
  public final PBBytesField compress_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public msgpush.FocusInfo focus_info = new msgpush.FocusInfo();
  public final PBUInt32Field general_flag = PBField.initUInt32(0);
  public final PBUInt32Field huge_flag = PBField.initUInt32(0);
  public final PBRepeatMessageField<common.Msg> msgs = PBField.initRepeatMessage(common.Msg.class);
  public final PBUInt32Field need_resp = PBField.initUInt32(0);
  public final PBBytesField server_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 50, 58, 64 }, new String[] { "msgs", "general_flag", "need_resp", "server_buf", "compress_flag", "compress_msg", "focus_info", "huge_flag" }, new Object[] { null, localInteger, localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, null, localInteger }, MsgOnlinePush.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.msgpush.MsgOnlinePush
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.group_pro_proto.msg_box;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MsgBox$GetRsp
  extends MessageMicro<GetRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<MsgBox.ChannelEvent> channel_events = PBField.initRepeatMessage(MsgBox.ChannelEvent.class);
  public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field err_code = PBField.initUInt64(0L);
  public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "err_code", "err_msg", "channel_events", "cookie" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, null, localByteStringMicro2 }, GetRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msg_box.MsgBox.GetRsp
 * JD-Core Version:    0.7.0.1
 */
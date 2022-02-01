package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class obj_msg$ObjMsg
  extends MessageMicro<ObjMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<obj_msg.MsgContentInfo> msg_content_info = PBField.initRepeatMessage(obj_msg.MsgContentInfo.class);
  public final PBRepeatField<ByteStringMicro> rpt_bytes_abstact = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField<obj_msg.MsgPic> rpt_msg_pic = PBField.initRepeatMessage(obj_msg.MsgPic.class);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_report_id_show = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 42, 50, 58, 64 }, new String[] { "uint32_msg_type", "bytes_title", "rpt_bytes_abstact", "bytes_title_ext", "rpt_msg_pic", "msg_content_info", "uint32_report_id_show" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, null, localInteger }, ObjMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.obj_msg.ObjMsg
 * JD-Core Version:    0.7.0.1
 */
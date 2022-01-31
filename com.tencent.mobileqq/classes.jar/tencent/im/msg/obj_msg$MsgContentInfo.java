package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class obj_msg$MsgContentInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_Content_info_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public obj_msg.MsgContentInfo.MsgFile msg_file = new obj_msg.MsgContentInfo.MsgFile();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_Content_info_id", "msg_file" }, new Object[] { localByteStringMicro, null }, MsgContentInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.obj_msg.MsgContentInfo
 * JD-Core Version:    0.7.0.1
 */
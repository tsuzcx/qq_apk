package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class QQCircleMsgPaelem$RichLongMsg
  extends MessageMicro<RichLongMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_long_msg_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_long_msg_wording" }, new Object[] { localByteStringMicro }, RichLongMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleMsgPaelem.RichLongMsg
 * JD-Core Version:    0.7.0.1
 */
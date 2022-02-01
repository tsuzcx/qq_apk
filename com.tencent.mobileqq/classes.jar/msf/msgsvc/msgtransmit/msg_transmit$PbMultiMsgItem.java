package msf.msgsvc.msgtransmit;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class msg_transmit$PbMultiMsgItem
  extends MessageMicro<PbMultiMsgItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField fileName = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "fileName", "buffer" }, new Object[] { "", localByteStringMicro }, PbMultiMsgItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     msf.msgsvc.msgtransmit.msg_transmit.PbMultiMsgItem
 * JD-Core Version:    0.7.0.1
 */
package localpb.richMsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class RichMsg$FoldMsg
  extends MessageMicro<FoldMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field fold_flags = PBField.initUInt32(0);
  public final PBBytesField msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField redbag_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField redbag_index = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field redbag_sender_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "fold_flags", "redbag_sender_uin", "redbag_id", "msg_content", "redbag_index" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, FoldMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     localpb.richMsg.RichMsg.FoldMsg
 * JD-Core Version:    0.7.0.1
 */
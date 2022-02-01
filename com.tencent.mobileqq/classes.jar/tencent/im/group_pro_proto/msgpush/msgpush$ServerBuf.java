package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msgpush$ServerBuf
  extends MessageMicro<ServerBuf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField echo_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field svr_ip = PBField.initUInt32(0);
  public final PBUInt32Field svr_port = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "svr_ip", "svr_port", "echo_key" }, new Object[] { localInteger, localInteger, localByteStringMicro }, ServerBuf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.msgpush.ServerBuf
 * JD-Core Version:    0.7.0.1
 */
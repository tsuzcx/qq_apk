package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class common$ContentHead
  extends MessageMicro<ContentHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field cnt_seq = PBField.initUInt64(0L);
  public final PBBytesField msg_meta = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  public final PBUInt64Field msg_time = PBField.initUInt64(0L);
  public final PBUInt64Field msg_type = PBField.initUInt64(0L);
  public final PBUInt64Field random = PBField.initUInt64(0L);
  public final PBUInt64Field sub_type = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "msg_type", "sub_type", "random", "msg_seq", "cnt_seq", "msg_time", "msg_meta" }, new Object[] { localLong, localLong, localLong, localLong, localLong, localLong, localByteStringMicro }, ContentHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.common.common.ContentHead
 * JD-Core Version:    0.7.0.1
 */
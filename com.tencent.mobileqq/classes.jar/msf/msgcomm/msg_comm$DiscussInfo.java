package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_comm$DiscussInfo
  extends MessageMicro<DiscussInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field discuss_info_seq = PBField.initUInt64(0L);
  public final PBBytesField discuss_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField discuss_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field discuss_type = PBField.initUInt32(0);
  public final PBUInt64Field discuss_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "discuss_uin", "discuss_type", "discuss_info_seq", "discuss_remark", "discuss_name" }, new Object[] { localLong, Integer.valueOf(0), localLong, localByteStringMicro1, localByteStringMicro2 }, DiscussInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msf.msgcomm.msg_comm.DiscussInfo
 * JD-Core Version:    0.7.0.1
 */
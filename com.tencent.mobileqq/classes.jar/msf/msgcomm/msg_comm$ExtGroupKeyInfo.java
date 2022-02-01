package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_comm$ExtGroupKeyInfo
  extends MessageMicro<ExtGroupKeyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext_group_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field cur_max_seq = PBField.initUInt32(0);
  public final PBUInt64Field cur_time = PBField.initUInt64(0L);
  public final PBUInt32Field operate_by_parents = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "cur_max_seq", "cur_time", "operate_by_parents", "bytes_ext_group_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, ExtGroupKeyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msf.msgcomm.msg_comm.ExtGroupKeyInfo
 * JD-Core Version:    0.7.0.1
 */
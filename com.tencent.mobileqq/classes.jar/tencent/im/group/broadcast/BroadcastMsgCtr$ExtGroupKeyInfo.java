package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BroadcastMsgCtr$ExtGroupKeyInfo
  extends MessageMicro<ExtGroupKeyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext_group_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_cur_max_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_operate_by_parents = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cur_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_cur_max_seq", "uint64_cur_time", "uint32_operate_by_parents", "bytes_ext_group_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, ExtGroupKeyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.group.broadcast.BroadcastMsgCtr.ExtGroupKeyInfo
 * JD-Core Version:    0.7.0.1
 */
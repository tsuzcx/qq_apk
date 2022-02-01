package tencent.im.group_pro_proto.group_pro.comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class common$MsgSeq
  extends MessageMicro<MsgSeq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_seq", "uint64_time" }, new Object[] { localLong, localLong }, MsgSeq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.group_pro.comm.common.MsgSeq
 * JD-Core Version:    0.7.0.1
 */
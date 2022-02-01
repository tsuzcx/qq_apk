package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$MsgPayGroupExt
  extends MessageMicro<MsgPayGroupExt>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_join_grp_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_quit_grp_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_join_grp_time", "uint64_quit_grp_time" }, new Object[] { localLong, localLong }, MsgPayGroupExt.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.MsgPayGroupExt
 * JD-Core Version:    0.7.0.1
 */
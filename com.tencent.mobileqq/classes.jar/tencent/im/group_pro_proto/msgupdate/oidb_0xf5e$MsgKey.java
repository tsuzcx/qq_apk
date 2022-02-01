package tencent.im.group_pro_proto.msgupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf5e$MsgKey
  extends MessageMicro<MsgKey>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field msg_time = PBField.initUInt64(0L);
  public final PBUInt64Field random = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "random", "msg_time" }, new Object[] { localLong, localLong }, MsgKey.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgupdate.oidb_0xf5e.MsgKey
 * JD-Core Version:    0.7.0.1
 */
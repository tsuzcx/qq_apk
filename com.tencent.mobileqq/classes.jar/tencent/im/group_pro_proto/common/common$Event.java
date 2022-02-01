package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class common$Event
  extends MessageMicro<Event>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field type = PBField.initUInt64(0L);
  public final PBUInt64Field version = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "type", "version" }, new Object[] { localLong, localLong }, Event.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.common.common.Event
 * JD-Core Version:    0.7.0.1
 */
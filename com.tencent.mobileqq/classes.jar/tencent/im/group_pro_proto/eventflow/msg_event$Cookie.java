package tencent.im.group_pro_proto.eventflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_event$Cookie
  extends MessageMicro<Cookie>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field begin_time = PBField.initUInt64(0L);
  public final PBUInt64Field end_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "begin_time", "end_time" }, new Object[] { localLong, localLong }, Cookie.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.eventflow.msg_event.Cookie
 * JD-Core Version:    0.7.0.1
 */
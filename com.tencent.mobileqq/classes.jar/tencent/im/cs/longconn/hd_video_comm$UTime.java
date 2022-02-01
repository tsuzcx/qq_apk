package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_comm$UTime
  extends MessageMicro<UTime>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_utime = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_time", "uint32_utime" }, new Object[] { localInteger, localInteger }, UTime.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.longconn.hd_video_comm.UTime
 * JD-Core Version:    0.7.0.1
 */
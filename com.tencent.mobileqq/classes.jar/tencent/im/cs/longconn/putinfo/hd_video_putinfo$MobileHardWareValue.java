package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_putinfo$MobileHardWareValue
  extends MessageMicro<MobileHardWareValue>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_mobile_camera_turn = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mobile_cpu_hertz = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mobile_cpu_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mobile_cpu_struct = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_mobile_cpu_struct", "uint32_mobile_cpu_number", "uint32_mobile_cpu_hertz", "uint32_mobile_camera_turn" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, MobileHardWareValue.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.longconn.putinfo.hd_video_putinfo.MobileHardWareValue
 * JD-Core Version:    0.7.0.1
 */
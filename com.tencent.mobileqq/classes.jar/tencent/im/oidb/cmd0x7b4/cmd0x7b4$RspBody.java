package tencent.im.oidb.cmd0x7b4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7b4$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_poi_info = PBField.initRepeatMessage(cmd0x7b4.POIInfo.class);
  public final PBRepeatMessageField rpt_taskcommon_info = PBField.initRepeatMessage(cmd0x7b4.TaskCommonInfo.class);
  public final PBUInt32Field uint32_flush_dist = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flush_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_get_award_range = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lbs_interval = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 82, 128 }, new String[] { "rpt_poi_info", "rpt_taskcommon_info", "uint32_get_award_range", "uint32_flush_dist", "uint32_flush_time", "bytes_cookie", "uint32_lbs_interval" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7b4.cmd0x7b4.RspBody
 * JD-Core Version:    0.7.0.1
 */
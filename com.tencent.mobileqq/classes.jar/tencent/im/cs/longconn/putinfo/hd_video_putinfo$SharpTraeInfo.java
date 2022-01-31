package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_putinfo$SharpTraeInfo
  extends MessageMicro<SharpTraeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88 }, new String[] { "uint32_trae_source", "uint32_trae_interface", "uint32_trae_stream_type", "uint32_trae_volume", "uint32_trae_mode", "uint32_arm_flag", "uint32_cpu_hertz", "uint32_audio_set", "uint32_param9", "uint32_param10", "uint32_param11" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SharpTraeInfo.class);
  public final PBUInt32Field uint32_arm_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_audio_set = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cpu_hertz = PBField.initUInt32(0);
  public final PBUInt32Field uint32_param10 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_param11 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_param9 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_trae_interface = PBField.initUInt32(0);
  public final PBUInt32Field uint32_trae_mode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_trae_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_trae_stream_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_trae_volume = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.longconn.putinfo.hd_video_putinfo.SharpTraeInfo
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0x74b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x74b$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 80 }, new String[] { "rpt_uint64_uin", "rpt_uint64_tinyid", "rpt_uint32_video_size", "rpt_head_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatField rpt_head_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField rpt_uint32_video_size = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField rpt_uint64_tinyid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x74b.oidb_0x74b.ReqBody
 * JD-Core Version:    0.7.0.1
 */
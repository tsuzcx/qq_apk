package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd4b$CheckUserSubStatusReq
  extends MessageMicro<CheckUserSubStatusReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_video_column_id" }, new Object[] { Integer.valueOf(0) }, CheckUserSubStatusReq.class);
  public final PBRepeatField<Integer> rpt_video_column_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.CheckUserSubStatusReq
 * JD-Core Version:    0.7.0.1
 */
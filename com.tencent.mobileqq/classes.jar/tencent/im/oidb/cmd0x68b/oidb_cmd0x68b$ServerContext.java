package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$ServerContext
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "rpt_recommend_uin_list", "rpt_circle_id_list" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ServerContext.class);
  public final PBRepeatField rpt_circle_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField rpt_recommend_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ServerContext
 * JD-Core Version:    0.7.0.1
 */
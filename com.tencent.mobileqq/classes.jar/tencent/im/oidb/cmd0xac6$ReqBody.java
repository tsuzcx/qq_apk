package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xac6$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_medals", "uint32_clean" }, new Object[] { null, Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatMessageField<cmd0xac6.MedalReport> rpt_medals = PBField.initRepeatMessage(cmd0xac6.MedalReport.class);
  public final PBUInt32Field uint32_clean = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac6.ReqBody
 * JD-Core Version:    0.7.0.1
 */
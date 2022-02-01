package tencent.im.beancurd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class anniversary$Anniversary
  extends MessageMicro<Anniversary>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_anniversary_info" }, new Object[] { null }, Anniversary.class);
  public final PBRepeatMessageField<anniversary.AnniversaryInfo> rpt_anniversary_info = PBField.initRepeatMessage(anniversary.AnniversaryInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.beancurd.anniversary.Anniversary
 * JD-Core Version:    0.7.0.1
 */
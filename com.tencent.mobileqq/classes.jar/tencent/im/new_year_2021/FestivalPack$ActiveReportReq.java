package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FestivalPack$ActiveReportReq
  extends MessageMicro<ActiveReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "act_id", "data", "int_data" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, ActiveReportReq.class);
  public final PBUInt32Field act_id = PBField.initUInt32(0);
  public final PBStringField data = PBField.initString("");
  public final PBUInt32Field int_data = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.ActiveReportReq
 * JD-Core Version:    0.7.0.1
 */
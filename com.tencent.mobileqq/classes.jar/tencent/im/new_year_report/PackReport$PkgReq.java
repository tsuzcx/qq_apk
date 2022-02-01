package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackReport$PkgReq
  extends MessageMicro<PkgReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  public final PBRepeatMessageField<PackReport.Report> report = PBField.initRepeatMessage(PackReport.Report.class);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uin", "promotion_id", "report", "seq" }, new Object[] { localLong, Integer.valueOf(0), null, localLong }, PkgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_report.PackReport.PkgReq
 * JD-Core Version:    0.7.0.1
 */
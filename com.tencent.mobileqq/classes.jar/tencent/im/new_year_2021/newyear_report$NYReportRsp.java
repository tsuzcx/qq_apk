package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class newyear_report$NYReportRsp
  extends MessageMicro<NYReportRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field batchSize = PBField.initUInt32(0);
  public final PBStringField errMsg = PBField.initString("");
  public final PBUInt32Field reportLevel = PBField.initUInt32(0);
  public final PBUInt32Field reportLevelTime = PBField.initUInt32(0);
  public final PBUInt32Field ret = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "ret", "errMsg", "batchSize", "reportLevel", "reportLevelTime" }, new Object[] { localInteger, "", localInteger, localInteger, localInteger }, NYReportRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2021.newyear_report.NYReportRsp
 * JD-Core Version:    0.7.0.1
 */
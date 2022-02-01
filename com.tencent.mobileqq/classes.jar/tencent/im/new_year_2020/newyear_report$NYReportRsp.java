package tencent.im.new_year_2020;

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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NYReportRsp{ret=");
    localStringBuilder.append(this.ret.get());
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(this.errMsg.get());
    localStringBuilder.append(", batchSize=");
    localStringBuilder.append(this.batchSize.get());
    localStringBuilder.append(", reportLevel=");
    localStringBuilder.append(this.reportLevel.get());
    localStringBuilder.append(", reportLevelTime=");
    localStringBuilder.append(this.reportLevelTime.get());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.new_year_2020.newyear_report.NYReportRsp
 * JD-Core Version:    0.7.0.1
 */
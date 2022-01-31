package tencent.im.new_year_2020;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class newyear_report$NYReportRsp
  extends MessageMicro<NYReportRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "ret", "errMsg", "batchSize", "reportLevel", "reportLevelTime" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NYReportRsp.class);
  public final PBUInt32Field batchSize = PBField.initUInt32(0);
  public final PBStringField errMsg = PBField.initString("");
  public final PBUInt32Field reportLevel = PBField.initUInt32(0);
  public final PBUInt32Field reportLevelTime = PBField.initUInt32(0);
  public final PBUInt32Field ret = PBField.initUInt32(0);
  
  public String toString()
  {
    return "NYReportRsp{ret=" + this.ret.get() + ", errMsg=" + this.errMsg.get() + ", batchSize=" + this.batchSize.get() + ", reportLevel=" + this.reportLevel.get() + ", reportLevelTime=" + this.reportLevelTime.get() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.new_year_2020.newyear_report.NYReportRsp
 * JD-Core Version:    0.7.0.1
 */
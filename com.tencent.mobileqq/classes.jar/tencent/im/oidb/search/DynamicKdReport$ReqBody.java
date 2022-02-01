package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class DynamicKdReport$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178 }, new String[] { "suin", "sguid", "squa", "sclientIp", "splatform", "sversion", "ssessionId", "stimeStamp", "sopername", "smodule", "saction", "sreseverobj1", "sreseverobj2", "sreseverobj3", "sreseverver1", "sreseverver2", "sreseverver3", "sreseverver4", "sreseverver5", "sreseverver6", "sreseverver7", "vecresever" }, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null }, ReqBody.class);
  public final PBStringField saction = PBField.initString("");
  public final PBStringField sclientIp = PBField.initString("");
  public final PBStringField sguid = PBField.initString("");
  public final PBStringField smodule = PBField.initString("");
  public final PBStringField sopername = PBField.initString("");
  public final PBStringField splatform = PBField.initString("");
  public final PBStringField squa = PBField.initString("");
  public final PBStringField sreseverobj1 = PBField.initString("");
  public final PBStringField sreseverobj2 = PBField.initString("");
  public final PBStringField sreseverobj3 = PBField.initString("");
  public final PBStringField sreseverver1 = PBField.initString("");
  public final PBStringField sreseverver2 = PBField.initString("");
  public final PBStringField sreseverver3 = PBField.initString("");
  public final PBStringField sreseverver4 = PBField.initString("");
  public final PBStringField sreseverver5 = PBField.initString("");
  public final PBStringField sreseverver6 = PBField.initString("");
  public final PBStringField sreseverver7 = PBField.initString("");
  public final PBStringField ssessionId = PBField.initString("");
  public final PBStringField stimeStamp = PBField.initString("");
  public final PBStringField suin = PBField.initString("");
  public final PBStringField sversion = PBField.initString("");
  public final PBRepeatMessageField<DynamicKdReport.KdReportResever> vecresever = PBField.initRepeatMessage(DynamicKdReport.KdReportResever.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.search.DynamicKdReport.ReqBody
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ArticleComment$ReportNetConnectInfoRequest
  extends MessageMicro<ReportNetConnectInfoRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field DNSCost = PBField.initUInt32(0);
  public final PBUInt32Field connectCost = PBField.initUInt32(0);
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBInt32Field netType = PBField.initInt32(0);
  public final PBUInt32Field receiveCost = PBField.initUInt32(0);
  public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField versionInfo = PBField.initString("");
  public final PBStringField website_address = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56, 64 }, new String[] { "versionInfo", "website_address", "errorcode", "url", "DNSCost", "connectCost", "receiveCost", "netType" }, new Object[] { "", "", localInteger, localByteStringMicro, localInteger, localInteger, localInteger, localInteger }, ReportNetConnectInfoRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.ac.ArticleComment.ReportNetConnectInfoRequest
 * JD-Core Version:    0.7.0.1
 */
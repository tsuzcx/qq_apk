package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QqAdGetProtos$PcgMediaTraceInfo
  extends MessageMicro<PcgMediaTraceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField buyer_id = PBField.initString("");
  public final PBStringField content_id = PBField.initString("");
  public final PBStringField ext_info = PBField.initString("");
  public final PBInt32Field media_type = PBField.initInt32(0);
  public final PBUInt64Field product_id = PBField.initUInt64(0L);
  public final PBInt32Field scene = PBField.initInt32(0);
  public final PBStringField seller_grade = PBField.initString("");
  public final PBStringField seller_id = PBField.initString("");
  public final PBUInt64Field timestamp = PBField.initUInt64(0L);
  public final PBStringField trace_id = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 74, 82 }, new String[] { "timestamp", "media_type", "product_id", "scene", "content_id", "trace_id", "buyer_id", "seller_id", "ext_info", "seller_grade" }, new Object[] { localLong, localInteger, localLong, localInteger, "", "", "", "", "", "" }, PcgMediaTraceInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.QqAdGetProtos.PcgMediaTraceInfo
 * JD-Core Version:    0.7.0.1
 */
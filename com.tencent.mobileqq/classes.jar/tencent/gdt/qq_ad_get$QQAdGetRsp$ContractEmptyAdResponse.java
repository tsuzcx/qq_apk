package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$ContractEmptyAdResponse
  extends MessageMicro<ContractEmptyAdResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField report_url = PBField.initString("");
  public final PBUInt32Field slot_index = PBField.initUInt32(0);
  public final PBStringField trace_id = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "trace_id", "type", "slot_index", "report_url" }, new Object[] { "", localInteger, localInteger, "" }, ContractEmptyAdResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.ContractEmptyAdResponse
 * JD-Core Version:    0.7.0.1
 */
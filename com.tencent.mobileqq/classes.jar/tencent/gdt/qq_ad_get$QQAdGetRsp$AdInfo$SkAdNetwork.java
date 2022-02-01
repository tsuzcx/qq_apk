package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$SkAdNetwork
  extends MessageMicro<SkAdNetwork>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField ad_network_id = PBField.initString("");
  public final PBUInt32Field campaign_id = PBField.initUInt32(0);
  public final PBStringField nonce = PBField.initString("");
  public final PBStringField signature = PBField.initString("");
  public final PBUInt64Field source_app_id = PBField.initUInt64(0L);
  public final PBUInt64Field timestamp_ms = PBField.initUInt64(0L);
  public final PBStringField version = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58 }, new String[] { "campaign_id", "timestamp_ms", "ad_network_id", "nonce", "source_app_id", "version", "signature" }, new Object[] { Integer.valueOf(0), localLong, "", "", localLong, "", "" }, SkAdNetwork.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.SkAdNetwork
 * JD-Core Version:    0.7.0.1
 */
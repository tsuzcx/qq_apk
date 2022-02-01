package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$BidInfo
  extends MessageMicro<BidInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ad_cost = PBField.initUInt32(0);
  public final PBUInt32Field cost_type = PBField.initUInt32(0);
  public final PBUInt32Field expect_cost = PBField.initUInt32(0);
  public final PBStringField fixed_pctr = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "cost_type", "expect_cost", "ad_cost", "fixed_pctr" }, new Object[] { localInteger, localInteger, localInteger, "" }, BidInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BidInfo
 * JD-Core Version:    0.7.0.1
 */
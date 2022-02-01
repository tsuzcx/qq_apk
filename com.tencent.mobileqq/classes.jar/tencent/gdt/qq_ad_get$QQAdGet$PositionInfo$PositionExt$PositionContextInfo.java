package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGet$PositionInfo$PositionExt$PositionContextInfo
  extends MessageMicro<PositionContextInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field abs_seq = PBField.initUInt32(0);
  public final PBUInt32Field screen_num = PBField.initUInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBStringField wesee_feeds_id = PBField.initString("");
  public final PBStringField wesee_first_category = PBField.initString("");
  public final PBStringField wesee_second_category = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "seq", "abs_seq", "wesee_feeds_id", "wesee_first_category", "wesee_second_category", "screen_num" }, new Object[] { localInteger, localInteger, "", "", "", localInteger }, PositionContextInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.PositionContextInfo
 * JD-Core Version:    0.7.0.1
 */
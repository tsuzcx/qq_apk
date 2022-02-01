package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGet$PositionInfo$PositionExt$SearchContentInfo$QueryInfo$Synonym
  extends MessageMicro<Synonym>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21 }, new String[] { "word", "weight" }, new Object[] { "", Float.valueOf(0.0F) }, Synonym.class);
  public final PBFloatField weight = PBField.initFloat(0.0F);
  public final PBStringField word = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.SearchContentInfo.QueryInfo.Synonym
 * JD-Core Version:    0.7.0.1
 */
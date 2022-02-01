package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGet$PositionInfo$PositionExt$SearchContentInfo$QueryInfo
  extends MessageMicro<QueryInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "word", "type", "terms" }, new Object[] { "", Integer.valueOf(0), null }, QueryInfo.class);
  public final PBRepeatMessageField<qq_ad_get.QQAdGet.PositionInfo.PositionExt.SearchContentInfo.QueryInfo.Term> terms = PBField.initRepeatMessage(qq_ad_get.QQAdGet.PositionInfo.PositionExt.SearchContentInfo.QueryInfo.Term.class);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField word = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.SearchContentInfo.QueryInfo
 * JD-Core Version:    0.7.0.1
 */
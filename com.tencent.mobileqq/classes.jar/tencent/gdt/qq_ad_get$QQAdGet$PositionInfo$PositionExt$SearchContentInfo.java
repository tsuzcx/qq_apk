package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qq_ad_get$QQAdGet$PositionInfo$PositionExt$SearchContentInfo
  extends MessageMicro<SearchContentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "query_tag", "query_info" }, new Object[] { null, null }, SearchContentInfo.class);
  public final PBRepeatMessageField<qq_ad_get.QQAdGet.PositionInfo.PositionExt.SearchContentInfo.QueryInfo> query_info = PBField.initRepeatMessage(qq_ad_get.QQAdGet.PositionInfo.PositionExt.SearchContentInfo.QueryInfo.class);
  public final PBRepeatMessageField<qq_ad_get.QQAdGet.PositionInfo.PositionExt.SearchContentInfo.Tag> query_tag = PBField.initRepeatMessage(qq_ad_get.QQAdGet.PositionInfo.PositionExt.SearchContentInfo.Tag.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.SearchContentInfo
 * JD-Core Version:    0.7.0.1
 */
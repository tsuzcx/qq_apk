package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class feeds_info$OutsideLinkInfo
  extends MessageMicro<OutsideLinkInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "title", "bring_goods_url", "icon_url" }, new Object[] { "", "", "" }, OutsideLinkInfo.class);
  public final PBStringField bring_goods_url = PBField.initString("");
  public final PBStringField icon_url = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.OutsideLinkInfo
 * JD-Core Version:    0.7.0.1
 */
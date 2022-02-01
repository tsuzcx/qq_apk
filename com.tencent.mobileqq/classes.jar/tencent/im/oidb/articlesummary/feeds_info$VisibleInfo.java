package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class feeds_info$VisibleInfo
  extends MessageMicro<VisibleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "visible_param", "visible_show_info" }, new Object[] { null, null }, VisibleInfo.class);
  public feeds_info.VisibleSetParam visible_param = new feeds_info.VisibleSetParam();
  public feeds_info.VisibleShowInfo visible_show_info = new feeds_info.VisibleShowInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.VisibleInfo
 * JD-Core Version:    0.7.0.1
 */
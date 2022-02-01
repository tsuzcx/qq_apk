package tencent.im.troop_search_searchtab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class searchtab$TitleBar
  extends MessageMicro<TitleBar>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_icon_url", "str_desc" }, new Object[] { "", "" }, TitleBar.class);
  public final PBStringField str_desc = PBField.initString("");
  public final PBStringField str_icon_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.troop_search_searchtab.searchtab.TitleBar
 * JD-Core Version:    0.7.0.1
 */
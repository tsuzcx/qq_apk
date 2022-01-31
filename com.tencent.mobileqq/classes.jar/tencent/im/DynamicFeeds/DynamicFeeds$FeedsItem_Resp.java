package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicFeeds$FeedsItem_Resp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "ulFeedID", "strTemplatData", "uiUpdateTime", "strFeedCookie", "uiResID" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "", Integer.valueOf(0) }, FeedsItem_Resp.class);
  public final PBStringField strFeedCookie = PBField.initString("");
  public final PBStringField strTemplatData = PBField.initString("");
  public final PBUInt32Field uiResID = PBField.initUInt32(0);
  public final PBUInt32Field uiUpdateTime = PBField.initUInt32(0);
  public final PBUInt64Field ulFeedID = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicFeeds.FeedsItem_Resp
 * JD-Core Version:    0.7.0.1
 */
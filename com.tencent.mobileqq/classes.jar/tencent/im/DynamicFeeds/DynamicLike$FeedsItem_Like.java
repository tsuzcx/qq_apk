package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicLike$FeedsItem_Like
  extends MessageMicro<FeedsItem_Like>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ulFeedID", "uiClickTime", "strFeedCookie" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, FeedsItem_Like.class);
  public final PBStringField strFeedCookie = PBField.initString("");
  public final PBUInt32Field uiClickTime = PBField.initUInt32(0);
  public final PBUInt64Field ulFeedID = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicLike.FeedsItem_Like
 * JD-Core Version:    0.7.0.1
 */
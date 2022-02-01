package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicFeeds$FeedsItem_History
  extends MessageMicro<FeedsItem_History>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "ulFeedID", "uiUpdateTimestamp", "bDislike" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false) }, FeedsItem_History.class);
  public final PBBoolField bDislike = PBField.initBool(false);
  public final PBUInt32Field uiUpdateTimestamp = PBField.initUInt32(0);
  public final PBUInt64Field ulFeedID = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicFeeds.FeedsItem_History
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicFeeds$FeedsItem_Resp
  extends MessageMicro<FeedsItem_Resp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field exp_temlate_id = PBField.initUInt32(0);
  public final PBStringField strFeedCookie = PBField.initString("");
  public final PBStringField strTemplatData = PBField.initString("");
  public final PBUInt32Field uiResID = PBField.initUInt32(0);
  public final PBUInt32Field uiUpdateTime = PBField.initUInt32(0);
  public final PBUInt64Field ulFeedID = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "ulFeedID", "strTemplatData", "uiUpdateTime", "strFeedCookie", "uiResID", "exp_temlate_id" }, new Object[] { Long.valueOf(0L), "", localInteger, "", localInteger, localInteger }, FeedsItem_Resp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicFeeds.FeedsItem_Resp
 * JD-Core Version:    0.7.0.1
 */
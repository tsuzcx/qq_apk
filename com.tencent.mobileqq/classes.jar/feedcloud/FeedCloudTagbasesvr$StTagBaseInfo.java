package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagbasesvr$StTagBaseInfo
  extends MessageMicro<StTagBaseInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136 }, new String[] { "tagName", "categoryChilds", "tagChilds", "relates", "parents", "status", "type", "tagNameId", "createTime", "userViewYesterday", "userViewHistory", "userPublishYesterday", "userPublishHistory", "showPublishHistory", "feedPublishHistory", "updateMillTime", "categoryIndex" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, StTagBaseInfo.class);
  public final PBRepeatField<String> categoryChilds = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt64Field categoryIndex = PBField.initInt64(0L);
  public final PBInt64Field createTime = PBField.initInt64(0L);
  public final PBInt64Field feedPublishHistory = PBField.initInt64(0L);
  public final PBRepeatField<String> parents = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> relates = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt64Field showPublishHistory = PBField.initInt64(0L);
  public final PBEnumField status = PBField.initEnum(0);
  public final PBRepeatField<String> tagChilds = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField tagName = PBField.initString("");
  public final PBInt64Field tagNameId = PBField.initInt64(0L);
  public final PBEnumField type = PBField.initEnum(0);
  public final PBInt64Field updateMillTime = PBField.initInt64(0L);
  public final PBInt64Field userPublishHistory = PBField.initInt64(0L);
  public final PBInt64Field userPublishYesterday = PBField.initInt64(0L);
  public final PBInt64Field userViewHistory = PBField.initInt64(0L);
  public final PBInt64Field userViewYesterday = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StTagBaseInfo
 * JD-Core Version:    0.7.0.1
 */
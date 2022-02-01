package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StShare;

public final class QQCircleBase$UserCircleInfo
  extends MessageMicro<UserCircleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 58, 66 }, new String[] { "id", "name", "circleType", "circleTab", "logo", "shareInfo", "tagId", "circleJumpUrl" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), "", null, "", "" }, UserCircleInfo.class);
  public final PBStringField circleJumpUrl = PBField.initString("");
  public final PBInt32Field circleTab = PBField.initInt32(0);
  public final PBInt32Field circleType = PBField.initInt32(0);
  public final PBStringField id = PBField.initString("");
  public final PBStringField logo = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public FeedCloudMeta.StShare shareInfo = new FeedCloudMeta.StShare();
  public final PBStringField tagId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleBase.UserCircleInfo
 * JD-Core Version:    0.7.0.1
 */
package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleProfile$StUserInfo
  extends MessageMicro<StUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26 }, new String[] { "user", "infos" }, new Object[] { null, null }, StUserInfo.class);
  public final PBRepeatMessageField<QQCircleProfile.StSingleInfo> infos = PBField.initRepeatMessage(QQCircleProfile.StSingleInfo.class);
  public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StUserInfo
 * JD-Core Version:    0.7.0.1
 */
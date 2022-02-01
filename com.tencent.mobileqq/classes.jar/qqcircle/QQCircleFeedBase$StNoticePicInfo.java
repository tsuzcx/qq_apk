package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StImage;

public final class QQCircleFeedBase$StNoticePicInfo
  extends MessageMicro<StNoticePicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "picInfo", "actionType", "schemaUrl" }, new Object[] { null, Integer.valueOf(0), "" }, StNoticePicInfo.class);
  public final PBUInt32Field actionType = PBField.initUInt32(0);
  public FeedCloudMeta.StImage picInfo = new FeedCloudMeta.StImage();
  public final PBStringField schemaUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StNoticePicInfo
 * JD-Core Version:    0.7.0.1
 */
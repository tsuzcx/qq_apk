package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import feedcloud.FeedCloudMeta.StImage;

public final class QQCircleFeedBase$StUserCertificationLabel
  extends MessageMicro<StUserCertificationLabel>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "needShow", "picInfo" }, new Object[] { Boolean.valueOf(false), null }, StUserCertificationLabel.class);
  public final PBBoolField needShow = PBField.initBool(false);
  public FeedCloudMeta.StImage picInfo = new FeedCloudMeta.StImage();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StUserCertificationLabel
 * JD-Core Version:    0.7.0.1
 */
package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleDitto$StPymkItemInfoBizData
  extends MessageMicro<StPymkItemInfoBizData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "recomUser", "isNew", "backupContent", "newUserPageMoreButton" }, new Object[] { null, Boolean.valueOf(false), "", null }, StPymkItemInfoBizData.class);
  public final PBStringField backupContent = PBField.initString("");
  public final PBBoolField isNew = PBField.initBool(false);
  public QQCircleDitto.StButton newUserPageMoreButton = new QQCircleDitto.StButton();
  public FeedCloudMeta.StUser recomUser = new FeedCloudMeta.StUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleDitto.StPymkItemInfoBizData
 * JD-Core Version:    0.7.0.1
 */
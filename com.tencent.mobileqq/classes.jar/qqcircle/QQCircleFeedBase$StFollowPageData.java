package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleFeedBase$StFollowPageData
  extends MessageMicro<StFollowPageData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "recomCircileCertification", "tipsTitle" }, new Object[] { null, "" }, StFollowPageData.class);
  public QQCircleBase.UserCircleInfo recomCircileCertification = new QQCircleBase.UserCircleInfo();
  public final PBStringField tipsTitle = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StFollowPageData
 * JD-Core Version:    0.7.0.1
 */
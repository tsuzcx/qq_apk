package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StNoticePattonInfo
  extends MessageMicro<StNoticePattonInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "pattonType", "leftTxtRightPic" }, new Object[] { Integer.valueOf(0), null }, StNoticePattonInfo.class);
  public QQCircleFeedBase.StLeftTxtRightPicInfo leftTxtRightPic = new QQCircleFeedBase.StLeftTxtRightPicInfo();
  public final PBUInt32Field pattonType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StNoticePattonInfo
 * JD-Core Version:    0.7.0.1
 */
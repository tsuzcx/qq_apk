package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQCircleFeedBase$StLeftTxtRightPicInfo
  extends MessageMicro<StLeftTxtRightPicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "txtInfo", "picInfo" }, new Object[] { null, null }, StLeftTxtRightPicInfo.class);
  public QQCircleFeedBase.StNoticePicInfo picInfo = new QQCircleFeedBase.StNoticePicInfo();
  public QQCircleFeedBase.StNoticeTxtInfo txtInfo = new QQCircleFeedBase.StNoticeTxtInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StLeftTxtRightPicInfo
 * JD-Core Version:    0.7.0.1
 */
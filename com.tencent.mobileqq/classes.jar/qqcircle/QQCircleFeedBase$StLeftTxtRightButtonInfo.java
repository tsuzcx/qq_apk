package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQCircleFeedBase$StLeftTxtRightButtonInfo
  extends MessageMicro<StLeftTxtRightButtonInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "txtInfo", "buttonInfo" }, new Object[] { null, null }, StLeftTxtRightButtonInfo.class);
  public QQCircleFeedBase.StNoticeButtonInfo buttonInfo = new QQCircleFeedBase.StNoticeButtonInfo();
  public QQCircleFeedBase.StNoticeTxtInfo txtInfo = new QQCircleFeedBase.StNoticeTxtInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StLeftTxtRightButtonInfo
 * JD-Core Version:    0.7.0.1
 */
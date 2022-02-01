package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQCircleFeedBase$StTopPicBottomTxtInfo
  extends MessageMicro<StTopPicBottomTxtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "title", "picInfo", "txtInfo", "moreInfo" }, new Object[] { null, null, null, null }, StTopPicBottomTxtInfo.class);
  public QQCircleFeedBase.StNoticeTxtInfo moreInfo = new QQCircleFeedBase.StNoticeTxtInfo();
  public QQCircleFeedBase.StNoticePicInfo picInfo = new QQCircleFeedBase.StNoticePicInfo();
  public QQCircleFeedBase.StNoticeTxtInfo title = new QQCircleFeedBase.StNoticeTxtInfo();
  public QQCircleFeedBase.StNoticeTxtInfo txtInfo = new QQCircleFeedBase.StNoticeTxtInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StTopPicBottomTxtInfo
 * JD-Core Version:    0.7.0.1
 */
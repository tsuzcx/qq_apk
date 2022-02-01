package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StNoticePattonInfo
  extends MessageMicro<StNoticePattonInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "pattonType", "userCertificationLabel", "plainTxt", "leftTxtRightPic", "leftTxtRightButton", "topPicBottomTxt" }, new Object[] { Integer.valueOf(0), null, null, null, null, null }, StNoticePattonInfo.class);
  public QQCircleFeedBase.StLeftTxtRightButtonInfo leftTxtRightButton = new QQCircleFeedBase.StLeftTxtRightButtonInfo();
  public QQCircleFeedBase.StLeftTxtRightPicInfo leftTxtRightPic = new QQCircleFeedBase.StLeftTxtRightPicInfo();
  public final PBUInt32Field pattonType = PBField.initUInt32(0);
  public QQCircleFeedBase.StPlainTxtInfo plainTxt = new QQCircleFeedBase.StPlainTxtInfo();
  public QQCircleFeedBase.StTopPicBottomTxtInfo topPicBottomTxt = new QQCircleFeedBase.StTopPicBottomTxtInfo();
  public QQCircleFeedBase.StUserCertificationLabel userCertificationLabel = new QQCircleFeedBase.StUserCertificationLabel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StNoticePattonInfo
 * JD-Core Version:    0.7.0.1
 */
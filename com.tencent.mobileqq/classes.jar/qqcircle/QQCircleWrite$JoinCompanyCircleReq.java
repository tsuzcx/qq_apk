package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleWrite$JoinCompanyCircleReq
  extends MessageMicro<JoinCompanyCircleReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "staffInfo", "msgID" }, new Object[] { null, null, "" }, JoinCompanyCircleReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField msgID = PBField.initString("");
  public QQCircleBase.StaffInfo staffInfo = new QQCircleBase.StaffInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleWrite.JoinCompanyCircleReq
 * JD-Core Version:    0.7.0.1
 */
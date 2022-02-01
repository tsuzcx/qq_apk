package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleWrite$JoinSchoolCircleReq
  extends MessageMicro<JoinSchoolCircleReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "studentInfo", "msgID" }, new Object[] { null, null, "" }, JoinSchoolCircleReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField msgID = PBField.initString("");
  public QQCircleBase.StudentInfo studentInfo = new QQCircleBase.StudentInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleWrite.JoinSchoolCircleReq
 * JD-Core Version:    0.7.0.1
 */
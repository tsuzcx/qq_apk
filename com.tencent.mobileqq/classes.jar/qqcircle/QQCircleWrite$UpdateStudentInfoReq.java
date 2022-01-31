package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleWrite$UpdateStudentInfoReq
  extends MessageMicro<UpdateStudentInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extInfo", "studentInfo", "msgID", "oldMsgID" }, new Object[] { null, null, "", "" }, UpdateStudentInfoReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField msgID = PBField.initString("");
  public final PBStringField oldMsgID = PBField.initString("");
  public QQCircleBase.StudentInfo studentInfo = new QQCircleBase.StudentInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleWrite.UpdateStudentInfoReq
 * JD-Core Version:    0.7.0.1
 */
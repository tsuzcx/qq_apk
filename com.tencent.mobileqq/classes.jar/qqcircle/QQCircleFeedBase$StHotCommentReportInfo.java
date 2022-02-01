package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleFeedBase$StHotCommentReportInfo
  extends MessageMicro<StHotCommentReportInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "reportID", "reportData" }, new Object[] { "", "" }, StHotCommentReportInfo.class);
  public final PBStringField reportData = PBField.initString("");
  public final PBStringField reportID = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StHotCommentReportInfo
 * JD-Core Version:    0.7.0.1
 */
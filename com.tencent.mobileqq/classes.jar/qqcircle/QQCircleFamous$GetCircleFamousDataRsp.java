package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleFamous$GetCircleFamousDataRsp
  extends MessageMicro<GetCircleFamousDataRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field grade = PBField.initInt32(0);
  public final PBRepeatMessageField<QQCircleFamous.CircleFamousGrade> gradeData = PBField.initRepeatMessage(QQCircleFamous.CircleFamousGrade.class);
  public final PBInt32Field totalFuel = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "totalFuel", "grade", "gradeData" }, new Object[] { null, localInteger, localInteger, null }, GetCircleFamousDataRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFamous.GetCircleFamousDataRsp
 * JD-Core Version:    0.7.0.1
 */
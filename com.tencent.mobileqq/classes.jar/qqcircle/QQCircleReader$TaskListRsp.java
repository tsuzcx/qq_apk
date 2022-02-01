package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleReader$TaskListRsp
  extends MessageMicro<TaskListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField ext = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field isFinish = PBField.initInt32(0);
  public final PBUInt32Field myFuel = PBField.initUInt32(0);
  public final PBStringField taskEntranceUrl = PBField.initString("");
  public final PBRepeatMessageField<QQCircleReader.TaskRecord> taskRecords = PBField.initRepeatMessage(QQCircleReader.TaskRecord.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50 }, new String[] { "extInfo", "myFuel", "taskRecords", "isFinish", "ext", "taskEntranceUrl" }, new Object[] { null, localInteger, null, localInteger, "", "" }, TaskListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleReader.TaskListRsp
 * JD-Core Version:    0.7.0.1
 */
package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class TaskCenterReader$ReceiveFuelRecordRsp
  extends MessageMicro<ReceiveFuelRecordRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "records" }, new Object[] { null, null }, ReceiveFuelRecordRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<TaskCenterReader.ReceiveFuelRecord> records = PBField.initRepeatMessage(TaskCenterReader.ReceiveFuelRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.TaskCenterReader.ReceiveFuelRecordRsp
 * JD-Core Version:    0.7.0.1
 */
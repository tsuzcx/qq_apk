package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class TaskCenterReader$ReceiveFuelRecordReq
  extends MessageMicro<ReceiveFuelRecordReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "reqFrom", "scene", "uids" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(1), "" }, ReceiveFuelRecordReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field reqFrom = PBField.initInt32(0);
  public final PBEnumField scene = PBField.initEnum(1);
  public final PBRepeatField<String> uids = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.TaskCenterReader.ReceiveFuelRecordReq
 * JD-Core Version:    0.7.0.1
 */
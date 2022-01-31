package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TaskCenterWrite$PushFeedReq
  extends MessageMicro<PushFeedReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "hostUserId", "srcUserId", "optTime", "feedsId", "optCnt" }, new Object[] { "", "", Integer.valueOf(0), "", Integer.valueOf(0) }, PushFeedReq.class);
  public final PBStringField feedsId = PBField.initString("");
  public final PBStringField hostUserId = PBField.initString("");
  public final PBUInt32Field optCnt = PBField.initUInt32(0);
  public final PBUInt32Field optTime = PBField.initUInt32(0);
  public final PBStringField srcUserId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.TaskCenterWrite.PushFeedReq
 * JD-Core Version:    0.7.0.1
 */
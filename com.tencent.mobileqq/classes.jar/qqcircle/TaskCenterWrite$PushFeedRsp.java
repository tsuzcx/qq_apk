package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TaskCenterWrite$PushFeedRsp
  extends MessageMicro<PushFeedRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field consumeFuel = PBField.initUInt32(0);
  public final PBUInt32Field myFuel = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "consumeFuel", "myFuel" }, new Object[] { localInteger, localInteger }, PushFeedRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.TaskCenterWrite.PushFeedRsp
 * JD-Core Version:    0.7.0.1
 */
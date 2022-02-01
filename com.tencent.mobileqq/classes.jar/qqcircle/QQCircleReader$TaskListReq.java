package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleReader$TaskListReq
  extends MessageMicro<TaskListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField ext = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBInt32Field reqFrom = PBField.initInt32(0);
  public final PBStringField userId = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "userId", "reqFrom", "num", "ext" }, new Object[] { null, "", localInteger, localInteger, "" }, TaskListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleReader.TaskListReq
 * JD-Core Version:    0.7.0.1
 */
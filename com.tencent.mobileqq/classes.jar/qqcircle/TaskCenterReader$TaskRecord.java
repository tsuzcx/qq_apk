package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class TaskCenterReader$TaskRecord
  extends MessageMicro<TaskRecord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField bottonDesc = PBField.initString("");
  public final PBInt32Field bottonJumpFlag = PBField.initInt32(0);
  public final PBStringField desc = PBField.initString("");
  public final PBInt32Field haveDone = PBField.initInt32(0);
  public final PBStringField jumpUrl = PBField.initString("");
  public final PBInt32Field maxCnt = PBField.initInt32(0);
  public final PBStringField taskDesc = PBField.initString("");
  public final PBEnumField taskType = PBField.initEnum(0);
  public final PBStringField title = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 58, 66, 72 }, new String[] { "taskType", "title", "desc", "haveDone", "maxCnt", "jumpUrl", "taskDesc", "bottonDesc", "bottonJumpFlag" }, new Object[] { localInteger, "", "", localInteger, localInteger, "", "", "", localInteger }, TaskRecord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.TaskCenterReader.TaskRecord
 * JD-Core Version:    0.7.0.1
 */
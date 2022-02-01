package tencent.im.mobiletips;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileTips$TaskInfo
  extends MessageMicro<TaskInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<String> keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field msgcnt = PBField.initUInt32(0);
  public final PBUInt32Field task_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "task_id", "msgcnt", "keywords" }, new Object[] { localInteger, localInteger, "" }, TaskInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.mobiletips.MobileTips.TaskInfo
 * JD-Core Version:    0.7.0.1
 */
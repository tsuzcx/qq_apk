package tencent.im.mobiletips;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MobileTips$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int TYPE_C2C = 1;
  public static final int TYPE_DISCUSS = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "peer_type", "peer_uin", "task_list" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), null }, ReqBody.class);
  public final PBEnumField peer_type = PBField.initEnum(1);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  public final PBRepeatMessageField<MobileTips.TaskInfo> task_list = PBField.initRepeatMessage(MobileTips.TaskInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.mobiletips.MobileTips.ReqBody
 * JD-Core Version:    0.7.0.1
 */
package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleMsgPaelem$GroupSvrTrans
  extends MessageMicro<GroupSvrTrans>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_to_uin_flag", "uint64_create_calender_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, GroupSvrTrans.class);
  public final PBUInt32Field uint32_to_uin_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_create_calender_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleMsgPaelem.GroupSvrTrans
 * JD-Core Version:    0.7.0.1
 */
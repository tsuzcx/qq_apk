package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class common$MsgCtrlHead
  extends MessageMicro<MsgCtrlHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field ctrl_flag = PBField.initUInt64(0L);
  public final PBRepeatField<Long> exclude_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> include_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field offline_flag = PBField.initUInt32(0);
  public final PBRepeatField<Long> rpt_featureid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field visibility = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "include_uin", "exclude_uin", "rpt_featureid", "offline_flag", "visibility", "ctrl_flag" }, new Object[] { localLong, localLong, localLong, localInteger, localInteger, localLong }, MsgCtrlHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.common.common.MsgCtrlHead
 * JD-Core Version:    0.7.0.1
 */
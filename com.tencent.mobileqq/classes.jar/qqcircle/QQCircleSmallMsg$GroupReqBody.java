package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleSmallMsg$GroupReqBody
  extends MessageMicro<GroupReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 56, 64, 72 }, new String[] { "opt_uint64_group_code", "rpt_uint64_memberuins", "opt_uint32_offline", "msg_inst_ctrl", "comm_gray_tips_info", "opt_sysdb_flag", "uint64_feature_id", "opt_push_mode" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, null, Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false) }, GroupReqBody.class);
  public QQCircleSmallMsg.CommGrayTipsInfo comm_gray_tips_info = new QQCircleSmallMsg.CommGrayTipsInfo();
  public QQCircleMsgPaelem.InstCtrl msg_inst_ctrl = new QQCircleMsgPaelem.InstCtrl();
  public final PBBoolField opt_push_mode = PBField.initBool(false);
  public final PBUInt32Field opt_sysdb_flag = PBField.initUInt32(0);
  public final PBUInt32Field opt_uint32_offline = PBField.initUInt32(0);
  public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
  public final PBRepeatField<Long> rpt_uint64_memberuins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_feature_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleSmallMsg.GroupReqBody
 * JD-Core Version:    0.7.0.1
 */
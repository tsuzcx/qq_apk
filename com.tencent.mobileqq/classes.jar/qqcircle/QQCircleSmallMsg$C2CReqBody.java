package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleSmallMsg$C2CReqBody
  extends MessageMicro<C2CReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66, 74 }, new String[] { "uint64_from_uin", "uint64_to_uin", "uint32_msg_seq", "uint32_rand", "uint32_tips_type", "comm_gray_tips_info", "uint64_feature_id", "pa_elem", "msg_inst_ctrl" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), null, null }, C2CReqBody.class);
  public QQCircleSmallMsg.CommGrayTipsInfo comm_gray_tips_info = new QQCircleSmallMsg.CommGrayTipsInfo();
  public QQCircleMsgPaelem.InstCtrl msg_inst_ctrl = new QQCircleMsgPaelem.InstCtrl();
  public QQCircleMsgPaelem.PAElem pa_elem = new QQCircleMsgPaelem.PAElem();
  public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rand = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tips_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feature_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleSmallMsg.C2CReqBody
 * JD-Core Version:    0.7.0.1
 */
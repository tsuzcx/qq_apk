package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleSmallMsg$C2CReqBody
  extends MessageMicro<C2CReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public QQCircleSmallMsg.CommGrayTipsInfo comm_gray_tips_info = new QQCircleSmallMsg.CommGrayTipsInfo();
  public QQCircleMsgPaelem.InstCtrl msg_inst_ctrl = new QQCircleMsgPaelem.InstCtrl();
  public QQCircleMsgPaelem.PAElem pa_elem = new QQCircleMsgPaelem.PAElem();
  public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rand = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tips_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feature_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66, 74 }, new String[] { "uint64_from_uin", "uint64_to_uin", "uint32_msg_seq", "uint32_rand", "uint32_tips_type", "comm_gray_tips_info", "uint64_feature_id", "pa_elem", "msg_inst_ctrl" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger, null, localLong, null, null }, C2CReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleSmallMsg.C2CReqBody
 * JD-Core Version:    0.7.0.1
 */
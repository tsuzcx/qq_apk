package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleMsgPaelem$InstCtrl
  extends MessageMicro<InstCtrl>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rpt_msg_send_to_inst", "rpt_msg_exclude_inst", "msg_from_inst" }, new Object[] { null, null, null }, InstCtrl.class);
  public QQCircleMsgPaelem.InstInfo msg_from_inst = new QQCircleMsgPaelem.InstInfo();
  public final PBRepeatMessageField<QQCircleMsgPaelem.InstInfo> rpt_msg_exclude_inst = PBField.initRepeatMessage(QQCircleMsgPaelem.InstInfo.class);
  public final PBRepeatMessageField<QQCircleMsgPaelem.InstInfo> rpt_msg_send_to_inst = PBField.initRepeatMessage(QQCircleMsgPaelem.InstInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleMsgPaelem.InstCtrl
 * JD-Core Version:    0.7.0.1
 */
package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_ctrl$MsgCtrl
  extends MessageMicro<MsgCtrl>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "msg_flag", "resv_resv_info" }, new Object[] { Integer.valueOf(0), null }, MsgCtrl.class);
  public final PBUInt32Field msg_flag = PBField.initUInt32(0);
  public msg_ctrl.ResvResvInfo resv_resv_info = new msg_ctrl.ResvResvInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_ctrl.MsgCtrl
 * JD-Core Version:    0.7.0.1
 */
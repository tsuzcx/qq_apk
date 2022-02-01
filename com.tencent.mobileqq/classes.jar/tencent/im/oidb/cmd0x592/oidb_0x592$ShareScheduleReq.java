package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.trunk.Qworkflow.Qworkflow.AppID;

public final class oidb_0x592$ShareScheduleReq
  extends MessageMicro<ShareScheduleReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public Qworkflow.AppID msg_receive_group = new Qworkflow.AppID();
  public final PBRepeatMessageField<oidb_0x592.RepeatedScheduleShareInfo> rpt_msg_repeated_schedule = PBField.initRepeatMessage(oidb_0x592.RepeatedScheduleShareInfo.class);
  public final PBRepeatMessageField<oidb_0x592.ShareReceiver> rpt_receiver_list = PBField.initRepeatMessage(oidb_0x592.ShareReceiver.class);
  public final PBRepeatField<ByteStringMicro> rpt_schedule_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "rpt_schedule_id_list", "rpt_receiver_list", "msg_receive_group", "rpt_msg_repeated_schedule" }, new Object[] { localByteStringMicro, null, null, null }, ShareScheduleReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.ShareScheduleReq
 * JD-Core Version:    0.7.0.1
 */
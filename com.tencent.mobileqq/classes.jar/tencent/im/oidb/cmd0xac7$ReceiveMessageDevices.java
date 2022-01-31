package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0xac7$ReceiveMessageDevices
  extends MessageMicro<ReceiveMessageDevices>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_devices" }, new Object[] { null }, ReceiveMessageDevices.class);
  public final PBRepeatMessageField<cmd0xac7.DeviceInfo> rpt_devices = PBField.initRepeatMessage(cmd0xac7.DeviceInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac7.ReceiveMessageDevices
 * JD-Core Version:    0.7.0.1
 */
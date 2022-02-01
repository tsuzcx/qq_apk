package tencent.im.oidb.qfind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QFind$ReqReportDevs
  extends MessageMicro<ReqReportDevs>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "dev_infos", "dev_loc" }, new Object[] { null, null }, ReqReportDevs.class);
  public final PBRepeatMessageField<QFind.DeviceInfo> dev_infos = PBField.initRepeatMessage(QFind.DeviceInfo.class);
  public QFind.DeviceLoc dev_loc = new QFind.DeviceLoc();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qfind.QFind.ReqReportDevs
 * JD-Core Version:    0.7.0.1
 */
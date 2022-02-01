package tencent.im.oidb.cmd0x91d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.label.comm.PersonalityTagComm.LabelInfo;

public final class cmd0x91d$LabelUpdateInfo
  extends MessageMicro<LabelUpdateInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_label_info", "uint32_upload_photos" }, new Object[] { null, Integer.valueOf(0) }, LabelUpdateInfo.class);
  public PersonalityTagComm.LabelInfo msg_label_info = new PersonalityTagComm.LabelInfo();
  public final PBUInt32Field uint32_upload_photos = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x91d.cmd0x91d.LabelUpdateInfo
 * JD-Core Version:    0.7.0.1
 */
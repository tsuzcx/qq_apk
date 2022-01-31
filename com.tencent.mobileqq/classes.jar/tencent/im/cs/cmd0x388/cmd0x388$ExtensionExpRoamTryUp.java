package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x388$ExtensionExpRoamTryUp
  extends MessageMicro<ExtensionExpRoamTryUp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_exproam_pic_info" }, new Object[] { null }, ExtensionExpRoamTryUp.class);
  public final PBRepeatMessageField<cmd0x388.ExpRoamPicInfo> rpt_msg_exproam_pic_info = PBField.initRepeatMessage(cmd0x388.ExpRoamPicInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.ExtensionExpRoamTryUp
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x88d$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_appid", "stzreqgroupinfo", "uint32_pc_client_version" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatMessageField<oidb_0x88d.ReqGroupInfo> stzreqgroupinfo = PBField.initRepeatMessage(oidb_0x88d.ReqGroupInfo.class);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pc_client_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody
 * JD-Core Version:    0.7.0.1
 */
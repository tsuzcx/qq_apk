package tencent.im.oidb.cmd0x769;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x769$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 810 }, new String[] { "uint32_result", "rpt_config_list", "query_uin_package_usage_rsp" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
  public Oidb_0x769.QueryUinPackageUsageRsp query_uin_package_usage_rsp = new Oidb_0x769.QueryUinPackageUsageRsp();
  public final PBRepeatMessageField rpt_config_list = PBField.initRepeatMessage(Oidb_0x769.Config.class);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x769.Oidb_0x769.RspBody
 * JD-Core Version:    0.7.0.1
 */
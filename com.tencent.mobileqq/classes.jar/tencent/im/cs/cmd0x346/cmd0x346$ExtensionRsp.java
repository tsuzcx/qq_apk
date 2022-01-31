package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x346$ExtensionRsp
  extends MessageMicro<ExtensionRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_transfer_type", "uint32_channel_type", "uint32_allow_retry", "server_addr_ipv6_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ExtensionRsp.class);
  public cmd0x346.AddrList server_addr_ipv6_list = new cmd0x346.AddrList();
  public final PBUInt32Field uint32_allow_retry = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_transfer_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ExtensionRsp
 * JD-Core Version:    0.7.0.1
 */
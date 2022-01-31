package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody$SrvAddrs
  extends MessageMicro<SrvAddrs>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_service_type", "rpt_msg_addrs" }, new Object[] { Integer.valueOf(0), null }, SrvAddrs.class);
  public final PBRepeatMessageField<subcmd0x501.SubCmd0x501Rspbody.IpAddr> rpt_msg_addrs = PBField.initRepeatMessage(subcmd0x501.SubCmd0x501Rspbody.IpAddr.class);
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs
 * JD-Core Version:    0.7.0.1
 */
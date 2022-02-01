package tencent.im.cs.cmd0x3fb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x3fb$GrayMsg
  extends MessageMicro<GrayMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 82, 90 }, new String[] { "uint32_subcmd", "msg_gray_req", "msg_gray_rsp" }, new Object[] { Integer.valueOf(0), null, null }, GrayMsg.class);
  public cmd0x3fb.ReqBody msg_gray_req = new cmd0x3fb.ReqBody();
  public cmd0x3fb.RspBody msg_gray_rsp = new cmd0x3fb.RspBody();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.cmd0x3fb.cmd0x3fb.GrayMsg
 * JD-Core Version:    0.7.0.1
 */
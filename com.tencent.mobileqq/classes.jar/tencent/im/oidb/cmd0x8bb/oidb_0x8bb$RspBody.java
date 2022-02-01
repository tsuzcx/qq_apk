package tencent.im.oidb.cmd0x8bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x8bb$RspBody
  extends MessageMicro<RspBody>
{
  public static final int MSG_READ_RSP_FIELD_NUMBER = 2;
  public static final int MSG_WRITE_RSP_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_write_rsp", "msg_read_rsp" }, new Object[] { null, null }, RspBody.class);
  public oidb_0x8bb.ReadRsp msg_read_rsp = new oidb_0x8bb.ReadRsp();
  public oidb_0x8bb.WriteRsp msg_write_rsp = new oidb_0x8bb.WriteRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8bb.oidb_0x8bb.RspBody
 * JD-Core Version:    0.7.0.1
 */
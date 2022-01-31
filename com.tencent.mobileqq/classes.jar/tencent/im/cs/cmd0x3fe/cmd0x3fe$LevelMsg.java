package tencent.im.cs.cmd0x3fe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x3fe$LevelMsg
  extends MessageMicro<LevelMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 82, 90 }, new String[] { "uint32_subcmd", "msg_level_req", "msg_level_rsp" }, new Object[] { Integer.valueOf(0), null, null }, LevelMsg.class);
  public cmd0x3fe.ReqBody msg_level_req = new cmd0x3fe.ReqBody();
  public cmd0x3fe.RspBody msg_level_rsp = new cmd0x3fe.RspBody();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x3fe.cmd0x3fe.LevelMsg
 * JD-Core Version:    0.7.0.1
 */
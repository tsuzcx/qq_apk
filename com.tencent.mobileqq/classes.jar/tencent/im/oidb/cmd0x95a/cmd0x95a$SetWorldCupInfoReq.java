package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x95a$SetWorldCupInfoReq
  extends MessageMicro<SetWorldCupInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_worldcup_info" }, new Object[] { null }, SetWorldCupInfoReq.class);
  public cmd0x95a.WorldCupInfo msg_worldcup_info = new cmd0x95a.WorldCupInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.SetWorldCupInfoReq
 * JD-Core Version:    0.7.0.1
 */
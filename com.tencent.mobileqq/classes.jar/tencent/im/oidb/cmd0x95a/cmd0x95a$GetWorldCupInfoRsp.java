package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0x95a$GetWorldCupInfoRsp
  extends MessageMicro<GetWorldCupInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_worldcup_info" }, new Object[] { null }, GetWorldCupInfoRsp.class);
  public cmd0x95a.WorldCupInfo msg_worldcup_info = new cmd0x95a.WorldCupInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.GetWorldCupInfoRsp
 * JD-Core Version:    0.7.0.1
 */
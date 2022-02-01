package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xeb7$StSignInRecordRsp
  extends MessageMicro<StSignInRecordRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "ret", "base", "userRecord", "daySigned", "kingRecord", "level" }, new Object[] { null, null, null, null, null, null }, StSignInRecordRsp.class);
  public oidb_0xeb7.SignInStatusBase base = new oidb_0xeb7.SignInStatusBase();
  public oidb_0xeb7.StSignInRecordDaySigned daySigned = new oidb_0xeb7.StSignInRecordDaySigned();
  public oidb_0xeb7.StSignInRecordKing kingRecord = new oidb_0xeb7.StSignInRecordKing();
  public oidb_0xeb7.StViewGroupLevel level = new oidb_0xeb7.StViewGroupLevel();
  public oidb_0xeb7.Ret ret = new oidb_0xeb7.Ret();
  public oidb_0xeb7.StSignInRecordUser userRecord = new oidb_0xeb7.StSignInRecordUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb7.oidb_0xeb7.StSignInRecordRsp
 * JD-Core Version:    0.7.0.1
 */
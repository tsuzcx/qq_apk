package tencent.im.oidb.cmd0x48a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x48a$ChkBlockReq
  extends MessageMicro<ChkBlockReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_block_account_data" }, new Object[] { null }, ChkBlockReq.class);
  public oidb_0x48a.OneBlockAccountData msg_block_account_data = new oidb_0x48a.OneBlockAccountData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x48a.oidb_0x48a.ChkBlockReq
 * JD-Core Version:    0.7.0.1
 */
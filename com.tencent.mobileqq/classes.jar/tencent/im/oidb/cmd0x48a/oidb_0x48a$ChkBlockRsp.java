package tencent.im.oidb.cmd0x48a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x48a$ChkBlockRsp
  extends MessageMicro<ChkBlockRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_block_account_data", "uint32_result" }, new Object[] { null, Integer.valueOf(0) }, ChkBlockRsp.class);
  public oidb_0x48a.OneBlockAccountData msg_block_account_data = new oidb_0x48a.OneBlockAccountData();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x48a.oidb_0x48a.ChkBlockRsp
 * JD-Core Version:    0.7.0.1
 */
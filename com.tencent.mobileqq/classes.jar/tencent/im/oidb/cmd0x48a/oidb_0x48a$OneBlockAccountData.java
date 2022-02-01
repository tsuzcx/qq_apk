package tencent.im.oidb.cmd0x48a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x48a$OneBlockAccountData
  extends MessageMicro<OneBlockAccountData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_account_type", "uint64_block_qcall_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, OneBlockAccountData.class);
  public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_block_qcall_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x48a.oidb_0x48a.OneBlockAccountData
 * JD-Core Version:    0.7.0.1
 */
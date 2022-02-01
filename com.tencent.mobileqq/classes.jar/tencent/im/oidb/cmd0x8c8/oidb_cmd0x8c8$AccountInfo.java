package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x8c8$AccountInfo
  extends MessageMicro<AccountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_is_account_approved = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_account_derelict = PBField.initUInt32(0);
  public final PBUInt64Field uint64_account_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_account_id", "uint32_is_account_approved", "uint32_is_account_derelict" }, new Object[] { Long.valueOf(0L), localInteger, localInteger }, AccountInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.AccountInfo
 * JD-Core Version:    0.7.0.1
 */
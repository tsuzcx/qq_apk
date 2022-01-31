package tencent.im.oidb.cmd0x8a1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x8a1$SelectGroupCodeInfo
  extends MessageMicro<SelectGroupCodeInfo>
{
  public static final int UINT64_OWNER_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_owner_uin" }, new Object[] { Long.valueOf(0L) }, SelectGroupCodeInfo.class);
  public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a1.cmd0x8a1.SelectGroupCodeInfo
 * JD-Core Version:    0.7.0.1
 */
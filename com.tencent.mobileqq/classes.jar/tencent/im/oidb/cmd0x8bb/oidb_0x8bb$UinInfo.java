package tencent.im.oidb.cmd0x8bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8bb$UinInfo
  extends MessageMicro
{
  public static final int UINT32_FROM_FIELD_NUMBER = 3;
  public static final int UINT32_UPDATE_TIME_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_update_time", "uint32_from" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, UinInfo.class);
  public final PBUInt32Field uint32_from = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8bb.oidb_0x8bb.UinInfo
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0xed4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xed4$UserCoin
  extends MessageMicro<UserCoin>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "platformCoin", "userCoin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, UserCoin.class);
  public final PBUInt64Field platformCoin = PBField.initUInt64(0L);
  public final PBUInt64Field userCoin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.UserCoin
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x43c$UinInfo
  extends MessageMicro<UinInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin", "isFriend", "isSearchable" }, new Object[] { Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false) }, UinInfo.class);
  public final PBBoolField isFriend = PBField.initBool(false);
  public final PBBoolField isSearchable = PBField.initBool(false);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x43c.Oidb_0x43c.UinInfo
 * JD-Core Version:    0.7.0.1
 */
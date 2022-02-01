package tencent.im.oidb.cmd0xd23;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0xd23$CacheKey
  extends MessageMicro<CacheKey>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "cache_prefix", "appid" }, new Object[] { "sdk_group_bind_data", Integer.valueOf(0) }, CacheKey.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBStringField cache_prefix = PBField.initString("sdk_group_bind_data");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd23.Oidb_0xd23.CacheKey
 * JD-Core Version:    0.7.0.1
 */
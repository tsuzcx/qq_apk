package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class common$RoutingHead
  extends MessageMicro<RoutingHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field from_appid = PBField.initUInt64(0L);
  public final PBUInt64Field from_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field guild_code = PBField.initUInt64(0L);
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "guild_id", "channel_id", "from_uin", "from_tinyid", "guild_code", "from_appid" }, new Object[] { localLong, localLong, localLong, localLong, localLong, localLong }, RoutingHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.common.common.RoutingHead
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.group_pro_proto.oidb0xffa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb0xffa$GuildInfo
  extends MessageMicro<GuildInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "guild_id", "channel_id" }, new Object[] { localLong, localLong }, GuildInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.oidb0xffa.oidb0xffa.GuildInfo
 * JD-Core Version:    0.7.0.1
 */
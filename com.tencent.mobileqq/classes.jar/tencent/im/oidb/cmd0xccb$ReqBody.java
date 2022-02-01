package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xccb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<cmd0xccb.C2cMsgInfo> c2c_msg = PBField.initRepeatMessage(cmd0xccb.C2cMsgInfo.class);
  public final PBUInt32Field c2c_type = PBField.initUInt32(0);
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field dest_uin = PBField.initUInt64(0L);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBRepeatMessageField<cmd0xccb.GroupMsgInfo> group_msg = PBField.initRepeatMessage(cmd0xccb.GroupMsgInfo.class);
  public final PBUInt64Field guild_id = PBField.initUInt64(0L);
  public final PBRepeatMessageField<cmd0xccb.GuildMsgInfo> guild_msg = PBField.initRepeatMessage(cmd0xccb.GuildMsgInfo.class);
  public cmd0xccb.LocalMsgInfo local_msg = new cmd0xccb.LocalMsgInfo();
  public final PBUInt32Field service_type = PBField.initUInt32(0);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 66, 72, 80, 90, 98 }, new String[] { "type", "dest_uin", "group_code", "c2c_msg", "group_msg", "c2c_type", "service_type", "local_msg", "guild_id", "channel_id", "guild_msg", "sig" }, new Object[] { localInteger, localLong, localLong, null, null, localInteger, localInteger, null, localLong, localLong, null, localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xccb.ReqBody
 * JD-Core Version:    0.7.0.1
 */
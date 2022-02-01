package tencent.im.group_pro_proto.oidb0xf9c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class common$Guild
  extends MessageMicro<Guild>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField avatar = PBField.initString("");
  public final PBUInt64Field code = PBField.initUInt64(0L);
  public final PBStringField cover = PBField.initString("");
  public final PBUInt64Field id = PBField.initUInt64(0L);
  public final PBBytesField join_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField name = PBField.initString("");
  public final PBStringField profile = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBBoolField verify = PBField.initBool(false);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 64, 74 }, new String[] { "id", "code", "name", "profile", "type", "avatar", "cover", "verify", "join_sig" }, new Object[] { localLong, localLong, "", "", Integer.valueOf(0), "", "", Boolean.valueOf(false), localByteStringMicro }, Guild.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.oidb0xf9c.common.Guild
 * JD-Core Version:    0.7.0.1
 */
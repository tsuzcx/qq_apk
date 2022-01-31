package tencent.im.oidb.cmd0x7e7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x7e7$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cmd_id = PBField.initUInt32(0);
  public final PBBytesField cmd_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field corp_uin = PBField.initUInt64(0L);
  public final PBUInt32Field env = PBField.initUInt32(0);
  public final PBBytesField json_string = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public Oidb_0x7e7.PlatformInfo platform_info = new Oidb_0x7e7.PlatformInfo();
  public final PBUInt64Field timestamp = PBField.initUInt64(0L);
  public final PBUInt64Field user_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56, 64, 74 }, new String[] { "cmd_id", "cmd_key", "env", "platform", "platform_info", "corp_uin", "user_uin", "timestamp", "json_string" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7e7.Oidb_0x7e7.ReqBody
 * JD-Core Version:    0.7.0.1
 */
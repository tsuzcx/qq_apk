package tencent.im.oidb.cmd0x991;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x991$User
  extends MessageMicro<User>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x991.LoginSig msg_login_sig = new oidb_cmd0x991.LoginSig();
  public final PBUInt32Field uint32_client = PBField.initUInt32(0);
  public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48 }, new String[] { "uint64_group", "uint32_client", "bytes_version", "uint32_portal", "msg_login_sig", "uint32_instance_id" }, new Object[] { Long.valueOf(0L), localInteger, localByteStringMicro, localInteger, null, localInteger }, User.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x991.oidb_cmd0x991.User
 * JD-Core Version:    0.7.0.1
 */
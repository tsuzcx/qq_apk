package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x58b$ConfMemberInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_conf_name_card = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_member_interemark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_interemark_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_join_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_read_msg_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58 }, new String[] { "uint64_uin", "uint32_join_time", "uint32_flag", "uint32_read_msg_seq", "bytes_member_interemark", "uint32_interemark_source", "bytes_conf_name_card" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, ConfMemberInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x58b.cmd0x58b.ConfMemberInfo
 * JD-Core Version:    0.7.0.1
 */
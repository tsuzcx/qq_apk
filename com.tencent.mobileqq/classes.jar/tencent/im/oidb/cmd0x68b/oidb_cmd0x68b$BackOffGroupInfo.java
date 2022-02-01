package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x68b$BackOffGroupInfo
  extends MessageMicro<BackOffGroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_back_off_group = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_max_evoke_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_fresh_evoke_count = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_back_off_group", "uint32_max_evoke_count", "uint32_max_fresh_evoke_count" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, BackOffGroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.BackOffGroupInfo
 * JD-Core Version:    0.7.0.1
 */
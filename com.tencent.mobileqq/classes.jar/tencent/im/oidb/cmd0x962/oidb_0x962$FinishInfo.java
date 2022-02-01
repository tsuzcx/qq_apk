package tencent.im.oidb.cmd0x962;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x962$FinishInfo
  extends MessageMicro<FinishInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_first_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_participate_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_first_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "bytes_text", "uint32_participate_num", "uint64_first_uin", "bytes_first_nick_name", "bytes_url" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3 }, FinishInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x962.oidb_0x962.FinishInfo
 * JD-Core Version:    0.7.0.1
 */
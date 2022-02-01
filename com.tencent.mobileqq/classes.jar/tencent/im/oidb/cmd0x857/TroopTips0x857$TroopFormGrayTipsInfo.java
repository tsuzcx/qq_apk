package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$TroopFormGrayTipsInfo
  extends MessageMicro<TroopFormGrayTipsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_creator_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_opt_bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rich_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_creator_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_writer_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint64_writer_uin", "uint64_creator_uin", "bytes_rich_content", "bytes_opt_bytes_url", "bytes_creator_nick" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, TroopFormGrayTipsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.TroopFormGrayTipsInfo
 * JD-Core Version:    0.7.0.1
 */
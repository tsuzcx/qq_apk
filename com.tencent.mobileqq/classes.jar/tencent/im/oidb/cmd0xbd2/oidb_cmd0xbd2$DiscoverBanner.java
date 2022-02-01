package tencent.im.oidb.cmd0xbd2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbd2$DiscoverBanner
  extends MessageMicro<DiscoverBanner>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cover_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_data_json = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "uint64_id", "bytes_cover_url", "bytes_cover_title", "uint32_jump_type", "bytes_jump_data_json" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3 }, DiscoverBanner.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd2.oidb_cmd0xbd2.DiscoverBanner
 * JD-Core Version:    0.7.0.1
 */
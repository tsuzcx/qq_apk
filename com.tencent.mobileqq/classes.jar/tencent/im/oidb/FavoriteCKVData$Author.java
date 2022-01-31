package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FavoriteCKVData$Author
  extends MessageMicro<Author>
{
  public static final int Email = 4;
  public static final int Group = 2;
  public static final int Phone = 5;
  public static final int TempTeam = 3;
  public static final int Uin = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_str_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_num_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint32_type", "uint64_num_id", "bytes_str_id", "uint64_group_id", "bytes_group_name" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, Author.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.FavoriteCKVData.Author
 * JD-Core Version:    0.7.0.1
 */
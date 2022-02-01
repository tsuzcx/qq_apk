package tencent.im.oidb.cmd0xf8b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xf8b$BiuOneLevelItem
  extends MessageMicro<BiuOneLevelItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_biu_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xf8b.JumpInfo msg_jump_info = new oidb_cmd0xf8b.JumpInfo();
  public final PBEnumField op_type = PBField.initEnum(0);
  public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 48, 58 }, new String[] { "uint64_feeds_id", "uint64_uin", "uint32_biu_time", "bytes_biu_comments", "op_type", "msg_jump_info" }, new Object[] { localLong, localLong, localInteger, localByteStringMicro, localInteger, null }, BiuOneLevelItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b.BiuOneLevelItem
 * JD-Core Version:    0.7.0.1
 */
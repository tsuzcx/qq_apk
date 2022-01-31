package tencent.im.oidb.cmd0x954;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x954$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_refresh_type = PBField.initEnum(0);
  public cmd0x954.ReqFeedsParam req_feeds_param = new cmd0x954.ReqFeedsParam();
  public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 90 }, new String[] { "uint64_uin", "enum_refresh_type", "uint64_start_time", "bytes_feeds_id", "req_feeds_param" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x954.cmd0x954.ReqBody
 * JD-Core Version:    0.7.0.1
 */
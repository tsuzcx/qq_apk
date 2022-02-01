package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xd4b$QuerySubListReq
  extends MessageMicro<QuerySubListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_uin", "bytes_page_cookies", "uint32_page_size" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, QuerySubListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.QuerySubListReq
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd4b$QuerySubUserListReq
  extends MessageMicro<QuerySubUserListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_column_id", "bytes_page_cookies", "uint32_page_size" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, QuerySubUserListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.QuerySubUserListReq
 * JD-Core Version:    0.7.0.1
 */
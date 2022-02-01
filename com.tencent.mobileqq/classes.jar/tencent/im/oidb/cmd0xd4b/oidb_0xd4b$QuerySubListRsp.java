package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd4b$QuerySubListRsp
  extends MessageMicro<QuerySubListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Integer> rpt_uint32_column_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "rpt_uint32_column_id", "uint32_is_end", "bytes_page_cookies" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, QuerySubListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.QuerySubListRsp
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xd4b$QuerySubUserListRsp
  extends MessageMicro<QuerySubUserListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "rpt_uin_list", "uint32_is_end", "bytes_page_cookies" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, QuerySubUserListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b.QuerySubUserListRsp
 * JD-Core Version:    0.7.0.1
 */
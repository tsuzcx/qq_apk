package tencent.im.oidb.cmd0x897;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x897$VisitorInfo
  extends MessageMicro<VisitorInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField string_visitor_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_guest_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_role = PBField.initUInt32(0);
  public final PBUInt32Field uint32_visitor_faceid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint64_visitor_uin", "uint32_visitor_faceid", "string_visitor_nick", "uint32_role", "uint32_guest_flag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, VisitorInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x897.cmd0x897.VisitorInfo
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0x897;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x897$GroupNextVisitor
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48 }, new String[] { "msg_group_uin_code", "uint64_next_visitor", "msg_req_field", "uint32_max_count", "uint32_administrator_field", "uint32_guest_field" }, new Object[] { null, Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupNextVisitor.class);
  public cmd0x897.GroupUinCode msg_group_uin_code = new cmd0x897.GroupUinCode();
  public cmd0x897.VisitorInfo msg_req_field = new cmd0x897.VisitorInfo();
  public final PBUInt32Field uint32_administrator_field = PBField.initUInt32(0);
  public final PBUInt32Field uint32_guest_field = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_next_visitor = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x897.cmd0x897.GroupNextVisitor
 * JD-Core Version:    0.7.0.1
 */
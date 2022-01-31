package im.oidb.wifi_poi_group.cmd0x8e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x8e9$VisitorInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_visitor_uin", "uint32_visitor_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, VisitorInfo.class);
  public final PBUInt32Field uint32_visitor_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     im.oidb.wifi_poi_group.cmd0x8e9.cmd0x8e9.VisitorInfo
 * JD-Core Version:    0.7.0.1
 */
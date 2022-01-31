package tencent.im.oidb.cmd0x8fd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x8fd$ReqFilter
  extends MessageMicro<ReqFilter>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_level_name_flag" }, new Object[] { Integer.valueOf(0) }, ReqFilter.class);
  public final PBUInt32Field uint32_level_name_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8fd.Oidb_0x8fd.ReqFilter
 * JD-Core Version:    0.7.0.1
 */
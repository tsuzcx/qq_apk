package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8e7$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56 }, new String[] { "msg_ext_parm", "uint64_uin", "uint64_tinyid", "bool_stock", "bool_is_first", "bool_need_warn", "bool_need_update_url" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) }, ReqBody.class);
  public final PBBoolField bool_is_first = PBField.initBool(false);
  public final PBBoolField bool_need_update_url = PBField.initBool(false);
  public final PBBoolField bool_need_warn = PBField.initBool(false);
  public final PBBoolField bool_stock = PBField.initBool(false);
  public oidb_0x8e7.ExtParam msg_ext_parm = new oidb_0x8e7.ExtParam();
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ReqBody
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x89a$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_group_code", "st_group_info", "uint64_original_operator_uin", "uint32_req_group_open_appid" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  public oidb_0x89a.groupinfo st_group_info = new oidb_0x89a.groupinfo();
  public final PBUInt32Field uint32_req_group_open_appid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_original_operator_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody
 * JD-Core Version:    0.7.0.1
 */
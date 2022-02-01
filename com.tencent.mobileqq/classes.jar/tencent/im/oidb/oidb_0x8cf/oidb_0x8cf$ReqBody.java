package tencent.im.oidb.oidb_0x8cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8cf$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int OPT_UINT32_NEED_MOBILE_SYSAPPS_FIELD_NUMBER = 2;
  public static final int OPT_UINT64_GROUPCODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "opt_uint64_groupcode", "opt_uint32_need_mobile_sysapps" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field opt_uint32_need_mobile_sysapps = PBField.initUInt32(0);
  public final PBUInt64Field opt_uint64_groupcode = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8cf.oidb_0x8cf.ReqBody
 * JD-Core Version:    0.7.0.1
 */
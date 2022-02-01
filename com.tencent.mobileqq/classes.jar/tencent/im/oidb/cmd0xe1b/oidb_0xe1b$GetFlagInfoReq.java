package tencent.im.oidb.cmd0xe1b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe1b$GetFlagInfoReq
  extends MessageMicro<GetFlagInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 88, 96 }, new String[] { "rpt_uint64_uin_list", "uint32_need_all", "uint32_ignore_cache", "uint32_need_private_flag", "uint32_need_teenager_flag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetFlagInfoReq.class);
  public final PBRepeatField<Long> rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_ignore_cache = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_all = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_private_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_teenager_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe1b.oidb_0xe1b.GetFlagInfoReq
 * JD-Core Version:    0.7.0.1
 */
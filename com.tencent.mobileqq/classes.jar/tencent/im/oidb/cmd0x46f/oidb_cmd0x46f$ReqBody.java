package tencent.im.oidb.cmd0x46f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x46f$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint64_uin", "rpt_param_list" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
  public final PBRepeatMessageField<oidb_cmd0x46f.DislikeParam> rpt_param_list = PBField.initRepeatMessage(oidb_cmd0x46f.DislikeParam.class);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.ReqBody
 * JD-Core Version:    0.7.0.1
 */
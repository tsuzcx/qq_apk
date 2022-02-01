package tencent.im.oidb.cmd0xe5b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe5b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_uin", "rpt_achievement_id", "uint32_max_count", "bool_req_achievement_content" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, ReqBody.class);
  public final PBBoolField bool_req_achievement_content = PBField.initBool(false);
  public final PBRepeatField<Integer> rpt_achievement_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_max_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5b.oidb_0xe5b.ReqBody
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0x89b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x89b$KickPublicGroupVisitorRspBody
  extends MessageMicro<KickPublicGroupVisitorRspBody>
{
  public static final int RPT_UINT64_VISITOR_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint64_visitor_uin" }, new Object[] { Long.valueOf(0L) }, KickPublicGroupVisitorRspBody.class);
  public final PBRepeatField<Long> rpt_uint64_visitor_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89b.oidb_0x89b.KickPublicGroupVisitorRspBody
 * JD-Core Version:    0.7.0.1
 */
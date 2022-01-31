package tencent.im.oidb.cmd0x89b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x89b$JoinPublicGroupRspBody
  extends MessageMicro
{
  public static final int UINT64_VISITOR_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_visitor_uin" }, new Object[] { Long.valueOf(0L) }, JoinPublicGroupRspBody.class);
  public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89b.oidb_0x89b.JoinPublicGroupRspBody
 * JD-Core Version:    0.7.0.1
 */
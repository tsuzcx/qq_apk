package tencent.im.oidb.cmd0xa8d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa8d$Cmd0xa8dJoinPublicGroupReqBody
  extends MessageMicro<Cmd0xa8dJoinPublicGroupReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_visitor_uin" }, new Object[] { Long.valueOf(0L) }, Cmd0xa8dJoinPublicGroupReqBody.class);
  public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa8d.oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody
 * JD-Core Version:    0.7.0.1
 */
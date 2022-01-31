package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x95a$JoinWorldCupRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_recommend_uin", "str_recommend_nick" }, new Object[] { Long.valueOf(0L), "" }, JoinWorldCupRsp.class);
  public final PBStringField str_recommend_nick = PBField.initString("");
  public final PBUInt64Field uint64_recommend_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.JoinWorldCupRsp
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x95a$GetWorldCupInfoReq
  extends MessageMicro<GetWorldCupInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_share_id" }, new Object[] { "" }, GetWorldCupInfoReq.class);
  public final PBStringField str_share_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.GetWorldCupInfoReq
 * JD-Core Version:    0.7.0.1
 */
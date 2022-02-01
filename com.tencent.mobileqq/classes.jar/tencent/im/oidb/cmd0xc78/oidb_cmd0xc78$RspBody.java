package tencent.im.oidb.cmd0xc78;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xc78$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82 }, new String[] { "wording", "check_share_extension_rsp" }, new Object[] { "", null }, RspBody.class);
  public oidb_cmd0xc78.CheckShareExtensionRsp check_share_extension_rsp = new oidb_cmd0xc78.CheckShareExtensionRsp();
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.RspBody
 * JD-Core Version:    0.7.0.1
 */
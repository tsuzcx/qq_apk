package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xb61$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82 }, new String[] { "wording", "get_appinfo_rsp" }, new Object[] { "", null }, RspBody.class);
  public oidb_0xb61.GetAppinfoRsp get_appinfo_rsp = new oidb_0xb61.GetAppinfoRsp();
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb61.RspBody
 * JD-Core Version:    0.7.0.1
 */
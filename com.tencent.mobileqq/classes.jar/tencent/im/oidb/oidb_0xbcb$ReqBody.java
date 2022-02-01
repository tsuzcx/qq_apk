package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0xbcb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 72, 82 }, new String[] { "not_use_cache", "check_url_req" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
  public oidb_0xbcb.CheckUrlReq check_url_req = new oidb_0xbcb.CheckUrlReq();
  public final PBInt32Field not_use_cache = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xbcb.ReqBody
 * JD-Core Version:    0.7.0.1
 */
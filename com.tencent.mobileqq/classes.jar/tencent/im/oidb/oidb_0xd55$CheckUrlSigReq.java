package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0xd55$CheckUrlSigReq
  extends MessageMicro<CheckUrlSigReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "is_need_check_raw_url_sig" }, new Object[] { Boolean.valueOf(false) }, CheckUrlSigReq.class);
  public final PBBoolField is_need_check_raw_url_sig = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd55.CheckUrlSigReq
 * JD-Core Version:    0.7.0.1
 */
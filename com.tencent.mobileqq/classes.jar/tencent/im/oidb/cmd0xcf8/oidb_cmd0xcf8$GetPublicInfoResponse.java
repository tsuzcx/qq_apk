package tencent.im.oidb.cmd0xcf8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xcf8$GetPublicInfoResponse
  extends MessageMicro<GetPublicInfoResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "ret_info", "seqno", "info" }, new Object[] { null, Integer.valueOf(0), null }, GetPublicInfoResponse.class);
  public oidb_cmd0xcf8.PublicAccountInfo info = new oidb_cmd0xcf8.PublicAccountInfo();
  public oidb_cmd0xcf8.RetInfo ret_info = new oidb_cmd0xcf8.RetInfo();
  public final PBUInt32Field seqno = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicInfoResponse
 * JD-Core Version:    0.7.0.1
 */
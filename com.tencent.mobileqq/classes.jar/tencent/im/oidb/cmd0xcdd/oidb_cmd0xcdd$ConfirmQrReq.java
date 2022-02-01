package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xcdd$ConfirmQrReq
  extends MessageMicro<ConfirmQrReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField biz_type = PBField.initEnum(1);
  public final PBBytesField qr_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xcdd.UserData user_data = new oidb_cmd0xcdd.UserData();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "qr_sig", "user_data", "biz_type" }, new Object[] { localByteStringMicro, null, Integer.valueOf(1) }, ConfirmQrReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.ConfirmQrReq
 * JD-Core Version:    0.7.0.1
 */
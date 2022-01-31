package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xcdd$RejectQrReq
  extends MessageMicro<RejectQrReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField biz_type = PBField.initEnum(1);
  public final PBBytesField qr_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "qr_sig", "biz_type" }, new Object[] { localByteStringMicro, Integer.valueOf(1) }, RejectQrReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.RejectQrReq
 * JD-Core Version:    0.7.0.1
 */
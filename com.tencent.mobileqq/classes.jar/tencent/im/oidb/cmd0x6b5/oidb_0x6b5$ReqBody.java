package tencent.im.oidb.cmd0x6b5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6b5$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_gift_bagid = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6b5.LoginSig msg_login_sig = new oidb_0x6b5.LoginSig();
  public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "uint64_group_id", "bytes_gift_bagid", "uint32_channel", "msg_login_sig", "uint32_business_id", "uint32_portal" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6b5.oidb_0x6b5.ReqBody
 * JD-Core Version:    0.7.0.1
 */
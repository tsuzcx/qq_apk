package tencent.im.oidb.cmd0x6c2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6c2$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_gift_bagid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_page_index = PBField.initInt32(0);
  public final PBInt32Field int32_page_size = PBField.initInt32(0);
  public oidb_0x6c2.LoginSig msg_login_sig = new oidb_0x6c2.LoginSig();
  public final PBUInt32Field uint32_channel = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "uint64_group_id", "bytes_gift_bagid", "int32_page_index", "int32_page_size", "uint32_channel", "msg_login_sig" }, new Object[] { Long.valueOf(0L), localByteStringMicro, localInteger, localInteger, localInteger, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c2.oidb_0x6c2.ReqBody
 * JD-Core Version:    0.7.0.1
 */
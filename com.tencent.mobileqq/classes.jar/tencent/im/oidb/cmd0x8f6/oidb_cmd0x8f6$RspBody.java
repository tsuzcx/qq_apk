package tencent.im.oidb.cmd0x8f6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x8f6$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x8f6.DecreaseUnreadMailCountRsp msg_dec_umc = new oidb_cmd0x8f6.DecreaseUnreadMailCountRsp();
  public oidb_cmd0x8f6.GetUnreadMailCountRsp msg_get_umc = new oidb_cmd0x8f6.GetUnreadMailCountRsp();
  public oidb_cmd0x8f6.IncUnreadMailCountRsp msg_inc_umc = new oidb_cmd0x8f6.IncUnreadMailCountRsp();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_result", "bytes_error_msg", "msg_get_umc", "msg_dec_umc", "msg_inc_umc" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.RspBody
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0x6c2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6c2$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_player = PBField.initInt32(0);
  public oidb_0x6c2.GiftBagInfo msg_gift_bag_info = new oidb_0x6c2.GiftBagInfo();
  public oidb_0x6c2.Player msg_winner = new oidb_0x6c2.Player();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "uint32_result", "bytes_errmsg", "msg_gift_bag_info", "int32_player", "msg_winner" }, new Object[] { localInteger, localByteStringMicro, null, localInteger, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c2.oidb_0x6c2.RspBody
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x6c3$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0x6c3.ExclusiveGiftItem> exclusive_gift_list = PBField.initRepeatMessage(oidb_0x6c3.ExclusiveGiftItem.class);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public oidb_0x6c3.GetExtraDataRsp msg_extra_data = new oidb_0x6c3.GetExtraDataRsp();
  public oidb_0x6c3.GetStockRsp msg_get_stock = new oidb_0x6c3.GetStockRsp();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "int32_ret", "bytes_msg", "msg_get_stock", "msg_extra_data", "exclusive_gift_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c3.oidb_0x6c3.RspBody
 * JD-Core Version:    0.7.0.1
 */
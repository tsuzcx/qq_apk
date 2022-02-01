package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class im_receipt$ReceiptReq
  extends MessageMicro<ReceiptReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "command", "msg_info" }, new Object[] { Integer.valueOf(1), null }, ReceiptReq.class);
  public final PBEnumField command = PBField.initEnum(1);
  public im_receipt.MsgInfo msg_info = new im_receipt.MsgInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_receipt.ReceiptReq
 * JD-Core Version:    0.7.0.1
 */
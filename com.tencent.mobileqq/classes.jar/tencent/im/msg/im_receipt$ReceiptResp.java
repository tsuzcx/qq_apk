package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class im_receipt$ReceiptResp
  extends MessageMicro<ReceiptResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "command", "receipt_info" }, new Object[] { Integer.valueOf(1), null }, ReceiptResp.class);
  public final PBEnumField command = PBField.initEnum(1);
  public im_receipt.ReceiptInfo receipt_info = new im_receipt.ReceiptInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_receipt.ReceiptResp
 * JD-Core Version:    0.7.0.1
 */
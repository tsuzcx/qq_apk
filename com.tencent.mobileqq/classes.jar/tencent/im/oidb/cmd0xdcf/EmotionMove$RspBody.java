package tencent.im.oidb.cmd0xdcf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class EmotionMove$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret", "errmsg", "msg_order_filename" }, new Object[] { Integer.valueOf(0), "", null }, RspBody.class);
  public final PBStringField errmsg = PBField.initString("");
  public EmotionMove.OrderFileResult msg_order_filename = new EmotionMove.OrderFileResult();
  public final PBInt32Field ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdcf.EmotionMove.RspBody
 * JD-Core Version:    0.7.0.1
 */
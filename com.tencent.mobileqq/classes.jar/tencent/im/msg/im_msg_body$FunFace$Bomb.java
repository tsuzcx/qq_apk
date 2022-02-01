package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class im_msg_body$FunFace$Bomb
  extends MessageMicro<Bomb>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "bool_burst" }, new Object[] { Boolean.valueOf(false) }, Bomb.class);
  public final PBBoolField bool_burst = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.FunFace.Bomb
 * JD-Core Version:    0.7.0.1
 */
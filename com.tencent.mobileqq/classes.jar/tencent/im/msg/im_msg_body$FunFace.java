package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_msg_body$FunFace
  extends MessageMicro<FunFace>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_turntable", "msg_bomb" }, new Object[] { null, null }, FunFace.class);
  public im_msg_body.FunFace.Bomb msg_bomb = new im_msg_body.FunFace.Bomb();
  public im_msg_body.FunFace.Turntable msg_turntable = new im_msg_body.FunFace.Turntable();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.FunFace
 * JD-Core Version:    0.7.0.1
 */
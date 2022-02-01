package tencent.im.oidb.cmd0xe16;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xe16$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_key_info", "msg_card_jump_info", "msg_content_info" }, new Object[] { null, null, null }, RspBody.class);
  public oidb_cmd0xe16.CardJumpInfo msg_card_jump_info = new oidb_cmd0xe16.CardJumpInfo();
  public oidb_cmd0xe16.ContentInfo msg_content_info = new oidb_cmd0xe16.ContentInfo();
  public oidb_cmd0xe16.KeyInfo msg_key_info = new oidb_cmd0xe16.KeyInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.RspBody
 * JD-Core Version:    0.7.0.1
 */
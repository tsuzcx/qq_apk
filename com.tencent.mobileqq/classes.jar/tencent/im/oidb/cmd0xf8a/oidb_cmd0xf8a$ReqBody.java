package tencent.im.oidb.cmd0xf8a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xf8a$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "patrol_info", "comment_info" }, new Object[] { null, null }, ReqBody.class);
  public oidb_cmd0xf8a.CommentInfo comment_info = new oidb_cmd0xf8a.CommentInfo();
  public oidb_cmd0xf8a.PatrolInfo patrol_info = new oidb_cmd0xf8a.PatrolInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf8a.oidb_cmd0xf8a.ReqBody
 * JD-Core Version:    0.7.0.1
 */
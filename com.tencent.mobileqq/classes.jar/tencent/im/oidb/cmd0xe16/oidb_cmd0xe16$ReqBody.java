package tencent.im.oidb.cmd0xe16;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xe16$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_param_info", "msg_comment_info", "msg_content_info" }, new Object[] { null, null, null }, ReqBody.class);
  public oidb_cmd0xe16.CommentInfo msg_comment_info = new oidb_cmd0xe16.CommentInfo();
  public oidb_cmd0xe16.ContentInfo msg_content_info = new oidb_cmd0xe16.ContentInfo();
  public oidb_cmd0xe16.ParamInfo msg_param_info = new oidb_cmd0xe16.ParamInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.ReqBody
 * JD-Core Version:    0.7.0.1
 */
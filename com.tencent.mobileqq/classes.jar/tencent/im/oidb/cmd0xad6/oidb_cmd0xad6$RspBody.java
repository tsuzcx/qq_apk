package tencent.im.oidb.cmd0xad6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xad6$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "bool_use_webview", "msg_rsp_article", "msg_ext_info" }, new Object[] { Boolean.valueOf(false), null, null }, RspBody.class);
  public final PBBoolField bool_use_webview = PBField.initBool(false);
  public oidb_cmd0xad6.ArticleExtInfo msg_ext_info = new oidb_cmd0xad6.ArticleExtInfo();
  public oidb_cmd0xad6.RspArticle msg_rsp_article = new oidb_cmd0xad6.RspArticle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspBody
 * JD-Core Version:    0.7.0.1
 */
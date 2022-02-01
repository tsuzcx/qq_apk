package tencent.im.oidb.cmd0xad6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xad6$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "msg_client", "msg_req_article", "uint32_article", "uint32_read_count", "uint32_comment", "uint32_comment_key_type" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public oidb_cmd0xad6.Client msg_client = new oidb_cmd0xad6.Client();
  public oidb_cmd0xad6.ReqArticle msg_req_article = new oidb_cmd0xad6.ReqArticle();
  public final PBUInt32Field uint32_article = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment_key_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_read_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ReqBody
 * JD-Core Version:    0.7.0.1
 */
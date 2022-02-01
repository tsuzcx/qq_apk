package tencent.im.oidb.cmd0xad6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xad6$RspArticle
  extends MessageMicro<RspArticle>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_article", "uint64_version" }, new Object[] { null, Long.valueOf(0L) }, RspArticle.class);
  public oidb_cmd0xad6.Article msg_article = new oidb_cmd0xad6.Article();
  public final PBUInt64Field uint64_version = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspArticle
 * JD-Core Version:    0.7.0.1
 */
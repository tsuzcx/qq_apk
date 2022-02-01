package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb54$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg_client", "msg_req_article", "uint32_topic", "msg_option" }, new Object[] { null, null, Integer.valueOf(0), null }, ReqBody.class);
  public oidb_cmd0xb54.Client msg_client = new oidb_cmd0xb54.Client();
  public oidb_cmd0xb54.ReqOption msg_option = new oidb_cmd0xb54.ReqOption();
  public oidb_cmd0xb54.ReqArticle msg_req_article = new oidb_cmd0xb54.ReqArticle();
  public final PBUInt32Field uint32_topic = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ReqBody
 * JD-Core Version:    0.7.0.1
 */
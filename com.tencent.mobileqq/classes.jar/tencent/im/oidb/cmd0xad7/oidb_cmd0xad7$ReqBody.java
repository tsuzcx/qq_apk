package tencent.im.oidb.cmd0xad7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xad7$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "msg_client", "msg_req_article", "uint32_friend", "uint32_qzhone", "uint32_wechat", "uint32_wechat_pyq", "uint32_wechat_dpyq", "uint32_weibo", "uint32_biu" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public oidb_cmd0xad7.Client msg_client = new oidb_cmd0xad7.Client();
  public oidb_cmd0xad7.ReqArticle msg_req_article = new oidb_cmd0xad7.ReqArticle();
  public final PBUInt32Field uint32_biu = PBField.initUInt32(0);
  public final PBUInt32Field uint32_friend = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qzhone = PBField.initUInt32(0);
  public final PBUInt32Field uint32_wechat = PBField.initUInt32(0);
  public final PBUInt32Field uint32_wechat_dpyq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_wechat_pyq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_weibo = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.ReqBody
 * JD-Core Version:    0.7.0.1
 */
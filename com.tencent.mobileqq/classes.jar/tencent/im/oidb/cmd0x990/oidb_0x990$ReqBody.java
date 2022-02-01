package tencent.im.oidb.cmd0x990;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x990$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_translate_req", "msg_batch_translate_req" }, new Object[] { null, null }, ReqBody.class);
  public oidb_0x990.BatchTranslateReq msg_batch_translate_req = new oidb_0x990.BatchTranslateReq();
  public oidb_0x990.TranslateReq msg_translate_req = new oidb_0x990.TranslateReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x990.oidb_0x990.ReqBody
 * JD-Core Version:    0.7.0.1
 */
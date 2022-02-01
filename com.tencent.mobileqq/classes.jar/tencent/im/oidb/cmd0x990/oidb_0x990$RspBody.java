package tencent.im.oidb.cmd0x990;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x990$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_translate_rsp", "msg_batch_translate_rsp" }, new Object[] { null, null }, RspBody.class);
  public oidb_0x990.BatchTranslateRsp msg_batch_translate_rsp = new oidb_0x990.BatchTranslateRsp();
  public oidb_0x990.TranslateRsp msg_translate_rsp = new oidb_0x990.TranslateRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x990.oidb_0x990.RspBody
 * JD-Core Version:    0.7.0.1
 */
package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x533$HttpAROcrResult
  extends MessageMicro<HttpAROcrResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26 }, new String[] { "uint64_ocr_recog_type", "msg_sougou_rsp" }, new Object[] { Long.valueOf(0L), null }, HttpAROcrResult.class);
  public subcmd0x533.HttpServerResponseBodyV2 msg_sougou_rsp = new subcmd0x533.HttpServerResponseBodyV2();
  public final PBUInt64Field uint64_ocr_recog_type = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x533.HttpAROcrResult
 * JD-Core Version:    0.7.0.1
 */
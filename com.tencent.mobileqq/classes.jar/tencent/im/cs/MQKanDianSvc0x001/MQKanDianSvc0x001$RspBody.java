package tencent.im.cs.MQKanDianSvc0x001;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MQKanDianSvc0x001$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_error_num", "rpt_msg_words", "rpt_msg_articles" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
  public final PBInt32Field int32_error_num = PBField.initInt32(0);
  public final PBRepeatMessageField<MQKanDianSvc0x001.RspBody.ArticleInfo> rpt_msg_articles = PBField.initRepeatMessage(MQKanDianSvc0x001.RspBody.ArticleInfo.class);
  public final PBRepeatMessageField<MQKanDianSvc0x001.RspBody.WordsOfCut> rpt_msg_words = PBField.initRepeatMessage(MQKanDianSvc0x001.RspBody.WordsOfCut.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.MQKanDianSvc0x001.MQKanDianSvc0x001.RspBody
 * JD-Core Version:    0.7.0.1
 */
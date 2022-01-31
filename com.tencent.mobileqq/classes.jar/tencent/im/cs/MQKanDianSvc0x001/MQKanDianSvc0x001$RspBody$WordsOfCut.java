package tencent.im.cs.MQKanDianSvc0x001;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MQKanDianSvc0x001$RspBody$WordsOfCut
  extends MessageMicro<WordsOfCut>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_str_words" }, new Object[] { "" }, WordsOfCut.class);
  public final PBRepeatField<String> rpt_str_words = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.MQKanDianSvc0x001.MQKanDianSvc0x001.RspBody.WordsOfCut
 * JD-Core Version:    0.7.0.1
 */
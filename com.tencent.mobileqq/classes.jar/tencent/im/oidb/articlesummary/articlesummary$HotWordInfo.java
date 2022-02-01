package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class articlesummary$HotWordInfo
  extends MessageMicro<HotWordInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_hot_word_item" }, new Object[] { null }, HotWordInfo.class);
  public final PBRepeatMessageField<articlesummary.HotWordItem> rpt_hot_word_item = PBField.initRepeatMessage(articlesummary.HotWordItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.HotWordInfo
 * JD-Core Version:    0.7.0.1
 */
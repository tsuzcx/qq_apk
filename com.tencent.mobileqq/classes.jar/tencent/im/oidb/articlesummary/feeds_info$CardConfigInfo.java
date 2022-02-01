package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class feeds_info$CardConfigInfo
  extends MessageMicro<CardConfigInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_pic_auto_play_type", "uint32_pic_show_type", "uint32_limit_word_lines", "uint32_show_next_button" }, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) }, CardConfigInfo.class);
  public final PBUInt32Field uint32_limit_word_lines = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_auto_play_type = PBField.initUInt32(1);
  public final PBUInt32Field uint32_pic_show_type = PBField.initUInt32(1);
  public final PBUInt32Field uint32_show_next_button = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.CardConfigInfo
 * JD-Core Version:    0.7.0.1
 */
package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class feeds_inner_define$MergedThemeMsg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 58 }, new String[] { "rpt_theme_msg" }, new Object[] { null }, MergedThemeMsg.class);
  public final PBRepeatMessageField rpt_theme_msg = PBField.initRepeatMessage(feeds_inner_define.ThemeMsgInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.trunk.feeds_inner_define.feeds_inner_define.MergedThemeMsg
 * JD-Core Version:    0.7.0.1
 */
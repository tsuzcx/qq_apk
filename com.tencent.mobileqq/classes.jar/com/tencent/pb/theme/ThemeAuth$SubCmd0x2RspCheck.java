package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ThemeAuth$SubCmd0x2RspCheck
  extends MessageMicro<SubCmd0x2RspCheck>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "int32_result" }, new Object[] { Integer.valueOf(0) }, SubCmd0x2RspCheck.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.SubCmd0x2RspCheck
 * JD-Core Version:    0.7.0.1
 */
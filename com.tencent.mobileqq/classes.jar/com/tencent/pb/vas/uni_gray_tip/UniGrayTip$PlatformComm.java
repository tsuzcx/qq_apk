package com.tencent.pb.vas.uni_gray_tip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class UniGrayTip$PlatformComm
  extends MessageMicro<PlatformComm>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "platForm", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, PlatformComm.class);
  public final PBStringField mqqver = PBField.initString("");
  public final PBStringField osver = PBField.initString("");
  public final PBInt64Field platForm = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.vas.uni_gray_tip.UniGrayTip.PlatformComm
 * JD-Core Version:    0.7.0.1
 */
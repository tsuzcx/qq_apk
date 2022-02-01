package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class VaProfileGate$QidInfoItem
  extends MessageMicro<QidInfoItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "qid", "url", "color", "logo_url" }, new Object[] { "", "", "", "" }, QidInfoItem.class);
  public final PBStringField color = PBField.initString("");
  public final PBStringField logo_url = PBField.initString("");
  public final PBStringField qid = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.profilecard.VaProfileGate.QidInfoItem
 * JD-Core Version:    0.7.0.1
 */
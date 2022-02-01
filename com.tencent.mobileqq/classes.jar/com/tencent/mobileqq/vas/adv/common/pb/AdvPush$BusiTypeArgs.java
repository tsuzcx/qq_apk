package com.tencent.mobileqq.vas.adv.common.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AdvPush$BusiTypeArgs
  extends MessageMicro<BusiTypeArgs>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "busi_type", "busi_args" }, new Object[] { Integer.valueOf(0), "" }, BusiTypeArgs.class);
  public final PBStringField busi_args = PBField.initString("");
  public final PBEnumField busi_type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.pb.AdvPush.BusiTypeArgs
 * JD-Core Version:    0.7.0.1
 */
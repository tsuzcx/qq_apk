package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class FeedsProtocol$TabRedPointRsp
  extends MessageMicro<TabRedPointRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "is_red" }, new Object[] { Boolean.valueOf(false) }, TabRedPointRsp.class);
  public final PBBoolField is_red = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.TabRedPointRsp
 * JD-Core Version:    0.7.0.1
 */
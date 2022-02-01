package com.tencent.pb.voiceChange;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class VipVoiceChange$subCmd0x1ReqAuth
  extends MessageMicro<subCmd0x1ReqAuth>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "int32_item_id" }, new Object[] { Integer.valueOf(0) }, subCmd0x1ReqAuth.class);
  public final PBInt32Field int32_item_id = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.voiceChange.VipVoiceChange.subCmd0x1ReqAuth
 * JD-Core Version:    0.7.0.1
 */
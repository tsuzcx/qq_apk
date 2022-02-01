package com.tencent.trpcprotocol.sweet.verification.judge;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SetQzoneDynamicNickReq
  extends MessageMicro<SetQzoneDynamicNickReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin", "module" }, new Object[] { Long.valueOf(0L), null }, SetQzoneDynamicNickReq.class);
  public DynamicNickModule module = new DynamicNickModule();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.sweet.verification.judge.SetQzoneDynamicNickReq
 * JD-Core Version:    0.7.0.1
 */
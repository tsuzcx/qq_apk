package com.tencent.trpcprotocol.sweet.verification.judge;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GetQzoneDynamicNickRsp
  extends MessageMicro<GetQzoneDynamicNickRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "module" }, new Object[] { null }, GetQzoneDynamicNickRsp.class);
  public DynamicNickModule module = new DynamicNickModule();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.sweet.verification.judge.GetQzoneDynamicNickRsp
 * JD-Core Version:    0.7.0.1
 */
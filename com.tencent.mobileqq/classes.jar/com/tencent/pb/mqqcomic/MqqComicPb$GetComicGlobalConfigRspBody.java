package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MqqComicPb$GetComicGlobalConfigRspBody
  extends MessageMicro<GetComicGlobalConfigRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "maintab" }, new Object[] { "" }, GetComicGlobalConfigRspBody.class);
  public final PBStringField maintab = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.mqqcomic.MqqComicPb.GetComicGlobalConfigRspBody
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SCUpdatePB$GetUrlRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18 }, new String[] { "update_list" }, new Object[] { null }, GetUrlRsp.class);
  public final PBRepeatMessageField update_list = PBField.initRepeatMessage(SCUpdatePB.UpdateInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB.GetUrlRsp
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CmShowContentUpdate$STContUpdReq
  extends MessageMicro<STContUpdReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "app_id", "cont_list" }, new Object[] { Integer.valueOf(0), null }, STContUpdReq.class);
  public final PBInt32Field app_id = PBField.initInt32(0);
  public final PBRepeatMessageField<CmShowContentUpdate.STContInfo> cont_list = PBField.initRepeatMessage(CmShowContentUpdate.STContInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.clubcontent.CmShowContentUpdate.STContUpdReq
 * JD-Core Version:    0.7.0.1
 */
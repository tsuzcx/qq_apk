package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CmShowContentUpdate$STContUpdRsp
  extends MessageMicro<STContUpdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "app_id", "domain_list", "cont_list", "intervals_ts" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0) }, STContUpdRsp.class);
  public final PBInt32Field app_id = PBField.initInt32(0);
  public final PBRepeatMessageField<CmShowContentUpdate.STVerInfo> cont_list = PBField.initRepeatMessage(CmShowContentUpdate.STVerInfo.class);
  public final PBRepeatMessageField<CmShowContentUpdate.STDomainInfo> domain_list = PBField.initRepeatMessage(CmShowContentUpdate.STDomainInfo.class);
  public final PBUInt32Field intervals_ts = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.clubcontent.CmShowContentUpdate.STContUpdRsp
 * JD-Core Version:    0.7.0.1
 */
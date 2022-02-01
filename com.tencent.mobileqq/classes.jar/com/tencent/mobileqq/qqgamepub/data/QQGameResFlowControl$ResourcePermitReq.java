package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQGameResFlowControl$ResourcePermitReq
  extends MessageMicro<ResourcePermitReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "res_url", "res_size" }, new Object[] { "", Integer.valueOf(0) }, ResourcePermitReq.class);
  public final PBUInt32Field res_size = PBField.initUInt32(0);
  public final PBStringField res_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl.ResourcePermitReq
 * JD-Core Version:    0.7.0.1
 */
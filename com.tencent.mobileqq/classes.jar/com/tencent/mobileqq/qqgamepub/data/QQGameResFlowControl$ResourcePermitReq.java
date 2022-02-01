package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQGameResFlowControl$ResourcePermitReq
  extends MessageMicro<ResourcePermitReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "resUrl", "resSize" }, new Object[] { "", Integer.valueOf(0) }, ResourcePermitReq.class);
  public final PBUInt32Field resSize = PBField.initUInt32(0);
  public final PBStringField resUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl.ResourcePermitReq
 * JD-Core Version:    0.7.0.1
 */
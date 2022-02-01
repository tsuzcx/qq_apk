package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQGameResFlowControl$ResourcePermitRsp
  extends MessageMicro<ResourcePermitRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "resState", "internalTime" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, ResourcePermitRsp.class);
  public final PBUInt64Field internalTime = PBField.initUInt64(0L);
  public final PBEnumField resState = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl.ResourcePermitRsp
 * JD-Core Version:    0.7.0.1
 */
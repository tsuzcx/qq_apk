package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class QQGameResFlowControl$DSLPermitRsp
  extends MessageMicro<DSLPermitRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "res_state" }, new Object[] { Integer.valueOf(0) }, DSLPermitRsp.class);
  public final PBEnumField res_state = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl.DSLPermitRsp
 * JD-Core Version:    0.7.0.1
 */
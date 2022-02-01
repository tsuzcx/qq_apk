package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class BusinessInfoCheckUpdate$LbsDispatchRspBody
  extends MessageMicro<LbsDispatchRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "iRetCode" }, new Object[] { Integer.valueOf(0) }, LbsDispatchRspBody.class);
  public final PBInt32Field iRetCode = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsDispatchRspBody
 * JD-Core Version:    0.7.0.1
 */
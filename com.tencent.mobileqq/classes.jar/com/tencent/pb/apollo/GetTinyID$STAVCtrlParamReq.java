package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GetTinyID$STAVCtrlParamReq
  extends MessageMicro<STAVCtrlParamReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "sdkAppId", "localVer" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, STAVCtrlParamReq.class);
  public final PBUInt32Field localVer = PBField.initUInt32(0);
  public final PBUInt32Field sdkAppId = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.apollo.GetTinyID.STAVCtrlParamReq
 * JD-Core Version:    0.7.0.1
 */
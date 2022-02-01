package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqavopensdkSsoTunnel$STAVCtrlParamReq
  extends MessageMicro<STAVCtrlParamReq>
{
  public static final int LOCALVER_FIELD_NUMBER = 2;
  public static final int SDKAPPID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field localVer = PBField.initUInt32(0);
  public final PBUInt32Field sdkAppId = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "sdkAppId", "localVer" }, new Object[] { localInteger, localInteger }, STAVCtrlParamReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAVCtrlParamReq
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqavopensdkSsoTunnel$STAVCtrlParamRsp
  extends MessageMicro<STAVCtrlParamRsp>
{
  public static final int CTRLPARAM_FIELD_NUMBER = 3;
  public static final int SVRVER_FIELD_NUMBER = 2;
  public static final int UPDATEFLAG_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField ctrlParam = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field svrVer = PBField.initUInt32(0);
  public final PBUInt32Field updateFlag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "updateFlag", "svrVer", "ctrlParam" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, STAVCtrlParamRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAVCtrlParamRsp
 * JD-Core Version:    0.7.0.1
 */
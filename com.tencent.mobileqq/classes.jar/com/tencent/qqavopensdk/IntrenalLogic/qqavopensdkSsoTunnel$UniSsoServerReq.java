package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqavopensdkSsoTunnel$UniSsoServerReq
  extends MessageMicro<UniSsoServerReq>
{
  public static final int COMM_FIELD_NUMBER = 1;
  public static final int PBREQDATA_FIELD_NUMBER = 3;
  public static final int REQDATA_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public qqavopensdkSsoTunnel.UniSsoServerReqComm comm = new qqavopensdkSsoTunnel.UniSsoServerReqComm();
  public final PBBytesField pbReqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField reqdata = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "comm", "reqdata", "pbReqData" }, new Object[] { null, "", localByteStringMicro }, UniSsoServerReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.UniSsoServerReq
 * JD-Core Version:    0.7.0.1
 */
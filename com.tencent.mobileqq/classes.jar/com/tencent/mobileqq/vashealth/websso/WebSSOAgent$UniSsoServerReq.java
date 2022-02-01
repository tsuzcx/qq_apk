package com.tencent.mobileqq.vashealth.websso;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WebSSOAgent$UniSsoServerReq
  extends MessageMicro<UniSsoServerReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public WebSSOAgent.UniSsoServerReqComm comm = new WebSSOAgent.UniSsoServerReqComm();
  public final PBBytesField pbReqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField reqdata = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "comm", "reqdata", "pbReqData" }, new Object[] { null, "", localByteStringMicro }, UniSsoServerReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.websso.WebSSOAgent.UniSsoServerReq
 * JD-Core Version:    0.7.0.1
 */
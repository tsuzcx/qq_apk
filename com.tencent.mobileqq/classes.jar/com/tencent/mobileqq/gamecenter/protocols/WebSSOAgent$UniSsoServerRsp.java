package com.tencent.mobileqq.gamecenter.protocols;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WebSSOAgent$UniSsoServerRsp
  extends MessageMicro<UniSsoServerRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public WebSSOAgent.UniSsoServerRspComm comm = new WebSSOAgent.UniSsoServerRspComm();
  public final PBStringField errmsg = PBField.initString("");
  public final PBBytesField pbRsqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field ret = PBField.initInt64(0L);
  public final PBStringField rspdata = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "ret", "errmsg", "comm", "rspdata", "pbRsqData" }, new Object[] { Long.valueOf(0L), "", null, "", localByteStringMicro }, UniSsoServerRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocols.WebSSOAgent.UniSsoServerRsp
 * JD-Core Version:    0.7.0.1
 */
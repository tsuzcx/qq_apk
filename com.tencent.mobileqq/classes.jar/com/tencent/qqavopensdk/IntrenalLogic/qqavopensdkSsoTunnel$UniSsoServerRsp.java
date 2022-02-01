package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqavopensdkSsoTunnel$UniSsoServerRsp
  extends MessageMicro<UniSsoServerRsp>
{
  public static final int COMM_FIELD_NUMBER = 3;
  public static final int ERRMSG_FIELD_NUMBER = 2;
  public static final int PBRSPDATA_FIELD_NUMBER = 5;
  public static final int RET_FIELD_NUMBER = 1;
  public static final int RSPDATA_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public qqavopensdkSsoTunnel.UniSsoServerRspComm comm = new qqavopensdkSsoTunnel.UniSsoServerRspComm();
  public final PBStringField errmsg = PBField.initString("");
  public final PBBytesField pbRspData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field ret = PBField.initInt64(0L);
  public final PBStringField rspdata = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "ret", "errmsg", "comm", "rspdata", "pbRspData" }, new Object[] { Long.valueOf(0L), "", null, "", localByteStringMicro }, UniSsoServerRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.UniSsoServerRsp
 * JD-Core Version:    0.7.0.1
 */
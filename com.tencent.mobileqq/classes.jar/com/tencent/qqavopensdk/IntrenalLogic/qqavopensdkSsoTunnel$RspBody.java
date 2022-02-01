package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class qqavopensdkSsoTunnel$RspBody
  extends MessageMicro<RspBody>
{
  public static final int BYTES_RSPBODY_FIELD_NUMBER = 2;
  public static final int MSG_CMD_ERROR_CODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rspbody = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqavopensdkSsoTunnel.CmdErrorCode msg_cmd_error_code = new qqavopensdkSsoTunnel.CmdErrorCode();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_cmd_error_code", "bytes_rspbody" }, new Object[] { null, localByteStringMicro }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.RspBody
 * JD-Core Version:    0.7.0.1
 */
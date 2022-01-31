package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class subcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf
  extends MessageMicro<DownloadEncryptConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "bool_enable_encrypt_request", "bool_enable_encrypted_pic", "uint32_ctrl_flag" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0) }, DownloadEncryptConf.class);
  public final PBBoolField bool_enable_encrypt_request = PBField.initBool(false);
  public final PBBoolField bool_enable_encrypted_pic = PBField.initBool(false);
  public final PBUInt32Field uint32_ctrl_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf
 * JD-Core Version:    0.7.0.1
 */
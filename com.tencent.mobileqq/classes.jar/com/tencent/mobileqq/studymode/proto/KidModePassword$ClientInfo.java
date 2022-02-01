package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class KidModePassword$ClientInfo
  extends MessageMicro<ClientInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField client_addr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField client_version = PBField.initString("");
  public final PBStringField guid = PBField.initString("");
  public final PBEnumField platform = PBField.initEnum(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "client_addr", "platform", "client_version", "guid" }, new Object[] { localByteStringMicro, Integer.valueOf(0), "", "" }, ClientInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.proto.KidModePassword.ClientInfo
 * JD-Core Version:    0.7.0.1
 */
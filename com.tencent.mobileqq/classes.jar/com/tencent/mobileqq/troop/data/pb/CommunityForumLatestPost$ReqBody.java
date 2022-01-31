package com.tencent.mobileqq.troop.data.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CommunityForumLatestPost$ReqBody
  extends MessageMicro
{
  public static final int CLIENT_VERSION_FIELD_NUMBER = 3;
  public static final int OS_FIELD_NUMBER = 2;
  public static final int TROOP_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public static final ReqBody __repeatHelper__ = new ReqBody();
  public final PBBytesField client_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField os = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field troop_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "troop_uin", "os", "client_version" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.pb.CommunityForumLatestPost.ReqBody
 * JD-Core Version:    0.7.0.1
 */
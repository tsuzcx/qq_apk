package com.tencent.mobileqq.troop.data.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CommunityForumLatestPost$RspBody
  extends MessageMicro
{
  public static final int LATEST_POST_FIELD_NUMBER = 4;
  public static final int REQUEST_PARAMS_FIELD_NUMBER = 3;
  public static final int TROOP_TYPE_FIELD_NUMBER = 1;
  public static final int TROOP_TYPE_NAME_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public static final RspBody __repeatHelper__ = new RspBody();
  public final PBBytesField latest_post = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField request_params = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field troop_type = PBField.initUInt32(0);
  public final PBBytesField troop_type_name = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "troop_type", "troop_type_name", "request_params", "latest_post" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.pb.CommunityForumLatestPost.RspBody
 * JD-Core Version:    0.7.0.1
 */
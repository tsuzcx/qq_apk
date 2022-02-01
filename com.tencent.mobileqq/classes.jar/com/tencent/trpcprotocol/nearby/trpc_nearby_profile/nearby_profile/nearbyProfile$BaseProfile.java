package com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbyProfile$BaseProfile
  extends MessageMicro<BaseProfile>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field age = PBField.initUInt32(0);
  public final PBBytesField birthday = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field gender = PBField.initUInt32(0);
  public nearbyProfile.Location location = new nearbyProfile.Location();
  public final PBStringField logo = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public nearbyProfile.PhotoWall photo_wall = new nearbyProfile.PhotoWall();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 802, 810 }, new String[] { "nick", "logo", "gender", "birthday", "age", "location", "photo_wall" }, new Object[] { "", "", localInteger, localByteStringMicro, localInteger, null, null }, BaseProfile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.BaseProfile
 * JD-Core Version:    0.7.0.1
 */
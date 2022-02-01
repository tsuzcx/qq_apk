package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserInfo$LocationInfo
  extends MessageMicro<LocationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field city = PBField.initUInt32(0);
  public final PBUInt32Field country = PBField.initUInt32(0);
  public final PBUInt32Field district = PBField.initUInt32(0);
  public final PBUInt32Field province = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "country", "province", "city", "district" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, LocationInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.LocationInfo
 * JD-Core Version:    0.7.0.1
 */
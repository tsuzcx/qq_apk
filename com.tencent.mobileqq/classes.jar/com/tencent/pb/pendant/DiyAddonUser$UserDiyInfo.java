package com.tencent.pb.pendant;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DiyAddonUser$UserDiyInfo
  extends MessageMicro<UserDiyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field curid = PBField.initInt32(0);
  public final PBUInt32Field frameid = PBField.initUInt32(0);
  public final PBRepeatMessageField<DiyAddonUser.UserStickerInfo> stickerinfo = PBField.initRepeatMessage(DiyAddonUser.UserStickerInfo.class);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt64Field updatets = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uin", "curid", "frameid", "stickerinfo", "updatets" }, new Object[] { localLong, localInteger, localInteger, null, localLong }, UserDiyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.pendant.DiyAddonUser.UserDiyInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipMusicBox$GetProfileMusicBoxInfoReq
  extends MessageMicro<GetProfileMusicBoxInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin" }, new Object[] { Long.valueOf(0L) }, GetProfileMusicBoxInfoReq.class);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.profilecard.VipMusicBox.GetProfileMusicBoxInfoReq
 * JD-Core Version:    0.7.0.1
 */
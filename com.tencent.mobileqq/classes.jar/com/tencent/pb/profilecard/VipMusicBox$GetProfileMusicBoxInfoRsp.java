package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class VipMusicBox$GetProfileMusicBoxInfoRsp
  extends MessageMicro<GetProfileMusicBoxInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "music", "is_visible" }, new Object[] { null, Boolean.valueOf(false) }, GetProfileMusicBoxInfoRsp.class);
  public final PBBoolField is_visible = PBField.initBool(false);
  public VipMusicBox.ProfileMusicInfo music = new VipMusicBox.ProfileMusicInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.profilecard.VipMusicBox.GetProfileMusicBoxInfoRsp
 * JD-Core Version:    0.7.0.1
 */
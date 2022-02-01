package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VipMusicBox$ProfileMusicInfo
  extends MessageMicro<ProfileMusicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48 }, new String[] { "song_id", "song_name", "album_name", "singer_list", "pic", "duration" }, new Object[] { "", "", "", null, "", Integer.valueOf(0) }, ProfileMusicInfo.class);
  public final PBStringField album_name = PBField.initString("");
  public final PBUInt32Field duration = PBField.initUInt32(0);
  public final PBStringField pic = PBField.initString("");
  public final PBRepeatMessageField<VipMusicBox.ProfileSingerInfo> singer_list = PBField.initRepeatMessage(VipMusicBox.ProfileSingerInfo.class);
  public final PBStringField song_id = PBField.initString("");
  public final PBStringField song_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.profilecard.VipMusicBox.ProfileMusicInfo
 * JD-Core Version:    0.7.0.1
 */
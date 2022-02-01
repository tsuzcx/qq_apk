package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class UserInfo$SetMiniUserInfoReq
  extends MessageMicro<SetMiniUserInfoReq>
{
  public static final int AchievementsID = 9;
  public static final int AvatarID = 2;
  public static final int BaseInfoID = 1;
  public static final int ExpandInfoID = 3;
  public static final int IdolsID = 10;
  public static final int LongNickID = 5;
  public static final int MatchSrcID = 6;
  public static final int PersonalLabelsID = 4;
  public static final int PicturesWallID = 12;
  public static final int QuestionAndAnswerListID = 8;
  public static final int Reserve = 0;
  public static final int SelectedPicID = 7;
  public static final int WangzheRecordID = 11;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "mini_info_ids", "infos" }, new Object[] { Integer.valueOf(0), null }, SetMiniUserInfoReq.class);
  public UserInfo.MiniInfo infos = new UserInfo.MiniInfo();
  public final PBRepeatField<Integer> mini_info_ids = PBField.initRepeat(PBEnumField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.SetMiniUserInfoReq
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserInfo$MiniInfo
  extends MessageMicro<MiniInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 8034 }, new String[] { "base_info", "avatar", "expand_info", "personal_labels", "long_nick", "match_src", "selected_pic", "question_and_answer_list", "achievements", "idols", "wangzhe_record", "pictures_wall_urls", "personalized_labels" }, new Object[] { null, "", null, "", "", null, "", null, null, null, null, null, null }, MiniInfo.class);
  public final PBRepeatMessageField<UserInfo.Achievements> achievements = PBField.initRepeatMessage(UserInfo.Achievements.class);
  public final PBStringField avatar = PBField.initString("");
  public UserInfo.BaseInfo base_info = new UserInfo.BaseInfo();
  public UserInfo.ExpandInfo expand_info = new UserInfo.ExpandInfo();
  public final PBRepeatMessageField<UserInfo.Idols> idols = PBField.initRepeatMessage(UserInfo.Idols.class);
  public final PBStringField long_nick = PBField.initString("");
  public UserInfo.MatchSrc match_src = new UserInfo.MatchSrc();
  public final PBRepeatField<String> personal_labels = PBField.initRepeat(PBStringField.__repeatHelper__);
  public UserInfo.PersonalizedLabels personalized_labels = new UserInfo.PersonalizedLabels();
  public UserInfo.PicturesWall pictures_wall_urls = new UserInfo.PicturesWall();
  public UserInfo.QuestionAndAnswerList question_and_answer_list = new UserInfo.QuestionAndAnswerList();
  public final PBRepeatField<String> selected_pic = PBField.initRepeat(PBStringField.__repeatHelper__);
  public UserInfo.WangzheRecord wangzhe_record = new UserInfo.WangzheRecord();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.userInfo.userInfo.UserInfo.MiniInfo
 * JD-Core Version:    0.7.0.1
 */
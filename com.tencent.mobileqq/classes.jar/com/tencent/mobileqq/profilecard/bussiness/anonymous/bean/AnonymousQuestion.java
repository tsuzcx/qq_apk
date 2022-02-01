package com.tencent.mobileqq.profilecard.bussiness.anonymous.bean;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.Quest;

public class AnonymousQuestion
{
  private static final String TAG = "AnonymousQuestion";
  public String mAnswer;
  public long mAnswerTime;
  public String mId;
  public long mOwnerUin;
  public String mPraiseKey;
  public boolean mPraised;
  public boolean mPrivate;
  public String mQuest;
  public long mQuestTime;
  public long mQuestUin;
  public long mTotalCommentCount;
  public long mTotalPraiseCount;
  public long mTotalViewCount;
  public int uiState = 0;
  
  public static AnonymousQuestion convertQuest(oidb_0xec4.Quest paramQuest, long paramLong)
  {
    for (;;)
    {
      try
      {
        AnonymousQuestion localAnonymousQuestion = new AnonymousQuestion();
        localAnonymousQuestion.mId = paramQuest.str_id.get();
        localAnonymousQuestion.mQuest = paramQuest.str_quest.get();
        localAnonymousQuestion.mQuestUin = paramQuest.uint64_quest_uin.get();
        localAnonymousQuestion.mQuestTime = paramQuest.uint64_time.get();
        localAnonymousQuestion.mOwnerUin = paramLong;
        paramLong = paramQuest.uint64_show_type.get();
        boolean bool2 = false;
        if (paramLong == 1L)
        {
          bool1 = true;
          localAnonymousQuestion.mPrivate = bool1;
          localAnonymousQuestion.mAnswer = paramQuest.str_ans.get();
          localAnonymousQuestion.mAnswerTime = paramQuest.uint64_ans_time.get();
          localAnonymousQuestion.mPraiseKey = paramQuest.str_like_key.get();
          bool1 = bool2;
          if (paramQuest.uint64_been_praised.get() == 1L) {
            bool1 = true;
          }
          localAnonymousQuestion.mPraised = bool1;
          localAnonymousQuestion.mTotalPraiseCount = paramQuest.uint64_praise_num.get();
          localAnonymousQuestion.mTotalCommentCount = paramQuest.uint64_comment_num.get();
          localAnonymousQuestion.mTotalViewCount = paramQuest.uint64_show_times.get();
          return localAnonymousQuestion;
        }
      }
      catch (Exception paramQuest)
      {
        QLog.e("AnonymousQuestion", 1, "convertQuest fail.", paramQuest);
        return null;
      }
      boolean bool1 = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AnonymousQuestion{mId='");
    localStringBuilder.append(this.mId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mQuestUin='");
    localStringBuilder.append(this.mQuestUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mQuestTime='");
    localStringBuilder.append(this.mQuestTime);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mOwnerUin='");
    localStringBuilder.append(this.mOwnerUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPrivate='");
    localStringBuilder.append(this.mPrivate);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mAnswer='");
    localStringBuilder.append(this.mAnswer);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mAnswerTime='");
    localStringBuilder.append(this.mAnswerTime);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPraiseKey='");
    localStringBuilder.append(this.mPraiseKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPraised='");
    localStringBuilder.append(this.mPraised);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mTotalPraiseCount='");
    localStringBuilder.append(this.mTotalPraiseCount);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mTotalCommentCount='");
    localStringBuilder.append(this.mTotalCommentCount);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mTotalViewCount='");
    localStringBuilder.append(this.mTotalViewCount);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion
 * JD-Core Version:    0.7.0.1
 */
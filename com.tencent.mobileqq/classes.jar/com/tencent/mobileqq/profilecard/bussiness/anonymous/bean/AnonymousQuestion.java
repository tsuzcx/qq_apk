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
    boolean bool2 = false;
    try
    {
      AnonymousQuestion localAnonymousQuestion = new AnonymousQuestion();
      localAnonymousQuestion.mId = paramQuest.str_id.get();
      localAnonymousQuestion.mQuest = paramQuest.str_quest.get();
      localAnonymousQuestion.mQuestUin = paramQuest.uint64_quest_uin.get();
      localAnonymousQuestion.mQuestTime = paramQuest.uint64_time.get();
      localAnonymousQuestion.mOwnerUin = paramLong;
      if (paramQuest.uint64_show_type.get() == 1L) {}
      for (boolean bool1 = true;; bool1 = false)
      {
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
      return null;
    }
    catch (Exception paramQuest)
    {
      QLog.e("AnonymousQuestion", 1, "convertQuest fail.", paramQuest);
    }
  }
  
  public String toString()
  {
    return "AnonymousQuestion{mId='" + this.mId + '\'' + ", mQuestUin='" + this.mQuestUin + '\'' + ", mQuestTime='" + this.mQuestTime + '\'' + ", mOwnerUin='" + this.mOwnerUin + '\'' + ", mPrivate='" + this.mPrivate + '\'' + ", mAnswer='" + this.mAnswer + '\'' + ", mAnswerTime='" + this.mAnswerTime + '\'' + ", mPraiseKey='" + this.mPraiseKey + '\'' + ", mPraised='" + this.mPraised + '\'' + ", mTotalPraiseCount='" + this.mTotalPraiseCount + '\'' + ", mTotalCommentCount='" + this.mTotalCommentCount + '\'' + ", mTotalViewCount='" + this.mTotalViewCount + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.profilecard.bussiness.anonymous;

import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import java.util.ArrayList;
import java.util.List;

public class ProfileAnonymousAnswerInfo
  implements IProfileBusinessInfo
{
  public static final int REQUEST_FETCH_TYPE = 1;
  public static final int REQUEST_QUESTION_SIZE = 10;
  public List<AnonymousQuestion> mAnonymousQuestions = new ArrayList();
  public int mAnsweredQuestionCount = 0;
  public boolean mHasFetchOver = true;
  public int mTotalQuestionCount = 0;
  public boolean needForbidEntry;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.ProfileAnonymousAnswerInfo
 * JD-Core Version:    0.7.0.1
 */
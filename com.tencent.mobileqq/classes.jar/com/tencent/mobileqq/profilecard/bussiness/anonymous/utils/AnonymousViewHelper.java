package com.tencent.mobileqq.profilecard.bussiness.anonymous.utils;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousHandler;

public class AnonymousViewHelper
{
  public static final int PARAM_TYPE_FROM_AIO = 4;
  public static final int PARAM_TYPE_FROM_ANSWER = 3;
  public static final int PARAM_TYPE_FROM_CARD = 6;
  public static final int PARAM_TYPE_FROM_CARD_ITEM = 8;
  public static final int PARAM_TYPE_FROM_COMMENT = 7;
  public static final int PARAM_TYPE_FROM_QZONE = 5;
  public static final int PARAM_TYPE_FROM_TITLE = 1;
  public static final int PARAM_TYPE_FROM_TOFU_AIO_MINI_PROFILE_CARD = 9;
  public static final int PARAM_TYPE_FROM_TOFU_ASK_ANONYMOUSLY = 10;
  public static final int PARAM_TYPE_FROM_TOFU_ASK_ANONYMOUSLY_COMMENT = 11;
  public static final int PARAM_TYPE_FROM_TOTAL = 2;
  public static final int RESULT_CODE = 4660;
  public static final String TAG = "AnonymousViewHelper";
  private static final String WEB_URL_ASK_QUES = "https://ti.qq.com/v2/anonymous/question?_wv=16777218&_wwv=129&uin=%s&from=%d";
  private static final String WEB_URL_QUES_DETAIL = "https://ti.qq.com/v2/anonymous/detail?_wv=16777218&_wwv=129&uin=%s&qid=%s&cid=%s&from=%d&qtime=%d";
  private static final String WEB_URL_QUES_LIST_AND_ANSWER = "https://ti.qq.com/v2/anonymous/answer?_wv=16777218&_wwv=129&uin=%s&from=%d";
  
  public static void jumpToAnonymousDetail(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      str = "0";
    }
    paramString3 = String.format("https://ti.qq.com/v2/anonymous/detail?_wv=16777218&_wwv=129&uin=%s&qid=%s&cid=%s&from=%d&qtime=%d", new Object[] { paramString1, paramString2, str, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    localIntent.putExtra("url", paramString3);
    paramBaseActivity.startActivityForResult(localIntent, 4660);
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousViewHelper", 0, String.format("jumpToAnonymousDetail() uin=%s qId=%s cId=%s form=%d url =%s", new Object[] { paramString1, paramString2, str, Integer.valueOf(paramInt), paramString3 }));
    }
  }
  
  public static void jumpToAskQuestion(BaseActivity paramBaseActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
    String str = String.format("https://ti.qq.com/v2/anonymous/question?_wv=16777218&_wwv=129&uin=%s&from=%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    localIntent.putExtra("url", str);
    paramBaseActivity.startActivityForResult(localIntent, 4660);
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousViewHelper", 0, String.format("jumpToAskQuestion() uin=%s from=%d url =%s", new Object[] { paramString, Integer.valueOf(paramInt), str }));
    }
  }
  
  public static void jumpToComment(BaseActivity paramBaseActivity, String paramString1, String paramString2, long paramLong)
  {
    jumpToAnonymousDetail(paramBaseActivity, paramString1, paramString2, "", 7, paramLong);
  }
  
  public static void jumpToQuestionListAndAnswer(BaseActivity paramBaseActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
    String str = String.format("https://ti.qq.com/v2/anonymous/answer?_wv=16777218&_wwv=129&uin=%s&from=%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    localIntent.putExtra("url", str);
    paramBaseActivity.startActivityForResult(localIntent, 4660);
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousViewHelper", 0, String.format("jumpToQuestionListAndAnswer() uin=%s from=%d url =%s", new Object[] { paramString, Integer.valueOf(paramInt), str }));
    }
  }
  
  public static void jumpToReqFriendAskQuestion(BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousViewHelper", 0, "jumpToReqFriendAskQuestion()");
    }
    AskAnonymouslyUtil.Companion.inviteAskAnonymously(paramBaseActivity, true);
  }
  
  public static void onClickLike(QQAppInterface paramQQAppInterface, AnonymousQuestion paramAnonymousQuestion)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousViewHelper", 0, "before onClickLike() question.mPraised = " + paramAnonymousQuestion.mPraised);
    }
    paramQQAppInterface = (AnonymousHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ANONYMOUS_ANSWER_HANDLER);
    if (!paramAnonymousQuestion.mPraised) {
      bool = true;
    }
    paramQQAppInterface.likeAnonymousAnswer(paramAnonymousQuestion, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper
 * JD-Core Version:    0.7.0.1
 */
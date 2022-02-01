package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/data/MessageForTofuAskAnonymously;", "Lcom/tencent/mobileqq/data/ChatMessage;", "()V", "askAnonymouslyQuestion", "Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/bean/AnonymousQuestion;", "getAskAnonymouslyQuestion", "()Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/bean/AnonymousQuestion;", "setAskAnonymouslyQuestion", "(Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/bean/AnonymousQuestion;)V", "doParse", "", "parseJsonToAnonymousQuestion", "jsonStr", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class MessageForTofuAskAnonymously
  extends ChatMessage
{
  public static final MessageForTofuAskAnonymously.Companion Companion = new MessageForTofuAskAnonymously.Companion(null);
  @NotNull
  public static final String TAG = "MessageForTofuAskAnonymously";
  @Nullable
  private AnonymousQuestion askAnonymouslyQuestion;
  
  public MessageForTofuAskAnonymously()
  {
    this.msgtype = -7012;
    this.mNeedTimeStamp = false;
  }
  
  private final AnonymousQuestion parseJsonToAnonymousQuestion(String paramString)
  {
    boolean bool = false;
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = new JSONObject(paramString);
        AnonymousQuestion localAnonymousQuestion = new AnonymousQuestion();
        localAnonymousQuestion.mId = paramString.optString("key_question_id", "");
        localAnonymousQuestion.mQuest = paramString.optString("key_question_str", "");
        localAnonymousQuestion.mQuestUin = paramString.optLong("key_question_uin", -1L);
        localAnonymousQuestion.mQuestTime = paramString.optLong("key_question_time", -1L);
        localAnonymousQuestion.mAnswer = paramString.optString("key_answer_str", "");
        localAnonymousQuestion.mAnswerTime = paramString.optLong("key_answer_time", -1L);
        localAnonymousQuestion.mPraiseKey = paramString.optString("key_praise_key", "");
        if (paramString.optInt("key_been_praise", 0) == 1) {
          bool = true;
        }
        localAnonymousQuestion.mPraised = bool;
        localAnonymousQuestion.mTotalPraiseCount = paramString.optLong("key_praise_num", -1L);
        localAnonymousQuestion.mTotalCommentCount = paramString.optLong("key_comment_num", -1L);
        localAnonymousQuestion.mTotalViewCount = paramString.optLong("key_show_times", -1L);
        paramString = localAnonymousQuestion;
        if (QLog.isColorLevel())
        {
          QLog.i("MessageForTofuAskAnonymously", 2, "parseJsonToAnonymousQuestion result: " + localAnonymousQuestion);
          return localAnonymousQuestion;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("MessageForTofuAskAnonymously", 1, "parseJsonToAnonymousQuestion exception: ", (Throwable)paramString);
      }
    }
    return null;
  }
  
  protected void doParse()
  {
    String str = this.msg;
    Intrinsics.checkExpressionValueIsNotNull(str, "msg");
    this.askAnonymouslyQuestion = parseJsonToAnonymousQuestion(str);
    this.isread = true;
  }
  
  @Nullable
  public final AnonymousQuestion getAskAnonymouslyQuestion()
  {
    return this.askAnonymouslyQuestion;
  }
  
  public final void setAskAnonymouslyQuestion(@Nullable AnonymousQuestion paramAnonymousQuestion)
  {
    this.askAnonymouslyQuestion = paramAnonymousQuestion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTofuAskAnonymously
 * JD-Core Version:    0.7.0.1
 */
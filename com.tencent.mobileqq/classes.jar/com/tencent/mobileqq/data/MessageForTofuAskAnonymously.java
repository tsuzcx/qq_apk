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
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return null;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = new AnonymousQuestion();
      paramString.mId = ((JSONObject)localObject).optString("key_question_id", "");
      paramString.mQuest = ((JSONObject)localObject).optString("key_question_str", "");
      paramString.mQuestUin = ((JSONObject)localObject).optLong("key_question_uin", -1L);
      paramString.mQuestTime = ((JSONObject)localObject).optLong("key_question_time", -1L);
      paramString.mAnswer = ((JSONObject)localObject).optString("key_answer_str", "");
      paramString.mAnswerTime = ((JSONObject)localObject).optLong("key_answer_time", -1L);
      paramString.mPraiseKey = ((JSONObject)localObject).optString("key_praise_key", "");
      boolean bool = false;
      if (((JSONObject)localObject).optInt("key_been_praise", 0) == 1) {
        bool = true;
      }
      paramString.mPraised = bool;
      paramString.mTotalPraiseCount = ((JSONObject)localObject).optLong("key_praise_num", -1L);
      paramString.mTotalCommentCount = ((JSONObject)localObject).optLong("key_comment_num", -1L);
      paramString.mTotalViewCount = ((JSONObject)localObject).optLong("key_show_times", -1L);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseJsonToAnonymousQuestion result: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("MessageForTofuAskAnonymously", 2, ((StringBuilder)localObject).toString());
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("MessageForTofuAskAnonymously", 1, "parseJsonToAnonymousQuestion exception: ", (Throwable)paramString);
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
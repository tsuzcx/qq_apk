package com.tencent.mobileqq.data;

import android.text.TextUtils;
import arva;
import azzl;
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
  public static final arva Companion = new arva(null);
  @NotNull
  public static final String TAG = "MessageForTofuAskAnonymously";
  @Nullable
  private azzl askAnonymouslyQuestion;
  
  public MessageForTofuAskAnonymously()
  {
    this.msgtype = -7012;
    this.mNeedTimeStamp = false;
  }
  
  private final azzl parseJsonToAnonymousQuestion(String paramString)
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
        azzl localazzl = new azzl();
        localazzl.jdField_a_of_type_JavaLangString = paramString.optString("key_question_id", "");
        localazzl.jdField_b_of_type_JavaLangString = paramString.optString("key_question_str", "");
        localazzl.jdField_a_of_type_Long = paramString.optLong("key_question_uin", -1L);
        localazzl.jdField_b_of_type_Long = paramString.optLong("key_question_time", -1L);
        localazzl.c = paramString.optString("key_answer_str", "");
        localazzl.jdField_d_of_type_Long = paramString.optLong("key_answer_time", -1L);
        localazzl.jdField_d_of_type_JavaLangString = paramString.optString("key_praise_key", "");
        if (paramString.optInt("key_been_praise", 0) == 1) {
          bool = true;
        }
        localazzl.jdField_b_of_type_Boolean = bool;
        localazzl.e = paramString.optLong("key_praise_num", -1L);
        localazzl.f = paramString.optLong("key_comment_num", -1L);
        localazzl.g = paramString.optLong("key_show_times", -1L);
        paramString = localazzl;
        if (QLog.isColorLevel())
        {
          QLog.i("MessageForTofuAskAnonymously", 2, "parseJsonToAnonymousQuestion result: " + localazzl);
          return localazzl;
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
  public final azzl getAskAnonymouslyQuestion()
  {
    return this.askAnonymouslyQuestion;
  }
  
  public final void setAskAnonymouslyQuestion(@Nullable azzl paramazzl)
  {
    this.askAnonymouslyQuestion = paramazzl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTofuAskAnonymously
 * JD-Core Version:    0.7.0.1
 */
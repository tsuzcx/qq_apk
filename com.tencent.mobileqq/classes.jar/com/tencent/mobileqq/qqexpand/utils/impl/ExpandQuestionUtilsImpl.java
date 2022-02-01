package com.tencent.mobileqq.qqexpand.utils.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/impl/ExpandQuestionUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/utils/IExpandQuestionUtils;", "()V", "needAnswerQuestion", "", "uin", "", "setAnswerQuestionFlag", "", "flag", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandQuestionUtilsImpl
  implements IExpandQuestionUtils
{
  public static final ExpandQuestionUtilsImpl.Companion Companion = new ExpandQuestionUtilsImpl.Companion(null);
  @NotNull
  public static final String SP_EXTEND_FRIEND_ENTRY_QUESTION = "sp_extend_friend_question";
  @NotNull
  public static final String TAG = "ExpandQuestionUtilsImpl";
  
  public boolean needAnswerQuestion(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    boolean bool = SharedPreUtils.g(paramString).getBoolean("sp_extend_friend_question", true);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("needAnswerQuestion: ");
      paramString.append(bool);
      QLog.d("ExpandQuestionUtilsImpl", 2, paramString.toString());
    }
    return bool;
  }
  
  public void setAnswerQuestionFlag(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    if (QLog.isColorLevel())
    {
      Object localObject = StringCompanionObject.INSTANCE;
      localObject = new Object[2];
      localObject[0] = paramString;
      localObject[1] = Boolean.valueOf(paramBoolean);
      localObject = String.format("setAnswerQuestionFlag, uin: %s, flag: %s", Arrays.copyOf((Object[])localObject, localObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      QLog.d("ExpandQuestionUtilsImpl", 2, (String)localObject);
    }
    SharedPreUtils.g(paramString).edit().putBoolean("sp_extend_friend_question", paramBoolean).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.ExpandQuestionUtilsImpl
 * JD-Core Version:    0.7.0.1
 */
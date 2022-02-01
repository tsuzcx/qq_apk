package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/IExpandQuestionUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "needAnswerQuestion", "", "uin", "", "setAnswerQuestionFlag", "", "flag", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandQuestionUtils
  extends QRouteApi
{
  public abstract boolean needAnswerQuestion(@NotNull String paramString);
  
  public abstract void setAnswerQuestionFlag(@NotNull String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils
 * JD-Core Version:    0.7.0.1
 */
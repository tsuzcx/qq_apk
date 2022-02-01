package com.tencent.mobileqq.education.request.callback;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/request/callback/IStudyUploadCallback;", "", "onUploadFinish", "", "isSuc", "", "errorCode", "", "errorMsg", "", "url", "qq-education-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IStudyUploadCallback
{
  public abstract void a(boolean paramBoolean, int paramInt, @NotNull String paramString1, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.callback.IStudyUploadCallback
 * JD-Core Version:    0.7.0.1
 */
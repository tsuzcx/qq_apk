package com.tencent.mobileqq.education.request;

import com.tencent.mobileqq.education.request.callback.IStudyUploadCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/request/IStudyMainProcessAbility;", "", "onDestroy", "", "uploadFile", "filePath", "", "callback", "Lcom/tencent/mobileqq/education/request/callback/IStudyUploadCallback;", "qq-education-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IStudyMainProcessAbility
{
  public abstract void a(@NotNull String paramString, @Nullable IStudyUploadCallback paramIStudyUploadCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.IStudyMainProcessAbility
 * JD-Core Version:    0.7.0.1
 */
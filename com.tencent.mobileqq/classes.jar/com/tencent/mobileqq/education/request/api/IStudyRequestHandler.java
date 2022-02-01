package com.tencent.mobileqq.education.request.api;

import com.tencent.mobileqq.education.request.callback.IStudyCmdCallback;
import com.tencent.mobileqq.education.request.callback.IStudyUploadCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/request/api/IStudyRequestHandler;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "sendSSORequest", "", "appInterface", "Lmqq/app/AppRuntime;", "cmdString", "", "buffer", "", "timeOutSecond", "", "callback", "Lcom/tencent/mobileqq/education/request/callback/IStudyCmdCallback;", "uploadFileRequest", "filePath", "Lcom/tencent/mobileqq/education/request/callback/IStudyUploadCallback;", "qq-education-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IStudyRequestHandler
  extends QRouteApi
{
  public abstract void sendSSORequest(@NotNull AppRuntime paramAppRuntime, @Nullable String paramString, @Nullable byte[] paramArrayOfByte, int paramInt, @Nullable IStudyCmdCallback paramIStudyCmdCallback);
  
  public abstract void uploadFileRequest(@NotNull AppRuntime paramAppRuntime, @NotNull String paramString, @Nullable IStudyUploadCallback paramIStudyUploadCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.api.IStudyRequestHandler
 * JD-Core Version:    0.7.0.1
 */
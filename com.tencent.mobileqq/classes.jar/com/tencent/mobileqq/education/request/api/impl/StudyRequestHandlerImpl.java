package com.tencent.mobileqq.education.request.api.impl;

import com.tencent.mobileqq.education.request.IStudyMainProcessAbility;
import com.tencent.mobileqq.education.request.StudyCmdHandler;
import com.tencent.mobileqq.education.request.api.IStudyRequestHandler;
import com.tencent.mobileqq.education.request.api.IStudyRuntimeService;
import com.tencent.mobileqq.education.request.callback.IStudyCmdCallback;
import com.tencent.mobileqq.education.request.callback.IStudyUploadCallback;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/request/api/impl/StudyRequestHandlerImpl;", "Lcom/tencent/mobileqq/education/request/api/IStudyRequestHandler;", "()V", "sendSSORequest", "", "appInterface", "Lmqq/app/AppRuntime;", "cmdString", "", "buffer", "", "timeOutSecond", "", "callback", "Lcom/tencent/mobileqq/education/request/callback/IStudyCmdCallback;", "uploadFileRequest", "filePath", "Lcom/tencent/mobileqq/education/request/callback/IStudyUploadCallback;", "Companion", "qq_education_impl_release"}, k=1, mv={1, 1, 16})
public final class StudyRequestHandlerImpl
  implements IStudyRequestHandler
{
  public static final StudyRequestHandlerImpl.Companion Companion = new StudyRequestHandlerImpl.Companion(null);
  @NotNull
  public static final String TAG = "StudyCmdHandlerImpl";
  
  public void sendSSORequest(@NotNull AppRuntime paramAppRuntime, @Nullable String paramString, @Nullable byte[] paramArrayOfByte, int paramInt, @Nullable IStudyCmdCallback paramIStudyCmdCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appInterface");
    paramAppRuntime = paramAppRuntime.getRuntimeService(IStudyRuntimeService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(paramAppRuntime, "appInterface.getRuntimeS…ava, ProcessConstant.ALL)");
    paramAppRuntime = ((IStudyRuntimeService)paramAppRuntime).getCmdHandler();
    if (paramAppRuntime != null)
    {
      ((StudyCmdHandler)paramAppRuntime).a(paramString, paramArrayOfByte, paramInt, paramIStudyCmdCallback);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.education.request.StudyCmdHandler");
  }
  
  public void uploadFileRequest(@NotNull AppRuntime paramAppRuntime, @NotNull String paramString, @Nullable IStudyUploadCallback paramIStudyUploadCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appInterface");
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    paramAppRuntime = paramAppRuntime.getRuntimeService(IStudyRuntimeService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(paramAppRuntime, "appInterface.getRuntimeS…ava, ProcessConstant.ALL)");
    ((IStudyRuntimeService)paramAppRuntime).getMainProcessAbility().a(paramString, paramIStudyUploadCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.api.impl.StudyRequestHandlerImpl
 * JD-Core Version:    0.7.0.1
 */
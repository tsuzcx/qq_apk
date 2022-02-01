package com.tencent.mobileqq.education.request;

import android.os.Bundle;
import com.tencent.mobileqq.education.request.callback.IStudyUploadCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/request/StudyMainProcessAbility;", "Lcom/tencent/mobileqq/education/request/IStudyMainProcessAbility;", "()V", "getIpcClient", "Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi;", "handleUploadFileEvent", "", "resp", "Landroid/os/Bundle;", "callback", "Lcom/tencent/mobileqq/education/request/callback/IStudyUploadCallback;", "onDestroy", "uploadFile", "filePath", "", "Companion", "qq_education_impl_release"}, k=1, mv={1, 1, 16})
public final class StudyMainProcessAbility
  implements IStudyMainProcessAbility
{
  public static final StudyMainProcessAbility.Companion a = new StudyMainProcessAbility.Companion(null);
  
  public StudyMainProcessAbility()
  {
    QRouteApi localQRouteApi = QRoute.api(ITroopMemberApiClientApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(ITroopMemberApiClientApi::class.java)");
    ((ITroopMemberApiClientApi)localQRouteApi).doBindService();
  }
  
  private final void a(Bundle paramBundle, IStudyUploadCallback paramIStudyUploadCallback)
  {
    Object localObject = paramBundle.getString("status");
    if (localObject == null) {
      return;
    }
    int i = ((String)localObject).hashCode();
    if (i != -1867169789)
    {
      if (i != -1281977283) {
        return;
      }
      if (((String)localObject).equals("failed"))
      {
        i = paramBundle.getInt("errorCode", 0);
        paramBundle = paramBundle.getString("errorMsg", "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleUploadFileEvent: upload file failed. errorCode[");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("] errorMsg[");
        ((StringBuilder)localObject).append(paramBundle);
        ((StringBuilder)localObject).append(']');
        QLog.i("StudyMainProcessAbility", 1, ((StringBuilder)localObject).toString());
        if (paramIStudyUploadCallback != null)
        {
          Intrinsics.checkExpressionValueIsNotNull(paramBundle, "errorMsg");
          paramIStudyUploadCallback.a(false, i, paramBundle, "");
        }
      }
    }
    else if (((String)localObject).equals("success"))
    {
      QLog.i("StudyMainProcessAbility", 1, "handleUploadFileEvent: upload file suc.");
      paramBundle = paramBundle.getString("downloadUrl", "");
      if (paramIStudyUploadCallback != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "url");
        paramIStudyUploadCallback.a(true, 0, "", paramBundle);
      }
    }
  }
  
  private final ITroopMemberApiClientApi b()
  {
    QRouteApi localQRouteApi = QRoute.api(ITroopMemberApiClientApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(ITroopMemberApiClientApi::class.java)");
    return (ITroopMemberApiClientApi)localQRouteApi;
  }
  
  public void a()
  {
    QLog.i("StudyMainProcessAbility", 1, "onDestroy: remove service client.");
    QRouteApi localQRouteApi = QRoute.api(ITroopMemberApiClientApi.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(ITroopMemberApiClientApi::class.java)");
    ((ITroopMemberApiClientApi)localQRouteApi).doUnbindService();
  }
  
  public void a(@NotNull String paramString, @Nullable IStudyUploadCallback paramIStudyUploadCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    b().studyRoomPicUpload(paramString, (ITroopMemberApiClientApi.Callback)new StudyMainProcessAbility.uploadFile.1(this, paramIStudyUploadCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.StudyMainProcessAbility
 * JD-Core Version:    0.7.0.1
 */
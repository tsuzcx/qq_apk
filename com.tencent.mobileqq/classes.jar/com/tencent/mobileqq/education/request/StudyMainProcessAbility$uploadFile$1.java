package com.tencent.mobileqq.education.request;

import android.os.Bundle;
import com.tencent.mobileqq.education.request.callback.IStudyUploadCallback;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Landroid/os/Bundle;", "callback"}, k=3, mv={1, 1, 16})
final class StudyMainProcessAbility$uploadFile$1
  implements ITroopMemberApiClientApi.Callback
{
  StudyMainProcessAbility$uploadFile$1(StudyMainProcessAbility paramStudyMainProcessAbility, IStudyUploadCallback paramIStudyUploadCallback) {}
  
  public final void callback(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "resp");
    StudyMainProcessAbility.a(this.a, paramBundle, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.StudyMainProcessAbility.uploadFile.1
 * JD-Core Version:    0.7.0.1
 */
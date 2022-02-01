package com.tencent.mobileqq.troop.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/troop/viewmodel/PictureShowViewModel$mReadInjoyObserver$1", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "onAtlasCommentDelete", "", "isSuccess", "", "rowKey", "", "commentID", "action", "seq", "", "totalDeleteCount", "onAtlasCommentSend", "content", "level", "parentCommentId", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PictureShowViewModel$mReadInjoyObserver$1
  extends ReadInJoyObserver
{
  public void a(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "commentID");
    Intrinsics.checkParameterIsNotNull(paramString3, "action");
    if (PictureShowViewModel.a(this.a, paramString1)) {
      return;
    }
    paramString1 = this.a;
    if (PictureShowViewModel.b(paramString1, (String)PictureShowViewModel.b(paramString1).getValue()))
    {
      paramInt1 = Integer.valueOf((String)PictureShowViewModel.b(this.a).getValue()).intValue();
      PictureShowViewModel.b(this.a).setValue(String.valueOf(paramInt1 - 1));
    }
  }
  
  public void a(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt1, @NotNull String paramString4, int paramInt2, @NotNull String paramString5)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "commentID");
    Intrinsics.checkParameterIsNotNull(paramString3, "content");
    Intrinsics.checkParameterIsNotNull(paramString4, "action");
    Intrinsics.checkParameterIsNotNull(paramString5, "parentCommentId");
    if (PictureShowViewModel.a(this.a, paramString1)) {
      return;
    }
    paramString1 = this.a;
    if (PictureShowViewModel.b(paramString1, (String)PictureShowViewModel.b(paramString1).getValue()))
    {
      paramInt1 = Integer.valueOf((String)PictureShowViewModel.b(this.a).getValue()).intValue();
      PictureShowViewModel.b(this.a).setValue(String.valueOf(paramInt1 + 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.viewmodel.PictureShowViewModel.mReadInjoyObserver.1
 * JD-Core Version:    0.7.0.1
 */
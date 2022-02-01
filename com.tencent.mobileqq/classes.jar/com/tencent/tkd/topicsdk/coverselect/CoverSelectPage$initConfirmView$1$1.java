package com.tencent.tkd.topicsdk.coverselect;

import android.app.Activity;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.OutputPicListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/coverselect/CoverSelectPage$initConfirmView$1$1", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/OutputPicListener;", "onOutput", "", "path", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CoverSelectPage$initConfirmView$1$1
  implements OutputPicListener
{
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    CoverSelectPage.a(this.a.a, paramString);
    paramString = this.a.a.b();
    if (paramString != null) {
      paramString.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.coverselect.CoverSelectPage.initConfirmView.1.1
 * JD-Core Version:    0.7.0.1
 */
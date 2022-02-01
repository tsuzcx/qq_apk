package com.tencent.tkd.topicsdk.coverselect;

import android.app.Activity;
import android.content.Intent;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.OutputPicListener;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureView;
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
    int i;
    if (((CharSequence)paramString).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label136;
      }
      Intent localIntent = new Intent();
      if (CoverSelectPage.a(this.a.a) == 0) {
        localIntent.putExtra("initial_progress", CoverSelectPage.a(this.a.a).a());
      }
      localIntent.putExtra("result_path", paramString);
      localIntent.putExtra("from_page", CoverSelectPage.b(this.a.a));
      paramString = this.a.a.a();
      if (paramString != null) {
        paramString.setResult(-1, localIntent);
      }
    }
    for (;;)
    {
      paramString = this.a.a.a();
      if (paramString != null) {
        paramString.finish();
      }
      return;
      i = 0;
      break;
      label136:
      paramString = this.a.a.a();
      if (paramString != null) {
        paramString.setResult(0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.coverselect.CoverSelectPage.initConfirmView.1.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tkd.topicsdk.widget.videocrop;

import android.content.Context;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoCropPage$initProgressDialog$1$1$1
  extends Lambda
  implements Function0<Unit>
{
  public static final 1 INSTANCE = new 1();
  
  VideoCropPage$initProgressDialog$1$1$1()
  {
    super(0);
  }
  
  public final void invoke()
  {
    String str = AppContext.a.a().getString(R.string.j);
    Intrinsics.checkExpressionValueIsNotNull(str, "AppContext.instance.getS…g.cancel_video_crop_tips)");
    TopicSDKHelperKt.a(str, false, null, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPage.initProgressDialog.1.1.1
 * JD-Core Version:    0.7.0.1
 */
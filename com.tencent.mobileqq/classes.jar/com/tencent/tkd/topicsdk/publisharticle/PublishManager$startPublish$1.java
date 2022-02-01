package com.tencent.tkd.topicsdk.publisharticle;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$startPublish$1
  extends Lambda
  implements Function0<Unit>
{
  public static final 1 INSTANCE = new 1();
  
  PublishManager$startPublish$1()
  {
    super(0);
  }
  
  public final void invoke()
  {
    String str = AppContext.a.a().getResources().getString(R.string.ac);
    Intrinsics.checkExpressionValueIsNotNull(str, "AppContext.instance.reso…commend_wifi_upload_tips)");
    TopicSDKHelperKt.a(str, false, null, 6, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.startPublish.1
 * JD-Core Version:    0.7.0.1
 */
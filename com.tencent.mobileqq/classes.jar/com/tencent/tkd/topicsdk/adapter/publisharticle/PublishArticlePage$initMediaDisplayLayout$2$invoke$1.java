package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.content.Context;
import android.os.IBinder;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.topicsdk.widget.MediaDisplayLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initMediaDisplayLayout$2$invoke$1
  implements Runnable
{
  PublishArticlePage$initMediaDisplayLayout$2$invoke$1(PublishArticlePage.initMediaDisplayLayout.2 param2) {}
  
  public final void run()
  {
    InputMethodUtils localInputMethodUtils = InputMethodUtils.a;
    Context localContext = (Context)this.this$0.b;
    IBinder localIBinder = PublishArticlePage.l(this.this$0.a).getWindowToken();
    Intrinsics.checkExpressionValueIsNotNull(localIBinder, "mediaDisplayLayout.windowToken");
    localInputMethodUtils.a(localContext, localIBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initMediaDisplayLayout.2.invoke.1
 * JD-Core Version:    0.7.0.1
 */
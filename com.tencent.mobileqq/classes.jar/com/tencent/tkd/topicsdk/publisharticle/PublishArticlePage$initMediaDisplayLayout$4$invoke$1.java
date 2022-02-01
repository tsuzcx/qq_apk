package com.tencent.tkd.topicsdk.publisharticle;

import android.content.Context;
import android.os.IBinder;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import com.tencent.tkd.topicsdk.widget.MediaDisplayLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initMediaDisplayLayout$4$invoke$1
  implements Runnable
{
  PublishArticlePage$initMediaDisplayLayout$4$invoke$1(PublishArticlePage.initMediaDisplayLayout.4 param4) {}
  
  public final void run()
  {
    InputMethodUtils localInputMethodUtils = InputMethodUtils.a;
    Context localContext = (Context)this.this$0.jdField_a_of_type_AndroidAppActivity;
    IBinder localIBinder = PublishArticlePage.a(this.this$0.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePage).getWindowToken();
    Intrinsics.checkExpressionValueIsNotNull(localIBinder, "mediaDisplayLayout.windowToken");
    localInputMethodUtils.a(localContext, localIBinder);
    BottomSelectorLayout.a(PublishArticlePage.a(this.this$0.jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishArticlePage), false, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initMediaDisplayLayout.4.invoke.1
 * JD-Core Version:    0.7.0.1
 */
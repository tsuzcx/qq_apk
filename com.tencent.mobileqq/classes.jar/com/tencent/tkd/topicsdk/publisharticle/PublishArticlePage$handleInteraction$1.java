package com.tencent.tkd.topicsdk.publisharticle;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.KeyboardListener;
import com.tencent.tkd.topicsdk.common.SystemBarTintUtil;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isShow", "", "keyboardHeight", "", "onKeyboardChange"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$handleInteraction$1
  implements KeyBoardChangeListener.KeyboardListener
{
  PublishArticlePage$handleInteraction$1(PublishArticlePage paramPublishArticlePage) {}
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      StorageManager.a.a("sp_keyboard_height", paramInt);
      BottomSelectorLayout localBottomSelectorLayout = PublishArticlePage.a(this.a);
      Object localObject = DisplayUtils.a;
      Context localContext = PublishArticlePage.a(this.a).getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "rootView.context");
      int i = ((DisplayUtils)localObject).b(localContext);
      localObject = SystemBarTintUtil.a;
      localContext = PublishArticlePage.a(this.a).getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "rootView.context");
      localBottomSelectorLayout.c(i - ((SystemBarTintUtil)localObject).a(localContext) - paramInt - PublishArticlePage.a(this.a).a());
      return;
    }
    PublishArticlePage.a(this.a).c(PublishArticlePage.a(this.a).f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.handleInteraction.1
 * JD-Core Version:    0.7.0.1
 */
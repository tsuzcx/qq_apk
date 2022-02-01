package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.KeyboardListener;
import com.tencent.tkd.topicsdk.common.SystemBarTintUtil;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePage$handleInteraction$1$1", "Lcom/tencent/tkd/topicsdk/common/KeyBoardChangeListener$KeyboardListener;", "onKeyboardChange", "", "isShow", "", "keyboardHeight", "", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePage$handleInteraction$$inlined$apply$lambda$1
  implements KeyBoardChangeListener.KeyboardListener
{
  PublishArticlePage$handleInteraction$$inlined$apply$lambda$1(PublishArticlePage paramPublishArticlePage) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      StorageManager.a.a("sp_keyboard_height", paramInt);
      localObject1 = PublishArticlePage.a(this.a);
      Object localObject2 = DisplayUtils.a;
      Context localContext = PublishArticlePage.a(this.a).getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "rootView.context");
      int i = ((DisplayUtils)localObject2).b(localContext);
      localObject2 = SystemBarTintUtil.a;
      localContext = PublishArticlePage.a(this.a).getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "rootView.context");
      ((BottomSelectorLayout)localObject1).c(i - ((SystemBarTintUtil)localObject2).a(localContext) - paramInt - PublishArticlePage.a(this.a).a());
      return;
    }
    PublishArticlePage.a(this.a).c(PublishArticlePage.a(this.a).e());
    Object localObject1 = PublishArticlePage.a(this.a);
    if (localObject1 != null) {
      ((SelectPopupController)localObject1).a(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.handleInteraction..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */
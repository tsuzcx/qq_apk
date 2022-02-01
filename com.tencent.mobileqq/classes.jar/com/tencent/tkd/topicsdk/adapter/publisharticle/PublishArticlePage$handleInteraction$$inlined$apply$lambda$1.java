package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.KeyboardListener;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectPopupController;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePage$handleInteraction$1$1", "Lcom/tencent/tkd/topicsdk/common/KeyBoardChangeListener$KeyboardListener;", "onKeyboardChange", "", "isShow", "", "keyboardHeight", "", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePage$handleInteraction$$inlined$apply$lambda$1
  implements KeyBoardChangeListener.KeyboardListener
{
  PublishArticlePage$handleInteraction$$inlined$apply$lambda$1(PublishArticlePage paramPublishArticlePage) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      StorageManager.b.a("sp_keyboard_height", paramInt);
      return;
    }
    SelectPopupController localSelectPopupController = PublishArticlePage.g(this.a);
    if (localSelectPopupController != null) {
      localSelectPopupController.a(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.handleInteraction..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.component.chat.message;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qqgift.callback.IQQGiftPanelResDownloadCallback;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/SendGiftMessageBaseItemView$loadGiftImageInner$1", "Lcom/tencent/mobileqq/qqgift/callback/IQQGiftPanelResDownloadCallback;", "onLoadFail", "", "id", "", "errorCode", "httpCode", "errorMessage", "", "onLoadSuccess", "panelResource", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "onProgress", "progress", "", "progressMax", "progressRate", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SendGiftMessageBaseItemView$loadGiftImageInner$1
  implements IQQGiftPanelResDownloadCallback
{
  SendGiftMessageBaseItemView$loadGiftImageInner$1(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errorCode: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("; httpCode: ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("; errorMessage: ");
    localStringBuilder.append(paramString);
    Logger.c("SendGiftMessageBaseItemView", localStringBuilder.toString());
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void a(int paramInt, @Nullable QQGiftPanelResource paramQQGiftPanelResource)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLoadSuccess: ");
    ((StringBuilder)localObject).append(paramInt);
    Logger.c("SendGiftMessageBaseItemView", ((StringBuilder)localObject).toString());
    if (SendGiftMessageBaseItemView.a(this.a) != this.b) {
      return;
    }
    if (paramQQGiftPanelResource != null) {
      paramQQGiftPanelResource = paramQQGiftPanelResource.b;
    } else {
      paramQQGiftPanelResource = null;
    }
    localObject = (CharSequence)paramQQGiftPanelResource;
    if ((localObject != null) && (!StringsKt.isBlank((CharSequence)localObject))) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    if (paramInt != 0) {
      return;
    }
    paramQQGiftPanelResource = URLDrawable.getFileDrawable(paramQQGiftPanelResource, URLDrawable.URLDrawableOptions.obtain());
    this.a.getGiftImageView().setImageDrawable((Drawable)paramQQGiftPanelResource);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SendGiftMessageBaseItemView.loadGiftImageInner.1
 * JD-Core Version:    0.7.0.1
 */
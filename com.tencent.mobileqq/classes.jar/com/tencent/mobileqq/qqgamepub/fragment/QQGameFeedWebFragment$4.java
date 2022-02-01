package com.tencent.mobileqq.qqgamepub.fragment;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;

class QQGameFeedWebFragment$4
  implements Runnable
{
  QQGameFeedWebFragment$4(QQGameFeedWebFragment paramQQGameFeedWebFragment, int paramInt, IPreloadService.PathResult paramPathResult, View paramView) {}
  
  public void run()
  {
    if ((this.a == 0) && (!TextUtils.isEmpty(this.b.filePath)))
    {
      Drawable localDrawable = ((IQWalletApiProxy)QRoute.api(IQWalletApiProxy.class)).getDrawableForWallet(this.b.filePath, null, null);
      if (localDrawable != null)
      {
        ((ImageView)this.c.findViewById(2131435561)).setImageDrawable(localDrawable);
        return;
      }
      QQGameFeedWebFragment.c(this.this$0);
      return;
    }
    QQGameFeedWebFragment.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.4
 * JD-Core Version:    0.7.0.1
 */
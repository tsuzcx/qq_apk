package com.tencent.mobileqq.minigame.publicaccount;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;

class MiniGamePublicAccountWebFragment$4$1
  implements Runnable
{
  MiniGamePublicAccountWebFragment$4$1(MiniGamePublicAccountWebFragment.4 param4, int paramInt, IPreloadService.PathResult paramPathResult) {}
  
  public void run()
  {
    if ((this.val$resCode == 0) && (!TextUtils.isEmpty(this.val$pathRes.filePath)))
    {
      Drawable localDrawable = ((IQWalletApiProxy)QRoute.api(IQWalletApiProxy.class)).getDrawableForWallet(this.val$pathRes.filePath, null, null);
      if (localDrawable != null)
      {
        ((ImageView)this.this$1.val$rootView.findViewById(2030239754)).setImageDrawable(localDrawable);
        return;
      }
      MiniGamePublicAccountWebFragment.access$500(this.this$1.this$0);
      return;
    }
    MiniGamePublicAccountWebFragment.access$500(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.4.1
 * JD-Core Version:    0.7.0.1
 */
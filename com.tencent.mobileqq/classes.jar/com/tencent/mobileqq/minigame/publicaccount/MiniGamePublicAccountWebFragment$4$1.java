package com.tencent.mobileqq.minigame.publicaccount;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import cooperation.qwallet.plugin.QWalletPicHelper;

class MiniGamePublicAccountWebFragment$4$1
  implements Runnable
{
  MiniGamePublicAccountWebFragment$4$1(MiniGamePublicAccountWebFragment.4 param4, int paramInt, PreloadManager.PathResult paramPathResult) {}
  
  public void run()
  {
    if ((this.val$resCode == 0) && (!TextUtils.isEmpty(this.val$pathRes.filePath)))
    {
      Drawable localDrawable = QWalletPicHelper.getDrawableForWallet(this.val$pathRes.filePath, null);
      if (localDrawable != null)
      {
        ((ImageView)this.this$1.val$rootView.findViewById(2131368534)).setImageDrawable(localDrawable);
        return;
      }
      MiniGamePublicAccountWebFragment.access$1200(this.this$1.this$0);
      return;
    }
    MiniGamePublicAccountWebFragment.access$1200(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.4.1
 * JD-Core Version:    0.7.0.1
 */
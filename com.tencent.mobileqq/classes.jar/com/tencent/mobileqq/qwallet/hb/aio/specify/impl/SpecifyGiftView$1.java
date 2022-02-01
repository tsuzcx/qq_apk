package com.tencent.mobileqq.qwallet.hb.aio.specify.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.qwallet.temp.IAIOAnimationControlManager;
import com.qwallet.temp.ISpriteVideoViewTemp;
import com.qwallet.temp.ISpriteVideoViewTemp.OnFrameEndListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;

class SpecifyGiftView$1
  implements View.OnClickListener
{
  SpecifyGiftView$1(SpecifyGiftView paramSpecifyGiftView, ISpriteVideoViewTemp.OnFrameEndListener paramOnFrameEndListener, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    SpecifyGiftView.a(this.c).stop();
    Object localObject = this.a;
    if (localObject != null) {
      ((ISpriteVideoViewTemp.OnFrameEndListener)localObject).a();
    }
    localObject = QWalletTools.b();
    if (localObject != null) {
      ((IAIOAnimationControlManager)((BaseQQAppInterface)localObject).getRuntimeService(IAIOAnimationControlManager.class)).removeAllGiftMsgByTroop(SpecifyGiftView.b(this.c).frienduin);
    }
    QWalletTools.a((AppInterface)localObject, "212", "only.animation.close");
    localObject = this.b;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.specify.impl.SpecifyGiftView.1
 * JD-Core Version:    0.7.0.1
 */
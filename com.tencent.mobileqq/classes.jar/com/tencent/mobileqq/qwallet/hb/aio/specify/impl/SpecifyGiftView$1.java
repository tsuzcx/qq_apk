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
    SpecifyGiftView.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplSpecifyGiftView).stop();
    Object localObject = this.jdField_a_of_type_ComQwalletTempISpriteVideoViewTemp$OnFrameEndListener;
    if (localObject != null) {
      ((ISpriteVideoViewTemp.OnFrameEndListener)localObject).a();
    }
    localObject = QWalletTools.a();
    if (localObject != null) {
      ((IAIOAnimationControlManager)((BaseQQAppInterface)localObject).getRuntimeService(IAIOAnimationControlManager.class)).removeAllGiftMsgByTroop(SpecifyGiftView.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioSpecifyImplSpecifyGiftView).frienduin);
    }
    QWalletTools.a((AppInterface)localObject, "212", "only.animation.close");
    localObject = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.specify.impl.SpecifyGiftView.1
 * JD-Core Version:    0.7.0.1
 */
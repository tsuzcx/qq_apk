package com.tencent.mobileqq.gamecenter.web;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import cooperation.qwallet.plugin.QWalletPicHelper;

class QQGameFeedWebFragment$6$1
  implements Runnable
{
  QQGameFeedWebFragment$6$1(QQGameFeedWebFragment.6 param6, int paramInt, IPreloadService.PathResult paramPathResult) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult.filePath)))
      {
        Drawable localDrawable = QWalletPicHelper.getDrawableForWallet(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult.filePath, null);
        if (localDrawable != null)
        {
          ((ImageView)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$6.jdField_a_of_type_AndroidViewView.findViewById(2131368923)).setImageDrawable(localDrawable);
          return;
        }
        QQGameFeedWebFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$6.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    QQGameFeedWebFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment$6.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.6.1
 * JD-Core Version:    0.7.0.1
 */
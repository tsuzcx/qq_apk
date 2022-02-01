package com.tencent.mobileqq.qqgamepub.fragment;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;

class QQGameFeedWebFragment$5$1
  implements Runnable
{
  QQGameFeedWebFragment$5$1(QQGameFeedWebFragment.5 param5, int paramInt, IPreloadService.PathResult paramPathResult) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult.filePath)))
      {
        Drawable localDrawable = ((IQWalletApiProxy)QRoute.api(IQWalletApiProxy.class)).getDrawableForWallet(this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$PathResult.filePath, null, null);
        if (localDrawable != null)
        {
          ((ImageView)this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$5.jdField_a_of_type_AndroidViewView.findViewById(2131368649)).setImageDrawable(localDrawable);
          return;
        }
        QQGameFeedWebFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$5.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment);
        return;
      }
      QQGameFeedWebFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment$5.jdField_a_of_type_ComTencentMobileqqQqgamepubFragmentQQGameFeedWebFragment);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.5.1
 * JD-Core Version:    0.7.0.1
 */
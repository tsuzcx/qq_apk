package com.tencent.mobileqq.gamecenter.web;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import auvp;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import cooperation.qwallet.plugin.QWalletPicHelper;

public class QQGameFeedWebFragment$4$1
  implements Runnable
{
  public QQGameFeedWebFragment$4$1(auvp paramauvp, int paramInt, PreloadManager.PathResult paramPathResult) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$PathResult.filePath)))
      {
        Drawable localDrawable = QWalletPicHelper.getDrawableForWallet(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$PathResult.filePath, null);
        if (localDrawable != null)
        {
          ((ImageView)this.jdField_a_of_type_Auvp.jdField_a_of_type_AndroidViewView.findViewById(2131368436)).setImageDrawable(localDrawable);
          return;
        }
        QQGameFeedWebFragment.a(this.jdField_a_of_type_Auvp.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
    QQGameFeedWebFragment.a(this.jdField_a_of_type_Auvp.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.4.1
 * JD-Core Version:    0.7.0.1
 */
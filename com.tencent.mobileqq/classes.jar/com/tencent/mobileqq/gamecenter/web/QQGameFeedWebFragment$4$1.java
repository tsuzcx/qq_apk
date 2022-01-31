package com.tencent.mobileqq.gamecenter.web;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import asos;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import cooperation.qwallet.plugin.QWalletPicHelper;

public class QQGameFeedWebFragment$4$1
  implements Runnable
{
  public QQGameFeedWebFragment$4$1(asos paramasos, int paramInt, PreloadManager.PathResult paramPathResult) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$PathResult.filePath)))
    {
      Drawable localDrawable = QWalletPicHelper.getDrawableForWallet(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$PathResult.filePath, null);
      if (localDrawable != null)
      {
        ((ImageView)this.jdField_a_of_type_Asos.jdField_a_of_type_AndroidViewView.findViewById(2131368110)).setImageDrawable(localDrawable);
        return;
      }
      QQGameFeedWebFragment.a(this.jdField_a_of_type_Asos.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment);
      return;
    }
    QQGameFeedWebFragment.a(this.jdField_a_of_type_Asos.jdField_a_of_type_ComTencentMobileqqGamecenterWebQQGameFeedWebFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.4.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.profile.PersonalityLabel;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class ShareHelper$1
  implements AdapterView.OnItemClickListener
{
  ShareHelper$1(ShareHelper paramShareHelper) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.getActionSheet().isShowing()) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.getActionSheet().dismiss();
    }
    int i;
    if ((paramLong == 2L) || (paramLong == 3L))
    {
      if (!WXShareHelper.a().a()) {
        i = 2131720478;
      } else if (!WXShareHelper.a().b()) {
        i = 2131720479;
      } else {
        i = -1;
      }
      if (i != -1)
      {
        QRUtils.a(1, i);
        break label223;
      }
    }
    if ((this.a.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.a.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$OnUseResListener.a(true);
      i = (int)paramLong;
      if (i != 0)
      {
        if (i != 1)
        {
          if ((i == 2) || (i == 3)) {
            ThreadManager.postImmediately(new ShareHelper.1.3(this, paramLong), null, true);
          }
        }
        else {
          ThreadManager.postImmediately(new ShareHelper.1.2(this), null, true);
        }
      }
      else {
        ThreadManager.postImmediately(new ShareHelper.1.1(this), null, true);
      }
    }
    else
    {
      QRUtils.a(1, 2131699133);
    }
    label223:
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1
 * JD-Core Version:    0.7.0.1
 */
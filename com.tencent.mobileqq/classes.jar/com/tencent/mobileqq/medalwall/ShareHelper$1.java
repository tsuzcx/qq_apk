package com.tencent.mobileqq.medalwall;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qrcode.util.QRUtils;
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
    if (this.a.a.getActionSheet().isShowing()) {
      this.a.a.getActionSheet().dismiss();
    }
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
        break label165;
      }
    }
    int i = (int)paramLong;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            ShareHelper.d(this.a);
          }
        }
        else {
          ShareHelper.c(this.a);
        }
      }
      else {
        ShareHelper.b(this.a);
      }
    }
    else {
      ShareHelper.a(this.a);
    }
    label165:
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.ShareHelper.1
 * JD-Core Version:    0.7.0.1
 */
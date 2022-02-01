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
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        i = 2131720753;
      }
    }
    for (;;)
    {
      if (i != -1) {
        QRUtils.a(1, i);
      }
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (WXShareHelper.a().b()) {
          break label175;
        }
        i = 2131720754;
        break;
        switch ((int)paramLong)
        {
        default: 
          break;
        case 0: 
          ShareHelper.a(this.a);
          break;
        case 1: 
          ShareHelper.b(this.a);
          break;
        case 2: 
          ShareHelper.c(this.a);
          break;
        case 3: 
          ShareHelper.d(this.a);
        }
      }
      label175:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.ShareHelper.1
 * JD-Core Version:    0.7.0.1
 */
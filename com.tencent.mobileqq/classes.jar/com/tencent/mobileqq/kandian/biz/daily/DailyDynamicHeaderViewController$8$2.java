package com.tencent.mobileqq.kandian.biz.daily;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class DailyDynamicHeaderViewController$8$2
  implements ViewBase.OnClickListener
{
  DailyDynamicHeaderViewController$8$2(DailyDynamicHeaderViewController.8 param8) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (paramViewBase.getEventAttachedData() == null) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramViewBase.getEventAttachedData()));
    paramViewBase.getNativeView().getContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyDynamicHeaderViewController.8.2
 * JD-Core Version:    0.7.0.1
 */
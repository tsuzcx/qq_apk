package com.tencent.mobileqq.mini.entry.search.ui;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;

class HotSearchAdapter$HotSearchViewHolder$1
  implements View.OnClickListener
{
  HotSearchAdapter$HotSearchViewHolder$1(HotSearchAdapter.HotSearchViewHolder paramHotSearchViewHolder, Activity paramActivity, MiniAppInfo paramMiniAppInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    try
    {
      ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      MiniAppController.launchMiniAppByAppInfo(this.val$activity, this.val$miniAppInfo, this.val$refer);
      return;
    }
    catch (Exception paramView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HotSearchAdapter, start miniApp exception: ");
      localStringBuilder.append(Log.getStackTraceString(paramView));
      QLog.e("HotSearchAdapter", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.HotSearchAdapter.HotSearchViewHolder.1
 * JD-Core Version:    0.7.0.1
 */
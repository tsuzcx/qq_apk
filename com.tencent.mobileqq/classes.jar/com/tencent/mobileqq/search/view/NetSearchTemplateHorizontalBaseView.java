package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

public class NetSearchTemplateHorizontalBaseView
  extends NetSearchTemplateBaseView
{
  public NetSearchTemplateHorizontalBaseView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public void a()
  {
    super.a();
    TextView localTextView = c();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      if (localTextView != null) {
        ((TextView)localTextView).setTextColor(localTextView.getContext().getResources().getColor(2131166963));
      }
    }
    while (localTextView == null) {
      return;
    }
    ((TextView)localTextView).setTextColor(Color.parseColor("#737373"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalBaseView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.search.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateDividerItem;
import com.tencent.mobileqq.search.view.NetSearchTemplateDividerView;
import com.tencent.mobileqq.theme.ThemeUtil;

public class SearchViewUtils
{
  public static void a(int paramInt1, int paramInt2, View paramView)
  {
    a(paramInt1, paramInt2, paramView, false);
  }
  
  public static void a(int paramInt1, int paramInt2, View paramView, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramBoolean, 0);
  }
  
  public static void a(int paramInt1, int paramInt2, View paramView, boolean paramBoolean, int paramInt3)
  {
    int i = ((Integer)paramView.getTag(2131362080)).intValue();
    LinearLayout localLinearLayout;
    Context localContext;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    int j;
    int k;
    if ((paramView instanceof LinearLayout))
    {
      localLinearLayout = (LinearLayout)paramView;
      localLinearLayout.removeView(localLinearLayout.findViewById(2131362469));
      localLinearLayout.removeView(localLinearLayout.findViewById(2131362470));
      if (localLinearLayout.getChildCount() == 1)
      {
        localContext = localLinearLayout.getContext();
        localView = localLinearLayout.getChildAt(0);
        localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        j = localContext.getResources().getDimensionPixelSize(2131559429);
        k = localContext.getResources().getDimensionPixelSize(2131559430);
        switch (paramInt2)
        {
        default: 
          localView.setLayoutParams(localLayoutParams);
          if (paramInt1 > 1)
          {
            localView.setPadding(localView.getPaddingLeft(), j, localView.getPaddingRight(), j);
            label167:
            if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
              break label390;
            }
            localLinearLayout.setBackgroundColor(paramView.getResources().getColor(2131492947));
          }
          break;
        }
      }
    }
    for (;;)
    {
      if (NetSearchTemplateDividerItem.a(paramInt3))
      {
        paramView = new NetSearchTemplateDividerView(localContext, paramInt3).a();
        paramView.setId(2131362470);
        localLinearLayout.addView(paramView, 0);
      }
      if (((paramInt2 == 0) || (paramInt1 == 1)) && (paramBoolean) && (i != 1))
      {
        paramView = new View(localLinearLayout.getContext());
        paramView.setId(2131362469);
        paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, localLinearLayout.getContext().getResources().getDimensionPixelSize(2131559425)));
        localLinearLayout.addView(paramView, 0);
        if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
          break label407;
        }
        paramView.setBackgroundColor(Color.parseColor("#061121"));
      }
      return;
      localLayoutParams.topMargin = j;
      localLayoutParams.bottomMargin = 0;
      break;
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = 0;
      break;
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = j;
      break;
      localView.setPadding(localView.getPaddingLeft(), k, localView.getPaddingRight(), k);
      break label167;
      label390:
      localLinearLayout.setBackgroundColor(paramView.getResources().getColor(2131492968));
    }
    label407:
    paramView.setBackgroundColor(Color.parseColor("#f2f2f2"));
  }
  
  public static void a(ISearchResultModel paramISearchResultModel, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = j;
    if (paramInt1 > 1)
    {
      if (paramInt2 != 0) {
        break label26;
      }
      i = 0;
    }
    for (;;)
    {
      paramISearchResultModel.b(paramInt1, i);
      return;
      label26:
      i = j;
      if (paramInt2 == paramInt1 - 1) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchViewUtils
 * JD-Core Version:    0.7.0.1
 */
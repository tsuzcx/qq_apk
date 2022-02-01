package com.tencent.mobileqq.search.base.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateDividerItem;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateDividerView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.MobileQQ;

public class SearchViewUtils
{
  public static void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    a(paramInt1, paramInt2, paramView, false, paramInt3, true);
  }
  
  public static void a(int paramInt1, int paramInt2, View paramView, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    int i = ((Integer)paramView.getTag(2131449868)).intValue();
    if ((paramView instanceof LinearLayout))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeView(paramView.findViewById(2131442531));
      paramView.removeView(paramView.findViewById(2131442532));
      if (paramView.getChildCount() == 1)
      {
        Object localObject = paramView.getContext();
        View localView = paramView.getChildAt(0);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        int j = ((Context)localObject).getResources().getDimensionPixelSize(2131299265);
        int k = ((Context)localObject).getResources().getDimensionPixelSize(2131299266);
        if (paramInt2 != 0)
        {
          if (paramInt2 != 1)
          {
            if (paramInt2 == 2)
            {
              localLayoutParams.topMargin = 0;
              localLayoutParams.bottomMargin = 0;
            }
          }
          else
          {
            localLayoutParams.topMargin = 0;
            localLayoutParams.bottomMargin = 0;
          }
        }
        else
        {
          localLayoutParams.topMargin = 0;
          localLayoutParams.bottomMargin = 0;
        }
        localView.setLayoutParams(localLayoutParams);
        if (paramBoolean2) {
          if (paramInt1 > 1) {
            localView.setPadding(localView.getPaddingLeft(), j, localView.getPaddingRight(), j);
          } else {
            localView.setPadding(localView.getPaddingLeft(), k, localView.getPaddingRight(), k);
          }
        }
        if (NetSearchTemplateDividerItem.a(paramInt3))
        {
          localObject = new NetSearchTemplateDividerView((Context)localObject, paramInt3).h();
          ((View)localObject).setId(2131442532);
          paramView.addView((View)localObject, 0);
        }
        if (((paramInt2 == 0) || (paramInt1 == 1)) && (paramBoolean1) && (i != 1))
        {
          localObject = new View(paramView.getContext());
          ((View)localObject).setId(2131442531);
          ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, paramView.getContext().getResources().getDimensionPixelSize(2131299259)));
          paramView.addView((View)localObject, 0);
          if (ThemeUtil.isInNightMode(MobileQQ.sMobileQQ.peekAppRuntime()))
          {
            ((View)localObject).setBackgroundColor(Color.parseColor("#080808"));
            return;
          }
          ((View)localObject).setBackgroundColor(Color.parseColor("#f2f2f2"));
        }
      }
    }
  }
  
  public static void a(ISearchResultModel paramISearchResultModel, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = j;
    if (paramInt1 > 1) {
      if (paramInt2 == 0)
      {
        i = 0;
      }
      else
      {
        i = j;
        if (paramInt2 == paramInt1 - 1) {
          i = 2;
        }
      }
    }
    paramISearchResultModel.a(paramInt1, i);
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString)
  {
    return ((ITroopRobotService)paramAppInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.util.SearchViewUtils
 * JD-Core Version:    0.7.0.1
 */
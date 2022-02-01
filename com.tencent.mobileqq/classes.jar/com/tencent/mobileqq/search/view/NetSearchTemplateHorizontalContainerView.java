package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalOneView;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;

public class NetSearchTemplateHorizontalContainerView
  extends NetSearchTemplateBaseView
{
  public final ArrayList<NetSearchTemplateHorizontalBaseView> a = new ArrayList();
  
  public NetSearchTemplateHorizontalContainerView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    LinearLayout localLinearLayout = (LinearLayout)b(paramInt);
    localLinearLayout.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramInt = DisplayUtil.a(paramViewGroup.getContext(), 13.5F);
    localLayoutParams.rightMargin = paramInt;
    localLayoutParams.leftMargin = paramInt;
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setBackgroundDrawable(null);
  }
  
  public void a(NetSearchTemplateHorizontalContainerItem paramNetSearchTemplateHorizontalContainerItem)
  {
    this.a.clear();
    LinearLayout localLinearLayout = (LinearLayout)b(this.m);
    localLinearLayout.removeAllViews();
    if (paramNetSearchTemplateHorizontalContainerItem.c != null)
    {
      if (paramNetSearchTemplateHorizontalContainerItem.c.size() == 0) {
        return;
      }
      Object localObject = localLinearLayout.getContext();
      int j = paramNetSearchTemplateHorizontalContainerItem.c.size();
      int i = 3;
      if (j >= 3) {
        i = paramNetSearchTemplateHorizontalContainerItem.c.size();
      }
      int k = (((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 27.0F)) / i;
      i = 0;
      while (i < j)
      {
        NetSearchTemplateHorizontalBaseItem localNetSearchTemplateHorizontalBaseItem = (NetSearchTemplateHorizontalBaseItem)paramNetSearchTemplateHorizontalContainerItem.c.get(i);
        localObject = null;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, -2);
        if (localNetSearchTemplateHorizontalBaseItem.c == 1) {
          localObject = new NetSearchTemplateHorizontalOneView((ViewGroup)h(), 0);
        }
        if (localObject != null)
        {
          ((NetSearchTemplateHorizontalBaseView)localObject).h().setLayoutParams(localLayoutParams);
          localLinearLayout.addView(((NetSearchTemplateHorizontalBaseView)localObject).h());
          this.a.add(localObject);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalContainerView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;

public class NetSearchTemplateHorizontalContainerView
  extends NetSearchTemplateBaseView
{
  public final ArrayList a = new ArrayList();
  
  public NetSearchTemplateHorizontalContainerView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    LinearLayout localLinearLayout = (LinearLayout)a(paramInt);
    localLinearLayout.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramInt = DisplayUtil.a(paramViewGroup.getContext(), 11.5F);
    localLayoutParams.rightMargin = paramInt;
    localLayoutParams.leftMargin = paramInt;
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setBackgroundDrawable(null);
  }
  
  public void a(NetSearchTemplateHorizontalContainerItem paramNetSearchTemplateHorizontalContainerItem)
  {
    int i = 3;
    this.a.clear();
    LinearLayout localLinearLayout = (LinearLayout)a(this.b);
    localLinearLayout.removeAllViews();
    if ((paramNetSearchTemplateHorizontalContainerItem.a == null) || (paramNetSearchTemplateHorizontalContainerItem.a.size() == 0)) {}
    int j;
    int k;
    label90:
    do
    {
      return;
      localObject = localLinearLayout.getContext();
      j = paramNetSearchTemplateHorizontalContainerItem.a.size();
      if (j >= 3) {
        break;
      }
      k = (((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 23.0F)) / i;
      i = 0;
    } while (i >= j);
    Object localObject = (NetSearchTemplateHorizontalBaseItem)paramNetSearchTemplateHorizontalContainerItem.a.get(i);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, -2);
    switch (((NetSearchTemplateHorizontalBaseItem)localObject).a)
    {
    }
    for (localObject = null;; localObject = new NetSearchTemplateHorizontalOneView((ViewGroup)a(), 0))
    {
      if (localObject != null)
      {
        ((NetSearchTemplateHorizontalBaseView)localObject).a().setLayoutParams(localLayoutParams);
        localLinearLayout.addView(((NetSearchTemplateHorizontalBaseView)localObject).a());
        this.a.add(localObject);
      }
      i += 1;
      break label90;
      i = paramNetSearchTemplateHorizontalContainerItem.a.size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalContainerView
 * JD-Core Version:    0.7.0.1
 */
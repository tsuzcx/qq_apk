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
  public final ArrayList<NetSearchTemplateHorizontalBaseView> a;
  
  public NetSearchTemplateHorizontalContainerView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    LinearLayout localLinearLayout = (LinearLayout)a(paramInt);
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
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    LinearLayout localLinearLayout = (LinearLayout)a(this.jdField_a_of_type_Int);
    localLinearLayout.removeAllViews();
    if (paramNetSearchTemplateHorizontalContainerItem.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (paramNetSearchTemplateHorizontalContainerItem.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return;
      }
      Object localObject = localLinearLayout.getContext();
      int j = paramNetSearchTemplateHorizontalContainerItem.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 3;
      if (j >= 3) {
        i = paramNetSearchTemplateHorizontalContainerItem.jdField_a_of_type_JavaUtilArrayList.size();
      }
      int k = (((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 27.0F)) / i;
      i = 0;
      while (i < j)
      {
        NetSearchTemplateHorizontalBaseItem localNetSearchTemplateHorizontalBaseItem = (NetSearchTemplateHorizontalBaseItem)paramNetSearchTemplateHorizontalContainerItem.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject = null;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, -2);
        if (localNetSearchTemplateHorizontalBaseItem.jdField_a_of_type_Int == 1) {
          localObject = new NetSearchTemplateHorizontalOneView((ViewGroup)a(), 0);
        }
        if (localObject != null)
        {
          ((NetSearchTemplateHorizontalBaseView)localObject).a().setLayoutParams(localLayoutParams);
          localLinearLayout.addView(((NetSearchTemplateHorizontalBaseView)localObject).a());
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalContainerView
 * JD-Core Version:    0.7.0.1
 */
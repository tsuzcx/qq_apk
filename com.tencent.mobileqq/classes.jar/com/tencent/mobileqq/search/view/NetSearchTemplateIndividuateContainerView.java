package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.model.NetSearchTemplateIndividuateContainerItem;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class NetSearchTemplateIndividuateContainerView
  extends NetSearchTemplateBaseView
{
  public final List<NetSearchTemplateHorizontalBaseView> a;
  public final int b = ViewUtils.a(20.0F);
  
  public NetSearchTemplateIndividuateContainerView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramViewGroup = (LinearLayout)a(paramInt);
    paramViewGroup.setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramInt = ViewUtils.a(13.5F);
    localLayoutParams.rightMargin = paramInt;
    localLayoutParams.leftMargin = paramInt;
    paramViewGroup.setLayoutParams(localLayoutParams);
    paramViewGroup.setBackgroundDrawable(null);
  }
  
  @NotNull
  private LinearLayout.LayoutParams a(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, -2);
    paramInt1 = this.b / 4;
    if (paramInt2 == 0)
    {
      localLayoutParams.rightMargin = paramInt1;
      return localLayoutParams;
    }
    if (paramInt2 == 1)
    {
      localLayoutParams.leftMargin = paramInt1;
      localLayoutParams.rightMargin = paramInt1;
      return localLayoutParams;
    }
    if (paramInt2 == 2) {
      localLayoutParams.leftMargin = paramInt1;
    }
    return localLayoutParams;
  }
  
  public void a(NetSearchTemplateIndividuateContainerItem paramNetSearchTemplateIndividuateContainerItem)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    LinearLayout localLinearLayout = (LinearLayout)a(this.jdField_a_of_type_Int);
    localLinearLayout.removeAllViews();
    if (paramNetSearchTemplateIndividuateContainerItem.jdField_a_of_type_JavaUtilList != null)
    {
      if (paramNetSearchTemplateIndividuateContainerItem.jdField_a_of_type_JavaUtilList.size() == 0) {
        return;
      }
      Object localObject = localLinearLayout.getContext();
      int j = paramNetSearchTemplateIndividuateContainerItem.jdField_a_of_type_JavaUtilList.size();
      int i = 3;
      if (j >= 3) {
        i = paramNetSearchTemplateIndividuateContainerItem.jdField_a_of_type_JavaUtilList.size();
      }
      int k = (((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.a((Context)localObject, 27.0F) - this.b) / i;
      i = 0;
      while (i < j)
      {
        paramNetSearchTemplateIndividuateContainerItem = new NetSearchTemplateIndividuateOneView((ViewGroup)a(), k);
        localObject = a(k, i);
        paramNetSearchTemplateIndividuateContainerItem.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
        localLinearLayout.addView(paramNetSearchTemplateIndividuateContainerItem.a());
        this.jdField_a_of_type_JavaUtilList.add(paramNetSearchTemplateIndividuateContainerItem);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateIndividuateContainerView
 * JD-Core Version:    0.7.0.1
 */
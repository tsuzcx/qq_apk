package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.NoScrollGridView;
import java.util.ArrayList;
import java.util.List;

public class AppsGridViewBuilder
  extends AppsBaseBuilder
{
  protected List<TroopAppShortcutContainer.TroopAppInfo> a;
  protected int b = 0;
  protected boolean c = false;
  
  public AppsGridViewBuilder(Context paramContext, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Bundle paramBundle)
  {
    super(paramContext, paramQQAppInterface, paramFragmentActivity, null, paramBundle);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new AppsGridViewBuilder.ItemViewHolder();
      paramView = new NoScrollGridView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setNumColumns(4);
      paramView.setVerticalSpacing(AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setHorizontalSpacing(AIOUtils.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setPadding(AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setColumnWidth(this.b);
      paramView.setSelector(new ColorDrawable(0));
      paramView.setVerticalScrollBarEnabled(false);
      paramView.setStretchMode(0);
      paramViewGroup.a = new AppsGridViewBuilder.AppsGridViewAdapter(this, this.b);
      paramViewGroup.a.a(this.jdField_a_of_type_JavaUtilList);
      paramView.setAdapter(paramViewGroup.a);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramView.setClickable(false);
      return paramView;
      ((AppsGridViewBuilder.ItemViewHolder)paramView.getTag()).a.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a_(Object paramObject)
  {
    if ((paramObject instanceof ArrayList)) {
      this.jdField_a_of_type_JavaUtilList = ((List)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AppsGridViewBuilder
 * JD-Core Version:    0.7.0.1
 */
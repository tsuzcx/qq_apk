package com.tencent.mobileqq.search.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class AssociateSearchWordsFragment$SearchAssociatedWordAdapter
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public AssociateSearchWordsFragment$SearchAssociatedWordAdapter(AssociateSearchWordsFragment paramAssociateSearchWordsFragment, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (AssociateSearchWordsFragment.AssociateItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    switch (((AssociateSearchWordsFragment.AssociateItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int)
    {
    default: 
      return 0;
    case 2: 
    case 4: 
    case 5: 
      return 3;
    case 3: 
      return 2;
    case 0: 
      return 1;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AssociateSearchWordsFragment.AssociateItem localAssociateItem = (AssociateSearchWordsFragment.AssociateItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.getActivity();
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    paramViewGroup = paramView;
    Object localObject;
    if (paramView == null)
    {
      localObject = new AssociateSearchWordsFragment.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment);
      paramViewGroup = new LinearLayout(localFragmentActivity);
      paramViewGroup.setPadding(DisplayUtil.a(localFragmentActivity, 12.0F), 0, DisplayUtil.a(localFragmentActivity, 12.0F), 0);
      paramViewGroup.setOrientation(1);
    }
    switch (getItemViewType(paramInt))
    {
    default: 
      paramView.setTag(localObject);
      paramView.setBackgroundResource(2130840385);
      paramViewGroup = paramView;
      paramView = (AssociateSearchWordsFragment.ViewHolder)paramViewGroup.getTag();
      switch (getItemViewType(paramInt))
      {
      default: 
        label184:
        if (bool) {
          paramViewGroup.setBackgroundResource(2130838586);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramViewGroup.setTag(2131362080, Integer.valueOf(paramInt));
      paramViewGroup.setTag(2131362079, localAssociateItem);
      return paramViewGroup;
      paramView = new TextView(localFragmentActivity);
      paramView.setBackgroundColor(Color.parseColor("#F7F7F9"));
      paramView.setHeight(DisplayUtil.a(localFragmentActivity, 10.0F));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      ((AssociateSearchWordsFragment.ViewHolder)localObject).c = paramView;
      paramViewGroup.addView(paramView, localLayoutParams);
      paramView = new TextView(localFragmentActivity);
      paramView.setTextColor(localFragmentActivity.getResources().getColor(2131494270));
      paramView.setTextSize(1, 15.0F);
      paramView.setGravity(16);
      paramView.setIncludeFontPadding(false);
      paramView.setHeight(localFragmentActivity.getResources().getDimensionPixelSize(2131559435));
      paramView.setPadding(DisplayUtil.a(localFragmentActivity, 12.0F), 0, DisplayUtil.a(localFragmentActivity, 12.0F), 0);
      paramViewGroup.addView(paramView, new LinearLayout.LayoutParams(-1, -2));
      paramViewGroup.setClickable(false);
      paramViewGroup.setFocusable(false);
      paramViewGroup.setPadding(0, 0, 0, 0);
      ((AssociateSearchWordsFragment.ViewHolder)localObject).a = paramView;
      paramView = paramViewGroup;
      break;
      paramView = new TextView(localFragmentActivity);
      paramView.setTextColor(localFragmentActivity.getResources().getColor(2131494220));
      paramView.setTextSize(1, 18.0F);
      paramView.setSingleLine();
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setIncludeFontPadding(false);
      paramView.setCompoundDrawablesWithIntrinsicBounds(localFragmentActivity.getResources().getDrawable(2130846075), null, null, null);
      paramView.setCompoundDrawablePadding(DisplayUtil.a(localFragmentActivity, 4.0F));
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.setMargins(0, DisplayUtil.a(localFragmentActivity, 16.0F), 0, DisplayUtil.a(localFragmentActivity, 16.0F));
      paramViewGroup.addView(paramView, localLayoutParams);
      ((AssociateSearchWordsFragment.ViewHolder)localObject).a = paramView;
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a);
      paramView = paramViewGroup;
      break;
      paramView = new TextView(localFragmentActivity);
      paramView.setTextColor(localFragmentActivity.getResources().getColor(2131494220));
      paramView.setTextSize(1, 18.0F);
      paramView.setIncludeFontPadding(false);
      paramViewGroup.addView(paramView);
      ((AssociateSearchWordsFragment.ViewHolder)localObject).a = paramView;
      paramView = new TextView(localFragmentActivity);
      paramView.setTextColor(localFragmentActivity.getResources().getColor(2131494270));
      paramView.setTextSize(1, 14.0F);
      paramView.setIncludeFontPadding(false);
      paramViewGroup.addView(paramView);
      ((AssociateSearchWordsFragment.ViewHolder)localObject).b = paramView;
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a);
      paramView = paramViewGroup;
      break;
      paramView = new TextView(localFragmentActivity);
      paramView.setHeight(1);
      paramViewGroup.addView(paramView);
      paramViewGroup.setPadding(DisplayUtil.a(localFragmentActivity, 12.0F), 0, 0, 0);
      ((AssociateSearchWordsFragment.ViewHolder)localObject).c = paramView;
      paramViewGroup.setClickable(false);
      paramViewGroup.setFocusable(false);
      paramView = paramViewGroup;
      break;
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.AssociateSearchWordsFragment", 2, "SearchAssociatedWordAdapter.getView() itemType not support. value=" + getItemViewType(paramInt));
      }
      return null;
      if (paramInt == 0) {
        paramView.c.setVisibility(8);
      }
      for (;;)
      {
        paramView.a.setText(localAssociateItem.jdField_a_of_type_JavaLangString);
        break;
        paramView.c.setVisibility(0);
        if (bool) {
          paramView.c.setBackgroundColor(localFragmentActivity.getResources().getColor(2131492950));
        } else {
          paramView.c.setBackgroundColor(localFragmentActivity.getResources().getColor(2131492949));
        }
      }
      paramView.a.setText(localAssociateItem.jdField_a_of_type_JavaLangString);
      break label184;
      paramView.a.setText(localAssociateItem.jdField_a_of_type_JavaLangString);
      paramView.b.setText(localAssociateItem.e);
      if (TextUtils.isEmpty(localAssociateItem.jdField_a_of_type_JavaLangString))
      {
        paramView.a.setVisibility(8);
        ((LinearLayout.LayoutParams)paramView.b.getLayoutParams()).setMargins(0, DisplayUtil.a(localFragmentActivity, 16.0F), 0, DisplayUtil.a(localFragmentActivity, 16.0F));
        break label184;
      }
      paramView.a.setVisibility(0);
      localObject = (LinearLayout.LayoutParams)paramView.a.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, DisplayUtil.a(localFragmentActivity, 12.0F), 0, 0);
      paramView.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramView.b.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, DisplayUtil.a(localFragmentActivity, 5.0F), 0, DisplayUtil.a(localFragmentActivity, 12.0F));
      paramView.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label184;
      if (bool)
      {
        paramView.c.setBackgroundColor(localFragmentActivity.getResources().getColor(2131492950));
        break label184;
      }
      paramView.c.setBackgroundColor(localFragmentActivity.getResources().getColor(2131492949));
      break label184;
      paramViewGroup.setBackgroundResource(2130838585);
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.SearchAssociatedWordAdapter
 * JD-Core Version:    0.7.0.1
 */
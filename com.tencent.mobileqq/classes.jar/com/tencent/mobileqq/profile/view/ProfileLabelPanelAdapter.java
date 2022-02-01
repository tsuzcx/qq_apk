package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ToggleButton;
import asrd;
import bacc;
import bacd;
import bacf;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ProfileLabelPanelAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  public float a;
  protected int a;
  public Context a;
  protected SparseArray<bacf> a;
  protected asrd a;
  protected bacc a;
  public bacd a;
  protected bacf a;
  protected List<ProfileLabelTypeInfo> a;
  
  public ProfileLabelPanelAdapter(Context paramContext, List<ProfileLabelTypeInfo> paramList)
  {
    this.jdField_a_of_type_Asrd = new asrd();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
  }
  
  protected GridView a()
  {
    GridView localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
    localGridView.setPadding((int)(this.jdField_a_of_type_Float * 10.0F), 0, (int)(this.jdField_a_of_type_Float * 10.0F), 0);
    localGridView.setNumColumns(4);
    localGridView.setHorizontalSpacing((int)(this.jdField_a_of_type_Float * 4.0F));
    localGridView.setVerticalSpacing((int)(this.jdField_a_of_type_Float * 4.0F));
    return localGridView;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    this.jdField_a_of_type_Bacf = ((bacf)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    if (this.jdField_a_of_type_Bacf == null)
    {
      this.jdField_a_of_type_Bacf = new bacf(this, null);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, this.jdField_a_of_type_Bacf);
    }
    paramView = (GridView)paramView;
    this.jdField_a_of_type_Bacf.a(((ProfileLabelTypeInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).labels);
    paramView.setAdapter(this.jdField_a_of_type_Bacf);
  }
  
  public void a(bacc parambacc)
  {
    this.jdField_a_of_type_Bacc = parambacc;
  }
  
  public void a(bacd parambacd)
  {
    this.jdField_a_of_type_Bacd = parambacd;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    GridView localGridView = (GridView)paramObject;
    ((ViewGroup)paramView).removeView(localGridView);
    this.jdField_a_of_type_Asrd.a((View)paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    GridView localGridView2 = (GridView)this.jdField_a_of_type_Asrd.a();
    GridView localGridView1 = localGridView2;
    if (localGridView2 == null) {
      localGridView1 = a();
    }
    a(localGridView1, paramInt);
    if ((localGridView1.getParent() != paramView) && (paramInt < getCount())) {
      ((ViewGroup)paramView).addView(localGridView1);
    }
    return localGridView1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    ToggleButton localToggleButton = (ToggleButton)paramView;
    localToggleButton.toggle();
    ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)paramView.getTag();
    bacc localbacc;
    if (localProfileLabelInfo != null)
    {
      localbacc = this.jdField_a_of_type_Bacc;
      if (localProfileLabelInfo.labelStatus != ProfileLabelInfo.STATUS_CHECKED) {
        break label64;
      }
    }
    label64:
    for (boolean bool = false;; bool = true)
    {
      localbacc.a(localProfileLabelInfo, localToggleButton, Boolean.valueOf(bool));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileLabelPanelAdapter
 * JD-Core Version:    0.7.0.1
 */
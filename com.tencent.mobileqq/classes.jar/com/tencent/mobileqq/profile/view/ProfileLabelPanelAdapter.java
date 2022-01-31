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
import ankz;
import auai;
import auaj;
import aual;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import java.util.List;

public class ProfileLabelPanelAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  public float a;
  protected int a;
  public Context a;
  protected SparseArray<aual> a;
  protected ankz a;
  protected auai a;
  public auaj a;
  protected aual a;
  protected List<ProfileLabelTypeInfo> a;
  
  public ProfileLabelPanelAdapter(Context paramContext, List<ProfileLabelTypeInfo> paramList)
  {
    this.jdField_a_of_type_Ankz = new ankz();
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
    this.jdField_a_of_type_Aual = ((aual)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    if (this.jdField_a_of_type_Aual == null)
    {
      this.jdField_a_of_type_Aual = new aual(this, null);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, this.jdField_a_of_type_Aual);
    }
    paramView = (GridView)paramView;
    this.jdField_a_of_type_Aual.a(((ProfileLabelTypeInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).labels);
    paramView.setAdapter(this.jdField_a_of_type_Aual);
  }
  
  public void a(auai paramauai)
  {
    this.jdField_a_of_type_Auai = paramauai;
  }
  
  public void a(auaj paramauaj)
  {
    this.jdField_a_of_type_Auaj = paramauaj;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    GridView localGridView = (GridView)paramObject;
    ((ViewGroup)paramView).removeView(localGridView);
    this.jdField_a_of_type_Ankz.a((View)paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    GridView localGridView2 = (GridView)this.jdField_a_of_type_Ankz.a();
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
    paramView = (ProfileLabelInfo)paramView.getTag();
    auai localauai;
    if (paramView != null)
    {
      localauai = this.jdField_a_of_type_Auai;
      if (paramView.labelStatus != ProfileLabelInfo.STATUS_CHECKED) {
        break label53;
      }
    }
    label53:
    for (boolean bool = false;; bool = true)
    {
      localauai.a(paramView, localToggleButton, Boolean.valueOf(bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileLabelPanelAdapter
 * JD-Core Version:    0.7.0.1
 */
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
import apxu;
import awvm;
import awvn;
import awvp;
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
  protected SparseArray<awvp> a;
  protected apxu a;
  protected awvm a;
  public awvn a;
  protected awvp a;
  protected List<ProfileLabelTypeInfo> a;
  
  public ProfileLabelPanelAdapter(Context paramContext, List<ProfileLabelTypeInfo> paramList)
  {
    this.jdField_a_of_type_Apxu = new apxu();
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
    this.jdField_a_of_type_Awvp = ((awvp)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    if (this.jdField_a_of_type_Awvp == null)
    {
      this.jdField_a_of_type_Awvp = new awvp(this, null);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, this.jdField_a_of_type_Awvp);
    }
    paramView = (GridView)paramView;
    this.jdField_a_of_type_Awvp.a(((ProfileLabelTypeInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).labels);
    paramView.setAdapter(this.jdField_a_of_type_Awvp);
  }
  
  public void a(awvm paramawvm)
  {
    this.jdField_a_of_type_Awvm = paramawvm;
  }
  
  public void a(awvn paramawvn)
  {
    this.jdField_a_of_type_Awvn = paramawvn;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    GridView localGridView = (GridView)paramObject;
    ((ViewGroup)paramView).removeView(localGridView);
    this.jdField_a_of_type_Apxu.a((View)paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    GridView localGridView2 = (GridView)this.jdField_a_of_type_Apxu.a();
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
    awvm localawvm;
    if (paramView != null)
    {
      localawvm = this.jdField_a_of_type_Awvm;
      if (paramView.labelStatus != ProfileLabelInfo.STATUS_CHECKED) {
        break label53;
      }
    }
    label53:
    for (boolean bool = false;; bool = true)
    {
      localawvm.a(paramView, localToggleButton, Boolean.valueOf(bool));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileLabelPanelAdapter
 * JD-Core Version:    0.7.0.1
 */
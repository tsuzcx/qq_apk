package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ToggleButton;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ProfileLabelPanelAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  protected float a;
  protected int a;
  protected Context a;
  protected SparseArray<ProfileLabelPanelAdapter.AllLabelGridViewAdapter> a;
  protected PanelRecycleBin a;
  protected ProfileLabelCallBack a;
  protected ProfileLabelPanel.LabelStatusManager a;
  protected ProfileLabelPanelAdapter.AllLabelGridViewAdapter a;
  protected List<ProfileLabelTypeInfo> a;
  
  public ProfileLabelPanelAdapter(Context paramContext, List<ProfileLabelTypeInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin = new PanelRecycleBin();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
  }
  
  protected GridView a()
  {
    GridView localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
    float f = this.jdField_a_of_type_Float;
    localGridView.setPadding((int)(f * 10.0F), 0, (int)(f * 10.0F), 0);
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
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter$AllLabelGridViewAdapter = ((ProfileLabelPanelAdapter.AllLabelGridViewAdapter)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter$AllLabelGridViewAdapter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter$AllLabelGridViewAdapter = new ProfileLabelPanelAdapter.AllLabelGridViewAdapter(this, null);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter$AllLabelGridViewAdapter);
    }
    paramView = (GridView)paramView;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter$AllLabelGridViewAdapter.a(((ProfileLabelTypeInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).labels);
    paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter$AllLabelGridViewAdapter);
  }
  
  public void a(ProfileLabelCallBack paramProfileLabelCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelCallBack = paramProfileLabelCallBack;
  }
  
  public void a(ProfileLabelPanel.LabelStatusManager paramLabelStatusManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager = paramLabelStatusManager;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    GridView localGridView = (GridView)paramObject;
    ((ViewGroup)paramView).removeView(localGridView);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.addScrapView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    GridView localGridView2 = (GridView)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.getScrapView();
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
    if (localProfileLabelInfo != null)
    {
      ProfileLabelCallBack localProfileLabelCallBack = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelCallBack;
      boolean bool;
      if (localProfileLabelInfo.labelStatus == ProfileLabelInfo.STATUS_CHECKED) {
        bool = false;
      } else {
        bool = true;
      }
      localProfileLabelCallBack.a(localProfileLabelInfo, localToggleButton, Boolean.valueOf(bool));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileLabelPanelAdapter
 * JD-Core Version:    0.7.0.1
 */
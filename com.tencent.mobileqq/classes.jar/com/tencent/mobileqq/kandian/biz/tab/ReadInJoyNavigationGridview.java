package com.tencent.mobileqq.kandian.biz.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class ReadInJoyNavigationGridview
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private ReadInJoyNavigationAdapter jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationAdapter;
  private ReadInJoyNavigationGridview.NaviBarHandler jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview$NaviBarHandler;
  private ReadInJoyNavigationGridview.NaviMaskTouchListener jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview$NaviMaskTouchListener;
  private List<ChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ReadInJoyNavigationGridview(Context paramContext, ReadInJoyNavigationGridview.NaviMaskTouchListener paramNaviMaskTouchListener)
  {
    super(paramContext);
    a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview$NaviBarHandler = new ReadInJoyNavigationGridview.NaviBarHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview$NaviMaskTouchListener = paramNaviMaskTouchListener;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131560244, this));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371717));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371718);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationAdapter = new ReadInJoyNavigationAdapter(paramContext);
    GridView localGridView = this.jdField_a_of_type_AndroidWidgetGridView;
    localGridView.setPadding(localGridView.getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(paramContext), this.jdField_a_of_type_AndroidWidgetGridView.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationAdapter);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new ReadInJoyNavigationGridview.1(this));
  }
  
  private void b()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationAdapter.getCount();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetGridView;
  }
  
  public List<ChannelCoverInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview$NaviBarHandler.removeMessages(1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setChannelButtonListener(ReadInJoyNavigationAdapter.ChannelButtonListener paramChannelButtonListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationAdapter.a(paramChannelButtonListener);
  }
  
  public void setNaviBarAdapterDataSet(List<ChannelCoverInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyNavigationGridview$NaviBarHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNavigationGridview
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.daily;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBasePopupWindow;
import java.util.List;

public class ReadInJoyDailySettingPopupWindow
  extends ReadInJoyBasePopupWindow
{
  private ReadInJoyDailySettingPopupWindow.Callback jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingPopupWindow$Callback;
  private List<String> jdField_a_of_type_JavaUtilList;
  private List<String> b;
  protected boolean b;
  
  public ReadInJoyDailySettingPopupWindow(Activity paramActivity, ReadInJoyDailySettingPopupWindow.Callback paramCallback, List<String> paramList1, List<String> paramList2)
  {
    super(paramActivity);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingPopupWindow$Callback = paramCallback;
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.jdField_b_of_type_JavaUtilList = paramList2;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = (LinearLayout)paramLayoutInflater.inflate(2131560162, null);
    RecyclerView localRecyclerView = (RecyclerView)paramLayoutInflater.findViewById(2131365078);
    ReadInJoyDailyConfigAdapter localReadInJoyDailyConfigAdapter = new ReadInJoyDailyConfigAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailySettingPopupWindow$Callback);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity));
    localRecyclerView.setAdapter(localReadInJoyDailyConfigAdapter);
    return paramLayoutInflater;
  }
  
  public void b(View paramView)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      a();
      this.jdField_b_of_type_Boolean = true;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailySettingPopupWindow
 * JD-Core Version:    0.7.0.1
 */
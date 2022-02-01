package com.tencent.mobileqq.filemanager.data.search;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.search.searchtype.IQFileSearchTypeController;
import com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.Iterator;
import java.util.List;

public class SearchTypeFragment
  extends ReportV4Fragment
  implements View.OnClickListener
{
  public int a;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private View jdField_a_of_type_AndroidViewView;
  private IQFileSearchTypeController jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchtypeIQFileSearchTypeController;
  private SearchFileFlowLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout;
  public String a;
  public List<Integer> a;
  private SparseIntArray b = new SparseIntArray();
  
  public View a(int paramInt1, int paramInt2, int paramInt3)
  {
    FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(getActivity()).inflate(2131560934, (ViewGroup)this.jdField_a_of_type_AndroidViewView, false);
    LinearLayout localLinearLayout = (LinearLayout)localFrameLayout.findViewById(2131370663);
    TextView localTextView = (TextView)localFrameLayout.findViewById(2131380587);
    ((ImageView)localFrameLayout.findViewById(2131369801)).setImageDrawable(getResources().getDrawable(this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1)));
    localTextView.setText(this.b.get(paramInt1));
    localLinearLayout.setTag(Integer.valueOf(paramInt1));
    localLinearLayout.setOnClickListener(this);
    ((FrameLayout.LayoutParams)localFrameLayout.getLayoutParams()).width = (paramInt2 / paramInt3);
    return localFrameLayout;
  }
  
  public void a(IQFileSearchTypeController paramIQFileSearchTypeController)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchtypeIQFileSearchTypeController = paramIQFileSearchTypeController;
  }
  
  public void a(List<Integer> paramList, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout != null) && (paramList != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.setMaxNumInLineAndAlignMode(0, paramInt);
      int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.getMeasuredWidth();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FrameLayout localFrameLayout = (FrameLayout)a(((Integer)paramList.next()).intValue(), i, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.addView(localFrameLayout);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Integer localInteger = (Integer)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchtypeIQFileSearchTypeController != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSearchtypeIQFileSearchTypeController.a(localInteger.intValue());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(13, 2130844076);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(3, 2130844521);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2, 2130844525);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(0, 2130844524);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 2130844522);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(11, 2130844523);
    this.b.put(13, 2131697347);
    this.b.put(3, 2131697345);
    this.b.put(2, 2131697350);
    this.b.put(0, 2131697346);
    this.b.put(1, 2131697348);
    this.b.put(11, 2131697349);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560932, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout = ((SearchFileFlowLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367101));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.post(new SearchTypeFragment.1(this));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.SearchTypeFragment
 * JD-Core Version:    0.7.0.1
 */
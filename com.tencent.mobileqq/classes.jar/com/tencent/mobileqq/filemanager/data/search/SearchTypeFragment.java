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
import aoos;
import com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout;
import java.util.Iterator;
import java.util.List;

public class SearchTypeFragment
  extends Fragment
  implements View.OnClickListener
{
  public int a;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private View jdField_a_of_type_AndroidViewView;
  private aoos jdField_a_of_type_Aoos;
  private SearchFileFlowLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout;
  public String a;
  public List<Integer> a;
  private SparseIntArray b = new SparseIntArray();
  
  public View a(int paramInt1, int paramInt2, int paramInt3)
  {
    FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(getActivity()).inflate(2131494908, (ViewGroup)this.jdField_a_of_type_AndroidViewView, false);
    LinearLayout localLinearLayout = (LinearLayout)localFrameLayout.findViewById(2131303763);
    TextView localTextView = (TextView)localFrameLayout.findViewById(2131312512);
    ((ImageView)localFrameLayout.findViewById(2131303046)).setImageDrawable(getResources().getDrawable(this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1)));
    localTextView.setText(this.b.get(paramInt1));
    localLinearLayout.setTag(Integer.valueOf(paramInt1));
    localLinearLayout.setOnClickListener(this);
    ((FrameLayout.LayoutParams)localFrameLayout.getLayoutParams()).width = (paramInt2 / paramInt3);
    return localFrameLayout;
  }
  
  public void a(aoos paramaoos)
  {
    this.jdField_a_of_type_Aoos = paramaoos;
  }
  
  public void a(List<Integer> paramList, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout != null)
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
    paramView = (Integer)paramView.getTag();
    if (this.jdField_a_of_type_Aoos != null) {
      this.jdField_a_of_type_Aoos.a(paramView.intValue());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(13, 2130843145);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(3, 2130843455);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2, 2130843459);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(0, 2130843458);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 2130843456);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(11, 2130843457);
    this.b.put(13, 2131631901);
    this.b.put(3, 2131631899);
    this.b.put(2, 2131631904);
    this.b.put(0, 2131631900);
    this.b.put(1, 2131631902);
    this.b.put(11, 2131631903);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131494906, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout = ((SearchFileFlowLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300736));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.post(new SearchTypeFragment.1(this));
    return this.jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.SearchTypeFragment
 * JD-Core Version:    0.7.0.1
 */
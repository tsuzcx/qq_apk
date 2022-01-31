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
import arcy;
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
  private arcy jdField_a_of_type_Arcy;
  private SearchFileFlowLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout;
  public String a;
  public List<Integer> a;
  private SparseIntArray b = new SparseIntArray();
  
  public View a(int paramInt1, int paramInt2, int paramInt3)
  {
    FrameLayout localFrameLayout = (FrameLayout)LayoutInflater.from(getActivity()).inflate(2131560672, (ViewGroup)this.jdField_a_of_type_AndroidViewView, false);
    LinearLayout localLinearLayout = (LinearLayout)localFrameLayout.findViewById(2131369711);
    TextView localTextView = (TextView)localFrameLayout.findViewById(2131378991);
    ((ImageView)localFrameLayout.findViewById(2131368907)).setImageDrawable(getResources().getDrawable(this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1)));
    localTextView.setText(this.b.get(paramInt1));
    localLinearLayout.setTag(Integer.valueOf(paramInt1));
    localLinearLayout.setOnClickListener(this);
    ((FrameLayout.LayoutParams)localFrameLayout.getLayoutParams()).width = (paramInt2 / paramInt3);
    return localFrameLayout;
  }
  
  public void a(arcy paramarcy)
  {
    this.jdField_a_of_type_Arcy = paramarcy;
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
    paramView = (Integer)paramView.getTag();
    if (this.jdField_a_of_type_Arcy != null) {
      this.jdField_a_of_type_Arcy.a(paramView.intValue());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(13, 2130843426);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(3, 2130843971);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2, 2130843975);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(0, 2130843974);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 2130843972);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(11, 2130843973);
    this.b.put(13, 2131697793);
    this.b.put(3, 2131697791);
    this.b.put(2, 2131697796);
    this.b.put(0, 2131697792);
    this.b.put(1, 2131697794);
    this.b.put(11, 2131697795);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560670, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout = ((SearchFileFlowLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366453));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.post(new SearchTypeFragment.1(this));
    return this.jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.SearchTypeFragment
 * JD-Core Version:    0.7.0.1
 */
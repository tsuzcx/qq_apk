package com.tencent.mobileqq.nearby.interestTag;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class InterestTagAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private InterestTagItemView.IInterestTagItemViewCallback jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagItemView$IInterestTagItemViewCallback;
  private List<InterestTagInfo> jdField_a_of_type_JavaUtilList;
  
  public InterestTagAdapter(Context paramContext, int paramInt, List<InterestTagInfo> paramList, InterestTagItemView.IInterestTagItemViewCallback paramIInterestTagItemViewCallback)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagItemView$IInterestTagItemViewCallback = paramIInterestTagItemViewCallback;
  }
  
  public InterestTagInfo a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > paramInt)) {
      return (InterestTagInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<InterestTagInfo> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramBoolean) {
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new InterestTagItemView(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(this.jdField_a_of_type_Int);
      paramView.setCallback(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagItemView$IInterestTagItemViewCallback);
    }
    else
    {
      paramView = (InterestTagItemView)paramView;
    }
    paramView.a(a(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTagAdapter
 * JD-Core Version:    0.7.0.1
 */
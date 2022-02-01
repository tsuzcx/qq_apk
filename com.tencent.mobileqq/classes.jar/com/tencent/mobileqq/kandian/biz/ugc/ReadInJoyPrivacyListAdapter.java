package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import java.util.List;

public class ReadInJoyPrivacyListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<Long> jdField_a_of_type_JavaUtilList;
  
  public ReadInJoyPrivacyListAdapter(Context paramContext, List<Long> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    View localView = null;
    if (localList != null)
    {
      if (localList.size() <= paramInt) {
        return null;
      }
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560258, paramViewGroup, false);
        paramViewGroup = new ReadInJoyPrivacyListAdapter.PrivacyItemViewHolder();
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131376818));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)localView.findViewById(2131369373));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)localView.findViewById(2131379784));
        localView.setTag(paramViewGroup);
      }
      else
      {
        paramViewGroup = localView;
        localView = paramView;
        if ((paramView.getTag() instanceof ReadInJoyPrivacyListAdapter.PrivacyItemViewHolder))
        {
          paramViewGroup = (ReadInJoyPrivacyListAdapter.PrivacyItemViewHolder)paramView.getTag();
          localView = paramView;
        }
      }
      if (paramViewGroup != null)
      {
        long l = ((Long)this.jdField_a_of_type_JavaUtilList.get(paramInt)).longValue();
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setHeadImgByUin(l);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setNickNameByUin(l);
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131376109, Integer.valueOf(paramInt));
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      }
      return localView;
    }
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131376818) {
      return;
    }
    if (paramView.getTag(2131376109) != null)
    {
      int i = ((Integer)paramView.getTag(2131376109)).intValue();
      paramView = this.jdField_a_of_type_JavaUtilList;
      if ((paramView != null) && (paramView.size() > i)) {
        ReadInJoyCommentUtils.a(String.valueOf(this.jdField_a_of_type_JavaUtilList.get(i)), this.jdField_a_of_type_AndroidContentContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyPrivacyListAdapter
 * JD-Core Version:    0.7.0.1
 */
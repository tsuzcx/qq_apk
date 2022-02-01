package com.tencent.mobileqq.kandian.biz.pts.component;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.HashMap;
import java.util.List;

class ComponentContentRecommendFollowList$FollowListAdapter
  extends BaseAdapter
{
  private List<RecommendFollowInfo> jdField_a_of_type_JavaUtilList;
  
  private ComponentContentRecommendFollowList$FollowListAdapter(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList) {}
  
  public void a(List<RecommendFollowInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
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
    int j = 0;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560266, paramViewGroup, false);
      paramViewGroup = new ComponentContentRecommendFollowList.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368058));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368067));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380362));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377820));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371884));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378309));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367080));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367072));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ComponentContentRecommendFollowList.ViewHolder)paramView.getTag();
    }
    RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo = localRecommendFollowInfo;
    paramViewGroup.jdField_a_of_type_Int = paramInt;
    ComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList).mRecommendFollowInfos.a.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
    if (!TextUtils.isEmpty(localRecommendFollowInfo.headUrl))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = ImageUtil.e();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
      localObject = URLDrawable.getDrawable(localRecommendFollowInfo.headUrl, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.a);
      ((URLDrawable)localObject).setFadeInImage(true);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    else
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.e());
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.nickName);
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
    if (localRecommendFollowInfo.isFollowed)
    {
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702525));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849733);
    }
    else
    {
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702515));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849689);
    }
    Object localObject = paramViewGroup.jdField_b_of_type_AndroidWidgetImageView;
    int i;
    if (localRecommendFollowInfo.isVip) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
    paramViewGroup = paramViewGroup.jdField_c_of_type_AndroidWidgetImageView;
    if (localRecommendFollowInfo.isStar) {
      i = j;
    } else {
      i = 8;
    }
    paramViewGroup.setVisibility(i);
    ComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList);
    ComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList, paramInt, localRecommendFollowInfo);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowList.FollowListAdapter
 * JD-Core Version:    0.7.0.1
 */
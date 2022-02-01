package com.tencent.mobileqq.kandian.biz.pts.view;

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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.HashMap;
import java.util.List;

class ReadInJoySocializeRecommendFollowView$FollowListAdapter
  extends BaseAdapter
{
  private List<RecommendFollowInfo> jdField_a_of_type_JavaUtilList;
  
  private ReadInJoySocializeRecommendFollowView$FollowListAdapter(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView) {}
  
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
    int i = 0;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560266, paramViewGroup, false);
      paramViewGroup = new ReadInJoySocializeRecommendFollowView.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368058));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368067));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380362));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377820));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371884));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378309));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367080));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367072));
      paramView.setTag(paramViewGroup);
      paramView.setBackgroundResource(2130843086);
      paramView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ReadInJoySocializeRecommendFollowView.ViewHolder)paramView.getTag();
    }
    RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo = localRecommendFollowInfo;
    ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView).mRecommendFollowInfos.a.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
    Object localObject2;
    if (!TextUtils.isEmpty(localRecommendFollowInfo.headUrl))
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = ImageUtil.e();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      localObject1 = URLDrawable.getDrawable(localRecommendFollowInfo.headUrl, (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.a);
      ((URLDrawable)localObject1).setFadeInImage(true);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    }
    else
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.e());
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.nickName);
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
    if (localRecommendFollowInfo.isFollowed)
    {
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712929));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849733);
    }
    else
    {
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131712930));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849689);
    }
    Object localObject1 = paramViewGroup.jdField_b_of_type_AndroidWidgetImageView;
    if (localRecommendFollowInfo.isVip) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    ((ImageView)localObject1).setVisibility(paramInt);
    paramViewGroup = paramViewGroup.jdField_c_of_type_AndroidWidgetImageView;
    if (localRecommendFollowInfo.isStar) {
      paramInt = i;
    } else {
      paramInt = 8;
    }
    paramViewGroup.setVisibility(paramInt);
    if (!localRecommendFollowInfo.hasReport)
    {
      localRecommendFollowInfo.hasReport = true;
      paramViewGroup = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localRecommendFollowInfo.uin);
      ((StringBuilder)localObject2).append("");
      paramViewGroup.publicAccountReportClickEvent(null, (String)localObject1, "0X8009848", "0X8009848", 0, 0, "1", ((StringBuilder)localObject2).toString(), "", "", false);
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.FollowListAdapter
 * JD-Core Version:    0.7.0.1
 */
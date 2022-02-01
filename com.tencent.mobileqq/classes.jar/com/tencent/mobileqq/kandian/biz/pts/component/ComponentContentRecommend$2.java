package com.tencent.mobileqq.kandian.biz.pts.component;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.view.widget.RingAvatarView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

class ComponentContentRecommend$2
  extends BaseAdapter
{
  ComponentContentRecommend$2(ComponentContentRecommend paramComponentContentRecommend) {}
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getCount()
  {
    return ComponentContentRecommend.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return ComponentContentRecommend.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)ComponentContentRecommend.a(this.a).get(paramInt);
    ComponentContentRecommend.a(this.a).mRecommendFollowInfos.a.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.a.getContext()).inflate(2131562704, null, false);
      paramView = new ComponentContentRecommend.FollowHolder(this.a);
      paramView.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramViewGroup.findViewById(2131368066));
      paramView.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRingAvatarView = ((RingAvatarView)paramViewGroup.findViewById(2131375988));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368119));
      paramView.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramViewGroup.findViewById(2131378884));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365534));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131363938));
      paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131365759);
      paramViewGroup.setTag(paramView);
    }
    else
    {
      ComponentContentRecommend.FollowHolder localFollowHolder = (ComponentContentRecommend.FollowHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localFollowHolder;
    }
    if (paramView != null)
    {
      try
      {
        paramView.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setImage(new URL(localRecommendFollowInfo.headUrl));
      }
      catch (MalformedURLException localMalformedURLException)
      {
        String str = ComponentContentRecommend.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getView, followItem.headUrl = ");
        localStringBuilder.append(localRecommendFollowInfo.headUrl);
        localStringBuilder.append(", e = ");
        localStringBuilder.append(QLog.getStackTraceString(localMalformedURLException));
        QLog.e(str, 2, localStringBuilder.toString());
        localMalformedURLException.printStackTrace();
      }
      ComponentContentRecommend.2.1 local1 = new ComponentContentRecommend.2.1(this, localRecommendFollowInfo);
      paramView.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyHeadImageView.setOnClickListener(local1);
      paramView.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setOnClickListener(local1);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(local1);
      if (localRecommendFollowInfo.isStar) {
        paramView.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRingAvatarView.showStarRing();
      } else {
        paramView.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRingAvatarView.showNormal();
      }
      if (localRecommendFollowInfo.isVip) {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(localRecommendFollowInfo.nickName);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
      if (localRecommendFollowInfo.isFollowed)
      {
        paramView.b.setText(HardCodeUtil.a(2131702534));
        paramView.b.setTextColor(Color.parseColor("#777777"));
        paramView.b.setBackgroundResource(2130849733);
      }
      else
      {
        paramView.b.setText(HardCodeUtil.a(2131702485));
        paramView.b.setTextColor(-1);
        paramView.b.setBackgroundResource(2130849689);
        paramView.b.setCompoundDrawablePadding(AIOUtils.b(3.0F, this.a.getResources()));
      }
      paramView.b.setOnClickListener(new ComponentContentRecommend.2.2(this, localRecommendFollowInfo));
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    return paramViewGroup;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommend.2
 * JD-Core Version:    0.7.0.1
 */
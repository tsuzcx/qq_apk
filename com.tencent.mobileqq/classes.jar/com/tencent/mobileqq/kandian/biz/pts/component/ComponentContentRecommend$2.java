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
    return ComponentContentRecommend.d(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return ComponentContentRecommend.d(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)ComponentContentRecommend.d(this.a).get(paramInt);
    ComponentContentRecommend.b(this.a).mRecommendFollowInfos.h.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.a.getContext()).inflate(2131629135, null, false);
      paramView = new ComponentContentRecommend.FollowHolder(this.a);
      paramView.a = ((ReadInJoyHeadImageView)paramViewGroup.findViewById(2131434916));
      paramView.b = ((RingAvatarView)paramViewGroup.findViewById(2131444175));
      paramView.c = ((ImageView)paramViewGroup.findViewById(2131434973));
      paramView.d = ((ReadInJoyNickNameTextView)paramViewGroup.findViewById(2131447585));
      paramView.e = ((TextView)paramViewGroup.findViewById(2131431753));
      paramView.f = ((TextView)paramViewGroup.findViewById(2131429893));
      paramView.g = paramViewGroup.findViewById(2131432003);
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
        paramView.a.setImage(new URL(localRecommendFollowInfo.headUrl));
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
      paramView.a.setOnClickListener(local1);
      paramView.d.setOnClickListener(local1);
      paramView.e.setOnClickListener(local1);
      if (localRecommendFollowInfo.isStar) {
        paramView.b.showStarRing();
      } else {
        paramView.b.showNormal();
      }
      if (localRecommendFollowInfo.isVip) {
        paramView.c.setVisibility(0);
      } else {
        paramView.c.setVisibility(8);
      }
      paramView.d.setText(localRecommendFollowInfo.nickName);
      paramView.e.setText(localRecommendFollowInfo.recommendReason);
      if (localRecommendFollowInfo.isFollowed)
      {
        paramView.f.setText(HardCodeUtil.a(2131900527));
        paramView.f.setTextColor(Color.parseColor("#777777"));
        paramView.f.setBackgroundResource(2130851442);
      }
      else
      {
        paramView.f.setText(HardCodeUtil.a(2131899712));
        paramView.f.setTextColor(-1);
        paramView.f.setBackgroundResource(2130851394);
        paramView.f.setCompoundDrawablePadding(AIOUtils.b(3.0F, this.a.getResources()));
      }
      paramView.f.setOnClickListener(new ComponentContentRecommend.2.2(this, localRecommendFollowInfo));
      paramView.g.setVisibility(8);
    }
    return paramViewGroup;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommend.2
 * JD-Core Version:    0.7.0.1
 */
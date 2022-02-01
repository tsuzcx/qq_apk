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
  private List<RecommendFollowInfo> b;
  
  private ComponentContentRecommendFollowList$FollowListAdapter(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList) {}
  
  public void a(List<RecommendFollowInfo> paramList)
  {
    this.b = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.b;
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
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626313, paramViewGroup, false);
      paramViewGroup = new ComponentContentRecommendFollowList.ViewHolder(this.a, null);
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131434908));
      paramViewGroup.a = ((RelativeLayout)paramView.findViewById(2131434917));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131449308));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131446289));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131439327));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131446828));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131433533));
      paramViewGroup.h = ((LinearLayout)paramView.findViewById(2131433525));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(paramViewGroup);
      paramViewGroup.a.setOnClickListener(paramViewGroup);
      paramViewGroup.e.setOnClickListener(paramViewGroup);
      paramViewGroup.h.setOnClickListener(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ComponentContentRecommendFollowList.ViewHolder)paramView.getTag();
    }
    RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)this.b.get(paramInt);
    paramViewGroup.i = localRecommendFollowInfo;
    paramViewGroup.j = paramInt;
    ComponentContentRecommendFollowList.b(this.a).mRecommendFollowInfos.h.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
    if (!TextUtils.isEmpty(localRecommendFollowInfo.headUrl))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = ImageUtil.j();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
      localObject = URLDrawable.getDrawable(localRecommendFollowInfo.headUrl, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.b);
      ((URLDrawable)localObject).setFadeInImage(true);
      paramViewGroup.b.setImageDrawable((Drawable)localObject);
    }
    else
    {
      paramViewGroup.b.setImageDrawable(ImageUtil.j());
    }
    paramViewGroup.e.setText(localRecommendFollowInfo.nickName);
    paramViewGroup.f.setText(localRecommendFollowInfo.recommendReason);
    if (localRecommendFollowInfo.isFollowed)
    {
      paramViewGroup.g.setText(HardCodeUtil.a(2131900520));
      paramViewGroup.g.setTextColor(-8947849);
      paramViewGroup.h.setBackgroundResource(2130851442);
    }
    else
    {
      paramViewGroup.g.setText(HardCodeUtil.a(2131899712));
      paramViewGroup.g.setTextColor(-1);
      paramViewGroup.h.setBackgroundResource(2130851394);
    }
    Object localObject = paramViewGroup.c;
    int i;
    if (localRecommendFollowInfo.isVip) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
    paramViewGroup = paramViewGroup.d;
    if (localRecommendFollowInfo.isStar) {
      i = j;
    } else {
      i = 8;
    }
    paramViewGroup.setVisibility(i);
    ComponentContentRecommendFollowList.c(this.a);
    ComponentContentRecommendFollowList.a(this.a, paramInt, localRecommendFollowInfo);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowList.FollowListAdapter
 * JD-Core Version:    0.7.0.1
 */
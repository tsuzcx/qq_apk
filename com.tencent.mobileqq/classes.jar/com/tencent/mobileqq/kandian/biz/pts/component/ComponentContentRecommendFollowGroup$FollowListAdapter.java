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
import com.tencent.mobileqq.kandian.repo.feeds.GroupRecommendAccount;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.HashMap;
import java.util.List;

class ComponentContentRecommendFollowGroup$FollowListAdapter
  extends BaseAdapter
{
  private List<GroupRecommendAccount> b;
  
  private ComponentContentRecommendFollowGroup$FollowListAdapter(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void a(List<GroupRecommendAccount> paramList)
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
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    int i;
    Object localObject1;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626311, paramViewGroup, false);
      paramViewGroup = new ComponentContentRecommendFollowGroup.ViewHolder(this.a, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131434457));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131433533));
      paramViewGroup.c = ((LinearLayout)paramView.findViewById(2131433525));
      paramViewGroup.d = ((LinearLayout)paramView.findViewById(2131434429));
      paramViewGroup.e = new RelativeLayout[3];
      paramViewGroup.f = new ImageView[3];
      paramViewGroup.g = new ImageView[3];
      paramViewGroup.h = new ImageView[3];
      paramViewGroup.i = new TextView[3];
      i = 0;
      while (i < paramViewGroup.d.getChildCount())
      {
        localObject1 = (RelativeLayout)paramViewGroup.d.getChildAt(i);
        paramViewGroup.e[i] = ((RelativeLayout)((RelativeLayout)localObject1).findViewById(2131434917));
        paramViewGroup.f[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131434908));
        paramViewGroup.g[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131449308));
        paramViewGroup.h[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131446289));
        paramViewGroup.i[i] = ((TextView)((RelativeLayout)localObject1).findViewById(2131439327));
        paramViewGroup.e[i].setOnClickListener(paramViewGroup);
        paramViewGroup.i[i].setOnClickListener(paramViewGroup);
        i += 1;
      }
      paramView.setTag(paramViewGroup);
      paramViewGroup.c.setOnClickListener(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ComponentContentRecommendFollowGroup.ViewHolder)paramView.getTag();
    }
    paramViewGroup.j = ((GroupRecommendAccount)this.b.get(paramInt));
    paramViewGroup.a.setText(paramViewGroup.j.a);
    paramInt = 0;
    while (paramInt < paramViewGroup.j.b.size())
    {
      localObject1 = (RecommendFollowInfo)paramViewGroup.j.b.get(paramInt);
      paramViewGroup.i[paramInt].setText(((RecommendFollowInfo)localObject1).nickName);
      paramViewGroup.i[paramInt].setTag(localObject1);
      paramViewGroup.e[paramInt].setTag(localObject1);
      if (!TextUtils.isEmpty(((RecommendFollowInfo)localObject1).headUrl))
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = ImageUtil.j();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
        localObject2 = URLDrawable.getDrawable(((RecommendFollowInfo)localObject1).headUrl, (URLDrawable.URLDrawableOptions)localObject2);
        ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.b);
        ((URLDrawable)localObject2).setFadeInImage(true);
        paramViewGroup.f[paramInt].setImageDrawable((Drawable)localObject2);
      }
      else
      {
        paramViewGroup.f[paramInt].setImageDrawable(ImageUtil.j());
      }
      Object localObject2 = paramViewGroup.g[paramInt];
      boolean bool = ((RecommendFollowInfo)localObject1).isVip;
      int k = 8;
      if (bool) {
        i = 0;
      } else {
        i = 8;
      }
      ((ImageView)localObject2).setVisibility(i);
      localObject2 = paramViewGroup.h[paramInt];
      i = k;
      if (((RecommendFollowInfo)localObject1).isStar) {
        i = 0;
      }
      ((ImageView)localObject2).setVisibility(i);
      ComponentContentRecommendFollowGroup.b(this.a).mRecommendFollowInfos.h.put(Long.valueOf(((RecommendFollowInfo)localObject1).uin), localObject1);
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < paramViewGroup.j.b.size())
    {
      if (!((RecommendFollowInfo)paramViewGroup.j.b.get(paramInt)).isFollowed)
      {
        paramInt = j;
        break label646;
      }
      paramInt += 1;
    }
    paramInt = 1;
    label646:
    if (paramInt != 0)
    {
      paramViewGroup.b.setText(HardCodeUtil.a(2131900444));
      paramViewGroup.b.setTextColor(-8947849);
      paramViewGroup.c.setBackgroundResource(2130851442);
      return paramView;
    }
    paramViewGroup.b.setText(HardCodeUtil.a(2131900478));
    paramViewGroup.b.setTextColor(-1);
    paramViewGroup.c.setBackgroundResource(2130851394);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowGroup.FollowListAdapter
 * JD-Core Version:    0.7.0.1
 */
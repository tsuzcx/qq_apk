package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;

class ComponentContentRecommendFollowList$ViewHolder
  implements View.OnClickListener
{
  RelativeLayout a;
  ImageView b;
  ImageView c;
  ImageView d;
  TextView e;
  TextView f;
  TextView g;
  LinearLayout h;
  RecommendFollowInfo i;
  int j;
  
  private ComponentContentRecommendFollowList$ViewHolder(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131434917: 
    case 2131436054: 
    case 2131439327: 
      this.k.b(this.i);
      ComponentContentRecommendFollowList.a(this.k, this.i, this.j);
      return;
    }
    paramView = this.k;
    RecommendFollowInfo localRecommendFollowInfo = this.i;
    paramView.a(localRecommendFollowInfo, localRecommendFollowInfo.isFollowed ^ true);
    ComponentContentRecommendFollowList.a(this.k, this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowList.ViewHolder
 * JD-Core Version:    0.7.0.1
 */
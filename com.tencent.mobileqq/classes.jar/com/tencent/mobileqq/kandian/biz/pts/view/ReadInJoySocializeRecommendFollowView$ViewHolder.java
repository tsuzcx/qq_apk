package com.tencent.mobileqq.kandian.biz.pts.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;

class ReadInJoySocializeRecommendFollowView$ViewHolder
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
  
  private ReadInJoySocializeRecommendFollowView$ViewHolder(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131434917: 
    case 2131436054: 
    case 2131439327: 
      ReadInJoySocializeRecommendFollowView.b(this.j, this.i);
      paramView = new StringBuilder();
      paramView.append(RIJQQAppInterfaceUtil.c());
      paramView.append("");
      paramView = paramView.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.i.uin);
      ((StringBuilder)localObject).append("");
      PublicAccountReportUtils.a(null, paramView, "0X8009849", "0X8009849", 0, 0, "1", ((StringBuilder)localObject).toString(), "", "", false);
      return;
    }
    paramView = this.j;
    Object localObject = this.i;
    paramView.a((RecommendFollowInfo)localObject, ((RecommendFollowInfo)localObject).isFollowed ^ true);
    paramView = new StringBuilder();
    paramView.append(RIJQQAppInterfaceUtil.c());
    paramView.append("");
    paramView = paramView.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.i.uin);
    ((StringBuilder)localObject).append("");
    PublicAccountReportUtils.a(null, paramView, "0X800984A", "0X800984A", 0, 0, "1", ((StringBuilder)localObject).toString(), "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.ViewHolder
 * JD-Core Version:    0.7.0.1
 */
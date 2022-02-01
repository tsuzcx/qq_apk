package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.feeds.GroupRecommendAccount;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import java.util.List;

class ComponentContentRecommendFollowGroup$ViewHolder
  implements View.OnClickListener
{
  TextView a;
  TextView b;
  LinearLayout c;
  LinearLayout d;
  RelativeLayout[] e;
  ImageView[] f;
  ImageView[] g;
  ImageView[] h;
  TextView[] i;
  GroupRecommendAccount j;
  
  private ComponentContentRecommendFollowGroup$ViewHolder(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m != 2131433525)
    {
      if ((m != 2131434917) && (m != 2131439327)) {
        return;
      }
      this.k.a((RecommendFollowInfo)paramView.getTag());
      return;
    }
    int n = 0;
    m = 0;
    while (m < this.j.b.size())
    {
      if (!((RecommendFollowInfo)this.j.b.get(m)).isFollowed)
      {
        m = n;
        break label95;
      }
      m += 1;
    }
    m = 1;
    label95:
    this.k.a(this.j.b, m ^ 0x1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowGroup.ViewHolder
 * JD-Core Version:    0.7.0.1
 */
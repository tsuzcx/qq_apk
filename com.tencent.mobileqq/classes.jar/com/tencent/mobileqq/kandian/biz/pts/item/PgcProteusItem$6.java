package com.tencent.mobileqq.kandian.biz.pts.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import java.util.ArrayList;

class PgcProteusItem$6
  implements View.OnClickListener
{
  PgcProteusItem$6(PgcProteusItem paramPgcProteusItem, IReadInJoyModel paramIReadInJoyModel, Container paramContainer, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.k().mSocialFeedInfo.t;
    ArrayList localArrayList = paramView.a;
    if (localArrayList != null)
    {
      if (localArrayList.size() == 0) {
        return;
      }
      paramView = (PGCPicInfo)paramView.a.get(0);
      PgcProteusItem.a(this.d, this.b.getContext(), this.a.k(), (int)paramView.h, this.a.k().innerUniqueID, this.c, 0, (ReadInJoyBaseAdapter)this.a.u());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcProteusItem.6
 * JD-Core Version:    0.7.0.1
 */
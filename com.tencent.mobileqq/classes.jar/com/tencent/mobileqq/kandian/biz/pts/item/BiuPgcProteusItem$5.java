package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage.OnGalleryItemClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import java.util.ArrayList;

class BiuPgcProteusItem$5
  implements ComponentContentGridImage.OnGalleryItemClickListener
{
  BiuPgcProteusItem$5(BiuPgcProteusItem paramBiuPgcProteusItem, IReadInJoyModel paramIReadInJoyModel, Container paramContainer, int paramInt) {}
  
  public void a(int paramInt)
  {
    Object localObject = this.a.k().mSocialFeedInfo.t;
    ArrayList localArrayList = ((PGCFeedsInfo)localObject).a;
    if (localArrayList != null)
    {
      if (localArrayList.size() == 0) {
        return;
      }
      localObject = (PGCPicInfo)((PGCFeedsInfo)localObject).a.get(paramInt);
      BiuPgcProteusItem.a(this.d, this.b.getContext(), this.a.k(), (int)((PGCPicInfo)localObject).h, this.a.k().innerUniqueID, this.c, paramInt, (ReadInJoyBaseAdapter)this.a.u());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.BiuPgcProteusItem.5
 * JD-Core Version:    0.7.0.1
 */
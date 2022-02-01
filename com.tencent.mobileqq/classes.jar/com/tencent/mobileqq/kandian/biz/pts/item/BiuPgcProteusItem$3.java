package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnSubRegionClickListener;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage.OnNoItemClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class BiuPgcProteusItem$3
  implements ComponentContentGridImage.OnNoItemClickListener
{
  BiuPgcProteusItem$3(BiuPgcProteusItem paramBiuPgcProteusItem, IReadInJoyModel paramIReadInJoyModel) {}
  
  public void a()
  {
    OnSubRegionClickListener localOnSubRegionClickListener = ((ReadInJoyBaseAdapter)this.a.u()).y().c();
    if (localOnSubRegionClickListener != null) {
      localOnSubRegionClickListener.a(null, this.a.k(), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.BiuPgcProteusItem.3
 * JD-Core Version:    0.7.0.1
 */
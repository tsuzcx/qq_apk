package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;

class BiuPgcProteusItem$1
  implements ViewBase.OnClickListener
{
  BiuPgcProteusItem$1(BiuPgcProteusItem paramBiuPgcProteusItem, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    BiuPgcProteusItem.a(this.d, this.a.getContext(), this.b, this.c);
    if (QLog.isColorLevel())
    {
      paramViewBase = new StringBuilder();
      paramViewBase.append("click gallery summary for jumping to gallery articleinfo = ");
      paramViewBase.append(this.b.k());
      paramViewBase.append(" position = ");
      paramViewBase.append(this.c);
      QLog.d("BiuPgcProteusItem", 2, paramViewBase.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.BiuPgcProteusItem.1
 * JD-Core Version:    0.7.0.1
 */
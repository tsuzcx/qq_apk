package com.tencent.mobileqq.kandian.biz.pts.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;

class BiuPgcProteusItem$2
  implements View.OnClickListener
{
  BiuPgcProteusItem$2(BiuPgcProteusItem paramBiuPgcProteusItem, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt) {}
  
  public void onClick(View paramView)
  {
    BiuPgcProteusItem.a(this.d, this.a.getContext(), this.b, this.c);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("click bottom bar for jumping to gallery articleinfo = ");
      paramView.append(this.b.k());
      paramView.append(" position = ");
      paramView.append(this.c);
      QLog.d("BiuPgcProteusItem", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.BiuPgcProteusItem.2
 * JD-Core Version:    0.7.0.1
 */
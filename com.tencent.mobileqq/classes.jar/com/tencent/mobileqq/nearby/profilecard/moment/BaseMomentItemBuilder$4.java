package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class BaseMomentItemBuilder$4
  implements DialogInterface.OnClickListener
{
  BaseMomentItemBuilder$4(BaseMomentItemBuilder paramBaseMomentItemBuilder, MomentFeedInfo paramMomentFeedInfo, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.c.a))
    {
      QQToast.makeText(this.c.a, 1, HardCodeUtil.a(2131899256), 0).show();
      return;
    }
    ((NearbyMomentManager)this.c.c.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.a.f, this.a.j, this.a.g, new BaseMomentItemBuilder.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */
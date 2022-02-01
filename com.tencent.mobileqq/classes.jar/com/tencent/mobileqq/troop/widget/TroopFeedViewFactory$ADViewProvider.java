package com.tencent.mobileqq.troop.widget;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class TroopFeedViewFactory$ADViewProvider
  extends TroopFeedViewFactory.ViewProvider
{
  public TroopAioTopADInfo a;
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    if (paramView == null) {
      paramView = LayoutInflater.from(this.b.a).inflate(2131626656, null);
    }
    Object localObject1 = (TroopFeedViewFactory.ADViewProvider.ViewHolder)paramView.getTag();
    paramTroopFeedItem = (TroopFeedItem)localObject1;
    if (localObject1 == null)
    {
      paramTroopFeedItem = new TroopFeedViewFactory.ADViewProvider.ViewHolder(this);
      paramTroopFeedItem.a = ((URLImageView)paramView.findViewById(2131427708));
      paramView.setOnClickListener(this.b);
      paramView.setTag(paramTroopFeedItem);
    }
    if (!NetworkUtil.isNetSupport(this.b.a))
    {
      if (this.b.g == null) {
        break label300;
      }
      this.b.g.d();
      return paramView;
    }
    try
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      Object localObject2 = new EmptyDrawable(1, 1);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      localObject1 = URLDrawable.getDrawable(this.a.uiUrl, (URLDrawable.URLDrawableOptions)localObject1);
      paramTroopFeedItem.a.setBackgroundDrawable((Drawable)localObject1);
      if (QLog.isColorLevel())
      {
        paramTroopFeedItem = new StringBuilder();
        paramTroopFeedItem.append("URLDrawable: ");
        paramTroopFeedItem.append(this.a.uiUrl);
        QLog.i("TroopAioADManager", 2, paramTroopFeedItem.toString());
      }
      paramTroopFeedItem = this.b.b;
      localObject1 = this.b.c.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.adId);
      ((StringBuilder)localObject2).append("");
      ReportController.b(paramTroopFeedItem, "P_CliOper", "Grp_AIO", "", "notice_center", "Exp_Promote", 0, 0, (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
      return paramView;
    }
    catch (IllegalArgumentException paramTroopFeedItem)
    {
      label286:
      label300:
      break label286;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopAioADManager", 2, "IllegalArgumentException");
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ADViewProvider
 * JD-Core Version:    0.7.0.1
 */
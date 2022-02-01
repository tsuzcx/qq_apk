package com.tencent.mobileqq.onlinestatus.view;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class StatusCardViewHolder
{
  private HashMap<Long, BaseStatusCardView> a = new HashMap(4);
  
  public BaseStatusCardView a(long paramLong)
  {
    QLog.d("StatusCardViewHolder", 1, new Object[] { "getStatusCardViewCache: id= ", Long.valueOf(paramLong) });
    paramLong = StatusCardViewBuilder.a(paramLong);
    return (BaseStatusCardView)this.a.get(Long.valueOf(paramLong));
  }
  
  public BaseStatusCardView a(View paramView, BaseActivity paramBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback, long paramLong)
  {
    QLog.d("StatusCardViewHolder", 1, new Object[] { "getStatusCardView: id= ", Long.valueOf(paramLong) });
    paramLong = StatusCardViewBuilder.a(paramLong);
    BaseStatusCardView localBaseStatusCardView2 = (BaseStatusCardView)this.a.get(Long.valueOf(paramLong));
    BaseStatusCardView localBaseStatusCardView1 = localBaseStatusCardView2;
    if (localBaseStatusCardView2 == null) {
      localBaseStatusCardView1 = StatusCardViewBuilder.a(paramBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback, paramLong);
    }
    if (localBaseStatusCardView1 != null)
    {
      localBaseStatusCardView1.a(OnlineStatusUtil.a(paramView));
      this.a.put(Long.valueOf(paramLong), localBaseStatusCardView1);
    }
    return localBaseStatusCardView1;
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.a.values().iterator();
      while (localIterator.hasNext()) {
        ((BaseStatusCardView)localIterator.next()).m();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("StatusCardViewHolder", 1, "dismissRecursive: failed. ", localException);
    }
  }
  
  public boolean a(long paramLong, int paramInt, Intent paramIntent)
  {
    QLog.d("StatusCardViewHolder", 1, new Object[] { "onActivityResult: requestCode= ", Long.valueOf(paramLong), " responseCode=", Integer.valueOf(paramInt) });
    BaseStatusCardView localBaseStatusCardView = (BaseStatusCardView)this.a.get(Long.valueOf(paramLong));
    if (localBaseStatusCardView != null)
    {
      localBaseStatusCardView.a((int)paramLong, paramInt, paramIntent);
      return true;
    }
    return false;
  }
  
  public boolean a(View paramView, BaseActivity paramBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback, long paramLong)
  {
    QLog.d("StatusCardViewHolder", 1, new Object[] { "showStatusCardView: id= ", Long.valueOf(paramLong) });
    paramLong = StatusCardViewBuilder.a(paramLong);
    BaseStatusCardView localBaseStatusCardView2 = (BaseStatusCardView)this.a.get(Long.valueOf(paramLong));
    BaseStatusCardView localBaseStatusCardView1 = localBaseStatusCardView2;
    if (localBaseStatusCardView2 == null) {
      localBaseStatusCardView1 = StatusCardViewBuilder.a(paramBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback, paramLong);
    }
    if (localBaseStatusCardView1 != null)
    {
      localBaseStatusCardView1.a(OnlineStatusUtil.a(paramView));
      localBaseStatusCardView1.aA_();
      this.a.put(Long.valueOf(paramLong), localBaseStatusCardView1);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.StatusCardViewHolder
 * JD-Core Version:    0.7.0.1
 */
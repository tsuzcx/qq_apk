package com.tencent.mobileqq.onlinestatus.view;

import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
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
  
  public BaseStatusCardView a(View paramView, QBaseActivity paramQBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback, long paramLong)
  {
    QLog.d("StatusCardViewHolder", 1, new Object[] { "getStatusCardView: id= ", Long.valueOf(paramLong) });
    paramLong = StatusCardViewBuilder.a(paramLong);
    BaseStatusCardView localBaseStatusCardView2 = (BaseStatusCardView)this.a.get(Long.valueOf(paramLong));
    BaseStatusCardView localBaseStatusCardView1 = localBaseStatusCardView2;
    if (localBaseStatusCardView2 == null) {
      localBaseStatusCardView1 = StatusCardViewBuilder.a(paramQBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback, paramLong);
    }
    if (localBaseStatusCardView1 != null)
    {
      localBaseStatusCardView1.a(a(paramView));
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
        ((BaseStatusCardView)localIterator.next()).k();
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
  
  public boolean a(View paramView, QBaseActivity paramQBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback, long paramLong)
  {
    QLog.d("StatusCardViewHolder", 1, new Object[] { "showStatusCardView: id= ", Long.valueOf(paramLong) });
    paramLong = StatusCardViewBuilder.a(paramLong);
    BaseStatusCardView localBaseStatusCardView2 = (BaseStatusCardView)this.a.get(Long.valueOf(paramLong));
    BaseStatusCardView localBaseStatusCardView1 = localBaseStatusCardView2;
    if (localBaseStatusCardView2 == null) {
      localBaseStatusCardView1 = StatusCardViewBuilder.a(paramQBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback, paramLong);
    }
    if (localBaseStatusCardView1 != null)
    {
      localBaseStatusCardView1.a(a(paramView));
      localBaseStatusCardView1.aL_();
      this.a.put(Long.valueOf(paramLong), localBaseStatusCardView1);
      return true;
    }
    return false;
  }
  
  float[] a(View paramView)
  {
    float[] arrayOfFloat = new float[2];
    if (paramView == null)
    {
      arrayOfFloat[0] = 0.5F;
      arrayOfFloat[1] = 0.5F;
      return arrayOfFloat;
    }
    int i = paramView.getResources().getDisplayMetrics().widthPixels;
    int j = paramView.getResources().getDisplayMetrics().heightPixels;
    int k = paramView.getWidth();
    int m = paramView.getHeight();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    arrayOfFloat[0] = ((k / 2.0F + arrayOfInt[0]) / i);
    arrayOfFloat[1] = ((m / 2.0F + arrayOfInt[1]) / j);
    return arrayOfFloat;
  }
  
  public void b()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.StatusCardViewHolder
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ecshop.keep;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil;
import com.tencent.mobileqq.ecshop.redpoint.RedPointInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

class CustomTabView$4
  implements Runnable
{
  public void run()
  {
    QQShopRedPointUtil.b(this.a.mTabId);
    Object localObject = this.a.mRedUrl;
    this.b.setVisibility(0);
    this.b.setTag(Integer.valueOf(this.a.mTashId));
    if (StringUtil.isEmpty((String)localObject))
    {
      this.b.setImageResource(2130844618);
      this.b.getLayoutParams().width = DisplayUtil.a(CustomTabView.a(this.this$0), 9.0F);
      this.b.getLayoutParams().height = DisplayUtil.a(CustomTabView.a(this.this$0), 9.0F);
      ((RelativeLayout.LayoutParams)this.b.getLayoutParams()).leftMargin = (-DisplayUtil.a(CustomTabView.a(this.this$0), 8.0F));
      return;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if (this.a.mRedType == 1)
      {
        this.this$0.a(this.c);
        this.b.getLayoutParams().width = DisplayUtil.a(CustomTabView.a(this.this$0), 63.0F);
        this.b.getLayoutParams().height = DisplayUtil.a(CustomTabView.a(this.this$0), 18.0F);
        ((RelativeLayout.LayoutParams)this.b.getLayoutParams()).topMargin = (-DisplayUtil.a(CustomTabView.a(this.this$0), 3.0F));
        ((RelativeLayout.LayoutParams)this.b.getLayoutParams()).leftMargin = (-DisplayUtil.a(CustomTabView.a(this.this$0), 10.0F));
        localURLDrawableOptions.mRequestWidth = DisplayUtil.a(CustomTabView.a(this.this$0), 63.0F);
        localURLDrawableOptions.mRequestHeight = DisplayUtil.a(CustomTabView.a(this.this$0), 20.0F);
      }
      else
      {
        this.b.getLayoutParams().width = DisplayUtil.a(CustomTabView.a(this.this$0), 9.0F);
        this.b.getLayoutParams().height = DisplayUtil.a(CustomTabView.a(this.this$0), 9.0F);
        ((RelativeLayout.LayoutParams)this.b.getLayoutParams()).leftMargin = (-DisplayUtil.a(CustomTabView.a(this.this$0), 8.0F));
        localURLDrawableOptions.mRequestWidth = DisplayUtil.a(CustomTabView.a(this.this$0), 9.0F);
        localURLDrawableOptions.mRequestHeight = DisplayUtil.a(CustomTabView.a(this.this$0), 9.0F);
      }
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      if (localObject != null)
      {
        this.b.setImageDrawable((Drawable)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("EcshopCustomTabView", 1, QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.keep.CustomTabView.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.widget;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ProfileURLDrawableDownListener
  implements URLDrawableDownListener
{
  final WeakReference<View> a;
  final String b;
  final String c;
  
  public ProfileURLDrawableDownListener(View paramView, String paramString1, String paramString2)
  {
    this.a = new WeakReference(paramView);
    this.c = paramString1;
    this.b = paramString2;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramView = (View)this.a.get();
    if (paramView != null)
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append(this.b);
      paramURLDrawable.append(this.c);
      QLog.e("Q.profilecard.FrdProfileCard", 1, paramURLDrawable.toString());
      paramView.setVisibility(8);
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = (View)this.a.get();
    if (paramView != null) {
      paramView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileURLDrawableDownListener
 * JD-Core Version:    0.7.0.1
 */
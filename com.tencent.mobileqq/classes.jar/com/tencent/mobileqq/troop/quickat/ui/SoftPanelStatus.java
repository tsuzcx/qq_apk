package com.tencent.mobileqq.troop.quickat.ui;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;

public class SoftPanelStatus
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public static int a = 0;
  public static boolean b = false;
  private int c = 1;
  private Activity d;
  private SoftPanelStatus.AtPanelStatusListener e;
  private int f = 0;
  private int g = 0;
  private View h;
  
  public SoftPanelStatus(Activity paramActivity)
  {
    this.d = paramActivity;
  }
  
  public static void a(Activity paramActivity)
  {
    a = b(paramActivity.getWindow().getDecorView());
    b = c(paramActivity);
  }
  
  public static int b(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    int i = paramActivity.getHeight();
    if (b(paramActivity) > i * 3 / 4) {
      return 2;
    }
    return 1;
  }
  
  public static int b(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  public static boolean c(Activity paramActivity)
  {
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("onGlobalLayout, top=");
      paramActivity.append(localRect.top);
      paramActivity.append(" bottom=");
      paramActivity.append(localRect.bottom);
      QLog.d("AtPanelStatus", 2, paramActivity.toString());
    }
    return localRect.top == 0;
  }
  
  @RequiresApi(api=16)
  public void a()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.d.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
    } else {
      this.d.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    this.c = 1;
    this.e = null;
    this.f = 0;
  }
  
  public void a(View paramView)
  {
    this.h = paramView;
  }
  
  public void a(SoftPanelStatus.AtPanelStatusListener paramAtPanelStatusListener)
  {
    if (paramAtPanelStatusListener != null) {
      this.d.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
    this.c = 1;
    this.e = paramAtPanelStatusListener;
    this.f = 0;
  }
  
  public void onGlobalLayout()
  {
    Object localObject = this.d.getWindow().getDecorView();
    if (localObject == null) {
      return;
    }
    int i = ((View)localObject).getHeight();
    int j = b((View)localObject);
    int k = i - j;
    localObject = this.h;
    if (localObject != null)
    {
      int m = ((View)localObject).getHeight();
      int n = this.f;
      if (m != n)
      {
        localObject = this.e;
        if (localObject != null) {
          ((SoftPanelStatus.AtPanelStatusListener)localObject).b(this.c, j, n);
        }
      }
      this.f = m;
    }
    if (j == this.f) {
      return;
    }
    if (k > i / 4)
    {
      this.c = 1;
      localObject = this.e;
      if (localObject != null) {
        ((SoftPanelStatus.AtPanelStatusListener)localObject).a(this.c, j, k);
      }
    }
    else if (k < i * 3 / 4)
    {
      this.c = 2;
      localObject = this.e;
      if (localObject != null) {
        ((SoftPanelStatus.AtPanelStatusListener)localObject).a(this.c, j, k);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGlobalLayout, screenHeight=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" visibleHeight=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" differHeight=");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(" mode=");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("AtPanelStatus", 2, ((StringBuilder)localObject).toString());
    }
    this.f = j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.SoftPanelStatus
 * JD-Core Version:    0.7.0.1
 */
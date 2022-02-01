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
  public static boolean a = false;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private SoftPanelStatus.AtPanelStatusListener jdField_a_of_type_ComTencentMobileqqTroopQuickatUiSoftPanelStatus$AtPanelStatusListener;
  private int b = 1;
  private int c = 0;
  private int d = 0;
  
  public SoftPanelStatus(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public static int a(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    int i = paramActivity.getHeight();
    if (a(paramActivity) > i * 3 / 4) {
      return 2;
    }
    return 1;
  }
  
  public static int a(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
  
  public static void a(Activity paramActivity)
  {
    jdField_a_of_type_Int = a(paramActivity.getWindow().getDecorView());
    jdField_a_of_type_Boolean = a(paramActivity);
  }
  
  public static boolean a(Activity paramActivity)
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
      this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
    } else {
      this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    this.b = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiSoftPanelStatus$AtPanelStatusListener = null;
    this.c = 0;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(SoftPanelStatus.AtPanelStatusListener paramAtPanelStatusListener)
  {
    if (paramAtPanelStatusListener != null) {
      this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
    this.b = 1;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiSoftPanelStatus$AtPanelStatusListener = paramAtPanelStatusListener;
    this.c = 0;
  }
  
  public void onGlobalLayout()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
    if (localObject == null) {
      return;
    }
    int i = ((View)localObject).getHeight();
    int j = a((View)localObject);
    int k = i - j;
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      int m = ((View)localObject).getHeight();
      int n = this.c;
      if (m != n)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiSoftPanelStatus$AtPanelStatusListener;
        if (localObject != null) {
          ((SoftPanelStatus.AtPanelStatusListener)localObject).b(this.b, j, n);
        }
      }
      this.c = m;
    }
    if (j == this.c) {
      return;
    }
    if (k > i / 4)
    {
      this.b = 1;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiSoftPanelStatus$AtPanelStatusListener;
      if (localObject != null) {
        ((SoftPanelStatus.AtPanelStatusListener)localObject).a(this.b, j, k);
      }
    }
    else if (k < i * 3 / 4)
    {
      this.b = 2;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiSoftPanelStatus$AtPanelStatusListener;
      if (localObject != null) {
        ((SoftPanelStatus.AtPanelStatusListener)localObject).a(this.b, j, k);
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
      ((StringBuilder)localObject).append(this.b);
      QLog.d("AtPanelStatus", 2, ((StringBuilder)localObject).toString());
    }
    this.c = j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.SoftPanelStatus
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Arrays;

class XPanelContainer$5
  implements Runnable
{
  XPanelContainer$5(XPanelContainer paramXPanelContainer) {}
  
  public void run()
  {
    try
    {
      View localView = ((Activity)this.this$0.getContext()).findViewById(2131444897);
      Object localObject = new int[2];
      localView.getLocationInWindow((int[])localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLocationInWindow:");
      localStringBuilder.append(Arrays.toString((int[])localObject));
      QLog.d("XPanelContainer", 1, localStringBuilder.toString());
      localView.getLocationOnScreen((int[])localObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLocationOnScreen:");
      localStringBuilder.append(Arrays.toString((int[])localObject));
      QLog.d("XPanelContainer", 1, localStringBuilder.toString());
      localObject = new Rect();
      localView.getLocalVisibleRect((Rect)localObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLocalVisibleRect: ");
      localStringBuilder.append(((Rect)localObject).toString());
      QLog.d("XPanelContainer", 1, localStringBuilder.toString());
      int i = ImmersiveUtils.getStatusBarHeight(this.this$0.getContext());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("status bar height:");
      ((StringBuilder)localObject).append(i);
      QLog.d("XPanelContainer", 1, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("title bar height:");
      ((StringBuilder)localObject).append(localView.getHeight());
      QLog.d("XPanelContainer", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("XPanelContainer", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.XPanelContainer.5
 * JD-Core Version:    0.7.0.1
 */
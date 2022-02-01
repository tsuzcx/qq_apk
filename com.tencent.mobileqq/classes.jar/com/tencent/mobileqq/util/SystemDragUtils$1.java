package com.tencent.mobileqq.util;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.UiThreadUtil;

final class SystemDragUtils$1
  implements View.OnDragListener
{
  SystemDragUtils$1(ImageView paramImageView, ColorDrawable paramColorDrawable1, ViewGroup paramViewGroup, ColorDrawable paramColorDrawable2, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    paramView = Looper.getMainLooper();
    if (Thread.currentThread() != paramView.getThread())
    {
      UiThreadUtil.a(new SystemDragUtils.1.1(this, paramDragEvent));
      return true;
    }
    return SystemDragUtils.a(paramDragEvent, this.a, this.b, this.c, this.d, this.e, this.f, this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.gamecenter.fragment;

import android.annotation.SuppressLint;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.qphone.base.util.QLog;

@SuppressLint({"NewApi"})
public class CustomOutlineProvider
  extends ViewOutlineProvider
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOutlineProvider", 1, "----->getOutline");
    }
    paramView.getGlobalVisibleRect(new Rect());
    paramOutline.setRoundRect(new Rect(this.c, this.a, this.d, this.b), 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.CustomOutlineProvider
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vas.qvip.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ark.open.ArkView;

public class QvipArkView
  extends ArkView
{
  private QQVipArkHeaderView a;
  
  public QvipArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.onTouchEvent(paramMotionEvent);
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setmQqVipArkHeaderView(QQVipArkHeaderView paramQQVipArkHeaderView)
  {
    this.a = paramQQVipArkHeaderView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.QvipArkView
 * JD-Core Version:    0.7.0.1
 */
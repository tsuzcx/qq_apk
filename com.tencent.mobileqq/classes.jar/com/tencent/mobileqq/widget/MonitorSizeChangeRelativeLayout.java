package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class MonitorSizeChangeRelativeLayout
  extends RelativeLayout
{
  private MonitorSizeChangeRelativeLayout.ICallback a;
  
  public MonitorSizeChangeRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MonitorSizeChangeRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setCallBack(MonitorSizeChangeRelativeLayout.ICallback paramICallback)
  {
    this.a = paramICallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MonitorSizeChangeRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
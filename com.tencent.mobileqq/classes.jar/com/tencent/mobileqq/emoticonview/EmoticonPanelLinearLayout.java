package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class EmoticonPanelLinearLayout
  extends LinearLayout
{
  private IEmoticonPanelLinearLayoutHelper mHelper;
  
  public EmoticonPanelLinearLayout(Context paramContext, IEmoticonPanelLinearLayoutHelper paramIEmoticonPanelLinearLayoutHelper)
  {
    super(paramContext);
    this.mHelper = paramIEmoticonPanelLinearLayoutHelper;
    this.mHelper.attachCurrentView(this);
    this.mHelper.initHelper(paramContext);
  }
  
  public EmoticonPanelLinearLayout(Context paramContext, IEmoticonPanelLinearLayoutHelper paramIEmoticonPanelLinearLayoutHelper, int paramInt)
  {
    super(paramContext);
    this.mHelper = paramIEmoticonPanelLinearLayoutHelper;
    this.mHelper.attachCurrentView(this);
    this.mHelper.setBusinessType(paramInt);
    this.mHelper.initHelper(paramContext);
  }
  
  public int getWindowAttachCount()
  {
    return super.getWindowAttachCount();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mHelper.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mHelper.onTouchEvent(paramMotionEvent);
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.mHelper.setCallBack(paramEmoticonCallback);
  }
  
  public void setInterceptListener(IEmoticonPanelLinearLayoutHelper.OnClickListener paramOnClickListener)
  {
    this.mHelper.setInterceptListener(paramOnClickListener);
  }
  
  public void setPanelType(int paramInt)
  {
    this.mHelper.setPanelType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout
 * JD-Core Version:    0.7.0.1
 */
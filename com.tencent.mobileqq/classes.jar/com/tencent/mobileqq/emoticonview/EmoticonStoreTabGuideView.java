package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.widget.PopupWindow;

public class EmoticonStoreTabGuideView
  extends PopupWindow
{
  protected Context mContext;
  
  public EmoticonStoreTabGuideView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public void initUI()
  {
    setContentView(LayoutInflater.from(this.mContext).inflate(2131561609, null));
    setWidth(-2);
    setHeight(-2);
    setBackgroundDrawable(new ColorDrawable(0));
    setOutsideTouchable(true);
    setTouchable(true);
    setFocusable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonStoreTabGuideView
 * JD-Core Version:    0.7.0.1
 */
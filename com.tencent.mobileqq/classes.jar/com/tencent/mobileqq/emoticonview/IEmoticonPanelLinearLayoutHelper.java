package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.MotionEvent;

public abstract interface IEmoticonPanelLinearLayoutHelper
{
  public static final int PANEL_TYPE_BIG_EMOTION = 1;
  public static final int PANEL_TYPE_CAMERA_EMOTION = 5;
  public static final int PANEL_TYPE_FAV_EMOTION = 3;
  public static final int PANEL_TYPE_HOTPIC_EMOTION = 6;
  public static final int PANEL_TYPE_ROAM = 4;
  public static final int PANEL_TYPE_SMALL_EMOTION = 2;
  public static final int PANEL_TYPE_SYSTEM_AND_EMOJI = 0;
  public static final String TAG = "EmotionPanelLinearLayout";
  
  public abstract void attachCurrentView(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout);
  
  public abstract Context getContext();
  
  public abstract void initHelper(Context paramContext);
  
  public abstract boolean onInterceptTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setBusinessType(int paramInt);
  
  public abstract void setCallBack(EmoticonCallback paramEmoticonCallback);
  
  public abstract void setInterceptListener(IEmoticonPanelLinearLayoutHelper.OnClickListener paramOnClickListener);
  
  public abstract void setPanelType(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
 * JD-Core Version:    0.7.0.1
 */
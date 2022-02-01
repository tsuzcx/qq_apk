package com.tencent.mobileqq.emoticonview.view;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelParams;

public abstract interface IBasePanelView
{
  public abstract Context getContext();
  
  public abstract EmoticonPanelController getController();
  
  public abstract EmoticonMainPanel getMainPanel();
  
  public abstract void onAttachedToWindow();
  
  public abstract void onDestory();
  
  public abstract void onDetachedFromWindow();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void setViewData(EmoticonPanelParams paramEmoticonPanelParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.view.IBasePanelView
 * JD-Core Version:    0.7.0.1
 */
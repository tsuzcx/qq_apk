package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageButton;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import java.util.List;

public abstract interface IPanelDependListener
{
  public abstract ImageButton getDeleteButtonFromCache(int paramInt);
  
  public abstract int getLastSelectedSecondTabIndex();
  
  public abstract List<EmotionPanelInfo> getPanelDataList();
  
  public abstract int getmAddedHeight();
  
  public abstract void hidePopupWindow(Context paramContext, EmoticonCallback paramEmoticonCallback);
  
  public abstract boolean isSmallEmotionDownloadedAdapter(Adapter paramAdapter);
  
  public abstract void removePopupGuide();
  
  public abstract void showPopupEmo(View paramView, EmoticonInfo paramEmoticonInfo, Rect paramRect, Context paramContext, EmoticonCallback paramEmoticonCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IPanelDependListener
 * JD-Core Version:    0.7.0.1
 */
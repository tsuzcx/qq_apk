package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;

public abstract interface IPanelDependListener
{
  public abstract void hidePopupWindow(Context paramContext, EmoticonCallback paramEmoticonCallback);
  
  public abstract void showPopupEmo(View paramView, EmoticonInfo paramEmoticonInfo, Rect paramRect, Context paramContext, EmoticonCallback paramEmoticonCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IPanelDependListener
 * JD-Core Version:    0.7.0.1
 */
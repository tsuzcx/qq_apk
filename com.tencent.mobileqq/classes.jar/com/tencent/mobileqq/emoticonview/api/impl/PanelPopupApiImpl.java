package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.emoticonview.api.IPanelDependListener;
import com.tencent.mobileqq.emoticonview.api.IPanelPopupApi;

public class PanelPopupApiImpl
  implements IPanelPopupApi
{
  public IPanelDependListener createPanelDependListener()
  {
    return new EmotionPanelDependListener();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.PanelPopupApiImpl
 * JD-Core Version:    0.7.0.1
 */
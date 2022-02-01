package com.tencent.mobileqq.emosm;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;

public abstract interface IEmotionSearchPanel
{
  public abstract void init(BaseQQAppInterface paramBaseQQAppInterface, IPanelInteractionListener paramIPanelInteractionListener, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3, IEmoticonPanelHotPicSearchHelper paramIEmoticonPanelHotPicSearchHelper);
  
  public abstract void onDestory();
  
  public abstract void showEmotionSearchWindow();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.IEmotionSearchPanel
 * JD-Core Version:    0.7.0.1
 */
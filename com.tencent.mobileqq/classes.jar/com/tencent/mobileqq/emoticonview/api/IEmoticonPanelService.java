package com.tencent.mobileqq.emoticonview.api;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IEmoticonPanelService
  extends QRouteApi
{
  public abstract <T> URLDrawable getPicEmoticonAioPreviewDrawable(T paramT);
  
  public abstract <T, K> URLDrawable getPicEmoticonLoadingDrawable(K paramK, String paramString, boolean paramBoolean1, boolean paramBoolean2, T paramT);
  
  public abstract <T, K> URLDrawable getPicEmoticonLoadingDrawable(K paramK, String paramString, boolean paramBoolean1, boolean paramBoolean2, T paramT, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IEmoticonPanelService
 * JD-Core Version:    0.7.0.1
 */
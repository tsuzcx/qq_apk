package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IRecommendEmotionService<T>
  extends QRouteApi
{
  public abstract void clearSpecWordType(BaseAIOContext paramBaseAIOContext);
  
  public abstract String getSpecKeyWord(BaseAIOContext paramBaseAIOContext);
  
  public abstract void onEmotionKeywordDimiss(BaseAIOContext paramBaseAIOContext);
  
  public abstract void openEmoticonDetailPage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, T paramT, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService
 * JD-Core Version:    0.7.0.1
 */
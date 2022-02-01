package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticon.IFindEmotionPackageListener;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import java.util.List;

@QAPI(process={""})
public abstract interface IRecommendEmotionService<T>
  extends QRouteApi
{
  public abstract void asyncFindEmoticonPackage(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, int paramInt2, String paramString, int paramInt3, IFindEmotionPackageListener paramIFindEmotionPackageListener);
  
  public abstract URLDrawable getApngDrawable(Drawable paramDrawable, String paramString, int paramInt);
  
  public abstract String getEmotionScid();
  
  public abstract long getPicBid();
  
  public abstract List<T> getProEmoticonPkgs(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, boolean paramBoolean1, int paramInt, boolean paramBoolean2);
  
  public abstract boolean isAIOBusiness(int paramInt);
  
  public abstract boolean isColorNick(int paramInt);
  
  public abstract boolean isKanDianBusiness(int paramInt);
  
  public abstract void openEmoticonDetailPage(Context paramContext, IEmoticonMainPanelApp paramIEmoticonMainPanelApp, T paramT, int paramInt);
  
  public abstract void recordRecommendEpExpose(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, T paramT);
  
  public abstract void removeCallBacker(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, CallBacker paramCallBacker);
  
  public abstract void sendRecommendSSORequest(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt);
  
  public abstract void setRecommendEpRedFlag(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.feeds.api;

import com.tencent.mobileqq.kandian.biz.video.api.OnUIChangeListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/IVideoUIManager;", "", "addOnUIChangeListener", "", "onUIChangeListener", "Lcom/tencent/mobileqq/kandian/biz/video/api/OnUIChangeListener;", "getAdBeforeEndGuide", "Ljava/lang/Object;", "getAdHighLightBar", "getPatchView", "getPlayingParam", "Lcom/tencent/mobileqq/kandian/biz/video/feeds/entity/VideoPlayParam;", "getReadInJoyAdBubbleNativeView", "isFullSreen", "", "removeOnUIChangeListener", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoUIManager
{
  @Nullable
  public abstract VideoPlayParam a();
  
  @Nullable
  public abstract Object a();
  
  public abstract void a(@Nullable OnUIChangeListener paramOnUIChangeListener);
  
  public abstract boolean a();
  
  @Nullable
  public abstract Object b();
  
  public abstract void b(@Nullable OnUIChangeListener paramOnUIChangeListener);
  
  @Nullable
  public abstract Object c();
  
  @Nullable
  public abstract Object d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager
 * JD-Core Version:    0.7.0.1
 */
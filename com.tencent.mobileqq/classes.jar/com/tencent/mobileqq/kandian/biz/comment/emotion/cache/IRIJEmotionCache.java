package com.tencent.mobileqq.kandian.biz.comment.emotion.cache;

import android.content.Context;
import android.graphics.Point;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJBaseEmotionInfo;
import java.util.List;

public abstract interface IRIJEmotionCache
{
  @NonNull
  public abstract EmotionInjectionInfo a(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, EmoticonCallback paramEmoticonCallback);
  
  @NonNull
  public abstract EmotionPanelInfo a();
  
  public abstract RIJBaseEmotionInfo a(String paramString);
  
  public abstract Point b(String paramString);
  
  @NonNull
  public abstract String b();
  
  public abstract List<? extends RIJBaseEmotionInfo> c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.cache.IRIJEmotionCache
 * JD-Core Version:    0.7.0.1
 */
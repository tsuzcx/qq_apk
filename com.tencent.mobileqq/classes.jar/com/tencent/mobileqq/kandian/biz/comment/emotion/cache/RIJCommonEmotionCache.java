package com.tencent.mobileqq.kandian.biz.comment.emotion.cache;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.kandian.biz.comment.emotion.RIJEmotionPanelBuilder;
import com.tencent.mobileqq.kandian.biz.comment.emotion.adapter.RIJCommonEmotionAdapterParams;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJCommonEmotionInfo;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.emotionsize.IRIJEmotionSize;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RIJCommonEmotionCache
  implements IRIJEmotionCache
{
  private EmotionPanelInfo a;
  private List<RIJCommonEmotionInfo> b = Collections.emptyList();
  private final Map<String, RIJCommonEmotionInfo> c = new ArrayMap();
  private final String d;
  private final String e;
  private final int f;
  private final IRIJEmotionSize g;
  
  public RIJCommonEmotionCache(String paramString1, String paramString2, int paramInt, IRIJEmotionSize paramIRIJEmotionSize)
  {
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramInt;
    this.g = paramIRIJEmotionSize;
  }
  
  @NonNull
  public EmotionInjectionInfo a(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    paramIEmoticonMainPanelApp = new RIJCommonEmotionAdapterParams(paramIEmoticonMainPanelApp, paramContext, paramEmoticonCallback);
    int i = this.f;
    paramIEmoticonMainPanelApp.e = i;
    paramIEmoticonMainPanelApp.d = i;
    paramIEmoticonMainPanelApp.a(this.g);
    paramIEmoticonMainPanelApp = new RIJEmotionPanelBuilder(paramIEmoticonMainPanelApp, this.e);
    paramIEmoticonMainPanelApp.a(this.b);
    paramContext = new EmotionInjectionInfo(this.f, this.g.a(), 0, paramIEmoticonMainPanelApp);
    paramContext.setEmotionTabCreateListener(paramIEmoticonMainPanelApp);
    return paramContext;
  }
  
  @NonNull
  public EmotionPanelInfo a()
  {
    return this.a;
  }
  
  public void a(@NonNull List<RIJCommonEmotionInfo> paramList)
  {
    this.b = paramList;
    this.c.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RIJCommonEmotionInfo localRIJCommonEmotionInfo = (RIJCommonEmotionInfo)paramList.next();
      this.c.put(localRIJCommonEmotionInfo.c, localRIJCommonEmotionInfo);
    }
  }
  
  public Point b(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(paramString, ((RIJCommonEmotionInfo)localIterator.next()).c)) {
        return new Point(this.g.i(), this.g.j());
      }
    }
    return null;
  }
  
  @NonNull
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tkd_comment_emotion_");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
  
  public RIJCommonEmotionInfo c(String paramString)
  {
    return (RIJCommonEmotionInfo)this.c.get(paramString);
  }
  
  public List<RIJCommonEmotionInfo> c()
  {
    return this.b;
  }
  
  public void d()
  {
    this.a = new EmotionPanelInfo(this.f, this.g.a(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJCommonEmotionCache
 * JD-Core Version:    0.7.0.1
 */
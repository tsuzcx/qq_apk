package com.tencent.mobileqq.kandian.biz.comment.emotion.adapter;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.emotionsize.IRIJEmotionSize;

public class RIJCommonEmotionAdapterParams
{
  public final IEmoticonMainPanelApp a;
  public final Context b;
  public final EmoticonCallback c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  
  public RIJCommonEmotionAdapterParams(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this.a = paramIEmoticonMainPanelApp;
    this.b = paramContext;
    this.c = paramEmoticonCallback;
  }
  
  public void a(IRIJEmotionSize paramIRIJEmotionSize)
  {
    if (paramIRIJEmotionSize == null) {
      return;
    }
    this.f = paramIRIJEmotionSize.a();
    this.h = paramIRIJEmotionSize.b();
    this.g = paramIRIJEmotionSize.c();
    this.i = paramIRIJEmotionSize.d();
    this.j = paramIRIJEmotionSize.e();
    this.k = paramIRIJEmotionSize.f();
    this.l = paramIRIJEmotionSize.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.adapter.RIJCommonEmotionAdapterParams
 * JD-Core Version:    0.7.0.1
 */
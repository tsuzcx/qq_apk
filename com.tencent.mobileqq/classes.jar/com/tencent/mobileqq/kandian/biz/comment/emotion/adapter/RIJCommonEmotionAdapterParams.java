package com.tencent.mobileqq.kandian.biz.comment.emotion.adapter;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.emotionsize.IRIJEmotionSize;

public class RIJCommonEmotionAdapterParams
{
  public int a;
  public final Context a;
  public final EmoticonCallback a;
  public final IEmoticonMainPanelApp a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public RIJCommonEmotionAdapterParams(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanelApp = paramIEmoticonMainPanelApp;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  public void a(IRIJEmotionSize paramIRIJEmotionSize)
  {
    if (paramIRIJEmotionSize == null) {
      return;
    }
    this.c = paramIRIJEmotionSize.a();
    this.e = paramIRIJEmotionSize.b();
    this.d = paramIRIJEmotionSize.c();
    this.f = paramIRIJEmotionSize.d();
    this.g = paramIRIJEmotionSize.e();
    this.h = paramIRIJEmotionSize.f();
    this.i = paramIRIJEmotionSize.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.adapter.RIJCommonEmotionAdapterParams
 * JD-Core Version:    0.7.0.1
 */
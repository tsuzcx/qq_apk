package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import android.view.View.OnClickListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IMsgLayoutHelper;", "", "hideMsgLayout", "", "hideMsgLayoutWithAnim", "isErrorLayoutShowing", "", "setBtnClickListener", "listener", "Landroid/view/View$OnClickListener;", "tag", "showMsgLayout", "msgType", "", "msg", "", "btnText", "btnIcon", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IMsgLayoutHelper
{
  public abstract void a();
  
  public abstract void a(int paramInt, @Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void a(int paramInt1, @Nullable String paramString1, @Nullable String paramString2, int paramInt2);
  
  public abstract void a(@Nullable View.OnClickListener paramOnClickListener, @Nullable Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IMsgLayoutHelper
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.comment.emotion.span;

import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.IViewProxy;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJBaseEmotionInfo;
import com.tencent.mobileqq.kandian.biz.comment.util.RIJEnhancedImageSpan;
import com.tencent.qphone.base.util.BaseApplication;

public class RIJEmotionImageSpan
  extends RIJEnhancedImageSpan
{
  IViewProxy a;
  private final RIJBaseEmotionInfo b;
  
  public RIJEmotionImageSpan(RIJBaseEmotionInfo paramRIJBaseEmotionInfo)
  {
    super(0);
    this.b = paramRIJBaseEmotionInfo;
    a();
  }
  
  private void a()
  {
    Object localObject1 = BaseApplication.getContext().getResources().getDrawable(2097479684);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
    localObject1 = URLDrawable.getDrawable(this.b.b, (URLDrawable.URLDrawableOptions)localObject2);
    localObject2 = RIJEmotionCacheManager.a(this.b.c);
    if (localObject2 != null)
    {
      a(((Point)localObject2).x, ((Point)localObject2).y);
      ((URLDrawable)localObject1).setBounds(0, 0, ((Point)localObject2).x, ((Point)localObject2).y);
    }
    ((URLDrawable)localObject1).setURLDrawableListener(new RIJEmotionImageSpan.MyDownloadListener(this));
    ((URLDrawable)localObject1).startDownload();
    a((Drawable)localObject1);
  }
  
  public void a(IViewProxy paramIViewProxy)
  {
    this.a = paramIViewProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.span.RIJEmotionImageSpan
 * JD-Core Version:    0.7.0.1
 */
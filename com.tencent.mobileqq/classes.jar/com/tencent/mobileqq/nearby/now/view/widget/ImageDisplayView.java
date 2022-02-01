package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.nearby.now.model.ImageData;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.StoryViewRelayoutListener;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import java.util.ArrayList;

public class ImageDisplayView
  extends FrameLayout
  implements URLDrawable.URLDrawableListener
{
  public FitXImageView a;
  private View b;
  private StoryViewRelayoutListener c;
  private URLDrawable d;
  
  public ImageDisplayView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ImageDisplayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ImageDisplayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.b = LayoutInflater.from(getContext()).inflate(((IResourceUtil)QRoute.api(IResourceUtil.class)).getQQNearbyImageDisplayView(), this, true);
    this.a = ((FitXImageView)this.b.findViewById(((IResourceUtil)QRoute.api(IResourceUtil.class)).getDisplayImageView()));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.post(new ImageDisplayView.1(this, paramString, paramInt1, paramInt2), 8, null, true);
  }
  
  public void a(VideoData paramVideoData)
  {
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).setFeedId(paramVideoData.c);
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).setAnchorUin(String.valueOf(paramVideoData.i));
    if (paramVideoData.b == 4)
    {
      a(((ImageData)paramVideoData.M.get(0)).a, ((ImageData)paramVideoData.M.get(0)).b, ((ImageData)paramVideoData.M.get(0)).c);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseAutoScaleParams = true;
    this.d = URLDrawable.getDrawable(((ImageData)paramVideoData.M.get(0)).a, localURLDrawableOptions);
    if (this.d.getStatus() == 1)
    {
      this.a.setImageDrawable(this.d);
      this.c.a(this.d.getIntrinsicWidth(), this.d.getIntrinsicHeight());
      return;
    }
    this.d.setURLDrawableListener(this);
    this.d.startDownload();
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    StoryViewRelayoutListener localStoryViewRelayoutListener = this.c;
    if (localStoryViewRelayoutListener != null) {
      localStoryViewRelayoutListener.a(paramURLDrawable.getURL().toString(), this.a, 1);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramThrowable = this.c;
    if (paramThrowable != null) {
      paramThrowable.a(paramURLDrawable.getURL().toString(), this.a, 0);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.setImageDrawable(paramURLDrawable);
    this.c.a(paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
  }
  
  public void setRelayoutListener(StoryViewRelayoutListener paramStoryViewRelayoutListener)
  {
    this.c = paramStoryViewRelayoutListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView
 * JD-Core Version:    0.7.0.1
 */
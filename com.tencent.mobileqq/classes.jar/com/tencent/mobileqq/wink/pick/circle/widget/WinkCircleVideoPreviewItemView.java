package com.tencent.mobileqq.wink.pick.circle.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.SimpleDateFormat;

public class WinkCircleVideoPreviewItemView
  extends RelativeLayout
{
  private LocalMediaInfo a;
  private FrameLayout b;
  private ImageView c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private SeekBar g;
  private BaseVideoView h;
  private SimpleDateFormat i = null;
  private Context j;
  private View.OnClickListener k;
  private SeekBar.OnSeekBarChangeListener l;
  private View.OnTouchListener m;
  private ColorDrawable n = new ColorDrawable(570425344);
  private LinearLayout o;
  private int p = -1;
  
  public WinkCircleVideoPreviewItemView(Context paramContext)
  {
    super(paramContext);
    this.j = paramContext;
    View.inflate(paramContext, 2131629689, this);
    this.b = ((FrameLayout)findViewById(2131449683));
    this.c = ((ImageView)findViewById(2131449684));
    this.f = ((TextView)findViewById(2131449685));
    this.d = ((ImageView)findViewById(2131449687));
    this.e = ((TextView)findViewById(2131449690));
    this.g = ((SeekBar)findViewById(2131449689));
    this.g.setOnSeekBarChangeListener(getOnSeekBarChangeListener());
    this.g.setOnTouchListener(getSeekBarTouchListener());
    this.o = ((LinearLayout)findViewById(2131449688));
    this.h = ((BaseVideoView)QQVideoViewFactory.createBaseVideoView(this.j, 109L, null, null));
    this.h.setOnClickListener(getOnVideoViewClickListener());
    this.b.addView(this.h, -1, -1);
  }
  
  private String a(long paramLong)
  {
    if (this.i == null) {
      this.i = new SimpleDateFormat("mm:ss");
    }
    return this.i.format(Long.valueOf(paramLong));
  }
  
  private URLDrawable.URLDrawableOptions b(LocalMediaInfo paramLocalMediaInfo)
  {
    int i1 = ImmersiveUtils.getScreenWidth();
    int i2 = (int)(i1 / paramLocalMediaInfo.mediaWidth * paramLocalMediaInfo.mediaHeight);
    paramLocalMediaInfo = URLDrawable.URLDrawableOptions.obtain();
    paramLocalMediaInfo.mRequestWidth = i1;
    paramLocalMediaInfo.mRequestHeight = i2;
    ColorDrawable localColorDrawable = this.n;
    paramLocalMediaInfo.mFailedDrawable = localColorDrawable;
    paramLocalMediaInfo.mLoadingDrawable = localColorDrawable;
    return paramLocalMediaInfo;
  }
  
  private void b()
  {
    BaseVideoView localBaseVideoView = this.h;
    if (localBaseVideoView != null)
    {
      if (localBaseVideoView.mIsPlayVideo)
      {
        this.h.resume();
        return;
      }
      this.h.play();
    }
  }
  
  private VideoPlayParam c(LocalMediaInfo paramLocalMediaInfo)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mVideoFormat = 104;
    localVideoPlayParam.mIsLocal = true;
    localVideoPlayParam.mIsLoop = true;
    localVideoPlayParam.mSceneId = 109;
    localVideoPlayParam.mVideoPath = paramLocalMediaInfo.path;
    localVideoPlayParam.mNeedPlayProgress = true;
    localVideoPlayParam.mCallback = new WinkCircleVideoPreviewItemView.1(this, paramLocalMediaInfo);
    return localVideoPlayParam;
  }
  
  private SeekBar.OnSeekBarChangeListener getOnSeekBarChangeListener()
  {
    if (this.l == null) {
      this.l = new WinkCircleVideoPreviewItemView.3(this);
    }
    return this.l;
  }
  
  private View.OnClickListener getOnVideoViewClickListener()
  {
    if (this.k == null) {
      this.k = new WinkCircleVideoPreviewItemView.2(this);
    }
    return this.k;
  }
  
  private View.OnTouchListener getSeekBarTouchListener()
  {
    if (this.m == null) {
      this.m = new WinkCircleVideoPreviewItemView.4(this);
    }
    return this.m;
  }
  
  public void a()
  {
    b();
    Object localObject = this.c;
    localObject = this.g;
    if (localObject != null) {
      ((SeekBar)localObject).setProgress(0);
    }
    localObject = this.d;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = this.f;
    if (localObject != null) {
      ((TextView)localObject).setText(a(0L));
    }
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo)
  {
    this.a = paramLocalMediaInfo;
    this.h.setVideoParam(c(paramLocalMediaInfo));
    this.c.setImageDrawable(URLDrawable.getDrawable(QAlbumUtil.generateAlbumVideoThumbURL(paramLocalMediaInfo.path, null), b(paramLocalMediaInfo)));
    this.e.setText(a(paramLocalMediaInfo.mDuration));
    this.d.setVisibility(0);
    this.g.setProgress(0);
    this.h.play();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.h != null)
    {
      QLog.d("WinkCircleVideoPreviewItemView", 4, "onDetachedFromWindow: video release");
      this.h.pause();
      this.h.releasePlayer(false);
    }
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.h == null)
    {
      this.h = ((BaseVideoView)QQVideoViewFactory.createBaseVideoView(this.j, 109L, null, null));
      this.h.setOnClickListener(getOnVideoViewClickListener());
      paramView = this.a;
      if (paramView != null) {
        this.h.setVideoParam(c(paramView));
      }
      this.b.addView(this.h, -1, -1);
    }
    if (paramInt == 0)
    {
      b();
      return;
    }
    QLog.d("WinkCircleVideoPreviewItemView", 4, "onVisibilityChanged: video release");
    this.h.pause();
    this.h.releasePlayer(false);
    paramView = this.b;
    if (paramView != null) {
      paramView.removeView(this.h);
    }
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.widget.WinkCircleVideoPreviewItemView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SeekBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.CustomClickListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.AbsVideoFeedsGestureLayout;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoBrightnessController;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsGestureLayout
  extends AbsVideoFeedsGestureLayout
{
  private int a = 0;
  private IVideoPlayManager b;
  private IVideoFeedsPlayManager c;
  private VideoBrightnessController d;
  private CustomClickListener e;
  private GestureDetector f;
  private VideoFeedsGestureUIManager g;
  private int h;
  private boolean i = false;
  private AudioManager j;
  private int k = 0;
  private int l;
  private int m;
  private int n = -1;
  private int o;
  private boolean p = false;
  private float q;
  private int r;
  private boolean s = false;
  private boolean t = false;
  private SeekBar u;
  private long v;
  private long w = 0L;
  private long x = 0L;
  private TopGestureLayout y;
  private Activity z;
  
  public VideoFeedsGestureLayout(Context paramContext)
  {
    super(paramContext, null, 0);
  }
  
  public VideoFeedsGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(float paramFloat)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((IVideoPlayManager)localObject).a() != null))
    {
      l2 = this.b.a().l * 1000;
      l1 = this.b.f();
    }
    else
    {
      localObject = this.c;
      if (localObject == null) {
        break label88;
      }
      l2 = ((IVideoFeedsPlayManager)localObject).t();
      l1 = this.c.b();
    }
    break label95;
    label88:
    long l1 = 0L;
    long l2 = l1;
    label95:
    if ((this.k == 0) && (l2 != 0L)) {
      this.q = ((float)l1 / (float)l2);
    }
    float f2 = this.q + paramFloat;
    float f1;
    if (f2 > 1.0F)
    {
      f1 = 1.0F;
    }
    else
    {
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = 0.0F;
      }
    }
    this.r = ((int)((float)l2 * f1));
    this.g.a(3, paramFloat, this.r, l2);
  }
  
  private void b()
  {
    if (this.k == 3)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        ((IVideoPlayManager)localObject).b(this.r);
        localObject = this.u;
        if (localObject != null) {
          ((SeekBar)localObject).setProgress(this.r / 1000);
        }
      }
      else
      {
        localObject = this.c;
        if (localObject != null) {
          ((IVideoFeedsPlayManager)localObject).a(this.r, true);
        }
      }
    }
    this.g.a(0, 0.0F, 0L, 0L);
  }
  
  private void b(float paramFloat)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    if (this.k == 0)
    {
      if (((VideoBrightnessController)localObject).b()) {
        this.p = true;
      }
      i1 = this.n;
      if (i1 == -1)
      {
        if (this.p) {
          this.m = 127;
        } else {
          this.m = this.d.c();
        }
      }
      else {
        this.m = i1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mBeginBrightness = ");
        ((StringBuilder)localObject).append(this.m);
        QLog.i("VideoFeedsItemFrameLayout", 2, ((StringBuilder)localObject).toString());
      }
    }
    int i1 = (int)(paramFloat * 255.0F);
    int i2 = this.m + i1;
    if (i2 > 255)
    {
      i1 = 255;
    }
    else
    {
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
    }
    localObject = this.d;
    paramFloat = i1 / 255.0F;
    ((VideoBrightnessController)localObject).a(paramFloat);
    this.g.a(2, paramFloat, 0L, 0L);
    this.n = i1;
  }
  
  private void c(float paramFloat)
  {
    if (this.k == 0) {
      this.l = this.j.getStreamVolume(3);
    }
    int i1 = this.o;
    int i2 = (int)(i1 * paramFloat) + this.l;
    if (i2 <= i1)
    {
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
    }
    int i3 = this.a;
    i2 = 2;
    if (i3 != 2) {
      i2 = 1;
    }
    if (i1 == 0) {
      VideoVolumeControl.getInstance().setMute(true, "user_gesture", i2);
    } else {
      VideoVolumeControl.getInstance().setMute(false, "user_gesture", i2);
    }
    this.j.setStreamVolume(3, i1, 0);
    this.g.a(1, i1 / this.o, 0L, 0L);
  }
  
  private void setActivityGestureLayoutAvailable(boolean paramBoolean)
  {
    Object localObject1 = this.z;
    if (localObject1 == null) {
      return;
    }
    if (this.y == null)
    {
      localObject1 = (ViewGroup)((Activity)localObject1).getWindow().getDecorView();
      int i1 = 0;
      while (i1 < ((ViewGroup)localObject1).getChildCount())
      {
        View localView = ((ViewGroup)localObject1).getChildAt(i1);
        Object localObject2 = localObject1;
        if (localView != null)
        {
          localObject2 = localObject1;
          if ((localView instanceof ViewGroup)) {
            localObject2 = (ViewGroup)localView;
          }
        }
        if ((localObject2 instanceof TopGestureLayout))
        {
          this.y = ((TopGestureLayout)localObject2);
          break;
        }
        i1 += 1;
        localObject1 = localObject2;
      }
    }
    localObject1 = this.y;
    if (localObject1 != null) {
      ((TopGestureLayout)localObject1).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public void a()
  {
    VideoFeedsGestureUIManager localVideoFeedsGestureUIManager = this.g;
    if (localVideoFeedsGestureUIManager != null) {
      localVideoFeedsGestureUIManager.a();
    }
    this.k = 0;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if (!this.s) {
      return;
    }
    CustomClickListener localCustomClickListener;
    if (paramInt == 0)
    {
      this.t = false;
      localCustomClickListener = this.e;
      if (localCustomClickListener != null) {
        localCustomClickListener.a(this, 1);
      }
    }
    else if (!this.t)
    {
      this.t = true;
      localCustomClickListener = this.e;
      if (localCustomClickListener != null) {
        localCustomClickListener.a(this, 2);
      }
    }
    if (this.j == null)
    {
      this.j = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
      this.o = this.j.getStreamMaxVolume(3);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            a(paramFloat);
          }
        }
        else {
          b(paramFloat);
        }
      }
      else {
        c(paramFloat);
      }
    }
    else {
      b();
    }
    this.k = paramInt;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.x = System.currentTimeMillis();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public long getLastMotionTouchTime()
  {
    return this.x;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.f == null) {
      this.f = new GestureDetector(getContext(), new VideoFeedsGestureLayout.MyGestureListener(this));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    boolean bool = false;
    if ((i1 == 1) && (this.h != 0))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("channel_id", this.v);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      i1 = this.h;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3) {
            PublicAccountReportUtils.b(null, null, "0X8008A41", "0X8008A41", 0, 0, "", "", "", VideoReporter.b(localJSONObject), false);
          }
        }
        else {
          PublicAccountReportUtils.b(null, null, "0X8008A42", "0X8008A42", 0, 0, "", "", "", VideoReporter.b(localJSONObject), false);
        }
      }
      else {
        PublicAccountReportUtils.b(null, null, "0X8008A43", "0X8008A43", 0, 0, "", "", "", VideoReporter.b(localJSONObject), false);
      }
      this.h = 0;
      a(0, 0.0F);
    }
    this.f.onTouchEvent(paramMotionEvent);
    if ((this.s) || (this.a != 1)) {
      bool = true;
    }
    return bool;
  }
  
  public void setChannelID(long paramLong)
  {
    this.v = paramLong;
  }
  
  public void setContext(Activity paramActivity)
  {
    this.z = paramActivity;
  }
  
  public void setIsInFullScreen(boolean paramBoolean)
  {
    this.s = paramBoolean;
    if ((this.s) && (!this.i))
    {
      this.g = new VideoFeedsGestureUIManager();
      try
      {
        this.g.a(this.z, this);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wgs error =");
          localStringBuilder.append(localException.getMessage());
          QLog.d("VideoFeedsItemFrameLayout", 2, localStringBuilder.toString());
        }
      }
      this.i = true;
    }
    if (this.s)
    {
      setActivityGestureLayoutAvailable(false);
      return;
    }
    setActivityGestureLayoutAvailable(true);
    VideoBrightnessController localVideoBrightnessController = this.d;
    if (localVideoBrightnessController != null)
    {
      localVideoBrightnessController.a();
      this.n = -1;
    }
  }
  
  @Deprecated
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnCustomClickListener(CustomClickListener paramCustomClickListener)
  {
    this.e = paramCustomClickListener;
  }
  
  public void setSeekBar(SeekBar paramSeekBar)
  {
    this.u = paramSeekBar;
  }
  
  public void setVideoBrightnessController(VideoBrightnessController paramVideoBrightnessController)
  {
    this.d = paramVideoBrightnessController;
  }
  
  public void setVideoPlayManager(IVideoPlayManager paramIVideoPlayManager)
  {
    this.b = paramIVideoPlayManager;
    this.a = 1;
  }
  
  public void setVideoPlayManager(IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    this.c = paramIVideoFeedsPlayManager;
    this.a = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGestureLayout
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGestureLayout;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.CustomClickListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoBrightnessController;
import com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaLazyFragment;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import java.util.HashMap;

public class ViolaVideoView
  extends FrameLayout
  implements View.OnClickListener, CustomClickListener, IVideoView, VideoPlayManager.VideoStatusListener
{
  private static HashMap<Integer, Drawable> F = new HashMap();
  private VideoPlayManager A;
  private Handler B = new ViolaVideoView.UIHandler(this, null);
  private ColorDrawable C;
  private IVideoView.VideoViewEventListener D;
  private int E;
  private HashMap<Integer, Drawable> G = new HashMap();
  private boolean a = false;
  private boolean b = true;
  private long c;
  private boolean d = false;
  private ViewGroup e;
  private URLImageView f;
  private ImageView g;
  private ViewGroup h;
  private SeekBar i;
  private TextView j;
  private TextView k;
  private TextView l;
  private ViewGroup m;
  private ViewGroup n;
  private View o;
  private int p = 0;
  private boolean q = false;
  private VideoFeedsGestureLayout r;
  private VideoBrightnessController s;
  private ViewGroup t;
  private ImageView u;
  private ViewGroup v;
  private View w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  public ViolaVideoView(@NonNull Activity paramActivity)
  {
    super(paramActivity);
    setTag("ViolaVideoView");
    this.e = new FrameLayout(paramActivity);
    addView(this.e, -1, -1);
    this.f = new URLImageView(paramActivity);
    this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.f, -1, -1);
    this.o = LayoutInflater.from(paramActivity).inflate(2131626418, this, false);
    addView(this.o);
    a(this.o, paramActivity);
    this.C = new ColorDrawable(paramActivity.getResources().getColor(2131165564));
    this.f.setImageDrawable(this.C);
    paramActivity.getWindow().setFlags(16777216, 16777216);
  }
  
  private static Drawable a(Context paramContext, int paramInt)
  {
    Object localObject = F;
    if (localObject == null) {
      return null;
    }
    if (((HashMap)localObject).containsKey(Integer.valueOf(paramInt))) {
      return (Drawable)F.get(Integer.valueOf(paramInt));
    }
    try
    {
      paramContext = paramContext.getResources().getDrawable(paramInt);
      F.put(Integer.valueOf(paramInt), paramContext);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("innerGetDrawableFromCache() OutOfMemoryError e=");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        QLog.d("ViolaVideoView", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (!this.A.n()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("innerChangePlayButton() what = ");
      localStringBuilder.append(paramInt);
      QLog.d("ViolaVideoView", 2, localStringBuilder.toString());
    }
    this.b = false;
    this.B.obtainMessage(paramInt, paramString).sendToTarget();
  }
  
  private void a(View paramView, Activity paramActivity)
  {
    this.r = ((VideoFeedsGestureLayout)paramView.findViewById(2131434168));
    this.g = ((ImageView)paramView.findViewById(2131440375));
    this.m = ((ViewGroup)paramView.findViewById(2131449516));
    this.i = ((SeekBar)paramView.findViewById(2131445507));
    this.j = ((TextView)paramView.findViewById(2131431532));
    this.k = ((TextView)paramView.findViewById(2131447796));
    this.h = ((ViewGroup)paramView.findViewById(2131440376));
    this.l = ((TextView)paramView.findViewById(2131432597));
    this.n = ((ViewGroup)paramView.findViewById(2131429659));
    this.t = ((ViewGroup)paramView.findViewById(2131433908));
    this.u = ((ImageView)paramView.findViewById(2131433909));
    this.y = ((TextView)paramView.findViewById(2131439639));
    this.z = ((TextView)paramView.findViewById(2131433137));
    this.v = ((ViewGroup)paramView.findViewById(2131433907));
    this.w = paramView.findViewById(2131430821);
    this.x = ((TextView)paramView.findViewById(2131433910));
    this.g.setBackgroundDrawable(null);
    this.g.setOnClickListener(this);
    this.y.setOnClickListener(this);
    i();
    this.t.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.x.getPaint().setFakeBoldText(true);
    this.s = new VideoBrightnessController(paramActivity);
    this.r.setOnCustomClickListener(this);
    this.r.setContext(paramActivity);
    this.r.setVideoBrightnessController(this.s);
    this.r.setVideoPlayManager(this.A);
  }
  
  private Drawable b(int paramInt)
  {
    if (this.G.containsKey(Integer.valueOf(paramInt))) {
      return (Drawable)this.G.get(Integer.valueOf(paramInt));
    }
    try
    {
      Drawable localDrawable = getContext().getResources().getDrawable(paramInt);
      this.G.put(Integer.valueOf(paramInt), localDrawable);
      return localDrawable;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("innerGetDrawableFromCache() OutOfMemoryError e=");
        localStringBuilder.append(localOutOfMemoryError.getMessage());
        QLog.d("ViolaVideoView", 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (!this.A.n()) {
      return;
    }
    VideoFeedsHelper.b(this.f, paramInt1, paramInt2);
  }
  
  private void b(int paramInt, String paramString)
  {
    if (this.A.m() == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("innerChangePlayButtonFromOpen() what = ");
      localStringBuilder.append(paramInt);
      QLog.d("ViolaVideoView", 2, localStringBuilder.toString());
    }
    this.b = false;
    this.B.obtainMessage(paramInt, paramString).sendToTarget();
  }
  
  private void c(VideoInfo paramVideoInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131913650));
    ((StringBuilder)localObject).append(VideoFeedsHelper.c(paramVideoInfo.h));
    localObject = ((StringBuilder)localObject).toString();
    if (paramVideoInfo.h <= 0L) {
      localObject = HardCodeUtil.a(2131913651);
    }
    paramVideoInfo = this.z;
    paramVideoInfo.setText((CharSequence)localObject);
    VideoFeedsHelper.a(paramVideoInfo, 0);
    this.B.postDelayed(new ViolaVideoView.10(this, paramVideoInfo), 1000L);
  }
  
  private boolean c(View paramView)
  {
    return (this.A.m() != null) && (paramView.getTag() == this.A.m());
  }
  
  private void g()
  {
    if (!this.d) {
      return;
    }
    if (this.A.m() == null) {
      return;
    }
    this.d = false;
    if (getParent() != null)
    {
      VVideoView localVVideoView = (VVideoView)getParent();
      a();
      localVVideoView.b(1);
      b();
      a(1);
    }
  }
  
  private void h()
  {
    if (this.d) {
      return;
    }
    if (this.A.m() == null) {
      return;
    }
    this.d = true;
    if (getParent() != null)
    {
      VVideoView localVVideoView = (VVideoView)getParent();
      a();
      localVVideoView.a(0);
      b();
      a(0, false);
    }
  }
  
  private void i()
  {
    this.i.setOnSeekBarChangeListener(new ViolaVideoView.9(this));
  }
  
  private boolean i(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    boolean bool1 = NetworkUtil.isMobileNetWork(getContext());
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (paramVideoPlayParam != null)
    {
      bool1 = bool2;
      if (paramVideoPlayParam.c != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean j(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    return (paramVideoPlayParam != null) && (paramVideoPlayParam.c != null) && (!paramVideoPlayParam.f) && (NetworkUtil.isMobileNetWork(getContext())) && (paramVideoPlayParam.c.h >= 0L);
  }
  
  private void setControllerVisibility(boolean paramBoolean)
  {
    IVideoView.VideoViewEventListener localVideoViewEventListener;
    if (paramBoolean)
    {
      if (this.m.getVisibility() == 8)
      {
        localVideoViewEventListener = this.D;
        if (localVideoViewEventListener != null) {
          localVideoViewEventListener.a(paramBoolean);
        }
        VideoFeedsHelper.a(this.m, 0);
      }
      if (this.h.getVisibility() == 8) {
        VideoFeedsHelper.a(this.h, 0);
      }
    }
    else
    {
      if (this.m.getVisibility() == 0)
      {
        localVideoViewEventListener = this.D;
        if (localVideoViewEventListener != null) {
          localVideoViewEventListener.a(paramBoolean);
        }
        VideoFeedsHelper.a(this.m, 8);
      }
      if ((this.A.g()) && (this.h.getVisibility() == 0)) {
        VideoFeedsHelper.a(this.h, 8);
      }
      this.l.setVisibility(8);
    }
  }
  
  private void setSeekBarDisable(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.i.setClickable(true);
      this.i.setEnabled(true);
      this.i.setSelected(true);
      this.i.setFocusable(true);
      return;
    }
    this.i.setClickable(false);
    this.i.setEnabled(false);
    this.i.setSelected(false);
    this.i.setFocusable(false);
  }
  
  private void setSeekbarLayoutBottomMargin(int paramInt)
  {
    ((ViewGroup.MarginLayoutParams)this.n.getLayoutParams()).bottomMargin = paramInt;
    this.n.requestLayout();
  }
  
  public void a()
  {
    if ((this.A.m() != null) && (this.A.m().b != null)) {
      this.A.m().b.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "deal exitFullScreen: ");
    }
    this.d = false;
    setControlType(this.p);
    this.r.setIsInFullScreen(false);
    if (paramInt == 1) {
      ((Activity)getContext()).setRequestedOrientation(1);
    } else {
      ((Activity)getContext()).setRequestedOrientation(9);
    }
    ((Activity)getContext()).setRequestedOrientation(1);
    if (getParent() != null)
    {
      localObject = (VVideoView)getParent();
      ((Activity)getContext()).getWindow().getDecorView().setSystemUiVisibility(this.E);
      if ((((VVideoView)localObject).getComponent() != null) && (((VVideoView)localObject).getComponent().getInstance() != null) && (((VVideoView)localObject).getComponent().getInstance().getFragment() != null))
      {
        localObject = (ViolaLazyFragment)((VVideoView)localObject).getComponent().getInstance().getFragment();
        if (localObject != null)
        {
          ((ViolaLazyFragment)localObject).showTitleBar();
          ((ViolaLazyFragment)localObject).recoverStatusBar();
        }
      }
      localObject = this.A.m();
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      localLayoutParams.height = ((VideoPlayManager.VideoPlayParam)localObject).h;
      localLayoutParams.width = ((VideoPlayManager.VideoPlayParam)localObject).g;
    }
    this.v.setPadding(0, 0, 0, 0);
    Object localObject = this.D;
    if (localObject != null) {
      ((IVideoView.VideoViewEventListener)localObject).b(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    ((ViewGroup.LayoutParams)localObject).height = paramInt2;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSizeChanged: width=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",height=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ViolaVideoView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoView", 2, "deal enterFullScreen: ");
    }
    this.d = true;
    setControlType(this.p);
    this.r.setIsInFullScreen(true);
    if (!paramBoolean) {
      if (paramInt == 0) {
        ((Activity)getContext()).setRequestedOrientation(0);
      } else {
        ((Activity)getContext()).setRequestedOrientation(8);
      }
    }
    if (getParent() != null)
    {
      localObject = (VVideoView)getParent();
      Activity localActivity = (Activity)getContext();
      this.E = localActivity.getWindow().getDecorView().getSystemUiVisibility();
      VideoFeedsHelper.h(localActivity);
      if ((((VVideoView)localObject).getComponent() != null) && (((VVideoView)localObject).getComponent().getInstance() != null) && (((VVideoView)localObject).getComponent().getInstance().getFragment() != null))
      {
        localObject = (ViolaLazyFragment)((VVideoView)localObject).getComponent().getInstance().getFragment();
        if (localObject != null)
        {
          ((ViolaLazyFragment)localObject).hideTitleBar();
          ((ViolaLazyFragment)localObject).hideStatusBar();
        }
      }
      localObject = getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = -1;
      ((ViewGroup.LayoutParams)localObject).width = -1;
    }
    if (paramBoolean) {
      this.v.setPadding(0, 40, 0, 0);
    }
    Object localObject = this.D;
    if (localObject != null) {
      ((IVideoView.VideoViewEventListener)localObject).b(true);
    }
  }
  
  public void a(View paramView)
  {
    if (!c(paramView)) {
      return;
    }
    boolean bool;
    if (this.m.getVisibility() == 8) {
      bool = true;
    } else {
      bool = false;
    }
    setControllerVisibility(bool);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (!c(paramView)) {
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      setControllerVisibility(false);
      return;
    }
    setControllerVisibility(true);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.f))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Object localObject = getLayoutParams();
      int i1 = ((ViewGroup.LayoutParams)localObject).width;
      int i2 = 0;
      if (i1 > 0) {
        i1 = ((ViewGroup.LayoutParams)localObject).width;
      } else {
        i1 = 0;
      }
      localURLDrawableOptions.mRequestWidth = i1;
      i1 = i2;
      if (((ViewGroup.LayoutParams)localObject).height > 0) {
        i1 = ((ViewGroup.LayoutParams)localObject).height;
      }
      localURLDrawableOptions.mRequestHeight = i1;
      localURLDrawableOptions.mPlayGifImage = true;
      localObject = this.C;
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.f, localURLDrawableOptions);
      this.f.setImageDrawable(paramVideoInfo);
      return;
    }
    this.f.setImageDrawable(null);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(paramVideoPlayParam.g, paramVideoPlayParam.h);
    a(paramVideoPlayParam.c);
    if (j(paramVideoPlayParam)) {
      b(paramVideoPlayParam.c);
    }
    setControllerVisibility(false);
    this.A.f(paramVideoPlayParam.j);
    if (paramVideoPlayParam.k != -1) {
      setSeekbarLayoutBottomMargin(paramVideoPlayParam.k);
    }
    setFullScreenDisable(paramVideoPlayParam.l);
    setSeekBarDisable(paramVideoPlayParam.m);
    this.B.removeMessages(0);
    this.B.sendEmptyMessageDelayed(0, 3000L);
    this.g.setTag(paramVideoPlayParam);
    this.t.setTag(paramVideoPlayParam);
    this.w.setTag(paramVideoPlayParam);
    this.r.setTag(paramVideoPlayParam);
    this.y.setTag(paramVideoPlayParam);
    setFullScreenTitle(paramVideoPlayParam.c.g);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    a(2, null);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt1, int paramInt2, String paramString)
  {
    this.B.post(new ViolaVideoView.8(this, paramString));
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, long paramLong)
  {
    long l1 = this.A.j();
    if (!this.a)
    {
      if (l1 == 0L)
      {
        this.i.setProgress(0);
      }
      else if (paramLong != 0L)
      {
        int i1 = (int)(100L * paramLong / l1);
        float f1 = Math.round(100000.0F / (float)l1);
        float f2 = i1 + f1;
        f1 = f2;
        if (f2 > 100.0F) {
          f1 = 100.0F;
        }
        this.i.setProgress((int)f1);
        VideoFeedsHelper.a(this.j, paramLong);
      }
      if (l1 > 0L) {
        VideoFeedsHelper.a(this.k, l1);
      }
    }
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    this.B.removeMessages(1);
    if (paramBoolean)
    {
      this.b = true;
      this.B.sendEmptyMessageDelayed(1, 1200L);
      return;
    }
    b(2, null);
  }
  
  public void a(VideoPlayManager paramVideoPlayManager)
  {
    this.A = paramVideoPlayManager;
  }
  
  public void b()
  {
    if ((this.A.m() != null) && (this.A.m().b != null)) {
      this.A.m().b.c();
    }
  }
  
  public void b(View paramView) {}
  
  protected void b(VideoInfo paramVideoInfo)
  {
    paramVideoInfo = VideoFeedsHelper.d(paramVideoInfo.h);
    this.g.setVisibility(8);
    Drawable localDrawable = getContext().getResources().getDrawable(2130844245);
    this.y.setText(paramVideoInfo);
    this.y.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.y.setCompoundDrawablePadding(DisplayUtil.a(getContext(), 6.0F));
    this.y.setVisibility(0);
  }
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam) {}
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    this.B.post(new ViolaVideoView.3(this));
  }
  
  public void c()
  {
    Object localObject = this.s;
    if (localObject != null)
    {
      ((VideoBrightnessController)localObject).d();
      this.s = null;
    }
    localObject = this.B;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(0);
      this.B.removeCallbacksAndMessages(null);
    }
  }
  
  public void c(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.B.post(new ViolaVideoView.1(this, paramVideoPlayParam));
  }
  
  public void d(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.B.post(new ViolaVideoView.2(this));
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public void e()
  {
    int i1;
    if (this.A.n()) {
      i1 = this.A.l();
    } else {
      i1 = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePlayButtonClick() status()=");
      ((StringBuilder)localObject).append(i1);
      QLog.d("ViolaVideoView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.A.m();
    switch (i1)
    {
    default: 
      return;
    case 6: 
      this.A.c((VideoPlayManager.VideoPlayParam)localObject);
      this.A.b((VideoPlayManager.VideoPlayParam)localObject);
      return;
    case 5: 
      this.A.d(1);
      return;
    case 3: 
    case 4: 
      this.A.c(1);
      return;
    case 2: 
      this.A.h();
      return;
    case 1: 
      this.A.c(1);
      return;
    }
    this.A.b((VideoPlayManager.VideoPlayParam)localObject);
  }
  
  public void e(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.B.post(new ViolaVideoView.4(this));
  }
  
  public void f()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeFullScreenStatus: mIsShowingFull=");
      localStringBuilder.append(this.d);
      QLog.d("ViolaVideoView", 2, localStringBuilder.toString());
    }
    if (this.d)
    {
      g();
      return;
    }
    h();
  }
  
  public void f(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.B.post(new ViolaVideoView.5(this));
  }
  
  public void g(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.B.post(new ViolaVideoView.6(this));
  }
  
  public ViewGroup getVideoContainer()
  {
    return this.e;
  }
  
  public ViewGroup getVideoControllerLayout()
  {
    return this.m;
  }
  
  public VideoPlayManager getVideoPlayManager()
  {
    return this.A;
  }
  
  public void h(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.B.post(new ViolaVideoView.7(this));
  }
  
  public void onClick(View paramView)
  {
    if (!c(paramView)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131440375: 
      e();
      return;
    case 2131439639: 
      if (this.A.p()) {
        VideoFeedsHelper.a(this.m, 8, 200);
      }
      e();
      return;
    case 2131433908: 
      f();
      return;
    }
    f();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.c = System.currentTimeMillis();
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setControlType(int paramInt)
  {
    this.p = paramInt;
    int i1 = this.p;
    paramInt = 8;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        localObject = this.v;
        if (this.d) {
          paramInt = 0;
        }
        ((ViewGroup)localObject).setVisibility(paramInt);
        this.o.setVisibility(0);
        localImageView = this.u;
        if (this.d) {
          localObject = a(getContext(), 2130842768);
        } else {
          localObject = a(getContext(), 2130842769);
        }
        localImageView.setBackgroundDrawable((Drawable)localObject);
        return;
      }
      Object localObject = this.o;
      if (this.d) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((View)localObject).setVisibility(i1);
      localObject = this.v;
      if (this.d) {
        paramInt = 0;
      }
      ((ViewGroup)localObject).setVisibility(paramInt);
      ImageView localImageView = this.u;
      if (this.d) {
        localObject = a(getContext(), 2130842768);
      } else {
        localObject = a(getContext(), 2130842769);
      }
      localImageView.setBackgroundDrawable((Drawable)localObject);
      return;
    }
    this.o.setVisibility(8);
  }
  
  public void setEndWithLastFrame(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setEventListener(IVideoView.VideoViewEventListener paramVideoViewEventListener)
  {
    this.D = paramVideoViewEventListener;
  }
  
  public void setFullScreenDisable(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this.t;
    int i1;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    localViewGroup.setVisibility(i1);
  }
  
  public void setFullScreenTitle(String paramString)
  {
    this.x.setText(paramString);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.ViolaVideoView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qzonevip.gift;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleExplodeView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vip.diy.common.DIYLottieLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import java.lang.ref.WeakReference;
import mqq.manager.Manager;

public class QzoneGiftManager
  implements View.OnTouchListener, QzoneGiftUtil.GiftLoadListener, Manager
{
  public static final float a = ViewUtils.getScreenWidth() / 720.0F;
  private static QzoneGiftManager q = null;
  private QzoneGiftManager.UIHandler b = new QzoneGiftManager.UIHandler(this, Looper.getMainLooper());
  private Drawable c;
  private Drawable d;
  private Bitmap e;
  private WeakReference<FrameLayout> f;
  private FrameLayout g;
  private ImageView h;
  private ImageView i;
  private ParticleExplodeView j;
  private ImageView k;
  private ParticleDropView l;
  private QzoneGiftManager.GiftData m;
  private DiniFlyAnimationView n;
  private DIYLottieLoader o;
  private Downloader p = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  
  private Drawable a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QzoneGiftManager", 1, "createAnimationDrawable mZipPath = null");
      return null;
    }
    Drawable localDrawable = ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
    String str = QzoneGiftUtil.a(paramString);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createAnimationDrawable mZipPath = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" resUrl = ");
      localStringBuilder.append(str);
      QLog.i("QzoneGiftManager", 4, localStringBuilder.toString());
    }
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(localDrawable, str, paramInt);
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setScale(localDrawable, a);
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(localDrawable);
    return localDrawable;
  }
  
  public static QzoneGiftManager a()
  {
    if (q == null) {
      try
      {
        if (q == null) {
          q = new QzoneGiftManager();
        }
      }
      finally {}
    }
    return q;
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QzoneGiftManager.UIHandler localUIHandler = this.b;
    if (localUIHandler == null) {
      return;
    }
    if (localUIHandler.hasMessages(paramInt1)) {
      this.b.removeMessages(paramInt1);
    }
    this.b.sendEmptyMessageDelayed(paramInt1, paramInt2);
  }
  
  private void f()
  {
    if (this.b == null) {
      return;
    }
    int i1 = 1;
    while (i1 < 9)
    {
      if (this.b.hasMessages(i1)) {
        this.b.removeMessages(i1);
      }
      i1 += 1;
    }
  }
  
  private void g()
  {
    if ((this.p != null) && (e()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("aio_lottie_gift", String.valueOf(this.m.e.hashCode())));
      ((StringBuilder)localObject).append(".zip");
      localObject = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" preloadLottieZip local path = ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" zipUrl = ");
        localStringBuilder.append(this.m.e);
        QLog.i("QzoneGiftManager", 2, localStringBuilder.toString());
      }
      this.p.download(this.m.e, (String)localObject, new QzoneGiftManager.1(this));
      return;
    }
    QLog.e("QzoneGiftManager", 1, "preloadLottieZip error");
  }
  
  private void h()
  {
    DIYLottieLoader localDIYLottieLoader = new DIYLottieLoader(BaseApplicationImpl.getContext());
    localDIYLottieLoader.setMemoryCacheSize((int)(MemoryManager.d() / 2L));
    this.o = localDIYLottieLoader;
  }
  
  private void i()
  {
    this.n = new DiniFlyAnimationView(BaseApplicationImpl.getContext());
    this.n.loop(false);
    this.n.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.n.addAnimatorListener(new QzoneGiftManager.2(this));
  }
  
  private void j()
  {
    if (!e()) {
      return;
    }
    h();
    i();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("aio_lottie_gift", String.valueOf(this.m.e.hashCode())));
    ((StringBuilder)localObject).append(".zip");
    localObject = ((StringBuilder)localObject).toString();
    this.o.fromNetworkWithCacheBitmap(this.n, this.m.e, (String)localObject, true);
    a(1);
  }
  
  private void k()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_CONTENT_VIEW");
    Object localObject = l();
    if (localObject != null)
    {
      this.f = new WeakReference((FrameLayout)((Activity)localObject).findViewById(16908290));
      localObject = (FrameLayout)this.f.get();
      if (localObject == null)
      {
        QLog.e("QzoneGiftManager", 1, "mParentLayout = null");
        return;
      }
      this.g = new FrameLayout(BaseApplicationImpl.getContext());
      this.g.setOnTouchListener(this);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout)localObject).addView(this.g, localLayoutParams);
      if (e())
      {
        this.b.sendEmptyMessage(7);
        return;
      }
      a(2);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "activity = null");
  }
  
  private Activity l()
  {
    if (BaseActivity.sTopActivity != null) {
      return BaseActivity.sTopActivity;
    }
    if (QBaseActivity.sTopActivity != null) {
      return QBaseActivity.sTopActivity;
    }
    return null;
  }
  
  private void m()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_VIEW");
    if (this.g == null)
    {
      QLog.e("QzoneGiftManager", 1, "mCotentLayout = null");
      return;
    }
    this.k = new ImageView(BaseApplicationImpl.getContext());
    this.g.addView(this.k);
    this.h = new ImageView(BaseApplicationImpl.getContext());
    this.h.setImageDrawable(this.c);
    this.i = new ImageView(BaseApplicationImpl.getContext());
    this.i.setImageDrawable(this.d);
    this.i.setAlpha(0);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(200.0F), ViewUtils.dpToPx(200.0F));
    localLayoutParams.gravity = 17;
    this.g.addView(this.h, localLayoutParams);
    this.g.addView(this.i, localLayoutParams);
    this.j = new ParticleExplodeView(BaseApplicationImpl.getContext());
    this.l = new ParticleDropView(BaseApplicationImpl.getContext());
    this.l.setBitmap(this.e);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.g.addView(this.j, localLayoutParams);
    this.g.addView(this.l, localLayoutParams);
    a(3);
  }
  
  private void n()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_BOX_ANIMATION_START");
    if (this.c != null)
    {
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).start(this.c);
      a(5, ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).getDuration(this.c) - 330);
      a(4, ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).getDuration(this.c) - 300);
    }
    if (this.c == null) {
      a(4, 0);
    }
  }
  
  private void o()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_START");
    q();
    if (this.d != null) {
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).start(this.d);
    }
    Object localObject = this.l;
    if (localObject != null) {
      ((ParticleDropView)localObject).d();
    }
    localObject = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.i, "scaleX", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.i, "scaleY", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.i, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator3.setInterpolator(new DecelerateInterpolator());
    ((AnimatorSet)localObject).setDuration(400L);
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    ((AnimatorSet)localObject).start();
    if (this.d != null) {
      a(6, ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).getDuration(this.d) + 2000);
    }
  }
  
  private void p()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_PARTICLE_EXPLODE");
    ParticleExplodeView localParticleExplodeView = this.j;
    if (localParticleExplodeView != null) {
      localParticleExplodeView.d();
    }
  }
  
  private void q()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_SHADER_SHOW");
    Object localObject = this.k;
    if (localObject != null)
    {
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#000000"));
      this.k.setAlpha(0);
      localObject = ObjectAnimator.ofFloat(this.k, "alpha", new float[] { 0.0F, 0.5F });
      ((ObjectAnimator)localObject).setDuration(300L);
      ((ObjectAnimator)localObject).start();
    }
  }
  
  private void r()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_STOP");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.g, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.addListener(new QzoneGiftManager.3(this));
    localObjectAnimator.start();
  }
  
  private void s()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_LOTTIE_ANIMATION_SHOW");
    if (this.n != null)
    {
      if (this.g == null) {
        return;
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.g.addView(this.n, localLayoutParams);
    }
  }
  
  private void t()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_RECYCLE_VIEW");
    if (this.c != null) {
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).release(this.c);
    }
    if (this.d != null) {
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).release(this.d);
    }
    Object localObject = this.o;
    if (localObject != null) {
      ((DIYLottieLoader)localObject).destroy();
    }
    localObject = this.n;
    if (localObject != null) {
      ((DiniFlyAnimationView)localObject).removeAllAnimatorListener();
    }
    localObject = this.f;
    if (localObject == null) {
      return;
    }
    localObject = (FrameLayout)((WeakReference)localObject).get();
    if (localObject != null)
    {
      FrameLayout localFrameLayout = this.g;
      if (localFrameLayout != null) {
        ((FrameLayout)localObject).removeView(localFrameLayout);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" preload data = ");
      localStringBuilder.append(paramString);
      QLog.i("QzoneGiftManager", 2, localStringBuilder.toString());
    }
    this.m = QzoneGiftManager.GiftData.a(paramString);
    if (e())
    {
      g();
      return;
    }
    paramString = this.m;
    if (paramString != null)
    {
      QzoneGiftUtil.a(null, paramString.b, this.m.c, this.m.d);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "preloadGiftData error with data = null");
  }
  
  public void b()
  {
    Object localObject = this.m;
    if ((localObject != null) && (!TextUtils.isEmpty(((QzoneGiftManager.GiftData)localObject).c)) && (!TextUtils.isEmpty(this.m.d)))
    {
      this.c = a(this.m.b, 10);
      this.d = a(this.m.c, 10);
      if (this.d != null)
      {
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.d, true);
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.d, false);
      }
      localObject = QzoneGiftUtil.a(this.m.d, "qzone_aio_gift");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("show Gift giftLocalPath = ");
          localStringBuilder.append((String)localObject);
          QLog.i("QzoneGiftManager", 4, localStringBuilder.toString());
        }
        this.e = BitmapFactory.decodeFile((String)localObject);
      }
      a(1);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "onSuccess show fail : data = null ");
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" startPlay data = ");
      localStringBuilder.append(paramString);
      QLog.i("QzoneGiftManager", 2, localStringBuilder.toString());
    }
    this.m = QzoneGiftManager.GiftData.a(paramString);
    if (e())
    {
      j();
      return;
    }
    paramString = this.m;
    if (paramString != null)
    {
      QzoneGiftUtil.a(this, paramString.b, this.m.c, this.m.d);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "preloadGiftData error with data = null");
  }
  
  public void c()
  {
    if (this.m == null)
    {
      QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFail show fail mGiftData = ");
    localStringBuilder.append(this.m.toString());
    QLog.e("QzoneGiftManager", 1, localStringBuilder.toString());
  }
  
  public void d()
  {
    QLog.i("QzoneGiftManager", 1, "onLoading");
  }
  
  public boolean e()
  {
    QzoneGiftManager.GiftData localGiftData = this.m;
    return (localGiftData != null) && (localGiftData.a == 1) && (!TextUtils.isEmpty(this.m.e));
  }
  
  public void onDestroy()
  {
    f();
    a(8);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      f();
      a(8);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftManager
 * JD-Core Version:    0.7.0.1
 */
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
  public static final float a;
  private static QzoneGiftManager jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager = null;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private QzoneGiftManager.GiftData jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData;
  private QzoneGiftManager.UIHandler jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler = new QzoneGiftManager.UIHandler(this, Looper.getMainLooper());
  private ParticleDropView jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView;
  private ParticleExplodeView jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView;
  private DIYLottieLoader jdField_a_of_type_ComTencentMobileqqVipDiyCommonDIYLottieLoader;
  private WeakReference<FrameLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  static
  {
    jdField_a_of_type_Float = ViewUtils.a() / 720.0F;
  }
  
  private Activity a()
  {
    if (BaseActivity.sTopActivity != null) {
      return BaseActivity.sTopActivity;
    }
    if (QBaseActivity.sTopActivity != null) {
      return QBaseActivity.sTopActivity;
    }
    return null;
  }
  
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
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setScale(localDrawable, jdField_a_of_type_Float);
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(localDrawable);
    return localDrawable;
  }
  
  public static QzoneGiftManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager == null) {
          jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager = new QzoneGiftManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager;
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QzoneGiftManager.UIHandler localUIHandler = this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler;
    if (localUIHandler == null) {
      return;
    }
    if (localUIHandler.hasMessages(paramInt1)) {
      this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler.removeMessages(paramInt1);
    }
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler.sendEmptyMessageDelayed(paramInt1, paramInt2);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler == null) {
      return;
    }
    int i = 1;
    while (i < 9)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler.hasMessages(i)) {
        this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler.removeMessages(i);
      }
      i += 1;
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader != null) && (a()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("aio_lottie_gift", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.d.hashCode())));
      ((StringBuilder)localObject).append(".zip");
      localObject = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" preloadLottieZip local path = ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" zipUrl = ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.d);
        QLog.i("QzoneGiftManager", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.d, (String)localObject, new QzoneGiftManager.1(this));
      return;
    }
    QLog.e("QzoneGiftManager", 1, "preloadLottieZip error");
  }
  
  private void f()
  {
    DIYLottieLoader localDIYLottieLoader = new DIYLottieLoader(BaseApplicationImpl.getContext());
    localDIYLottieLoader.setMemoryCacheSize((int)(MemoryManager.a() / 2L));
    this.jdField_a_of_type_ComTencentMobileqqVipDiyCommonDIYLottieLoader = localDIYLottieLoader;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = new DiniFlyAnimationView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(false);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new QzoneGiftManager.2(this));
  }
  
  private void h()
  {
    if (!a()) {
      return;
    }
    f();
    g();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("aio_lottie_gift", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.d.hashCode())));
    ((StringBuilder)localObject).append(".zip");
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_ComTencentMobileqqVipDiyCommonDIYLottieLoader.fromNetworkWithCacheBitmap(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.d, (String)localObject, true);
    a(1);
  }
  
  private void i()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_CONTENT_VIEW");
    Object localObject = a();
    if (localObject != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((FrameLayout)((Activity)localObject).findViewById(16908290));
      localObject = (FrameLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null)
      {
        QLog.e("QzoneGiftManager", 1, "mParentLayout = null");
        return;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(this);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, localLayoutParams);
      if (a())
      {
        this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler.sendEmptyMessage(7);
        return;
      }
      a(2);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "activity = null");
  }
  
  private void j()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_VIEW");
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      QLog.e("QzoneGiftManager", 1, "mCotentLayout = null");
      return;
    }
    this.c = new ImageView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.c);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(0);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.b(200.0F), ViewUtils.b(200.0F));
    localLayoutParams.gravity = 17;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView = new ParticleExplodeView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView = new ParticleDropView(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView, localLayoutParams);
    a(3);
  }
  
  private void k()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_BOX_ANIMATION_START");
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).start(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      a(5, ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).getDuration(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable) - 330);
      a(4, ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).getDuration(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable) - 300);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      a(4, 0);
    }
  }
  
  private void l()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_START");
    n();
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).start(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView;
    if (localObject != null) {
      ((ParticleDropView)localObject).b();
    }
    localObject = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "scaleX", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "scaleY", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator3.setInterpolator(new DecelerateInterpolator());
    ((AnimatorSet)localObject).setDuration(400L);
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    ((AnimatorSet)localObject).start();
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
      a(6, ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).getDuration(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable) + 2000);
    }
  }
  
  private void m()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_PARTICLE_EXPLODE");
    ParticleExplodeView localParticleExplodeView = this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView;
    if (localParticleExplodeView != null) {
      localParticleExplodeView.b();
    }
  }
  
  private void n()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_SHADER_SHOW");
    Object localObject = this.c;
    if (localObject != null)
    {
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#000000"));
      this.c.setAlpha(0);
      localObject = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { 0.0F, 0.5F });
      ((ObjectAnimator)localObject).setDuration(300L);
      ((ObjectAnimator)localObject).start();
    }
  }
  
  private void o()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_STOP");
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetFrameLayout, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.addListener(new QzoneGiftManager.3(this));
    localObjectAnimator.start();
  }
  
  private void p()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_LOTTIE_ANIMATION_SHOW");
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
        return;
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, localLayoutParams);
    }
  }
  
  private void q()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_RECYCLE_VIEW");
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).release(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).release(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVipDiyCommonDIYLottieLoader;
    if (localObject != null) {
      ((DIYLottieLoader)localObject).destroy();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if (localObject != null) {
      ((DiniFlyAnimationView)localObject).removeAllAnimatorListener();
    }
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (FrameLayout)((WeakReference)localObject).get();
    if (localObject != null)
    {
      FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (localFrameLayout != null) {
        ((FrameLayout)localObject).removeView(localFrameLayout);
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData;
    if ((localObject != null) && (!TextUtils.isEmpty(((QzoneGiftManager.GiftData)localObject).b)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.c)))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.jdField_a_of_type_JavaLangString, 10);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.b, 10);
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, true);
        ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, false);
      }
      localObject = QzoneGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.c, "qzone_aio_gift");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("show Gift giftLocalPath = ");
          localStringBuilder.append((String)localObject);
          QLog.i("QzoneGiftManager", 4, localStringBuilder.toString());
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile((String)localObject);
      }
      a(1);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "onSuccess show fail : data = null ");
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
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData = QzoneGiftManager.GiftData.a(paramString);
    if (a())
    {
      e();
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData;
    if (paramString != null)
    {
      QzoneGiftUtil.a(null, paramString.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.b, this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.c);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "preloadGiftData error with data = null");
  }
  
  public boolean a()
  {
    QzoneGiftManager.GiftData localGiftData = this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData;
    return (localGiftData != null) && (localGiftData.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.d));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData == null)
    {
      QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFail show fail mGiftData = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.toString());
    QLog.e("QzoneGiftManager", 1, localStringBuilder.toString());
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
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData = QzoneGiftManager.GiftData.a(paramString);
    if (a())
    {
      h();
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData;
    if (paramString != null)
    {
      QzoneGiftUtil.a(this, paramString.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.b, this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.c);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "preloadGiftData error with data = null");
  }
  
  public void c()
  {
    QLog.i("QzoneGiftManager", 1, "onLoading");
  }
  
  public void onDestroy()
  {
    d();
    a(8);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      d();
      a(8);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftManager
 * JD-Core Version:    0.7.0.1
 */
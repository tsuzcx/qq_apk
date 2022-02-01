package com.tencent.mobileqq.qzonevip.gift;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
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
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleDropView;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleExplodeView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vip.diy.common.DIYLottieLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.qzone.zipanimate.ZipAnimationDrawable;
import java.lang.ref.WeakReference;
import mqq.manager.Manager;

public class QzoneGiftManager
  implements View.OnTouchListener, QzoneGiftUtil.GiftLoadListener, Manager
{
  public static final float a;
  private static QzoneGiftManager jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager = null;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private Downloader jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private QzoneGiftManager.GiftData jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData;
  private QzoneGiftManager.UIHandler jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler = new QzoneGiftManager.UIHandler(this, Looper.getMainLooper());
  private ParticleDropView jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView;
  private ParticleExplodeView jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView;
  private DIYLottieLoader jdField_a_of_type_ComTencentMobileqqVipDiyCommonDIYLottieLoader;
  private ZipAnimationDrawable jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable;
  private WeakReference<FrameLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ZipAnimationDrawable jdField_b_of_type_CooperationQzoneZipanimateZipAnimationDrawable;
  private ImageView c;
  
  static
  {
    jdField_a_of_type_Float = ViewUtils.a() / 720.0F;
  }
  
  public static QzoneGiftManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager == null) {
        jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager = new QzoneGiftManager();
      }
      return jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager;
    }
    finally {}
  }
  
  private ZipAnimationDrawable a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QzoneGiftManager", 1, "createAnimationDrawable mZipPath = null");
      return null;
    }
    ZipAnimationDrawable localZipAnimationDrawable = new ZipAnimationDrawable();
    String str = QzoneGiftUtil.a(paramString);
    if (QLog.isDevelopLevel()) {
      QLog.i("QzoneGiftManager", 4, "createAnimationDrawable mZipPath = " + paramString + " resUrl = " + str);
    }
    localZipAnimationDrawable.setAnimationRes(str, paramInt);
    localZipAnimationDrawable.setScale(jdField_a_of_type_Float);
    localZipAnimationDrawable.clearFirstFrame();
    return localZipAnimationDrawable;
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler.hasMessages(paramInt1)) {
      this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler.removeMessages(paramInt1);
    }
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler.sendEmptyMessageDelayed(paramInt1, paramInt2);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler == null) {}
    for (;;)
    {
      return;
      int i = 1;
      while (i < 9)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler.hasMessages(i)) {
          this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler.removeMessages(i);
        }
        i += 1;
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader == null) || (!a()))
    {
      QLog.e("QzoneGiftManager", 1, "preloadLottieZip error");
      return;
    }
    String str = QzoneZipCacheHelper.getBasePath("aio_lottie_gift", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.d.hashCode())) + ".zip";
    if (QLog.isColorLevel()) {
      QLog.i("QzoneGiftManager", 2, " preloadLottieZip local path = " + str + " zipUrl = " + this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.d);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader.download(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.d, str, new QzoneGiftManager.1(this));
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
    String str = QzoneZipCacheHelper.getBasePath("aio_lottie_gift", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.d.hashCode())) + ".zip";
    this.jdField_a_of_type_ComTencentMobileqqVipDiyCommonDIYLottieLoader.fromNetworkWithCacheBitmap(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.d, str, true);
    a(1);
  }
  
  private void i()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_INIT_CONTENT_VIEW");
    FrameLayout localFrameLayout;
    if (BaseActivity.sTopActivity != null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((FrameLayout)BaseActivity.sTopActivity.findViewById(16908290));
      localFrameLayout = (FrameLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localFrameLayout == null) {
        QLog.e("QzoneGiftManager", 1, "mParentLayout = null");
      }
    }
    else
    {
      QLog.e("QzoneGiftManager", 1, "activity = null");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(this);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, localLayoutParams);
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$UIHandler.sendEmptyMessage(7);
      return;
    }
    a(2);
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_CooperationQzoneZipanimateZipAnimationDrawable);
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
    if (this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable != null)
    {
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.start();
      a(5, this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.getDuration() - 330);
      a(4, this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.getDuration() - 300);
    }
    if (this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable == null) {
      a(4, 0);
    }
  }
  
  private void l()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_ANIMATION_START");
    n();
    if (this.jdField_b_of_type_CooperationQzoneZipanimateZipAnimationDrawable != null) {
      this.jdField_b_of_type_CooperationQzoneZipanimateZipAnimationDrawable.start();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView != null) {
      this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleDropView.b();
    }
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "scaleX", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "scaleY", new float[] { 0.0F, 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator3.setInterpolator(new DecelerateInterpolator());
    localAnimatorSet.setDuration(400L);
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    localAnimatorSet.start();
    if (this.jdField_b_of_type_CooperationQzoneZipanimateZipAnimationDrawable != null) {
      a(6, this.jdField_b_of_type_CooperationQzoneZipanimateZipAnimationDrawable.getDuration() + 2000);
    }
  }
  
  private void m()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_GIFT_PARTICLE_EXPLODE");
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView != null) {
      this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleExplodeView.b();
    }
  }
  
  private void n()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_SHADER_SHOW");
    if (this.c != null)
    {
      this.c.setBackgroundColor(Color.parseColor("#000000"));
      this.c.setAlpha(0);
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.c, "alpha", new float[] { 0.0F, 0.5F });
      localObjectAnimator.setDuration(300L);
      localObjectAnimator.start();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, localLayoutParams);
  }
  
  private void q()
  {
    QLog.i("QzoneGiftManager", 1, "MSG_RECYCLE_VIEW");
    if (this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable != null) {
      this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable.release();
    }
    if (this.jdField_b_of_type_CooperationQzoneZipanimateZipAnimationDrawable != null) {
      this.jdField_b_of_type_CooperationQzoneZipanimateZipAnimationDrawable.release();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipDiyCommonDIYLottieLoader != null) {
      this.jdField_a_of_type_ComTencentMobileqqVipDiyCommonDIYLottieLoader.destroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAllAnimatorListener();
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    FrameLayout localFrameLayout;
    do
    {
      return;
      localFrameLayout = (FrameLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localFrameLayout == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null));
    localFrameLayout.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.b)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.c)))
    {
      QLog.e("QzoneGiftManager", 1, "onSuccess show fail : data = null ");
      return;
    }
    this.jdField_a_of_type_CooperationQzoneZipanimateZipAnimationDrawable = a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.jdField_a_of_type_JavaLangString, 10);
    this.jdField_b_of_type_CooperationQzoneZipanimateZipAnimationDrawable = a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.b, 10);
    if (this.jdField_b_of_type_CooperationQzoneZipanimateZipAnimationDrawable != null)
    {
      this.jdField_b_of_type_CooperationQzoneZipanimateZipAnimationDrawable.setShowLastFrameWhenStop(true);
      this.jdField_b_of_type_CooperationQzoneZipanimateZipAnimationDrawable.setRepeatAnimation(false);
    }
    String str = QzoneGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.c, "qzone_aio_gift");
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QzoneGiftManager", 4, "show Gift giftLocalPath = " + str);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeFile(str);
    }
    a(1);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneGiftManager", 2, " preload data = " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData = QzoneGiftManager.GiftData.a(paramString);
    if (a())
    {
      e();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData != null)
    {
      QzoneGiftUtil.a(null, this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.b, this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.c);
      return;
    }
    QLog.e("QzoneGiftManager", 1, "preloadGiftData error with data = null");
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData != null) && (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.d));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData == null)
    {
      QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = null");
      return;
    }
    QLog.e("QzoneGiftManager", 1, "onFail show fail mGiftData = " + this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.toString());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneGiftManager", 2, " startPlay data = " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData = QzoneGiftManager.GiftData.a(paramString);
    if (a())
    {
      h();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData != null)
    {
      QzoneGiftUtil.a(this, this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.b, this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftQzoneGiftManager$GiftData.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftManager
 * JD-Core Version:    0.7.0.1
 */
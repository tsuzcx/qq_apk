package dov.com.qq.im.ptv;

import alud;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;
import axso;
import bczz;
import bmfh;
import bmgb;
import bmgc;
import bmgd;
import bmge;
import bmgf;
import bmgg;
import bmgh;
import bmgi;
import bmgj;
import bmgk;
import bmgl;
import bmgo;
import bmgp;
import bmgq;
import bnsm;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class LightWeightCaptureButtonLayout
  extends RelativeLayout
  implements axso
{
  protected float a;
  protected int a;
  protected long a;
  protected Handler a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bmgb(this);
  public bmgo a;
  protected bmgp a;
  protected bmgq a;
  protected SimpleEffectsCaptureView a;
  public BaseButton a;
  private LWMotionEvent jdField_a_of_type_DovComQqImPtvLWMotionEvent = new LWMotionEvent();
  private LightWeightCaptureButtonLayout.StartRunnable jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$StartRunnable = new LightWeightCaptureButtonLayout.StartRunnable(this, null);
  public LightWeightProgress a;
  protected ArrayList<Animator> a;
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  protected AtomicBoolean a;
  protected boolean a;
  protected float b;
  protected final int b;
  public BaseButton b;
  protected AtomicBoolean b;
  protected boolean b;
  protected float c;
  protected final int c;
  public BaseButton c;
  protected boolean c;
  protected float d;
  public int d;
  protected boolean d;
  protected boolean e;
  public boolean f;
  private boolean g = true;
  private boolean h;
  private boolean i;
  
  public LightWeightCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_b_of_type_Int = 30;
    this.jdField_c_of_type_Int = 3;
    this.jdField_b_of_type_Float = bnsm.a(2.0F);
    this.jdField_c_of_type_Float = bnsm.a(5.0F);
    this.jdField_d_of_type_Float = bnsm.a(2.0F);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new bmge(this, Looper.getMainLooper());
    this.jdField_a_of_type_Bmgo = new bmgo();
    a();
  }
  
  public LightWeightCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Float = 20000.0F;
    this.jdField_b_of_type_Int = 30;
    this.jdField_c_of_type_Int = 3;
    this.jdField_b_of_type_Float = bnsm.a(2.0F);
    this.jdField_c_of_type_Float = bnsm.a(5.0F);
    this.jdField_d_of_type_Float = bnsm.a(2.0F);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new bmge(this, Looper.getMainLooper());
    this.jdField_a_of_type_Bmgo = new bmgo();
    a();
  }
  
  private AnimatorSet a(View paramView, float paramFloat1, float paramFloat2)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, paramFloat2 });
    localObjectAnimator.setDuration(100L);
    paramView = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat2, 0.0F });
    paramView.setDuration(40L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator).before(paramView);
    return localAnimatorSet;
  }
  
  @TargetApi(19)
  private void a(int paramInt)
  {
    String str = MotionEvent.actionToString(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "cocohe onTouchHook handleTouch  actionName=" + str);
    }
  }
  
  private boolean a(LWMotionEvent paramLWMotionEvent, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    if (paramBoolean) {
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$StartRunnable, 800L);
        this.jdField_e_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      a(paramLWMotionEvent);
      return true;
      o();
      continue;
      o();
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setVisibility(0);
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void p()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void q()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  abstract int a();
  
  protected AnimatorSet a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Animator paramAnimator, ArrayList<Animator> paramArrayList, long paramLong1, long paramLong2)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { paramFloat1, paramFloat2 });
    Object localObject = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { paramFloat1, paramFloat2 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator).with((Animator)localObject);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (Animator)paramArrayList.next();
        localAnimatorSet.play(localObjectAnimator).with((Animator)localObject);
      }
    }
    localAnimatorSet.setDuration(paramLong1);
    paramArrayList = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { paramFloat3, paramFloat4 });
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { paramFloat3, paramFloat4 });
    paramView = new AnimatorSet();
    paramView.play(paramArrayList).with(localObjectAnimator);
    paramView.setDuration(paramLong2);
    paramArrayList = new AnimatorSet();
    paramArrayList.play(localAnimatorSet).before(paramView);
    if (paramAnimator != null) {
      paramArrayList.play(localAnimatorSet).with(paramAnimator);
    }
    return paramArrayList;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Int = getResources().getColor(2131166204);
    LayoutInflater.from(getContext()).inflate(a(), this, true);
    this.jdField_a_of_type_DovComQqImPtvBaseButton = ((BaseButton)findViewById(2131375531));
    this.jdField_b_of_type_DovComQqImPtvBaseButton = ((BaseButton)findViewById(2131365089));
    this.jdField_c_of_type_DovComQqImPtvBaseButton = ((BaseButton)findViewById(2131369839));
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowDraw(false);
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      bczz.a(this.jdField_a_of_type_DovComQqImPtvBaseButton, true);
      bczz.a(this.jdField_a_of_type_DovComQqImPtvBaseButton, alud.a(2131706460), Button.class.getName());
      bczz.a(this.jdField_b_of_type_DovComQqImPtvBaseButton, alud.a(2131706486), Button.class.getName());
      bczz.a(this.jdField_c_of_type_DovComQqImPtvBaseButton, alud.a(2131706488), Button.class.getName());
    }
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setEnabled(true);
    this.jdField_c_of_type_DovComQqImPtvBaseButton.setShadowStrokeWidth(bnsm.a(3.0F));
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setShadowStrokeWidth(bnsm.a(3.0F));
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setShadowDraw(true);
    this.jdField_c_of_type_DovComQqImPtvBaseButton.setShadowDraw(true);
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat)
  {
    int j = 0;
    while (j < paramInt)
    {
      postDelayed(new LightWeightCaptureButtonLayout.DelayRefresh(this, j, paramArrayOfFloat[j]), j * 50);
      j += 1;
    }
  }
  
  protected void a(long paramLong)
  {
    Object localObject = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView, "surfaceAlpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView, "alpha", new float[] { 1.0F, 0.0F });
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localObjectAnimator2);
    ((AnimatorSet)localObject).setDuration(paramLong);
    ((AnimatorSet)localObject).start();
    localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvLightWeightProgress, "alpha", new float[] { 1.0F, 0.0F });
    ((ObjectAnimator)localObject).setDuration(paramLong);
    ((ObjectAnimator)localObject).start();
  }
  
  public void a(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    if (!this.jdField_a_of_type_DovComQqImPtvBaseButton.isEnabled()) {
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureLayout", 2, "handleCaptureMessage[isEnabled= false]: what: " + paramMessage.what + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramMessage.what)
            {
            case 1: 
            default: 
              return;
            case 2: 
              if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
              {
                if (this.jdField_a_of_type_Bmgp != null) {
                  this.jdField_a_of_type_Bmgp.n();
                }
                this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
                return;
              }
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("CameraCaptureLayout", 2, "handleCaptureMessage[Have Already started]: what: " + paramMessage.what + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
          return;
        } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        if (this.jdField_a_of_type_Bmgp != null) {
          this.jdField_a_of_type_Bmgp.o();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
      } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      if (this.jdField_a_of_type_Bmgp != null) {
        this.jdField_a_of_type_Bmgp.q();
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      b();
      return;
    } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    e();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 50L);
    return;
    d();
  }
  
  public void a(bmgp parambmgp, SimpleEffectsCaptureView paramSimpleEffectsCaptureView, LightWeightProgress paramLightWeightProgress)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView = paramSimpleEffectsCaptureView;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setAudioVolumeListener(this);
    this.jdField_a_of_type_Bmgp = parambmgp;
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress = paramLightWeightProgress;
  }
  
  protected void a(LWMotionEvent paramLWMotionEvent)
  {
    this.jdField_a_of_type_Bmgo.jdField_a_of_type_Float = paramLWMotionEvent.a();
    this.jdField_a_of_type_Bmgo.jdField_b_of_type_Float = paramLWMotionEvent.b();
    this.jdField_a_of_type_Bmgo.jdField_c_of_type_Float = paramLWMotionEvent.a();
    this.jdField_a_of_type_Bmgo.jdField_d_of_type_Float = paramLWMotionEvent.b();
    this.jdField_a_of_type_Bmgo.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bmgo.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Bmgo.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Bmgo.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_Bmgo.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Bmgo.jdField_e_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "handleTouch[Adsorption] startX=" + this.jdField_a_of_type_Bmgo.jdField_a_of_type_Float + " startY=" + this.jdField_a_of_type_Bmgo.jdField_b_of_type_Float + " lastX=" + this.jdField_a_of_type_Bmgo.jdField_c_of_type_Float + " lastY=" + this.jdField_a_of_type_Bmgo.jdField_d_of_type_Float);
    }
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowDraw(true);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_DovComQqImPtvLWMotionEvent.a(paramMotionEvent);
    return a(paramView, this.jdField_a_of_type_DovComQqImPtvLWMotionEvent);
  }
  
  protected boolean a(View paramView, LWMotionEvent paramLWMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "touch action:" + paramLWMotionEvent.a() + ", shortVideoShot:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", actionUp:" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", isOver:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {}
    while (!this.g) {
      return false;
    }
    switch (paramLWMotionEvent.a() & 0xFF)
    {
    default: 
      return false;
    case 0: 
      return a(paramLWMotionEvent, false);
    case 1: 
    case 3: 
      a(paramLWMotionEvent);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "touch action: mHaveIPCEvent: " + this.i + " isStarting: " + this.jdField_c_of_type_Boolean);
    }
    if ((this.i) && (!this.jdField_c_of_type_Boolean))
    {
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_e_of_type_Boolean))
      {
        b(paramLWMotionEvent);
        return false;
      }
      return a(paramLWMotionEvent, true);
    }
    b(paramLWMotionEvent);
    return false;
  }
  
  protected boolean a(LWMotionEvent paramLWMotionEvent)
  {
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setShadowDraw(false);
    this.jdField_a_of_type_Bmgo.jdField_d_of_type_Boolean = true;
    if (!this.jdField_a_of_type_Bmgo.jdField_a_of_type_Boolean)
    {
      h();
      return true;
    }
    switch (this.jdField_a_of_type_Bmgo.jdField_d_of_type_Int)
    {
    default: 
      return false;
    case 0: 
      h();
      return true;
    }
    h();
    return true;
  }
  
  public int b()
  {
    return Math.abs(this.jdField_b_of_type_DovComQqImPtvBaseButton.getLeft() + this.jdField_b_of_type_DovComQqImPtvBaseButton.getWidth() / 2 - (this.jdField_a_of_type_DovComQqImPtvBaseButton.getLeft() + this.jdField_a_of_type_DovComQqImPtvBaseButton.getWidth() / 2));
  }
  
  protected void b()
  {
    boolean bool2 = true;
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setStatus(false);
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setCurrentProgress(0.0F);
    Animation localAnimation = this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.getAnimation();
    if (localAnimation != null) {}
    for (boolean bool1 = localAnimation.hasEnded();; bool1 = true)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("cancelResetViewState endAnim:").append(bool1).append(", anim !=null:");
        if (localAnimation == null) {
          break label115;
        }
      }
      label115:
      for (bool1 = bool2;; bool1 = false)
      {
        QLog.i("CameraCaptureLayout", 2, bool1);
        this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.clearAnimation();
        this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setVisibility(8);
        return;
      }
    }
  }
  
  protected void b(LWMotionEvent paramLWMotionEvent)
  {
    float f1 = paramLWMotionEvent.a();
    float f2 = paramLWMotionEvent.b();
    this.jdField_a_of_type_Bmgo.jdField_e_of_type_Float = (f1 - this.jdField_a_of_type_Bmgo.jdField_c_of_type_Float);
    this.jdField_a_of_type_Bmgo.f = (f2 - this.jdField_a_of_type_Bmgo.jdField_d_of_type_Float);
    c();
    if (this.jdField_a_of_type_Bmgo.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bmgo.jdField_c_of_type_Float = f1;
      this.jdField_a_of_type_Bmgo.jdField_d_of_type_Float = f2;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, "handleTouch[Adsorption] xDiff=" + this.jdField_a_of_type_Bmgo.jdField_e_of_type_Float + " currentX=" + f1 + " yDiff=" + this.jdField_a_of_type_Bmgo.f + " currentY=" + f2);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_DovComQqImPtvBaseButton.isEnabled();
  }
  
  public int c()
  {
    int j = this.jdField_c_of_type_DovComQqImPtvBaseButton.getLeft();
    int k = this.jdField_c_of_type_DovComQqImPtvBaseButton.getWidth() / 2;
    return Math.abs(this.jdField_a_of_type_DovComQqImPtvBaseButton.getLeft() + this.jdField_a_of_type_DovComQqImPtvBaseButton.getWidth() / 2 - (j + k));
  }
  
  abstract void c();
  
  public void c(LWMotionEvent paramLWMotionEvent)
  {
    int j;
    if (a())
    {
      j = paramLWMotionEvent.a();
      if (((j != 3) && (j != 1)) || (this.i)) {
        break label117;
      }
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureLayout", 2, "onTouchHook [mHaveIPCEvent:false]  action=" + j + " isStarting:" + this.jdField_c_of_type_Boolean);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$StartRunnable);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      if (this.jdField_a_of_type_Bmgq != null) {
        this.jdField_a_of_type_Bmgq.l();
      }
    }
    label117:
    do
    {
      return;
      if (((!this.i) || (paramLWMotionEvent.jdField_b_of_type_Int != 1)) || (!this.i))
      {
        this.i = true;
        if (QLog.isColorLevel()) {
          QLog.i("CameraCaptureLayout", 2, "onTouchHook [move-down event]  action=" + j + " isStarting:" + this.jdField_c_of_type_Boolean);
        }
      }
      a(this.jdField_a_of_type_DovComQqImPtvBaseButton, paramLWMotionEvent);
      if ((j == 3) || (j == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraCaptureLayout", 2, "onTouchHook[ACTION_UP-CANCEL]  action=" + j + " mHaveIPCEvent:" + this.i);
        }
        this.i = false;
      }
    } while (Build.VERSION.SDK_INT < 19);
    a(j);
  }
  
  public int d()
  {
    int j = this.jdField_b_of_type_DovComQqImPtvBaseButton.getTop();
    int k = this.jdField_b_of_type_DovComQqImPtvBaseButton.getHeight() / 2;
    return Math.abs(this.jdField_a_of_type_DovComQqImPtvBaseButton.getTop() + this.jdField_a_of_type_DovComQqImPtvBaseButton.getHeight() / 2 - (j + k));
  }
  
  public void d() {}
  
  protected void e()
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    boolean bool;
    if ((float)l >= this.jdField_a_of_type_Float)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label147;
      }
    }
    label147:
    for (int j = 10000;; j = (int)((float)l / this.jdField_a_of_type_Float * 10000.0F))
    {
      String str = (int)l / 1000 + alud.a(2131706490);
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureLayout", 2, "updateProgress percent:" + j + ", time:" + str);
      }
      if (this.jdField_a_of_type_Bmgp != null) {
        this.jdField_a_of_type_Bmgp.c(j);
      }
      if (this.jdField_a_of_type_Boolean) {
        h();
      }
      return;
      bool = false;
      break;
    }
  }
  
  public void f()
  {
    this.jdField_b_of_type_Boolean = false;
    d();
  }
  
  public void g()
  {
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureLayout", 2, "onPause isStarting=" + this.jdField_c_of_type_Boolean);
    }
    j();
  }
  
  public void h()
  {
    long l = 0L;
    if (this.jdField_c_of_type_Boolean) {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    if (l < 1000L)
    {
      if (this.jdField_a_of_type_Bmgq != null) {
        this.jdField_a_of_type_Bmgq.i();
      }
      j();
      return;
    }
    i();
  }
  
  protected void i()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      p();
      return;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$StartRunnable);
      p();
      if (this.jdField_a_of_type_Bmgq != null) {
        this.jdField_a_of_type_Bmgq.l();
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void j()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      q();
      return;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_DovComQqImPtvLightWeightCaptureButtonLayout$StartRunnable);
      q();
      if (this.jdField_a_of_type_Bmgq != null) {
        this.jdField_a_of_type_Bmgq.l();
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  protected void k()
  {
    this.jdField_a_of_type_Bmgo.jdField_d_of_type_Int = 3;
    int j = getResources().getColor(2131165564);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.jdField_b_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { j });
    localObjectAnimator.setEvaluator(bmfh.a());
    int k = getResources().getColor(2131165565);
    Object localObject2 = ObjectAnimator.ofInt(this.jdField_b_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { k });
    ((ObjectAnimator)localObject2).setEvaluator(bmfh.a());
    Object localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).play(localObjectAnimator).with((Animator)localObject2);
    ((AnimatorSet)localObject1).setDuration(100L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_DovComQqImPtvBaseButton, "rotation", new float[] { 0.0F, 180.0F });
    localObjectAnimator.addListener(new bmgf(this));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(localObjectAnimator);
    a(this.jdField_b_of_type_DovComQqImPtvBaseButton, 1.0F, 1.533F, 1.533F, 1.5F, (Animator)localObject1, this.jdField_a_of_type_JavaUtilArrayList, 140L, 50L).start();
    this.jdField_b_of_type_DovComQqImPtvBaseButton.setImageResource(2130844049);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { j });
    ((ObjectAnimator)localObject1).setEvaluator(bmfh.a());
    j = getResources().getColor(2131165357);
    localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { j });
    localObjectAnimator.setEvaluator(bmfh.a());
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play((Animator)localObject1).with(localObjectAnimator);
    ((AnimatorSet)localObject2).setDuration(100L);
    localObject1 = a(this.jdField_a_of_type_DovComQqImPtvBaseButton, 1.0F, 1.022F, 1.022F, 1.0F, (Animator)localObject2, null, 140L, 50L);
    ((AnimatorSet)localObject1).addListener(new bmgg(this));
    ((AnimatorSet)localObject1).start();
    j = getResources().getColor(2131166208);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvLightWeightProgress, "deleteColor", new int[] { this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.a(), j });
    ((ObjectAnimator)localObject1).setStartDelay(90L);
    ((ObjectAnimator)localObject1).setDuration(50L);
    ((ObjectAnimator)localObject1).addListener(new bmgh(this));
    ((ObjectAnimator)localObject1).start();
  }
  
  protected void l()
  {
    int j = getResources().getColor(2131165731);
    int k = getResources().getColor(2131165732);
    int m = getResources().getColor(2131165258);
    this.jdField_a_of_type_Bmgo.jdField_d_of_type_Int = 3;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.jdField_c_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { -1, j });
    localObjectAnimator.setEvaluator(bmfh.a());
    Object localObject2 = ObjectAnimator.ofInt(this.jdField_c_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { m, k });
    ((ObjectAnimator)localObject2).setEvaluator(bmfh.a());
    Object localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).play(localObjectAnimator).with((Animator)localObject2);
    ((AnimatorSet)localObject1).setDuration(100L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_c_of_type_DovComQqImPtvBaseButton, "rotation", new float[] { 0.0F, 0.0F });
    localObjectAnimator.addListener(new bmgi(this));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(localObjectAnimator);
    a(this.jdField_c_of_type_DovComQqImPtvBaseButton, 1.0F, 1.533F, 1.533F, 1.5F, (Animator)localObject1, this.jdField_a_of_type_JavaUtilArrayList, 140L, 50L).start();
    this.jdField_c_of_type_DovComQqImPtvBaseButton.setImageResource(2130844054);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { j });
    ((ObjectAnimator)localObject1).setEvaluator(bmfh.a());
    j = getResources().getColor(2131165360);
    localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { j });
    localObjectAnimator.setEvaluator(bmfh.a());
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play((Animator)localObject1).with(localObjectAnimator);
    ((AnimatorSet)localObject2).setDuration(100L);
    localObject1 = a(this.jdField_a_of_type_DovComQqImPtvBaseButton, 1.0F, 1.022F, 1.022F, 1.0F, (Animator)localObject2, null, 140L, 50L);
    ((AnimatorSet)localObject1).addListener(new bmgj(this));
    ((AnimatorSet)localObject1).start();
  }
  
  protected void m()
  {
    int j = getResources().getColor(2131165731);
    int k = getResources().getColor(2131165732);
    int m = getResources().getColor(2131165258);
    Object localObject1 = ObjectAnimator.ofInt(this.jdField_c_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { j, -1 });
    ((ObjectAnimator)localObject1).setEvaluator(bmfh.a());
    Object localObject2 = ObjectAnimator.ofInt(this.jdField_c_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { k, m });
    ((ObjectAnimator)localObject2).setEvaluator(bmfh.a());
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_c_of_type_DovComQqImPtvBaseButton, "scaleX", new float[] { 1.5F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_c_of_type_DovComQqImPtvBaseButton, "scaleY", new float[] { 1.5F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator1).with((Animator)localObject1);
    localAnimatorSet.play(localObjectAnimator1).with((Animator)localObject2);
    localAnimatorSet.setDuration(170L);
    localObject1 = a(this.jdField_c_of_type_DovComQqImPtvBaseButton, this.jdField_c_of_type_DovComQqImPtvBaseButton.getTranslationX(), -this.jdField_b_of_type_Float);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play(localAnimatorSet).with((Animator)localObject1);
    ((AnimatorSet)localObject2).addListener(new bmgk(this));
    ((AnimatorSet)localObject2).start();
    m = getResources().getColor(2131165358);
    k = getResources().getColor(2131165359);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { j, m });
    ((ObjectAnimator)localObject1).setEvaluator(bmfh.a());
    j = getResources().getColor(2131165360);
    localObject2 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { j, k });
    ((ObjectAnimator)localObject2).setEvaluator(bmfh.a());
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "scaleX", new float[] { 1.0F, 0.7889F });
    localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImPtvBaseButton, "scaleY", new float[] { 1.0F, 0.7889F });
    localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.play(localObjectAnimator1).with((Animator)localObject1);
    localAnimatorSet.play(localObjectAnimator1).with((Animator)localObject2);
    localAnimatorSet.setDuration(100L);
    localObject1 = a(this.jdField_a_of_type_DovComQqImPtvBaseButton, this.jdField_a_of_type_DovComQqImPtvBaseButton.getTranslationX(), this.jdField_b_of_type_Float);
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play(localAnimatorSet).with((Animator)localObject1);
    ((AnimatorSet)localObject2).addListener(new bmgl(this));
    ((AnimatorSet)localObject2).start();
  }
  
  protected void n()
  {
    int j = getResources().getColor(2131165731);
    int k = getResources().getColor(2131165732);
    int m = getResources().getColor(2131165258);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.jdField_c_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { j, -1 });
    localObjectAnimator.setEvaluator(bmfh.a());
    Object localObject2 = ObjectAnimator.ofInt(this.jdField_c_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { k, m });
    ((ObjectAnimator)localObject2).setEvaluator(bmfh.a());
    Object localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).play(localObjectAnimator).with((Animator)localObject2);
    ((AnimatorSet)localObject1).setDuration(100L);
    localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_c_of_type_DovComQqImPtvBaseButton, "rotation", new float[] { 0.0F, 0.0F });
    localObject2 = ObjectAnimator.ofFloat(this.jdField_c_of_type_DovComQqImPtvBaseButton, "translationX", new float[] { this.jdField_c_of_type_DovComQqImPtvBaseButton.getTranslationX(), 0.0F });
    localObjectAnimator.addListener(new bmgc(this));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(localObjectAnimator);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
    a(this.jdField_c_of_type_DovComQqImPtvBaseButton, 1.5F, 1.533F, 1.533F, 1.0F, (Animator)localObject1, this.jdField_a_of_type_JavaUtilArrayList, 140L, 50L).start();
    this.jdField_c_of_type_DovComQqImPtvBaseButton.setImageResource(2130844066);
    m = getResources().getColor(2131165354);
    k = getResources().getColor(2131165361);
    localObject1 = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "backgroundColor", new int[] { j, m });
    ((ObjectAnimator)localObject1).setEvaluator(bmfh.a());
    j = getResources().getColor(2131165360);
    localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_DovComQqImPtvBaseButton, "shadowColor", new int[] { j, k });
    localObjectAnimator.setEvaluator(bmfh.a());
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play((Animator)localObject1).with(localObjectAnimator);
    ((AnimatorSet)localObject2).setDuration(100L);
    localObject1 = a(this.jdField_a_of_type_DovComQqImPtvBaseButton, 1.0F, 1.022F, 1.022F, 1.0F, (Animator)localObject2, null, 140L, 50L);
    ((AnimatorSet)localObject1).addListener(new bmgd(this));
    ((AnimatorSet)localObject1).start();
  }
  
  public void setCaptureEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImPtvBaseButton.setEnabled(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.g == paramBoolean) {
      return;
    }
    this.g = paramBoolean;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void setUIButtonListener(bmgq parambmgq)
  {
    this.jdField_a_of_type_Bmgq = parambmgq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */
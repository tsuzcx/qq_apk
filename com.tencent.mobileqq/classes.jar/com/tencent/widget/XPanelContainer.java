package com.tencent.widget;

import aepi;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import anxw;
import apvq;
import bdnm;
import bdqd;
import bhrx;
import bhtb;
import bics;
import bict;
import bicu;
import bicv;
import bicw;
import bicx;
import bicy;
import bicz;
import bida;
import bidj;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanel;
import com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;

public class XPanelContainer
  extends FrameLayout
  implements Runnable
{
  public static int a;
  public static int b;
  public static boolean b;
  public static int c;
  public static volatile int d;
  private static boolean d;
  private long jdField_a_of_type_Long = -1L;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
  private View jdField_a_of_type_AndroidViewView;
  public bicw a;
  private bicy jdField_a_of_type_Bicy;
  private bicz jdField_a_of_type_Bicz;
  public WeakReference<bicx> a;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private View b;
  public boolean c;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int = -1;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int = -1;
  private boolean jdField_k_of_type_Boolean;
  private int l;
  private int m = 0;
  private int n;
  
  static
  {
    jdField_d_of_type_Boolean = bhtb.e();
  }
  
  public XPanelContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  @TargetApi(11)
  public XPanelContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    if (jdField_a_of_type_Int == 0)
    {
      jdField_a_of_type_Int = (int)(b() * paramContext.getResources().getDisplayMetrics().density);
      jdField_b_of_type_Int = jdField_a_of_type_Int;
      if (!bidj.a(paramContext)) {
        break label309;
      }
      i1 = bidj.a(paramContext);
    }
    label309:
    for (jdField_c_of_type_Int = (int)((paramContext.getResources().getDisplayMetrics().heightPixels + i1) * 0.4D);; jdField_c_of_type_Int = (int)(paramContext.getResources().getDisplayMetrics().heightPixels * 0.4D))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, " mMAXExternalPanelheight = " + jdField_c_of_type_Int + "mExternalPanelheight=" + jdField_a_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, " mDefaultExternalPanelheight = " + jdField_b_of_type_Int + "mMAXExternalPanelheight=" + jdField_c_of_type_Int + "density=" + paramContext.getResources().getDisplayMetrics().density + "mNavigationBarHeight=" + i1);
      }
      this.l = ImmersiveUtils.getStatusBarHeight(getContext());
      if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT < 24) && (!bdqd.a())) {
        setOnSystemUiVisibilityChangeListener(new bics(this));
      }
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (bicx localbicx = null;; localbicx = (bicx)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      if (localbicx != null) {
        localbicx.b(paramInt1, paramInt2);
      }
      return;
    }
  }
  
  private void a(int paramInt, View paramView)
  {
    if ((paramView != null) && (paramInt == 10)) {}
    try
    {
      paramView = (HongBaoPanel)paramView;
      paramView.doRedManagerShowReport();
      paramView.tryGetFailedImage();
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bicz != null) {
      this.jdField_a_of_type_Bicz.a(paramBoolean);
    }
  }
  
  public static int b()
  {
    return 196;
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XPanelContainer", 2, "setStatus status=" + paramInt + " mStatus=" + this.jdField_f_of_type_Int + " mSoftInputChange=" + this.jdField_k_of_type_Boolean + " mSoftInputShowing=" + this.jdField_j_of_type_Boolean);
    }
    if (paramInt != this.jdField_f_of_type_Int)
    {
      int i1 = this.jdField_f_of_type_Int;
      this.jdField_f_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Bicy != null) {
        this.jdField_a_of_type_Bicy.a(i1, this.jdField_f_of_type_Int);
      }
      URLDrawable.resume();
      ApngImage.playByTag(0);
      if ((this.jdField_b_of_type_AndroidViewView != null) && (paramInt <= 1) && ((!(this.jdField_b_of_type_AndroidViewView instanceof VoiceTextEditPanel)) || (paramInt != 1)))
      {
        if ((!this.jdField_k_of_type_Boolean) || (this.jdField_j_of_type_Boolean)) {
          break label171;
        }
        if ((this.jdField_b_of_type_AndroidViewView instanceof VoiceTextEditPanel)) {
          this.jdField_f_of_type_Int = 36;
        }
      }
    }
    return;
    label171:
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView = null;
      postDelayed(this, 1L);
      return;
    }
    this.jdField_b_of_type_AndroidViewView = null;
  }
  
  private int c()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof bida))) {
      return ((bida)this.jdField_b_of_type_AndroidViewView).a();
    }
    return jdField_b_of_type_Int;
  }
  
  @TargetApi(11)
  private void f()
  {
    if ((jdField_d_of_type_Boolean) && (this.jdField_g_of_type_Boolean))
    {
      if (this.jdField_e_of_type_Boolean) {
        if (this.n >= jdField_a_of_type_Int)
        {
          this.n = 0;
          this.jdField_e_of_type_Boolean = false;
        }
      }
      while ((!this.jdField_f_of_type_Boolean) || (this.n > 0)) {
        return;
      }
      this.n = 0;
      this.jdField_f_of_type_Boolean = false;
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() >= this.jdField_a_of_type_Long + 0L)
    {
      this.n = 0;
      return;
    }
    float f1 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long) / 0.0F;
    this.n = ((int)(jdField_a_of_type_Int - bhrx.a(f1) * jdField_a_of_type_Int));
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void a()
  {
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, true);
  }
  
  @TargetApi(11)
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.XPanelContainer", 2, " showExternalPanel panelId = " + paramInt + " mStatus = " + this.jdField_f_of_type_Int + " ready = " + this.jdField_i_of_type_Boolean);
    }
    if (!this.jdField_i_of_type_Boolean) {}
    label116:
    do
    {
      do
      {
        for (;;)
        {
          return;
          this.m = paramInt;
          a(this.jdField_f_of_type_Int, paramInt);
          Object localObject2;
          Object localObject1;
          if (jdField_b_of_type_Boolean)
          {
            if (paramInt == 1) {
              if (this.jdField_a_of_type_AndroidViewView.requestFocusFromTouch())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.aio.XPanelContainer", 2, " requestFocusFromTouch success ");
                }
                aepi.a(this.jdField_a_of_type_AndroidViewView);
                if (this.jdField_b_of_type_AndroidViewView != null) {
                  this.jdField_b_of_type_AndroidViewView.setVisibility(8);
                }
              }
            }
            for (;;)
            {
              for (;;)
              {
                requestLayout();
                return;
                if (!QLog.isColorLevel()) {
                  break label116;
                }
                QLog.e("Q.aio.XPanelContainer", 2, " requestFocusFromTouch fail ");
                break label116;
                if (paramInt > 1)
                {
                  a();
                  if (this.jdField_f_of_type_Int == 1) {
                    this.jdField_f_of_type_Int = 0;
                  }
                  localObject2 = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
                  localObject1 = localObject2;
                  if (localObject2 != null)
                  {
                    localObject1 = localObject2;
                    if (this.jdField_a_of_type_Bicy.a(paramInt))
                    {
                      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
                      removeView((View)localObject2);
                      localObject1 = null;
                    }
                  }
                  a(paramInt, (View)localObject1);
                  localObject2 = localObject1;
                  if (localObject1 == null) {}
                  try
                  {
                    localObject2 = this.jdField_a_of_type_Bicy.a(paramInt);
                    if (localObject2 == null) {
                      break;
                    }
                    addView((View)localObject2);
                    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
                    if (localObject2 != this.jdField_b_of_type_AndroidViewView)
                    {
                      if (this.jdField_b_of_type_AndroidViewView != null) {
                        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
                      }
                      ((View)localObject2).setVisibility(0);
                      this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
                    }
                  }
                  catch (Exception localException1)
                  {
                    for (;;)
                    {
                      localObject2 = localObject1;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("XPanelContainer", 2, localException1, new Object[0]);
                        localObject2 = localObject1;
                      }
                    }
                  }
                }
              }
              a();
            }
          }
          if (paramInt == 1)
          {
            aepi.a(this.jdField_a_of_type_AndroidViewView);
            return;
          }
          if (paramInt <= 1) {
            break label928;
          }
          this.jdField_a_of_type_Boolean = false;
          if (paramInt == 3)
          {
            EmoticonMainPanel.jdField_a_of_type_Long = System.currentTimeMillis();
            bdnm.a(null, "AIO_EmoticonPanel_OpenDuration");
            localObject2 = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (this.jdField_a_of_type_Bicy.a(paramInt))
              {
                this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
                removeView((View)localObject2);
                localObject1 = null;
              }
            }
            a(paramInt, (View)localObject1);
            localObject2 = localObject1;
            if (localObject1 != null) {}
          }
          try
          {
            localObject2 = this.jdField_a_of_type_Bicy.a(paramInt);
            if (localObject2 != null)
            {
              addView((View)localObject2);
              this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
              if (localObject2 != this.jdField_b_of_type_AndroidViewView)
              {
                if (this.jdField_b_of_type_AndroidViewView != null) {
                  this.jdField_b_of_type_AndroidViewView.setVisibility(8);
                }
                ((View)localObject2).setVisibility(0);
                this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
              }
              if (this.jdField_f_of_type_Int == 0)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.d("Q.aio.XPanelContainer", 4, " showExternalPanel mAnimationPosition= " + this.n + "mExternalPanelheight=" + jdField_a_of_type_Int);
                }
                if (this.n > 0) {
                  continue;
                }
                this.jdField_g_of_type_Int = paramInt;
                URLDrawable.pause();
                ApngImage.pauseByTag(0);
                this.jdField_g_of_type_Boolean = paramBoolean;
                if ((jdField_d_of_type_Boolean) && (paramBoolean))
                {
                  this.jdField_e_of_type_Boolean = true;
                  paramInt = getHeight();
                  int i1 = jdField_a_of_type_Int;
                  localObject1 = ValueAnimator.ofInt(new int[] { paramInt, paramInt - jdField_a_of_type_Int });
                  ((ValueAnimator)localObject1).setDuration(150L);
                  ((ValueAnimator)localObject1).addUpdateListener(new bicu(this, paramInt));
                  ((ValueAnimator)localObject1).start();
                  return;
                  if (paramInt != 21) {
                    break label409;
                  }
                  bdnm.a(null, "apollo_panel_open");
                }
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localObject2 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.d("XPanelContainer", 2, localException2, new Object[0]);
                localObject2 = localObject1;
              }
            }
            this.n = jdField_a_of_type_Int;
            this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
            requestLayout();
            return;
          }
        }
        if (this.jdField_f_of_type_Int != 1) {
          break;
        }
        if ((this.n != 0) && (this.n != jdField_a_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.d("XPanelContainer", 2, new Object[] { "mAnimationPosition went wrong. mAnimationPosition = ", Integer.valueOf(this.n), " mExternalPanelheight = ", Integer.valueOf(jdField_a_of_type_Int) });
          }
          this.n = jdField_a_of_type_Int;
          this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
        }
        this.jdField_g_of_type_Int = paramInt;
        a();
      } while ((this.n != 0) || (this.jdField_j_of_type_Boolean) || (this.jdField_h_of_type_Int <= 0) || (getHeight() < this.jdField_h_of_type_Int));
      if (QLog.isColorLevel()) {
        QLog.w("XPanelContainer", 2, "soft input status error, reset");
      }
      c();
      return;
    } while (this.jdField_f_of_type_Int == paramInt);
    label409:
    b(paramInt);
    return;
    label928:
    throw new IllegalArgumentException("wrong argument..must be SOFT_INPUT,EXTERNAL_EMOTICON,EXTERNAL_INPUT");
  }
  
  public void a(View paramView)
  {
    a(paramView, true);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (paramView.getOnFocusChangeListener() == null) {
      paramView.setOnFocusChangeListener(new bict(this));
    }
    if ((paramBoolean) && (paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup)))
    {
      paramView = (ViewGroup)paramView.getParent();
      paramView.setDescendantFocusability(131072);
      paramView.setFocusableInTouchMode(true);
    }
  }
  
  @TargetApi(11)
  public boolean a()
  {
    return a(true);
  }
  
  @TargetApi(11)
  public boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, false);
  }
  
  @TargetApi(11)
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_b_of_type_AndroidViewView instanceof EmoticonMainPanel))
    {
      EmoticonMainPanel localEmoticonMainPanel = (EmoticonMainPanel)this.jdField_b_of_type_AndroidViewView;
      localEmoticonMainPanel.removeView(localEmoticonMainPanel.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_Bicy != null) {
      this.jdField_a_of_type_Bicy.s();
    }
    boolean bool;
    if (this.jdField_f_of_type_Int > 0)
    {
      bool = true;
      if (!jdField_b_of_type_Boolean) {
        break label102;
      }
      if (this.jdField_f_of_type_Int == 1)
      {
        if (!paramBoolean2) {
          break label95;
        }
        b();
      }
      label77:
      this.m = 0;
      requestLayout();
    }
    label95:
    label102:
    do
    {
      return bool;
      bool = false;
      break;
      a();
      break label77;
      if (this.jdField_f_of_type_Int == 1)
      {
        if (paramBoolean2) {
          try
          {
            b();
            return bool;
          }
          catch (Exception localException)
          {
            QLog.e("XPanelContainer", 1, localException, new Object[0]);
            return bool;
          }
        }
        a();
        return bool;
      }
    } while (this.jdField_f_of_type_Int <= 1);
    if (this.n > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, "  hideAllPanel return  mAnimationPosition = " + this.n);
      }
      return true;
    }
    this.m = 0;
    this.jdField_g_of_type_Int = 0;
    if (paramBoolean1) {}
    for (int i1 = jdField_a_of_type_Int;; i1 = 0)
    {
      this.n = i1;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      if ((!jdField_d_of_type_Boolean) || (!paramBoolean1)) {
        break;
      }
      this.jdField_f_of_type_Boolean = true;
      i1 = getHeight();
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i1 - jdField_a_of_type_Int, i1 });
      localValueAnimator.setDuration(150L);
      localValueAnimator.addUpdateListener(new bicv(this, i1));
      localValueAnimator.start();
      return bool;
    }
    requestLayout();
    return bool;
  }
  
  public void b()
  {
    anxw localanxw;
    if ((this.jdField_a_of_type_Bicy instanceof BaseChatPie))
    {
      localanxw = (anxw)((BaseChatPie)this.jdField_a_of_type_Bicy).a(50);
      if (localanxw == null) {}
    }
    for (boolean bool = localanxw.a();; bool = true)
    {
      if (bool)
      {
        a();
        if (QLog.isColorLevel()) {
          QLog.w("XPanelContainer", 2, "hideKeyboardInConsiderLeftSwipe");
        }
      }
      return;
    }
  }
  
  @TargetApi(11)
  public boolean b()
  {
    return a(true, true);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("XPanelContainer", 2, "-->finish--reset resetPosition");
    }
    this.jdField_g_of_type_Int = -1;
    b(0);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.n = 0;
    requestLayout();
  }
  
  public boolean c()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.XPanelContainer", 2, " clearAllPanel ");
    }
    if ((this.jdField_b_of_type_AndroidViewView instanceof VoiceTextEditPanel)) {
      return;
    }
    int i1 = 0;
    try
    {
      while (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i1));
        if (localView.getParent() != null) {
          removeView(localView);
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      this.jdField_b_of_type_AndroidViewView = null;
      apvq.b();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof VoiceTextEditPanel));
  }
  
  public void e()
  {
    if (jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Bicy != null) {}
      this.jdField_f_of_type_Int = 1;
      this.m = 1;
      this.jdField_g_of_type_Int = 0;
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {
          break label60;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView = null;
      }
    }
    return;
    label60:
    this.jdField_b_of_type_AndroidViewView = null;
  }
  
  @TargetApi(13)
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (bhtb.f()) {
      if ((paramConfiguration.orientation != this.jdField_i_of_type_Int) && ((this.jdField_j_of_type_Int != paramConfiguration.screenWidthDp) || (this.jdField_k_of_type_Int != paramConfiguration.screenHeightDp)))
      {
        this.jdField_i_of_type_Int = -1;
        this.jdField_k_of_type_Int = -1;
        this.jdField_k_of_type_Int = -1;
        this.jdField_h_of_type_Int = -1;
        a();
      }
    }
    while (paramConfiguration.orientation == this.jdField_i_of_type_Int) {
      return;
    }
    this.jdField_i_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    a();
  }
  
  @TargetApi(13)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.XPanelContainer", 2, "  changed = " + paramInt1 + "top=" + paramInt2 + "bottom=" + paramInt4 + " mAnimationPosition = " + this.n);
    }
    if ((getContext() instanceof SplashActivity))
    {
      i1 = ((Activity)getContext()).getWindow().getAttributes().softInputMode;
      if (i1 != 18)
      {
        QLog.e("XPanelContainer", 1, "illegal soft input mode: " + i1);
        ((Activity)getContext()).getWindow().setSoftInputMode(18);
        requestLayout();
      }
    }
    int i5 = getPaddingRight();
    int i2 = getPaddingLeft();
    int i4 = getPaddingBottom();
    int i3 = getPaddingTop();
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      if (jdField_b_of_type_Boolean)
      {
        long l1 = System.currentTimeMillis();
        if ((getContext() instanceof Activity))
        {
          bool = ((Activity)getContext()).isInMultiWindowMode();
          QLog.d("XPanelContainer", 1, "targetSdk > 24 tmpIsMultiScreen= " + bool + ",calltime = " + (System.currentTimeMillis() - l1));
          if (jdField_b_of_type_Boolean != bool)
          {
            this.jdField_h_of_type_Boolean = true;
            jdField_b_of_type_Boolean = bool;
          }
        }
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Bicw != null) {
          this.jdField_a_of_type_Bicw.l(jdField_b_of_type_Boolean);
        }
        this.jdField_c_of_type_Boolean = false;
      }
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_h_of_type_Boolean = false;
        if (this.jdField_a_of_type_Bicw != null) {
          this.jdField_a_of_type_Bicw.l(jdField_b_of_type_Boolean);
        }
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, "  multi screen change to normal ");
          }
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView = null;
        }
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        d();
        b(0);
        this.m = 0;
        this.jdField_g_of_type_Int = -1;
        jdField_b_of_type_Int = (int)(b() * getContext().getResources().getDisplayMetrics().density);
        jdField_a_of_type_Int = jdField_b_of_type_Int;
        jdField_d_of_type_Int = 0;
        paramInt1 = paramInt3 - paramInt1 - i5;
        paramInt2 = paramInt4 - paramInt2 - i4;
        try
        {
          View localView = getChildAt(0);
          localView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3, 1073741824));
          localView.layout(i2, i3, paramInt1, paramInt2);
          return;
          if ((Build.VERSION.SDK_INT >= 21) && (getSystemUiVisibility() == 0) && (((getContext() instanceof SplashActivity)) || ((getContext() instanceof ChatActivity))))
          {
            if (getParent() != null) {
              ((View)getParent()).getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
            }
            if (this.jdField_a_of_type_ArrayOfInt[1] < this.l - 5) {}
            for (bool = true; jdField_b_of_type_Boolean != bool; bool = false)
            {
              QLog.d("XPanelContainer", 1, "tmpIsMultiScreen= " + bool + ", coordinate " + this.jdField_a_of_type_ArrayOfInt[1] + ", default top " + this.l);
              this.jdField_h_of_type_Boolean = true;
              jdField_b_of_type_Boolean = bool;
              break;
            }
          }
        }
        catch (Exception localException1)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d("Q.aio.XPanelContainer", 2, "  error = " + localException1);
          return;
        }
      }
    }
    int i6 = paramInt4 - paramInt2;
    int i1 = this.jdField_f_of_type_Int;
    Object localObject;
    float f1;
    if ((this.jdField_h_of_type_Int < 0) && (paramBoolean) && (i6 > 0))
    {
      localObject = getResources().getConfiguration();
      this.jdField_i_of_type_Int = ((Configuration)localObject).orientation;
      if (bhtb.f())
      {
        this.jdField_j_of_type_Int = ((Configuration)localObject).screenWidthDp;
        this.jdField_k_of_type_Int = ((Configuration)localObject).screenHeightDp;
      }
      this.jdField_h_of_type_Int = i6;
      if (getResources().getConfiguration().orientation != 2) {
        break label1291;
      }
      f1 = 0.3F * this.jdField_h_of_type_Int;
      label796:
      int i7 = (int)f1;
      if ((this.jdField_h_of_type_Int <= i6) || (this.jdField_h_of_type_Int - i6 <= i7)) {
        break label1305;
      }
      bool = true;
      label825:
      if (bool != this.jdField_j_of_type_Boolean) {
        break label1311;
      }
      this.jdField_k_of_type_Boolean = false;
      label839:
      this.jdField_j_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " setStatus onLayout before finalStatus = ", Integer.valueOf(i1), " softInputShowing = ", Boolean.valueOf(bool), " mStatus = ", Integer.valueOf(this.jdField_f_of_type_Int), " changed = ", Boolean.valueOf(paramBoolean), " mPendingStatus = ", Integer.valueOf(this.jdField_g_of_type_Int), " mIsMultiScreen = ", Boolean.valueOf(jdField_b_of_type_Boolean), " mCoordinates[1] = ", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]), " mClickStatus = ", Integer.valueOf(this.m), "mNormalSize = ", Integer.valueOf(this.jdField_h_of_type_Int), " height = ", Integer.valueOf(i6), " dHeight = " + i7 + " mSoftInputChange=" + this.jdField_k_of_type_Boolean });
      }
      paramInt3 = paramInt3 - paramInt1 - i5;
      paramInt2 = paramInt4 - paramInt2 - i4;
      localObject = getChildAt(0);
    }
    for (;;)
    {
      try
      {
        if (!jdField_b_of_type_Boolean) {
          break label1500;
        }
        jdField_b_of_type_Int = (int)(b() * getContext().getResources().getDisplayMetrics().density);
        jdField_a_of_type_Int = c();
        jdField_d_of_type_Int = 0;
        if (this.m != 1) {
          break label1319;
        }
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3, 1073741824));
        ((View)localObject).layout(i2, i3, paramInt3, paramInt2);
        b(this.m);
        this.jdField_g_of_type_Int = 0;
        return;
      }
      catch (Exception localException2)
      {
        QLog.e("Q.aio.XPanelContainer", 1, "main.getContext: " + ((View)localObject).getContext() + " \n " + localException2.toString() + " crash happen restore init status", localException2);
        if (this.jdField_b_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        b(0);
        this.jdField_g_of_type_Int = -1;
        requestLayout();
        return;
      }
      if (i6 <= this.jdField_h_of_type_Int) {
        break;
      }
      this.jdField_h_of_type_Int = i6;
      break;
      label1291:
      f1 = 0.2F * this.jdField_h_of_type_Int;
      break label796;
      label1305:
      bool = false;
      break label825;
      label1311:
      this.jdField_k_of_type_Boolean = true;
      break label839;
      label1319:
      if (this.m == 0)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3, 1073741824));
        ((View)localObject).layout(i2, i3, paramInt3, paramInt2);
      }
      else
      {
        if ((this.jdField_b_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0))
        {
          this.m = 0;
          this.jdField_g_of_type_Int = -1;
          b(this.m);
          requestLayout();
          return;
        }
        this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_a_of_type_Int, 1073741824));
        this.jdField_b_of_type_AndroidViewView.layout(i2, paramInt2 - jdField_a_of_type_Int, paramInt3, paramInt2);
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3 - jdField_a_of_type_Int, 1073741824));
        ((View)localObject).layout(i2, i3, paramInt3, paramInt2 - jdField_a_of_type_Int);
      }
    }
    label1500:
    if (((!bool) || (this.jdField_f_of_type_Int == 1)) && (this.jdField_e_of_type_Int == 0)) {
      this.jdField_e_of_type_Int = paramInt2;
    }
    if (getResources().getConfiguration().orientation == 2)
    {
      if (jdField_d_of_type_Int != 0) {
        d();
      }
      jdField_d_of_type_Int = 0;
      jdField_b_of_type_Int = (int)(b() * getContext().getResources().getDisplayMetrics().density);
      jdField_a_of_type_Int = c();
    }
    if ((bool) && (this.jdField_f_of_type_Int != 1)) {
      if ((this.jdField_b_of_type_AndroidViewView instanceof VoiceTextEditPanel))
      {
        ((VoiceTextEditPanel)this.jdField_b_of_type_AndroidViewView).a(true);
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3 - jdField_a_of_type_Int, 1073741824));
        ((View)localObject).layout(i2, i3, paramInt3, paramInt2 - jdField_a_of_type_Int);
        ((VoiceTextEditPanel)this.jdField_b_of_type_AndroidViewView).a(i2, i3, paramInt3, paramInt2, bool);
        label1681:
        paramInt1 = this.jdField_e_of_type_Int - paramInt2;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout inputHeight ", Integer.valueOf(paramInt1), " mExternalPanelheight = ", Integer.valueOf(jdField_a_of_type_Int), " mDefaultExternalPanelheight = ", Integer.valueOf(jdField_b_of_type_Int), " mAddedHeight = ", Integer.valueOf(jdField_d_of_type_Int) });
        }
        if (getResources().getConfiguration().orientation == 1)
        {
          jdField_b_of_type_Int = (int)(b() * getContext().getResources().getDisplayMetrics().density);
          if (jdField_a_of_type_Int != paramInt1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.XPanelContainer", 2, " mExternalPanelheight=" + jdField_a_of_type_Int + " inputHeight=" + paramInt1 + " mDefaultExternalPanelheight=" + jdField_b_of_type_Int + " mMAXHExternalPanelheight=" + jdField_c_of_type_Int + " mAnimationPosition=" + this.n);
            }
            if (this.n == 0)
            {
              if (paramInt1 <= jdField_b_of_type_Int) {
                break label2180;
              }
              if (paramInt1 <= jdField_c_of_type_Int) {
                break label2173;
              }
              if (jdField_c_of_type_Int <= jdField_b_of_type_Int) {
                break label2164;
              }
              jdField_a_of_type_Int = jdField_c_of_type_Int;
              label1924:
              jdField_d_of_type_Int = jdField_a_of_type_Int - jdField_b_of_type_Int;
            }
            d();
            if (QLog.isColorLevel()) {
              QLog.d("XPanelContainer", 2, "mExternalPanelheight=" + jdField_a_of_type_Int + "mAddedHeight=" + jdField_d_of_type_Int);
            }
          }
        }
        label1983:
        if ((!paramBoolean) || (!bool)) {
          break label3361;
        }
        paramInt1 = 1;
        this.jdField_g_of_type_Int = -1;
      }
    }
    label2164:
    label2173:
    do
    {
      do
      {
        b(paramInt1);
        this.m = paramInt1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout after finalStatus = ", Integer.valueOf(paramInt1), " softInputShowing = ", Boolean.valueOf(bool), " mStatus = ", Integer.valueOf(this.jdField_f_of_type_Int), " changed = ", Boolean.valueOf(paramBoolean), " mPendingStatus = ", Integer.valueOf(this.jdField_g_of_type_Int) });
        }
        if (!(this.jdField_b_of_type_AndroidViewView instanceof VoiceTextEditPanel)) {
          break;
        }
        ((VoiceTextEditPanel)this.jdField_b_of_type_AndroidViewView).f();
        return;
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3, 1073741824));
        ((View)localObject).layout(i2, i3, paramInt3, paramInt2);
        break label1681;
        jdField_a_of_type_Int = jdField_b_of_type_Int;
        break label1924;
        jdField_a_of_type_Int = paramInt1;
        break label1924;
        jdField_a_of_type_Int = jdField_b_of_type_Int;
        break label1924;
        if ((this.jdField_g_of_type_Int > 1) && ((!bool) || (paramBoolean)))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout  =  softInputShowing " + bool + " changed = " + paramBoolean);
          }
          if ((bool) && (paramBoolean))
          {
            requestLayout();
            return;
          }
          f();
          if ((jdField_d_of_type_Boolean) && (this.jdField_g_of_type_Boolean)) {
            if (this.jdField_e_of_type_Boolean) {
              paramInt1 = this.n;
            }
          }
          while (this.jdField_b_of_type_AndroidViewView == null)
          {
            QLog.e("XPanelContainer", 1, " onLayout panel error:curPanel==nulll ,restore status NONE ");
            b(0);
            this.jdField_g_of_type_Int = -1;
            requestLayout();
            return;
            paramInt1 = jdField_a_of_type_Int;
            continue;
            if (!this.jdField_g_of_type_Boolean) {
              this.jdField_g_of_type_Boolean = true;
            }
            paramInt1 = jdField_a_of_type_Int - this.n;
          }
          if ((this.jdField_b_of_type_AndroidViewView instanceof VoiceTextEditPanel)) {
            ((VoiceTextEditPanel)this.jdField_b_of_type_AndroidViewView).a(i2, paramInt2 - paramInt1, paramInt3, paramInt2 - paramInt1 + jdField_a_of_type_Int, bool);
          }
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout calcposition d= " + paramInt1 + "mAnimationPosition = " + this.n + "isOpenAnim=" + this.jdField_e_of_type_Boolean + "mExternalPanelheight=" + jdField_a_of_type_Int);
            }
            ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3 - paramInt1, 1073741824));
            ((View)localObject).layout(i2, i3, paramInt3, paramInt2 - paramInt1);
            if ((this.jdField_e_of_type_Boolean) || ((this.n != 0) && (this.jdField_g_of_type_Int <= 1))) {
              break label2636;
            }
            b(this.jdField_g_of_type_Int);
            this.jdField_g_of_type_Int = -1;
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout,end ，not canvas =  isOpenAnim " + this.jdField_e_of_type_Boolean + " mAnimationPosition = " + this.n);
            return;
            this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_a_of_type_Int, 1073741824));
            this.jdField_b_of_type_AndroidViewView.layout(i2, paramInt2 - paramInt1, paramInt3, paramInt2 - paramInt1 + jdField_a_of_type_Int);
          }
          if (jdField_d_of_type_Boolean) {
            break;
          }
          postDelayed(this, 1L);
          return;
        }
        if ((this.jdField_g_of_type_Int == 0) && (this.jdField_f_of_type_Int > 1))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout reget =  mAnimationPosition = " + this.n);
          }
          f();
          if (this.jdField_b_of_type_AndroidViewView == null)
          {
            QLog.e("XPanelContainer", 1, " onLayout panel error:curPanel==nulll ,restore status NONE ");
            b(0);
            this.jdField_g_of_type_Int = -1;
            requestLayout();
            return;
          }
          if ((this.jdField_b_of_type_AndroidViewView instanceof VoiceTextEditPanel)) {
            ((VoiceTextEditPanel)this.jdField_b_of_type_AndroidViewView).a(i2, paramInt2 - this.n, paramInt3, paramInt2 - this.n + jdField_a_of_type_Int, bool);
          }
          for (;;)
          {
            ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3 - this.n, 1073741824));
            ((View)localObject).layout(i2, i3, paramInt3, paramInt2 - this.n);
            if (this.n != 0) {
              break;
            }
            b(this.jdField_g_of_type_Int);
            this.jdField_g_of_type_Int = -1;
            return;
            this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_a_of_type_Int, 1073741824));
            this.jdField_b_of_type_AndroidViewView.layout(i2, paramInt2 - this.n, paramInt3, paramInt2 - this.n + jdField_a_of_type_Int);
          }
          if (jdField_d_of_type_Boolean) {
            break;
          }
          postDelayed(this, 1L);
          return;
        }
        if ((this.jdField_f_of_type_Int > 1) && (!bool))
        {
          if (QLog.isDevelopLevel()) {
            if (this.jdField_b_of_type_AndroidViewView != null) {
              break label3040;
            }
          }
          for (paramInt1 = 0;; paramInt1 = this.jdField_b_of_type_AndroidViewView.getVisibility())
          {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel ,confirm it mExternalPanelheight= " + jdField_a_of_type_Int + " bottom = " + paramInt2 + "  mCurPanel.getVisibility() " + paramInt1);
            if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {
              break;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.aio.XPanelContainer", 4, " onLayout panel hold on error ,restore status NONE ");
            }
            b(0);
            this.jdField_g_of_type_Int = -1;
            requestLayout();
            return;
          }
          if (QLog.isDevelopLevel())
          {
            ViewParent localViewParent = this.jdField_b_of_type_AndroidViewView.getParent();
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel ,confirm it vp.ViewParent = " + localViewParent.getClass().getName());
          }
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3 - jdField_a_of_type_Int, 1073741824));
          ((View)localObject).layout(i2, i3, paramInt3, paramInt2 - jdField_a_of_type_Int);
          if (!(this.jdField_b_of_type_AndroidViewView instanceof VoiceTextEditPanel))
          {
            this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_a_of_type_Int, 1073741824));
            this.jdField_b_of_type_AndroidViewView.layout(i2, paramInt2 - jdField_a_of_type_Int, paramInt3, paramInt2);
            break label1983;
          }
          ((VoiceTextEditPanel)this.jdField_b_of_type_AndroidViewView).a(i2, paramInt2 - jdField_a_of_type_Int, paramInt3, paramInt2, bool);
          break label1983;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.aio.XPanelContainer", 4, " onLayout use default layout = ");
        }
        if ((this.jdField_b_of_type_AndroidViewView instanceof VoiceTextEditPanel))
        {
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3 - jdField_a_of_type_Int, 1073741824));
          ((View)localObject).layout(i2, i3, paramInt3, paramInt2 - jdField_a_of_type_Int);
          ((VoiceTextEditPanel)this.jdField_b_of_type_AndroidViewView).a(i2, i3, paramInt3, paramInt2, bool);
          break label1983;
        }
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3, 1073741824));
        ((View)localObject).layout(i2, i3, paramInt3, paramInt2);
        break label1983;
        if (this.jdField_g_of_type_Int == 0) {
          break label3383;
        }
        paramInt1 = i1;
      } while (!paramBoolean);
      paramInt1 = i1;
    } while (bool);
    label2180:
    label2636:
    label3040:
    if (paramBoolean)
    {
      if (i1 == 28) {
        break label3417;
      }
      if (i1 == 35) {
        paramInt1 = i1;
      }
    }
    for (;;)
    {
      label3361:
      label3383:
      this.jdField_g_of_type_Int = -1;
      break;
      paramInt1 = 0;
      continue;
      label3417:
      paramInt1 = i1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), getDefaultSize(getSuggestedMinimumHeight(), paramInt2));
  }
  
  public void run()
  {
    requestLayout();
  }
  
  public void setIsInMultiScreen(boolean paramBoolean)
  {
    if (jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_h_of_type_Boolean = true;
      jdField_b_of_type_Boolean = paramBoolean;
    }
  }
  
  public void setOnChangeMultiScreenListener(bicw parambicw)
  {
    this.jdField_a_of_type_Bicw = parambicw;
  }
  
  public void setOnGoingToShowPanelListener(bicx parambicx)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambicx);
  }
  
  public void setOnPanelChangeListener(bicy parambicy)
  {
    this.jdField_a_of_type_Bicy = parambicy;
  }
  
  public void setReadyToShow(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XPanelContainer", 2, "setReadyToShow() called with: readyToShow = [" + paramBoolean + "]");
    }
    if (this.jdField_i_of_type_Boolean != paramBoolean)
    {
      this.jdField_i_of_type_Boolean = paramBoolean;
      a(paramBoolean);
    }
  }
  
  public void setReadyToShowChangeListener(bicz parambicz)
  {
    this.jdField_a_of_type_Bicz = parambicz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.XPanelContainer
 * JD-Core Version:    0.7.0.1
 */
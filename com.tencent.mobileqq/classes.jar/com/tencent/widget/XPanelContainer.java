package com.tencent.widget;

import ameh;
import amei;
import amej;
import amek;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
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
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.kapalaiadapter.DeviceInfoUtil2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarTintManager;
import java.lang.reflect.Field;

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
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
  private View jdField_a_of_type_AndroidViewView;
  public XPanelContainer.OnChangeMultiScreenListener a;
  private XPanelContainer.PanelCallback jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback;
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
  private int j = -1;
  private int k = -1;
  private int l;
  private int m = 0;
  private int n;
  
  static
  {
    jdField_d_of_type_Boolean = VersionUtils.e();
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
      jdField_a_of_type_Int = (int)(196.0F * paramContext.getResources().getDisplayMetrics().density);
      jdField_b_of_type_Int = jdField_a_of_type_Int;
      if (!SystemBarTintManager.a(paramContext)) {
        break label307;
      }
      i1 = SystemBarTintManager.a(paramContext);
    }
    label307:
    for (jdField_c_of_type_Int = (int)((paramContext.getResources().getDisplayMetrics().heightPixels + i1) * 0.4D);; jdField_c_of_type_Int = (int)(paramContext.getResources().getDisplayMetrics().heightPixels * 0.4D))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, " mMAXExternalPanelheight = " + jdField_c_of_type_Int + "mExternalPanelheight=" + jdField_a_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, " mDefaultExternalPanelheight = " + jdField_b_of_type_Int + "mMAXExternalPanelheight=" + jdField_c_of_type_Int + "density=" + paramContext.getResources().getDisplayMetrics().density + "mNavigationBarHeight=" + i1);
      }
      this.l = ImmersiveUtils.a(getContext());
      if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT < 24) && (!DeviceInfoUtil2.a())) {
        setOnSystemUiVisibilityChangeListener(new ameh(this));
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
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XPanelContainer", 2, "setStatus status=" + paramInt + "mStatus=" + this.jdField_f_of_type_Int);
    }
    if (paramInt != this.jdField_f_of_type_Int)
    {
      int i1 = this.jdField_f_of_type_Int;
      this.jdField_f_of_type_Int = paramInt;
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback != null) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(i1, this.jdField_f_of_type_Int);
      }
      URLDrawable.resume();
      ApngImage.playByTag(0);
      if ((this.jdField_b_of_type_AndroidViewView != null) && (paramInt <= 1))
      {
        if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {
          break label133;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView = null;
        postDelayed(this, 1L);
      }
    }
    return;
    label133:
    this.jdField_b_of_type_AndroidViewView = null;
  }
  
  @TargetApi(11)
  private void d()
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
    this.n = ((int)(jdField_a_of_type_Int - AnimateUtils.a(f1) * jdField_a_of_type_Int));
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
    if (QLog.isColorLevel()) {
      QLog.d("XPanelContainer", 2, "-->finish--reset resetPosition");
    }
    this.jdField_g_of_type_Int = -1;
    b(0);
    this.jdField_a_of_type_Boolean = true;
    this.n = 0;
    requestLayout();
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
    label157:
    label200:
    label223:
    do
    {
      for (;;)
      {
        return;
        this.m = paramInt;
        Object localObject1;
        Object localObject3;
        if (jdField_b_of_type_Boolean)
        {
          if (paramInt == 1) {
            if (this.jdField_a_of_type_AndroidViewView.requestFocusFromTouch())
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " requestFocusFromTouch success ");
              }
              if (!this.jdField_a_of_type_AndroidViewView.requestFocus()) {
                break label280;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " requestFocus success ");
              }
              if (!this.jdField_a_of_type_AndroidViewView.hasFocus()) {
                break label262;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " hasFocus true ");
              }
              localObject1 = (InputMethodManager)getContext().getSystemService("input_method");
              if (!((InputMethodManager)localObject1).showSoftInput(this.jdField_a_of_type_AndroidViewView, 0)) {
                break label298;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput success ");
              }
              if (!((InputMethodManager)localObject1).isActive()) {
                break label536;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " imm.isActive() = true");
              }
              if (this.jdField_b_of_type_AndroidViewView != null) {
                this.jdField_b_of_type_AndroidViewView.setVisibility(8);
              }
            }
          }
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                requestLayout();
                return;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("Q.aio.XPanelContainer", 2, " requestFocusFromTouch fail ");
                break;
                if (!QLog.isColorLevel()) {
                  break label157;
                }
                QLog.d("Q.aio.XPanelContainer", 2, " hasFocus false ");
                break label157;
                if (!QLog.isColorLevel()) {
                  break label157;
                }
                QLog.e("Q.aio.XPanelContainer", 2, " requestFocus fail ");
                break label157;
                if (QLog.isColorLevel()) {
                  QLog.e("Q.aio.XPanelContainer", 2, " showSoftInput fail ");
                }
                try
                {
                  Object localObject5 = localObject1.getClass();
                  Object localObject2 = ((Class)localObject5).getDeclaredField("mServedView");
                  localObject5 = ((Class)localObject5).getDeclaredField("mNextServedView");
                  ((Field)localObject2).setAccessible(true);
                  ((Field)localObject5).setAccessible(true);
                  localObject2 = ((Field)localObject2).get(localObject1);
                  localObject5 = ((Field)localObject5).get(localObject1);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput fail mNextServedObject = " + localObject5 + " mServedObject" + localObject2 + " messageInputer = " + this.jdField_a_of_type_AndroidViewView);
                  }
                  if ((localObject2 == null) || (localObject2 == this.jdField_a_of_type_AndroidViewView) || (!(localObject2 instanceof View))) {
                    break label200;
                  }
                  ((InputMethodManager)localObject1).hideSoftInputFromWindow(((View)localObject2).getWindowToken(), 0);
                  this.jdField_a_of_type_AndroidViewView.requestFocusFromTouch();
                  this.jdField_a_of_type_AndroidViewView.requestFocus();
                  if ((!((InputMethodManager)localObject1).showSoftInput(this.jdField_a_of_type_AndroidViewView, 0)) && (QLog.isColorLevel())) {
                    QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput fail ");
                  }
                  if (!QLog.isColorLevel()) {
                    break label200;
                  }
                  QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput end");
                }
                catch (Exception localException1)
                {
                  localException1.printStackTrace();
                }
              }
              break label200;
              if (!QLog.isColorLevel()) {
                break label223;
              }
              QLog.d("Q.aio.XPanelContainer", 2, " imm.isActive() = false");
              break label223;
              if (paramInt > 1)
              {
                ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
                if (this.jdField_f_of_type_Int == 1) {
                  this.jdField_f_of_type_Int = 0;
                }
                localObject3 = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
                localObject1 = localObject3;
                if (localObject3 != null)
                {
                  localObject1 = localObject3;
                  if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(paramInt))
                  {
                    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
                    removeView((View)localObject3);
                    localObject1 = null;
                  }
                }
                a(paramInt, (View)localObject1);
                localObject3 = localObject1;
                if (localObject1 == null) {}
                try
                {
                  localObject3 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(paramInt);
                  if (localObject3 == null) {
                    break;
                  }
                  addView((View)localObject3);
                  this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject3);
                  if (localObject3 != this.jdField_b_of_type_AndroidViewView)
                  {
                    if (this.jdField_b_of_type_AndroidViewView != null) {
                      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
                    }
                    ((View)localObject3).setVisibility(0);
                    this.jdField_b_of_type_AndroidViewView = ((View)localObject3);
                  }
                }
                catch (Exception localException3)
                {
                  for (;;)
                  {
                    localObject3 = localObject1;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("XPanelContainer", 2, localException3, new Object[0]);
                      localObject3 = localObject1;
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
          if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.requestFocus()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.XPanelContainer", 2, " requestFocus success ");
            }
            if (this.jdField_a_of_type_AndroidViewView.hasFocus())
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " hasFocus true ");
              }
              localObject1 = (InputMethodManager)getContext().getSystemService("input_method");
              if (!((InputMethodManager)localObject1).showSoftInput(this.jdField_a_of_type_AndroidViewView, 0)) {
                break label943;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput success ");
              }
            }
          }
          for (;;)
          {
            if (!((InputMethodManager)localObject1).isActive()) {
              break label1188;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.aio.XPanelContainer", 2, " imm.isActive() = true");
            return;
            if (!QLog.isColorLevel()) {
              break label840;
            }
            QLog.d("Q.aio.XPanelContainer", 2, " hasFocus false ");
            break label840;
            if (!QLog.isColorLevel()) {
              break label840;
            }
            QLog.e("Q.aio.XPanelContainer", 2, " requestFocus fail ");
            break label840;
            if (QLog.isColorLevel()) {
              QLog.e("Q.aio.XPanelContainer", 2, " showSoftInput fail ");
            }
            try
            {
              Object localObject6 = localObject1.getClass();
              localObject3 = ((Class)localObject6).getDeclaredField("mServedView");
              localObject6 = ((Class)localObject6).getDeclaredField("mNextServedView");
              ((Field)localObject3).setAccessible(true);
              ((Field)localObject6).setAccessible(true);
              localObject3 = ((Field)localObject3).get(localObject1);
              localObject6 = ((Field)localObject6).get(localObject1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput fail mNextServedObject = " + localObject6 + " mServedObject" + localObject3 + " messageInputer = " + this.jdField_a_of_type_AndroidViewView);
              }
              if ((localObject3 != null) && (this.jdField_a_of_type_AndroidViewView != null) && (localObject3 != this.jdField_a_of_type_AndroidViewView) && ((localObject3 instanceof View)))
              {
                ((InputMethodManager)localObject1).hideSoftInputFromWindow(((View)localObject3).getWindowToken(), 0);
                this.jdField_a_of_type_AndroidViewView.requestFocusFromTouch();
                this.jdField_a_of_type_AndroidViewView.requestFocus();
                if ((!((InputMethodManager)localObject1).showSoftInput(this.jdField_a_of_type_AndroidViewView, 0)) && (QLog.isColorLevel())) {
                  QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput fail ");
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput end");
                }
              }
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " imm.isActive() = false");
          }
        }
        else
        {
          if (paramInt <= 1) {
            break label1718;
          }
          this.jdField_a_of_type_Boolean = false;
          Object localObject4;
          if (paramInt == 3)
          {
            EmoticonMainPanel.jdField_a_of_type_Long = System.currentTimeMillis();
            StartupTracker.a(null, "AIO_EmoticonPanel_OpenDuration");
            localObject4 = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
            localObject1 = localObject4;
            if (localObject4 != null)
            {
              localObject1 = localObject4;
              if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(paramInt))
              {
                this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
                removeView((View)localObject4);
                localObject1 = null;
              }
            }
            a(paramInt, (View)localObject1);
            localObject4 = localObject1;
            if (localObject1 != null) {}
          }
          try
          {
            localObject4 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.a(paramInt);
            if (localObject4 != null)
            {
              addView((View)localObject4);
              this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject4);
              if (localObject4 != this.jdField_b_of_type_AndroidViewView)
              {
                if (this.jdField_b_of_type_AndroidViewView != null) {
                  this.jdField_b_of_type_AndroidViewView.setVisibility(8);
                }
                ((View)localObject4).setVisibility(0);
                this.jdField_b_of_type_AndroidViewView = ((View)localObject4);
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
                  ((ValueAnimator)localObject1).addUpdateListener(new amej(this, paramInt));
                  ((ValueAnimator)localObject1).start();
                  return;
                  if (paramInt != 21) {
                    break label1232;
                  }
                  StartupTracker.a(null, "apollo_panel_open");
                }
              }
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              localObject4 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.d("XPanelContainer", 2, localException4, new Object[0]);
                localObject4 = localObject1;
              }
            }
            this.n = jdField_a_of_type_Int;
            this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
            requestLayout();
            return;
          }
        }
      }
      if (this.jdField_f_of_type_Int == 1)
      {
        if ((this.n != 0) && (this.n != jdField_a_of_type_Int))
        {
          if (QLog.isColorLevel()) {
            QLog.d("XPanelContainer", 2, new Object[] { "mAnimationPosition went wrong. mAnimationPosition = ", Integer.valueOf(this.n), " mExternalPanelheight = ", Integer.valueOf(jdField_a_of_type_Int) });
          }
          this.n = jdField_a_of_type_Int;
          this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
        }
        this.jdField_g_of_type_Int = paramInt;
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
    } while (this.jdField_f_of_type_Int == paramInt);
    label262:
    label280:
    label298:
    label840:
    label1232:
    b(paramInt);
    label536:
    label943:
    return;
    label1188:
    label1718:
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
      paramView.setOnFocusChangeListener(new amei(this));
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
    Object localObject;
    if ((this.jdField_b_of_type_AndroidViewView instanceof EmoticonMainPanel))
    {
      localObject = (EmoticonMainPanel)this.jdField_b_of_type_AndroidViewView;
      ((EmoticonMainPanel)localObject).removeView(((EmoticonMainPanel)localObject).jdField_b_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback.q();
    }
    boolean bool;
    if (this.jdField_f_of_type_Int > 0)
    {
      bool = true;
      if (!jdField_b_of_type_Boolean) {
        break label106;
      }
      if (this.jdField_f_of_type_Int == 1) {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
      }
      this.m = 0;
      requestLayout();
    }
    label106:
    do
    {
      return bool;
      bool = false;
      break;
      if (this.jdField_f_of_type_Int == 1)
      {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
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
    if (paramBoolean) {}
    for (int i1 = jdField_a_of_type_Int;; i1 = 0)
    {
      this.n = i1;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      if ((!jdField_d_of_type_Boolean) || (!paramBoolean)) {
        break;
      }
      this.jdField_f_of_type_Boolean = true;
      i1 = getHeight();
      localObject = ValueAnimator.ofInt(new int[] { i1 - jdField_a_of_type_Int, i1 });
      ((ValueAnimator)localObject).setDuration(150L);
      ((ValueAnimator)localObject).addUpdateListener(new amek(this, i1));
      ((ValueAnimator)localObject).start();
      return bool;
    }
    requestLayout();
    return bool;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.XPanelContainer", 2, " clearAllPanel ");
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
      EmoticonPanelViewBinder.b();
    }
  }
  
  public void c()
  {
    if (jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback != null) {}
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
    if (VersionUtils.f()) {
      if ((paramConfiguration.orientation != this.jdField_i_of_type_Int) && ((this.j != paramConfiguration.screenWidthDp) || (this.k != paramConfiguration.screenHeightDp)))
      {
        this.jdField_i_of_type_Int = -1;
        this.k = -1;
        this.k = -1;
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
    int i5 = getPaddingRight();
    int i2 = getPaddingLeft();
    int i4 = getPaddingBottom();
    int i3 = getPaddingTop();
    if (Build.VERSION.SDK_INT >= 24) {}
    boolean bool;
    for (;;)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$OnChangeMultiScreenListener != null) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer$OnChangeMultiScreenListener.j(jdField_b_of_type_Boolean);
        }
        this.jdField_c_of_type_Boolean = false;
      }
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_h_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer$OnChangeMultiScreenListener != null) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer$OnChangeMultiScreenListener.j(jdField_b_of_type_Boolean);
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
        b();
        b(0);
        this.m = 0;
        this.jdField_g_of_type_Int = -1;
        jdField_b_of_type_Int = (int)(196.0F * getContext().getResources().getDisplayMetrics().density);
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
      if (VersionUtils.f())
      {
        this.j = ((Configuration)localObject).screenWidthDp;
        this.k = ((Configuration)localObject).screenHeightDp;
      }
      this.jdField_h_of_type_Int = i6;
      if (getResources().getConfiguration().orientation != 2) {
        break label1080;
      }
      f1 = 0.3F * this.jdField_h_of_type_Int;
      label620:
      int i7 = (int)f1;
      if ((this.jdField_h_of_type_Int <= i6) || (this.jdField_h_of_type_Int - i6 <= i7)) {
        break label1094;
      }
      bool = true;
      label649:
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout before finalStatus = ", Integer.valueOf(i1), " softInputShowing = ", Boolean.valueOf(bool), " mStatus = ", Integer.valueOf(this.jdField_f_of_type_Int), " changed = ", Boolean.valueOf(paramBoolean), " mPendingStatus = ", Integer.valueOf(this.jdField_g_of_type_Int), " mIsMultiScreen = ", Boolean.valueOf(jdField_b_of_type_Boolean), " mCoordinates[1] = ", Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]), " mClickStatus = ", Integer.valueOf(this.m), "mNormalSize = ", Integer.valueOf(this.jdField_h_of_type_Int), " height = ", Integer.valueOf(i6), " dHeight = " + i7 });
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
          break label1281;
        }
        jdField_b_of_type_Int = (int)(196.0F * getContext().getResources().getDisplayMetrics().density);
        jdField_a_of_type_Int = jdField_b_of_type_Int;
        jdField_d_of_type_Int = 0;
        if (this.m != 1) {
          break label1100;
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
      label1080:
      f1 = 0.2F * this.jdField_h_of_type_Int;
      break label620;
      label1094:
      bool = false;
      break label649;
      label1100:
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
        this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_b_of_type_Int, 1073741824));
        this.jdField_b_of_type_AndroidViewView.layout(i2, paramInt2 - jdField_b_of_type_Int, paramInt3, paramInt2);
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3 - jdField_b_of_type_Int, 1073741824));
        ((View)localObject).layout(i2, i3, paramInt3, paramInt2 - jdField_b_of_type_Int);
      }
    }
    label1281:
    if (((!bool) || (this.jdField_f_of_type_Int == 1)) && (this.jdField_e_of_type_Int == 0)) {
      this.jdField_e_of_type_Int = paramInt2;
    }
    if (getResources().getConfiguration().orientation == 2)
    {
      if (jdField_d_of_type_Int != 0) {
        b();
      }
      jdField_d_of_type_Int = 0;
      jdField_b_of_type_Int = (int)(196.0F * getContext().getResources().getDisplayMetrics().density);
      jdField_a_of_type_Int = jdField_b_of_type_Int;
    }
    if ((bool) && (this.jdField_f_of_type_Int != 1))
    {
      ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3, 1073741824));
      ((View)localObject).layout(i2, i3, paramInt3, paramInt2);
      paramInt1 = this.jdField_e_of_type_Int - paramInt2;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout inputHeight ", Integer.valueOf(paramInt1), " mExternalPanelheight = ", Integer.valueOf(jdField_a_of_type_Int), " mDefaultExternalPanelheight = ", Integer.valueOf(jdField_b_of_type_Int), " mAddedHeight = ", Integer.valueOf(jdField_d_of_type_Int) });
      }
      if (getResources().getConfiguration().orientation == 1)
      {
        jdField_b_of_type_Int = (int)(196.0F * getContext().getResources().getDisplayMetrics().density);
        if (jdField_a_of_type_Int != paramInt1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " mExternalPanelheight=" + jdField_a_of_type_Int + " inputHeight=" + paramInt1 + " mDefaultExternalPanelheight=" + jdField_b_of_type_Int + " mMAXHExternalPanelheight=" + jdField_c_of_type_Int + " mAnimationPosition=" + this.n);
          }
          if (this.n == 0)
          {
            if (paramInt1 <= jdField_b_of_type_Int) {
              break label1847;
            }
            if (paramInt1 <= jdField_c_of_type_Int) {
              break label1840;
            }
            if (jdField_c_of_type_Int <= jdField_b_of_type_Int) {
              break label1831;
            }
            jdField_a_of_type_Int = jdField_c_of_type_Int;
            label1652:
            jdField_d_of_type_Int = jdField_a_of_type_Int - jdField_b_of_type_Int;
          }
          b();
          if (QLog.isColorLevel()) {
            QLog.d("XPanelContainer", 2, "mExternalPanelheight=" + jdField_a_of_type_Int + "mAddedHeight=" + jdField_d_of_type_Int);
          }
        }
      }
      label1711:
      if ((!paramBoolean) || (!bool)) {
        break label2831;
      }
      paramInt1 = 1;
      this.jdField_g_of_type_Int = -1;
    }
    label1831:
    label1840:
    label1847:
    label2623:
    do
    {
      do
      {
        b(paramInt1);
        this.m = paramInt1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.aio.XPanelContainer", 2, new Object[] { " onLayout after finalStatus = ", Integer.valueOf(paramInt1), " softInputShowing = ", Boolean.valueOf(bool), " mStatus = ", Integer.valueOf(this.jdField_f_of_type_Int), " changed = ", Boolean.valueOf(paramBoolean), " mPendingStatus = ", Integer.valueOf(this.jdField_g_of_type_Int) });
        return;
        jdField_a_of_type_Int = jdField_b_of_type_Int;
        break label1652;
        jdField_a_of_type_Int = paramInt1;
        break label1652;
        jdField_a_of_type_Int = jdField_b_of_type_Int;
        break label1652;
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
          d();
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
          this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_a_of_type_Int, 1073741824));
          this.jdField_b_of_type_AndroidViewView.layout(i2, paramInt2 - paramInt1, paramInt3, paramInt2 - paramInt1 + jdField_a_of_type_Int);
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout calcposition d= " + paramInt1 + "mAnimationPosition = " + this.n + "isOpenAnim=" + this.jdField_e_of_type_Boolean + "mExternalPanelheight=" + jdField_a_of_type_Int);
          }
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3 - paramInt1, 1073741824));
          ((View)localObject).layout(i2, i3, paramInt3, paramInt2 - paramInt1);
          if ((!this.jdField_e_of_type_Boolean) && ((this.n == 0) || (this.jdField_g_of_type_Int > 1)))
          {
            b(this.jdField_g_of_type_Int);
            this.jdField_g_of_type_Int = -1;
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.d("Q.aio.XPanelContainer", 4, " onLayout bom panel mannule layout,end ，not canvas =  isOpenAnim " + this.jdField_e_of_type_Boolean + " mAnimationPosition = " + this.n);
            return;
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
          d();
          if (this.jdField_b_of_type_AndroidViewView == null)
          {
            QLog.e("XPanelContainer", 1, " onLayout panel error:curPanel==nulll ,restore status NONE ");
            b(0);
            this.jdField_g_of_type_Int = -1;
            requestLayout();
            return;
          }
          this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_a_of_type_Int, 1073741824));
          this.jdField_b_of_type_AndroidViewView.layout(i2, paramInt2 - this.n, paramInt3, paramInt2 - this.n + jdField_a_of_type_Int);
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3 - this.n, 1073741824));
          ((View)localObject).layout(i2, i3, paramInt3, paramInt2 - this.n);
          if (this.n == 0)
          {
            b(this.jdField_g_of_type_Int);
            this.jdField_g_of_type_Int = -1;
            return;
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
              break label2623;
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
          this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(jdField_a_of_type_Int, 1073741824));
          this.jdField_b_of_type_AndroidViewView.layout(i2, paramInt2 - jdField_a_of_type_Int, paramInt3, paramInt2);
          break label1711;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.aio.XPanelContainer", 4, " onLayout use default layout = ");
        }
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - i2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2 - i3, 1073741824));
        ((View)localObject).layout(i2, i3, paramInt3, paramInt2);
        break label1711;
        if (this.jdField_g_of_type_Int == 0) {
          break label2853;
        }
        paramInt1 = i1;
      } while (!paramBoolean);
      paramInt1 = i1;
    } while (bool);
    label2831:
    label2853:
    if ((paramBoolean) && (i1 == 28)) {}
    for (paramInt1 = i1;; paramInt1 = 0)
    {
      this.jdField_g_of_type_Int = -1;
      break;
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
  
  public void setOnChangeMultiScreenListener(XPanelContainer.OnChangeMultiScreenListener paramOnChangeMultiScreenListener)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer$OnChangeMultiScreenListener = paramOnChangeMultiScreenListener;
  }
  
  public void setOnPanelChangeListener(XPanelContainer.PanelCallback paramPanelCallback)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback = paramPanelCallback;
  }
  
  public void setReadyToShow(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.widget.XPanelContainer
 * JD-Core Version:    0.7.0.1
 */
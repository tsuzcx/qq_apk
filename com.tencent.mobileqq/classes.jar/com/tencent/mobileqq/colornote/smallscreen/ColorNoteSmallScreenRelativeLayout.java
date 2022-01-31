package com.tencent.mobileqq.colornote.smallscreen;

import aciy;
import alsg;
import alsr;
import alts;
import aluj;
import aluk;
import alul;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import awqx;
import azvv;
import bajq;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import krx;
import lor;
import mqq.os.MqqHandler;

public class ColorNoteSmallScreenRelativeLayout
  extends RelativeLayout
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private static float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 3.0F, 2.0F, 2.5F, 2.0F };
  private static int[] jdField_a_of_type_ArrayOfInt = { 0, 9, 5, 3 };
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private alsg jdField_a_of_type_Alsg;
  private aluk jdField_a_of_type_Aluk;
  private alul jdField_a_of_type_Alul;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point(0, 0);
  private Display jdField_a_of_type_AndroidViewDisplay;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ColorNoteSmallScreenRelativeLayout.CheckForLongPress jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress = new ColorNoteSmallScreenRelativeLayout.CheckForLongPress(this, null);
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private Point jdField_b_of_type_AndroidGraphicsPoint = new Point();
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ValueAnimator jdField_c_of_type_AndroidAnimationValueAnimator;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  private int n = 0;
  private int o;
  private int p;
  private int q;
  
  public ColorNoteSmallScreenRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorNoteSmallScreenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorNoteSmallScreenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "SmallScreenRelativeLayout");
    }
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131165504);
    this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131165503);
    this.jdField_e_of_type_Int = this.jdField_c_of_type_Int;
    this.jdField_f_of_type_Int = ((int)(this.jdField_c_of_type_Int * 1.5D));
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131166655);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this);
    this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(100L);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(this);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(this);
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(this);
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.n = e();
    this.jdField_a_of_type_Alul = new alul(this, getContext(), 2);
    this.p = bajq.b();
    this.o = bajq.a();
    this.jdField_a_of_type_Alsg = new alsg();
    this.jdField_a_of_type_Alsg.a(getContext(), azvv.a(getContext(), 15.0F), azvv.a(getContext(), 9.5F), getContext().getResources().getColor(2131099873));
    this.m = aciy.a(8.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131310495));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299816));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131310494));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302995));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302996));
  }
  
  private float a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 9)) {
      return azvv.a(getContext(), jdField_a_of_type_ArrayOfFloat[paramInt]);
    }
    return getResources().getDimensionPixelSize(2131167605);
  }
  
  private int a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 4)) {
      return azvv.a(getContext(), jdField_a_of_type_ArrayOfInt[paramInt]);
    }
    return azvv.a(getContext(), 4.0F);
  }
  
  private SmallColorNoteItem a(ColorNote paramColorNote, ViewGroup paramViewGroup)
  {
    paramViewGroup = new SmallColorNoteItem(getContext(), a());
    paramViewGroup.setAttachLeft(a());
    View localView = paramViewGroup.a().findViewById(2131305247);
    ImageView localImageView = (ImageView)paramViewGroup.a().findViewById(2131305248);
    new alts().a(paramColorNote, localView, localImageView, a());
    return paramViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    paramInt1 = this.jdField_g_of_type_Int + paramInt1 - this.i;
    int i3 = this.h + paramInt2 - this.j;
    int i1;
    int i6;
    int i5;
    int i4;
    if (this.n % 2 == 0)
    {
      i1 = this.jdField_c_of_type_Int;
      paramInt2 = this.jdField_d_of_type_Int;
      i6 = this.o - i1;
      i5 = this.p - paramInt2;
      i4 = -this.m;
      this.q = 2;
      if (paramInt1 >= i4) {
        break label334;
      }
      this.q = 0;
      paramInt1 = i4;
    }
    label169:
    label314:
    label334:
    for (;;)
    {
      int i2;
      if (paramInt1 > aciy.a(6.0F, getResources()) + i6)
      {
        i2 = i6 + aciy.a(6.0F, getResources());
        this.q = 1;
      }
      for (;;)
      {
        if (i3 < 0) {}
        for (paramInt1 = 0;; paramInt1 = i3)
        {
          if (paramInt1 > i5) {
            paramInt1 = i5;
          }
          for (;;)
          {
            if ((i2 > i4) && (i2 < i6)) {
              if (ThemeUtil.isNowThemeIsNight(null, false, null))
              {
                setBackgroundResource(2130838975);
                if (this.jdField_a_of_type_Aluk == null) {
                  break label297;
                }
                this.jdField_a_of_type_Aluk.a(this, i2, paramInt1, i1 + i2, paramInt1 + paramInt2);
              }
            }
            for (;;)
            {
              if (this.q != 2) {
                break label314;
              }
              m();
              return;
              i1 = this.jdField_d_of_type_Int;
              paramInt2 = this.jdField_c_of_type_Int;
              break;
              setBackgroundResource(2130838978);
              break label169;
              if (i2 == i4)
              {
                if (ThemeUtil.isNowThemeIsNight(null, false, null))
                {
                  setBackgroundResource(2130838974);
                  break label169;
                }
                setBackgroundResource(2130838977);
                break label169;
              }
              if (ThemeUtil.isNowThemeIsNight(null, false, null))
              {
                setBackgroundResource(2130838976);
                break label169;
              }
              setBackgroundResource(2130838979);
              break label169;
              layout(i2, paramInt1, i2 + i1, paramInt2 + paramInt1);
            }
            n();
            return;
          }
        }
        i2 = paramInt1;
      }
    }
  }
  
  private int e()
  {
    try
    {
      int i1 = this.jdField_a_of_type_AndroidViewDisplay.getRotation();
      return i1;
    }
    catch (Exception localException)
    {
      krx.e("ColorNoteSmallScreenRelativeLayout", localException.getMessage());
    }
    return 0;
  }
  
  private void f()
  {
    if (a())
    {
      this.q = 0;
      if (this.q != 2) {
        break label33;
      }
      m();
    }
    label33:
    while (this.jdField_c_of_type_Boolean)
    {
      return;
      this.q = 1;
      break;
    }
    n();
    if (b())
    {
      if (a())
      {
        i();
        return;
      }
      j();
      return;
    }
    h();
  }
  
  private void g()
  {
    if (!a()) {}
    int i1;
    int i2;
    int i3;
    int i4;
    for (this.jdField_b_of_type_AndroidGraphicsPoint.x = (this.o - this.jdField_c_of_type_Int + this.m);; this.jdField_b_of_type_AndroidGraphicsPoint.x = (-this.m))
    {
      i1 = this.jdField_b_of_type_AndroidGraphicsPoint.x;
      i2 = i1 + this.jdField_c_of_type_Int;
      i3 = this.jdField_b_of_type_AndroidGraphicsPoint.y;
      i4 = i3 + this.jdField_d_of_type_Int;
      if (this.jdField_a_of_type_Aluk == null) {
        break;
      }
      this.jdField_a_of_type_Aluk.a(this, i1, i3, i2, i4);
      return;
    }
    layout(i1, i3, i2, i4);
  }
  
  private void h()
  {
    k();
    l();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131310495);
    this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams1.width = getResources().getDimensionPixelSize(2131167609);
    if (a())
    {
      localLayoutParams1.rightMargin = azvv.a(localLinearLayout.getContext(), 10.0F);
      localLayoutParams1.leftMargin = 0;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
    }
    for (;;)
    {
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.setVisibility(0);
      g();
      return;
      localLayoutParams1.leftMargin = azvv.a(localLinearLayout.getContext(), 10.0F);
      localLayoutParams1.rightMargin = 0;
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(9, 0);
    }
  }
  
  private void i()
  {
    k();
    l();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131310495);
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_Alsg = new alsg();
      this.jdField_a_of_type_Alsg.a(getContext(), azvv.a(getContext(), 15.0F), azvv.a(getContext(), 9.5F), getContext().getResources().getColor(2131099873));
      this.jdField_a_of_type_Alsg.a(300);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Alsg);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      localLinearLayout.setVisibility(8);
      this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
      return;
    }
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
    this.jdField_c_of_type_Int = this.jdField_f_of_type_Int;
    localLinearLayout.setVisibility(0);
    localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131167609);
    if (a())
    {
      ((LinearLayout.LayoutParams)localObject).rightMargin = azvv.a(getContext(), 13.5F);
      ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    }
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    g();
  }
  
  private void j()
  {
    k();
    l();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131310495);
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Alsg);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      this.jdField_a_of_type_Alsg.a(300);
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      localLinearLayout.setVisibility(8);
      this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
      return;
    }
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
    ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
    this.jdField_c_of_type_Int = this.jdField_f_of_type_Int;
    localLinearLayout.setVisibility(0);
    localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131167609);
    if (!a())
    {
      ((LinearLayout.LayoutParams)localObject).leftMargin = azvv.a(getContext(), 13.5F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    }
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    g();
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302995));
      this.jdField_a_of_type_Alsg = new alsg();
      this.jdField_a_of_type_Alsg.a(getContext(), azvv.a(getContext(), 15.0F), azvv.a(getContext(), 9.5F), getContext().getResources().getColor(2131099873));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Alsg);
      this.jdField_a_of_type_Alsg.a(300);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302996));
      this.jdField_a_of_type_Alsg = new alsg();
      this.jdField_a_of_type_Alsg.a(getContext(), azvv.a(getContext(), 15.0F), azvv.a(getContext(), 9.5F), getContext().getResources().getColor(2131099873));
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Alsg);
      this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams().width = azvv.a(getContext(), 15.0F);
      this.jdField_a_of_type_Alsg.a(300);
    }
  }
  
  private void l()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131310494));
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131310495));
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299816));
    }
  }
  
  private void m()
  {
    l();
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
  }
  
  private void n()
  {
    l();
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_Alsg == null)
    {
      this.jdField_a_of_type_Alsg = new alsg();
      this.jdField_a_of_type_Alsg.a(getContext(), azvv.a(getContext(), 15.0F), azvv.a(getContext(), 9.5F), getContext().getResources().getColor(2131099873));
    }
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Point a()
  {
    return this.jdField_b_of_type_AndroidGraphicsPoint;
  }
  
  public void a()
  {
    int i4 = e();
    boolean bool = lor.i();
    int i1;
    int i2;
    if (i4 == 1)
    {
      i1 = bajq.a();
      i2 = bajq.b();
      int i3 = i1;
      if (bool) {
        i3 = i1 - this.jdField_a_of_type_Int;
      }
      i1 = this.n;
      if ((this.n != i4) || (i2 != this.o) || ((i4 == 0) && (this.p < i3)) || ((i4 != 0) && (this.p != i3)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ColorNoteSmallScreenRelativeLayout", 1, "onOrientationChangedInner, mPosition[" + i1 + "], mRotation[" + this.n + "->" + i4 + "], mScreenWidth[" + this.o + "->" + i2 + "], mScreenHeight[" + this.p + "->" + i3 + "], mIsInit[" + this.jdField_e_of_type_Boolean + "]");
        }
        if ((this.jdField_e_of_type_Boolean) && (i4 != 0)) {
          this.jdField_e_of_type_Boolean = false;
        }
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
        this.n = i4;
        this.o = i2;
        this.p = i3;
        this.jdField_b_of_type_AndroidGraphicsPoint = new Point(this.o - this.jdField_c_of_type_Int + aciy.a(7.0F, getResources()), i3 / 2);
        setCurPosition(this.jdField_b_of_type_AndroidGraphicsPoint);
        if (this.jdField_a_of_type_Aluk == null) {
          break label382;
        }
        i1 = this.jdField_a_of_type_Aluk.a(this);
        this.k = i1;
        this.jdField_g_of_type_Int = i1;
        i1 = this.jdField_a_of_type_Aluk.b(this);
        this.l = i1;
        this.h = i1;
        this.jdField_a_of_type_Aluk.a(this.jdField_b_of_type_AndroidGraphicsPoint, this.n);
      }
    }
    for (;;)
    {
      if (!this.jdField_e_of_type_Boolean) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      return;
      i2 = bajq.a();
      i1 = bajq.b();
      break;
      label382:
      i1 = getLeft();
      this.k = i1;
      this.jdField_g_of_type_Int = i1;
      i1 = getTop();
      this.l = i1;
      this.h = i1;
    }
  }
  
  public void a(List<ColorNote> paramList)
  {
    int i6 = 0;
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131310495);
    if (!alsr.a(this.jdField_a_of_type_JavaUtilList, paramList)) {}
    for (int i1 = 1; (localLinearLayout == null) || (paramList.size() <= 0); i1 = 0)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      e();
      return;
    }
    int i4;
    int i2;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      i4 = 0;
      if ((this.jdField_g_of_type_Boolean) || (i1 == 0)) {
        break label323;
      }
      Iterator localIterator = paramList.iterator();
      i2 = 0;
      i1 = 0;
      label91:
      if (!localIterator.hasNext()) {
        break label170;
      }
      ColorNote localColorNote = (ColorNote)localIterator.next();
      if (localColorNote.getServiceType() != 16973824) {
        break label348;
      }
      if (!localColorNote.animate) {
        break label336;
      }
      localColorNote.animate = false;
      i1 = 1;
      i2 = 1;
    }
    for (;;)
    {
      int i3 = i2;
      i2 = i1;
      i1 = i3;
      break label91;
      i4 = this.jdField_a_of_type_JavaUtilList.size();
      break;
      label170:
      int i5 = 0;
      i3 = i6;
      if (i5 < i4)
      {
        if (((ColorNote)this.jdField_a_of_type_JavaUtilList.get(i5)).getServiceType() != 16973824) {
          break label333;
        }
        i3 = 1;
      }
      label323:
      label333:
      for (;;)
      {
        i5 += 1;
        break;
        this.jdField_a_of_type_JavaUtilList = paramList;
        if (((i1 != 0) || ((i2 == 0) && (i3 != 0))) && (Math.abs(paramList.size() - i4) == 1))
        {
          e();
          return;
        }
        this.jdField_g_of_type_Boolean = true;
        paramList = localLinearLayout.animate();
        if (a()) {}
        for (float f1 = -localLinearLayout.getMeasuredWidth();; f1 = localLinearLayout.getMeasuredWidth())
        {
          paramList.translationX(f1).setDuration(200L).setListener(new aluj(this, localLinearLayout)).start();
          return;
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
        e();
        return;
      }
      label336:
      i3 = 1;
      i2 = i1;
      i1 = i3;
      continue;
      label348:
      i3 = i1;
      i1 = i2;
      i2 = i3;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_AndroidGraphicsPoint.x <= 0;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void b()
  {
    Point localPoint;
    int i1;
    if ((this.o != 0) && (this.p != 0))
    {
      localPoint = this.jdField_b_of_type_AndroidGraphicsPoint;
      if (this.n % 2 != 0) {
        break label83;
      }
      i1 = this.jdField_c_of_type_Int;
    }
    for (int i2 = this.jdField_d_of_type_Int; (this.jdField_a_of_type_Aluk != null) && (!this.jdField_d_of_type_Boolean); i2 = this.jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_Aluk.a(this, localPoint.x, localPoint.y, i1 + localPoint.x, localPoint.y + i2);
      return;
      label83:
      i1 = this.jdField_d_of_type_Int;
    }
    layout(localPoint.x, localPoint.y, localPoint.x + i1, i2 + localPoint.y);
  }
  
  public boolean b()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public int c()
  {
    return this.o;
  }
  
  public void c()
  {
    if (!this.jdField_d_of_type_Boolean) {
      d();
    }
  }
  
  public boolean c()
  {
    return (b()) && (this.jdField_a_of_type_JavaUtilList.size() != 1);
  }
  
  public int d()
  {
    return this.p;
  }
  
  public void d()
  {
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_JavaUtilList.size() == 1) || (!b()))
    {
      this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.width = getResources().getDimensionPixelSize(2131167609);
        if (!b()) {
          break label136;
        }
        if (!a()) {
          break label114;
        }
        localLayoutParams.rightMargin = azvv.a(getContext(), 13.5F);
        localLayoutParams.leftMargin = 0;
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      g();
      return;
      this.jdField_c_of_type_Int = this.jdField_f_of_type_Int;
      break;
      label114:
      localLayoutParams.leftMargin = azvv.a(getContext(), 13.5F);
      localLayoutParams.rightMargin = 0;
      continue;
      label136:
      if (a())
      {
        localLayoutParams.rightMargin = azvv.a(getContext(), 10.0F);
        localLayoutParams.leftMargin = 0;
      }
      else
      {
        localLayoutParams.leftMargin = azvv.a(getContext(), 10.0F);
        localLayoutParams.rightMargin = 0;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    int i1 = (int)paramMotionEvent.getRawX();
    int i2 = (int)paramMotionEvent.getRawY();
    if (this.jdField_d_of_type_Boolean) {}
    do
    {
      return true;
      switch (paramMotionEvent.getAction())
      {
      default: 
        return true;
      case 0: 
        this.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
        this.i = i1;
        this.j = i2;
        if (this.jdField_a_of_type_Aluk != null) {
          this.jdField_g_of_type_Int = this.jdField_a_of_type_Aluk.a(this);
        }
        for (this.h = this.jdField_a_of_type_Aluk.b(this);; this.h = getTop())
        {
          this.jdField_b_of_type_Boolean = false;
          return true;
          this.jdField_g_of_type_Int = getLeft();
        }
      case 2: 
        if (this.jdField_b_of_type_Boolean)
        {
          a(i1, i2);
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress);
          return true;
        }
        break;
      }
    } while ((Math.abs(i1 - this.i) <= this.jdField_b_of_type_Int) && (Math.abs(i2 - this.j) <= this.jdField_b_of_type_Int));
    this.jdField_b_of_type_Boolean = true;
    return true;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress);
    boolean bool1;
    if (this.jdField_b_of_type_Boolean)
    {
      a(i1, i2);
      bool1 = bool2;
      label254:
      if (this.jdField_a_of_type_Aluk == null) {
        break label394;
      }
      this.k = this.jdField_a_of_type_Aluk.a(this);
    }
    for (this.l = this.jdField_a_of_type_Aluk.b(this); !bool1; this.l = getTop())
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return true;
      long l1 = System.currentTimeMillis();
      bool1 = bool2;
      if (this.jdField_a_of_type_Aluk == null) {
        break label254;
      }
      bool1 = bool2;
      if (this.jdField_c_of_type_Boolean) {
        break label254;
      }
      bool1 = bool2;
      if (l1 - this.jdField_a_of_type_Long <= 600L) {
        break label254;
      }
      paramMotionEvent = this.jdField_a_of_type_Aluk;
      Point localPoint = this.jdField_b_of_type_AndroidGraphicsPoint;
      bool1 = bool3;
      if (this.n == 0) {
        bool1 = true;
      }
      bool1 = paramMotionEvent.a(localPoint, bool1);
      this.jdField_a_of_type_Long = l1;
      break label254;
      label394:
      this.k = getLeft();
    }
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_b_of_type_Boolean)
    {
      a(i1, i2);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress);
    }
    if (this.jdField_a_of_type_Aluk != null) {
      this.k = this.jdField_a_of_type_Aluk.a(this);
    }
    for (this.l = this.jdField_a_of_type_Aluk.b(this);; this.l = getTop())
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return true;
      this.k = getLeft();
    }
  }
  
  public void e()
  {
    int i3 = 0;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    label105:
    do
    {
      return;
      this.jdField_f_of_type_Boolean = false;
      int i1 = 0;
      LinearLayout localLinearLayout;
      int i5;
      int i2;
      int i4;
      if (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((ColorNote)this.jdField_a_of_type_JavaUtilList.get(i1)).mServiceType == 16973824) {
          this.jdField_f_of_type_Boolean = true;
        }
      }
      else
      {
        localLinearLayout = (LinearLayout)findViewById(2131310495);
        localLinearLayout.removeAllViews();
        if (!this.jdField_f_of_type_Boolean) {
          break label195;
        }
        i1 = this.jdField_a_of_type_JavaUtilList.size() - 1;
        i5 = getResources().getDimensionPixelSize(2131167604);
        i2 = getResources().getDimensionPixelSize(2131167603);
        i4 = a(i1);
        if (i1 != 0) {
          break label208;
        }
        i2 = i5;
      }
      for (;;)
      {
        if (i3 < this.jdField_a_of_type_JavaUtilList.size())
        {
          Object localObject = (ColorNote)this.jdField_a_of_type_JavaUtilList.get(i3);
          if (((ColorNote)localObject).mServiceType == 16973824)
          {
            i3 += 1;
            continue;
            i1 += 1;
            break;
            i1 = this.jdField_a_of_type_JavaUtilList.size();
            break label105;
            i2 = (int)((i2 - i4 * 2) * 1.0F / i1 - a(i1));
            continue;
          }
          SmallColorNoteItem localSmallColorNoteItem = a((ColorNote)localObject, localLinearLayout);
          localSmallColorNoteItem.setAttachLeft(a());
          if (this.jdField_f_of_type_Boolean)
          {
            i4 = this.jdField_a_of_type_JavaUtilList.size() - 1;
            if (i4 <= 3) {
              break label387;
            }
            localSmallColorNoteItem.c();
            if (!this.jdField_f_of_type_Boolean) {
              break label415;
            }
            i4 = this.jdField_a_of_type_JavaUtilList.size() - 1;
            if (i4 <= 4) {
              break label429;
            }
            localSmallColorNoteItem.a();
          }
          for (;;)
          {
            localSmallColorNoteItem.a(i2, i5);
            localObject = new RelativeLayout.LayoutParams(-1, i2);
            ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(a(i1) / 2.0F));
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(a(i1) / 2.0F));
            localLinearLayout.addView(localSmallColorNoteItem.a(), -1, (ViewGroup.LayoutParams)localObject);
            break;
            i4 = this.jdField_a_of_type_JavaUtilList.size();
            break label270;
            localSmallColorNoteItem.d();
            localSmallColorNoteItem.setTitle(((ColorNote)localObject).mMainTitle);
            localSmallColorNoteItem.setSubTitle(((ColorNote)localObject).mSubTitle);
            break label281;
            i4 = this.jdField_a_of_type_JavaUtilList.size();
            break label301;
            localSmallColorNoteItem.b();
          }
        }
      }
      if (this.jdField_f_of_type_Boolean)
      {
        if (a())
        {
          i();
          return;
        }
        j();
        return;
      }
    } while (this.jdField_c_of_type_Boolean);
    label195:
    label208:
    h();
    label270:
    label281:
    label301:
    return;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    f();
    int i1;
    int i2;
    if (paramAnimator == this.jdField_a_of_type_AndroidAnimationValueAnimator)
    {
      paramAnimator = this.jdField_a_of_type_AndroidGraphicsPoint;
      if (this.n % 2 == 0)
      {
        i1 = this.jdField_c_of_type_Int;
        i2 = this.jdField_d_of_type_Int;
        if (!a()) {
          paramAnimator.x = (this.o - this.jdField_c_of_type_Int + this.m);
        }
        this.jdField_b_of_type_AndroidGraphicsPoint = paramAnimator;
        if (this.jdField_b_of_type_AndroidGraphicsPoint.x > 0) {
          break label232;
        }
        if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
          break label222;
        }
        setBackgroundResource(2130838974);
        label92:
        if (this.jdField_a_of_type_Aluk == null) {
          break label261;
        }
        this.jdField_a_of_type_Aluk.a(this, paramAnimator.x, paramAnimator.y, i1 + paramAnimator.x, paramAnimator.y + i2);
        this.jdField_a_of_type_Aluk.a(this.jdField_b_of_type_AndroidGraphicsPoint, this.n);
        label146:
        this.jdField_e_of_type_Boolean = false;
        if (this.jdField_b_of_type_AndroidGraphicsPoint.y <= this.p / 2) {
          break label288;
        }
        awqx.b(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 2, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      f();
      e();
      return;
      i1 = this.jdField_d_of_type_Int;
      i2 = this.jdField_c_of_type_Int;
      break;
      label222:
      setBackgroundResource(2130838977);
      break label92;
      label232:
      if (ThemeUtil.isNowThemeIsNight(null, false, null))
      {
        setBackgroundResource(2130838976);
        break label92;
      }
      setBackgroundResource(2130838979);
      break label92;
      label261:
      layout(paramAnimator.x, paramAnimator.y, paramAnimator.x + i1, i2 + paramAnimator.y);
      break label146;
      label288:
      awqx.b(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 1, 0, "", "", "", "");
      continue;
      if (paramAnimator == this.jdField_b_of_type_AndroidAnimationValueAnimator)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          setVisibility(8);
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "onAnimationEnd setVisibility(GONE)");
          }
          if (this.jdField_a_of_type_Aluk != null) {
            this.jdField_a_of_type_Aluk.a(this);
          }
        }
      }
      else if (paramAnimator == this.jdField_c_of_type_AndroidAnimationValueAnimator)
      {
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
        }
        i2 = this.jdField_c_of_type_Int / 2;
        paramAnimator = this.jdField_b_of_type_AndroidGraphicsPoint;
        i1 = i2;
        if (this.jdField_f_of_type_Boolean)
        {
          i1 = i2;
          if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
            i1 = 0;
          }
        }
        if (this.n % 2 == 0) {
          i2 = this.jdField_c_of_type_Int;
        }
        for (int i3 = this.jdField_d_of_type_Int;; i3 = this.jdField_c_of_type_Int)
        {
          if (paramAnimator.x > 0) {
            break label525;
          }
          if (this.jdField_a_of_type_Aluk == null) {
            break;
          }
          this.jdField_a_of_type_Aluk.a(this, paramAnimator.x, paramAnimator.y, i2 + paramAnimator.x, paramAnimator.y + i3, i1, true);
          break;
          i2 = this.jdField_d_of_type_Int;
        }
        label525:
        if (this.jdField_a_of_type_Aluk != null) {
          this.jdField_a_of_type_Aluk.a(this, paramAnimator.x, paramAnimator.y, i2 + paramAnimator.x, paramAnimator.y + i3, -i1, true);
        }
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (paramAnimator == this.jdField_a_of_type_AndroidAnimationValueAnimator) {
      if (this.k < this.o / 2)
      {
        this.jdField_a_of_type_AndroidGraphicsPoint.x = (0 - this.m);
        this.jdField_a_of_type_AndroidGraphicsPoint.y = this.l;
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidGraphicsPoint.x = (this.o - this.jdField_c_of_type_Int + this.m);
        break;
      } while ((paramAnimator != this.jdField_b_of_type_AndroidAnimationValueAnimator) || (!this.jdField_a_of_type_Boolean));
      setVisibility(0);
    } while (!QLog.isColorLevel());
    QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "onAnimationStart setVisibility(VISIBLE)");
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i3;
    int i4;
    int i1;
    int i2;
    if (paramValueAnimator == this.jdField_a_of_type_AndroidAnimationValueAnimator)
    {
      paramValueAnimator = this.jdField_a_of_type_AndroidGraphicsPoint;
      i3 = (int)(this.k + (paramValueAnimator.x - this.k) * f1);
      float f2 = this.l;
      i4 = (int)(f1 * (paramValueAnimator.y - this.l) + f2);
      if (this.n % 2 == 0)
      {
        i1 = this.jdField_c_of_type_Int;
        i2 = this.jdField_d_of_type_Int;
        if (this.jdField_a_of_type_Aluk == null) {
          break label136;
        }
        this.jdField_a_of_type_Aluk.a(this, i3, i4, i1 + i3, i4 + i2);
      }
    }
    label136:
    label171:
    label317:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            i1 = this.jdField_d_of_type_Int;
            i2 = this.jdField_c_of_type_Int;
            break;
            layout(i3, i4, i3 + i1, i2 + i4);
            return;
            if (paramValueAnimator != this.jdField_b_of_type_AndroidAnimationValueAnimator) {
              break label171;
            }
          } while (this.jdField_a_of_type_Boolean);
          return;
        } while (paramValueAnimator != this.jdField_c_of_type_AndroidAnimationValueAnimator);
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
        }
      } while ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() != 1));
      i3 = (int)(f1 * (this.jdField_c_of_type_Int / 2));
      paramValueAnimator = this.jdField_b_of_type_AndroidGraphicsPoint;
      if (this.n % 2 == 0) {
        i1 = this.jdField_c_of_type_Int;
      }
      for (i2 = this.jdField_d_of_type_Int;; i2 = this.jdField_c_of_type_Int)
      {
        if (paramValueAnimator.x > 0) {
          break label317;
        }
        if (this.jdField_a_of_type_Aluk == null) {
          break;
        }
        this.jdField_a_of_type_Aluk.a(this, paramValueAnimator.x, paramValueAnimator.y, i1 + paramValueAnimator.x, paramValueAnimator.y + i2, i3, false);
        return;
        i1 = this.jdField_d_of_type_Int;
      }
    } while (this.jdField_a_of_type_Aluk == null);
    this.jdField_a_of_type_Aluk.a(this, paramValueAnimator.x, paramValueAnimator.y, i1 + paramValueAnimator.x, paramValueAnimator.y + i2, -i3, false);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    a();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.o == 0) || (this.p == 0))
    {
      this.o = bajq.a();
      this.p = bajq.b();
      setCurPosition(this.jdField_b_of_type_AndroidGraphicsPoint);
    }
  }
  
  public void setCurPosition(Point paramPoint)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "setCurPosition position = " + paramPoint);
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "setCurPosition mScreenWidth = " + this.o);
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "setCurPosition mScreenHeight = " + this.p);
    }
    this.jdField_b_of_type_AndroidGraphicsPoint = paramPoint;
    int i1;
    if ((this.o != 0) && (this.p != 0))
    {
      if (this.n % 2 != 0) {
        break label200;
      }
      i1 = this.jdField_c_of_type_Int;
    }
    for (int i2 = this.jdField_d_of_type_Int;; i2 = this.jdField_c_of_type_Int)
    {
      if ((paramPoint.x == 0) && (paramPoint.y == 0))
      {
        paramPoint.y = (this.p / 2);
        paramPoint.x = (this.o - i1);
      }
      if (this.jdField_a_of_type_Aluk == null) {
        break;
      }
      this.jdField_a_of_type_Aluk.a(this, paramPoint.x, paramPoint.y, i1 + paramPoint.x, paramPoint.y + i2);
      return;
      label200:
      i1 = this.jdField_d_of_type_Int;
    }
    layout(paramPoint.x, paramPoint.y, paramPoint.x + i1, i2 + paramPoint.y);
  }
  
  public void setFloatListener(aluk paramaluk)
  {
    this.jdField_a_of_type_Aluk = paramaluk;
  }
  
  public void setShouldMaxRootView(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
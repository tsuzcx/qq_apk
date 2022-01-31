package com.tencent.mobileqq.colornote.smallscreen;

import actj;
import amhh;
import amik;
import amju;
import amjv;
import amjw;
import amjx;
import amjy;
import amjz;
import amka;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import axqy;
import baxn;
import bbll;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.anim.MusicDanceImageView;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import lcg;
import lze;
import mqq.os.MqqHandler;

public class ColorNoteSmallScreenRelativeLayout
  extends RelativeLayout
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private static float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 3.0F, 2.0F, 2.5F, 2.0F };
  private static int[] jdField_a_of_type_ArrayOfInt = { 0, 9, 5, 3 };
  private static boolean jdField_i_of_type_Boolean;
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private amjz jdField_a_of_type_Amjz;
  private amka jdField_a_of_type_Amka;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point(0, 0);
  private Display jdField_a_of_type_AndroidViewDisplay;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private MusicDanceDrawable jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable;
  private MusicDanceImageView jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView;
  private ColorNoteSmallScreenRelativeLayout.CheckForLongPress jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress = new ColorNoteSmallScreenRelativeLayout.CheckForLongPress(this, null);
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private Point jdField_b_of_type_AndroidGraphicsPoint = new Point();
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private MusicDanceDrawable jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable;
  private MusicDanceImageView jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView;
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
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  private int jdField_j_of_type_Int = -1;
  private boolean jdField_j_of_type_Boolean;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  private int o = -1;
  private int p = 0;
  private int q;
  private int r;
  private int s = -1;
  private int t = -1;
  private int u = -1;
  private int v = 1;
  
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
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131296576);
    this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131296575);
    this.jdField_e_of_type_Int = this.jdField_c_of_type_Int;
    this.jdField_f_of_type_Int = ((int)(this.jdField_c_of_type_Int * 1.5D));
    this.jdField_g_of_type_Int = (this.jdField_c_of_type_Int * 2);
    this.jdField_h_of_type_Int = this.jdField_f_of_type_Int;
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131297744);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this);
    this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(300L);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(this);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(this);
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(this);
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.p = j();
    this.jdField_a_of_type_Amka = new amka(this, getContext(), 2);
    this.r = bbll.b();
    this.q = bbll.a();
    this.o = actj.a(8.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376289));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365395));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376288));
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131368628));
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131368629));
  }
  
  private float a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 9)) {
      return baxn.a(getContext(), jdField_a_of_type_ArrayOfFloat[paramInt]);
    }
    return getResources().getDimensionPixelSize(2131298703);
  }
  
  private int a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 4)) {
      return baxn.a(getContext(), jdField_a_of_type_ArrayOfInt[paramInt]);
    }
    return baxn.a(getContext(), 4.0F);
  }
  
  private SmallColorNoteItem a(ColorNote paramColorNote, ViewGroup paramViewGroup)
  {
    paramViewGroup = new SmallColorNoteItem(getContext(), a());
    paramViewGroup.setAttachLeft(a());
    View localView = paramViewGroup.a().findViewById(2131370921);
    ImageView localImageView = (ImageView)paramViewGroup.a().findViewById(2131370922);
    new amik().a(paramColorNote, localView, localImageView, a());
    paramColorNote = localView.findViewById(2131370932);
    localView = localView.findViewById(2131370930);
    ViewCompat.setImportantForAccessibility(paramViewGroup, 2);
    ViewCompat.setImportantForAccessibility(paramColorNote, 2);
    ViewCompat.setImportantForAccessibility(localView, 2);
    paramColorNote = (RelativeLayout.LayoutParams)findViewById(2131366504).getLayoutParams();
    if (a())
    {
      paramColorNote.addRule(9, 0);
      paramColorNote.addRule(11);
      return paramViewGroup;
    }
    paramColorNote.addRule(11, 0);
    paramColorNote.addRule(9);
    return paramViewGroup;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i5 = this.jdField_i_of_type_Int + paramInt1 - this.k;
    int i4 = this.jdField_j_of_type_Int + paramInt2 - this.l;
    int i6 = e();
    this.jdField_c_of_type_Int = i6;
    int i7 = this.jdField_d_of_type_Int;
    int i1 = i();
    int i3 = this.r - i7;
    int i2 = h();
    paramInt1 = i5;
    if (i5 < i2) {
      paramInt1 = i2;
    }
    paramInt2 = paramInt1;
    if (paramInt1 > i1) {
      paramInt2 = i1;
    }
    paramInt1 = i4;
    if (i4 < 0) {
      paramInt1 = 0;
    }
    if (paramInt1 > i3) {
      paramInt1 = i3;
    }
    for (;;)
    {
      if (((paramInt2 > i2) && (paramInt2 < i1)) || (this.jdField_h_of_type_Boolean))
      {
        this.t = this.s;
        this.s = 2;
        i1 = e();
        this.jdField_c_of_type_Int = i1;
        i2 = this.jdField_d_of_type_Int;
        a(this, paramInt2, paramInt1, paramInt2 + i1, paramInt1 + i2);
        if (this.t != this.s) {
          a(this.s, this.t, paramInt2, paramInt1, i1, i2, false);
        }
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
          setBackgroundResource(2130839003);
        }
      }
      do
      {
        return;
        setBackgroundResource(2130839006);
        return;
        if (paramInt2 == i2)
        {
          this.t = this.s;
          this.s = 0;
          if (this.t != this.s) {
            a(this.s, this.t, paramInt2, paramInt1, i6, i7);
          }
          a(this, paramInt2, paramInt1, paramInt2 + i6, paramInt1 + i7);
          if (ThemeUtil.isNowThemeIsNight(null, false, null))
          {
            setBackgroundResource(2130839002);
            return;
          }
          setBackgroundResource(2130839005);
          return;
        }
      } while (paramInt2 != i1);
      this.t = this.s;
      this.s = 1;
      this.jdField_j_of_type_Boolean = false;
      if (this.t != this.s) {
        a(this.s, this.t, paramInt2, paramInt1, i6, i7);
      }
      a(this, paramInt2, paramInt1, paramInt2 + i6, paramInt1 + i7);
      if (ThemeUtil.isNowThemeIsNight(null, false, null))
      {
        setBackgroundResource(2130839004);
        return;
      }
      setBackgroundResource(2130839007);
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, true);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidGraphicsPoint.x = paramInt3;
      this.jdField_b_of_type_AndroidGraphicsPoint.y = paramInt4;
      if (this.jdField_b_of_type_AndroidGraphicsPoint.x < 0)
      {
        paramInt2 = 0;
        this.s = paramInt2;
      }
    }
    else
    {
      if (paramInt1 != 0) {
        break label71;
      }
      if (!b()) {
        break label64;
      }
      i();
      label54:
      m();
    }
    label64:
    label71:
    do
    {
      return;
      paramInt2 = 1;
      break;
      h();
      break label54;
      if (paramInt1 == 1)
      {
        if (b()) {
          j();
        }
        for (;;)
        {
          m();
          return;
          h();
        }
      }
    } while (paramInt1 != 2);
    l();
  }
  
  private void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Amjz != null)
    {
      this.jdField_a_of_type_Amjz.a(paramColorNoteSmallScreenRelativeLayout, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.v = paramInt2;
    if (paramInt1 == 1) {
      h();
    }
    while ((paramInt1 != 3) && (paramInt1 != 2)) {
      return;
    }
    if (a())
    {
      i();
      return;
    }
    this.jdField_j_of_type_Boolean = true;
    j();
  }
  
  public static boolean d()
  {
    return jdField_i_of_type_Boolean;
  }
  
  private boolean e()
  {
    return this.s == 2;
  }
  
  private void g()
  {
    int i2 = g();
    int i1 = e() + i2 - this.o;
    if (k() == 0) {
      i1 = f() - this.o;
    }
    int i3;
    int i4;
    for (;;)
    {
      i3 = this.jdField_b_of_type_AndroidGraphicsPoint.y;
      i4 = i3 + this.jdField_d_of_type_Int;
      if (this.jdField_a_of_type_Amjz == null) {
        break;
      }
      this.jdField_a_of_type_Amjz.a(this, i2, i3, i1, i4);
      return;
      if (k() == 1) {
        i1 = i2 + e();
      }
    }
    layout(i2, i3, i1, i4);
  }
  
  private void h()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131376289);
    this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView != null) {
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
    }
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    if (a())
    {
      i1 = getResources().getDimensionPixelSize(2131298708);
      localLayoutParams1.width = i1;
      if (!a()) {
        break label223;
      }
      localLayoutParams1.rightMargin = baxn.a(localLinearLayout.getContext(), 10.0F);
      localLayoutParams1.leftMargin = 0;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      label139:
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getViewTreeObserver().addOnGlobalLayoutListener(new amjv(this));
      this.jdField_b_of_type_AndroidGraphicsPoint.x = g();
      if (this.jdField_b_of_type_AndroidGraphicsPoint.x >= 0) {
        break label260;
      }
    }
    label260:
    for (int i1 = 0;; i1 = 1)
    {
      this.s = i1;
      if (this.v != 2) {
        g();
      }
      return;
      i1 = getResources().getDimensionPixelSize(2131298706);
      break;
      label223:
      localLayoutParams1.leftMargin = baxn.a(localLinearLayout.getContext(), 10.0F);
      localLayoutParams1.rightMargin = 0;
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(9);
      break label139;
    }
  }
  
  private void i()
  {
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131376289);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getLayoutParams();
    if (this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a(300);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a();
      localLayoutParams.rightMargin = baxn.a(getContext(), 13.5F);
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(0);
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      localLinearLayout.setVisibility(8);
      this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      localLayoutParams.rightMargin = baxn.a(getContext(), 17.5F);
    }
    for (;;)
    {
      g();
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
      this.jdField_c_of_type_Int = this.jdField_f_of_type_Int;
      localLinearLayout.setVisibility(0);
      localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131298708);
      if (a())
      {
        ((LinearLayout.LayoutParams)localObject).rightMargin = baxn.a(getContext(), 13.5F);
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      }
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private int j()
  {
    try
    {
      int i1 = this.jdField_a_of_type_AndroidViewDisplay.getRotation();
      return i1;
    }
    catch (Exception localException)
    {
      lcg.e("ColorNoteSmallScreenRelativeLayout", localException.getMessage());
    }
    return 0;
  }
  
  private void j()
  {
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    int i1;
    LinearLayout localLinearLayout;
    if ((this.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() > 1))
    {
      i1 = 1;
      localLinearLayout = (LinearLayout)findViewById(2131376289);
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a();
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getLayoutParams();
      if (i1 == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(0);
        localLayoutParams.leftMargin = baxn.a(getContext(), 13.5F);
      }
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a(300);
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label206;
      }
      localLinearLayout.setVisibility(8);
      this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
      localLayoutParams.leftMargin = baxn.a(getContext(), 17.5F);
    }
    for (;;)
    {
      if (i1 == 0) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getViewTreeObserver().addOnPreDrawListener(new amjw(this));
      }
      if (i1 == 0) {
        break label299;
      }
      k();
      return;
      i1 = 0;
      break;
      label206:
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      this.jdField_c_of_type_Int = this.jdField_f_of_type_Int;
      localLinearLayout.setVisibility(0);
      if (i1 == 0)
      {
        localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131298706);
        if (!a())
        {
          ((LinearLayout.LayoutParams)localObject).leftMargin = baxn.a(getContext(), 14.5F);
          ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        }
        localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label299:
    g();
  }
  
  private int k()
  {
    return this.s;
  }
  
  private void k()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(100L);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    int i1 = localLayoutParams.leftMargin;
    this.jdField_b_of_type_AndroidGraphicsPoint.x = (this.q - this.jdField_e_of_type_Int + this.o);
    localValueAnimator.addUpdateListener(new amjx(this, this, this.jdField_b_of_type_AndroidGraphicsPoint, localLayoutParams, i1));
    localValueAnimator.addListener(new amjy(this));
    localValueAnimator.start();
  }
  
  private void l()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
  }
  
  private void m()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void n()
  {
    if ((ThemeUtil.isNowThemeIsNight(null, false, null)) || (jdField_i_of_type_Boolean))
    {
      if (this.jdField_b_of_type_AndroidGraphicsPoint.x <= 0)
      {
        setBackgroundResource(2130839002);
        return;
      }
      setBackgroundResource(2130839004);
      return;
    }
    if (this.jdField_b_of_type_AndroidGraphicsPoint.x <= 0)
    {
      setBackgroundResource(2130839005);
      return;
    }
    setBackgroundResource(2130839007);
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
    int i4 = j();
    boolean bool = lze.i();
    int i1;
    int i2;
    if (i4 % 2 == 1)
    {
      i1 = bbll.a();
      i2 = bbll.b();
      int i3 = i1;
      if (bool) {
        i3 = i1 - this.jdField_a_of_type_Int;
      }
      i1 = this.p;
      if ((this.p != i4) || (i2 != this.q) || ((i4 == 0) && (this.r < i3)) || ((i4 != 0) && (this.r != i3)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ColorNoteSmallScreenRelativeLayout", 1, "onOrientationChangedInner, mPosition[" + i1 + "], mRotation[" + this.p + "->" + i4 + "], mScreenWidth[" + this.q + "->" + i2 + "], mScreenHeight[" + this.r + "->" + i3 + "], mIsInit[" + this.jdField_e_of_type_Boolean + "]");
        }
        if ((this.jdField_e_of_type_Boolean) && (i4 != 0)) {
          this.jdField_e_of_type_Boolean = false;
        }
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
        this.p = i4;
        this.q = i2;
        this.r = i3;
        this.jdField_b_of_type_AndroidGraphicsPoint = new Point(g(), i3 / 2);
        setCurPosition(this.jdField_b_of_type_AndroidGraphicsPoint);
        if (this.jdField_a_of_type_Amjz == null) {
          break label368;
        }
        i1 = this.jdField_a_of_type_Amjz.a(this);
        this.m = i1;
        this.jdField_i_of_type_Int = i1;
        i1 = this.jdField_a_of_type_Amjz.b(this);
        this.n = i1;
        this.jdField_j_of_type_Int = i1;
        this.jdField_a_of_type_Amjz.a(this.jdField_b_of_type_AndroidGraphicsPoint, this.p);
      }
    }
    for (;;)
    {
      if (!this.jdField_e_of_type_Boolean) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      return;
      i2 = bbll.a();
      i1 = bbll.b();
      break;
      label368:
      i1 = getLeft();
      this.m = i1;
      this.jdField_i_of_type_Int = i1;
      i1 = getTop();
      this.n = i1;
      this.jdField_j_of_type_Int = i1;
    }
  }
  
  public void a(List<ColorNote> paramList)
  {
    int i6 = 0;
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131376289);
    if (!amhh.a(this.jdField_a_of_type_JavaUtilList, paramList)) {}
    for (int i1 = 1; (localLinearLayout == null) || (paramList.size() <= 0); i1 = 0)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      f();
      return;
    }
    int i4;
    int i2;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      i4 = 0;
      if ((this.jdField_g_of_type_Boolean) || (i1 == 0)) {
        break label322;
      }
      Iterator localIterator = paramList.iterator();
      i2 = 0;
      i1 = 0;
      label90:
      if (!localIterator.hasNext()) {
        break label169;
      }
      ColorNote localColorNote = (ColorNote)localIterator.next();
      if (localColorNote.getServiceType() != 16973824) {
        break label347;
      }
      if (!localColorNote.animate) {
        break label335;
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
      break label90;
      i4 = this.jdField_a_of_type_JavaUtilList.size();
      break;
      label169:
      int i5 = 0;
      i3 = i6;
      if (i5 < i4)
      {
        if (((ColorNote)this.jdField_a_of_type_JavaUtilList.get(i5)).getServiceType() != 16973824) {
          break label332;
        }
        i3 = 1;
      }
      label322:
      label332:
      for (;;)
      {
        i5 += 1;
        break;
        this.jdField_a_of_type_JavaUtilList = paramList;
        if (((i1 != 0) || ((i2 == 0) && (i3 != 0))) && (Math.abs(paramList.size() - i4) == 1))
        {
          f();
          return;
        }
        this.jdField_g_of_type_Boolean = true;
        paramList = localLinearLayout.animate();
        if (a()) {}
        for (float f1 = -localLinearLayout.getMeasuredWidth();; f1 = localLinearLayout.getMeasuredWidth())
        {
          paramList.translationX(f1).setDuration(200L).setListener(new amju(this, localLinearLayout)).start();
          return;
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
        f();
        return;
      }
      label335:
      i3 = 1;
      i2 = i1;
      i1 = i3;
      continue;
      label347:
      i3 = i1;
      i1 = i2;
      i2 = i3;
    }
  }
  
  public boolean a()
  {
    if ((this.s == -1) && (this.jdField_a_of_type_Amjz != null))
    {
      this.jdField_b_of_type_AndroidGraphicsPoint.x = this.jdField_a_of_type_Amjz.a(this);
      this.jdField_b_of_type_AndroidGraphicsPoint.y = this.jdField_a_of_type_Amjz.b(this);
      if (this.jdField_b_of_type_AndroidGraphicsPoint.x >= 0) {
        break label107;
      }
    }
    label107:
    for (int i1 = 0;; i1 = 1)
    {
      this.s = i1;
      if ((this.s == 0) && (this.jdField_b_of_type_AndroidGraphicsPoint.x > 0) && (QLog.isColorLevel())) {
        QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "state is STATE_LEFT, but mPoint.x grater than 0");
      }
      if (this.s != 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidGraphicsPoint.x = g();
  }
  
  public boolean b()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public int c()
  {
    return this.q;
  }
  
  public void c()
  {
    Point localPoint;
    int i1;
    int i2;
    if ((this.q != 0) && (this.r != 0))
    {
      localPoint = this.jdField_b_of_type_AndroidGraphicsPoint;
      i1 = e();
      this.jdField_c_of_type_Int = i1;
      i2 = this.jdField_d_of_type_Int;
      if ((this.jdField_a_of_type_Amjz != null) && (!this.jdField_d_of_type_Boolean)) {
        this.jdField_a_of_type_Amjz.a(this, localPoint.x, localPoint.y, i1 + localPoint.x, i2 + localPoint.y);
      }
    }
    else
    {
      return;
    }
    layout(localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i2);
  }
  
  public boolean c()
  {
    return (b()) && (this.jdField_a_of_type_JavaUtilList.size() != 1);
  }
  
  public int d()
  {
    return this.r;
  }
  
  public void d()
  {
    if (!this.jdField_d_of_type_Boolean) {
      e();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    int i1 = (int)paramMotionEvent.getRawX();
    int i2 = (int)paramMotionEvent.getRawY();
    int i3 = this.jdField_i_of_type_Int;
    i3 = this.k;
    i3 = this.jdField_j_of_type_Int;
    i3 = this.l;
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
        this.k = i1;
        this.l = i2;
        if (this.jdField_a_of_type_Amjz != null) {
          this.jdField_i_of_type_Int = this.jdField_a_of_type_Amjz.a(this);
        }
        for (this.jdField_j_of_type_Int = this.jdField_a_of_type_Amjz.b(this);; this.jdField_j_of_type_Int = getTop())
        {
          this.jdField_b_of_type_Boolean = false;
          return true;
          this.jdField_i_of_type_Int = getLeft();
        }
      case 2: 
        this.jdField_h_of_type_Boolean = true;
        if (this.jdField_b_of_type_Boolean)
        {
          a(i1, i2);
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress);
          return true;
        }
        break;
      }
    } while ((Math.abs(i1 - this.k) <= this.jdField_b_of_type_Int) && (Math.abs(i2 - this.l) <= this.jdField_b_of_type_Int));
    this.jdField_b_of_type_Boolean = true;
    return true;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress);
    boolean bool1;
    if (this.jdField_b_of_type_Boolean)
    {
      a(i1, i2);
      bool1 = bool2;
      label288:
      if (this.jdField_a_of_type_Amjz == null) {
        break label428;
      }
      this.m = this.jdField_a_of_type_Amjz.a(this);
    }
    for (this.n = this.jdField_a_of_type_Amjz.b(this); !bool1; this.n = getTop())
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return true;
      long l1 = System.currentTimeMillis();
      bool1 = bool2;
      if (this.jdField_a_of_type_Amjz == null) {
        break label288;
      }
      bool1 = bool2;
      if (this.jdField_c_of_type_Boolean) {
        break label288;
      }
      bool1 = bool2;
      if (l1 - this.jdField_a_of_type_Long <= 600L) {
        break label288;
      }
      paramMotionEvent = this.jdField_a_of_type_Amjz;
      Point localPoint = this.jdField_b_of_type_AndroidGraphicsPoint;
      bool1 = bool3;
      if (this.p == 0) {
        bool1 = true;
      }
      bool1 = paramMotionEvent.a(localPoint, bool1);
      this.jdField_a_of_type_Long = l1;
      break label288;
      label428:
      this.m = getLeft();
    }
    this.jdField_h_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_b_of_type_Boolean)
    {
      a(i1, i2);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress);
    }
    if (this.jdField_a_of_type_Amjz != null) {
      this.m = this.jdField_a_of_type_Amjz.a(this);
    }
    for (this.n = this.jdField_a_of_type_Amjz.b(this);; this.n = getTop())
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return true;
      this.m = getLeft();
    }
  }
  
  public int e()
  {
    if (e()) {
      return this.jdField_e_of_type_Int;
    }
    if (c())
    {
      if (a()) {
        return this.jdField_f_of_type_Int;
      }
      return this.jdField_g_of_type_Int;
    }
    if (a()) {
      return this.jdField_e_of_type_Int;
    }
    return this.jdField_g_of_type_Int;
  }
  
  public void e()
  {
    LinearLayout.LayoutParams localLayoutParams;
    int i1;
    if ((this.jdField_a_of_type_JavaUtilList.size() == 1) || (!b()))
    {
      this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        if (!a()) {
          break label123;
        }
        i1 = getResources().getDimensionPixelSize(2131298708);
        label64:
        localLayoutParams.width = i1;
        if (!b()) {
          break label159;
        }
        if (!a()) {
          break label137;
        }
        localLayoutParams.rightMargin = baxn.a(getContext(), 13.5F);
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
      label123:
      i1 = getResources().getDimensionPixelSize(2131298706);
      break label64;
      label137:
      localLayoutParams.leftMargin = baxn.a(getContext(), 14.5F);
      localLayoutParams.rightMargin = 0;
      continue;
      label159:
      if (a())
      {
        localLayoutParams.rightMargin = baxn.a(getContext(), 10.0F);
        localLayoutParams.leftMargin = 0;
      }
      else
      {
        localLayoutParams.leftMargin = baxn.a(getContext(), 10.0F);
        localLayoutParams.rightMargin = 0;
      }
    }
  }
  
  public int f()
  {
    if ((e()) || (this.jdField_h_of_type_Boolean)) {
      return this.jdField_e_of_type_Int;
    }
    if (c()) {
      return this.jdField_f_of_type_Int;
    }
    return this.jdField_e_of_type_Int;
  }
  
  public void f()
  {
    int i3 = 0;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Amjz == null)) {}
    int i6;
    label107:
    label240:
    label248:
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
        i6 = this.u;
        if (!this.jdField_f_of_type_Boolean) {
          break label240;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() <= 1) {
          break label232;
        }
        this.u = 2;
        localLinearLayout = (LinearLayout)findViewById(2131376289);
        localLinearLayout.removeAllViews();
        if (!this.jdField_f_of_type_Boolean) {
          break label248;
        }
        i1 = this.jdField_a_of_type_JavaUtilList.size() - 1;
        i5 = getResources().getDimensionPixelSize(2131298702);
        i2 = getResources().getDimensionPixelSize(2131298701);
        i4 = a(i1);
        if (i1 != 0) {
          break label261;
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
            this.u = 3;
            break label107;
            this.u = 1;
            break label107;
            i1 = this.jdField_a_of_type_JavaUtilList.size();
            break label142;
            i2 = (int)((i2 - i4 * 2) * 1.0F / i1 - a(i1));
            continue;
          }
          SmallColorNoteItem localSmallColorNoteItem = a((ColorNote)localObject, localLinearLayout);
          localSmallColorNoteItem.setAttachLeft(a());
          if (this.jdField_f_of_type_Boolean)
          {
            i4 = this.jdField_a_of_type_JavaUtilList.size() - 1;
            if (i4 <= 3) {
              break label440;
            }
            localSmallColorNoteItem.c();
            if (!this.jdField_f_of_type_Boolean) {
              break label468;
            }
            i4 = this.jdField_a_of_type_JavaUtilList.size() - 1;
            if (i4 <= 4) {
              break label482;
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
            break label323;
            localSmallColorNoteItem.d();
            localSmallColorNoteItem.setTitle(((ColorNote)localObject).mMainTitle);
            localSmallColorNoteItem.setSubTitle(((ColorNote)localObject).mSubTitle);
            break label334;
            i4 = this.jdField_a_of_type_JavaUtilList.size();
            break label354;
            localSmallColorNoteItem.b();
          }
        }
      }
    } while (i6 == this.u);
    label142:
    label232:
    b(this.u, i6);
    label261:
    label323:
    label334:
    label354:
    return;
  }
  
  public int g()
  {
    if (a()) {
      return -this.o;
    }
    return this.q - f() + this.o;
  }
  
  public int h()
  {
    return -this.o;
  }
  
  public int i()
  {
    return this.q - f() + this.o;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i2;
    int i3;
    int i1;
    int i4;
    if (paramAnimator == this.jdField_a_of_type_AndroidAnimationValueAnimator)
    {
      paramAnimator = this.jdField_a_of_type_AndroidGraphicsPoint;
      i2 = e();
      this.jdField_c_of_type_Int = i2;
      i3 = this.jdField_d_of_type_Int;
      this.jdField_b_of_type_AndroidGraphicsPoint = paramAnimator;
      if ((paramAnimator.x <= 0) || (k() == 0))
      {
        this.t = this.s;
        this.s = 0;
        this.jdField_b_of_type_AndroidGraphicsPoint.x = g();
        if (this.jdField_b_of_type_AndroidGraphicsPoint.x < 0)
        {
          i1 = 0;
          this.s = i1;
          i1 = g();
          i4 = e();
          if (this.t != this.s) {
            a(this.s, this.t, i1, this.jdField_b_of_type_AndroidGraphicsPoint.y, i2, i3);
          }
          a(this, i1, this.jdField_b_of_type_AndroidGraphicsPoint.y, i1 + i4, i3 + this.jdField_b_of_type_AndroidGraphicsPoint.y);
          if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
            break label265;
          }
          setBackgroundResource(2130839002);
          label177:
          if (this.jdField_a_of_type_Amjz != null) {
            this.jdField_a_of_type_Amjz.a(this.jdField_b_of_type_AndroidGraphicsPoint, this.p);
          }
          this.jdField_e_of_type_Boolean = false;
          if (this.jdField_b_of_type_AndroidGraphicsPoint.y <= this.r / 2) {
            break label439;
          }
          axqy.b(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 2, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      f();
      return;
      i1 = 1;
      break;
      label265:
      setBackgroundResource(2130839005);
      break label177;
      this.t = this.s;
      this.s = 1;
      this.jdField_b_of_type_AndroidGraphicsPoint.x = g();
      if (this.jdField_b_of_type_AndroidGraphicsPoint.x < 0) {}
      for (i1 = 0;; i1 = 1)
      {
        this.s = i1;
        i1 = g();
        i4 = e();
        if (this.t != this.s) {
          a(this.s, this.t, this.jdField_b_of_type_AndroidGraphicsPoint.x, this.jdField_b_of_type_AndroidGraphicsPoint.y, i2, i3);
        }
        this.jdField_j_of_type_Boolean = true;
        a(this, this.jdField_b_of_type_AndroidGraphicsPoint.x, this.jdField_b_of_type_AndroidGraphicsPoint.y, i1 + i4, this.jdField_b_of_type_AndroidGraphicsPoint.y + i3);
        if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
          break label429;
        }
        setBackgroundResource(2130839004);
        break;
      }
      label429:
      setBackgroundResource(2130839007);
      break label177;
      label439:
      axqy.b(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 1, 0, "", "", "", "");
      continue;
      if (paramAnimator == this.jdField_b_of_type_AndroidAnimationValueAnimator)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          setVisibility(8);
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "onAnimationEnd setVisibility(GONE)");
          }
          if (this.jdField_a_of_type_Amjz != null) {
            this.jdField_a_of_type_Amjz.a(this);
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
        i2 = e();
        this.jdField_c_of_type_Int = i2;
        i3 = this.jdField_d_of_type_Int;
        if (paramAnimator.x <= 0)
        {
          if (this.jdField_a_of_type_Amjz != null) {
            this.jdField_a_of_type_Amjz.a(this, paramAnimator.x, paramAnimator.y, i2 + paramAnimator.x + i1, i3 + paramAnimator.y, i1, true);
          }
        }
        else if (this.jdField_a_of_type_Amjz != null) {
          this.jdField_a_of_type_Amjz.a(this, paramAnimator.x - i1, paramAnimator.y, i2 + paramAnimator.x - i1, i3 + paramAnimator.y, -i1, true);
        }
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (paramAnimator == this.jdField_a_of_type_AndroidAnimationValueAnimator) {
      if (this.m + e() / 2 < this.q / 2)
      {
        this.jdField_a_of_type_AndroidGraphicsPoint.x = (-this.o);
        this.jdField_a_of_type_AndroidGraphicsPoint.y = this.n;
        this.jdField_j_of_type_Boolean = false;
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidGraphicsPoint.x = i();
        break;
      } while ((paramAnimator != this.jdField_b_of_type_AndroidAnimationValueAnimator) || (!this.jdField_a_of_type_Boolean));
      setVisibility(0);
    } while (!QLog.isColorLevel());
    QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "onAnimationStart setVisibility(VISIBLE)");
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i1;
    int i2;
    int i3;
    int i4;
    if (paramValueAnimator == this.jdField_a_of_type_AndroidAnimationValueAnimator)
    {
      paramValueAnimator = this.jdField_a_of_type_AndroidGraphicsPoint;
      i1 = (int)(this.m + (paramValueAnimator.x - this.m) * f1);
      float f2 = this.n;
      i2 = (int)(f1 * (paramValueAnimator.y - this.n) + f2);
      i3 = e();
      this.jdField_c_of_type_Int = i3;
      i4 = this.jdField_d_of_type_Int;
      if (this.jdField_a_of_type_Amjz != null) {
        this.jdField_a_of_type_Amjz.a(this, i1, i2, i1 + i3, i4 + i2);
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
            do
            {
              return;
              layout(i1, i2, i1 + i3, i2 + i4);
              return;
              if (paramValueAnimator != this.jdField_b_of_type_AndroidAnimationValueAnimator) {
                break;
              }
            } while (this.jdField_a_of_type_Boolean);
            return;
          } while (paramValueAnimator != this.jdField_c_of_type_AndroidAnimationValueAnimator);
          if (this.jdField_c_of_type_Boolean) {
            this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
          }
        } while ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() != 1));
        i1 = (int)(f1 * (this.jdField_c_of_type_Int / 2));
        this.jdField_b_of_type_AndroidGraphicsPoint.x = g();
        paramValueAnimator = this.jdField_b_of_type_AndroidGraphicsPoint;
        i2 = e();
        this.jdField_c_of_type_Int = i2;
        i3 = this.jdField_d_of_type_Int;
        if (paramValueAnimator.x > 0) {
          break;
        }
      } while (this.jdField_a_of_type_Amjz == null);
      this.jdField_a_of_type_Amjz.a(this, paramValueAnimator.x, paramValueAnimator.y, i2 + paramValueAnimator.x + i1, i3 + paramValueAnimator.y, i1, false);
      return;
    } while (this.jdField_a_of_type_Amjz == null);
    this.jdField_a_of_type_Amjz.a(this, paramValueAnimator.x - i1, paramValueAnimator.y, i2 + paramValueAnimator.x - i1, i3 + paramValueAnimator.y, -i1, false);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    a();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376288));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376289));
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131368628));
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131368629));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365395));
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable = new MusicDanceDrawable();
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a(getContext(), baxn.a(getContext(), 15.0F), baxn.a(getContext(), 9.5F), getContext().getResources().getColor(2131165443));
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable = new MusicDanceDrawable();
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable.a(getContext(), baxn.a(getContext(), 15.0F), baxn.a(getContext(), 9.5F), getContext().getResources().getColor(2131165443));
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable);
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceDrawable);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.q == 0) || (this.r == 0))
    {
      this.q = bbll.a();
      this.r = bbll.b();
      setCurPosition(this.jdField_b_of_type_AndroidGraphicsPoint);
    }
  }
  
  public void setCurPosition(Point paramPoint)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "setCurPosition position = " + paramPoint);
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "setCurPosition mScreenWidth = " + this.q);
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "setCurPosition mScreenHeight = " + this.r);
    }
    this.jdField_b_of_type_AndroidGraphicsPoint = paramPoint;
    if (this.jdField_b_of_type_AndroidGraphicsPoint.x < 0) {}
    int i2;
    for (int i1 = 0;; i1 = 1)
    {
      this.s = i1;
      if ((this.q != 0) && (this.r != 0))
      {
        i1 = this.jdField_c_of_type_Int;
        i2 = this.jdField_d_of_type_Int;
        if ((paramPoint.x == 0) && (paramPoint.y == 0))
        {
          paramPoint.y = (this.r / 2);
          paramPoint.x = (this.q - i1);
        }
        if (this.jdField_a_of_type_Amjz == null) {
          break;
        }
        this.jdField_a_of_type_Amjz.a(this, paramPoint.x, paramPoint.y, paramPoint.x + i1, i2 + paramPoint.y);
      }
      return;
    }
    layout(paramPoint.x, paramPoint.y, i1 + paramPoint.x, paramPoint.y + i2);
  }
  
  public void setCustomNightMode(boolean paramBoolean)
  {
    jdField_i_of_type_Boolean = paramBoolean;
    n();
  }
  
  public void setFloatListener(amjz paramamjz)
  {
    this.jdField_a_of_type_Amjz = paramamjz;
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
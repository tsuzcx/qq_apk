package com.tencent.mobileqq.colornote.smallscreen;

import afur;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
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
import aqcn;
import aqda;
import aqee;
import aqfi;
import aqfj;
import aqfk;
import aqfl;
import aqfm;
import aqfo;
import aqfp;
import aqfw;
import aqfy;
import bcst;
import bggq;
import bgtn;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.anim.MusicDanceImageView;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import lbc;
import lyu;
import mqq.os.MqqHandler;

public class ColorNoteSmallScreenRelativeLayout
  extends RelativeLayout
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, aqfw
{
  private static float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 3.0F, 2.0F, 2.5F, 2.0F };
  private static int[] jdField_a_of_type_ArrayOfInt = { 0, 9, 5, 3 };
  private static boolean jdField_i_of_type_Boolean;
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point(0, 0);
  private Display jdField_a_of_type_AndroidViewDisplay;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private aqcn jdField_a_of_type_Aqcn;
  private aqfo jdField_a_of_type_Aqfo;
  private aqfp jdField_a_of_type_Aqfp;
  private aqfy jdField_a_of_type_Aqfy;
  private MusicDanceImageView jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView;
  private ColorNoteSmallScreenRelativeLayout.CheckForLongPress jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress = new ColorNoteSmallScreenRelativeLayout.CheckForLongPress(this, null);
  private Cancellable jdField_a_of_type_ComTencentMobileqqDiniflyCancellable;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private Point jdField_b_of_type_AndroidGraphicsPoint = new Point();
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private aqcn jdField_b_of_type_Aqcn;
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
  private int jdField_k_of_type_Int = -1;
  private boolean jdField_k_of_type_Boolean;
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
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131296635);
    this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131296634);
    this.jdField_e_of_type_Int = this.jdField_c_of_type_Int;
    this.jdField_f_of_type_Int = ((int)(this.jdField_c_of_type_Int * 1.5D));
    this.jdField_g_of_type_Int = (this.jdField_c_of_type_Int * 2);
    this.jdField_h_of_type_Int = this.jdField_f_of_type_Int;
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131297846);
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
    this.jdField_a_of_type_Aqfp = new aqfp(this, getContext(), 2);
    this.r = bgtn.b();
    this.q = bgtn.a();
    this.o = afur.a(8.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377659));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365717));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377658));
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131369197));
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131369198));
  }
  
  private float a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 9)) {
      return bggq.a(getContext(), jdField_a_of_type_ArrayOfFloat[paramInt]);
    }
    return getResources().getDimensionPixelSize(2131298814);
  }
  
  private int a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 4)) {
      return bggq.a(getContext(), jdField_a_of_type_ArrayOfInt[paramInt]);
    }
    return bggq.a(getContext(), 4.0F);
  }
  
  private SmallColorNoteItem a(ColorNote paramColorNote, ViewGroup paramViewGroup)
  {
    paramViewGroup = new SmallColorNoteItem(getContext(), a(), paramViewGroup);
    paramViewGroup.setAttachLeft(a());
    View localView = paramViewGroup.a().findViewById(2131371815);
    ImageView localImageView = (ImageView)paramViewGroup.a().findViewById(2131371816);
    new aqee().a(paramColorNote, localView, localImageView, a());
    paramColorNote = localView.findViewById(2131371826);
    localView = localView.findViewById(2131371824);
    ViewCompat.setImportantForAccessibility(paramViewGroup, 2);
    ViewCompat.setImportantForAccessibility(paramColorNote, 2);
    ViewCompat.setImportantForAccessibility(localView, 2);
    paramColorNote = (RelativeLayout.LayoutParams)findViewById(2131366887).getLayoutParams();
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
    int i5 = this.jdField_i_of_type_Int + paramInt1 - this.jdField_k_of_type_Int;
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
          setBackgroundResource(2130839257);
        }
      }
      do
      {
        return;
        setBackgroundResource(2130839260);
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
            setBackgroundResource(2130839256);
            return;
          }
          setBackgroundResource(2130839259);
          return;
        }
      } while (paramInt2 != i1);
      this.t = this.s;
      this.s = 1;
      this.jdField_k_of_type_Boolean = false;
      if (this.t != this.s) {
        a(this.s, this.t, paramInt2, paramInt1, i6, i7);
      }
      a(this, paramInt2, paramInt1, paramInt2 + i6, paramInt1 + i7);
      if (ThemeUtil.isNowThemeIsNight(null, false, null))
      {
        setBackgroundResource(2130839258);
        return;
      }
      setBackgroundResource(2130839261);
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
      j();
      label54:
      n();
    }
    label64:
    label71:
    do
    {
      return;
      paramInt2 = 1;
      break;
      i();
      break label54;
      if (paramInt1 == 1)
      {
        if (b()) {
          k();
        }
        for (;;)
        {
          n();
          return;
          i();
        }
      }
    } while (paramInt1 != 2);
    m();
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      if (!paramBoolean) {
        p();
      }
      return;
    }
    ThreadManagerV2.excute(new ColorNoteSmallScreenRelativeLayout.6(this, paramString1, paramContext, paramString2, paramBoolean), 16, null, true);
  }
  
  private void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Aqfo != null)
    {
      this.jdField_a_of_type_Aqfo.a(paramColorNoteSmallScreenRelativeLayout, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    MusicDanceDrawable localMusicDanceDrawable = null;
    if (paramInt == 1) {
      localMusicDanceDrawable = new MusicDanceDrawable();
    }
    if (localMusicDanceDrawable == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aqcn = localMusicDanceDrawable;
      localMusicDanceDrawable.a(getContext(), bggq.a(getContext(), 15.0F), bggq.a(getContext(), 9.5F), getContext().getResources().getColor(2131165515));
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable((Drawable)localMusicDanceDrawable);
      return;
    }
    this.jdField_b_of_type_Aqcn = localMusicDanceDrawable;
    localMusicDanceDrawable.a(getContext(), bggq.a(getContext(), 15.0F), bggq.a(getContext(), 9.5F), getContext().getResources().getColor(2131165515));
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable((Drawable)localMusicDanceDrawable);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.v = paramInt2;
    if (paramInt1 == 1) {
      i();
    }
    while ((paramInt1 != 3) && (paramInt1 != 2) && (paramInt1 != 4)) {
      return;
    }
    if (a())
    {
      j();
      return;
    }
    this.jdField_k_of_type_Boolean = true;
    k();
  }
  
  public static boolean d()
  {
    return jdField_i_of_type_Boolean;
  }
  
  private boolean e()
  {
    return this.s == 2;
  }
  
  private void h()
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
      if (this.jdField_a_of_type_Aqfo == null) {
        break;
      }
      this.jdField_a_of_type_Aqfo.a(this, i2, i3, i1, i4);
      return;
      if (k() == 1) {
        i1 = i2 + e();
      }
    }
    layout(i2, i3, i1, i4);
  }
  
  private void i()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377659);
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
      i1 = getResources().getDimensionPixelSize(2131298819);
      localLayoutParams1.width = i1;
      if (!a()) {
        break label224;
      }
      localLayoutParams1.rightMargin = bggq.a(localLinearLayout.getContext(), 10.0F);
      localLayoutParams1.leftMargin = 0;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      label140:
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getViewTreeObserver().addOnGlobalLayoutListener(new aqfj(this));
      this.jdField_b_of_type_AndroidGraphicsPoint.x = g();
      if (this.jdField_b_of_type_AndroidGraphicsPoint.x >= 0) {
        break label261;
      }
    }
    label261:
    for (int i1 = 0;; i1 = 1)
    {
      this.s = i1;
      if (this.v != 2) {
        h();
      }
      return;
      i1 = getResources().getDimensionPixelSize(2131298817);
      break;
      label224:
      localLayoutParams1.leftMargin = bggq.a(localLinearLayout.getContext(), 10.0F);
      localLayoutParams1.rightMargin = 0;
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(9);
      break label140;
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
      lbc.e("ColorNoteSmallScreenRelativeLayout", localException.getMessage());
    }
    return 0;
  }
  
  private void j()
  {
    if (!b()) {
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377659);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getLayoutParams();
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleX(1.0F);
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleY(1.0F);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    if (aqda.a(this.jdField_a_of_type_JavaUtilList))
    {
      a(getContext(), "colornote/data.json", "colornote/images", false);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
      localLayoutParams.rightMargin = bggq.a(getContext(), 13.5F);
      if ((this.jdField_a_of_type_JavaUtilList.size() != 1) || (!this.jdField_f_of_type_Boolean)) {
        break label307;
      }
      localLinearLayout.setVisibility(8);
      this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      localLayoutParams.rightMargin = bggq.a(getContext(), 17.5F);
    }
    for (;;)
    {
      h();
      return;
      a(true, 1);
      if (this.jdField_a_of_type_Aqcn == null)
      {
        this.jdField_a_of_type_Aqcn = new MusicDanceDrawable();
        this.jdField_a_of_type_Aqcn.a(getContext(), bggq.a(getContext(), 15.0F), bggq.a(getContext(), 9.5F), getContext().getResources().getColor(2131165515));
      }
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable((Drawable)this.jdField_a_of_type_Aqcn);
      this.jdField_a_of_type_Aqcn.a(300);
      if (this.jdField_b_of_type_Aqcn == null) {
        break;
      }
      this.jdField_b_of_type_Aqcn.stop();
      break;
      label307:
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
      this.jdField_c_of_type_Int = this.jdField_f_of_type_Int;
      localLinearLayout.setVisibility(0);
      localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLinearLayout.setGravity(16);
      ((LinearLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131298819);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      if (a())
      {
        ((LinearLayout.LayoutParams)localObject).rightMargin = bggq.a(getContext(), 13.5F);
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      }
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      f();
    }
  }
  
  private int k()
  {
    return this.s;
  }
  
  private void k()
  {
    if (!b()) {
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    int i1;
    LinearLayout localLinearLayout;
    int i2;
    if ((this.jdField_k_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() > 1))
    {
      i1 = 1;
      localLinearLayout = (LinearLayout)findViewById(2131377659);
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
      if (this.jdField_a_of_type_Aqcn != null) {
        this.jdField_a_of_type_Aqcn.stop();
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleX(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleY(1.0F);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getLayoutParams();
      if (i1 == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(0);
        localLayoutParams.leftMargin = bggq.a(getContext(), 13.5F);
      }
      if (!aqda.a(this.jdField_a_of_type_JavaUtilList)) {
        break label362;
      }
      a(getContext(), "colornote/data.json", "colornote/images", false);
      i2 = 0;
      label160:
      if (i2 != 0)
      {
        if (this.jdField_b_of_type_Aqcn == null)
        {
          this.jdField_b_of_type_Aqcn = new MusicDanceDrawable();
          this.jdField_b_of_type_Aqcn.a(getContext(), bggq.a(getContext(), 15.0F), bggq.a(getContext(), 9.5F), getContext().getResources().getColor(2131165515));
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable((Drawable)this.jdField_b_of_type_Aqcn);
        this.jdField_b_of_type_Aqcn.a(300);
      }
      if ((this.jdField_a_of_type_JavaUtilList.size() != 1) || (!this.jdField_f_of_type_Boolean)) {
        break label373;
      }
      localLinearLayout.setVisibility(8);
      this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
      localLayoutParams.leftMargin = bggq.a(getContext(), 17.5F);
    }
    for (;;)
    {
      if (i1 == 0) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getViewTreeObserver().addOnPreDrawListener(new aqfk(this));
      }
      if (i1 == 0) {
        break label481;
      }
      l();
      return;
      i1 = 0;
      break;
      label362:
      a(false, 1);
      i2 = 1;
      break label160;
      label373:
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      this.jdField_c_of_type_Int = this.jdField_f_of_type_Int;
      localLinearLayout.setVisibility(0);
      localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      if (i1 == 0)
      {
        ((LinearLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131298817);
        if (!a())
        {
          ((LinearLayout.LayoutParams)localObject).leftMargin = bggq.a(getContext(), 14.5F);
          ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        }
        localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label481:
    h();
  }
  
  private void l()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(100L);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    int i1 = localLayoutParams.leftMargin;
    this.jdField_b_of_type_AndroidGraphicsPoint.x = (this.q - this.jdField_e_of_type_Int + this.o);
    localValueAnimator.addUpdateListener(new aqfl(this, this, this.jdField_b_of_type_AndroidGraphicsPoint, localLayoutParams, i1));
    localValueAnimator.addListener(new aqfm(this));
    localValueAnimator.start();
  }
  
  private void m()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
  }
  
  private void n()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void o()
  {
    if ((ThemeUtil.isNowThemeIsNight(null, false, null)) || (jdField_i_of_type_Boolean))
    {
      if (this.jdField_b_of_type_AndroidGraphicsPoint.x <= 0)
      {
        setBackgroundResource(2130839256);
        return;
      }
      setBackgroundResource(2130839258);
      return;
    }
    if (this.jdField_b_of_type_AndroidGraphicsPoint.x <= 0)
    {
      setBackgroundResource(2130839259);
      return;
    }
    setBackgroundResource(2130839261);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null)
    {
      QLog.e("ColorNoteSmallScreenRelativeLayout", 1, "lottie loaded but still null");
      return;
    }
    QLog.d("ColorNoteSmallScreenRelativeLayout", 4, "play animation");
    float f1 = getContext().getResources().getDisplayMetrics().density / 2.0F;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setScale(f1, f1);
    if (a())
    {
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleX(f1);
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleY(f1);
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(-1);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      return;
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleX(f1);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleY(f1);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
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
    int i4 = j();
    boolean bool = lyu.i();
    int i1;
    int i2;
    if (i4 % 2 == 1)
    {
      i1 = bgtn.a();
      i2 = bgtn.b();
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
        if (this.jdField_a_of_type_Aqfo == null) {
          break label368;
        }
        i1 = this.jdField_a_of_type_Aqfo.a(this);
        this.m = i1;
        this.jdField_i_of_type_Int = i1;
        i1 = this.jdField_a_of_type_Aqfo.b(this);
        this.n = i1;
        this.jdField_j_of_type_Int = i1;
        this.jdField_a_of_type_Aqfo.a(this.jdField_b_of_type_AndroidGraphicsPoint, this.p);
      }
    }
    for (;;)
    {
      if (!this.jdField_e_of_type_Boolean) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      return;
      i2 = bgtn.a();
      i1 = bgtn.b();
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
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377659);
    if (!aqda.a(this.jdField_a_of_type_JavaUtilList, paramList)) {}
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
          f();
          return;
        }
        this.jdField_g_of_type_Boolean = true;
        paramList = localLinearLayout.animate();
        if (a()) {}
        for (float f1 = -localLinearLayout.getMeasuredWidth();; f1 = localLinearLayout.getMeasuredWidth())
        {
          paramList.translationX(f1).setDuration(200L).setListener(new aqfi(this, localLinearLayout)).start();
          return;
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
        f();
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
    if ((this.s == -1) && (this.jdField_a_of_type_Aqfo != null))
    {
      this.jdField_b_of_type_AndroidGraphicsPoint.x = this.jdField_a_of_type_Aqfo.a(this);
      this.jdField_b_of_type_AndroidGraphicsPoint.y = this.jdField_a_of_type_Aqfo.b(this);
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
    return (this.jdField_f_of_type_Boolean) || (aqda.a(this.jdField_a_of_type_JavaUtilList));
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
      if ((this.jdField_a_of_type_Aqfo != null) && (!this.jdField_d_of_type_Boolean)) {
        this.jdField_a_of_type_Aqfo.a(this, localPoint.x, localPoint.y, i1 + localPoint.x, i2 + localPoint.y);
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
    return ((b()) && (this.jdField_a_of_type_JavaUtilList.size() != 1)) || (aqda.a(this.jdField_a_of_type_JavaUtilList));
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
    i3 = this.jdField_k_of_type_Int;
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
        this.jdField_k_of_type_Int = i1;
        this.l = i2;
        if (this.jdField_a_of_type_Aqfo != null) {
          this.jdField_i_of_type_Int = this.jdField_a_of_type_Aqfo.a(this);
        }
        for (this.jdField_j_of_type_Int = this.jdField_a_of_type_Aqfo.b(this);; this.jdField_j_of_type_Int = getTop())
        {
          this.jdField_b_of_type_Boolean = false;
          return true;
          this.jdField_i_of_type_Int = getLeft();
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
    } while ((Math.abs(i1 - this.jdField_k_of_type_Int) <= this.jdField_b_of_type_Int) && (Math.abs(i2 - this.l) <= this.jdField_b_of_type_Int));
    this.jdField_h_of_type_Boolean = true;
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
      if (this.jdField_a_of_type_Aqfo == null) {
        break label428;
      }
      this.m = this.jdField_a_of_type_Aqfo.a(this);
    }
    for (this.n = this.jdField_a_of_type_Aqfo.b(this); !bool1; this.n = getTop())
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return true;
      long l1 = System.currentTimeMillis();
      bool1 = bool2;
      if (this.jdField_a_of_type_Aqfo == null) {
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
      paramMotionEvent = this.jdField_a_of_type_Aqfo;
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
    if (this.jdField_a_of_type_Aqfo != null) {
      this.m = this.jdField_a_of_type_Aqfo.a(this);
    }
    for (this.n = this.jdField_a_of_type_Aqfo.b(this);; this.n = getTop())
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
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    LinearLayout.LayoutParams localLayoutParams;
    int i1;
    if ((this.jdField_a_of_type_JavaUtilList.size() == 1) || (!b()))
    {
      this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        if (!a()) {
          break label143;
        }
        i1 = getResources().getDimensionPixelSize(2131298819);
        label84:
        localLayoutParams.width = i1;
        if (!b()) {
          break label179;
        }
        if (!a()) {
          break label157;
        }
        localLayoutParams.rightMargin = bggq.a(getContext(), 13.5F);
        localLayoutParams.leftMargin = 0;
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      h();
      return;
      this.jdField_c_of_type_Int = this.jdField_f_of_type_Int;
      break;
      label143:
      i1 = getResources().getDimensionPixelSize(2131298817);
      break label84;
      label157:
      localLayoutParams.leftMargin = bggq.a(getContext(), 14.5F);
      localLayoutParams.rightMargin = 0;
      continue;
      label179:
      if (a())
      {
        localLayoutParams.rightMargin = bggq.a(getContext(), 10.0F);
        localLayoutParams.leftMargin = 0;
      }
      else
      {
        localLayoutParams.leftMargin = bggq.a(getContext(), 10.0F);
        localLayoutParams.rightMargin = 0;
      }
    }
  }
  
  public int f()
  {
    if ((e()) || (this.jdField_h_of_type_Boolean)) {
      return this.jdField_e_of_type_Int;
    }
    QLog.d("ColorNoteSmallScreenRelativeLayout", 4, new Object[] { Boolean.valueOf(c()) });
    if ((c()) && (!this.jdField_j_of_type_Boolean))
    {
      QLog.d("ColorNoteSmallScreenRelativeLayout", 4, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) });
      return this.jdField_f_of_type_Int;
    }
    return this.jdField_e_of_type_Int;
  }
  
  public void f()
  {
    int i3 = 0;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Aqfo == null)) {}
    int i7;
    label104:
    label360:
    label380:
    do
    {
      return;
      this.jdField_f_of_type_Boolean = false;
      int i1 = 0;
      LinearLayout localLinearLayout;
      int i6;
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
        i7 = this.u;
        if (!b()) {
          break label266;
        }
        if (!aqda.a(this.jdField_a_of_type_JavaUtilList)) {
          break label230;
        }
        this.u = 4;
        localLinearLayout = (LinearLayout)findViewById(2131377659);
        localLinearLayout.removeAllViews();
        if (!this.jdField_f_of_type_Boolean) {
          break label274;
        }
        i1 = this.jdField_a_of_type_JavaUtilList.size() - 1;
        i6 = getResources().getDimensionPixelSize(2131298813);
        i2 = getResources().getDimensionPixelSize(2131298812);
        i4 = a(i1);
        if (i1 != 0) {
          break label287;
        }
        i2 = i6;
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
            if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() > 1))
            {
              this.u = 2;
              break label104;
            }
            this.u = 3;
            break label104;
            this.u = 1;
            break label104;
            i1 = this.jdField_a_of_type_JavaUtilList.size();
            break label140;
            i2 = (int)((i2 - i4 * 2) * 1.0F / i1 - a(i1));
            continue;
          }
          SmallColorNoteItem localSmallColorNoteItem = a((ColorNote)localObject, localLinearLayout);
          localSmallColorNoteItem.setAttachLeft(a());
          if (this.jdField_f_of_type_Boolean)
          {
            i4 = this.jdField_a_of_type_JavaUtilList.size() - 1;
            if (i4 <= 3) {
              break label484;
            }
            localSmallColorNoteItem.c();
            if (!this.jdField_f_of_type_Boolean) {
              break label512;
            }
            i4 = this.jdField_a_of_type_JavaUtilList.size() - 1;
            if (i4 <= 4) {
              break label526;
            }
            localSmallColorNoteItem.a();
            localSmallColorNoteItem.a(i2, i6);
            localObject = new LinearLayout.LayoutParams(-1, i2);
            i4 = (int)(a(i1) / 2.0F);
            if (i4 != 0) {
              break label534;
            }
          }
          for (int i5 = 1;; i5 = i4)
          {
            ((LinearLayout.LayoutParams)localObject).topMargin = i5;
            i5 = i4;
            if (i4 == 0) {
              i5 = 1;
            }
            ((LinearLayout.LayoutParams)localObject).bottomMargin = i5;
            localLinearLayout.addView(localSmallColorNoteItem.a(), -1, (ViewGroup.LayoutParams)localObject);
            break;
            i4 = this.jdField_a_of_type_JavaUtilList.size();
            break label349;
            localSmallColorNoteItem.d();
            localSmallColorNoteItem.setTitle(((ColorNote)localObject).mMainTitle);
            localSmallColorNoteItem.setSubTitle(((ColorNote)localObject).mSubTitle);
            break label360;
            i4 = this.jdField_a_of_type_JavaUtilList.size();
            break label380;
            localSmallColorNoteItem.b();
            break label391;
          }
        }
      }
    } while (i7 == this.u);
    label140:
    label230:
    b(this.u, i7);
    label266:
    label274:
    label287:
    label349:
    label484:
    return;
  }
  
  public int g()
  {
    if (a()) {
      return -this.o;
    }
    QLog.d("ColorNoteSmallScreenRelativeLayout", 4, new Object[] { Integer.valueOf(f()) });
    return this.q - f() + this.o;
  }
  
  public void g()
  {
    boolean bool = a();
    if ((this.jdField_a_of_type_Aqfy != null) && (this.jdField_a_of_type_Aqfy.a() == 2)) {
      return;
    }
    if (bool)
    {
      j();
      return;
    }
    k();
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
          setBackgroundResource(2130839256);
          label177:
          if (this.jdField_a_of_type_Aqfo != null) {
            this.jdField_a_of_type_Aqfo.a(this.jdField_b_of_type_AndroidGraphicsPoint, this.p);
          }
          this.jdField_e_of_type_Boolean = false;
          if (this.jdField_b_of_type_AndroidGraphicsPoint.y <= this.r / 2) {
            break label439;
          }
          bcst.b(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 2, 0, "", "", "", "");
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
      setBackgroundResource(2130839259);
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
        this.jdField_k_of_type_Boolean = true;
        a(this, this.jdField_b_of_type_AndroidGraphicsPoint.x, this.jdField_b_of_type_AndroidGraphicsPoint.y, i1 + i4, this.jdField_b_of_type_AndroidGraphicsPoint.y + i3);
        if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
          break label429;
        }
        setBackgroundResource(2130839258);
        break;
      }
      label429:
      setBackgroundResource(2130839261);
      break label177;
      label439:
      bcst.b(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 1, 0, "", "", "", "");
      continue;
      if (paramAnimator == this.jdField_b_of_type_AndroidAnimationValueAnimator)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          setVisibility(8);
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "onAnimationEnd setVisibility(GONE)");
          }
          if (this.jdField_a_of_type_Aqfo != null) {
            this.jdField_a_of_type_Aqfo.a(this);
          }
        }
      }
      else if (paramAnimator == this.jdField_c_of_type_AndroidAnimationValueAnimator)
      {
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
        }
        i1 = this.jdField_c_of_type_Int / 2;
        paramAnimator = this.jdField_b_of_type_AndroidGraphicsPoint;
        if (((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() != 1)) || (aqda.a(this.jdField_a_of_type_JavaUtilList))) {
          i1 = 0;
        }
        paramAnimator.x = g();
        i2 = e();
        this.jdField_c_of_type_Int = i2;
        i3 = this.jdField_d_of_type_Int;
        if (paramAnimator.x <= 0)
        {
          if (this.jdField_a_of_type_Aqfo != null) {
            this.jdField_a_of_type_Aqfo.a(this, paramAnimator.x, paramAnimator.y, i2 + paramAnimator.x + i1, i3 + paramAnimator.y, i1, true);
          }
        }
        else if (this.jdField_a_of_type_Aqfo != null) {
          this.jdField_a_of_type_Aqfo.a(this, paramAnimator.x - i1, paramAnimator.y, i2 + paramAnimator.x - i1, i3 + paramAnimator.y, -i1, true);
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
        this.jdField_k_of_type_Boolean = false;
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
      if (this.jdField_a_of_type_Aqfo != null) {
        this.jdField_a_of_type_Aqfo.a(this, i1, i2, i1 + i3, i4 + i2);
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
        } while (((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() != 1)) || (aqda.a(this.jdField_a_of_type_JavaUtilList)));
        i1 = (int)(f1 * (this.jdField_c_of_type_Int / 2));
        this.jdField_b_of_type_AndroidGraphicsPoint.x = g();
        paramValueAnimator = this.jdField_b_of_type_AndroidGraphicsPoint;
        i2 = e();
        this.jdField_c_of_type_Int = i2;
        i3 = this.jdField_d_of_type_Int;
        if (paramValueAnimator.x > 0) {
          break;
        }
      } while (this.jdField_a_of_type_Aqfo == null);
      this.jdField_a_of_type_Aqfo.a(this, paramValueAnimator.x, paramValueAnimator.y, i2 + paramValueAnimator.x + i1, i3 + paramValueAnimator.y, i1, false);
      return;
    } while (this.jdField_a_of_type_Aqfo == null);
    this.jdField_a_of_type_Aqfo.a(this, paramValueAnimator.x - i1, paramValueAnimator.y, i2 + paramValueAnimator.x - i1, i3 + paramValueAnimator.y, -i1, false);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    a();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377658));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377659));
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131369197));
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131369198));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365717));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.q == 0) || (this.r == 0))
    {
      this.q = bgtn.a();
      this.r = bgtn.b();
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
        if (this.jdField_a_of_type_Aqfo == null) {
          break;
        }
        this.jdField_a_of_type_Aqfo.a(this, paramPoint.x, paramPoint.y, paramPoint.x + i1, i2 + paramPoint.y);
      }
      return;
    }
    layout(paramPoint.x, paramPoint.y, i1 + paramPoint.x, paramPoint.y + i2);
  }
  
  public void setCustomNightMode(boolean paramBoolean)
  {
    jdField_i_of_type_Boolean = paramBoolean;
    o();
  }
  
  public void setFloatListener(aqfo paramaqfo)
  {
    this.jdField_a_of_type_Aqfo = paramaqfo;
  }
  
  public void setShouldMaxRootView(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setUpcomingController(aqfy paramaqfy)
  {
    this.jdField_a_of_type_Aqfy = paramaqfy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
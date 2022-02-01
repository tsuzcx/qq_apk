package com.tencent.mobileqq.colornote.smallscreen;

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
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.anim.FloatingWindowDrawable;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.anim.MusicDanceImageView;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.list.DefaultItemBuilder;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ColorNoteSmallScreenRelativeLayout
  extends RelativeLayout
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, IFloatingView
{
  private static float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 3.0F, 2.0F, 2.5F, 2.0F };
  private static int[] jdField_a_of_type_ArrayOfInt = { 0, 9, 5, 3 };
  private static boolean jdField_i_of_type_Boolean = false;
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point(0, 0);
  private Display jdField_a_of_type_AndroidViewDisplay;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private FloatingWindowDrawable jdField_a_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable;
  private MusicDanceImageView jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView;
  private ColorNoteSmallScreenRelativeLayout.CheckForLongPress jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress = new ColorNoteSmallScreenRelativeLayout.CheckForLongPress(this, null);
  private ColorNoteSmallScreenRelativeLayout.FloatListener jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
  private ColorNoteSmallScreenRelativeLayout.SmallScreenOrientationEventListener jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$SmallScreenOrientationEventListener = null;
  private IUpcomingController jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenIUpcomingController;
  private Cancellable jdField_a_of_type_ComTencentMobileqqDiniflyCancellable;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
  private boolean jdField_a_of_type_Boolean = false;
  private final int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private Point jdField_b_of_type_AndroidGraphicsPoint = new Point();
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private FloatingWindowDrawable jdField_b_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable;
  private MusicDanceImageView jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private ValueAnimator jdField_c_of_type_AndroidAnimationValueAnimator;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = -1;
  private int jdField_j_of_type_Int = -1;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int = -1;
  private boolean jdField_k_of_type_Boolean = false;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  private int o = -1;
  private int p = 0;
  private int q = 0;
  private int r = 0;
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
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131296702);
    this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131296701);
    paramInt = this.jdField_c_of_type_Int;
    this.jdField_e_of_type_Int = paramInt;
    double d1 = paramInt;
    Double.isNaN(d1);
    this.jdField_f_of_type_Int = ((int)(d1 * 1.5D));
    this.jdField_g_of_type_Int = (paramInt * 2);
    this.jdField_h_of_type_Int = this.jdField_f_of_type_Int;
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131297977);
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
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$SmallScreenOrientationEventListener = new ColorNoteSmallScreenRelativeLayout.SmallScreenOrientationEventListener(this, getContext(), 2);
    this.r = ViewUtils.b();
    this.q = ViewUtils.a();
    this.o = Utils.a(8.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377674));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365883));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377673));
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131369424));
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131369425));
  }
  
  private float a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 9)) {}
    for (paramInt = DisplayUtil.a(getContext(), jdField_a_of_type_ArrayOfFloat[paramInt]);; paramInt = getResources().getDimensionPixelSize(2131298988)) {
      return paramInt;
    }
  }
  
  private int a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 4)) {
      return DisplayUtil.a(getContext(), jdField_a_of_type_ArrayOfInt[paramInt]);
    }
    return DisplayUtil.a(getContext(), 4.0F);
  }
  
  private SmallColorNoteItem a(ColorNote paramColorNote, ViewGroup paramViewGroup)
  {
    paramViewGroup = new SmallColorNoteItem(getContext(), a(), paramViewGroup);
    paramViewGroup.setAttachLeft(a());
    View localView = paramViewGroup.a().findViewById(2131371964);
    ImageView localImageView = (ImageView)paramViewGroup.a().findViewById(2131371965);
    new DefaultItemBuilder().a(paramColorNote, localView, localImageView, a());
    paramColorNote = localView.findViewById(2131371975);
    localView = localView.findViewById(2131371973);
    ViewCompat.setImportantForAccessibility(paramViewGroup, 2);
    ViewCompat.setImportantForAccessibility(paramColorNote, 2);
    ViewCompat.setImportantForAccessibility(localView, 2);
    paramColorNote = (RelativeLayout.LayoutParams)findViewById(2131367052).getLayoutParams();
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
    if (paramInt1 > i1) {
      paramInt2 = i1;
    } else {
      paramInt2 = paramInt1;
    }
    paramInt1 = i4;
    if (i4 < 0) {
      paramInt1 = 0;
    }
    if (paramInt1 > i3) {
      paramInt1 = i3;
    }
    if (((paramInt2 > i2) && (paramInt2 < i1)) || (this.jdField_h_of_type_Boolean))
    {
      this.t = this.s;
      this.s = 2;
      i1 = e();
      this.jdField_c_of_type_Int = i1;
      i2 = this.jdField_d_of_type_Int;
      a(this, paramInt2, paramInt1, paramInt2 + i1, paramInt1 + i2);
      i3 = this.t;
      i4 = this.s;
      if (i3 != i4) {
        a(i4, i3, paramInt2, paramInt1, i1, i2, false);
      }
      if (QQTheme.a())
      {
        setBackgroundResource(2130839252);
        return;
      }
      setBackgroundResource(2130839255);
      return;
    }
    if (paramInt2 == i2)
    {
      this.t = this.s;
      this.s = 0;
      i1 = this.t;
      i2 = this.s;
      if (i1 != i2) {
        a(i2, i1, paramInt2, paramInt1, i6, i7);
      }
      a(this, paramInt2, paramInt1, paramInt2 + i6, paramInt1 + i7);
      if (QQTheme.a())
      {
        setBackgroundResource(2130839251);
        return;
      }
      setBackgroundResource(2130839254);
      return;
    }
    if (paramInt2 == i1)
    {
      this.t = this.s;
      this.s = 1;
      this.jdField_k_of_type_Boolean = false;
      i1 = this.t;
      i2 = this.s;
      if (i1 != i2) {
        a(i2, i1, paramInt2, paramInt1, i6, i7);
      }
      a(this, paramInt2, paramInt1, paramInt2 + i6, paramInt1 + i7);
      if (QQTheme.a())
      {
        setBackgroundResource(2130839253);
        return;
      }
      setBackgroundResource(2130839256);
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
      Point localPoint = this.jdField_b_of_type_AndroidGraphicsPoint;
      localPoint.x = paramInt3;
      localPoint.y = paramInt4;
      if (localPoint.x < 0) {
        paramInt2 = 0;
      } else {
        paramInt2 = 1;
      }
      this.s = paramInt2;
    }
    if (paramInt1 == 0)
    {
      if (b()) {
        j();
      } else {
        i();
      }
      n();
      return;
    }
    if (paramInt1 == 1)
    {
      if (b()) {
        k();
      } else {
        i();
      }
      n();
      return;
    }
    if (paramInt1 == 2) {
      m();
    }
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
    ColorNoteSmallScreenRelativeLayout.FloatListener localFloatListener = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
    if (localFloatListener != null)
    {
      localFloatListener.a(paramColorNoteSmallScreenRelativeLayout, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    MusicDanceDrawable localMusicDanceDrawable;
    if (paramInt == 1) {
      localMusicDanceDrawable = new MusicDanceDrawable();
    } else {
      localMusicDanceDrawable = null;
    }
    if (localMusicDanceDrawable == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable = localMusicDanceDrawable;
      localMusicDanceDrawable.a(getContext(), DisplayUtil.a(getContext(), 15.0F), DisplayUtil.a(getContext(), 9.5F), getContext().getResources().getColor(2131165503));
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable((Drawable)localMusicDanceDrawable);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable = localMusicDanceDrawable;
    localMusicDanceDrawable.a(getContext(), DisplayUtil.a(getContext(), 15.0F), DisplayUtil.a(getContext(), 9.5F), getContext().getResources().getColor(2131165503));
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable((Drawable)localMusicDanceDrawable);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.v = paramInt2;
    if (paramInt1 == 1)
    {
      i();
      return;
    }
    if ((paramInt1 == 3) || (paramInt1 == 2) || (paramInt1 == 4))
    {
      if (a())
      {
        j();
        return;
      }
      this.jdField_k_of_type_Boolean = true;
      k();
    }
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
    } else if (k() == 1) {
      i1 = e() + i2;
    }
    int i3 = this.jdField_b_of_type_AndroidGraphicsPoint.y;
    int i4 = i3 + this.jdField_d_of_type_Int;
    ColorNoteSmallScreenRelativeLayout.FloatListener localFloatListener = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
    if (localFloatListener != null)
    {
      localFloatListener.a(this, i2, i3, i1, i4);
      return;
    }
    layout(i2, i3, i1, i4);
  }
  
  private void i()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377674);
    this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    if (a()) {
      i1 = getResources().getDimensionPixelSize(2131298993);
    } else {
      i1 = getResources().getDimensionPixelSize(2131298991);
    }
    localLayoutParams1.width = i1;
    boolean bool = a();
    int i1 = 0;
    if (bool)
    {
      localLayoutParams1.rightMargin = DisplayUtil.a(localLinearLayout.getContext(), 10.0F);
      localLayoutParams1.leftMargin = 0;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
    }
    else
    {
      localLayoutParams1.leftMargin = DisplayUtil.a(localLinearLayout.getContext(), 10.0F);
      localLayoutParams1.rightMargin = 0;
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(9);
    }
    localLinearLayout.setLayoutParams(localLayoutParams1);
    localLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getViewTreeObserver().addOnGlobalLayoutListener(new ColorNoteSmallScreenRelativeLayout.2(this));
    this.jdField_b_of_type_AndroidGraphicsPoint.x = g();
    if (this.jdField_b_of_type_AndroidGraphicsPoint.x >= 0) {
      i1 = 1;
    }
    this.s = i1;
    if (this.v != 2) {
      h();
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
      QLog.e("ColorNoteSmallScreenRelativeLayout", 1, new Object[] { "[getSysRotation]", localException.getMessage() });
    }
    return 0;
  }
  
  private void j()
  {
    if (!b()) {
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377674);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getLayoutParams();
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleX(1.0F);
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleY(1.0F);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    if (ColorNoteUtils.a(this.jdField_a_of_type_JavaUtilList))
    {
      a(getContext(), "colornote/data.json", "colornote/images", false);
    }
    else
    {
      a(true, 1);
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable = new MusicDanceDrawable();
        this.jdField_a_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable.a(getContext(), DisplayUtil.a(getContext(), 15.0F), DisplayUtil.a(getContext(), 9.5F), getContext().getResources().getColor(2131165503));
      }
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable((Drawable)this.jdField_a_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable.a(300);
      FloatingWindowDrawable localFloatingWindowDrawable = this.jdField_b_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable;
      if (localFloatingWindowDrawable != null) {
        localFloatingWindowDrawable.stop();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
    localLayoutParams.rightMargin = DisplayUtil.a(getContext(), 13.5F);
    if ((this.jdField_a_of_type_JavaUtilList.size() == 1) && (this.jdField_f_of_type_Boolean))
    {
      localLinearLayout.setVisibility(8);
      this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      localLayoutParams.rightMargin = DisplayUtil.a(getContext(), 17.5F);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
      this.jdField_c_of_type_Int = this.jdField_f_of_type_Int;
      localLinearLayout.setVisibility(0);
      localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLinearLayout.setGravity(16);
      ((LinearLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131298993);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      if (a())
      {
        ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(getContext(), 13.5F);
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      }
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      f();
    }
    h();
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
    Object localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    int i1;
    if ((this.jdField_k_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() > 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377674);
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable;
    if (localObject2 != null) {
      ((FloatingWindowDrawable)localObject2).stop();
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleX(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleY(1.0F);
    localObject2 = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getLayoutParams();
    if (i1 == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(0);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = DisplayUtil.a(getContext(), 13.5F);
    }
    int i2;
    if (ColorNoteUtils.a(this.jdField_a_of_type_JavaUtilList))
    {
      a(getContext(), "colornote/data.json", "colornote/images", false);
      i2 = 0;
    }
    else
    {
      a(false, 1);
      i2 = 1;
    }
    if (i2 != 0)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable = new MusicDanceDrawable();
        this.jdField_b_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable.a(getContext(), DisplayUtil.a(getContext(), 15.0F), DisplayUtil.a(getContext(), 9.5F), getContext().getResources().getColor(2131165503));
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable((Drawable)this.jdField_b_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable);
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimFloatingWindowDrawable.a(300);
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() == 1) && (this.jdField_f_of_type_Boolean))
    {
      localLinearLayout.setVisibility(8);
      this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject1).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = DisplayUtil.a(getContext(), 17.5F);
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(9);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13, 0);
      this.jdField_c_of_type_Int = this.jdField_f_of_type_Int;
      localLinearLayout.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      if (i1 == 0)
      {
        ((LinearLayout.LayoutParams)localObject1).width = getResources().getDimensionPixelSize(2131298991);
        if (!a())
        {
          ((LinearLayout.LayoutParams)localObject1).leftMargin = DisplayUtil.a(getContext(), 14.5F);
          ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        }
        localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    if (i1 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getViewTreeObserver().addOnPreDrawListener(new ColorNoteSmallScreenRelativeLayout.3(this));
    }
    if (i1 != 0)
    {
      l();
      return;
    }
    h();
  }
  
  private void l()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(100L);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    int i1 = localLayoutParams.leftMargin;
    Point localPoint = this.jdField_b_of_type_AndroidGraphicsPoint;
    localPoint.x = (this.q - this.jdField_e_of_type_Int + this.o);
    localValueAnimator.addUpdateListener(new ColorNoteSmallScreenRelativeLayout.4(this, this, localPoint, localLayoutParams, i1));
    localValueAnimator.addListener(new ColorNoteSmallScreenRelativeLayout.5(this));
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
    if ((!QQTheme.a()) && (!jdField_i_of_type_Boolean))
    {
      if (this.jdField_b_of_type_AndroidGraphicsPoint.x <= 0)
      {
        setBackgroundResource(2130839254);
        return;
      }
      setBackgroundResource(2130839256);
      return;
    }
    if (this.jdField_b_of_type_AndroidGraphicsPoint.x <= 0)
    {
      setBackgroundResource(2130839251);
      return;
    }
    setBackgroundResource(2130839253);
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
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleX(f1);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleY(f1);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(-1);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
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
    boolean bool = ColorNoteSmallScreenUtil.a();
    int i2;
    if (i4 % 2 == 1)
    {
      i1 = ViewUtils.a();
      i2 = ViewUtils.b();
    }
    else
    {
      i2 = ViewUtils.a();
      i1 = ViewUtils.b();
    }
    int i3 = i1;
    if (bool) {
      i3 = i1 - this.jdField_a_of_type_Int;
    }
    int i1 = this.p;
    if ((i1 != i4) || (i2 != this.q) || ((i4 == 0) && (this.r < i3)) || ((i4 != 0) && (this.r != i3)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onOrientationChangedInner, mPosition[");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append("], mRotation[");
        ((StringBuilder)localObject).append(this.p);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(i4);
        ((StringBuilder)localObject).append("], mScreenWidth[");
        ((StringBuilder)localObject).append(this.q);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append("], mScreenHeight[");
        ((StringBuilder)localObject).append(this.r);
        ((StringBuilder)localObject).append("->");
        ((StringBuilder)localObject).append(i3);
        ((StringBuilder)localObject).append("], mIsInit[");
        ((StringBuilder)localObject).append(this.jdField_e_of_type_Boolean);
        ((StringBuilder)localObject).append("]");
        QLog.w("ColorNoteSmallScreenRelativeLayout", 1, ((StringBuilder)localObject).toString());
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
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
      if (localObject != null)
      {
        i1 = ((ColorNoteSmallScreenRelativeLayout.FloatListener)localObject).a(this);
        this.m = i1;
        this.jdField_i_of_type_Int = i1;
        i1 = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener.b(this);
        this.n = i1;
        this.jdField_j_of_type_Int = i1;
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener.a(this.jdField_b_of_type_AndroidGraphicsPoint, this.p);
      }
      else
      {
        i1 = getLeft();
        this.m = i1;
        this.jdField_i_of_type_Int = i1;
        i1 = getTop();
        this.n = i1;
        this.jdField_j_of_type_Int = i1;
      }
      if (!this.jdField_e_of_type_Boolean) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
    }
  }
  
  public void a(List<ColorNote> paramList)
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377674);
    boolean bool = ColorNoteUtils.a(this.jdField_a_of_type_JavaUtilList, paramList);
    if ((localLinearLayout != null) && (paramList.size() > 0))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      int i4 = 0;
      int i2;
      if (localObject == null) {
        i2 = 0;
      } else {
        i2 = ((List)localObject).size();
      }
      if ((!this.jdField_g_of_type_Boolean) && ((bool ^ true)))
      {
        localObject = paramList.iterator();
        int i1 = 0;
        int i3 = 0;
        while (((Iterator)localObject).hasNext())
        {
          ColorNote localColorNote = (ColorNote)((Iterator)localObject).next();
          if (localColorNote.getServiceType() == 16973824) {
            if (localColorNote.animate)
            {
              localColorNote.animate = false;
              i1 = 1;
              i3 = 1;
            }
            else
            {
              i1 = 1;
            }
          }
        }
        int i5 = 0;
        while (i4 < i2)
        {
          if (((ColorNote)this.jdField_a_of_type_JavaUtilList.get(i4)).getServiceType() == 16973824) {
            i5 = 1;
          }
          i4 += 1;
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
        if (((i3 != 0) || ((i1 == 0) && (i5 != 0))) && (Math.abs(paramList.size() - i2) == 1))
        {
          f();
          return;
        }
        this.jdField_g_of_type_Boolean = true;
        paramList = localLinearLayout.animate();
        if (a()) {
          i1 = -localLinearLayout.getMeasuredWidth();
        } else {
          i1 = localLinearLayout.getMeasuredWidth();
        }
        paramList.translationX(i1).setDuration(200L).setListener(new ColorNoteSmallScreenRelativeLayout.1(this, localLinearLayout)).start();
        return;
      }
      this.jdField_a_of_type_JavaUtilList = paramList;
      f();
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    f();
  }
  
  public boolean a()
  {
    if (this.s == -1)
    {
      ColorNoteSmallScreenRelativeLayout.FloatListener localFloatListener = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
      if (localFloatListener != null)
      {
        this.jdField_b_of_type_AndroidGraphicsPoint.x = localFloatListener.a(this);
        this.jdField_b_of_type_AndroidGraphicsPoint.y = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener.b(this);
        int i1;
        if (this.jdField_b_of_type_AndroidGraphicsPoint.x < 0) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        this.s = i1;
      }
    }
    if ((this.s == 0) && (this.jdField_b_of_type_AndroidGraphicsPoint.x > 0) && (QLog.isColorLevel())) {
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "state is STATE_LEFT, but mPoint.x grater than 0");
    }
    return this.s == 0;
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
    return (this.jdField_f_of_type_Boolean) || (ColorNoteUtils.a(this.jdField_a_of_type_JavaUtilList));
  }
  
  public int c()
  {
    return this.q;
  }
  
  public void c()
  {
    if ((this.q != 0) && (this.r != 0))
    {
      Point localPoint = this.jdField_b_of_type_AndroidGraphicsPoint;
      int i1 = e();
      this.jdField_c_of_type_Int = i1;
      int i2 = this.jdField_d_of_type_Int;
      ColorNoteSmallScreenRelativeLayout.FloatListener localFloatListener = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
      if ((localFloatListener != null) && (!this.jdField_d_of_type_Boolean))
      {
        localFloatListener.a(this, localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i2);
        return;
      }
      layout(localPoint.x, localPoint.y, localPoint.x + i1, localPoint.y + i2);
    }
  }
  
  public boolean c()
  {
    boolean bool2 = b();
    boolean bool1 = true;
    if ((!bool2) || (this.jdField_a_of_type_JavaUtilList.size() == 1))
    {
      if (ColorNoteUtils.a(this.jdField_a_of_type_JavaUtilList)) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
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
    int i1 = (int)paramMotionEvent.getRawX();
    int i2 = (int)paramMotionEvent.getRawY();
    int i3 = this.jdField_i_of_type_Int;
    i3 = this.jdField_k_of_type_Int;
    i3 = this.jdField_j_of_type_Int;
    i3 = this.l;
    if (this.jdField_d_of_type_Boolean) {
      return true;
    }
    i3 = paramMotionEvent.getAction();
    boolean bool3 = false;
    boolean bool2 = false;
    if (i3 != 0)
    {
      if (i3 != 1)
      {
        if (i3 != 2)
        {
          if (i3 != 3) {
            return true;
          }
          this.jdField_h_of_type_Boolean = false;
          this.jdField_c_of_type_Boolean = false;
          if (this.jdField_b_of_type_Boolean)
          {
            a(i1, i2);
            this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress);
          }
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
          if (paramMotionEvent != null)
          {
            this.m = paramMotionEvent.a(this);
            this.n = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener.b(this);
          }
          else
          {
            this.m = getLeft();
            this.n = getTop();
          }
          this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          return true;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          a(i1, i2);
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress);
          return true;
        }
        if ((Math.abs(i1 - this.jdField_k_of_type_Int) > this.jdField_b_of_type_Int) || (Math.abs(i2 - this.l) > this.jdField_b_of_type_Int))
        {
          this.jdField_h_of_type_Boolean = true;
          this.jdField_b_of_type_Boolean = true;
          return true;
        }
      }
      else
      {
        this.jdField_h_of_type_Boolean = false;
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress);
        boolean bool1;
        if (this.jdField_b_of_type_Boolean)
        {
          a(i1, i2);
          bool1 = bool3;
        }
        else
        {
          long l1 = System.currentTimeMillis();
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
          bool1 = bool3;
          if (paramMotionEvent != null)
          {
            bool1 = bool3;
            if (!this.jdField_c_of_type_Boolean)
            {
              bool1 = bool3;
              if (l1 - this.jdField_a_of_type_Long > 600L)
              {
                Point localPoint = this.jdField_b_of_type_AndroidGraphicsPoint;
                bool1 = bool2;
                if (this.p == 0) {
                  bool1 = true;
                }
                bool1 = paramMotionEvent.a(localPoint, bool1);
                this.jdField_a_of_type_Long = l1;
              }
            }
          }
        }
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
        if (paramMotionEvent != null)
        {
          this.m = paramMotionEvent.a(this);
          this.n = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener.b(this);
        }
        else
        {
          this.m = getLeft();
          this.n = getTop();
        }
        if (!bool1)
        {
          this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
          return true;
        }
      }
    }
    else
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_k_of_type_Int = i1;
      this.l = i2;
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
      if (paramMotionEvent != null)
      {
        this.jdField_i_of_type_Int = paramMotionEvent.a(this);
        this.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener.b(this);
      }
      else
      {
        this.jdField_i_of_type_Int = getLeft();
        this.jdField_j_of_type_Int = getTop();
      }
      this.jdField_b_of_type_Boolean = false;
    }
    return true;
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
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      if ((this.jdField_a_of_type_JavaUtilList.size() != 1) && (b())) {
        this.jdField_c_of_type_Int = this.jdField_f_of_type_Int;
      } else {
        this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      }
      if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
      {
        localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        int i1;
        if (a()) {
          i1 = getResources().getDimensionPixelSize(2131298993);
        } else {
          i1 = getResources().getDimensionPixelSize(2131298991);
        }
        ((LinearLayout.LayoutParams)localObject).width = i1;
        if (b())
        {
          if (a())
          {
            ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(getContext(), 13.5F);
            ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
          }
          else
          {
            ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(getContext(), 14.5F);
            ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
          }
        }
        else if (a())
        {
          ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(getContext(), 10.0F);
          ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        }
        else
        {
          ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(getContext(), 10.0F);
          ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        }
      }
      this.jdField_c_of_type_Boolean = false;
      h();
    }
  }
  
  public int f()
  {
    if ((!e()) && (!this.jdField_h_of_type_Boolean))
    {
      QLog.d("ColorNoteSmallScreenRelativeLayout", 4, new Object[] { Boolean.valueOf(c()) });
      if ((c()) && (!this.jdField_j_of_type_Boolean))
      {
        QLog.d("ColorNoteSmallScreenRelativeLayout", 4, new Object[] { Integer.valueOf(this.jdField_f_of_type_Int) });
        return this.jdField_f_of_type_Int;
      }
      return this.jdField_e_of_type_Int;
    }
    return this.jdField_e_of_type_Int;
  }
  
  public void f()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener == null) {
        return;
      }
      int i3 = 0;
      this.jdField_f_of_type_Boolean = false;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((ColorNote)this.jdField_a_of_type_JavaUtilList.get(i1)).mServiceType == 16973824)
        {
          this.jdField_f_of_type_Boolean = true;
          break;
        }
        i1 += 1;
      }
      int i7 = this.u;
      if (b())
      {
        if (ColorNoteUtils.a(this.jdField_a_of_type_JavaUtilList)) {
          this.u = 4;
        } else if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() > 1)) {
          this.u = 2;
        } else {
          this.u = 3;
        }
      }
      else {
        this.u = 1;
      }
      localObject1 = (LinearLayout)findViewById(2131377674);
      ((LinearLayout)localObject1).removeAllViews();
      if (this.jdField_f_of_type_Boolean) {
        i1 = this.jdField_a_of_type_JavaUtilList.size() - 1;
      } else {
        i1 = this.jdField_a_of_type_JavaUtilList.size();
      }
      int i6 = getResources().getDimensionPixelSize(2131298987);
      int i2 = getResources().getDimensionPixelSize(2131298986);
      int i4 = a(i1);
      if (i1 == 0) {
        i2 = i6;
      } else {
        i2 = (int)((i2 - i4 * 2) * 1.0F / i1 - a(i1));
      }
      while (i3 < this.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject2 = (ColorNote)this.jdField_a_of_type_JavaUtilList.get(i3);
        if (((ColorNote)localObject2).mServiceType != 16973824)
        {
          SmallColorNoteItem localSmallColorNoteItem = a((ColorNote)localObject2, (ViewGroup)localObject1);
          localSmallColorNoteItem.setAttachLeft(a());
          if (this.jdField_f_of_type_Boolean) {
            i4 = this.jdField_a_of_type_JavaUtilList.size() - 1;
          } else {
            i4 = this.jdField_a_of_type_JavaUtilList.size();
          }
          if (i4 > 3)
          {
            localSmallColorNoteItem.c();
          }
          else
          {
            localSmallColorNoteItem.d();
            localSmallColorNoteItem.setTitle(((ColorNote)localObject2).mMainTitle);
            localSmallColorNoteItem.setSubTitle(((ColorNote)localObject2).mSubTitle);
          }
          if (this.jdField_f_of_type_Boolean) {
            i4 = this.jdField_a_of_type_JavaUtilList.size() - 1;
          } else {
            i4 = this.jdField_a_of_type_JavaUtilList.size();
          }
          if (i4 > 4) {
            localSmallColorNoteItem.a();
          } else {
            localSmallColorNoteItem.b();
          }
          localSmallColorNoteItem.a(i2, i6);
          localObject2 = new LinearLayout.LayoutParams(-1, i2);
          i4 = (int)(a(i1) / 2.0F);
          if (i4 == 0) {
            i5 = 1;
          } else {
            i5 = i4;
          }
          ((LinearLayout.LayoutParams)localObject2).topMargin = i5;
          int i5 = i4;
          if (i4 == 0) {
            i5 = 1;
          }
          ((LinearLayout.LayoutParams)localObject2).bottomMargin = i5;
          ((LinearLayout)localObject1).addView(localSmallColorNoteItem.a(), -1, (ViewGroup.LayoutParams)localObject2);
        }
        i3 += 1;
      }
      i1 = this.u;
      if (i7 != i1) {
        b(i1, i7);
      }
    }
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
    IUpcomingController localIUpcomingController = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenIUpcomingController;
    if ((localIUpcomingController != null) && (localIUpcomingController.a() == 2)) {
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
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    int i1 = 1;
    int i2;
    int i3;
    if (paramAnimator == localObject)
    {
      paramAnimator = this.jdField_a_of_type_AndroidGraphicsPoint;
      i2 = e();
      this.jdField_c_of_type_Int = i2;
      i3 = this.jdField_d_of_type_Int;
      this.jdField_b_of_type_AndroidGraphicsPoint = paramAnimator;
      int i4;
      int i5;
      int i6;
      if ((paramAnimator.x > 0) && (k() != 0))
      {
        this.t = this.s;
        this.s = 1;
        this.jdField_b_of_type_AndroidGraphicsPoint.x = g();
        if (this.jdField_b_of_type_AndroidGraphicsPoint.x < 0) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        this.s = i1;
        i1 = g();
        i4 = e();
        i5 = this.t;
        i6 = this.s;
        if (i5 != i6) {
          a(i6, i5, this.jdField_b_of_type_AndroidGraphicsPoint.x, this.jdField_b_of_type_AndroidGraphicsPoint.y, i2, i3);
        }
        this.jdField_k_of_type_Boolean = true;
        a(this, this.jdField_b_of_type_AndroidGraphicsPoint.x, this.jdField_b_of_type_AndroidGraphicsPoint.y, i1 + i4, this.jdField_b_of_type_AndroidGraphicsPoint.y + i3);
        if (QQTheme.a()) {
          setBackgroundResource(2130839253);
        } else {
          setBackgroundResource(2130839256);
        }
      }
      else
      {
        this.t = this.s;
        this.s = 0;
        this.jdField_b_of_type_AndroidGraphicsPoint.x = g();
        if (this.jdField_b_of_type_AndroidGraphicsPoint.x < 0) {
          i1 = 0;
        }
        this.s = i1;
        i1 = g();
        i4 = e();
        i5 = this.t;
        i6 = this.s;
        if (i5 != i6) {
          a(i6, i5, i1, this.jdField_b_of_type_AndroidGraphicsPoint.y, i2, i3);
        }
        a(this, i1, this.jdField_b_of_type_AndroidGraphicsPoint.y, i1 + i4, this.jdField_b_of_type_AndroidGraphicsPoint.y + i3);
        if (QQTheme.a()) {
          setBackgroundResource(2130839251);
        } else {
          setBackgroundResource(2130839254);
        }
      }
      paramAnimator = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
      if (paramAnimator != null) {
        paramAnimator.a(this.jdField_b_of_type_AndroidGraphicsPoint, this.p);
      }
      this.jdField_e_of_type_Boolean = false;
      if (this.jdField_b_of_type_AndroidGraphicsPoint.y > this.r / 2) {
        ReportController.b(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 2, 0, "", "", "", "");
      } else {
        ReportController.b(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 1, 0, "", "", "", "");
      }
    }
    else if (paramAnimator == this.jdField_b_of_type_AndroidAnimationValueAnimator)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "onAnimationEnd setVisibility(GONE)");
        }
        paramAnimator = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
        if (paramAnimator != null) {
          paramAnimator.a(this);
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
      if (((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() != 1)) || (ColorNoteUtils.a(this.jdField_a_of_type_JavaUtilList))) {
        i1 = 0;
      }
      paramAnimator.x = g();
      i2 = e();
      this.jdField_c_of_type_Int = i2;
      i3 = this.jdField_d_of_type_Int;
      if (paramAnimator.x <= 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
        if (localObject != null) {
          ((ColorNoteSmallScreenRelativeLayout.FloatListener)localObject).a(this, paramAnimator.x, paramAnimator.y, paramAnimator.x + i2 + i1, paramAnimator.y + i3, i1, true);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
        if (localObject != null) {
          ((ColorNoteSmallScreenRelativeLayout.FloatListener)localObject).a(this, paramAnimator.x - i1, paramAnimator.y, paramAnimator.x + i2 - i1, paramAnimator.y + i3, -i1, true);
        }
      }
    }
    f();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (paramAnimator == this.jdField_a_of_type_AndroidAnimationValueAnimator)
    {
      if (this.m + e() / 2 < this.q / 2) {
        this.jdField_a_of_type_AndroidGraphicsPoint.x = (-this.o);
      } else {
        this.jdField_a_of_type_AndroidGraphicsPoint.x = i();
      }
      this.jdField_a_of_type_AndroidGraphicsPoint.y = this.n;
      this.jdField_k_of_type_Boolean = false;
      return;
    }
    if ((paramAnimator == this.jdField_b_of_type_AndroidAnimationValueAnimator) && (this.jdField_a_of_type_Boolean))
    {
      setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "onAnimationStart setVisibility(VISIBLE)");
      }
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i1;
    int i2;
    int i3;
    if (paramValueAnimator == this.jdField_a_of_type_AndroidAnimationValueAnimator)
    {
      paramValueAnimator = this.jdField_a_of_type_AndroidGraphicsPoint;
      i1 = (int)(this.m + (paramValueAnimator.x - this.m) * f1);
      i2 = (int)(this.n + (paramValueAnimator.y - this.n) * f1);
      i3 = e();
      this.jdField_c_of_type_Int = i3;
      int i4 = this.jdField_d_of_type_Int;
      paramValueAnimator = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
      if (paramValueAnimator != null)
      {
        paramValueAnimator.a(this, i1, i2, i1 + i3, i2 + i4);
        return;
      }
      layout(i1, i2, i3 + i1, i4 + i2);
      return;
    }
    if (paramValueAnimator == this.jdField_b_of_type_AndroidAnimationValueAnimator)
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return;
    }
    if (paramValueAnimator == this.jdField_c_of_type_AndroidAnimationValueAnimator)
    {
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      }
      if (((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() != 1)) || (ColorNoteUtils.a(this.jdField_a_of_type_JavaUtilList))) {
        return;
      }
      i1 = (int)(this.jdField_c_of_type_Int / 2 * f1);
      this.jdField_b_of_type_AndroidGraphicsPoint.x = g();
      paramValueAnimator = this.jdField_b_of_type_AndroidGraphicsPoint;
      i2 = e();
      this.jdField_c_of_type_Int = i2;
      i3 = this.jdField_d_of_type_Int;
      ColorNoteSmallScreenRelativeLayout.FloatListener localFloatListener;
      if (paramValueAnimator.x <= 0)
      {
        localFloatListener = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
        if (localFloatListener != null) {
          localFloatListener.a(this, paramValueAnimator.x, paramValueAnimator.y, paramValueAnimator.x + i2 + i1, paramValueAnimator.y + i3, i1, false);
        }
      }
      else
      {
        localFloatListener = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
        if (localFloatListener != null) {
          localFloatListener.a(this, paramValueAnimator.x - i1, paramValueAnimator.y, paramValueAnimator.x + i2 - i1, paramValueAnimator.y + i3, -i1, false);
        }
      }
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    a();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377673));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377674));
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131369424));
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131369425));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365883));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.q == 0) || (this.r == 0))
    {
      this.q = ViewUtils.a();
      this.r = ViewUtils.b();
      setCurPosition(this.jdField_b_of_type_AndroidGraphicsPoint);
    }
  }
  
  public void setCurPosition(Point paramPoint)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurPosition position = ");
      ((StringBuilder)localObject).append(paramPoint);
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurPosition mScreenWidth = ");
      ((StringBuilder)localObject).append(this.q);
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurPosition mScreenHeight = ");
      ((StringBuilder)localObject).append(this.r);
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_AndroidGraphicsPoint = paramPoint;
    int i1;
    if (this.jdField_b_of_type_AndroidGraphicsPoint.x < 0) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    this.s = i1;
    if ((this.q != 0) && (this.r != 0))
    {
      i1 = this.jdField_c_of_type_Int;
      int i2 = this.jdField_d_of_type_Int;
      if ((paramPoint.x == 0) && (paramPoint.y == 0))
      {
        paramPoint.y = (this.r / 2);
        paramPoint.x = (this.q - i1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener;
      if (localObject != null)
      {
        ((ColorNoteSmallScreenRelativeLayout.FloatListener)localObject).a(this, paramPoint.x, paramPoint.y, paramPoint.x + i1, paramPoint.y + i2);
        return;
      }
      layout(paramPoint.x, paramPoint.y, paramPoint.x + i1, paramPoint.y + i2);
    }
  }
  
  public void setCustomNightMode(boolean paramBoolean)
  {
    jdField_i_of_type_Boolean = paramBoolean;
    o();
  }
  
  public void setFloatListener(ColorNoteSmallScreenRelativeLayout.FloatListener paramFloatListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$FloatListener = paramFloatListener;
  }
  
  public void setShouldMaxRootView(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setUpcomingController(IUpcomingController paramIUpcomingController)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenIUpcomingController = paramIUpcomingController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
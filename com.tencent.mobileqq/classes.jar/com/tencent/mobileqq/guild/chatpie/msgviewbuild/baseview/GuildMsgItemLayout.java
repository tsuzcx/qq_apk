package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOCheckBoxUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemAnimLayout;
import com.tencent.mobileqq.activity.aio.SelectCursorTouchHelper;
import com.tencent.mobileqq.activity.aio.SelectCursorTouchHelper.SelectCursorTouchHelperListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.selectable.SelectableCursor;
import com.tencent.mobileqq.activity.selectable.SelectableDelegate;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.chatpie.view.GuildVasAvatar;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class GuildMsgItemLayout
  extends ChatItemAnimLayout
  implements SelectCursorTouchHelper.SelectCursorTouchHelperListener, SelectableCursor
{
  private static final int a;
  private static final int b;
  public static final int i;
  public static final int j;
  public static final int k;
  public static final int l;
  public static final int m;
  public static final int n;
  public static final int o = ViewUtils.getScreenWidth() - j - k - i - l;
  public static final int p = ViewUtils.dpToPx(5.0F);
  public static String q;
  protected GuildVasAvatar A;
  protected View B;
  public MsgItemLayoutWrapper C = new MsgItemLayoutWrapper();
  protected GuildMsgItemLayoutViewFactory D;
  private int E = -1;
  private int F = -1;
  private int G = -1;
  private int H = -1;
  private int I = -1;
  private int J = -1;
  private int K;
  private boolean L = false;
  private int M = -1;
  private int N = -1;
  private int O = -1;
  private Paint P;
  private Rect Q;
  private RelativeLayout R;
  private View c;
  private View d;
  private TextView e;
  private SelectableDelegate f;
  private boolean g = false;
  private boolean h = false;
  public ProgressBar r;
  public ImageView s;
  public RelativeLayout.LayoutParams t;
  public View u;
  public View v;
  protected int[] w = new int[2];
  protected RelativeLayout x;
  protected LinearLayout y;
  protected CheckBox z;
  
  static
  {
    a = ViewUtils.dpToPx(2.0F);
    b = ViewUtils.dpToPx(18.0F);
    q = "GuildMsgItemLayout";
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    i = localBaseApplication.getResources().getDimensionPixelSize(2131297577);
    j = localBaseApplication.getResources().getDimensionPixelSize(2131297578);
    k = localBaseApplication.getResources().getDimensionPixelSize(2131297580);
    l = localBaseApplication.getResources().getDimensionPixelSize(2131298142);
    m = localBaseApplication.getResources().getDimensionPixelSize(2131297576);
    n = localBaseApplication.getResources().getDimensionPixelSize(2131297575);
  }
  
  public GuildMsgItemLayout(AppRuntime paramAppRuntime, Context paramContext)
  {
    super(paramContext);
    this.D = new GuildMsgItemLayoutViewFactory(paramAppRuntime, this, paramContext);
    this.C.a(this);
  }
  
  public GuildMsgItemLayout(AppRuntime paramAppRuntime, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.D = new GuildMsgItemLayoutViewFactory(paramAppRuntime, this, paramContext);
    this.C.a(this);
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    int i3 = this.E;
    int i2 = p;
    int i1 = i3 - i2 * 3;
    i3 += i2 * 3;
    int i4 = this.F;
    i2 = i4 - b - i2 * 2;
    if ((paramFloat1 >= i1) && (paramFloat1 <= i3) && (paramFloat2 >= i2) && (paramFloat2 <= i4) && (this.g)) {
      return 1;
    }
    if (QLog.isColorLevel())
    {
      String str = q;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isTouchOnCursor, left=");
      localStringBuilder.append(i1);
      localStringBuilder.append(",right=");
      localStringBuilder.append(i3);
      localStringBuilder.append(",top=");
      localStringBuilder.append(i2);
      localStringBuilder.append(", bottom=");
      localStringBuilder.append(i4);
      localStringBuilder.append(", x=");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(",y=");
      localStringBuilder.append(paramFloat2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    i1 = this.G;
    i2 = p;
    i3 = this.H;
    i4 = b;
    if ((paramFloat1 >= i1 - i2 * 3) && (paramFloat1 <= i1 + i2 * 3) && (paramFloat2 >= i3 - i4) && (paramFloat2 <= i3 + i2 * 2) && (this.h)) {
      return 2;
    }
    return -1;
  }
  
  private void a()
  {
    if (this.y == null)
    {
      this.y = ((IGuildNickLayoutProcessor)a(IGuildNickLayoutProcessor.class)).b();
      this.y.setId(2131430596);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131430587);
      localLayoutParams.addRule(6, 2131430587);
      localLayoutParams.topMargin = AIOUtils.b(-2.0F, getResources());
      localLayoutParams.leftMargin = l;
      localLayoutParams.rightMargin = k;
      addView(this.y, localLayoutParams);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i1 = this.M;
    if (i1 == 1)
    {
      i1 = this.I;
      if (i1 != -1) {
        this.f.a(paramInt, i1, paramBoolean);
      }
    }
    else if (i1 == 2)
    {
      i1 = this.J;
      if (i1 != -1) {
        this.f.a(paramInt, i1, paramBoolean);
      }
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    int i2;
    if (!this.L)
    {
      i2 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i2 != -1) && (i1 == 0))
      {
        k();
        this.L = true;
        this.M = i2;
        this.N = this.f.e();
        this.O = this.f.f();
        if (paramMotionEvent.getSource() != -1) {
          this.f.a(this.M, false);
        }
        if (this.f.i()) {
          this.f.j();
        }
        return true;
      }
      return false;
    }
    k();
    if ((i1 != 1) && (i1 != 3))
    {
      if (i1 == 2)
      {
        int i3 = (int)paramMotionEvent.getRawX();
        int i4 = (int)paramMotionEvent.getRawY();
        int i5 = this.M;
        int[] arrayOfInt;
        if (i5 == 1)
        {
          i1 = this.E;
          i2 = this.F;
          i5 = b;
          int i6 = p;
          arrayOfInt = a(i3, i4, i1, i2, i6 * 2 + i5, -i5, this.g, i6 * 2);
          i1 = arrayOfInt[0];
          i2 = arrayOfInt[1];
        }
        else
        {
          i1 = i3;
          i2 = i4;
          if (i5 == 2)
          {
            i1 = this.G;
            i2 = this.H;
            i5 = p;
            arrayOfInt = a(i3, i4, i1, i2, 0, i5 * 2, this.h, -i5 * 2);
            i1 = arrayOfInt[0];
            i2 = arrayOfInt[1];
          }
        }
        c(i1, i2, paramMotionEvent.getSource());
        return true;
      }
    }
    else
    {
      this.L = false;
      this.I = -1;
      this.J = -1;
      this.f.a(-1, true);
      this.f.h();
      if (i1 == 1)
      {
        if (paramMotionEvent.getSource() == -1) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        ReportController.b(null, "dc00898", "", "", "0X800AE7B", "0X800AE7B", i1, 0, "", "", "", "");
      }
    }
    return true;
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7)
  {
    int i2 = p;
    int i1 = paramInt2;
    if (paramInt1 >= paramInt3 - i2 * 3)
    {
      i1 = paramInt2;
      if (paramInt1 <= paramInt3 + i2 * 3)
      {
        i1 = paramInt2;
        if (paramInt2 >= paramInt4 - paramInt5)
        {
          i1 = paramInt2;
          if (paramInt2 <= paramInt4 + paramInt6)
          {
            i1 = paramInt2;
            if (paramBoolean) {
              i1 = paramInt2 + paramInt7;
            }
          }
        }
      }
    }
    return new int[] { paramInt1, i1 };
  }
  
  private void b()
  {
    if (this.x == null)
    {
      this.x = new RelativeLayout(getContext());
      this.x.setId(2131434588);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.rightMargin = k;
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(5, 2131430587);
      localLayoutParams.topMargin = AIOUtils.b(16.666668F, getResources());
      addView(this.x, localLayoutParams);
    }
  }
  
  private void g()
  {
    if (this.r == null)
    {
      this.r = new ProgressBar(getContext(), null, 0);
      this.r.setId(2131430606);
      this.r.setIndeterminate(true);
      this.r.setIndeterminateDrawable(getResources().getDrawable(2130839585));
      addView(this.r);
    }
    h();
    this.r.setLayoutParams(this.t);
  }
  
  private void h()
  {
    if (this.t == null)
    {
      int i1 = AIOUtils.b(16.0F, getResources());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
      localLayoutParams.addRule(5, 2131430578);
      localLayoutParams.addRule(3, 2131430578);
      localLayoutParams.bottomMargin = AIOUtils.b(8.666666F, getResources());
      this.t = localLayoutParams;
    }
  }
  
  private void i()
  {
    if (this.s == null)
    {
      this.s = new ImageView(getContext());
      this.s.setId(2131430585);
      this.s.setImageResource(2130840966);
      this.s.setContentDescription(getContext().getString(2131886538));
      addView(this.s);
    }
    h();
    this.s.setLayoutParams(this.t);
  }
  
  private void j()
  {
    if (this.R != null) {
      return;
    }
    this.R = ((IGuildTailProcessor)a(IGuildTailProcessor.class)).a();
    this.R.setId(2131430608);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(3, 2131430578);
    localLayoutParams.addRule(5, 2131430578);
    addView(this.R, localLayoutParams);
  }
  
  private void k()
  {
    if (this.f != null) {
      return;
    }
    throw new IllegalStateException("Has no bound delegate!");
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((!this.g) && (!this.h)) {
      return -1;
    }
    return new SelectCursorTouchHelper(this, this.f).a(paramFloat1, paramFloat2, paramInt1, paramInt2);
  }
  
  @Nullable
  public <T extends IGuildMsgItemLayoutProcessor> T a(Class<T> paramClass)
  {
    return this.D.a(paramClass);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2)
    {
      this.N = (paramInt1 - paramInt2);
      return;
    }
    this.O = (paramInt1 + paramInt2);
  }
  
  protected void a(RelativeLayout.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    paramLayoutParams.rightMargin = k;
    paramLayoutParams.bottomMargin = AIOUtils.b(4.666667F, getResources());
    if (paramBoolean)
    {
      paramLayoutParams.addRule(5, 0);
      paramLayoutParams.addRule(3, 0);
      Object localObject = this.x;
      if ((localObject != null) && (((RelativeLayout)localObject).getVisibility() == 0)) {
        paramLayoutParams.addRule(3, 2131434588);
      } else {
        paramLayoutParams.addRule(10);
      }
      localObject = this.z;
      if ((localObject != null) && (((CheckBox)localObject).getVisibility() != 8)) {
        paramLayoutParams.leftMargin = (l + i + j + m + n);
      } else {
        paramLayoutParams.leftMargin = (l + i + j);
      }
      paramLayoutParams.topMargin = AIOUtils.b(4.666667F, getResources());
      return;
    }
    paramLayoutParams.addRule(10, 0);
    paramLayoutParams.leftMargin = 0;
    paramLayoutParams.addRule(5, 2131430596);
    paramLayoutParams.addRule(3, 2131430596);
    paramLayoutParams.topMargin = AIOUtils.b(6.666667F, getResources());
  }
  
  public void a(SelectableDelegate paramSelectableDelegate)
  {
    this.f = paramSelectableDelegate;
  }
  
  public void a(ChatMessage paramChatMessage, View.OnClickListener paramOnClickListener)
  {
    a();
    IGuildNickLayoutProcessor localIGuildNickLayoutProcessor = (IGuildNickLayoutProcessor)a(IGuildNickLayoutProcessor.class);
    localIGuildNickLayoutProcessor.a(paramChatMessage);
    localIGuildNickLayoutProcessor.a(paramOnClickListener);
  }
  
  public int b(int paramInt)
  {
    if (paramInt == 1) {
      return this.E;
    }
    return this.G;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    k();
    getLocationInWindow(this.w);
    boolean bool;
    if ((paramInt1 != -1) && (paramInt2 != -1)) {
      bool = true;
    } else {
      bool = false;
    }
    int[] arrayOfInt;
    if (paramInt3 == 1)
    {
      arrayOfInt = this.w;
      this.E = (paramInt1 - arrayOfInt[0]);
      this.F = (paramInt2 - arrayOfInt[1]);
      this.g = bool;
    }
    else
    {
      arrayOfInt = this.w;
      this.G = (paramInt1 - arrayOfInt[0]);
      this.H = (paramInt2 - arrayOfInt[1]);
      this.h = bool;
    }
    if (this.P == null) {
      this.P = new Paint(1);
    }
    if (this.Q == null) {
      this.Q = new Rect();
    }
    if (paramInt3 == 1)
    {
      this.I = paramInt2;
    }
    else if (paramInt3 == 2)
    {
      this.J = paramInt2;
    }
    else
    {
      this.I = -1;
      this.J = -1;
    }
    invalidate();
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    j();
    ((IGuildTailProcessor)a(IGuildTailProcessor.class)).a(paramChatMessage);
  }
  
  public int c(int paramInt)
  {
    if (paramInt == 1) {
      return this.F;
    }
    return this.H;
  }
  
  protected void c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2;
    if (this.M == 1) {
      i2 = this.N;
    } else {
      i2 = this.O;
    }
    int i1 = this.f.b(paramInt1, paramInt2);
    if (paramInt3 == -1) {
      this.f.a(this.M, false);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCursorLocation, touchIndex=");
      localStringBuilder.append(i1);
      localStringBuilder.append(", type=");
      localStringBuilder.append(this.M);
      QLog.d("BaseChatItemLayout", 2, localStringBuilder.toString());
    }
    if (i1 == -1) {
      return;
    }
    if (i1 != i2)
    {
      if (this.M == 1)
      {
        paramInt3 = this.N;
        if (i1 < paramInt3)
        {
          paramInt3 = this.O;
          this.N = i1;
        }
      }
      for (;;)
      {
        i2 = i1;
        i1 = paramInt3;
        paramInt3 = i2;
        break;
        if (i1 > paramInt3)
        {
          paramInt3 = this.O;
          if (i1 < paramInt3)
          {
            this.N = i1;
            continue;
          }
        }
        paramInt3 = this.N;
        if (i1 == paramInt3)
        {
          i1 = this.O;
          break;
        }
        paramInt3 = this.O;
        if (i1 == paramInt3)
        {
          i1 = paramInt3 - 1;
        }
        else
        {
          this.N = paramInt3;
          this.O = i1;
          this.M = 2;
          this.f.a(this.M);
          break;
          paramInt3 = this.O;
          if (i1 > paramInt3)
          {
            paramInt3 = this.N;
            this.O = i1;
            break;
          }
          if (i1 < paramInt3)
          {
            paramInt3 = this.N;
            if (i1 > paramInt3)
            {
              this.O = i1;
              break;
            }
          }
          paramInt3 = this.O;
          if (i1 == paramInt3)
          {
            i1 = this.N;
          }
          else
          {
            paramInt3 = this.N;
            if (i1 == paramInt3)
            {
              i1 = paramInt3 + 1;
              break;
            }
            this.O = paramInt3;
            this.N = i1;
            this.M = 1;
            this.f.a(this.M);
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("update selection, s=");
        localStringBuilder.append(paramInt3);
        localStringBuilder.append(", e=");
        localStringBuilder.append(i1);
        QLog.d("BaseChatItemLayout", 2, localStringBuilder.toString());
      }
      this.f.a(paramInt3, i1);
      this.f.c(paramInt1, paramInt2);
      a(paramInt1, true);
      return;
    }
    a(paramInt1, false);
  }
  
  protected boolean c()
  {
    CheckBox localCheckBox = this.z;
    return (localCheckBox != null) && (localCheckBox.getVisibility() == 0);
  }
  
  protected boolean d()
  {
    CheckBox localCheckBox = this.z;
    return (localCheckBox != null) && (localCheckBox.getVisibility() == 0);
  }
  
  public boolean d(int paramInt)
  {
    if (paramInt == 1) {
      return this.g;
    }
    return this.h;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Rect localRect;
    int i1;
    int i2;
    float f1;
    if (this.g)
    {
      localRect = this.Q;
      i1 = this.E;
      i2 = a;
      int i3 = this.F;
      localRect.set(i1 - i2, i3 - b, i1, i3);
      this.P.setColor(this.K);
      paramCanvas.drawRect(this.Q, this.P);
      f1 = this.Q.centerX();
      i1 = this.Q.top;
      i2 = p;
      paramCanvas.drawCircle(f1, i1 - i2, i2, this.P);
    }
    if (this.h)
    {
      localRect = this.Q;
      i1 = this.G;
      i2 = this.H;
      localRect.set(i1, i2 - b, a + i1, i2);
      this.P.setColor(this.K);
      paramCanvas.drawRect(this.Q, this.P);
      f1 = this.Q.centerX();
      i1 = this.Q.bottom;
      i2 = p;
      paramCanvas.drawCircle(f1, i1 + i2, i2, this.P);
    }
  }
  
  @NonNull
  public View e()
  {
    return this;
  }
  
  public void e(int paramInt)
  {
    if (paramInt == 1) {
      this.g = false;
    } else {
      this.h = false;
    }
    invalidate();
  }
  
  public void f(int paramInt)
  {
    this.K = paramInt;
  }
  
  public boolean f()
  {
    ImageView localImageView = this.s;
    return (localImageView != null) && (localImageView.getVisibility() == 0);
  }
  
  public String getNickNameString()
  {
    IGuildNickLayoutProcessor localIGuildNickLayoutProcessor = (IGuildNickLayoutProcessor)a(IGuildNickLayoutProcessor.class);
    if (localIGuildNickLayoutProcessor != null) {
      return localIGuildNickLayoutProcessor.c();
    }
    return "";
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.aB) {
      return true;
    }
    if (BaseChatItemLayout.ad)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(q, 4, "onInterceptTouchEvent...down ");
        }
        return true;
      }
    }
    else if (((this.g) || (this.h)) && (a(paramMotionEvent.getX(), paramMotionEvent.getY()) != -1))
    {
      k();
      this.f.m();
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (BaseChatItemLayout.ad)
    {
      AIOCheckBoxUtil.a(this, paramMotionEvent);
      return true;
    }
    if (((this.g) || (this.h)) && (a(paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAtView(Context paramContext, ChatMessage paramChatMessage)
  {
    if (this.v == null)
    {
      this.v = new View(getContext());
      this.v.setId(2131434585);
      addView(this.v);
      this.v.setBackgroundColor(16773091);
      paramContext = (RelativeLayout.LayoutParams)this.v.getLayoutParams();
      paramContext.bottomMargin = AIOUtils.b(-7.0F, getResources());
      paramContext.width = -1;
      paramContext.height = -1;
      paramContext.addRule(13);
      paramContext.addRule(6, 2131430578);
      paramContext.addRule(8, 2131430578);
    }
    paramContext = (RelativeLayout.LayoutParams)this.v.getLayoutParams();
    if (paramChatMessage.isNeedCombine())
    {
      paramContext.topMargin = AIOUtils.b(-7.0F, getResources());
      return;
    }
    paramContext.topMargin = AIOUtils.b(-38.0F, getResources());
  }
  
  public void setContentView(@NonNull View paramView, boolean paramBoolean, int paramInt)
  {
    setContentView(paramView, paramBoolean, paramInt, null);
  }
  
  public void setContentView(@NonNull View paramView, boolean paramBoolean, int paramInt, RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramView.getClass();
    View localView = this.B;
    if (localView != paramView)
    {
      removeView(localView);
      this.B = paramView;
      this.B.setId(2131430578);
      if (paramLayoutParams == null) {
        addView(paramView);
      } else {
        addView(paramView, paramLayoutParams);
      }
    }
    a((RelativeLayout.LayoutParams)this.B.getLayoutParams(), paramBoolean);
  }
  
  public void setContentViewBg(int paramInt)
  {
    View localView = this.B;
    if (localView == null) {
      return;
    }
    localView.setBackgroundResource(paramInt);
  }
  
  public void setDtReport(ChatMessage paramChatMessage)
  {
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.A, "em_aio_profile", null);
    Object localObject = new HashMap();
    ((Map)localObject).put("msg_type", Integer.valueOf(paramChatMessage.msgtype));
    ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.B, "em_aio_message", (Map)localObject);
    localObject = this.B;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("em_aio_message");
    localStringBuilder.append(paramChatMessage.hashCode());
    VideoReport.setElementReuseIdentifier(localObject, localStringBuilder.toString());
  }
  
  public void setFailedIconVisable(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    i();
    this.s.setOnClickListener(paramOnClickListener);
    if (paramBoolean) {
      this.s.setVisibility(0);
    } else {
      this.s.setVisibility(8);
    }
    if (BaseChatItemLayout.ad)
    {
      paramOnClickListener = this.s;
      if (paramOnClickListener != null) {
        paramOnClickListener.setOnClickListener(null);
      }
    }
  }
  
  public void setFlushView(ChatMessage paramChatMessage)
  {
    if (this.u == null)
    {
      this.u = new View(getContext());
      this.u.setId(2131434586);
      addView(this.u);
      localLayoutParams = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
      localLayoutParams.bottomMargin = AIOUtils.b(-3.333333F, getResources());
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localLayoutParams.addRule(13);
      localLayoutParams.addRule(6, 2131430578);
      localLayoutParams.addRule(8, 2131430578);
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
    if (paramChatMessage.isNeedCombine())
    {
      localLayoutParams.topMargin = AIOUtils.b(-3.333333F, getResources());
      return;
    }
    localLayoutParams.topMargin = AIOUtils.b(-24.0F, getResources());
  }
  
  public void setHeadIcon(QQAppInterface paramQQAppInterface, GuildMsgItemLayout.AvatarViewInfo paramAvatarViewInfo)
  {
    Object localObject = this.A;
    if (localObject == null)
    {
      this.A = new GuildVasAvatar(getContext());
      this.A.setAppInterface(paramQQAppInterface);
      this.A.setId(2131430587);
      this.A.setScaleType(ImageView.ScaleType.FIT_XY);
      paramQQAppInterface = new RelativeLayout.LayoutParams(paramAvatarViewInfo.c, paramAvatarViewInfo.d);
      paramQQAppInterface.leftMargin = paramAvatarViewInfo.e;
      paramQQAppInterface.rightMargin = paramAvatarViewInfo.f;
      paramQQAppInterface.topMargin = paramAvatarViewInfo.g;
      paramQQAppInterface.bottomMargin = paramAvatarViewInfo.h;
      this.A.setPadding(paramAvatarViewInfo.i, paramAvatarViewInfo.k, paramAvatarViewInfo.j, paramAvatarViewInfo.l);
      paramQQAppInterface.addRule(9);
      paramQQAppInterface.addRule(10);
      localObject = this.z;
      if ((localObject != null) && (((CheckBox)localObject).getVisibility() != 8)) {
        paramQQAppInterface.leftMargin = (m + n + paramAvatarViewInfo.e);
      }
      addView(this.A, paramQQAppInterface);
    }
    else
    {
      paramQQAppInterface = (RelativeLayout.LayoutParams)((GuildVasAvatar)localObject).getLayoutParams();
      localObject = this.z;
      if ((localObject != null) && (((CheckBox)localObject).getVisibility() != 8)) {
        paramQQAppInterface.leftMargin = (m + n + paramAvatarViewInfo.e);
      } else {
        paramQQAppInterface.leftMargin = paramAvatarViewInfo.e;
      }
      paramQQAppInterface.topMargin = paramAvatarViewInfo.g;
    }
    this.A.setAvatarTinyId(paramAvatarViewInfo.b);
    if (paramAvatarViewInfo.a)
    {
      setHeadIconVisible(0);
      return;
    }
    setHeadIconVisible(8);
  }
  
  public void setHeadIcon(QQAppInterface paramQQAppInterface, String paramString, ChatMessage paramChatMessage, View.OnClickListener paramOnClickListener)
  {
    setHeadIcon(paramQQAppInterface, new GuildMsgItemLayout.AvatarViewInfo(this, paramString, paramChatMessage));
    this.A.setOnClickListener(paramOnClickListener);
  }
  
  public void setHeadIconContentDescription(String paramString)
  {
    if (this.A != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.A.setContentDescription(paramString);
        return;
      }
      this.A.setContentDescription(getNickNameString());
    }
  }
  
  public void setHeadIconVisible(int paramInt)
  {
    GuildVasAvatar localGuildVasAvatar = this.A;
    if (localGuildVasAvatar != null) {
      localGuildVasAvatar.setVisibility(paramInt);
    }
  }
  
  public void setIconLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    GuildVasAvatar localGuildVasAvatar = this.A;
    if (localGuildVasAvatar != null) {
      localGuildVasAvatar.setOnLongClickListener(paramOnLongClickListener);
    }
  }
  
  public void setOtherWhenNeeded(Context paramContext, GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    this.C.a(paramContext, paramChatMessage);
  }
  
  public void setProgressAndFailParams(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams == null) {
      return;
    }
    this.t = paramLayoutParams;
  }
  
  public void setProgressVisable(boolean paramBoolean)
  {
    g();
    if (paramBoolean)
    {
      this.r.setVisibility(0);
      return;
    }
    this.r.setVisibility(8);
  }
  
  public void setSelCheckBox(ChatMessage paramChatMessage, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    boolean bool = BaseChatItemLayout.ad;
    if (BaseChatItemLayout.ad)
    {
      if (this.z == null)
      {
        this.z = new CheckBox(getContext());
        this.z.setButtonDrawable(2130840768);
        this.z.setId(2131430605);
        this.z.setOnCheckedChangeListener(paramOnCheckedChangeListener);
        addView(this.z);
      }
      paramOnCheckedChangeListener = (RelativeLayout.LayoutParams)this.z.getLayoutParams();
      int i1 = m;
      paramOnCheckedChangeListener.width = i1;
      paramOnCheckedChangeListener.height = i1;
      paramOnCheckedChangeListener.addRule(9);
      if (paramChatMessage.isNeedCombine())
      {
        if (paramChatMessage.mNeedTimeStamp) {
          paramOnCheckedChangeListener.topMargin = AIOUtils.b(8.0F, getResources());
        } else {
          paramOnCheckedChangeListener.topMargin = 0;
        }
        paramOnCheckedChangeListener.removeRule(10);
        paramOnCheckedChangeListener.addRule(15);
      }
      else
      {
        paramOnCheckedChangeListener.addRule(8, 2131430587);
        paramOnCheckedChangeListener.bottomMargin = (i / 2 - paramOnCheckedChangeListener.height / 2);
      }
      paramOnCheckedChangeListener.leftMargin = AIOUtils.b(12.0F, getContext().getResources());
      this.z.setLayoutParams(paramOnCheckedChangeListener);
      this.z.setTag(paramChatMessage);
      if (bool)
      {
        paramOnCheckedChangeListener = AIOLongShotHelper.f();
        if ((paramOnCheckedChangeListener != null) && (paramOnCheckedChangeListener.c()))
        {
          this.z.setVisibility(8);
          this.z.setChecked(paramOnCheckedChangeListener.a(paramChatMessage));
          return;
        }
        this.z.setVisibility(0);
        bool = MultiMsgManager.a().a(paramChatMessage);
        this.z.setChecked(bool);
        return;
      }
      this.z.setVisibility(4);
      return;
    }
    paramChatMessage = this.z;
    if (paramChatMessage != null) {
      paramChatMessage.setVisibility(8);
    }
  }
  
  public void setSplitLineView(boolean paramBoolean, CharSequence paramCharSequence, ColorStateList paramColorStateList)
  {
    b();
    if (this.e == null)
    {
      this.e = new TextView(getContext());
      this.e.setId(2131434587);
      this.e.setTextColor(Color.parseColor("#E3E3E3"));
      this.e.setTextSize(12.0F);
      this.e.setIncludeFontPadding(false);
      paramColorStateList = new RelativeLayout.LayoutParams(-2, -2);
      paramColorStateList.addRule(13);
      paramColorStateList.leftMargin = AIOUtils.b(6.0F, getResources());
      paramColorStateList.rightMargin = AIOUtils.b(6.0F, getResources());
      this.x.addView(this.e, paramColorStateList);
    }
    if (this.c == null)
    {
      this.c = new TextView(getContext());
      this.c.setBackgroundColor(Color.parseColor("#E3E3E3"));
      paramColorStateList = new RelativeLayout.LayoutParams(-1, (int)getContext().getResources().getDimension(2131297581));
      paramColorStateList.addRule(13);
      paramColorStateList.addRule(0, 2131434587);
      this.x.addView(this.c, paramColorStateList);
    }
    if (this.d == null)
    {
      this.d = new TextView(getContext());
      this.d.setBackgroundColor(Color.parseColor("#E3E3E3"));
      paramColorStateList = new RelativeLayout.LayoutParams(-1, (int)getContext().getResources().getDimension(2131297581));
      paramColorStateList.addRule(13);
      paramColorStateList.addRule(1, 2131434587);
      this.x.addView(this.d, paramColorStateList);
    }
    if (paramBoolean)
    {
      setmSplitLineTimeTV(paramCharSequence);
      return;
    }
    this.e.setVisibility(8);
  }
  
  public void setSplitLineViewVisible(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.x;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(paramInt);
    }
  }
  
  public void setmSplitLineTimeTV(CharSequence paramCharSequence)
  {
    TextView localTextView = this.e;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  public void setmSplitLineTimeTVVisible(int paramInt)
  {
    TextView localTextView = this.e;
    if (localTextView != null) {
      localTextView.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout
 * JD-Core Version:    0.7.0.1
 */
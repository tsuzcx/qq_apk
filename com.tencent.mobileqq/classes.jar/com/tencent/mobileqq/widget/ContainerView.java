package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SelectCursorTouchHelper;
import com.tencent.mobileqq.activity.aio.SelectCursorTouchHelper.SelectCursorTouchHelperListener;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.activity.selectable.SelectableCursor;
import com.tencent.mobileqq.activity.selectable.SelectableDelegate;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticon.api.IAniStickerUtils;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper.Builder;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import mqq.app.MobileQQ;

@SuppressLint({"NewApi", "ResourceAsColor", "Override"})
@TargetApi(11)
public class ContainerView
  extends LinearLayout
  implements SelectCursorTouchHelper.SelectCursorTouchHelperListener, SelectableCursor
{
  private static final int G = ViewUtils.dpToPx(5.0F);
  private static final int H = ViewUtils.dpToPx(2.0F);
  private static final int I = ViewUtils.dpToPx(28.0F);
  public static float b;
  private int A = -1;
  private int B = -1;
  private int C = -1;
  private int D = -1;
  private int E = -1;
  private boolean F = false;
  public int a = 0;
  public AnimationTextView c;
  protected Handler d;
  public boolean e = true;
  protected int f = -1;
  protected String g = null;
  protected boolean h = false;
  protected boolean i = false;
  protected volatile boolean j = false;
  protected AniStickerLottieView k;
  protected PopupWindow l;
  private ScrollView m;
  private boolean n = false;
  private SelectableDelegate o;
  private int[] p = new int[2];
  private boolean q = false;
  private boolean r = false;
  private int s = -1;
  private int t = -1;
  private int u = -1;
  private int v = -1;
  private Paint w;
  private Rect x;
  private int y;
  private boolean z = false;
  
  public ContainerView(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  @TargetApi(11)
  public ContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    int i1 = this.s;
    int i2 = G;
    int i3 = this.t;
    int i4 = I;
    if ((paramFloat1 >= i1 - i2 * 3) && (paramFloat1 <= i1 + i2 * 3) && (paramFloat2 >= i3 - i4 - i2 * 2) && (paramFloat2 <= i3) && (this.q)) {
      return 1;
    }
    i1 = this.u;
    i2 = G;
    i3 = this.v;
    i4 = I;
    if ((paramFloat1 >= i1 - i2 * 3) && (paramFloat1 <= i1 + i2 * 3) && (paramFloat2 >= i3 - i4) && (paramFloat2 <= i3 + i2 * 2) && (this.r)) {
      return 2;
    }
    return -1;
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat != 0.0F)
    {
      if (paramFloat == this.m.getScrollY()) {
        return;
      }
      int i1 = (int)paramFloat;
      int i2 = (int)((paramFloat - i1) * this.c.getLineHeight());
      Layout localLayout = this.c.getLayout();
      if (localLayout != null)
      {
        i1 = localLayout.getLineForOffset(i1);
        if (i1 == 0) {
          i1 = -localLayout.getTopPadding();
        } else {
          i1 = localLayout.getLineTop(i1);
        }
        new Handler().post(new ContainerView.4(this, i1 - i2));
        return;
      }
      i2 = this.c.getLineHeight();
      new Handler().post(new ContainerView.5(this, i1 * i2));
    }
  }
  
  private void b()
  {
    if (this.l == null) {
      this.l = c();
    }
    Object localObject = new Rect();
    this.c.getGlobalVisibleRect((Rect)localObject);
    Size localSize = getPopSize();
    int i1;
    int i2;
    if (Build.VERSION.SDK_INT >= 19)
    {
      i1 = (((Rect)localObject).width() - localSize.a()) / 2;
      i2 = -(localSize.b() + ((Rect)localObject).height());
      this.l.showAsDropDown(this.c, i1, i2, 3);
    }
    else
    {
      i1 = ((Rect)localObject).left;
      i2 = (((Rect)localObject).width() - localSize.a()) / 2;
      int i3 = ((Rect)localObject).top;
      int i4 = localSize.b();
      this.l.showAtLocation(this, 51, i1 + i2, i3 - i4);
    }
    ((IAniStickerUtils)QRoute.api(IAniStickerUtils.class)).notifyAniStickerPreGuideShow();
    if (this.h) {
      localObject = "0X800BCCF";
    } else {
      localObject = "0X800BBD8";
    }
    ReportController.b(MobileQQ.sMobileQQ.waitAppRuntime(null), "dc00898", "", "", (String)localObject, (String)localObject, QQSysFaceUtil.convertToServer(this.f), 0, "", "", "", "");
  }
  
  private void b(Context paramContext)
  {
    this.c = new AnimationTextView(paramContext);
    this.c.setBackgroundColor(17170445);
    this.c.setGravity(1);
    this.c.setScroller(null);
    this.c.setHighlightColor(1722605812);
    this.c.setTextSize(1, 32.0F);
    this.c.setTextColor(-16777216);
    int i1 = AIOUtils.b(10.0F, getResources());
    this.c.setPadding(i1, i1, i1, i1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    addView(this.c, localLayoutParams);
    this.k = new AniStickerLottieView(paramContext);
    this.k.setId(2131428371);
    this.k.setVisibility(8);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 1;
    addView(this.k, paramContext);
    setOrientation(1);
    getViewTreeObserver().addOnGlobalLayoutListener(new ContainerView.1(this));
  }
  
  private PopupWindow c()
  {
    return ((IAniStickerUtils)QRoute.api(IAniStickerUtils.class)).createAniStickerPreGuideView(getContext());
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2;
    if (this.A == 1) {
      i2 = this.B;
    } else {
      i2 = this.C;
    }
    int i1 = this.o.b(paramInt1, paramInt2);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCursorLocation, touchIndex=");
      localStringBuilder.append(i1);
      localStringBuilder.append(", type=");
      localStringBuilder.append(this.A);
      QLog.d("BaseChatItemLayout", 2, localStringBuilder.toString());
    }
    if (paramInt3 == -1) {
      this.o.a(this.A, false);
    }
    if (i1 == -1) {
      return;
    }
    if (i1 != i2)
    {
      if (this.A == 1)
      {
        paramInt3 = this.B;
        if (i1 < paramInt3)
        {
          paramInt3 = this.C;
          this.B = i1;
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
          paramInt3 = this.C;
          if (i1 < paramInt3)
          {
            this.B = i1;
            continue;
          }
        }
        paramInt3 = this.B;
        if (i1 == paramInt3)
        {
          i1 = this.C;
          break;
        }
        paramInt3 = this.C;
        if (i1 == paramInt3)
        {
          i1 = paramInt3 - 1;
        }
        else
        {
          this.B = paramInt3;
          this.C = i1;
          this.A = 2;
          this.o.a(this.A);
          break;
          paramInt3 = this.C;
          if (i1 > paramInt3)
          {
            paramInt3 = this.B;
            this.C = i1;
            break;
          }
          if (i1 < paramInt3)
          {
            paramInt3 = this.B;
            if (i1 > paramInt3)
            {
              this.C = i1;
              break;
            }
          }
          paramInt3 = this.C;
          if (i1 == paramInt3)
          {
            i1 = this.B;
          }
          else
          {
            paramInt3 = this.B;
            if (i1 == paramInt3)
            {
              i1 = paramInt3 + 1;
              break;
            }
            this.C = paramInt3;
            this.B = i1;
            this.A = 1;
            this.o.a(this.A);
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
      this.o.a(paramInt3, i1);
      this.o.c(paramInt1, paramInt2);
      paramInt2 = this.A;
      if (paramInt2 == 1)
      {
        paramInt2 = this.D;
        if (paramInt2 != -1) {
          this.o.a(paramInt1, paramInt2, true);
        }
      }
      else if (paramInt2 == 2)
      {
        paramInt2 = this.E;
        if (paramInt2 != -1) {
          this.o.a(paramInt1, paramInt2, true);
        }
      }
    }
    else
    {
      paramInt2 = this.A;
      if (paramInt2 == 1)
      {
        paramInt2 = this.D;
        if (paramInt2 != -1) {
          this.o.a(paramInt1, paramInt2, false);
        }
      }
      else if (paramInt2 == 2)
      {
        paramInt2 = this.E;
        if (paramInt2 != -1) {
          this.o.a(paramInt1, paramInt2, false);
        }
      }
    }
  }
  
  private float d()
  {
    int i1 = this.m.getScrollY();
    Layout localLayout = this.c.getLayout();
    if (localLayout != null)
    {
      int i2 = -localLayout.getTopPadding();
      if (i1 <= i2) {
        return (i2 - i1) / this.c.getLineHeight();
      }
      int i3 = localLayout.getLineForVertical(i1 - 1) + 1;
      i2 = localLayout.getLineStart(i3);
      i3 = localLayout.getLineTop(i3);
      return i2 + (i3 - i1) / this.c.getLineHeight();
    }
    return i1 / this.c.getLineHeight();
  }
  
  private void f()
  {
    if (this.o != null) {
      return;
    }
    throw new IllegalStateException("Has no bound delegate!");
  }
  
  private Size getPopSize()
  {
    return ((IAniStickerUtils)QRoute.api(IAniStickerUtils.class)).getAniStickerPreGuideViewSize();
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((!this.q) && (!this.r)) {
      return -1;
    }
    return new SelectCursorTouchHelper(this, this.o).a(paramFloat1, paramFloat2, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2)
    {
      this.B = (paramInt1 - paramInt2);
      return;
    }
    this.C = (paramInt1 + paramInt2);
  }
  
  public void a(SelectableDelegate paramSelectableDelegate)
  {
    this.o = paramSelectableDelegate;
  }
  
  public boolean a()
  {
    return this.m.isScrollFinished();
  }
  
  public boolean a(Context paramContext)
  {
    return this.c.getSelectionEnd() - this.c.getSelectionStart() > 0;
  }
  
  public int b(int paramInt)
  {
    if (paramInt == 1) {
      return this.s;
    }
    return this.u;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    f();
    getLocationInWindow(this.p);
    boolean bool;
    if ((paramInt1 != -1) && (paramInt2 != -1)) {
      bool = true;
    } else {
      bool = false;
    }
    int[] arrayOfInt;
    if (paramInt3 == 1)
    {
      arrayOfInt = this.p;
      this.s = (paramInt1 - arrayOfInt[0]);
      this.t = (paramInt2 - arrayOfInt[1]);
      this.q = bool;
    }
    else
    {
      arrayOfInt = this.p;
      this.u = (paramInt1 - arrayOfInt[0]);
      this.v = (paramInt2 - arrayOfInt[1]);
      this.r = bool;
    }
    if (this.w == null) {
      this.w = new Paint(1);
    }
    if (this.x == null) {
      this.x = new Rect();
    }
    if (paramInt3 == 1)
    {
      this.D = paramInt2;
    }
    else if (paramInt3 == 2)
    {
      this.E = paramInt2;
    }
    else
    {
      this.D = -1;
      this.E = -1;
    }
    invalidate();
  }
  
  public int c(int paramInt)
  {
    if (paramInt == 1) {
      return this.t;
    }
    return this.v;
  }
  
  public boolean d(int paramInt)
  {
    if (paramInt == 1) {
      return this.q;
    }
    return this.r;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Rect localRect;
    int i1;
    int i2;
    float f1;
    if (this.q)
    {
      localRect = this.x;
      i1 = this.s;
      i2 = H;
      int i3 = this.t;
      localRect.set(i1 - i2, i3 - I, i1, i3);
      this.w.setColor(this.y);
      paramCanvas.drawRect(this.x, this.w);
      f1 = this.x.centerX();
      i1 = this.x.top;
      i2 = G;
      paramCanvas.drawCircle(f1, i1 - i2, i2, this.w);
    }
    if (this.r)
    {
      localRect = this.x;
      i1 = this.u;
      i2 = this.v;
      localRect.set(i1, i2 - I, H + i1, i2);
      this.w.setColor(this.y);
      paramCanvas.drawRect(this.x, this.w);
      f1 = this.x.centerX();
      i1 = this.x.bottom;
      i2 = G;
      paramCanvas.drawCircle(f1, i1 + i2, i2, this.w);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.dispatchTouchEvent(paramMotionEvent)) {
      return this.c.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  @NonNull
  public View e()
  {
    return this;
  }
  
  public void e(int paramInt)
  {
    if (paramInt == 1) {
      this.q = false;
    } else {
      this.r = false;
    }
    invalidate();
  }
  
  public void f(int paramInt)
  {
    this.y = paramInt;
  }
  
  public String getText()
  {
    return this.c.getText().toString();
  }
  
  protected void onDetachedFromWindow()
  {
    b = d();
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a == 0)
    {
      super.onDraw(paramCanvas);
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.a);
    super.onDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((this.q) || (this.r)) && (a(paramMotionEvent.getX(), paramMotionEvent.getY()) != -1))
    {
      f();
      this.o.m();
      requestDisallowInterceptTouchEvent(true);
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject;
    if (this.f >= 0)
    {
      paramInt1 = AIOUtils.b(180.0F, getResources());
      localObject = (LinearLayout.LayoutParams)this.k.getLayoutParams();
      if (localObject == null)
      {
        localObject = new LinearLayout.LayoutParams(paramInt1, paramInt1);
      }
      else
      {
        ((LinearLayout.LayoutParams)localObject).width = paramInt1;
        ((LinearLayout.LayoutParams)localObject).height = paramInt1;
      }
      setGravity(17);
      this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.h)
      {
        AniStickerHelper.setAniStickerRandomResource(new AniStickerHelper.Builder(this.k).width(paramInt1).height(paramInt1).localId(this.f).placeholderDrawable(2130852735).build());
        AniStickerHelper.setAniStickerRandomResultResource(new AniStickerHelper.Builder(this.k).resultId(this.g).build());
      }
      else
      {
        AniStickerHelper.setAniStickerResource(new AniStickerHelper.Builder(this.k).width(paramInt1).height(paramInt1).localId(this.f).placeholderDrawable(2130852735).build());
      }
      this.k.setVisibility(0);
      localObject = (LinearLayout.LayoutParams)this.c.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, AIOUtils.b(32.0F, getResources()));
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else
    {
      this.k.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.c.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.m;
      if ((localObject != null) && (((ScrollView)localObject).getHeight() > getHeight())) {
        return;
      }
      paramInt4 = getHeight();
      int i1 = getWidth();
      paramInt2 = this.c.getHeight();
      paramInt3 = this.c.getWidth();
      if (paramInt2 != 0)
      {
        paramInt1 = paramInt3;
        if (paramInt3 != 0) {}
      }
      else
      {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648);
        this.c.measure(paramInt1, paramInt2);
        paramInt2 = this.c.getMeasuredHeight();
        paramInt1 = this.c.getMeasuredWidth();
      }
      if (paramInt2 < paramInt4 * 0.8F)
      {
        if (this.e) {
          if (paramInt1 < i1) {
            setGravity(17);
          } else {
            setGravity(19);
          }
        }
        this.a = (-this.c.getLineHeight());
      }
      else if (this.e)
      {
        setGravity(51);
      }
    }
    this.c.setVisibility(0);
    boolean bool = ((IAniStickerUtils)QRoute.api(IAniStickerUtils.class)).checkIsNeedShowAniStickerPreGuide();
    if ((this.f >= 0) && (this.h) && (bool) && (!this.j) && (!this.i))
    {
      this.j = true;
      this.c.postDelayed(new ContainerView.2(this), 500L);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1;
    int i2;
    if ((this.q) || (this.r))
    {
      i1 = paramMotionEvent.getAction();
      if (this.z) {
        break label139;
      }
      i2 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((i2 != -1) && (i1 == 0))
      {
        f();
        this.z = true;
        this.A = i2;
        this.B = this.o.e();
        this.C = this.o.f();
        if (paramMotionEvent.getSource() != -1) {
          this.o.a(this.A, false);
        }
        if (this.o.i()) {
          this.o.j();
        }
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
    label139:
    f();
    if ((i1 != 1) && (i1 != 3))
    {
      if (i1 == 2)
      {
        int i3 = (int)paramMotionEvent.getRawX();
        i2 = (int)paramMotionEvent.getRawY();
        int i4 = this.A;
        int i5;
        int i6;
        if (i4 == 1)
        {
          i4 = this.s;
          i5 = G;
          i6 = this.t;
          int i7 = I;
          i1 = i2;
          if (i3 >= i4 - i5 * 3)
          {
            i1 = i2;
            if (i3 <= i4 + i5 * 3)
            {
              i1 = i2;
              if (i2 >= i6 - i7 - i5 * 2)
              {
                i1 = i2;
                if (i2 <= i6 - i7)
                {
                  i1 = i2;
                  if (this.q) {
                    i1 = i2 + i5 * 2;
                  }
                }
              }
            }
          }
        }
        else
        {
          i1 = i2;
          if (i4 == 2)
          {
            i4 = this.u;
            i5 = G;
            i6 = this.v;
            i1 = i2;
            if (i3 >= i4 - i5 * 3)
            {
              i1 = i2;
              if (i3 <= i4 + i5 * 3)
              {
                i1 = i2;
                if (i2 >= i6)
                {
                  i1 = i2;
                  if (i2 <= i5 * 2 + i6)
                  {
                    i1 = i2;
                    if (this.r) {
                      i1 = i2 - i5 * 2;
                    }
                  }
                }
              }
            }
          }
        }
        c(i3, i1, paramMotionEvent.getSource());
        return true;
      }
    }
    else
    {
      this.z = false;
      this.D = -1;
      this.E = -1;
      this.o.a(-1, true);
      this.o.h();
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
  
  public void setAniStickerLocID(int paramInt)
  {
    this.f = paramInt;
    this.h = QQSysFaceUtil.isRandomAniSticker(paramInt);
    this.j = false;
  }
  
  public void setAniStickerResult(String paramString)
  {
    this.g = paramString;
  }
  
  public void setIsSendMsg(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setMsgHandler(Handler paramHandler)
  {
    this.d = paramHandler;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setOutScrollView(ScrollView paramScrollView)
  {
    this.m = paramScrollView;
    this.m.setOnScrollStateChangedListener(new ContainerView.3(this));
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.c.setText(paramCharSequence);
  }
  
  public void setTextColor(int paramInt)
  {
    this.c.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContainerView
 * JD-Core Version:    0.7.0.1
 */
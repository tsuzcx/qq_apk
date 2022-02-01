package com.tencent.timi.game.team.impl.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.text.Html;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper.Callback;
import com.tencent.av.utils.UITools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/team/impl/main/LevelSegmentSelectView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backLineGrayColor", "backLinePadding", "backLineYellowColor", "buttonSize", "", "dragHelper", "Landroidx/customview/widget/ViewDragHelper;", "gameMode", "itemNormalColor", "itemSelectColor", "lineEnd", "lineStart", "mode", "paint", "Landroid/graphics/Paint;", "textItemLinear", "Landroid/widget/LinearLayout;", "userLevelPosition", "acquireRightPos", "pos", "acquireSelectedItem", "", "", "checkAndDragViewToTarget", "Landroid/view/View;", "x", "dragViewToTarget", "targetTextView", "findEndView", "findPositionByX", "findPositionInTextList", "findStartView", "initPosition", "", "startPosition", "endPosition", "initTextContent", "levelList", "isInDragViewRange", "", "isXInViewRange", "view", "moveDraggableViewWhenClick", "moveToSpecialPosition", "targetPos", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "scrollButtonWhenRank", "releasedChild", "scrollToLatestLevelMiddle", "setMatchMode", "setRankMode", "userPosition", "setSelectorImgMargin", "selectorImg", "position", "setTextColor", "acquireViewCenterPos", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LevelSegmentSelectView
  extends FrameLayout
{
  public static final LevelSegmentSelectView.Companion a = new LevelSegmentSelectView.Companion(null);
  private ViewDragHelper b;
  private LinearLayout c;
  private final Paint d = new Paint();
  private final int e = -16777216;
  private final int f = -3355444;
  private int g;
  private final int h = Color.parseColor("#F7F7F7");
  private final int i = Color.parseColor("#F5A300");
  private float j;
  private float k;
  private final float l = 24.0F;
  private int m;
  private int n;
  private int o;
  private HashMap p;
  
  public LevelSegmentSelectView(@NotNull Context paramContext)
  {
    super(paramContext);
    Object localObject = getContext();
    paramContext = (ViewGroup)this;
    FrameLayout.inflate((Context)localObject, 2131629435, paramContext);
    setWillNotDraw(false);
    this.g = ((int)UITools.a(getContext(), 12.0F));
    localObject = findViewById(2131447075);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.textItemLinear)");
    this.c = ((LinearLayout)localObject);
    paramContext = ViewDragHelper.create(paramContext, 1.0F, (ViewDragHelper.Callback)new LevelSegmentSelectView.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ViewDragHelper.create(th…\n            }\n        })");
    this.b = paramContext;
    this.d.setColor(Color.parseColor("#FFDD33"));
    a(2131430783).setOnTouchListener((View.OnTouchListener)new LevelSegmentSelectView.2(this));
    this.j = ((UITools.a(getContext(), this.l) - UITools.a(getContext(), 4.0F)) / 2);
    this.k = (UITools.a(getContext(), this.l) - this.j);
  }
  
  public LevelSegmentSelectView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = getContext();
    paramContext = (ViewGroup)this;
    FrameLayout.inflate(paramAttributeSet, 2131629435, paramContext);
    setWillNotDraw(false);
    this.g = ((int)UITools.a(getContext(), 12.0F));
    paramAttributeSet = findViewById(2131447075);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "findViewById(R.id.textItemLinear)");
    this.c = ((LinearLayout)paramAttributeSet);
    paramContext = ViewDragHelper.create(paramContext, 1.0F, (ViewDragHelper.Callback)new LevelSegmentSelectView.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ViewDragHelper.create(th…\n            }\n        })");
    this.b = paramContext;
    this.d.setColor(Color.parseColor("#FFDD33"));
    a(2131430783).setOnTouchListener((View.OnTouchListener)new LevelSegmentSelectView.2(this));
    this.j = ((UITools.a(getContext(), this.l) - UITools.a(getContext(), 4.0F)) / 2);
    this.k = (UITools.a(getContext(), this.l) - this.j);
  }
  
  public LevelSegmentSelectView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = getContext();
    paramContext = (ViewGroup)this;
    FrameLayout.inflate(paramAttributeSet, 2131629435, paramContext);
    setWillNotDraw(false);
    this.g = ((int)UITools.a(getContext(), 12.0F));
    paramAttributeSet = findViewById(2131447075);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "findViewById(R.id.textItemLinear)");
    this.c = ((LinearLayout)paramAttributeSet);
    paramContext = ViewDragHelper.create(paramContext, 1.0F, (ViewDragHelper.Callback)new LevelSegmentSelectView.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ViewDragHelper.create(th…\n            }\n        })");
    this.b = paramContext;
    this.d.setColor(Color.parseColor("#FFDD33"));
    a(2131430783).setOnTouchListener((View.OnTouchListener)new LevelSegmentSelectView.2(this));
    this.j = ((UITools.a(getContext(), this.l) - UITools.a(getContext(), 4.0F)) / 2);
    this.k = (UITools.a(getContext(), this.l) - this.j);
  }
  
  private final View a(float paramFloat, View paramView)
  {
    View localView = (View)null;
    if (paramView != null)
    {
      localView = b();
      if (paramFloat > localView.getRight())
      {
        localView.offsetLeftAndRight(c(paramView) - c(localView));
        paramView = localView;
      }
      else
      {
        localView = c();
        localView.offsetLeftAndRight(c(paramView) - c(localView));
        paramView = localView;
      }
      d();
      invalidate();
      localView = paramView;
    }
    return localView;
  }
  
  private final void a(float paramFloat)
  {
    View localView = b(paramFloat);
    if (localView != null) {
      a(localView);
    }
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    ImageView localImageView = (ImageView)a(2131439560);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "oneButton");
    b((View)localImageView, paramInt1);
    localImageView = (ImageView)a(2131439706);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "otherButton");
    b((View)localImageView, paramInt2);
    this.c.post((Runnable)new LevelSegmentSelectView.initPosition.1(this));
  }
  
  private final void a(View paramView)
  {
    if (this.m == 1)
    {
      int i1 = c(c(paramView));
      int i2 = b(this.o - 1);
      int i3 = b(this.o + 1);
      if (i1 < i2) {
        a(paramView, i2);
      }
      if (i1 > i3) {
        a(paramView, i3);
      }
      if (this.n == 1)
      {
        ImageView localImageView = (ImageView)a(2131439560);
        if (Intrinsics.areEqual(paramView, (ImageView)a(2131439560))) {
          localImageView = (ImageView)a(2131439706);
        }
        i2 = c(c(paramView));
        Intrinsics.checkExpressionValueIsNotNull(localImageView, "temOtherView");
        View localView = (View)localImageView;
        i1 = c(c(localView));
        if (paramView.getLeft() < localImageView.getLeft())
        {
          i2 = b(i2 + 1);
          if (i1 > i2) {
            a(localView, i2);
          }
        }
        else if (paramView.getLeft() > localImageView.getLeft())
        {
          i2 = b(i2 - 1);
          if (i1 < i2) {
            a(localView, i2);
          }
        }
      }
      invalidate();
      d();
    }
  }
  
  private final void a(View paramView, int paramInt)
  {
    View localView = this.c.getChildAt(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localView, "textItemLinear.getChildAt(targetPos)");
    paramView.offsetLeftAndRight(c(localView) - c(paramView));
  }
  
  private final int b(int paramInt)
  {
    if (paramInt < 0) {
      return 0;
    }
    int i1 = paramInt;
    if (paramInt > this.c.getChildCount() - 1) {
      i1 = this.c.getChildCount() - 1;
    }
    return i1;
  }
  
  private final View b()
  {
    ImageView localImageView = (ImageView)a(2131439560);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "oneButton");
    int i1 = localImageView.getLeft();
    localImageView = (ImageView)a(2131439706);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "otherButton");
    if (i1 > localImageView.getLeft())
    {
      localImageView = (ImageView)a(2131439560);
      Intrinsics.checkExpressionValueIsNotNull(localImageView, "oneButton");
      return (View)localImageView;
    }
    localImageView = (ImageView)a(2131439706);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "otherButton");
    return (View)localImageView;
  }
  
  private final View b(float paramFloat)
  {
    View localView = (View)null;
    if (!e(paramFloat)) {
      localView = a(paramFloat, d(paramFloat));
    }
    return localView;
  }
  
  private final void b(View paramView)
  {
    View localView = d(c(paramView));
    if (localView != null) {
      paramView.offsetLeftAndRight(c(localView) - c(paramView));
    }
    invalidate();
    d();
  }
  
  private final void b(View paramView, int paramInt)
  {
    if ((this.c.getChildCount() > 1) && (paramInt >= 0) && (paramInt < this.c.getChildCount()))
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if ((localLayoutParams instanceof FrameLayout.LayoutParams))
      {
        if (Build.VERSION.SDK_INT >= 17)
        {
          FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)localLayoutParams;
          View localView = this.c.getChildAt(paramInt);
          Intrinsics.checkExpressionValueIsNotNull(localView, "textItemLinear.getChildAt(position)");
          localLayoutParams1.setMarginStart(c(localView) - paramView.getWidth() / 2);
        }
        paramView.setLayoutParams(localLayoutParams);
        paramView.requestLayout();
      }
    }
  }
  
  private final boolean b(float paramFloat, View paramView)
  {
    return (paramFloat >= paramView.getLeft()) && (paramFloat <= paramView.getRight());
  }
  
  private final int c(float paramFloat)
  {
    int i2 = this.c.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = this.c.getChildAt(i1);
      Intrinsics.checkExpressionValueIsNotNull(localView, "textItemLinear.getChildAt(index)");
      if (b(paramFloat, localView)) {
        return i1;
      }
      i1 += 1;
    }
    return 0;
  }
  
  private final int c(@NotNull View paramView)
  {
    return paramView.getLeft() + paramView.getWidth() / 2;
  }
  
  private final View c()
  {
    ImageView localImageView = (ImageView)a(2131439560);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "oneButton");
    int i1 = localImageView.getLeft();
    localImageView = (ImageView)a(2131439706);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "otherButton");
    if (i1 < localImageView.getLeft())
    {
      localImageView = (ImageView)a(2131439560);
      Intrinsics.checkExpressionValueIsNotNull(localImageView, "oneButton");
      return (View)localImageView;
    }
    localImageView = (ImageView)a(2131439706);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "otherButton");
    return (View)localImageView;
  }
  
  private final View d(float paramFloat)
  {
    int i2 = this.c.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = this.c.getChildAt(i1);
      Intrinsics.checkExpressionValueIsNotNull(localView, "textItemLinear.getChildAt(index)");
      if (b(paramFloat, localView)) {
        return this.c.getChildAt(i1);
      }
      i1 += 1;
    }
    return null;
  }
  
  private final void d()
  {
    if (this.c.getChildCount() > 1)
    {
      int i2 = c(c());
      int i3 = c(b());
      float f1 = getWidth() * 1.0F / (this.c.getChildCount() - 1) / 2;
      int i1 = 0;
      int i4 = this.c.getChildCount();
      while (i1 < i4)
      {
        Object localObject1 = this.c.getChildAt(i1);
        if (localObject1 != null)
        {
          localObject1 = (TextView)localObject1;
          int i5 = c((View)localObject1);
          if ((i2 - i5 <= f1) && (i5 - i3 <= f1))
          {
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("<strong>");
            ((StringBuilder)localObject2).append(((TextView)localObject1).getText());
            ((StringBuilder)localObject2).append("</strong>");
            localObject2 = Html.fromHtml(((StringBuilder)localObject2).toString());
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "Html.fromHtml(\"<strong>\"…tView.text + \"</strong>\")");
            ((TextView)localObject1).setText((CharSequence)localObject2);
            ((TextView)localObject1).setTextColor(this.e);
          }
          else
          {
            ((TextView)localObject1).setTextColor(this.f);
          }
          i1 += 1;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
      }
    }
  }
  
  private final boolean e(float paramFloat)
  {
    ImageView localImageView = (ImageView)a(2131439560);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "oneButton");
    if (!b(paramFloat, (View)localImageView))
    {
      localImageView = (ImageView)a(2131439706);
      Intrinsics.checkExpressionValueIsNotNull(localImageView, "otherButton");
      if (!b(paramFloat, (View)localImageView)) {
        return false;
      }
    }
    return true;
  }
  
  public View a(int paramInt)
  {
    if (this.p == null) {
      this.p = new HashMap();
    }
    View localView2 = (View)this.p.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.p.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public final List<String> a()
  {
    List localList = (List)new ArrayList();
    int i2 = this.c.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = this.c.getChildAt(i1);
      if (localObject != null)
      {
        localObject = (TextView)localObject;
        if (((TextView)localObject).getCurrentTextColor() == this.e)
        {
          localObject = ((TextView)localObject).getText();
          if (localObject != null)
          {
            localObject = localObject.toString();
            if (localObject != null) {
              localList.add(localObject);
            }
          }
        }
        i1 += 1;
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
      }
    }
    return localList;
  }
  
  public final void a(@NotNull List<String> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "levelList");
    if (this.c.getChildCount() != 0) {
      return;
    }
    this.c.removeAllViews();
    float f1 = UITools.a(getContext(), 6.0F);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      TextView localTextView = new TextView(getContext());
      localTextView.setText((CharSequence)localObject);
      localTextView.setGravity(17);
      localTextView.setTextSize(1, 12.0F);
      localTextView.setPadding(0, (int)f1, 0, 0);
      localObject = new LinearLayout.LayoutParams(0, -2);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.c.addView((View)localTextView, (ViewGroup.LayoutParams)localObject);
      localTextView.setOnClickListener((View.OnClickListener)new LevelSegmentSelectView.initTextContent.1(this));
    }
  }
  
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    if (getWidth() > this.g)
    {
      this.d.setColor(this.h);
      paramCanvas.drawRect(this.g, this.j, getWidth() - this.g, this.k, this.d);
    }
    this.d.setColor(this.i);
    paramCanvas.drawRect(c(c()), this.j, c(b()), this.k, this.d);
    super.onDraw(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "ev");
    return this.b.shouldInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    this.b.processTouchEvent(paramMotionEvent);
    return true;
  }
  
  public final void setMatchMode(int paramInt1, int paramInt2)
  {
    this.m = 0;
    a(paramInt1, paramInt2);
  }
  
  public final void setRankMode(int paramInt1, int paramInt2)
  {
    this.m = 1;
    this.o = paramInt1;
    this.n = paramInt2;
    if (paramInt2 == 1) {
      paramInt2 = paramInt1;
    } else {
      paramInt2 = paramInt1 - 1;
    }
    int i1 = paramInt1 + 1;
    if (i1 > this.c.getChildCount() - 1) {
      paramInt2 = paramInt1 - 1;
    } else {
      paramInt1 = i1;
    }
    i1 = paramInt2;
    if (paramInt2 < 0) {
      i1 = 0;
    }
    paramInt2 = paramInt1;
    if (paramInt1 > this.c.getChildCount() - 1) {
      paramInt2 = this.c.getChildCount() - 1;
    }
    a(i1, paramInt2);
  }
  
  public final void setRankMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.m = 1;
    this.n = paramInt4;
    this.o = paramInt1;
    a(paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.LevelSegmentSelectView
 * JD-Core Version:    0.7.0.1
 */
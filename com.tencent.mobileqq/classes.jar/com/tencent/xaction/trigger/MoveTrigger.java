package com.tencent.xaction.trigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.LinkView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.trigger.touch.TouchEventHelper;
import com.tencent.xaction.trigger.touch.VelocityTrackerHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/MoveTrigger;", "Lcom/tencent/xaction/trigger/BaseTrigger;", "()V", "direction", "", "getDirection", "()I", "setDirection", "(I)V", "lastEventX", "Ljava/util/concurrent/atomic/AtomicInteger;", "getLastEventX", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setLastEventX", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "lastEventY", "getLastEventY", "setLastEventY", "maxValue", "", "getMaxValue", "()F", "setMaxValue", "(F)V", "pointEvent", "Landroid/graphics/PointF;", "getPointEvent", "()Landroid/graphics/PointF;", "ptype", "", "getPtype", "()Ljava/lang/String;", "setPtype", "(Ljava/lang/String;)V", "speed", "getSpeed", "setSpeed", "trackerHelper", "Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper;", "getTrackerHelper", "()Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper;", "setTrackerHelper", "(Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper;)V", "vts", "getVts", "setVts", "actionMove", "", "v", "Landroid/view/View;", "moveX", "moveY", "getCurXy", "", "getMoveXY", "x", "y", "linkTranslationX", "links", "", "Lcom/tencent/xaction/api/data/LinkView;", "translationX", "linkTranslationY", "translationY", "monitor", "data", "Lcom/tencent/xaction/api/data/ViewData;", "iview", "Lcom/tencent/xaction/api/IView;", "value", "Companion", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class MoveTrigger
  extends BaseTrigger
{
  @NotNull
  public static final String ACTION_DOWN = "movedown";
  @NotNull
  public static final String ACTION_MOVE = "move";
  @NotNull
  public static final String ACTION_UP = "moveup";
  public static final MoveTrigger.Companion Companion = new MoveTrigger.Companion(null);
  public static final int DOWN = 8;
  public static final int LEFT = 16;
  public static final int RIGHT = 4;
  public static final int UP = 2;
  private int direction;
  @NotNull
  private transient AtomicInteger lastEventX = new AtomicInteger();
  @NotNull
  private transient AtomicInteger lastEventY = new AtomicInteger();
  private float maxValue = -1.0F;
  @NotNull
  private final transient PointF pointEvent = new PointF();
  @NotNull
  private String ptype = "translation";
  private float speed = 1.0F;
  @Nullable
  private transient VelocityTrackerHelper trackerHelper;
  private float vts = 1.0F;
  
  private final void actionMove(View paramView, float paramFloat1, float paramFloat2)
  {
    List localList = getLinkViews();
    if (this.direction == 0)
    {
      moveX(paramView, paramFloat1);
      moveY(paramView, paramFloat2);
      linkTranslationY(localList, paramFloat2);
      linkTranslationX(localList, paramFloat1);
    }
    do
    {
      return;
      if (((this.direction & 0x2) > 0) && (paramFloat2 < 0))
      {
        moveY(paramView, paramFloat2);
        linkTranslationY(localList, paramFloat2);
      }
      if (((this.direction & 0x4) > 0) && (paramFloat1 > 0))
      {
        moveX(paramView, paramFloat1);
        linkTranslationX(localList, paramFloat1);
      }
      if (((this.direction & 0x8) > 0) && (paramFloat2 <= 0))
      {
        moveY(paramView, paramFloat2);
        linkTranslationY(localList, paramFloat2);
      }
    } while (((this.direction & 0x10) <= 0) || (paramFloat1 > 0));
    moveX(paramView, paramFloat1);
    linkTranslationX(localList, paramFloat1);
  }
  
  private final float[] getCurXy(View paramView, String paramString)
  {
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return new float[] { paramView.getTranslationX(), paramView.getTranslationY() };
          } while (!paramString.equals("rotate"));
          return new float[] { paramView.getRotationX(), paramView.getRotationY(), paramView.getRotation() };
        } while (!paramString.equals("translation"));
        return new float[] { paramView.getTranslationX(), paramView.getTranslationY() };
      } while (!paramString.equals("scale"));
      return new float[] { paramView.getRotationX(), paramView.getRotationY() };
    } while (!paramString.equals("opacity"));
    return new float[] { paramView.getAlpha() };
  }
  
  private final void linkTranslationX(List<LinkView> paramList, float paramFloat)
  {
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        LinkView localLinkView = (LinkView)paramList.next();
        if (localLinkView.getViews().size() != 0)
        {
          Iterator localIterator = ((Iterable)localLinkView.getViews()).iterator();
          while (localIterator.hasNext())
          {
            View localView = ((IView)localIterator.next()).a().a();
            if (localView != null) {
              moveX(localView, localLinkView.getDamping() * paramFloat);
            }
          }
        }
      }
    }
  }
  
  private final void linkTranslationY(List<LinkView> paramList, float paramFloat)
  {
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        LinkView localLinkView = (LinkView)paramList.next();
        if (localLinkView.getViews().size() != 0)
        {
          Iterator localIterator = ((Iterable)localLinkView.getViews()).iterator();
          while (localIterator.hasNext())
          {
            View localView = ((IView)localIterator.next()).a().a();
            if (localView != null) {
              moveY(localView, localLinkView.getDamping() * paramFloat);
            }
          }
        }
      }
    }
  }
  
  private final void moveX(View paramView, float paramFloat)
  {
    paramFloat = this.speed * paramFloat;
    if ((this.maxValue != -1.0F) && (Math.abs(paramFloat) > this.maxValue)) {}
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            str = this.ptype;
            switch (str.hashCode())
            {
            default: 
              return;
            }
          } while (!str.equals("translation"));
          paramView.setTranslationX(paramFloat);
          return;
        } while (!str.equals("rotate"));
        paramView.setRotationY(paramFloat);
        return;
      } while (!str.equals("scale"));
      paramView.setScaleX(paramFloat);
      return;
    } while (!str.equals("opacity"));
    paramView.setAlpha(paramFloat);
  }
  
  private final void moveY(View paramView, float paramFloat)
  {
    paramFloat = this.speed * paramFloat;
    if ((this.maxValue != -1.0F) && (Math.abs(paramFloat) > this.maxValue)) {}
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            str = this.ptype;
            switch (str.hashCode())
            {
            default: 
              return;
            }
          } while (!str.equals("translation"));
          paramView.setTranslationY(paramFloat);
          return;
        } while (!str.equals("rotate"));
        paramView.setRotationX(paramFloat);
        return;
      } while (!str.equals("scale"));
      paramView.setScaleY(paramFloat);
      return;
    } while (!str.equals("opacity"));
    paramView.setAlpha(paramFloat);
  }
  
  public final int getDirection()
  {
    return this.direction;
  }
  
  @NotNull
  public final AtomicInteger getLastEventX()
  {
    return this.lastEventX;
  }
  
  @NotNull
  public final AtomicInteger getLastEventY()
  {
    return this.lastEventY;
  }
  
  public final float getMaxValue()
  {
    return this.maxValue;
  }
  
  @NotNull
  public final float[] getMoveXY(int paramInt1, int paramInt2, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    int i = this.lastEventX.get();
    int j = this.lastEventY.get();
    paramView = getCurXy(paramView, this.ptype);
    float f1 = paramView[0];
    float f2 = paramInt1 - i;
    float f3 = paramView[1];
    return new float[] { f2 + f1, paramInt2 - j + f3 };
  }
  
  @NotNull
  public final PointF getPointEvent()
  {
    return this.pointEvent;
  }
  
  @NotNull
  public final String getPtype()
  {
    return this.ptype;
  }
  
  public final float getSpeed()
  {
    return this.speed;
  }
  
  @Nullable
  public final VelocityTrackerHelper getTrackerHelper()
  {
    return this.trackerHelper;
  }
  
  public final float getVts()
  {
    return this.vts;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void monitor(@NotNull ViewData paramViewData, @NotNull IView paramIView)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "data");
    Intrinsics.checkParameterIsNotNull(paramIView, "iview");
    super.monitor(paramViewData, paramIView);
    paramViewData = paramIView.a().a();
    if (paramViewData == null) {
      Intrinsics.throwNpe();
    }
    Context localContext = paramViewData.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "view.context");
    localContext = localContext.getApplicationContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "view.context.applicationContext");
    this.trackerHelper = new VelocityTrackerHelper(localContext);
    TouchEventHelper.a.a(paramViewData, (View.OnTouchListener)new MoveTrigger.monitor.1(this, paramIView, paramViewData));
  }
  
  public final void setDirection(int paramInt)
  {
    this.direction = paramInt;
  }
  
  public final void setLastEventX(@NotNull AtomicInteger paramAtomicInteger)
  {
    Intrinsics.checkParameterIsNotNull(paramAtomicInteger, "<set-?>");
    this.lastEventX = paramAtomicInteger;
  }
  
  public final void setLastEventY(@NotNull AtomicInteger paramAtomicInteger)
  {
    Intrinsics.checkParameterIsNotNull(paramAtomicInteger, "<set-?>");
    this.lastEventY = paramAtomicInteger;
  }
  
  public final void setMaxValue(float paramFloat)
  {
    this.maxValue = paramFloat;
  }
  
  public final void setPtype(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.ptype = paramString;
  }
  
  public final void setSpeed(float paramFloat)
  {
    this.speed = paramFloat;
  }
  
  public final void setTrackerHelper(@Nullable VelocityTrackerHelper paramVelocityTrackerHelper)
  {
    this.trackerHelper = paramVelocityTrackerHelper;
  }
  
  public final void setVts(float paramFloat)
  {
    this.vts = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.trigger.MoveTrigger
 * JD-Core Version:    0.7.0.1
 */
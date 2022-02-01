package com.tencent.xaction.trigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnTouchListener;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.LinkView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.trigger.helper.CurrentState;
import com.tencent.xaction.trigger.touch.TouchEventHelper;
import com.tencent.xaction.trigger.touch.VelocityTrackerHelper;
import com.tencent.xaction.trigger.touch.VelocityTrackerHelper.ScrollCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/MoveTrigger;", "Lcom/tencent/xaction/trigger/BaseTrigger;", "()V", "direction", "", "getDirection", "()I", "setDirection", "(I)V", "maxValue", "getMaxValue", "setMaxValue", "maxValueX", "getMaxValueX", "setMaxValueX", "maxValueY", "getMaxValueY", "setMaxValueY", "ptype", "", "getPtype", "()Ljava/lang/String;", "setPtype", "(Ljava/lang/String;)V", "speed", "", "getSpeed", "()F", "setSpeed", "(F)V", "trackerHelper", "Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper;", "getTrackerHelper", "()Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper;", "setTrackerHelper", "(Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper;)V", "vts", "getVts", "setVts", "actionMove", "", "v", "Landroid/view/View;", "mx", "my", "getMaxX", "getMaxY", "linkTranslationX", "links", "", "Lcom/tencent/xaction/api/data/LinkView;", "translationX", "linkTranslationY", "translationY", "monitor", "data", "Lcom/tencent/xaction/api/data/ViewData;", "iview", "Lcom/tencent/xaction/api/IView;", "moveX", "value", "moveY", "trackerActionUp", "view", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
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
  private int maxValue = ScreenUnit.a.a();
  private int maxValueX = ScreenUnit.a.a();
  private int maxValueY = ScreenUnit.a.a();
  @NotNull
  private String ptype = "translation";
  private float speed = 1.0F;
  @Nullable
  private transient VelocityTrackerHelper trackerHelper;
  private float vts = -1.0F;
  
  private final void actionMove(View paramView, float paramFloat1, float paramFloat2)
  {
    List localList = getLinkViews();
    int i = this.direction;
    if (i == 0)
    {
      moveX(paramView, paramFloat1);
      moveY(paramView, paramFloat2);
      linkTranslationY(localList, paramFloat2);
      linkTranslationX(localList, paramFloat1);
      return;
    }
    if (((i & 0x2) > 0) && (paramFloat2 > 0))
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
    if (((this.direction & 0x10) > 0) && (paramFloat1 <= 0))
    {
      moveX(paramView, paramFloat1);
      linkTranslationX(localList, paramFloat1);
    }
  }
  
  private final int getMaxX()
  {
    if (this.maxValue != ScreenUnit.a.a()) {
      return ScreenUnit.a.a(this.maxValue);
    }
    if (this.maxValueX != ScreenUnit.a.a()) {
      return ScreenUnit.a.a(this.maxValueX);
    }
    return ScreenUnit.a.a();
  }
  
  private final int getMaxY()
  {
    if (this.maxValue != ScreenUnit.a.a()) {
      return ScreenUnit.a.a(this.maxValue);
    }
    if (this.maxValueY != ScreenUnit.a.a()) {
      return ScreenUnit.a.a(this.maxValueY);
    }
    return ScreenUnit.a.a();
  }
  
  private final void linkTranslationX(List<LinkView> paramList, float paramFloat)
  {
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        LinkView localLinkView = (LinkView)paramList.next();
        if ((isSameStatus(localLinkView.getStatus())) && (localLinkView.getViews().size() != 0))
        {
          Iterator localIterator = ((Iterable)localLinkView.getViews()).iterator();
          while (localIterator.hasNext())
          {
            View localView = ((IView)localIterator.next()).getDecor().getProxy();
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
        if ((isSameStatus(localLinkView.getStatus())) && (localLinkView.getViews().size() != 0))
        {
          Iterator localIterator = ((Iterable)localLinkView.getViews()).iterator();
          while (localIterator.hasNext())
          {
            View localView = ((IView)localIterator.next()).getDecor().getProxy();
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
    int i = getMaxX();
    if ((i != -1) && (Math.abs(getState().getCx() - getState().getLastDownX()) > i)) {
      return;
    }
    String str = this.ptype;
    switch (str.hashCode())
    {
    default: 
    case 109250890: 
      if (str.equals("scale"))
      {
        paramView.setScaleX(paramView.getScaleX() + paramFloat);
        return;
      }
      break;
    case -925180581: 
      if (str.equals("rotate"))
      {
        paramView.setRotationY(paramView.getRotationY() + paramFloat);
        return;
      }
      break;
    case -1267206133: 
      if (str.equals("opacity"))
      {
        paramView.setAlpha(paramView.getAlpha() + paramFloat);
        return;
      }
      break;
    case -1840647503: 
      if (str.equals("translation")) {
        paramView.setTranslationX(paramView.getTranslationX() + paramFloat);
      }
      break;
    }
  }
  
  private final void moveY(View paramView, float paramFloat)
  {
    paramFloat = this.speed * paramFloat;
    int i = getMaxY();
    if ((i != -1) && (Math.abs(getState().getCy() - getState().getLastDownY()) > i)) {
      return;
    }
    String str = this.ptype;
    switch (str.hashCode())
    {
    default: 
    case 109250890: 
      if (str.equals("scale"))
      {
        paramView.setScaleY(paramView.getScaleY() + paramFloat);
        return;
      }
      break;
    case -925180581: 
      if (str.equals("rotate"))
      {
        paramView.setRotationX(paramView.getRotationX() + paramFloat);
        return;
      }
      break;
    case -1267206133: 
      if (str.equals("opacity"))
      {
        paramView.setAlpha(paramView.getAlpha() + paramFloat);
        return;
      }
      break;
    case -1840647503: 
      if (str.equals("translation")) {
        paramView.setTranslationY(paramView.getTranslationY() + paramFloat);
      }
      break;
    }
  }
  
  private final void trackerActionUp(View paramView1, View paramView2)
  {
    if (this.vts > 0.0F)
    {
      VelocityTrackerHelper localVelocityTrackerHelper = this.trackerHelper;
      if (localVelocityTrackerHelper == null) {
        Intrinsics.throwNpe();
      }
      VelocityTrackerHelper.a(localVelocityTrackerHelper, (VelocityTrackerHelper.ScrollCallback)new MoveTrigger.trackerActionUp.1(this, paramView1, paramView2), 0, 0, this.vts, 6, null);
      return;
    }
    updateStatus(paramView1, "moveup");
  }
  
  public final int getDirection()
  {
    return this.direction;
  }
  
  public final int getMaxValue()
  {
    return this.maxValue;
  }
  
  public final int getMaxValueX()
  {
    return this.maxValueX;
  }
  
  public final int getMaxValueY()
  {
    return this.maxValueY;
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
    paramViewData = paramIView.getDecor().getProxy();
    if (paramViewData == null) {
      Intrinsics.throwNpe();
    }
    Context localContext = paramViewData.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "view.context");
    localContext = localContext.getApplicationContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "view.context.applicationContext");
    this.trackerHelper = new VelocityTrackerHelper(localContext, null, 2, null);
    TouchEventHelper.a.a(paramViewData, (View.OnTouchListener)new MoveTrigger.monitor.1(this, paramIView, paramViewData));
  }
  
  public final void setDirection(int paramInt)
  {
    this.direction = paramInt;
  }
  
  public final void setMaxValue(int paramInt)
  {
    this.maxValue = paramInt;
  }
  
  public final void setMaxValueX(int paramInt)
  {
    this.maxValueX = paramInt;
  }
  
  public final void setMaxValueY(int paramInt)
  {
    this.maxValueY = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.MoveTrigger
 * JD-Core Version:    0.7.0.1
 */
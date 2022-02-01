package com.tencent.xaction.anim;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IEngineLifeCycle;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/PhysicalAnim;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "bodyType", "", "getBodyType", "()I", "setBodyType", "(I)V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "dirX", "getDirX", "setDirX", "dirY", "getDirY", "setDirY", "friction", "getFriction", "setFriction", "mirror", "", "getMirror", "()Z", "setMirror", "(Z)V", "physicalWorld", "Lcom/tencent/xaction/anim/PhysicalWorld;", "restitution", "getRestitution", "setRestitution", "doFrameUpdate", "", "animTime", "end", "init", "layout", "Landroid/view/ViewGroup;", "play", "preStart", "view", "Landroid/view/View;", "XAPhysical_release"}, k=1, mv={1, 1, 16})
@Keep
public final class PhysicalAnim
  extends BaseAnim
{
  private int bodyType = 2;
  private float density = 0.3F;
  private float dirX = 200.0F;
  private float dirY = 200.0F;
  private float friction;
  private boolean mirror;
  private transient PhysicalWorld physicalWorld;
  private float restitution = 0.3F;
  
  private final void init(ViewGroup paramViewGroup)
  {
    Object localObject = getEngine();
    if (!(localObject instanceof XAEngine)) {
      return;
    }
    localObject = (XAEngine)localObject;
    IEngineLifeCycle localIEngineLifeCycle = ((XAEngine)localObject).getPhysicalWorld();
    if ((localIEngineLifeCycle instanceof PhysicalWorld))
    {
      this.physicalWorld = ((PhysicalWorld)localIEngineLifeCycle);
    }
    else
    {
      localIEngineLifeCycle = (IEngineLifeCycle)new PhysicalWorld();
      PhysicalWorld localPhysicalWorld = (PhysicalWorld)localIEngineLifeCycle;
      PhysicalWorld.Params localParams = localPhysicalWorld.a();
      localParams.a(this.density);
      localParams.b(this.friction);
      localParams.c(this.restitution);
      localParams.a(this.bodyType);
      ((XAEngine)localObject).setPhysicalWorld(localIEngineLifeCycle);
      this.physicalWorld = localPhysicalWorld;
    }
    localObject = this.physicalWorld;
    if (localObject != null) {
      ((PhysicalWorld)localObject).a(paramViewGroup.getWidth(), paramViewGroup.getHeight());
    }
  }
  
  public void doFrameUpdate(float paramFloat)
  {
    PhysicalWorld localPhysicalWorld = this.physicalWorld;
    if (localPhysicalWorld != null) {
      localPhysicalWorld.a(paramFloat);
    }
  }
  
  public void end()
  {
    super.end();
    View localView = getView();
    if (localView != null)
    {
      PhysicalWorld localPhysicalWorld = this.physicalWorld;
      if (localPhysicalWorld != null) {
        localPhysicalWorld.a(localView);
      }
    }
  }
  
  public final int getBodyType()
  {
    return this.bodyType;
  }
  
  public final float getDensity()
  {
    return this.density;
  }
  
  public final float getDirX()
  {
    return this.dirX;
  }
  
  public final float getDirY()
  {
    return this.dirY;
  }
  
  public final float getFriction()
  {
    return this.friction;
  }
  
  public final boolean getMirror()
  {
    return this.mirror;
  }
  
  public final float getRestitution()
  {
    return this.restitution;
  }
  
  public void play()
  {
    super.play();
    View localView = getView();
    if (localView != null)
    {
      PhysicalWorld localPhysicalWorld = this.physicalWorld;
      if (localPhysicalWorld != null)
      {
        float f;
        if (this.mirror) {
          f = -this.dirX;
        } else {
          f = this.dirX;
        }
        localPhysicalWorld.a(localView, f, this.dirY);
      }
    }
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    Object localObject = getEngine();
    if (localObject != null)
    {
      localObject = ((IXAEngine)localObject).getLayout();
      if (localObject != null)
      {
        if ((((ViewGroup)localObject).getWidth() != 0) && (((ViewGroup)localObject).getHeight() != 0))
        {
          init((ViewGroup)localObject);
          return;
        }
        paramView.post((Runnable)new PhysicalAnim.preStart..inlined.let.lambda.1((ViewGroup)localObject, this, paramView));
      }
    }
  }
  
  public final void setBodyType(int paramInt)
  {
    this.bodyType = paramInt;
  }
  
  public final void setDensity(float paramFloat)
  {
    this.density = paramFloat;
  }
  
  public final void setDirX(float paramFloat)
  {
    this.dirX = paramFloat;
  }
  
  public final void setDirY(float paramFloat)
  {
    this.dirY = paramFloat;
  }
  
  public final void setFriction(float paramFloat)
  {
    this.friction = paramFloat;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.mirror = paramBoolean;
  }
  
  public final void setRestitution(float paramFloat)
  {
    this.restitution = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.PhysicalAnim
 * JD-Core Version:    0.7.0.1
 */
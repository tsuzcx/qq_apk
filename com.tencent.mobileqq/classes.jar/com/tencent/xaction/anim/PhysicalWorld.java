package com.tencent.xaction.anim;

import android.view.View;
import com.tencent.xaction.api.IEngineLifeCycle;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.impl.XATimeline.Companion;
import com.tencent.xaction.log.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/PhysicalWorld;", "Lcom/tencent/xaction/api/IEngineLifeCycle;", "()V", "FRAME_RATE", "", "boundsBodyList", "Ljava/util/ArrayList;", "Lorg/jbox2d/dynamics/Body;", "Lkotlin/collections/ArrayList;", "frameRateTime", "height", "", "lastSystemTime", "", "params", "Lcom/tencent/xaction/anim/PhysicalWorld$Params;", "getParams", "()Lcom/tencent/xaction/anim/PhysicalWorld$Params;", "setParams", "(Lcom/tencent/xaction/anim/PhysicalWorld$Params;)V", "pixelsPerMeter", "getPixelsPerMeter", "()F", "setPixelsPerMeter", "(F)V", "positionIterations", "getPositionIterations", "()I", "setPositionIterations", "(I)V", "realWorld", "Lorg/jbox2d/dynamics/World;", "velocityIterations", "getVelocityIterations", "setVelocityIterations", "viewBodyMap", "Ljava/util/HashMap;", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "width", "addBody", "", "view", "dirX", "dirY", "create", "createBody", "createBounds", "createFixtureDef", "Lorg/jbox2d/dynamics/FixtureDef;", "box", "Lorg/jbox2d/collision/shapes/Shape;", "createLeftAndRightBounds", "bodyDef", "Lorg/jbox2d/dynamics/BodyDef;", "createTopAndBottomBounds", "doFrame", "animTime", "metersToPixels", "meters", "obainParams", "onDestroy", "pixelsToMeters", "pixels", "radiansToDegrees", "radians", "removeBody", "reset", "Companion", "Params", "XAPhysical_release"}, k=1, mv={1, 1, 16})
public final class PhysicalWorld
  implements IEngineLifeCycle
{
  public static final PhysicalWorld.Companion a = new PhysicalWorld.Companion(null);
  private World b;
  private final HashMap<View, Body> c = new HashMap();
  private final ArrayList<Body> d = new ArrayList();
  private int e;
  private int f;
  private long g;
  private final float h = 1000.0F / XATimeline.a.a() - 4;
  private final float i = 1.0F / XATimeline.a.a();
  private float j = 50.0F;
  @NotNull
  private PhysicalWorld.Params k = new PhysicalWorld.Params(0.0F, 0.0F, 0.0F, false, 0, 31, null);
  private int l = 8;
  private int m = 3;
  
  private final FixtureDef a(Shape paramShape)
  {
    FixtureDef localFixtureDef = new FixtureDef();
    localFixtureDef.shape = paramShape;
    localFixtureDef.density = this.k.a();
    localFixtureDef.friction = this.k.b();
    localFixtureDef.restitution = this.k.c();
    return localFixtureDef;
  }
  
  private final void a(BodyDef paramBodyDef)
  {
    World localWorld = this.b;
    if (localWorld != null)
    {
      Object localObject = new PolygonShape();
      float f1 = c(this.e);
      float f2 = c(this.j);
      ((PolygonShape)localObject).setAsBox(f1, f2);
      localObject = a((Shape)localObject);
      paramBodyDef.position.set(0.0F, -f2);
      Body localBody = localWorld.createBody(paramBodyDef);
      localBody.createFixture((FixtureDef)localObject);
      paramBodyDef.position.set(0.0F, c(this.f + f2));
      paramBodyDef = localWorld.createBody(paramBodyDef);
      paramBodyDef.createFixture((FixtureDef)localObject);
      this.d.add(localBody);
      this.d.add(paramBodyDef);
    }
  }
  
  private final float b(float paramFloat)
  {
    return paramFloat * this.j;
  }
  
  private final void b(BodyDef paramBodyDef)
  {
    World localWorld = this.b;
    if (localWorld != null)
    {
      Object localObject = new PolygonShape();
      float f1 = c(this.j);
      ((PolygonShape)localObject).setAsBox(f1, c(this.f));
      localObject = a((Shape)localObject);
      paramBodyDef.position.set(-f1, 0.0F);
      Body localBody = localWorld.createBody(paramBodyDef);
      localBody.createFixture((FixtureDef)localObject);
      paramBodyDef.position.set(c(this.e + f1), 0.0F);
      paramBodyDef = localWorld.createBody(paramBodyDef);
      paramBodyDef.createFixture((FixtureDef)localObject);
      this.d.add(localBody);
      this.d.add(paramBodyDef);
    }
  }
  
  private final float c(float paramFloat)
  {
    return paramFloat / this.j;
  }
  
  private final void c()
  {
    BodyDef localBodyDef = new BodyDef();
    localBodyDef.type = BodyType.STATIC;
    a(localBodyDef);
    b(localBodyDef);
  }
  
  private final void d()
  {
    this.e = 0;
    this.f = 0;
    Iterator localIterator = ((Iterable)this.d).iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Body)localIterator.next();
      PhysicalWorldKt.a(this.b, (Body)localObject);
    }
    this.d.clear();
    localIterator = ((Map)this.c).entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      PhysicalWorldKt.a(this.b, (Body)((Map.Entry)localObject).getValue());
    }
    this.c.clear();
    this.b = ((World)null);
  }
  
  @NotNull
  public final PhysicalWorld.Params a()
  {
    return this.k;
  }
  
  public final void a(float paramFloat)
  {
    World localWorld = this.b;
    if (localWorld != null)
    {
      if ((float)(System.currentTimeMillis() - this.g) < this.h) {
        return;
      }
      this.g = System.currentTimeMillis();
      try
      {
        localWorld.step(this.i, this.l, this.m);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Iterator localIterator = ((Map)this.c).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        View localView = (View)((Map.Entry)localObject).getKey();
        localObject = (Body)((Map.Entry)localObject).getValue();
        if ((localView.getVisibility() == 0) && (localView.getAlpha() > 0.0F))
        {
          localView.setX(b(((Body)localObject).getPosition().x) - localView.getWidth() / 2.0F);
          localView.setY(b(((Body)localObject).getPosition().y) - localView.getHeight() / 2.0F);
        }
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((this.e == paramInt1) && (this.f == paramInt2) && ((((Collection)this.d).isEmpty() ^ true))) {
      return;
    }
    Iterator localIterator = ((Iterable)this.d).iterator();
    while (localIterator.hasNext())
    {
      Body localBody = (Body)localIterator.next();
      World localWorld = this.b;
      if (localWorld != null) {
        PhysicalWorldKt.a(localWorld, localBody);
      }
    }
    this.d.clear();
    this.e = paramInt1;
    this.f = paramInt2;
    this.b = new World(new Vec2(0.0F, 9.8F));
    c();
  }
  
  public final void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Body localBody = (Body)this.c.get(paramView);
    if ((localBody != null) && (this.b != null))
    {
      this.c.remove(paramView);
      PhysicalWorldKt.a(this.b, localBody);
    }
  }
  
  public final void a(@NotNull View paramView, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramView = b(paramView);
    if (paramView != null)
    {
      paramView.setAwake(true);
      paramView.applyLinearImpulse(new Vec2(paramFloat1, paramFloat2), paramView.getPosition());
    }
  }
  
  @Nullable
  public final Body b(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Object localObject1 = this.b;
    if ((localObject1 != null) && (paramView.getWidth() != 0))
    {
      if (paramView.getHeight() == 0) {
        return null;
      }
      Object localObject2 = (Body)this.c.get(paramView);
      BodyDef localBodyDef = new BodyDef();
      int n = this.k.d();
      if (n != 0)
      {
        if (n != 1)
        {
          if (n == 2) {
            localBodyDef.type = BodyType.DYNAMIC;
          }
        }
        else {
          localBodyDef.type = BodyType.KINEMATIC;
        }
      }
      else {
        localBodyDef.type = BodyType.STATIC;
      }
      localBodyDef.position.set(c(paramView.getX() + paramView.getWidth() / 2), c(paramView.getY() + paramView.getHeight() / 2));
      if (localObject2 != null) {
        PhysicalWorldKt.a((World)localObject1, (Body)localObject2);
      }
      localObject1 = ((World)localObject1).createBody(localBodyDef);
      localObject2 = new PolygonShape();
      ((PolygonShape)localObject2).setAsBox(c(paramView.getWidth() / 2), c(paramView.getHeight() / 2));
      ((Body)localObject1).createFixture(a((Shape)localObject2));
      localObject2 = (Map)this.c;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "body");
      ((Map)localObject2).put(paramView, localObject1);
      return localObject1;
    }
    return null;
  }
  
  public void b()
  {
    QLog.a("PhysicalWorld", 2, "PhysicalWorld onDestroy");
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.PhysicalWorld
 * JD-Core Version:    0.7.0.1
 */
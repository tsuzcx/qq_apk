package com.tencent.xaction.anim;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.xaction.api.IEngineLifeCycle;
import com.tencent.xaction.log.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/PhysicalWorld2;", "Lcom/tencent/xaction/api/IEngineLifeCycle;", "()V", "animTime", "", "getAnimTime", "()F", "setAnimTime", "(F)V", "boundsBodyList", "Ljava/util/ArrayList;", "Lorg/jbox2d/dynamics/Body;", "Lkotlin/collections/ArrayList;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "handlerThread", "Landroid/os/HandlerThread;", "getHandlerThread", "()Landroid/os/HandlerThread;", "setHandlerThread", "(Landroid/os/HandlerThread;)V", "height", "", "lastTime", "pixelsPerMeter", "getPixelsPerMeter", "setPixelsPerMeter", "positionIterations", "getPositionIterations", "()I", "setPositionIterations", "(I)V", "realWorld", "Lorg/jbox2d/dynamics/World;", "rectBodyMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/xaction/anim/XARect;", "velocityIterations", "getVelocityIterations", "setVelocityIterations", "width", "addBody", "", "rect", "dirX", "dirY", "create", "createBody", "createBounds", "createFixtureDef", "Lorg/jbox2d/dynamics/FixtureDef;", "box", "Lorg/jbox2d/collision/shapes/Shape;", "createLeftAndRightBounds", "bodyDef", "Lorg/jbox2d/dynamics/BodyDef;", "createTopAndBottomBounds", "doFrame", "getRectBody", "metersToPixels", "meters", "onDestroy", "pixelsToMeters", "pixels", "post", "runnable", "Ljava/lang/Runnable;", "radiansToDegrees", "radians", "reset", "Companion", "XAPhysical_release"}, k=1, mv={1, 1, 16})
public final class PhysicalWorld2
  implements IEngineLifeCycle
{
  public static final PhysicalWorld2.Companion a = new PhysicalWorld2.Companion(null);
  private World b;
  private final ConcurrentHashMap<XARect, Body> c = new ConcurrentHashMap();
  private final ArrayList<Body> d = new ArrayList();
  private int e;
  private int f;
  private float g = -1.0F;
  private float h = 50.0F;
  @NotNull
  private HandlerThread i = new HandlerThread("physical");
  @Nullable
  private Handler j;
  private int k = 8;
  private int l = 3;
  
  private final FixtureDef a(Shape paramShape)
  {
    FixtureDef localFixtureDef = new FixtureDef();
    localFixtureDef.shape = paramShape;
    localFixtureDef.density = 0.3F;
    localFixtureDef.friction = 0.0F;
    localFixtureDef.restitution = 0.3F;
    return localFixtureDef;
  }
  
  private final void a(Runnable paramRunnable)
  {
    if (!this.i.isAlive()) {
      return;
    }
    Handler localHandler = this.j;
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  private final void a(BodyDef paramBodyDef)
  {
    World localWorld = this.b;
    if (localWorld != null)
    {
      Object localObject = new PolygonShape();
      float f1 = c(this.e);
      float f2 = c(this.h);
      ((PolygonShape)localObject).setAsBox(f1, f2);
      localObject = a((Shape)localObject);
      paramBodyDef.position.set(0.0F, -f2);
      Body localBody = localWorld.createBody(paramBodyDef);
      if (localBody != null)
      {
        localBody.createFixture((FixtureDef)localObject);
        paramBodyDef.position.set(0.0F, c(this.f + f2));
        paramBodyDef = localWorld.createBody(paramBodyDef);
        if (paramBodyDef != null)
        {
          paramBodyDef.createFixture((FixtureDef)localObject);
          this.d.add(localBody);
          this.d.add(paramBodyDef);
        }
      }
    }
  }
  
  private final float b(float paramFloat)
  {
    return paramFloat * this.h;
  }
  
  private final void b(BodyDef paramBodyDef)
  {
    World localWorld = this.b;
    if (localWorld != null)
    {
      Object localObject = new PolygonShape();
      float f1 = c(this.h);
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
    return paramFloat / this.h;
  }
  
  private final float d(float paramFloat)
  {
    return paramFloat / 3.14F * 180.0F;
  }
  
  private final void e()
  {
    BodyDef localBodyDef = new BodyDef();
    localBodyDef.type = BodyType.STATIC;
    a(localBodyDef);
    b(localBodyDef);
  }
  
  private final void f()
  {
    this.e = 0;
    this.f = 0;
    Iterator localIterator = ((Iterable)this.d).iterator();
    Object localObject;
    World localWorld;
    while (localIterator.hasNext())
    {
      localObject = (Body)localIterator.next();
      localWorld = this.b;
      if (localWorld != null) {
        PhysicalWorldKt.a(localWorld, (Body)localObject);
      }
    }
    this.d.clear();
    localIterator = ((Map)this.c).entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      localWorld = this.b;
      if (localWorld != null) {
        PhysicalWorldKt.a(localWorld, (Body)((Map.Entry)localObject).getValue());
      }
    }
    this.c.clear();
    this.b = ((World)null);
  }
  
  public final int a()
  {
    return this.k;
  }
  
  @Nullable
  public final Body a(@NotNull XARect paramXARect)
  {
    Intrinsics.checkParameterIsNotNull(paramXARect, "rect");
    Object localObject1 = this.b;
    if ((localObject1 != null) && (paramXARect.f() != 0))
    {
      if (paramXARect.g() == 0) {
        return null;
      }
      Object localObject2 = (Body)this.c.get(paramXARect);
      BodyDef localBodyDef = new BodyDef();
      localBodyDef.type = BodyType.DYNAMIC;
      localBodyDef.position.set(c(paramXARect.d() + paramXARect.f() / 2.0F), c(paramXARect.e() + paramXARect.g() / 2.0F));
      if (localObject2 != null) {
        PhysicalWorldKt.a((World)localObject1, (Body)localObject2);
      }
      localObject1 = ((World)localObject1).createBody(localBodyDef);
      if (localObject1 != null)
      {
        localObject2 = new PolygonShape();
        ((PolygonShape)localObject2).setAsBox(c(paramXARect.f() / 2), c(paramXARect.g() / 2));
        ((Body)localObject1).createFixture(a((Shape)localObject2));
        ((Map)this.c).put(paramXARect, localObject1);
        return localObject1;
      }
    }
    return null;
  }
  
  public final void a(float paramFloat)
  {
    a((Runnable)new PhysicalWorld2.doFrame.1(this, paramFloat));
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((this.e == paramInt1) && (this.f == paramInt2) && ((((Collection)this.d).isEmpty() ^ true))) {
      return;
    }
    this.i.start();
    this.j = new Handler(this.i.getLooper());
    this.b = new World(new Vec2(0.0F, 9.8F));
    Object localObject = ((Iterable)this.d).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Body localBody = (Body)((Iterator)localObject).next();
      World localWorld = this.b;
      if (localWorld != null) {
        PhysicalWorldKt.a(localWorld, localBody);
      }
    }
    this.d.clear();
    this.e = paramInt1;
    this.f = paramInt2;
    e();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("create width=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", height=");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.a("PhysicalWorld2", 1, ((StringBuilder)localObject).toString());
  }
  
  public final void a(@NotNull XARect paramXARect, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramXARect, "rect");
    a((Runnable)new PhysicalWorld2.addBody.1(this, paramXARect, paramFloat1, paramFloat2));
  }
  
  public void b()
  {
    if (this.i.isAlive())
    {
      this.i.quit();
      this.j = ((Handler)null);
    }
    QLog.a("PhysicalWorld2", 1, "PhysicalWorld onDestroy");
    f();
  }
  
  public final int c()
  {
    return this.l;
  }
  
  @NotNull
  public final ConcurrentHashMap<XARect, Body> d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.PhysicalWorld2
 * JD-Core Version:    0.7.0.1
 */
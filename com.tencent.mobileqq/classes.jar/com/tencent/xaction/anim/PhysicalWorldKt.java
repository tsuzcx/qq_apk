package com.tencent.xaction.anim;

import com.tencent.xaction.log.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"safeDestroyBody", "", "Lorg/jbox2d/dynamics/World;", "body", "Lorg/jbox2d/dynamics/Body;", "XAPhysical_release"}, k=2, mv={1, 1, 16})
public final class PhysicalWorldKt
{
  public static final void a(@Nullable World paramWorld, @NotNull Body paramBody)
  {
    Intrinsics.checkParameterIsNotNull(paramBody, "body");
    if (paramWorld == null) {
      return;
    }
    try
    {
      paramWorld.destroyBody(paramBody);
      return;
    }
    catch (Exception paramWorld)
    {
      QLog.a("PhysicalWorld", 1, "worldDestroyBody error!", (Throwable)paramWorld);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.PhysicalWorldKt
 * JD-Core Version:    0.7.0.1
 */
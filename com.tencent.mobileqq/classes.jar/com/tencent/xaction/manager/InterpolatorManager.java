package com.tencent.xaction.manager;

import com.tencent.xaction.interpolator.AccelerateInterpolator;
import com.tencent.xaction.interpolator.BounceInterpolator;
import com.tencent.xaction.interpolator.SpringInterpolator;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/manager/InterpolatorManager;", "", "()V", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class InterpolatorManager
{
  public static final InterpolatorManager.Companion a = new InterpolatorManager.Companion(null);
  @NotNull
  private static HashMap<String, Class<?>> b = new HashMap();
  
  static
  {
    ((Map)b).put("bound", BounceInterpolator.class);
    ((Map)b).put("accelerate", AccelerateInterpolator.class);
    ((Map)b).put("spring", SpringInterpolator.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.manager.InterpolatorManager
 * JD-Core Version:    0.7.0.1
 */
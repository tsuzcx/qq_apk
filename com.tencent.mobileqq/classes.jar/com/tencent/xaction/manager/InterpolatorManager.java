package com.tencent.xaction.manager;

import com.tencent.xaction.interpolator.AccelerateInterpolator;
import com.tencent.xaction.interpolator.BounceInterpolator;
import com.tencent.xaction.interpolator.SpringInterpolator;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/manager/InterpolatorManager;", "", "()V", "Companion", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class InterpolatorManager
{
  public static final InterpolatorManager.Companion a;
  @NotNull
  private static HashMap<String, Class<?>> a;
  
  static
  {
    jdField_a_of_type_ComTencentXactionManagerInterpolatorManager$Companion = new InterpolatorManager.Companion(null);
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    ((Map)jdField_a_of_type_JavaUtilHashMap).put("bound", BounceInterpolator.class);
    ((Map)jdField_a_of_type_JavaUtilHashMap).put("accelerate", AccelerateInterpolator.class);
    ((Map)jdField_a_of_type_JavaUtilHashMap).put("spring", SpringInterpolator.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.manager.InterpolatorManager
 * JD-Core Version:    0.7.0.1
 */
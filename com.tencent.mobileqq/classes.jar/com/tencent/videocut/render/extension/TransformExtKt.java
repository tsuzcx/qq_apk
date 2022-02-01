package com.tencent.videocut.render.extension;

import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.creator.IComponentCreator;
import com.tencent.videocut.model.PointF;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.Transform;
import com.tencent.videocut.render.FrameFuncKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"calculatePinToEdgeAnchor", "Lcom/tencent/tavcut/composition/model/component/Rect;", "anchorPoint", "Lcom/tencent/videocut/model/PointF;", "renderSize", "Lcom/tencent/videocut/model/SizeF;", "clipSize", "toScreenTransform", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "Lcom/tencent/videocut/model/Transform;", "toScreenTransformPinToEdge", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class TransformExtKt
{
  private static final Rect a(PointF paramPointF, SizeF paramSizeF1, SizeF paramSizeF2)
  {
    if ((0.0F != paramSizeF2.width) && (0.0F != paramSizeF2.height) && (paramSizeF1 != null))
    {
      paramSizeF2 = FrameFuncKt.a(paramSizeF1, paramSizeF2);
      float f1 = -1;
      float f2 = paramPointF.x * paramSizeF1.width / paramSizeF2.width;
      float f3 = 1;
      float f4 = paramPointF.x * paramSizeF1.width / paramSizeF2.width;
      return new Rect(f1 + f2, f3 + paramPointF.y * paramSizeF1.height / paramSizeF2.height, f3 + f4, f1 + paramPointF.y * paramSizeF1.height / paramSizeF2.height, null, 16, null);
    }
    return new Rect(-1.0F, 1.0F, 1.0F, -1.0F, null, 16, null);
  }
  
  @NotNull
  public static final ScreenTransform a(@NotNull Transform paramTransform, @Nullable SizeF paramSizeF1, @NotNull SizeF paramSizeF2)
  {
    Intrinsics.checkParameterIsNotNull(paramTransform, "$this$toScreenTransform");
    Intrinsics.checkParameterIsNotNull(paramSizeF2, "clipSize");
    paramSizeF1 = TavCut.a.e();
    PointF localPointF = paramTransform.anchorPoint;
    float f1;
    if (localPointF != null) {
      f1 = localPointF.x;
    } else {
      f1 = 0.0F;
    }
    localPointF = paramTransform.anchorPoint;
    float f2;
    if (localPointF != null) {
      f2 = localPointF.y;
    } else {
      f2 = 0.0F;
    }
    return paramSizeF1.a(f1, f2, paramSizeF2.width, paramSizeF2.height, paramTransform.scale, paramTransform.rotate);
  }
  
  @NotNull
  public static final ScreenTransform b(@NotNull Transform paramTransform, @Nullable SizeF paramSizeF1, @NotNull SizeF paramSizeF2)
  {
    Intrinsics.checkParameterIsNotNull(paramTransform, "$this$toScreenTransformPinToEdge");
    Intrinsics.checkParameterIsNotNull(paramSizeF2, "clipSize");
    IComponentCreator localIComponentCreator = TavCut.a.e();
    float f1 = paramTransform.scale;
    float f2 = paramTransform.rotate;
    paramTransform = paramTransform.anchorPoint;
    if (paramTransform == null) {
      paramTransform = new PointF(0.0F, 0.0F, null, 7, null);
    }
    return localIComponentCreator.a(f1, f2, a(paramTransform, paramSizeF1, paramSizeF2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.extension.TransformExtKt
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tavcut.utils;

import com.tencent.tavcut.composition.model.component.Quat;
import com.tencent.tavcut.composition.model.component.Vec3;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ANGLE2DEGREE", "", "BASE_SCREEN_HEIGHT", "", "eulerAnglesToQuaternion", "Lcom/tencent/tavcut/composition/model/component/Quat;", "pitch", "roll", "yaw", "getRotation", "screenTransform", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "getScaleX", "getScaleY", "getSize", "Landroid/util/Size;", "pSize", "quaternion2EulerAngles", "Lcom/tencent/tavcut/composition/model/component/Vec3;", "rotation", "setRotation", "rotationDegree", "setScaleX", "scaleX", "setScaleY", "scaleY", "setSize", "size", "toQuaternion", "lib_tavcut_release"}, k=2, mv={1, 1, 16})
public final class ScreenTransformUtilsKt
{
  @NotNull
  public static final Quat a(float paramFloat)
  {
    return a(0.0F, 0.0F, paramFloat / 57.29578F);
  }
  
  @NotNull
  public static final Quat a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    double d1 = paramFloat1 * 0.5F;
    paramFloat1 = (float)Math.cos(d1);
    double d2 = paramFloat2 * 0.5F;
    paramFloat2 = (float)Math.cos(d2);
    double d3 = paramFloat3 * 0.5F;
    Vec3 localVec31 = new Vec3(paramFloat1, paramFloat2, (float)Math.cos(d3), null, 8, null);
    Vec3 localVec32 = new Vec3((float)Math.sin(d1), (float)Math.sin(d2), (float)Math.sin(d3), null, 8, null);
    return new Quat(localVec32.x * localVec31.y * localVec31.z - localVec31.x * localVec32.y * localVec32.z, localVec31.x * localVec32.y * localVec31.z + localVec32.x * localVec31.y * localVec32.z, localVec31.x * localVec31.y * localVec32.z - localVec32.x * localVec32.y * localVec31.z, localVec31.x * localVec31.y * localVec31.z + localVec32.x * localVec32.y * localVec32.z, null, 16, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.utils.ScreenTransformUtilsKt
 * JD-Core Version:    0.7.0.1
 */
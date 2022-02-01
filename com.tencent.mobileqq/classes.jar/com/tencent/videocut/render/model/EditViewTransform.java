package com.tencent.videocut.render.model;

import .r8.java8methods.utility.Float.hashCode.IF;
import android.graphics.PointF;
import android.util.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/model/EditViewTransform;", "", "position", "Landroid/graphics/PointF;", "size", "Landroid/util/Size;", "scale", "", "rotation", "anchorX", "anchorY", "(Landroid/graphics/PointF;Landroid/util/Size;FFFF)V", "getAnchorX", "()F", "setAnchorX", "(F)V", "getAnchorY", "setAnchorY", "getPosition", "()Landroid/graphics/PointF;", "setPosition", "(Landroid/graphics/PointF;)V", "getRotation", "setRotation", "getScale", "setScale", "getSize", "()Landroid/util/Size;", "setSize", "(Landroid/util/Size;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class EditViewTransform
{
  @NotNull
  private PointF a;
  @NotNull
  private Size b;
  private float c;
  private float d;
  private float e;
  private float f;
  
  public EditViewTransform()
  {
    this(null, null, 0.0F, 0.0F, 0.0F, 0.0F, 63, null);
  }
  
  public EditViewTransform(@NotNull PointF paramPointF, @NotNull Size paramSize, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramPointF;
    this.b = paramSize;
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramFloat3;
    this.f = paramFloat4;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof EditViewTransform))
      {
        paramObject = (EditViewTransform)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Float.compare(this.c, paramObject.c) == 0) && (Float.compare(this.d, paramObject.d) == 0) && (Float.compare(this.e, paramObject.e) == 0) && (Float.compare(this.f, paramObject.f) == 0)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return ((((i * 31 + j) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.c)) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.d)) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.e)) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.f);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditViewTransform(position=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", scale=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", rotation=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", anchorX=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", anchorY=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.model.EditViewTransform
 * JD-Core Version:    0.7.0.1
 */
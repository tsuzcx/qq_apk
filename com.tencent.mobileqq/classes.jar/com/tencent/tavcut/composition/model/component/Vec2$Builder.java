package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/Vec2$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/Vec2;", "()V", "x", "", "Ljava/lang/Float;", "y", "build", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Vec2$Builder
  extends Message.Builder<Vec2, Builder>
{
  @JvmField
  @Nullable
  public Float x;
  @JvmField
  @Nullable
  public Float y;
  
  @NotNull
  public Vec2 build()
  {
    Float localFloat = this.x;
    if (localFloat != null)
    {
      float f = localFloat.floatValue();
      localFloat = this.y;
      if (localFloat != null) {
        return new Vec2(f, localFloat.floatValue(), buildUnknownFields());
      }
      throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat, "y" }));
    }
    throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat, "x" }));
  }
  
  @NotNull
  public final Builder x(float paramFloat)
  {
    this.x = Float.valueOf(paramFloat);
    return this;
  }
  
  @NotNull
  public final Builder y(float paramFloat)
  {
    this.y = Float.valueOf(paramFloat);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Vec2.Builder
 * JD-Core Version:    0.7.0.1
 */
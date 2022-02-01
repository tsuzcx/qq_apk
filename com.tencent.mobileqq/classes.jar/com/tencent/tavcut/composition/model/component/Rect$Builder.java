package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/Rect$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/Rect;", "()V", "bottom", "", "Ljava/lang/Float;", "left", "right", "top", "build", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Rect$Builder
  extends Message.Builder<Rect, Builder>
{
  @JvmField
  @Nullable
  public Float bottom;
  @JvmField
  @Nullable
  public Float left;
  @JvmField
  @Nullable
  public Float right;
  @JvmField
  @Nullable
  public Float top;
  
  @NotNull
  public final Builder bottom(float paramFloat)
  {
    this.bottom = Float.valueOf(paramFloat);
    return this;
  }
  
  @NotNull
  public Rect build()
  {
    Float localFloat = this.left;
    if (localFloat != null)
    {
      float f1 = localFloat.floatValue();
      localFloat = this.top;
      if (localFloat != null)
      {
        float f2 = localFloat.floatValue();
        localFloat = this.right;
        if (localFloat != null)
        {
          float f3 = localFloat.floatValue();
          localFloat = this.bottom;
          if (localFloat != null) {
            return new Rect(f1, f2, f3, localFloat.floatValue(), buildUnknownFields());
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat, "bottom" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat, "right" }));
      }
      throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat, "top" }));
    }
    throw ((Throwable)Internal.missingRequiredFields(new Object[] { localFloat, "left" }));
  }
  
  @NotNull
  public final Builder left(float paramFloat)
  {
    this.left = Float.valueOf(paramFloat);
    return this;
  }
  
  @NotNull
  public final Builder right(float paramFloat)
  {
    this.right = Float.valueOf(paramFloat);
    return this;
  }
  
  @NotNull
  public final Builder top(float paramFloat)
  {
    this.top = Float.valueOf(paramFloat);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Rect.Builder
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tavcut.model;

import com.squareup.wire.Message.Builder;
import com.tencent.tavcut.composition.model.component.BackgroundFillMode;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.Size;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/Painting$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/Painting;", "()V", "backgroundColor", "", "backgroundFillMode", "Lcom/tencent/tavcut/composition/model/component/BackgroundFillMode;", "fillScale", "", "Ljava/lang/Float;", "pagPath", "renderSize", "Lcom/tencent/tavcut/composition/model/component/Size;", "screenTransform", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "build", "(Ljava/lang/Float;)Lcom/tencent/tavcut/model/Painting$Builder;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Painting$Builder
  extends Message.Builder<Painting, Builder>
{
  @JvmField
  @Nullable
  public String backgroundColor;
  @JvmField
  @Nullable
  public BackgroundFillMode backgroundFillMode;
  @JvmField
  @Nullable
  public Float fillScale;
  @JvmField
  @Nullable
  public String pagPath;
  @JvmField
  @Nullable
  public Size renderSize;
  @JvmField
  @Nullable
  public ScreenTransform screenTransform;
  
  @NotNull
  public final Builder backgroundColor(@Nullable String paramString)
  {
    this.backgroundColor = paramString;
    return this;
  }
  
  @NotNull
  public final Builder backgroundFillMode(@Nullable BackgroundFillMode paramBackgroundFillMode)
  {
    this.backgroundFillMode = paramBackgroundFillMode;
    return this;
  }
  
  @NotNull
  public Painting build()
  {
    return new Painting(this.renderSize, this.screenTransform, this.backgroundFillMode, this.pagPath, this.backgroundColor, this.fillScale, buildUnknownFields());
  }
  
  @NotNull
  public final Builder fillScale(@Nullable Float paramFloat)
  {
    this.fillScale = paramFloat;
    return this;
  }
  
  @NotNull
  public final Builder pagPath(@Nullable String paramString)
  {
    this.pagPath = paramString;
    return this;
  }
  
  @NotNull
  public final Builder renderSize(@Nullable Size paramSize)
  {
    this.renderSize = paramSize;
    return this;
  }
  
  @NotNull
  public final Builder screenTransform(@Nullable ScreenTransform paramScreenTransform)
  {
    this.screenTransform = paramScreenTransform;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.Painting.Builder
 * JD-Core Version:    0.7.0.1
 */
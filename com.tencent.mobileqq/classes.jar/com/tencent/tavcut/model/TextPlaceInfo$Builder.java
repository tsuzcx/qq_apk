package com.tencent.tavcut.model;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/model/TextPlaceInfo$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/model/TextPlaceInfo;", "()V", "entityId", "", "Ljava/lang/Integer;", "fillColor", "key", "", "layerHeight", "", "Ljava/lang/Float;", "layerWidth", "maxLength", "replaceIndex", "text", "build", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TextPlaceInfo$Builder
  extends Message.Builder<TextPlaceInfo, Builder>
{
  @JvmField
  @Nullable
  public Integer entityId;
  @JvmField
  @Nullable
  public Integer fillColor;
  @JvmField
  @Nullable
  public String key;
  @JvmField
  @Nullable
  public Float layerHeight;
  @JvmField
  @Nullable
  public Float layerWidth;
  @JvmField
  @Nullable
  public Integer maxLength;
  @JvmField
  @Nullable
  public Integer replaceIndex;
  @JvmField
  @Nullable
  public String text;
  
  @NotNull
  public TextPlaceInfo build()
  {
    String str1 = this.key;
    String str2 = this.text;
    Object localObject = this.fillColor;
    if (localObject != null)
    {
      int i = ((Integer)localObject).intValue();
      localObject = this.maxLength;
      if (localObject != null)
      {
        int j = ((Integer)localObject).intValue();
        localObject = this.layerWidth;
        if (localObject != null)
        {
          float f1 = ((Float)localObject).floatValue();
          localObject = this.layerHeight;
          if (localObject != null)
          {
            float f2 = ((Float)localObject).floatValue();
            localObject = this.replaceIndex;
            if (localObject != null)
            {
              int k = ((Integer)localObject).intValue();
              localObject = this.entityId;
              if (localObject != null) {
                return new TextPlaceInfo(str1, str2, i, j, f1, f2, k, ((Integer)localObject).intValue(), buildUnknownFields());
              }
              throw ((Throwable)Internal.missingRequiredFields(new Object[] { localObject, "entityId" }));
            }
            throw ((Throwable)Internal.missingRequiredFields(new Object[] { localObject, "replaceIndex" }));
          }
          throw ((Throwable)Internal.missingRequiredFields(new Object[] { localObject, "layerHeight" }));
        }
        throw ((Throwable)Internal.missingRequiredFields(new Object[] { localObject, "layerWidth" }));
      }
      throw ((Throwable)Internal.missingRequiredFields(new Object[] { localObject, "maxLength" }));
    }
    throw ((Throwable)Internal.missingRequiredFields(new Object[] { localObject, "fillColor" }));
  }
  
  @NotNull
  public final Builder entityId(int paramInt)
  {
    this.entityId = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final Builder fillColor(int paramInt)
  {
    this.fillColor = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final Builder key(@Nullable String paramString)
  {
    this.key = paramString;
    return this;
  }
  
  @NotNull
  public final Builder layerHeight(float paramFloat)
  {
    this.layerHeight = Float.valueOf(paramFloat);
    return this;
  }
  
  @NotNull
  public final Builder layerWidth(float paramFloat)
  {
    this.layerWidth = Float.valueOf(paramFloat);
    return this;
  }
  
  @NotNull
  public final Builder maxLength(int paramInt)
  {
    this.maxLength = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final Builder replaceIndex(int paramInt)
  {
    this.replaceIndex = Integer.valueOf(paramInt);
    return this;
  }
  
  @NotNull
  public final Builder text(@Nullable String paramString)
  {
    this.text = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.TextPlaceInfo.Builder
 * JD-Core Version:    0.7.0.1
 */
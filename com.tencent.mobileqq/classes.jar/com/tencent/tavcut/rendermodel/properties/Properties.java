package com.tencent.tavcut.rendermodel.properties;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/properties/Properties;", "", "layout", "Lcom/tencent/tavcut/rendermodel/properties/Layout;", "boundsTrackerPlaceHolders", "Lcom/google/gson/JsonArray;", "musicIDs", "fonts", "movieConfig", "Lcom/google/gson/JsonObject;", "materialConfigs", "resourceIDs", "(Lcom/tencent/tavcut/rendermodel/properties/Layout;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;)V", "getBoundsTrackerPlaceHolders", "()Lcom/google/gson/JsonArray;", "getFonts", "getLayout", "()Lcom/tencent/tavcut/rendermodel/properties/Layout;", "getMaterialConfigs", "getMovieConfig", "()Lcom/google/gson/JsonObject;", "getMusicIDs", "getResourceIDs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Properties
{
  @Nullable
  private final JsonArray boundsTrackerPlaceHolders;
  @Nullable
  private final JsonArray fonts;
  @Nullable
  private final Layout layout;
  @Nullable
  private final JsonArray materialConfigs;
  @Nullable
  private final JsonObject movieConfig;
  @Nullable
  private final JsonArray musicIDs;
  @Nullable
  private final JsonArray resourceIDs;
  
  public Properties()
  {
    this(null, null, null, null, null, null, null, 127, null);
  }
  
  public Properties(@Nullable Layout paramLayout, @Nullable JsonArray paramJsonArray1, @Nullable JsonArray paramJsonArray2, @Nullable JsonArray paramJsonArray3, @Nullable JsonObject paramJsonObject, @Nullable JsonArray paramJsonArray4, @Nullable JsonArray paramJsonArray5)
  {
    this.layout = paramLayout;
    this.boundsTrackerPlaceHolders = paramJsonArray1;
    this.musicIDs = paramJsonArray2;
    this.fonts = paramJsonArray3;
    this.movieConfig = paramJsonObject;
    this.materialConfigs = paramJsonArray4;
    this.resourceIDs = paramJsonArray5;
  }
  
  @Nullable
  public final Layout component1()
  {
    return this.layout;
  }
  
  @Nullable
  public final JsonArray component2()
  {
    return this.boundsTrackerPlaceHolders;
  }
  
  @Nullable
  public final JsonArray component3()
  {
    return this.musicIDs;
  }
  
  @Nullable
  public final JsonArray component4()
  {
    return this.fonts;
  }
  
  @Nullable
  public final JsonObject component5()
  {
    return this.movieConfig;
  }
  
  @Nullable
  public final JsonArray component6()
  {
    return this.materialConfigs;
  }
  
  @Nullable
  public final JsonArray component7()
  {
    return this.resourceIDs;
  }
  
  @NotNull
  public final Properties copy(@Nullable Layout paramLayout, @Nullable JsonArray paramJsonArray1, @Nullable JsonArray paramJsonArray2, @Nullable JsonArray paramJsonArray3, @Nullable JsonObject paramJsonObject, @Nullable JsonArray paramJsonArray4, @Nullable JsonArray paramJsonArray5)
  {
    return new Properties(paramLayout, paramJsonArray1, paramJsonArray2, paramJsonArray3, paramJsonObject, paramJsonArray4, paramJsonArray5);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Properties))
      {
        paramObject = (Properties)paramObject;
        if ((Intrinsics.areEqual(this.layout, paramObject.layout)) && (Intrinsics.areEqual(this.boundsTrackerPlaceHolders, paramObject.boundsTrackerPlaceHolders)) && (Intrinsics.areEqual(this.musicIDs, paramObject.musicIDs)) && (Intrinsics.areEqual(this.fonts, paramObject.fonts)) && (Intrinsics.areEqual(this.movieConfig, paramObject.movieConfig)) && (Intrinsics.areEqual(this.materialConfigs, paramObject.materialConfigs)) && (Intrinsics.areEqual(this.resourceIDs, paramObject.resourceIDs))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final JsonArray getBoundsTrackerPlaceHolders()
  {
    return this.boundsTrackerPlaceHolders;
  }
  
  @Nullable
  public final JsonArray getFonts()
  {
    return this.fonts;
  }
  
  @Nullable
  public final Layout getLayout()
  {
    return this.layout;
  }
  
  @Nullable
  public final JsonArray getMaterialConfigs()
  {
    return this.materialConfigs;
  }
  
  @Nullable
  public final JsonObject getMovieConfig()
  {
    return this.movieConfig;
  }
  
  @Nullable
  public final JsonArray getMusicIDs()
  {
    return this.musicIDs;
  }
  
  @Nullable
  public final JsonArray getResourceIDs()
  {
    return this.resourceIDs;
  }
  
  public int hashCode()
  {
    Object localObject = this.layout;
    int i2 = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.boundsTrackerPlaceHolders;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.musicIDs;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.fonts;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.movieConfig;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.materialConfigs;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    localObject = this.resourceIDs;
    if (localObject != null) {
      i2 = localObject.hashCode();
    }
    return (((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Properties(layout=");
    localStringBuilder.append(this.layout);
    localStringBuilder.append(", boundsTrackerPlaceHolders=");
    localStringBuilder.append(this.boundsTrackerPlaceHolders);
    localStringBuilder.append(", musicIDs=");
    localStringBuilder.append(this.musicIDs);
    localStringBuilder.append(", fonts=");
    localStringBuilder.append(this.fonts);
    localStringBuilder.append(", movieConfig=");
    localStringBuilder.append(this.movieConfig);
    localStringBuilder.append(", materialConfigs=");
    localStringBuilder.append(this.materialConfigs);
    localStringBuilder.append(", resourceIDs=");
    localStringBuilder.append(this.resourceIDs);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.properties.Properties
 * JD-Core Version:    0.7.0.1
 */
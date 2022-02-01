package com.tencent.mobileqq.profilecard.vas;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "", "diyText", "", "diyTextFontId", "", "diyTextWidth", "", "diyTextHeight", "diyTextLocX", "diyTextLocY", "diyTextDegree", "diyTextScale", "diyTextTransparency", "diyDefaultText", "(Ljava/lang/String;IFFFFFFFLjava/lang/String;)V", "getDiyDefaultText", "()Ljava/lang/String;", "getDiyText", "getDiyTextDegree", "()F", "getDiyTextFontId", "()I", "getDiyTextHeight", "getDiyTextLocX", "getDiyTextLocY", "getDiyTextScale", "getDiyTextTransparency", "getDiyTextWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasDiyTextData
{
  @Nullable
  private final String diyDefaultText;
  @Nullable
  private final String diyText;
  private final float diyTextDegree;
  private final int diyTextFontId;
  private final float diyTextHeight;
  private final float diyTextLocX;
  private final float diyTextLocY;
  private final float diyTextScale;
  private final float diyTextTransparency;
  private final float diyTextWidth;
  
  public VasDiyTextData()
  {
    this(null, 0, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, null, 1023, null);
  }
  
  public VasDiyTextData(@Nullable String paramString1, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, @Nullable String paramString2)
  {
    this.diyText = paramString1;
    this.diyTextFontId = paramInt;
    this.diyTextWidth = paramFloat1;
    this.diyTextHeight = paramFloat2;
    this.diyTextLocX = paramFloat3;
    this.diyTextLocY = paramFloat4;
    this.diyTextDegree = paramFloat5;
    this.diyTextScale = paramFloat6;
    this.diyTextTransparency = paramFloat7;
    this.diyDefaultText = paramString2;
  }
  
  @Nullable
  public final String component1()
  {
    return this.diyText;
  }
  
  @Nullable
  public final String component10()
  {
    return this.diyDefaultText;
  }
  
  public final int component2()
  {
    return this.diyTextFontId;
  }
  
  public final float component3()
  {
    return this.diyTextWidth;
  }
  
  public final float component4()
  {
    return this.diyTextHeight;
  }
  
  public final float component5()
  {
    return this.diyTextLocX;
  }
  
  public final float component6()
  {
    return this.diyTextLocY;
  }
  
  public final float component7()
  {
    return this.diyTextDegree;
  }
  
  public final float component8()
  {
    return this.diyTextScale;
  }
  
  public final float component9()
  {
    return this.diyTextTransparency;
  }
  
  @NotNull
  public final VasDiyTextData copy(@Nullable String paramString1, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, @Nullable String paramString2)
  {
    return new VasDiyTextData(paramString1, paramInt, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramString2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VasDiyTextData))
      {
        paramObject = (VasDiyTextData)paramObject;
        if ((Intrinsics.areEqual(this.diyText, paramObject.diyText)) && (this.diyTextFontId == paramObject.diyTextFontId) && (Float.compare(this.diyTextWidth, paramObject.diyTextWidth) == 0) && (Float.compare(this.diyTextHeight, paramObject.diyTextHeight) == 0) && (Float.compare(this.diyTextLocX, paramObject.diyTextLocX) == 0) && (Float.compare(this.diyTextLocY, paramObject.diyTextLocY) == 0) && (Float.compare(this.diyTextDegree, paramObject.diyTextDegree) == 0) && (Float.compare(this.diyTextScale, paramObject.diyTextScale) == 0) && (Float.compare(this.diyTextTransparency, paramObject.diyTextTransparency) == 0) && (Intrinsics.areEqual(this.diyDefaultText, paramObject.diyDefaultText))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final String getDiyDefaultText()
  {
    return this.diyDefaultText;
  }
  
  @Nullable
  public final String getDiyText()
  {
    return this.diyText;
  }
  
  public final float getDiyTextDegree()
  {
    return this.diyTextDegree;
  }
  
  public final int getDiyTextFontId()
  {
    return this.diyTextFontId;
  }
  
  public final float getDiyTextHeight()
  {
    return this.diyTextHeight;
  }
  
  public final float getDiyTextLocX()
  {
    return this.diyTextLocX;
  }
  
  public final float getDiyTextLocY()
  {
    return this.diyTextLocY;
  }
  
  public final float getDiyTextScale()
  {
    return this.diyTextScale;
  }
  
  public final float getDiyTextTransparency()
  {
    return this.diyTextTransparency;
  }
  
  public final float getDiyTextWidth()
  {
    return this.diyTextWidth;
  }
  
  public int hashCode()
  {
    String str = this.diyText;
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    int k = this.diyTextFontId;
    int m = Float.floatToIntBits(this.diyTextWidth);
    int n = Float.floatToIntBits(this.diyTextHeight);
    int i1 = Float.floatToIntBits(this.diyTextLocX);
    int i2 = Float.floatToIntBits(this.diyTextLocY);
    int i3 = Float.floatToIntBits(this.diyTextDegree);
    int i4 = Float.floatToIntBits(this.diyTextScale);
    int i5 = Float.floatToIntBits(this.diyTextTransparency);
    str = this.diyDefaultText;
    if (str != null) {
      j = str.hashCode();
    }
    return ((((((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VasDiyTextData(diyText=");
    localStringBuilder.append(this.diyText);
    localStringBuilder.append(", diyTextFontId=");
    localStringBuilder.append(this.diyTextFontId);
    localStringBuilder.append(", diyTextWidth=");
    localStringBuilder.append(this.diyTextWidth);
    localStringBuilder.append(", diyTextHeight=");
    localStringBuilder.append(this.diyTextHeight);
    localStringBuilder.append(", diyTextLocX=");
    localStringBuilder.append(this.diyTextLocX);
    localStringBuilder.append(", diyTextLocY=");
    localStringBuilder.append(this.diyTextLocY);
    localStringBuilder.append(", diyTextDegree=");
    localStringBuilder.append(this.diyTextDegree);
    localStringBuilder.append(", diyTextScale=");
    localStringBuilder.append(this.diyTextScale);
    localStringBuilder.append(", diyTextTransparency=");
    localStringBuilder.append(this.diyTextTransparency);
    localStringBuilder.append(", diyDefaultText=");
    localStringBuilder.append(this.diyDefaultText);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasDiyTextData
 * JD-Core Version:    0.7.0.1
 */
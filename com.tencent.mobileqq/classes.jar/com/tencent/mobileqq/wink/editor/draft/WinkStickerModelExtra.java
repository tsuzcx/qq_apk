package com.tencent.mobileqq.wink.editor.draft;

import .r8.java8methods.utility.Float.hashCode.IF;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.model.PointF;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/draft/WinkStickerModelExtra;", "Ljava/io/Serializable;", "initStickerScale", "", "downScaleRecord", "originPointInView", "Lcom/tencent/mobileqq/wink/editor/model/PointF;", "sizeInView", "centerInView", "leftTopInView", "rightBottomInView", "material", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "lastDownScale", "lastDownRotate", "(FFLcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcom/tencent/mobileqq/wink/editor/model/PointF;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;FF)V", "getCenterInView", "()Lcom/tencent/mobileqq/wink/editor/model/PointF;", "getDownScaleRecord", "()F", "getInitStickerScale", "getLastDownRotate", "getLastDownScale", "getLeftTopInView", "getMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getOriginPointInView", "getRightBottomInView", "getSizeInView", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkStickerModelExtra
  implements Serializable
{
  @NotNull
  private final PointF centerInView;
  private final float downScaleRecord;
  private final float initStickerScale;
  private final float lastDownRotate;
  private final float lastDownScale;
  @NotNull
  private final PointF leftTopInView;
  @Nullable
  private final MetaMaterial material;
  @NotNull
  private final PointF originPointInView;
  @NotNull
  private final PointF rightBottomInView;
  @NotNull
  private final PointF sizeInView;
  
  public WinkStickerModelExtra()
  {
    this(0.0F, 0.0F, null, null, null, null, null, null, 0.0F, 0.0F, 1023, null);
  }
  
  public WinkStickerModelExtra(float paramFloat1, float paramFloat2, @NotNull PointF paramPointF1, @NotNull PointF paramPointF2, @NotNull PointF paramPointF3, @NotNull PointF paramPointF4, @NotNull PointF paramPointF5, @Nullable MetaMaterial paramMetaMaterial, float paramFloat3, float paramFloat4)
  {
    this.initStickerScale = paramFloat1;
    this.downScaleRecord = paramFloat2;
    this.originPointInView = paramPointF1;
    this.sizeInView = paramPointF2;
    this.centerInView = paramPointF3;
    this.leftTopInView = paramPointF4;
    this.rightBottomInView = paramPointF5;
    this.material = paramMetaMaterial;
    this.lastDownScale = paramFloat3;
    this.lastDownRotate = paramFloat4;
  }
  
  public final float component1()
  {
    return this.initStickerScale;
  }
  
  public final float component10()
  {
    return this.lastDownRotate;
  }
  
  public final float component2()
  {
    return this.downScaleRecord;
  }
  
  @NotNull
  public final PointF component3()
  {
    return this.originPointInView;
  }
  
  @NotNull
  public final PointF component4()
  {
    return this.sizeInView;
  }
  
  @NotNull
  public final PointF component5()
  {
    return this.centerInView;
  }
  
  @NotNull
  public final PointF component6()
  {
    return this.leftTopInView;
  }
  
  @NotNull
  public final PointF component7()
  {
    return this.rightBottomInView;
  }
  
  @Nullable
  public final MetaMaterial component8()
  {
    return this.material;
  }
  
  public final float component9()
  {
    return this.lastDownScale;
  }
  
  @NotNull
  public final WinkStickerModelExtra copy(float paramFloat1, float paramFloat2, @NotNull PointF paramPointF1, @NotNull PointF paramPointF2, @NotNull PointF paramPointF3, @NotNull PointF paramPointF4, @NotNull PointF paramPointF5, @Nullable MetaMaterial paramMetaMaterial, float paramFloat3, float paramFloat4)
  {
    Intrinsics.checkParameterIsNotNull(paramPointF1, "originPointInView");
    Intrinsics.checkParameterIsNotNull(paramPointF2, "sizeInView");
    Intrinsics.checkParameterIsNotNull(paramPointF3, "centerInView");
    Intrinsics.checkParameterIsNotNull(paramPointF4, "leftTopInView");
    Intrinsics.checkParameterIsNotNull(paramPointF5, "rightBottomInView");
    return new WinkStickerModelExtra(paramFloat1, paramFloat2, paramPointF1, paramPointF2, paramPointF3, paramPointF4, paramPointF5, paramMetaMaterial, paramFloat3, paramFloat4);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof WinkStickerModelExtra))
      {
        paramObject = (WinkStickerModelExtra)paramObject;
        if ((Float.compare(this.initStickerScale, paramObject.initStickerScale) == 0) && (Float.compare(this.downScaleRecord, paramObject.downScaleRecord) == 0) && (Intrinsics.areEqual(this.originPointInView, paramObject.originPointInView)) && (Intrinsics.areEqual(this.sizeInView, paramObject.sizeInView)) && (Intrinsics.areEqual(this.centerInView, paramObject.centerInView)) && (Intrinsics.areEqual(this.leftTopInView, paramObject.leftTopInView)) && (Intrinsics.areEqual(this.rightBottomInView, paramObject.rightBottomInView)) && (Intrinsics.areEqual(this.material, paramObject.material)) && (Float.compare(this.lastDownScale, paramObject.lastDownScale) == 0) && (Float.compare(this.lastDownRotate, paramObject.lastDownRotate) == 0)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final PointF getCenterInView()
  {
    return this.centerInView;
  }
  
  public final float getDownScaleRecord()
  {
    return this.downScaleRecord;
  }
  
  public final float getInitStickerScale()
  {
    return this.initStickerScale;
  }
  
  public final float getLastDownRotate()
  {
    return this.lastDownRotate;
  }
  
  public final float getLastDownScale()
  {
    return this.lastDownScale;
  }
  
  @NotNull
  public final PointF getLeftTopInView()
  {
    return this.leftTopInView;
  }
  
  @Nullable
  public final MetaMaterial getMaterial()
  {
    return this.material;
  }
  
  @NotNull
  public final PointF getOriginPointInView()
  {
    return this.originPointInView;
  }
  
  @NotNull
  public final PointF getRightBottomInView()
  {
    return this.rightBottomInView;
  }
  
  @NotNull
  public final PointF getSizeInView()
  {
    return this.sizeInView;
  }
  
  public int hashCode()
  {
    int i2 = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.initStickerScale);
    int i3 = .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.downScaleRecord);
    Object localObject = this.originPointInView;
    int i1 = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.sizeInView;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.centerInView;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.leftTopInView;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.rightBottomInView;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.material;
    if (localObject != null) {
      i1 = localObject.hashCode();
    }
    return ((((((((i2 * 31 + i3) * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.lastDownScale)) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.lastDownRotate);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WinkStickerModelExtra(initStickerScale=");
    localStringBuilder.append(this.initStickerScale);
    localStringBuilder.append(", downScaleRecord=");
    localStringBuilder.append(this.downScaleRecord);
    localStringBuilder.append(", originPointInView=");
    localStringBuilder.append(this.originPointInView);
    localStringBuilder.append(", sizeInView=");
    localStringBuilder.append(this.sizeInView);
    localStringBuilder.append(", centerInView=");
    localStringBuilder.append(this.centerInView);
    localStringBuilder.append(", leftTopInView=");
    localStringBuilder.append(this.leftTopInView);
    localStringBuilder.append(", rightBottomInView=");
    localStringBuilder.append(this.rightBottomInView);
    localStringBuilder.append(", material=");
    localStringBuilder.append(this.material);
    localStringBuilder.append(", lastDownScale=");
    localStringBuilder.append(this.lastDownScale);
    localStringBuilder.append(", lastDownRotate=");
    localStringBuilder.append(this.lastDownRotate);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.draft.WinkStickerModelExtra
 * JD-Core Version:    0.7.0.1
 */
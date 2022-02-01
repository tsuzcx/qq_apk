package com.tencent.xaction.api.data;

import androidx.annotation.Keep;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.BaseAnim;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/LinkView;", "", "()V", "anim", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/base/BaseAnim;", "Lkotlin/collections/ArrayList;", "getAnim", "()Ljava/util/ArrayList;", "damping", "", "getDamping", "()F", "setDamping", "(F)V", "float", "", "getFloat", "()Ljava/lang/String;", "setFloat", "(Ljava/lang/String;)V", "floatData", "Lcom/tencent/xaction/api/data/FloatViewData;", "getFloatData", "()Lcom/tencent/xaction/api/data/FloatViewData;", "setFloatData", "(Lcom/tencent/xaction/api/data/FloatViewData;)V", "lId", "", "", "getLId", "()[Ljava/lang/Integer;", "setLId", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "maxValue", "getMaxValue", "setMaxValue", "status", "getStatus", "setStatus", "views", "Lcom/tencent/xaction/api/IView;", "getViews", "setViews", "(Ljava/util/ArrayList;)V", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class LinkView
{
  @Nullable
  private final ArrayList<BaseAnim> anim;
  private float damping = 1.0F;
  @NotNull
  private String jdField_float = "";
  @NotNull
  private transient FloatViewData floatData = new FloatViewData();
  @Nullable
  private Integer[] lId;
  private float maxValue;
  @NotNull
  private String status = "";
  @NotNull
  private transient ArrayList<IView> views = new ArrayList();
  
  @Nullable
  public final ArrayList<BaseAnim> getAnim()
  {
    return this.anim;
  }
  
  public final float getDamping()
  {
    return this.damping;
  }
  
  @NotNull
  public final String getFloat()
  {
    return this.jdField_float;
  }
  
  @NotNull
  public final FloatViewData getFloatData()
  {
    return this.floatData;
  }
  
  @Nullable
  public final Integer[] getLId()
  {
    return this.lId;
  }
  
  public final float getMaxValue()
  {
    return this.maxValue;
  }
  
  @NotNull
  public final String getStatus()
  {
    return this.status;
  }
  
  @NotNull
  public final ArrayList<IView> getViews()
  {
    return this.views;
  }
  
  public final void setDamping(float paramFloat)
  {
    this.damping = paramFloat;
  }
  
  public final void setFloat(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_float = paramString;
  }
  
  public final void setFloatData(@NotNull FloatViewData paramFloatViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatViewData, "<set-?>");
    this.floatData = paramFloatViewData;
  }
  
  public final void setLId(@Nullable Integer[] paramArrayOfInteger)
  {
    this.lId = paramArrayOfInteger;
  }
  
  public final void setMaxValue(float paramFloat)
  {
    this.maxValue = paramFloat;
  }
  
  public final void setStatus(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.status = paramString;
  }
  
  public final void setViews(@NotNull ArrayList<IView> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.views = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.data.LinkView
 * JD-Core Version:    0.7.0.1
 */
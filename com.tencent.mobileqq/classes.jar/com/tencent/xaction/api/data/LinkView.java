package com.tencent.xaction.api.data;

import androidx.annotation.Keep;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/LinkView;", "", "()V", "anim", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/base/BaseAnim;", "Lkotlin/collections/ArrayList;", "getAnim", "()Ljava/util/ArrayList;", "bx", "", "getBx", "()I", "setBx", "(I)V", "by", "getBy", "setBy", "damping", "", "getDamping", "()F", "setDamping", "(F)V", "float", "", "getFloat", "()Ljava/lang/String;", "setFloat", "(Ljava/lang/String;)V", "floatData", "Lcom/tencent/xaction/api/data/FloatViewData;", "getFloatData", "()Lcom/tencent/xaction/api/data/FloatViewData;", "setFloatData", "(Lcom/tencent/xaction/api/data/FloatViewData;)V", "fx", "getFx", "setFx", "fy", "getFy", "setFy", "isForWardActive", "", "()Z", "setForWardActive", "(Z)V", "lId", "", "getLId", "()[Ljava/lang/Integer;", "setLId", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "lTag", "getLTag", "()[Ljava/lang/String;", "setLTag", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "runViewAnim", "getRunViewAnim", "status", "getStatus", "setStatus", "views", "Lcom/tencent/xaction/api/IView;", "getViews", "setViews", "(Ljava/util/ArrayList;)V", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class LinkView
{
  @Nullable
  private final ArrayList<BaseAnim> anim;
  private int bx = ScreenUnit.a.a();
  private int by = ScreenUnit.a.a();
  private float damping = 1.0F;
  @NotNull
  private String jdField_float = "";
  @NotNull
  private FloatViewData floatData = new FloatViewData();
  private int fx = ScreenUnit.a.a();
  private int fy = ScreenUnit.a.a();
  private transient boolean isForWardActive;
  @Nullable
  private Integer[] lId;
  @Nullable
  private String[] lTag;
  private final boolean runViewAnim;
  @NotNull
  private String status = "";
  @NotNull
  private transient ArrayList<IView> views = new ArrayList();
  
  @Nullable
  public final ArrayList<BaseAnim> getAnim()
  {
    return this.anim;
  }
  
  public final int getBx()
  {
    return this.bx;
  }
  
  public final int getBy()
  {
    return this.by;
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
  
  public final int getFx()
  {
    return this.fx;
  }
  
  public final int getFy()
  {
    return this.fy;
  }
  
  @Nullable
  public final Integer[] getLId()
  {
    return this.lId;
  }
  
  @Nullable
  public final String[] getLTag()
  {
    return this.lTag;
  }
  
  public final boolean getRunViewAnim()
  {
    return this.runViewAnim;
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
  
  public final boolean isForWardActive()
  {
    return this.isForWardActive;
  }
  
  public final void setBx(int paramInt)
  {
    this.bx = paramInt;
  }
  
  public final void setBy(int paramInt)
  {
    this.by = paramInt;
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
  
  public final void setForWardActive(boolean paramBoolean)
  {
    this.isForWardActive = paramBoolean;
  }
  
  public final void setFx(int paramInt)
  {
    this.fx = paramInt;
  }
  
  public final void setFy(int paramInt)
  {
    this.fy = paramInt;
  }
  
  public final void setLId(@Nullable Integer[] paramArrayOfInteger)
  {
    this.lId = paramArrayOfInteger;
  }
  
  public final void setLTag(@Nullable String[] paramArrayOfString)
  {
    this.lTag = paramArrayOfString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.data.LinkView
 * JD-Core Version:    0.7.0.1
 */
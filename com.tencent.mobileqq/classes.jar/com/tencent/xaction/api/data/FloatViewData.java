package com.tencent.xaction.api.data;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/FloatViewData;", "", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "layoutParam", "Landroid/view/ViewGroup$LayoutParams;", "getLayoutParam", "()Landroid/view/ViewGroup$LayoutParams;", "setLayoutParam", "(Landroid/view/ViewGroup$LayoutParams;)V", "parent", "Landroid/view/ViewParent;", "getParent", "()Landroid/view/ViewParent;", "setParent", "(Landroid/view/ViewParent;)V", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class FloatViewData
{
  private transient int index;
  @Nullable
  private transient ViewGroup.LayoutParams layoutParam;
  @Nullable
  private transient ViewParent parent;
  
  public final int getIndex()
  {
    return this.index;
  }
  
  @Nullable
  public final ViewGroup.LayoutParams getLayoutParam()
  {
    return this.layoutParam;
  }
  
  @Nullable
  public final ViewParent getParent()
  {
    return this.parent;
  }
  
  public final void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public final void setLayoutParam(@Nullable ViewGroup.LayoutParams paramLayoutParams)
  {
    this.layoutParam = paramLayoutParams;
  }
  
  public final void setParent(@Nullable ViewParent paramViewParent)
  {
    this.parent = paramViewParent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.data.FloatViewData
 * JD-Core Version:    0.7.0.1
 */
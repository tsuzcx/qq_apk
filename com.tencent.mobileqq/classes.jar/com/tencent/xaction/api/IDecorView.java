package com.tencent.xaction.api;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.openapi.api.IPublicDecorView;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/IDecorView;", "Lcom/tencent/xaction/openapi/api/IPublicDecorView;", "Lcom/tencent/xaction/api/IStyle;", "bindData", "", "destroy", "getProxy", "Landroid/view/View;", "init", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "viewLayout", "Landroid/view/ViewGroup;", "linkAnim", "linkViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "anims", "Lcom/tencent/xaction/api/base/BaseAnim;", "timeline", "Lcom/tencent/xaction/impl/XATimeline;", "setProxy", "view", "isStyle", "", "XActionCore_release"}, k=1, mv={1, 1, 16})
public abstract interface IDecorView
  extends IStyle, IPublicDecorView
{
  public abstract void a(@Nullable View paramView, boolean paramBoolean);
  
  public abstract void a(@NotNull IXAEngine paramIXAEngine, @Nullable ViewGroup paramViewGroup);
  
  public abstract void a(@NotNull ArrayList<View> paramArrayList, @NotNull ArrayList<BaseAnim> paramArrayList1, @NotNull XATimeline paramXATimeline);
  
  @Nullable
  public abstract View b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.IDecorView
 * JD-Core Version:    0.7.0.1
 */
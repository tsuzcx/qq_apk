package com.tencent.xaction.openapi.api;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/openapi/api/IPublicDecorView;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "linkAnim", "", "linkViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "XAApi_release"}, k=1, mv={1, 1, 16})
public abstract interface IPublicDecorView
{
  @Nullable
  public abstract Drawable getDrawable();
  
  public abstract void linkAnim(@NotNull ArrayList<View> paramArrayList);
  
  public abstract void setDrawable(@Nullable Drawable paramDrawable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.openapi.api.IPublicDecorView
 * JD-Core Version:    0.7.0.1
 */
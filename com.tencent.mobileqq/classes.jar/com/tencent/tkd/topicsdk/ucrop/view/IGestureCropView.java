package com.tencent.tkd.topicsdk.ucrop.view;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import com.tencent.tkd.topicsdk.ucrop.handler.GestureCropHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/view/IGestureCropView;", "", "gestureCropHandler", "Lcom/tencent/tkd/topicsdk/ucrop/handler/GestureCropHandler;", "getGestureCropHandler", "()Lcom/tencent/tkd/topicsdk/ucrop/handler/GestureCropHandler;", "initMatrix", "Landroid/graphics/Matrix;", "getInitMatrix", "()Landroid/graphics/Matrix;", "getBitmapForCrop", "Landroid/graphics/Bitmap;", "getBitmapHeight", "", "getBitmapWidth", "getInitialBitmapRectF", "Landroid/graphics/RectF;", "getView", "Landroid/view/View;", "updateMatrix", "", "matrix", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public abstract interface IGestureCropView
{
  public abstract void a(@NotNull Matrix paramMatrix);
  
  @Nullable
  public abstract Bitmap getBitmapForCrop();
  
  public abstract int getBitmapHeight();
  
  public abstract int getBitmapWidth();
  
  @NotNull
  public abstract GestureCropHandler getGestureCropHandler();
  
  @NotNull
  public abstract Matrix getInitMatrix();
  
  @NotNull
  public abstract RectF getInitialBitmapRectF();
  
  @NotNull
  public abstract View getView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.IGestureCropView
 * JD-Core Version:    0.7.0.1
 */
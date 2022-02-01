package com.tencent.timi.game.float_window;

import android.graphics.Bitmap;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.ex.LayoutExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/FloatingAnimateInfo;", "", "()V", "centerX", "", "getCenterX", "()F", "setCenterX", "(F)V", "centerY", "getCenterY", "setCenterY", "preDrawBitmap", "Landroid/graphics/Bitmap;", "getPreDrawBitmap", "()Landroid/graphics/Bitmap;", "setPreDrawBitmap", "(Landroid/graphics/Bitmap;)V", "size", "getSize", "setSize", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FloatingAnimateInfo
{
  public static final FloatingAnimateInfo.Companion a;
  @NotNull
  private static FloatingAnimateInfo f;
  private float b;
  private float c;
  private float d;
  @Nullable
  private Bitmap e;
  
  static
  {
    Object localObject1 = null;
    a = new FloatingAnimateInfo.Companion(null);
    FloatingAnimateInfo localFloatingAnimateInfo = new FloatingAnimateInfo();
    Object localObject2 = MobileQQ.context.getSystemService("window");
    if ((localObject2 instanceof WindowManager)) {
      localObject1 = localObject2;
    }
    localObject1 = (WindowManager)localObject1;
    if (localObject1 != null)
    {
      localObject2 = ((WindowManager)localObject1).getDefaultDisplay();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.defaultDisplay");
      localFloatingAnimateInfo.c = (((Display)localObject2).getHeight() - LayoutExKt.a(60) - LayoutExKt.a(32));
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "it.defaultDisplay");
      localFloatingAnimateInfo.b = (((Display)localObject1).getWidth() - LayoutExKt.a(1) - LayoutExKt.a(47));
    }
    localFloatingAnimateInfo.d = LayoutExKt.a(46);
    f = localFloatingAnimateInfo;
  }
  
  public final float a()
  {
    return this.b;
  }
  
  public final void a(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public final void a(@Nullable Bitmap paramBitmap)
  {
    this.e = paramBitmap;
  }
  
  public final float b()
  {
    return this.c;
  }
  
  public final void b(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public final float c()
  {
    return this.d;
  }
  
  public final void c(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  @Nullable
  public final Bitmap d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.FloatingAnimateInfo
 * JD-Core Version:    0.7.0.1
 */
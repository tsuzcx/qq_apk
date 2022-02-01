package com.tencent.xaction.anim;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/Layout;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "h", "", "getH", "()I", "setH", "(I)V", "hPX", "getHPX", "setHPX", "isConvert", "", "()Z", "setConvert", "(Z)V", "startH", "getStartH", "setStartH", "startW", "getStartW", "setStartW", "startX", "getStartX", "setStartX", "startY", "getStartY", "setStartY", "w", "getW", "setW", "wPX", "getWPX", "setWPX", "x", "getX", "setX", "xPX", "getXPX", "setXPX", "y", "getY", "setY", "yPX", "getYPX", "setYPX", "doFrameUpdate", "", "animTime", "", "preStart", "view", "Landroid/view/View;", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Layout
  extends BaseAnim
{
  private int h = ScreenUnit.a.a();
  private transient int hPX = ScreenUnit.a.a();
  private transient boolean isConvert;
  private int startH;
  private int startW;
  private int startX;
  private int startY;
  private int w = ScreenUnit.a.a();
  private transient int wPX = ScreenUnit.a.a();
  private int x = ScreenUnit.a.a();
  private transient int xPX = ScreenUnit.a.a();
  private int y = ScreenUnit.a.a();
  private transient int yPX = ScreenUnit.a.a();
  
  public void doFrameUpdate(float paramFloat)
  {
    int i = this.startW;
    float f1 = i;
    float f2 = this.wPX - i;
    i = this.startH;
    float f3 = i;
    float f4 = this.hPX - i;
    i = this.startX;
    float f5 = i + (this.xPX - i) * paramFloat;
    i = this.startY;
    float f6 = i + (this.yPX - i) * paramFloat;
    View localView = getView();
    if (localView != null) {
      localView.layout((int)f5, (int)f6, (int)(f5 + (f1 + f2 * paramFloat)), (int)(f6 + (f3 + f4 * paramFloat)));
    }
  }
  
  public final int getH()
  {
    return this.h;
  }
  
  public final int getHPX()
  {
    return this.hPX;
  }
  
  public final int getStartH()
  {
    return this.startH;
  }
  
  public final int getStartW()
  {
    return this.startW;
  }
  
  public final int getStartX()
  {
    return this.startX;
  }
  
  public final int getStartY()
  {
    return this.startY;
  }
  
  public final int getW()
  {
    return this.w;
  }
  
  public final int getWPX()
  {
    return this.wPX;
  }
  
  public final int getX()
  {
    return this.x;
  }
  
  public final int getXPX()
  {
    return this.xPX;
  }
  
  public final int getY()
  {
    return this.y;
  }
  
  public final int getYPX()
  {
    return this.yPX;
  }
  
  public final boolean isConvert()
  {
    return this.isConvert;
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    this.startW = paramView.getWidth();
    this.startH = paramView.getHeight();
    this.startX = ((int)paramView.getX());
    this.startY = ((int)paramView.getY());
    int i;
    if (this.w > ScreenUnit.a.a()) {
      i = ScreenUnit.a.a(this.w);
    } else {
      i = this.startW;
    }
    this.wPX = i;
    if (this.h > ScreenUnit.a.a()) {
      i = ScreenUnit.a.a(this.h);
    } else {
      i = this.startH;
    }
    this.hPX = i;
    if (this.x > ScreenUnit.a.a()) {
      i = ScreenUnit.a.a(this.x);
    } else {
      i = this.startX;
    }
    this.xPX = i;
    if (this.y > ScreenUnit.a.a()) {
      i = ScreenUnit.a.a(this.y);
    } else {
      i = this.startY;
    }
    this.yPX = i;
  }
  
  public final void setConvert(boolean paramBoolean)
  {
    this.isConvert = paramBoolean;
  }
  
  public final void setH(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void setHPX(int paramInt)
  {
    this.hPX = paramInt;
  }
  
  public final void setStartH(int paramInt)
  {
    this.startH = paramInt;
  }
  
  public final void setStartW(int paramInt)
  {
    this.startW = paramInt;
  }
  
  public final void setStartX(int paramInt)
  {
    this.startX = paramInt;
  }
  
  public final void setStartY(int paramInt)
  {
    this.startY = paramInt;
  }
  
  public final void setW(int paramInt)
  {
    this.w = paramInt;
  }
  
  public final void setWPX(int paramInt)
  {
    this.wPX = paramInt;
  }
  
  public final void setX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public final void setXPX(int paramInt)
  {
    this.xPX = paramInt;
  }
  
  public final void setY(int paramInt)
  {
    this.y = paramInt;
  }
  
  public final void setYPX(int paramInt)
  {
    this.yPX = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.Layout
 * JD-Core Version:    0.7.0.1
 */
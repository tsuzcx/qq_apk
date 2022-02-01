package com.tencent.xaction.anim;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/Layout;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "h", "", "getH", "()I", "setH", "(I)V", "hPX", "getHPX", "setHPX", "isConvert", "", "()Z", "setConvert", "(Z)V", "startH", "getStartH", "setStartH", "startW", "getStartW", "setStartW", "startX", "getStartX", "setStartX", "startY", "getStartY", "setStartY", "w", "getW", "setW", "wPX", "getWPX", "setWPX", "x", "getX", "setX", "xPX", "getXPX", "setXPX", "y", "getY", "setY", "yPX", "getYPX", "setYPX", "doFrameUpdate", "", "animTime", "", "end", "preStart", "view", "Landroid/view/View;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Layout
  extends BaseAnim
{
  private int h = -1;
  private transient int hPX = -1;
  private transient boolean isConvert;
  private int startH;
  private int startW;
  private int startX;
  private int startY;
  private int w = -1;
  private transient int wPX = -1;
  private int x = -1;
  private transient int xPX = -1;
  private int y = -1;
  private transient int yPX = -1;
  
  public void doFrameUpdate(float paramFloat)
  {
    float f1 = this.startW;
    float f2 = this.wPX - this.startW;
    float f3 = this.startH;
    float f4 = this.hPX - this.startH;
    float f5 = this.startX + (this.xPX - this.startX) * paramFloat;
    float f6 = this.startY + (this.yPX - this.startY) * paramFloat;
    View localView = getView();
    if (localView != null) {
      localView.layout((int)f5, (int)f6, (int)(f1 + f2 * paramFloat + f5), (int)(f3 + f4 * paramFloat + f6));
    }
  }
  
  public void end() {}
  
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
    if (this.w > -1)
    {
      i = ScreenUnit.a.a(this.w);
      this.wPX = i;
      if (this.h <= -1) {
        break label150;
      }
      i = ScreenUnit.a.a(this.h);
      label88:
      this.hPX = i;
      if (this.x <= -1) {
        break label158;
      }
      i = ScreenUnit.a.a(this.x);
      label112:
      this.xPX = i;
      if (this.y <= -1) {
        break label166;
      }
    }
    label150:
    label158:
    label166:
    for (int i = ScreenUnit.a.a(this.y);; i = this.startY)
    {
      this.yPX = i;
      return;
      i = this.startW;
      break;
      i = this.startH;
      break label88;
      i = this.startX;
      break label112;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.anim.Layout
 * JD-Core Version:    0.7.0.1
 */
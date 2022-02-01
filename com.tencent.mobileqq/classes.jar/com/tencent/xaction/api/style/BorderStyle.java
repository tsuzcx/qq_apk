package com.tencent.xaction.api.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import androidx.annotation.Keep;
import com.tencent.xaction.api.data.Border;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/style/BorderStyle;", "", "()V", "mViewData", "Lcom/tencent/xaction/api/data/ViewData;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "setStyle", "viewData", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class BorderStyle
{
  private ViewData mViewData;
  
  public final void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Object localObject1 = this.mViewData;
    if (localObject1 != null)
    {
      localObject1 = ((ViewData)localObject1).getSt();
      if (localObject1 != null)
      {
        localObject1 = ((Style)localObject1).getBorders();
        break label42;
      }
    }
    localObject1 = null;
    label42:
    if (localObject1 == null) {
      return;
    }
    localObject1 = new Paint();
    Object localObject2 = this.mViewData;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((ViewData)localObject2).getSt().getBorders();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      Object localObject3 = localObject2[i];
      ((Paint)localObject1).setColor(-16776961);
      ((Paint)localObject1).setStrokeWidth(ScreenUnit.a.d(localObject3.getW()));
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      int k = paramCanvas.getWidth();
      int m = paramCanvas.getHeight();
      int n = localObject3.getOrientation();
      if (n != 1)
      {
        float f;
        if (n != 2)
        {
          if (n != 4)
          {
            if (n == 8) {
              paramCanvas.drawLine(0.0F, 0.0F, 0.0F, m, (Paint)localObject1);
            }
          }
          else
          {
            f = m;
            paramCanvas.drawLine(0.0F, f, k, f, (Paint)localObject1);
          }
        }
        else
        {
          f = k;
          paramCanvas.drawLine(f, 0.0F, f, m, (Paint)localObject1);
        }
      }
      else
      {
        paramCanvas.drawLine(0.0F, 0.0F, k, 0.0F, (Paint)localObject1);
      }
      i += 1;
    }
  }
  
  public final void setStyle(@NotNull ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    this.mViewData = paramViewData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.style.BorderStyle
 * JD-Core Version:    0.7.0.1
 */
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/style/BorderStyle;", "", "()V", "mViewData", "Lcom/tencent/xaction/api/data/ViewData;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "setStyle", "viewData", "XActionEngine_release"}, k=1, mv={1, 1, 16})
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
        if (localObject1 != null) {
          break label48;
        }
      }
    }
    label48:
    Object localObject2;
    int j;
    int i;
    do
    {
      return;
      localObject1 = null;
      break;
      localObject1 = new Paint();
      localObject2 = this.mViewData;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = ((ViewData)localObject2).getSt().getBorders();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      j = localObject2.length;
      i = 0;
    } while (i >= j);
    Object localObject3 = localObject2[i];
    ((Paint)localObject1).setColor(-16776961);
    ((Paint)localObject1).setStrokeWidth(ScreenUnit.a.a(localObject3.getW()));
    ((Paint)localObject1).setStyle(Paint.Style.STROKE);
    int k = paramCanvas.getWidth();
    int m = paramCanvas.getHeight();
    switch (localObject3.getOrientation())
    {
    }
    for (;;)
    {
      i += 1;
      break;
      paramCanvas.drawLine(0.0F, 0.0F, k, 0.0F, (Paint)localObject1);
      continue;
      paramCanvas.drawLine(k, 0.0F, k, m, (Paint)localObject1);
      continue;
      paramCanvas.drawLine(0.0F, m, k, m, (Paint)localObject1);
      continue;
      paramCanvas.drawLine(0.0F, 0.0F, 0.0F, m, (Paint)localObject1);
    }
  }
  
  public final void setStyle(@NotNull ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    this.mViewData = paramViewData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.style.BorderStyle
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/widget/CommonButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "ctx", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isBelowOMR1", "", "()Z", "mClipPath", "Landroid/graphics/Path;", "mDrawPath", "mPaint", "Landroid/graphics/Paint;", "mRectF", "Landroid/graphics/RectF;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class CommonButton
  extends AppCompatTextView
{
  public static final CommonButton.Companion a = new CommonButton.Companion(null);
  private final Paint b;
  private final Path c;
  private final Path d;
  private final RectF e;
  
  @JvmOverloads
  public CommonButton(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public CommonButton(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public CommonButton(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new Paint();
    if (a()) {
      paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    } else {
      paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }
    paramAttributeSet.setXfermode((Xfermode)paramContext);
    paramAttributeSet.setStyle(Paint.Style.FILL_AND_STROKE);
    paramAttributeSet.setAntiAlias(true);
    this.b = paramAttributeSet;
    this.c = new Path();
    this.d = new Path();
    this.e = new RectF();
  }
  
  private final boolean a()
  {
    return Build.VERSION.SDK_INT <= 27;
  }
  
  @RequiresApi(21)
  public void draw(@Nullable Canvas paramCanvas)
  {
    this.e.setEmpty();
    this.d.reset();
    this.c.reset();
    RectF localRectF = this.e;
    float f1 = 0;
    localRectF.set(f1, f1, getWidth(), getHeight());
    float f2 = Math.min(getWidth(), getHeight()) / 2;
    if (a())
    {
      if (paramCanvas != null) {
        paramCanvas.saveLayer(this.e, null, 31);
      }
      super.draw(paramCanvas);
      this.c.addRoundRect(this.e, f2, f2, Path.Direction.CW);
      if (paramCanvas != null) {
        paramCanvas.drawPath(this.c, this.b);
      }
    }
    else
    {
      if (paramCanvas != null) {
        paramCanvas.saveLayer(this.e, null);
      }
      super.draw(paramCanvas);
      this.d.addRoundRect(this.e, f2, f2, Path.Direction.CW);
      this.c.addRect(f1, f1, getWidth(), getHeight(), Path.Direction.CW);
      this.c.op(this.d, Path.Op.DIFFERENCE);
      if (paramCanvas != null) {
        paramCanvas.drawPath(this.c, this.b);
      }
    }
    if (paramCanvas != null) {
      paramCanvas.restore();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.CommonButton
 * JD-Core Version:    0.7.0.1
 */
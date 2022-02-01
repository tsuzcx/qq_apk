package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.wink.editor.model.PointF;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;

public class WinkStickerFrameView
  extends View
{
  private float a;
  private Paint b;
  private RectF c;
  private WinkStickerModel d;
  
  public WinkStickerFrameView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WinkStickerFrameView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WinkStickerFrameView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = DisplayUtil.a(getContext(), 4.0F);
    this.b = new Paint(1);
    this.b.setStrokeWidth(DisplayUtil.a(getContext(), 2.0F));
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(-1);
    this.c = new RectF();
  }
  
  public void a(WinkStickerModel paramWinkStickerModel)
  {
    this.d = paramWinkStickerModel;
    this.c.left = this.d.getLeftTopInView().x;
    this.c.top = this.d.getLeftTopInView().y;
    this.c.right = this.d.getRightBottomInView().x;
    this.c.bottom = this.d.getRightBottomInView().y;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.d == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.rotate(-this.d.rotate, this.d.getCenterInView().x, this.d.getCenterInView().y);
    RectF localRectF = this.c;
    float f = this.a;
    paramCanvas.drawRoundRect(localRectF, f, f, this.b);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.WinkStickerFrameView
 * JD-Core Version:    0.7.0.1
 */
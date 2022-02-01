package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.wink.R.styleable;
import com.tencent.mobileqq.wink.editor.music.lyric.util.UIUtils;

public class RoundCorneredFrameLayout
  extends FrameLayout
{
  public int a = 6;
  
  @TargetApi(11)
  public RoundCorneredFrameLayout(Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
  }
  
  @TargetApi(11)
  public RoundCorneredFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = UIUtils.a(a(paramContext, paramAttributeSet), paramContext.getResources());
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
  }
  
  int a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.fp);
    int i = paramContext.getInt(R.styleable.fq, 6);
    paramContext.recycle();
    return i;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int j = getWidth();
    int i = getHeight();
    Path localPath = new Path();
    localPath.moveTo(0.0F, this.a);
    int k = this.a;
    localPath.arcTo(new RectF(0.0F, 0.0F, k * 2, k * 2), -180.0F, 90.0F);
    localPath.lineTo(j - this.a, 0.0F);
    k = this.a;
    float f2 = j - k * 2;
    float f1 = j;
    localPath.arcTo(new RectF(f2, 0.0F, f1, k * 2), -90.0F, 90.0F);
    localPath.lineTo(f1, i - this.a);
    k = this.a;
    f2 = j - k * 2;
    float f3 = i - k * 2;
    float f4 = i;
    localPath.arcTo(new RectF(f2, f3, f1, f4), 0.0F, 90.0F);
    localPath.lineTo(this.a, f4);
    j = this.a;
    localPath.arcTo(new RectF(0.0F, i - j * 2, j * 2, f4), 90.0F, 90.0F);
    localPath.lineTo(0.0F, this.a);
    localPath.close();
    paramCanvas.clipPath(localPath);
    super.dispatchDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.widget.RoundCorneredFrameLayout
 * JD-Core Version:    0.7.0.1
 */
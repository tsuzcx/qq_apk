package cooperation.vip.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;

public class ScaleVideoView
  extends TextureVideoView
{
  private Matrix a = new Matrix();
  
  public ScaleVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScaleVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScaleVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = getDefaultSize(this.k, paramInt1);
    paramInt2 = getDefaultSize(this.l, paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
    float f1 = paramInt1 * 1.0F / this.k;
    float f2 = paramInt2 * 1.0F / this.l;
    float f3 = Math.max(f1, f2);
    paramInt1 /= 2;
    paramInt2 /= 2;
    this.a.setScale(f3 / f1, f3 / f2, paramInt1, paramInt2);
    setTransform(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.widget.ScaleVideoView
 * JD-Core Version:    0.7.0.1
 */
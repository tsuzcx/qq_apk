package dov.com.qq.im.ae.cmshow;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class AECMShowSquareLayout
  extends FrameLayout
{
  public AECMShowSquareLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AECMShowSquareLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AECMShowSquareLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getContext().getResources().getConfiguration().orientation;
    if ((i == 1) || (i == 0)) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 1073741824);
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      paramInt1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowSquareLayout
 * JD-Core Version:    0.7.0.1
 */
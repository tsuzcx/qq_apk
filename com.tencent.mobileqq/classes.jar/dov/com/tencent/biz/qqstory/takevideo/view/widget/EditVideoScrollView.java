package dov.com.tencent.biz.qqstory.takevideo.view.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class EditVideoScrollView
  extends HorizontalScrollView
{
  public EditVideoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    try
    {
      paramContext = HorizontalScrollView.class.getDeclaredField("mEdgeGlowLeft");
      paramAttributeSet = HorizontalScrollView.class.getDeclaredField("mEdgeGlowRight");
      paramContext.setAccessible(true);
      paramAttributeSet.setAccessible(true);
      paramContext = paramContext.get(this);
      paramAttributeSet = paramAttributeSet.get(this);
      Object localObject = EdgeEffect.class.getDeclaredField("mPaint");
      ((Field)localObject).setAccessible(true);
      paramContext = ((Field)localObject).get(paramContext);
      paramAttributeSet = ((Field)localObject).get(paramAttributeSet);
      localObject = Paint.class.getMethod("setXfermode", new Class[] { Xfermode.class });
      ((Method)localObject).invoke(paramContext, new Object[] { new PorterDuffXfermode(PorterDuff.Mode.DST) });
      ((Method)localObject).invoke(paramAttributeSet, new Object[] { new PorterDuffXfermode(PorterDuff.Mode.DST) });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    return 0.0F;
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    paramInt7 = (int)(paramInt1 * 1.0F);
    if ((paramInt3 + paramInt1 == 0) || (paramInt3 - paramInt5 + paramInt1 == 0)) {
      paramInt7 = paramInt1;
    }
    return super.overScrollBy(paramInt7, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 100, paramInt8, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.EditVideoScrollView
 * JD-Core Version:    0.7.0.1
 */
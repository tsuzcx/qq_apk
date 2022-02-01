package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.LinearInterpolator;
import bnmo;
import bnmx;
import bnne;
import bnng;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class SecondDemoView
  extends View
{
  int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  bnmo jdField_a_of_type_Bnmo = new bnmo();
  bnne jdField_a_of_type_Bnne;
  private String jdField_a_of_type_JavaLangString = "05:36";
  public ArrayList<Integer> a;
  bnne jdField_b_of_type_Bnne;
  private String jdField_b_of_type_JavaLangString = "2017 SEPTEMBER 30";
  private ArrayList<Bitmap> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<Bitmap> c = new ArrayList();
  private ArrayList<Bitmap> d = new ArrayList();
  private ArrayList<Bitmap> e = new ArrayList();
  
  public SecondDemoView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SecondDemoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SecondDemoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = null;
    a();
  }
  
  private bnne a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Typeface paramTypeface, bnmo parambnmo)
  {
    paramTypeface = new bnne(paramInt1, paramInt2, paramTypeface, paramInt3, paramInt4, paramInt5, paramInt6);
    paramTypeface.a(paramCharSequence, parambnmo);
    return paramTypeface;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setDither(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_Bnne = a(this.jdField_a_of_type_JavaLangString, AIOUtils.dp2px(48.0F, getResources()), -1, 0, 0, 0, 600, Typeface.DEFAULT_BOLD, this.jdField_a_of_type_Bnmo);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Bnmo.a("", 500L, 500L, 0, AIOUtils.dp2px(135.0F, getResources()), new AnticipateOvershootInterpolator());
    this.jdField_b_of_type_Bnne = a(this.jdField_b_of_type_JavaLangString, AIOUtils.dp2px(11.0F, getResources()), -1, 0, AIOUtils.dp2px(60.0F, getResources()), 700, 1000, Typeface.DEFAULT_BOLD, this.jdField_a_of_type_Bnmo);
    b();
  }
  
  private void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      paramArrayList = this.jdField_a_of_type_Bnne.jdField_a_of_type_JavaUtilArrayList.iterator();
      bnmx localbnmx;
      Bitmap localBitmap;
      TextPaint localTextPaint;
      while (paramArrayList.hasNext())
      {
        localbnmx = (bnmx)paramArrayList.next();
        localBitmap = localbnmx.jdField_a_of_type_AndroidGraphicsBitmap;
        localTextPaint = this.jdField_a_of_type_Bnne.jdField_a_of_type_AndroidTextTextPaint;
        localTextPaint.setAlpha(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(localbnmx.b)).intValue());
        i = this.jdField_a_of_type_Bnne.jdField_a_of_type_Int;
        paramCanvas.drawBitmap(localBitmap, localbnmx.jdField_a_of_type_Int + i, this.jdField_a_of_type_Bnne.b, localTextPaint);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(AIOUtils.dp2px(2.0F, getResources()));
      int i = AIOUtils.dp2px(55.0F, getResources());
      paramCanvas.drawLine(0.0F, i, ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).intValue(), i, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramArrayList = this.jdField_b_of_type_Bnne.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localbnmx = (bnmx)paramArrayList.next();
        localBitmap = localbnmx.jdField_a_of_type_AndroidGraphicsBitmap;
        localTextPaint = this.jdField_b_of_type_Bnne.jdField_a_of_type_AndroidTextTextPaint;
        localTextPaint.setAlpha(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(localbnmx.b)).intValue());
        i = this.jdField_b_of_type_Bnne.jdField_a_of_type_Int;
        paramCanvas.drawBitmap(localBitmap, localbnmx.jdField_a_of_type_Int + i, this.jdField_b_of_type_Bnne.b, localTextPaint);
      }
    }
  }
  
  private void b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofObject(this.jdField_a_of_type_Bnmo, new Object[] { this.jdField_a_of_type_Bnmo.b(), this.jdField_a_of_type_Bnmo.a() });
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.setRepeatCount(100);
    localValueAnimator.addUpdateListener(new bnng(this));
    localValueAnimator.setDuration(this.jdField_a_of_type_Bnmo.a());
    localValueAnimator.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.SecondDemoView
 * JD-Core Version:    0.7.0.1
 */
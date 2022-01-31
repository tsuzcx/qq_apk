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
import aobq;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class SecondDemoView
  extends View
{
  int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  AnimStateTypeEvaluator jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator = new AnimStateTypeEvaluator();
  PerLineFontBitmapsInfo jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo;
  private String jdField_a_of_type_JavaLangString = "05:36";
  public ArrayList a;
  PerLineFontBitmapsInfo jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo;
  private String jdField_b_of_type_JavaLangString = "2017 SEPTEMBER 30";
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList c = new ArrayList();
  private ArrayList d = new ArrayList();
  private ArrayList e = new ArrayList();
  
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
  
  private PerLineFontBitmapsInfo a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Typeface paramTypeface, AnimStateTypeEvaluator paramAnimStateTypeEvaluator)
  {
    paramTypeface = new PerLineFontBitmapsInfo(paramInt1, paramInt2, paramTypeface, paramInt3, paramInt4, paramInt5, paramInt6);
    paramTypeface.a(paramCharSequence, paramAnimStateTypeEvaluator);
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
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo = a(this.jdField_a_of_type_JavaLangString, AIOUtils.a(48.0F, getResources()), -1, 0, 0, 0, 600, Typeface.DEFAULT_BOLD, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a("", 500L, 500L, 0, AIOUtils.a(135.0F, getResources()), new AnticipateOvershootInterpolator());
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo = a(this.jdField_b_of_type_JavaLangString, AIOUtils.a(11.0F, getResources()), -1, 0, AIOUtils.a(60.0F, getResources()), 700, 1000, Typeface.DEFAULT_BOLD, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator);
    b();
  }
  
  private void a(Canvas paramCanvas, ArrayList paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      paramArrayList = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      FontBitmapInfo localFontBitmapInfo;
      Bitmap localBitmap;
      TextPaint localTextPaint;
      while (paramArrayList.hasNext())
      {
        localFontBitmapInfo = (FontBitmapInfo)paramArrayList.next();
        localBitmap = localFontBitmapInfo.jdField_a_of_type_AndroidGraphicsBitmap;
        localTextPaint = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_AndroidTextTextPaint;
        localTextPaint.setAlpha(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(localFontBitmapInfo.b)).intValue());
        i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_Int;
        paramCanvas.drawBitmap(localBitmap, localFontBitmapInfo.jdField_a_of_type_Int + i, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.b, localTextPaint);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(AIOUtils.a(2.0F, getResources()));
      int i = AIOUtils.a(55.0F, getResources());
      paramCanvas.drawLine(0.0F, i, ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).intValue(), i, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramArrayList = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localFontBitmapInfo = (FontBitmapInfo)paramArrayList.next();
        localBitmap = localFontBitmapInfo.jdField_a_of_type_AndroidGraphicsBitmap;
        localTextPaint = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_AndroidTextTextPaint;
        localTextPaint.setAlpha(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(localFontBitmapInfo.b)).intValue());
        i = this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.jdField_a_of_type_Int;
        paramCanvas.drawBitmap(localBitmap, localFontBitmapInfo.jdField_a_of_type_Int + i, this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetPerLineFontBitmapsInfo.b, localTextPaint);
      }
    }
  }
  
  private void b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofObject(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator, new Object[] { this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.b(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a() });
    localValueAnimator.setInterpolator(new LinearInterpolator());
    localValueAnimator.setRepeatCount(100);
    localValueAnimator.addUpdateListener(new aobq(this));
    localValueAnimator.setDuration(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetAnimStateTypeEvaluator.a());
    localValueAnimator.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.SecondDemoView
 * JD-Core Version:    0.7.0.1
 */
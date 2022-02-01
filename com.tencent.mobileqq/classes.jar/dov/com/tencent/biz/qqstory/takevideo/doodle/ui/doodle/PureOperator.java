package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class PureOperator
  extends DoodleOperator
{
  public static final int a;
  public float a;
  public Paint a;
  DoodleLineListener a;
  public PureLinePath a;
  public float b;
  public int b;
  public Paint b;
  public int c = AIOUtils.a(6.0F, BaseApplicationImpl.getContext().getResources());
  
  static
  {
    jdField_a_of_type_Int = dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke.a[1];
  }
  
  public PureOperator(DoodleLineListener paramDoodleLineListener)
  {
    this.jdField_b_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.c);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener = paramDoodleLineListener;
  }
  
  private void a(Paint paramPaint, PureLinePath paramPureLinePath)
  {
    paramPaint.setXfermode(null);
    paramPaint.setColor(paramPureLinePath.jdField_b_of_type_Int);
    paramPaint.setStrokeWidth(paramPureLinePath.c);
    paramPaint.setShader(null);
  }
  
  public Paint a()
  {
    return this.jdField_b_of_type_AndroidGraphicsPaint;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.c);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(Canvas paramCanvas, DoodleLinePath paramDoodleLinePath, Paint paramPaint)
  {
    if ((paramDoodleLinePath instanceof PureLinePath))
    {
      paramDoodleLinePath = (PureLinePath)paramDoodleLinePath;
      if (paramDoodleLinePath.jdField_a_of_type_AndroidGraphicsPath != null)
      {
        a(paramPaint, paramDoodleLinePath);
        paramCanvas.drawPath(paramDoodleLinePath.jdField_a_of_type_AndroidGraphicsPath, paramPaint);
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePureLinePath = new PureLinePath(new Path(), 101, this.jdField_a_of_type_AndroidGraphicsPaint.getColor(), this.c);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLineListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePureLinePath);
      }
      DoodleLayout.a("use_graffiti");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePureLinePath.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePureLinePath.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePureLinePath.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 + 1.0F, f2 + 1.0F);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePureLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_a_of_type_Int, f1, f2));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePureLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.jdField_b_of_type_Int, f1 + 1.0F, f2 + 1.0F));
      continue;
      float f3 = (this.jdField_a_of_type_Float + f1) / 2.0F;
      float f4 = (this.jdField_b_of_type_Float + f2) / 2.0F;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePureLinePath != null)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePureLinePath.jdField_a_of_type_AndroidGraphicsPath.quadTo(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, f3, f4);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePureLinePath.jdField_a_of_type_JavaUtilArrayList.add(new PointAction(PointAction.c, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, f3, f4));
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
    }
  }
  
  public Paint b()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(jdField_a_of_type_Int);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodlePureLinePath = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PureOperator
 * JD-Core Version:    0.7.0.1
 */
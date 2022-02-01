package dov.com.qq.im.aeeditor.lyric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;

public class LyricView
  extends FrameLayout
{
  protected PointF a;
  private Handler a;
  protected View.OnClickListener a;
  protected LyricView.OnLineClickListener a;
  protected LyricView.OnLyricViewLongClickListener a;
  protected LyricViewAttribute a;
  protected LyricViewInternalBase a;
  protected LyricViewScroll a;
  protected boolean a;
  protected PointF b;
  protected boolean b;
  protected boolean c = false;
  protected boolean d = true;
  protected boolean e = false;
  
  public LyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF();
    this.jdField_b_of_type_AndroidGraphicsPointF = new PointF();
    this.jdField_a_of_type_AndroidOsHandler = new LyricView.1(this);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AELyricView, 0, 0);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewAttribute = new LyricViewAttribute();
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewAttribute.a(paramContext);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(19, false);
    paramContext.recycle();
  }
  
  public LyricViewInternalBase a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewInternalBase;
  }
  
  public LyricViewScroll a()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.a(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    while (this.jdField_b_of_type_Boolean)
    {
      a(paramMotionEvent);
      return true;
      this.jdField_a_of_type_AndroidGraphicsPointF.set(f1, f2);
      this.jdField_b_of_type_AndroidGraphicsPointF.set(f1, f2);
      this.c = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 1000L);
      continue;
      this.jdField_b_of_type_AndroidGraphicsPointF.set(f1, f2);
      if ((Math.abs(this.jdField_a_of_type_AndroidGraphicsPointF.x - f1) > 10.0F) || (Math.abs(this.jdField_a_of_type_AndroidGraphicsPointF.y - f2) > 10.0F)) {
        this.c = false;
      }
      if (Math.abs(f2 - this.jdField_a_of_type_AndroidGraphicsPointF.y) > 10.0F)
      {
        this.d = false;
        continue;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
        if ((!this.e) && (Math.abs(this.jdField_a_of_type_AndroidGraphicsPointF.x - f1) < 10.0F) && (Math.abs(this.jdField_a_of_type_AndroidGraphicsPointF.y - f2) < 10.0F) && (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) && (this.c)) {
          this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this);
        }
        if ((!this.e) && (this.d) && (this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricView$OnLineClickListener != null))
        {
          i = (int)(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.getScrollY() + f2);
          i = this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewInternalBase.c(i);
          this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricView$OnLineClickListener.a(i);
        }
        this.d = true;
        this.e = false;
        this.jdField_a_of_type_AndroidGraphicsPointF.set(0.0F, 0.0F);
        this.jdField_b_of_type_AndroidGraphicsPointF.set(f1, f2);
        this.c = false;
        continue;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
      }
    }
    return false;
  }
  
  public void setIsDealTouchEvent(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setOnLineClickListener(LyricView.OnLineClickListener paramOnLineClickListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricView$OnLineClickListener = paramOnLineClickListener;
  }
  
  public void setOnLyricViewLongClickListener(LyricView.OnLyricViewLongClickListener paramOnLyricViewLongClickListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricView$OnLyricViewLongClickListener = paramOnLyricViewLongClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricView
 * JD-Core Version:    0.7.0.1
 */
package dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy.StrokeStrategy;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.PureStroke;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.Stroke;
import java.util.Iterator;
import java.util.List;

@TargetApi(11)
public class SelectStrokeLayout
  extends RelativeLayout
  implements View.OnTouchListener, StrokePicker.OnStrokeDrawableSelectedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SelectStrokeLayout.StrokeLayoutListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarSelectStrokeLayout$StrokeLayoutListener;
  private StrokePicker jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public SelectStrokeLayout(Context paramContext)
  {
    super(paramContext);
    this.c = UIUtils.a(paramContext, 20.0F);
    this.d = UIUtils.a(paramContext, 40.0F);
    this.e = UIUtils.a(paramContext, 40.0F);
    this.f = UIUtils.a(paramContext, 10.0F);
    this.g = UIUtils.a(paramContext, 0.0F);
    this.h = 0;
    a();
  }
  
  public SelectStrokeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.stroke_picker);
    this.c = paramAttributeSet.getDimensionPixelSize(0, UIUtils.a(paramContext, 20.0F));
    this.d = paramAttributeSet.getDimensionPixelSize(1, UIUtils.a(paramContext, 40.0F));
    this.e = paramAttributeSet.getDimensionPixelSize(2, UIUtils.a(paramContext, 40.0F));
    this.f = paramAttributeSet.getDimensionPixelOffset(3, UIUtils.a(paramContext, 10.0F));
    this.g = paramAttributeSet.getDimensionPixelSize(5, 0);
    this.h = paramAttributeSet.getDimensionPixelOffset(4, 0);
    this.i = paramAttributeSet.getDimensionPixelSize(7, 0);
    paramAttributeSet.recycle();
    a();
  }
  
  private View a(int paramInt)
  {
    View localView = findViewById(paramInt);
    if (localView == null) {
      throw new IllegalStateException("cannot find view with viewId:" + paramInt);
    }
    return localView;
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2130970644, this, true);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker = ((StrokePicker)a(2131371498));
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker == null) {
      throw new IllegalStateException("can not find ColorPicker.");
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.setOnStrokeSelectedListener(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.setContentDescription("颜色条");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131371499));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131362823));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131371500));
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = this.c;
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = this.c;
    this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams().width = this.d;
    this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams().height = this.e;
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).rightMargin = this.g;
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).rightMargin = ((this.f - this.c) / 2);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.getLayoutParams().width = this.f;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.setPadding(this.h, 0, this.h, 0);
    if (this.e > this.c) {}
    for (int k = this.e;; k = this.c)
    {
      k /= 2;
      if (this.jdField_a_of_type_Int < k) {
        this.jdField_a_of_type_Int = k;
      }
      if (this.jdField_b_of_type_Int < k) {
        this.jdField_b_of_type_Int = k;
      }
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.getLayoutParams()).topMargin = this.jdField_a_of_type_Int;
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.getLayoutParams()).bottomMargin = this.jdField_b_of_type_Int;
      setOnTouchListener(this);
      return;
    }
  }
  
  private void a(Stroke paramStroke)
  {
    switch (paramStroke.a())
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = this.c;
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = this.c;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width = UIUtils.a(getContext(), 24.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = UIUtils.a(getContext(), 29.0F);
  }
  
  private void b(Stroke paramStroke)
  {
    switch (paramStroke.a())
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      return;
    }
    int k = UIUtils.a(getContext(), 1.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, k, k, k);
  }
  
  public Stroke a(float paramFloat)
  {
    Stroke localStroke = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.a(paramFloat);
    if (localStroke != null)
    {
      Object localObject = localStroke.a(0.0F, paramFloat);
      Drawable localDrawable = localStroke.b(0.0F, paramFloat);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      int k = localStroke.jdField_b_of_type_Int;
      int m = localStroke.c;
      int n = localStroke.d;
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      int i1 = localStroke.e;
      int i2 = localStroke.c;
      ((RelativeLayout)localObject).setTranslationY((k - m - n) / 2 + (i1 + i2));
      b(localStroke);
      a(localStroke);
      this.j = ((int)paramFloat);
      return localStroke;
    }
    SLog.e("SelectStrokeLayout", "selectedStroke is null.");
    return null;
  }
  
  public void a(@NonNull MotionEvent paramMotionEvent, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @NonNull Stroke paramStroke)
  {
    float f2 = 0.0F;
    float f1 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Long > System.currentTimeMillis()) {
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (f1 < 0.0F)) {}
    for (;;)
    {
      f1 = f2;
      if (!this.jdField_a_of_type_Boolean)
      {
        f1 = f2;
        if (f2 < this.c / 2) {
          f1 = this.c / 2;
        }
      }
      f2 = f1;
      if (this.jdField_b_of_type_Boolean)
      {
        f2 = f1;
        if (f1 > this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.getHeight()) {
          f2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.getHeight();
        }
      }
      f1 = f2;
      if (!this.jdField_b_of_type_Boolean)
      {
        f1 = f2;
        if (f2 > this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.getHeight() - this.c / 2) {
          f1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.getHeight() - this.c / 2;
        }
      }
      int k = paramStroke.jdField_b_of_type_Int;
      int m = paramStroke.c;
      int n = paramStroke.d;
      RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      int i1 = paramStroke.e;
      int i2 = paramStroke.c;
      localRelativeLayout.setTranslationY((k - m - n) / 2 + (i1 + i2));
      if (paramDrawable1 != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramDrawable1);
      }
      if (paramDrawable2 != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable2);
      }
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        b(paramStroke);
        a(paramStroke);
        this.j = ((int)f1);
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarSelectStrokeLayout$StrokeLayoutListener == null) {
          break;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarSelectStrokeLayout$StrokeLayoutListener.a(paramMotionEvent, paramStroke);
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        continue;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      f2 = f1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int * 2 + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.a(), 1073741824));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      float f3 = getWidth() - this.f;
      float f4 = this.jdField_a_of_type_Int;
      paramView = MotionEvent.obtain(paramMotionEvent);
      paramView.setLocation(f1 - f3, f2 - f4);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.a(paramView);
      paramView.recycle();
      return true;
    } while ((f1 >= getWidth() - this.f + this.i) && (f1 <= getWidth() - this.i));
    return false;
  }
  
  public void setAnimationEndTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setSelectedStrokeWithColor(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.a();
    if (!((List)localObject).isEmpty())
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStroke = (Stroke)((Iterator)localObject).next();
        if (((localStroke instanceof PureStroke)) && (((PureStroke)localStroke).b() == paramInt))
        {
          paramInt = localStroke.e;
          a(localStroke.jdField_b_of_type_Int / 2 + paramInt);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Stroke localStroke;
      return;
    }
    QLog.d("SelectStrokeLayout", 2, "setSelectedStrokeWithColor " + paramInt + " failed");
  }
  
  public void setStrokeLayoutListener(SelectStrokeLayout.StrokeLayoutListener paramStrokeLayoutListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarSelectStrokeLayout$StrokeLayoutListener = paramStrokeLayoutListener;
  }
  
  public void setStrokeStrategy(StrokeStrategy paramStrokeStrategy)
  {
    if (paramStrokeStrategy != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.a(paramStrokeStrategy);
      Object localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker.a();
      a(0.0F);
      if (!((List)localObject).isEmpty())
      {
        paramStrokeStrategy = (Stroke)((List)localObject).get(0);
        localObject = (Stroke)((List)localObject).get(((List)localObject).size() - 1);
        this.jdField_a_of_type_Boolean = (paramStrokeStrategy instanceof PureStroke);
        this.jdField_b_of_type_Boolean = (localObject instanceof PureStroke);
      }
      invalidate();
      return;
    }
    setVisibility(8);
    Log.e("SelectStrokeLayout", "StrokeStrategy is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.SelectStrokeLayout
 * JD-Core Version:    0.7.0.1
 */
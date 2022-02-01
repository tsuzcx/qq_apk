package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QZoneLayoutTemplate1
  extends ViewGroup
{
  protected int a;
  private ImageView a;
  protected List<View> a;
  protected int b;
  private ImageView b;
  protected int c;
  protected int d;
  
  public QZoneLayoutTemplate1(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QZoneLayoutTemplate1(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QZoneLayoutTemplate1(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new ColorDrawable(-16777216);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramAttributeSet);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramAttributeSet);
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    super.addView(this.jdField_b_of_type_AndroidWidgetImageView);
    this.c = a(8.0F);
  }
  
  private int a(float paramFloat)
  {
    return (int)(getContext().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    this.jdField_a_of_type_JavaUtilList.add(paramView);
    paramView.setPadding(this.d, this.d, this.d, this.d);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = this.jdField_a_of_type_Int / 3;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      ((View)this.jdField_a_of_type_JavaUtilList.get(0)).layout(0, 0, paramInt1, paramInt1);
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      ((View)this.jdField_a_of_type_JavaUtilList.get(1)).layout(this.c + paramInt1, 0, paramInt1 * 2 + this.c, paramInt1);
      this.jdField_b_of_type_AndroidWidgetImageView.layout(paramInt1 * 2 + this.c * 2, 0, this.jdField_a_of_type_Int, paramInt1);
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 2)
    {
      ((View)this.jdField_a_of_type_JavaUtilList.get(2)).layout(this.jdField_a_of_type_Int - paramInt1 * 2 - this.c, this.c + paramInt1, this.jdField_a_of_type_Int - paramInt1 - this.c, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetImageView.layout(0, this.c + paramInt1, paramInt1 - this.c * 2, this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 3) {
      ((View)this.jdField_a_of_type_JavaUtilList.get(3)).layout(this.jdField_a_of_type_Int - paramInt1, paramInt1 + this.c, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = View.MeasureSpec.getSize(paramInt1);
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * 2 / 3 + this.c);
    paramInt1 = this.jdField_a_of_type_Int / 3;
    this.jdField_b_of_type_AndroidWidgetImageView.measure(View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int - paramInt1 * 2 - this.c * 2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
    this.jdField_a_of_type_AndroidWidgetImageView.measure(View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int - paramInt1 * 2 - this.c * 2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      ((View)this.jdField_a_of_type_JavaUtilList.get(0)).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
      ((View)this.jdField_a_of_type_JavaUtilList.get(1)).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 2) {
      ((View)this.jdField_a_of_type_JavaUtilList.get(2)).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 3) {
      ((View)this.jdField_a_of_type_JavaUtilList.get(3)).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 2)
    {
      setMeasuredDimension(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return;
    }
    setMeasuredDimension(this.jdField_a_of_type_Int, paramInt1);
  }
  
  public void removeAllViewsInLayout()
  {
    super.removeAllViewsInLayout();
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    super.addView(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void setBorderColor(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((View)localIterator.next()).setBackgroundColor(paramInt);
    }
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setItemBg(Drawable paramDrawable, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (paramDrawable != null) {
        localView.setBackgroundDrawable(paramDrawable);
      } else {
        localView.setBackgroundColor(paramInt);
      }
    }
  }
  
  public void setLeftView(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
  }
  
  public void setRightView(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.QZoneLayoutTemplate1
 * JD-Core Version:    0.7.0.1
 */
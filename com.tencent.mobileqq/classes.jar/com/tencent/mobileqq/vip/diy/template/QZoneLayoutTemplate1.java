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
    return (int)(paramFloat * getContext().getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    this.jdField_a_of_type_JavaUtilList.add(paramView);
    int i = this.d;
    paramView.setPadding(i, i, i, i);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = this.jdField_a_of_type_Int / 3;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      ((View)this.jdField_a_of_type_JavaUtilList.get(0)).layout(0, 0, paramInt1, paramInt1);
    }
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList.size() > 1)
    {
      localObject = (View)this.jdField_a_of_type_JavaUtilList.get(1);
      paramInt2 = this.c;
      paramInt3 = paramInt1 * 2;
      ((View)localObject).layout(paramInt1 + paramInt2, 0, paramInt2 + paramInt3, paramInt1);
      this.jdField_b_of_type_AndroidWidgetImageView.layout(paramInt3 + this.c * 2, 0, this.jdField_a_of_type_Int, paramInt1);
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 2)
    {
      localObject = (View)this.jdField_a_of_type_JavaUtilList.get(2);
      paramInt2 = this.jdField_a_of_type_Int;
      paramInt3 = this.c;
      ((View)localObject).layout(paramInt2 - paramInt1 * 2 - paramInt3, paramInt1 + paramInt3, paramInt2 - paramInt1 - paramInt3, this.jdField_b_of_type_Int);
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      paramInt2 = this.c;
      ((ImageView)localObject).layout(0, paramInt1 + paramInt2, paramInt1 - paramInt2 * 2, this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 3)
    {
      localObject = (View)this.jdField_a_of_type_JavaUtilList.get(3);
      paramInt2 = this.jdField_a_of_type_Int;
      ((View)localObject).layout(paramInt2 - paramInt1, paramInt1 + this.c, paramInt2, this.jdField_b_of_type_Int);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = this.jdField_a_of_type_Int;
    int i = paramInt1 * 2 / 3;
    paramInt2 = this.c;
    this.jdField_b_of_type_Int = (i + paramInt2);
    i = paramInt1 / 3;
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    int j = i * 2;
    localImageView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - j - paramInt2 * 2, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    this.jdField_a_of_type_AndroidWidgetImageView.measure(View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int - j - this.c * 2, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      ((View)this.jdField_a_of_type_JavaUtilList.get(0)).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
      ((View)this.jdField_a_of_type_JavaUtilList.get(1)).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 2) {
      ((View)this.jdField_a_of_type_JavaUtilList.get(2)).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 3) {
      ((View)this.jdField_a_of_type_JavaUtilList.get(3)).measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 2)
    {
      setMeasuredDimension(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return;
    }
    setMeasuredDimension(this.jdField_a_of_type_Int, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.QZoneLayoutTemplate1
 * JD-Core Version:    0.7.0.1
 */
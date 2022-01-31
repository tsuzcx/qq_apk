package com.tencent.mobileqq.troop.honor.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import azce;
import azch;
import azck;
import bajq;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.Collections;
import java.util.List;

public class TroopHonorView
  extends LinearLayout
{
  private static final int jdField_a_of_type_Int = bajq.a(18.0F);
  private static final int b = bajq.a(16.0F);
  private static final int c = bajq.a(1.0F);
  private String jdField_a_of_type_JavaLangString = "";
  private List<azch> jdField_a_of_type_JavaUtilList;
  
  public TroopHonorView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopHonorView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopHonorView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() * jdField_a_of_type_Int + (this.jdField_a_of_type_JavaUtilList.size() - 1) * jdField_a_of_type_Int + getPaddingLeft() + getPaddingRight();
  }
  
  public String a()
  {
    return azce.c(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void setHonorList(List<azch> paramList)
  {
    if (this.jdField_a_of_type_JavaLangString.equals(azce.b(paramList))) {}
    for (;;)
    {
      return;
      if (paramList != null) {
        Collections.sort(paramList);
      }
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_JavaLangString = azce.b(this.jdField_a_of_type_JavaUtilList);
      removeAllViews();
      if ((paramList != null) && (paramList.size() > 0))
      {
        int i = 0;
        int k;
        for (int j = 0; i < paramList.size(); j = k)
        {
          azch localazch = (azch)paramList.get(i);
          k = j;
          if (!TextUtils.isEmpty(localazch.b))
          {
            Object localObject = URLDrawable.URLDrawableOptions.obtain();
            localObject = URLDrawable.getDrawable(localazch.b, (URLDrawable.URLDrawableOptions)localObject);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(jdField_a_of_type_Int, b);
            ImageView localImageView = new ImageView(getContext());
            ((URLDrawable)localObject).setURLDrawableListener(new azck(this, localImageView));
            localImageView.setImageDrawable((Drawable)localObject);
            localImageView.setContentDescription(localazch.jdField_a_of_type_JavaLangString);
            if (j != 0) {
              localLayoutParams.leftMargin = c;
            }
            addView(localImageView, localLayoutParams);
            k = j + 1;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.widget.TroopHonorView
 * JD-Core Version:    0.7.0.1
 */
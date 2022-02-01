package com.tencent.mobileqq.troop.honor.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aqxe;
import bfwx;
import bfxc;
import bfxd;
import bfxf;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

public class TroopHonorView
  extends LinearLayout
{
  private static final int jdField_a_of_type_Int = ViewUtils.dip2px(16.0F);
  private static final int b = ViewUtils.dip2px(16.0F);
  private static final int c = ViewUtils.dip2px(1.0F);
  private String jdField_a_of_type_JavaLangString = "";
  private List<bfxc> jdField_a_of_type_JavaUtilList;
  
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
    return this.jdField_a_of_type_JavaUtilList.size() * jdField_a_of_type_Int + (this.jdField_a_of_type_JavaUtilList.size() - 1) * c + getPaddingLeft() + getPaddingRight();
  }
  
  public String a()
  {
    return bfwx.c(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void setHonorList(List<bfxc> paramList)
  {
    if (this.jdField_a_of_type_JavaLangString.equals(bfwx.b(paramList))) {}
    for (;;)
    {
      return;
      if (paramList != null) {
        Collections.sort(paramList);
      }
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_JavaLangString = bfwx.b(this.jdField_a_of_type_JavaUtilList);
      removeAllViews();
      if ((paramList != null) && (paramList.size() > 0))
      {
        int i = 0;
        int k;
        for (int j = 0; i < paramList.size(); j = k)
        {
          bfxc localbfxc = (bfxc)paramList.get(i);
          k = j;
          if (!TextUtils.isEmpty(localbfxc.b))
          {
            Object localObject = URLDrawable.URLDrawableOptions.obtain();
            localObject = URLDrawable.getDrawable(localbfxc.b, (URLDrawable.URLDrawableOptions)localObject);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(jdField_a_of_type_Int, b);
            ImageView localImageView = new ImageView(getContext());
            ((URLDrawable)localObject).setURLDrawableListener(new bfxf(localImageView));
            localImageView.setImageDrawable((Drawable)localObject);
            localImageView.setContentDescription(localbfxc.jdField_a_of_type_JavaLangString);
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
  
  public void setHonorList(List<bfxc> paramList, float paramFloat)
  {
    if (paramList == null) {
      return;
    }
    int i = (int)((paramFloat - getPaddingLeft() - getPaddingRight() + c) / (jdField_a_of_type_Int + c));
    Collections.sort(paramList);
    setHonorList(paramList.subList(0, Math.min(i, paramList.size())));
  }
  
  public void setHonorList(List<bfxc> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    bfxd localbfxd;
    if ((paramInt == 1) || (paramInt == 2))
    {
      localbfxd = (bfxd)aqxe.a().a(544);
      if (localbfxd == null) {
        break label114;
      }
    }
    label114:
    for (paramInt = localbfxd.jdField_a_of_type_Int;; paramInt = 3)
    {
      Collections.sort(paramList);
      setHonorList(paramList.subList(0, Math.min(paramInt, paramList.size())));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopHonorView", 2, "maxNumberOfAIOIcon = " + paramInt + ",honorList.size = " + paramList.size());
      return;
      setHonorList(paramList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.widget.TroopHonorView
 * JD-Core Version:    0.7.0.1
 */
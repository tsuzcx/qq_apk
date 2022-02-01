package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import bdzx;
import bibk;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import zkb;
import zlx;

public class QVipMedalView
  extends ViewGroup
{
  protected int a;
  protected bibk a;
  protected List<ImageView> a;
  protected int b;
  
  public QVipMedalView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QVipMedalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QVipMedalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(ImageView paramImageView, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QVipSettingMe.QVipMedalView", 1, "bindData with null value!!");
      return;
    }
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, bdzx.a, null, null);
    ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramImageView);
    paramImageView.setImageDrawable(paramString);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bibk == null) {}
    while (this.jdField_a_of_type_Bibk.a() == getChildCount()) {
      return;
    }
    zkb.a("consistency check failed ! adapter count=" + this.jdField_a_of_type_Bibk.a() + " view list size=" + this.jdField_a_of_type_JavaUtilList.size() + " child count=" + getChildCount(), new Object[0]);
    int j = this.jdField_a_of_type_Bibk.a();
    removeAllViews();
    int i = 0;
    label97:
    if (i < j)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() <= i) {
        break label189;
      }
      ((ImageView)this.jdField_a_of_type_JavaUtilList.get(i)).setImageDrawable(null);
    }
    for (;;)
    {
      a((ImageView)this.jdField_a_of_type_JavaUtilList.get(i), this.jdField_a_of_type_Bibk.a(i), this.jdField_a_of_type_Bibk.a(i));
      addView((View)this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
      break label97;
      break;
      label189:
      this.jdField_a_of_type_JavaUtilList.add(new ImageView(getContext()));
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Int = zlx.a(getContext(), 4.0F);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Bibk == null) {}
    label163:
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_Bibk.a();
      int j = getPaddingTop();
      int k = getPaddingBottom();
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 >= i) {
          break label163;
        }
        int m = this.b;
        int n = this.jdField_a_of_type_Int;
        m = getPaddingLeft() + (m + n) * paramInt2;
        n = m + this.b;
        if (n > paramInt3 - paramInt1)
        {
          if (paramInt2 == 0)
          {
            QLog.e("QVipMedalView", 1, "illegal size to layout the medal!! no one can layout");
            return;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QVipMedalView", 1, "It only can layout " + paramInt2 + "medal");
          return;
        }
        ((ImageView)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).layout(m, j, n, paramInt4 - k);
        paramInt2 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (this.jdField_a_of_type_Bibk == null)
    {
      setMeasuredDimension(0, 0);
      return;
    }
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (m == 1073741824)
    {
      this.b = (paramInt1 - getPaddingTop() - getPaddingBottom());
      if (k != 1073741824) {
        break label162;
      }
    }
    for (paramInt2 = j;; paramInt2 = (paramInt2 - 1) * this.jdField_a_of_type_Int + j * paramInt2 + getPaddingLeft() + getPaddingRight())
    {
      j = this.jdField_a_of_type_Bibk.a();
      b();
      while (i < j)
      {
        ((ImageView)this.jdField_a_of_type_JavaUtilList.get(i)).measure(View.MeasureSpec.makeMeasureSpec(this.b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
        i += 1;
      }
      this.b = zlx.a(getContext(), 20.0F);
      paramInt1 = this.b + getPaddingBottom() + getPaddingTop();
      break;
      label162:
      paramInt2 = this.jdField_a_of_type_Bibk.a();
      j = this.b;
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setAdapter(bibk parambibk)
  {
    this.jdField_a_of_type_Bibk = parambibk;
    removeAllViews();
    if (this.jdField_a_of_type_Bibk != null)
    {
      int j = this.jdField_a_of_type_Bibk.a();
      int i = 0;
      if (i < j)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > i) {
          ((ImageView)this.jdField_a_of_type_JavaUtilList.get(i)).setImageDrawable(null);
        }
        for (;;)
        {
          a((ImageView)this.jdField_a_of_type_JavaUtilList.get(i), this.jdField_a_of_type_Bibk.a(i), this.jdField_a_of_type_Bibk.a(i));
          addView((View)this.jdField_a_of_type_JavaUtilList.get(i));
          i += 1;
          break;
          this.jdField_a_of_type_JavaUtilList.add(new ImageView(getContext()));
        }
      }
    }
    requestLayout();
  }
  
  public void setData(MedalList paramMedalList)
  {
    if (this.jdField_a_of_type_Bibk == null) {
      this.jdField_a_of_type_Bibk = new bibk();
    }
    this.jdField_a_of_type_Bibk.a(paramMedalList);
    setAdapter(this.jdField_a_of_type_Bibk);
  }
  
  public void setItemMargin(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setItemWidth(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QVipMedalView
 * JD-Core Version:    0.7.0.1
 */
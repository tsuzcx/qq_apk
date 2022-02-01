package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import aneg;
import ayvw;
import bcef;
import bhij;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import yos;

public class QVipMedalView
  extends ViewGroup
{
  protected int a;
  protected bhij a;
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
  
  private void a(ImageView paramImageView, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QVipSettingMe.QVipMedalView", 1, "bindData with null value!!");
      return;
    }
    paramString = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, URLDrawableHelper.TRANSPARENT, null, null);
    ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramImageView);
    paramImageView.setImageDrawable(paramString);
    paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramString != null) {}
    for (paramInt1 = aneg.a(paramString, paramString.getCurrentUin(), false);; paramInt1 = 98)
    {
      if (paramInt2 != 0)
      {
        paramString = new ayvw();
        Message localMessage = Message.obtain();
        localMessage.arg1 = 1;
        localMessage.obj = paramImageView;
        localMessage.what = 0;
        paramImageView = new Bundle();
        paramImageView.putInt("iTipsTimes", paramInt3);
        localMessage.setData(paramImageView);
        paramString.removeMessages(localMessage.what);
        paramString.sendMessage(localMessage);
        a("0X800B2B3", paramInt1);
        return;
      }
      a("0X800B2B2", paramInt1);
      return;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bhij == null) {}
    while (this.jdField_a_of_type_Bhij.a() == getChildCount()) {
      return;
    }
    yos.a("consistency check failed ! adapter count=" + this.jdField_a_of_type_Bhij.a() + " view list size=" + this.jdField_a_of_type_JavaUtilList.size() + " child count=" + getChildCount(), new Object[0]);
    int j = this.jdField_a_of_type_Bhij.a();
    removeAllViews();
    int i = 0;
    label97:
    if (i < j)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() <= i) {
        break label205;
      }
      ((ImageView)this.jdField_a_of_type_JavaUtilList.get(i)).setImageDrawable(null);
    }
    for (;;)
    {
      a((ImageView)this.jdField_a_of_type_JavaUtilList.get(i), this.jdField_a_of_type_Bhij.a(i), this.jdField_a_of_type_Bhij.a(i), this.jdField_a_of_type_Bhij.b(i), this.jdField_a_of_type_Bhij.c(i));
      addView((View)this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
      break label97;
      break;
      label205:
      this.jdField_a_of_type_JavaUtilList.add(new ImageView(getContext()));
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Int = UIUtils.dip2px(getContext(), 4.0F);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(String paramString, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      bcef.b(localQQAppInterface, "dc00898", "", localQQAppInterface.getCurrentUin(), paramString, paramString, paramInt, 0, String.valueOf(paramInt), "", "", "");
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Bhij == null) {}
    label168:
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_Bhij.a();
      int j = getPaddingTop();
      int k = getPaddingBottom();
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 >= i) {
          break label168;
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
    if (this.jdField_a_of_type_Bhij == null)
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
        break label167;
      }
    }
    for (paramInt2 = j;; paramInt2 = (paramInt2 - 1) * this.jdField_a_of_type_Int + j * paramInt2 + getPaddingLeft() + getPaddingRight())
    {
      j = this.jdField_a_of_type_Bhij.a();
      b();
      while (i < j)
      {
        ((ImageView)this.jdField_a_of_type_JavaUtilList.get(i)).measure(View.MeasureSpec.makeMeasureSpec(this.b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
        i += 1;
      }
      this.b = UIUtils.dip2px(getContext(), 20.0F);
      paramInt1 = this.b + getPaddingBottom() + getPaddingTop();
      break;
      label167:
      paramInt2 = this.jdField_a_of_type_Bhij.a();
      j = this.b;
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setAdapter(bhij parambhij)
  {
    this.jdField_a_of_type_Bhij = parambhij;
    removeAllViews();
    if (this.jdField_a_of_type_Bhij != null)
    {
      int j = this.jdField_a_of_type_Bhij.a();
      int i = 0;
      if (i < j)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > i) {
          ((ImageView)this.jdField_a_of_type_JavaUtilList.get(i)).setImageDrawable(null);
        }
        for (;;)
        {
          a((ImageView)this.jdField_a_of_type_JavaUtilList.get(i), this.jdField_a_of_type_Bhij.a(i), this.jdField_a_of_type_Bhij.a(i), this.jdField_a_of_type_Bhij.b(i), this.jdField_a_of_type_Bhij.c(i));
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
    if (this.jdField_a_of_type_Bhij == null) {
      this.jdField_a_of_type_Bhij = new bhij();
    }
    this.jdField_a_of_type_Bhij.a(paramMedalList);
    setAdapter(this.jdField_a_of_type_Bhij);
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
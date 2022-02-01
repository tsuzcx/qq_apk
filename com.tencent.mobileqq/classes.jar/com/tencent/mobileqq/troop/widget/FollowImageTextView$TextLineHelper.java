package com.tencent.mobileqq.troop.widget;

import android.graphics.Canvas;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class FollowImageTextView$TextLineHelper
{
  private int jdField_a_of_type_Int;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private FollowImageTextView jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private List<FollowImageTextView.Line> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public FollowImageTextView$TextLineHelper(FollowImageTextView paramFollowImageTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView = paramFollowImageTextView;
  }
  
  private int a()
  {
    return this.jdField_a_of_type_Int - this.f - this.d;
  }
  
  private int a(CharSequence paramCharSequence)
  {
    return (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    int n = a();
    Object localObject;
    if (n <= 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("lineWidth=");
        ((StringBuilder)localObject).append(n);
        QLog.i("FollowImageTextView", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    int i1 = this.jdField_a_of_type_JavaLangCharSequence.length();
    int i = 0;
    int k = 0;
    int j = 0;
    while (i < i1)
    {
      if (this.jdField_a_of_type_JavaLangCharSequence.charAt(i) == '\n')
      {
        localObject = new FollowImageTextView.Line(null);
        ((FollowImageTextView.Line)localObject).jdField_a_of_type_Int = k;
        ((FollowImageTextView.Line)localObject).b = (i - 1);
        ((FollowImageTextView.Line)localObject).c = j;
        ((FollowImageTextView.Line)localObject).jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_JavaLangCharSequence.subSequence(k, i);
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        k = i + 1;
        j = 0;
      }
      else
      {
        int m = a(this.jdField_a_of_type_JavaLangCharSequence.subSequence(k, i + 1));
        if (m > n)
        {
          localObject = new FollowImageTextView.Line(null);
          ((FollowImageTextView.Line)localObject).jdField_a_of_type_Int = k;
          ((FollowImageTextView.Line)localObject).b = (i - 1);
          ((FollowImageTextView.Line)localObject).c = j;
          ((FollowImageTextView.Line)localObject).jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_JavaLangCharSequence.subSequence(k, i);
          this.jdField_a_of_type_JavaUtilList.add(localObject);
          if (this.jdField_a_of_type_JavaUtilList.size() >= i1) {
            break;
          }
          j = 0;
          k = i;
          i -= 1;
        }
        else if (i == i1 - 1)
        {
          localObject = new FollowImageTextView.Line(null);
          ((FollowImageTextView.Line)localObject).jdField_a_of_type_Int = k;
          ((FollowImageTextView.Line)localObject).b = (i - 1);
          ((FollowImageTextView.Line)localObject).c = m;
          ((FollowImageTextView.Line)localObject).jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_JavaLangCharSequence.subSequence(k, i1);
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
        else
        {
          j = m;
        }
      }
      i += 1;
    }
    if (FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView) != null) {
      FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView).a(this.jdField_a_of_type_JavaUtilList.size());
    }
  }
  
  public void a(int paramInt)
  {
    FollowImageTextView.FirstTextView localFirstTextView = FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView);
    this.jdField_a_of_type_JavaLangCharSequence = localFirstTextView.getText();
    this.jdField_a_of_type_AndroidTextTextPaint = localFirstTextView.getPaint();
    this.jdField_a_of_type_Int = localFirstTextView.getMeasuredWidth();
    this.b = localFirstTextView.getLineHeight();
    this.d = localFirstTextView.getPaddingLeft();
    this.e = localFirstTextView.getPaddingTop();
    this.f = localFirstTextView.getPaddingRight();
    this.g = localFirstTextView.getPaddingBottom();
    this.c = paramInt;
    a();
  }
  
  public void a(Canvas paramCanvas)
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = this.c;
    if ((i > 0) && (i < j)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      j = this.c;
    }
    int k = 0;
    while (k < j)
    {
      CharSequence localCharSequence = ((FollowImageTextView.Line)this.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaLangCharSequence;
      float f1 = this.jdField_a_of_type_AndroidTextTextPaint.getTextSize();
      paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), this.d + 0, f1 + this.b * k + this.e, this.jdField_a_of_type_AndroidTextTextPaint);
      k += 1;
    }
    if ((i != 0) && (j < this.jdField_a_of_type_JavaUtilList.size()))
    {
      paramCanvas = (FollowImageTextView.Line)this.jdField_a_of_type_JavaUtilList.get(j);
      i = this.jdField_a_of_type_JavaLangCharSequence.length();
      if ((paramCanvas.jdField_a_of_type_Int > -1) && (paramCanvas.jdField_a_of_type_Int < i))
      {
        paramCanvas = this.jdField_a_of_type_JavaLangCharSequence.subSequence(paramCanvas.jdField_a_of_type_Int, i);
        FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView).setText(paramCanvas);
        FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView, true);
        return;
      }
      FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView, false);
      return;
    }
    FollowImageTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFollowImageTextView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.FollowImageTextView.TextLineHelper
 * JD-Core Version:    0.7.0.1
 */
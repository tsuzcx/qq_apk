package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import ayow;
import ayoz;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class PicProgressView
  extends MessageProgressView
{
  int jdField_a_of_type_Int = 0;
  private ayoz jdField_a_of_type_Ayoz;
  PicProgressView.RefreshProgressRunnable jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable;
  public String a;
  public boolean a;
  private boolean b;
  
  public PicProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PicProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PicProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ayoz == null) {}
    label222:
    do
    {
      int i;
      do
      {
        return;
        if ((this.jdField_a_of_type_Ayoz.e() < 100) && (paramInt1 >= 100)) {
          i = 100;
        }
        do
        {
          this.jdField_a_of_type_Ayoz.a(i);
          paramInt1 = Math.max(this.jdField_a_of_type_Ayoz.g(), 0);
          long l = 25L;
          if (this.jdField_a_of_type_Ayoz.g() < 0) {
            l = 1000L;
          }
          if (this.jdField_a_of_type_Ayoz.e() > paramInt1) {
            break label222;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PicProgressView", 2, "currentProgress " + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_Ayoz.a() + " processor " + this.jdField_a_of_type_Ayoz);
          }
          setProgress(i);
          if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable != null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable = new PicProgressView.RefreshProgressRunnable(this, i, paramInt2);
          postDelayed(this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable, l);
          return;
          i = paramInt1;
        } while (paramInt1 < 100);
        this.jdField_a_of_type_Ayoz = null;
        return;
      } while (paramInt2 == 1);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable.a(paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PicProgressView", 2, "doUpdateCurrentProgress ,currentProgress:" + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_Ayoz.a() + " processor " + this.jdField_a_of_type_Ayoz);
      }
    } while (paramInt1 < this.jdField_a_of_type_Int);
    setProgress(paramInt1);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Ayoz != null) {
      return this.jdField_a_of_type_Ayoz.e();
    }
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicProgressView", 2, "updateProgress processor:" + this.jdField_a_of_type_Ayoz);
    }
    if (this.jdField_a_of_type_Ayoz != null) {
      a(this.jdField_a_of_type_Ayoz.e(), 1);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Ayoz != null) && ((this.jdField_a_of_type_Ayoz instanceof ayow)) && (this.jdField_a_of_type_Ayoz.c() < 1001L)) {
      return;
    }
    super.a(paramCanvas);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable);
    super.onDetachedFromWindow();
  }
  
  public void setProcessor(ayoz paramayoz)
  {
    if (this.jdField_a_of_type_Ayoz == paramayoz) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable != null)
    {
      removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable = null;
    }
    this.jdField_a_of_type_Ayoz = paramayoz;
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt == 100) {
      setProcessor(null);
    }
    this.jdField_a_of_type_Int = paramInt;
    setDrawStatus(1);
    setAnimProgress(paramInt, this.jdField_a_of_type_JavaLangString);
  }
  
  public void setProgressKey(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a(paramString);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    int i = 1;
    if ((!this.b) && (paramBoolean == true)) {}
    for (;;)
    {
      this.b = paramBoolean;
      if (i != 0) {
        invalidate();
      }
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.PicProgressView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import berl;
import berp;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class PicProgressView
  extends MessageProgressView
{
  int jdField_a_of_type_Int = 0;
  private berp jdField_a_of_type_Berp;
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
    if (this.jdField_a_of_type_Berp == null) {}
    label222:
    do
    {
      int i;
      do
      {
        return;
        if ((this.jdField_a_of_type_Berp.e() < 100) && (paramInt1 >= 100)) {
          i = 100;
        }
        do
        {
          this.jdField_a_of_type_Berp.a(i);
          paramInt1 = Math.max(this.jdField_a_of_type_Berp.g(), 0);
          long l = 25L;
          if (this.jdField_a_of_type_Berp.g() < 0) {
            l = 1000L;
          }
          if (this.jdField_a_of_type_Berp.e() > paramInt1) {
            break label222;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PicProgressView", 2, "currentProgress " + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_Berp.b() + " processor " + this.jdField_a_of_type_Berp);
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
        this.jdField_a_of_type_Berp = null;
        return;
      } while (paramInt2 == 1);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable.a(paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PicProgressView", 2, "doUpdateCurrentProgress ,currentProgress:" + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_Berp.b() + " processor " + this.jdField_a_of_type_Berp);
      }
    } while (paramInt1 < this.jdField_a_of_type_Int);
    setProgress(paramInt1);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Berp != null) {
      return this.jdField_a_of_type_Berp.e();
    }
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicProgressView", 2, "updateProgress processor:" + this.jdField_a_of_type_Berp);
    }
    if (this.jdField_a_of_type_Berp != null) {
      a(this.jdField_a_of_type_Berp.e(), 1);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Berp != null) && ((this.jdField_a_of_type_Berp instanceof berl)) && (this.jdField_a_of_type_Berp.c() < 1001L)) {
      return;
    }
    super.a(paramCanvas);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable);
    super.onDetachedFromWindow();
  }
  
  public void setProcessor(berp paramberp)
  {
    if (this.jdField_a_of_type_Berp == paramberp) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable != null)
    {
      removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable = null;
    }
    this.jdField_a_of_type_Berp = paramberp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.PicProgressView
 * JD-Core Version:    0.7.0.1
 */
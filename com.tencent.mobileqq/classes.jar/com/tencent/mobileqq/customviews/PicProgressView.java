package com.tencent.mobileqq.customviews;

import abmq;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mobileqq.transfile.BasePicUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class PicProgressView
  extends MessageProgressView
{
  int jdField_a_of_type_Int = 0;
  public abmq a;
  private BaseTransProcessor jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor;
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
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor == null) {}
    label222:
    do
    {
      int i;
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.e() < 100) && (paramInt1 >= 100)) {
          i = 100;
        }
        do
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a(i);
          paramInt1 = Math.max(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.g(), 0);
          long l = 25L;
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.g() < 0) {
            l = 1000L;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.e() > paramInt1) {
            break label222;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PicProgressView", 2, "currentProgress " + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a() + " processor " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
          }
          setProgress(i);
          if (this.jdField_a_of_type_Abmq != null) {
            break;
          }
          this.jdField_a_of_type_Abmq = new abmq(this, i, paramInt2);
          postDelayed(this.jdField_a_of_type_Abmq, l);
          return;
          i = paramInt1;
        } while (paramInt1 < 100);
        this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = null;
        return;
      } while (paramInt2 == 1);
      this.jdField_a_of_type_Abmq.a(paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PicProgressView", 2, "doUpdateCurrentProgress ,currentProgress:" + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a() + " processor " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
      }
    } while (paramInt1 < this.jdField_a_of_type_Int);
    setProgress(paramInt1);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.e();
    }
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicProgressView", 2, "updateProgress processor:" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.e(), 1);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor instanceof BasePicUploadProcessor)) && (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.c() < 1002L)) {
      return;
    }
    super.a(paramCanvas);
  }
  
  public void setProcessor(BaseTransProcessor paramBaseTransProcessor)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor == paramBaseTransProcessor) {
      return;
    }
    if (this.jdField_a_of_type_Abmq != null)
    {
      removeCallbacks(this.jdField_a_of_type_Abmq);
      this.jdField_a_of_type_Abmq = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = paramBaseTransProcessor;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.PicProgressView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.customviews;

import agmy;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import arqt;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.qphone.base.util.QLog;

public class MessageProgressTextView
  extends TextView
{
  private arqt jdField_a_of_type_Arqt;
  MessageProgressTextView.RefreshProgressRunnable jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable;
  private BaseTransProcessor jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor;
  private boolean jdField_a_of_type_Boolean = true;
  public boolean b;
  int c;
  public boolean c;
  int d;
  int e = 0;
  
  public MessageProgressTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public MessageProgressTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public MessageProgressTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Boolean = true;
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
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.getCurrentProgress() < 100) && (paramInt1 >= 100)) {
          i = 100;
        }
        do
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.setCurrentProgress(i);
          paramInt1 = Math.max(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.getRealProgress(), 0);
          long l = 25L;
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.getRealProgress() < 0) {
            l = 1000L;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.getCurrentProgress() > paramInt1) {
            break label222;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProgressTextView", 2, "currentProgress " + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.getKey() + " processor " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
          }
          setProgress(i);
          if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable != null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable = new MessageProgressTextView.RefreshProgressRunnable(this, i, paramInt2);
          postDelayed(this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable, l);
          return;
          i = paramInt1;
        } while (paramInt1 < 100);
        this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = null;
        return;
      } while (paramInt2 == 1);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable.a(paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProgressTextView", 2, "doUpdateCurrentProgress ,currentProgress:" + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.getKey() + " processor " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
      }
    } while (paramInt1 < this.e);
    setProgress(paramInt1);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProgressTextView", 2, "updateProgress processor:" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.getCurrentProgress(), 1);
    }
  }
  
  public void setDisplayInTextView(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
  }
  
  public void setProcessor(BaseTransProcessor paramBaseTransProcessor)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor == paramBaseTransProcessor) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable != null)
    {
      removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = paramBaseTransProcessor;
  }
  
  public void setProgress(int paramInt)
  {
    this.e = paramInt;
    if (this.jdField_a_of_type_Arqt != null) {
      this.jdField_a_of_type_Arqt.a(paramInt);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
      setText(paramInt + "%");
    }
    for (;;)
    {
      Drawable localDrawable = getBackground();
      if (localDrawable != null)
      {
        localDrawable.setLevel((100 - paramInt) * 100);
        if (((localDrawable instanceof agmy)) && (!this.jdField_c_of_type_Boolean)) {
          ((agmy)localDrawable).a(this.jdField_c_of_type_Int, this.d);
        }
      }
      return;
      setText("");
    }
  }
  
  public void setProgressListener(arqt paramarqt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Arqt = paramarqt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.MessageProgressTextView
 * JD-Core Version:    0.7.0.1
 */
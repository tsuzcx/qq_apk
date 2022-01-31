package com.tencent.mobileqq.customviews;

import afcu;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import aowp;
import bamw;
import com.tencent.qphone.base.util.QLog;

public class MessageProgressTextView
  extends TextView
{
  private aowp jdField_a_of_type_Aowp;
  private bamw jdField_a_of_type_Bamw;
  MessageProgressTextView.RefreshProgressRunnable jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable;
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
    if (this.jdField_a_of_type_Bamw == null) {}
    label222:
    do
    {
      int i;
      do
      {
        return;
        if ((this.jdField_a_of_type_Bamw.e() < 100) && (paramInt1 >= 100)) {
          i = 100;
        }
        do
        {
          this.jdField_a_of_type_Bamw.a(i);
          paramInt1 = Math.max(this.jdField_a_of_type_Bamw.g(), 0);
          long l = 25L;
          if (this.jdField_a_of_type_Bamw.g() < 0) {
            l = 1000L;
          }
          if (this.jdField_a_of_type_Bamw.e() > paramInt1) {
            break label222;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProgressTextView", 2, "currentProgress " + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_Bamw.a() + " processor " + this.jdField_a_of_type_Bamw);
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
        this.jdField_a_of_type_Bamw = null;
        return;
      } while (paramInt2 == 1);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable.a(paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProgressTextView", 2, "doUpdateCurrentProgress ,currentProgress:" + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_Bamw.a() + " processor " + this.jdField_a_of_type_Bamw);
      }
    } while (paramInt1 < this.e);
    setProgress(paramInt1);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProgressTextView", 2, "updateProgress processor:" + this.jdField_a_of_type_Bamw);
    }
    if (this.jdField_a_of_type_Bamw != null) {
      a(this.jdField_a_of_type_Bamw.e(), 1);
    }
  }
  
  public void setDisplayInTextView(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
  }
  
  public void setProcessor(bamw parambamw)
  {
    if (this.jdField_a_of_type_Bamw == parambamw) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable != null)
    {
      removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable = null;
    }
    this.jdField_a_of_type_Bamw = parambamw;
  }
  
  public void setProgress(int paramInt)
  {
    this.e = paramInt;
    if (this.jdField_a_of_type_Aowp != null) {
      this.jdField_a_of_type_Aowp.a(paramInt);
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
        if (((localDrawable instanceof afcu)) && (!this.jdField_c_of_type_Boolean)) {
          ((afcu)localDrawable).a(this.jdField_c_of_type_Int, this.d);
        }
      }
      return;
      setText("");
    }
  }
  
  public void setProgressListener(aowp paramaowp, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aowp = paramaowp;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.MessageProgressTextView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.customviews;

import agxx;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import artk;
import berp;
import com.tencent.qphone.base.util.QLog;

public class MessageProgressTextView
  extends TextView
{
  private artk jdField_a_of_type_Artk;
  private berp jdField_a_of_type_Berp;
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
            QLog.d("ProgressTextView", 2, "currentProgress " + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_Berp.b() + " processor " + this.jdField_a_of_type_Berp);
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
        this.jdField_a_of_type_Berp = null;
        return;
      } while (paramInt2 == 1);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable.a(paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProgressTextView", 2, "doUpdateCurrentProgress ,currentProgress:" + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_Berp.b() + " processor " + this.jdField_a_of_type_Berp);
      }
    } while (paramInt1 < this.e);
    setProgress(paramInt1);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProgressTextView", 2, "updateProgress processor:" + this.jdField_a_of_type_Berp);
    }
    if (this.jdField_a_of_type_Berp != null) {
      a(this.jdField_a_of_type_Berp.e(), 1);
    }
  }
  
  public void setDisplayInTextView(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
  }
  
  public void setProcessor(berp paramberp)
  {
    if (this.jdField_a_of_type_Berp == paramberp) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable != null)
    {
      removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable = null;
    }
    this.jdField_a_of_type_Berp = paramberp;
  }
  
  public void setProgress(int paramInt)
  {
    this.e = paramInt;
    if (this.jdField_a_of_type_Artk != null) {
      this.jdField_a_of_type_Artk.a(paramInt);
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
        if (((localDrawable instanceof agxx)) && (!this.jdField_c_of_type_Boolean)) {
          ((agxx)localDrawable).a(this.jdField_c_of_type_Int, this.d);
        }
      }
      return;
      setText("");
    }
  }
  
  public void setProgressListener(artk paramartk, boolean paramBoolean)
  {
    this.jdField_a_of_type_Artk = paramartk;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.MessageProgressTextView
 * JD-Core Version:    0.7.0.1
 */
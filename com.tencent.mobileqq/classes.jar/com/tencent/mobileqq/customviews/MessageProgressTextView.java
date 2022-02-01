package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.AIOSendMask;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.qphone.base.util.QLog;

public class MessageProgressTextView
  extends TextView
{
  private MessageProgressTextView.ProgressListener jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener;
  MessageProgressTextView.RefreshProgressRunnable jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable;
  private BaseTransProcessor jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor;
  private boolean jdField_a_of_type_Boolean = true;
  public boolean b = false;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor;
    if (localObject == null) {
      return;
    }
    int i;
    if ((((BaseTransProcessor)localObject).getCurrentProgress() < 100) && (paramInt1 >= 100))
    {
      i = 100;
    }
    else
    {
      i = paramInt1;
      if (paramInt1 >= 100)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = null;
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.setCurrentProgress(i);
    paramInt1 = Math.max(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.getRealProgress(), 0);
    long l = 25L;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.getRealProgress() < 0) {
      l = 1000L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.getCurrentProgress() <= paramInt1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("currentProgress ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" receiveProgress ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("addProgress");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" processor.getKey() ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.getKey());
        ((StringBuilder)localObject).append(" processor ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
        QLog.d("ProgressTextView", 2, ((StringBuilder)localObject).toString());
      }
      setProgress(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable;
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable = new MessageProgressTextView.RefreshProgressRunnable(this, i, paramInt2);
        postDelayed(this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable, l);
        return;
      }
      if (paramInt2 != 1) {
        ((MessageProgressTextView.RefreshProgressRunnable)localObject).a(paramInt2);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doUpdateCurrentProgress ,currentProgress:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" receiveProgress ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("addProgress");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" processor.getKey() ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.getKey());
        ((StringBuilder)localObject).append(" processor ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
        QLog.d("ProgressTextView", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt1 >= this.e) {
        setProgress(paramInt1);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateProgress processor:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
      QLog.d("ProgressTextView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor;
    if (localObject != null) {
      a(((BaseTransProcessor)localObject).getCurrentProgress(), 1);
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
    MessageProgressTextView.RefreshProgressRunnable localRefreshProgressRunnable = this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable;
    if (localRefreshProgressRunnable != null)
    {
      removeCallbacks(localRefreshProgressRunnable);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$RefreshProgressRunnable = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = paramBaseTransProcessor;
  }
  
  public void setProgress(int paramInt)
  {
    this.e = paramInt;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener;
    if (localObject != null) {
      ((MessageProgressTextView.ProgressListener)localObject).a(paramInt);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("%");
      setText(((StringBuilder)localObject).toString());
    }
    else
    {
      setText("");
    }
    localObject = getBackground();
    if (localObject != null)
    {
      ((Drawable)localObject).setLevel((100 - paramInt) * 100);
      if (((localObject instanceof AIOSendMask)) && (!this.jdField_c_of_type_Boolean)) {
        ((AIOSendMask)localObject).a(this.jdField_c_of_type_Int, this.d);
      }
    }
  }
  
  public void setProgressListener(MessageProgressTextView.ProgressListener paramProgressListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener = paramProgressListener;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.MessageProgressTextView
 * JD-Core Version:    0.7.0.1
 */
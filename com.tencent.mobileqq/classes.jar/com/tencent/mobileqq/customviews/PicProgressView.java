package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mobileqq.pic.api.IPicTransFile.IPicUploadPro;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class PicProgressView
  extends MessageProgressView
{
  int jdField_a_of_type_Int = 0;
  PicProgressView.RefreshProgressRunnable jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable;
  private BaseTransProcessor jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor;
  public String a;
  public boolean a;
  private boolean b = false;
  
  public PicProgressView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public PicProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public PicProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
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
        QLog.d("PicProgressView", 2, ((StringBuilder)localObject).toString());
      }
      setProgress(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable;
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable = new PicProgressView.RefreshProgressRunnable(this, i, paramInt2);
        postDelayed(this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable, l);
        return;
      }
      if (paramInt2 != 1) {
        ((PicProgressView.RefreshProgressRunnable)localObject).a(paramInt2);
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
        QLog.d("PicProgressView", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt1 >= this.jdField_a_of_type_Int) {
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
      QLog.d("PicProgressView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor;
    if (localObject != null) {
      a(((BaseTransProcessor)localObject).getCurrentProgress(), 1);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    BaseTransProcessor localBaseTransProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor;
    if ((localBaseTransProcessor != null) && ((localBaseTransProcessor instanceof IPicTransFile.IPicUploadPro)) && (localBaseTransProcessor.getFileStatus() < 1001L)) {
      return;
    }
    super.a(paramCanvas);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable);
    super.onDetachedFromWindow();
  }
  
  public void setProcessor(BaseTransProcessor paramBaseTransProcessor)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor == paramBaseTransProcessor) {
      return;
    }
    PicProgressView.RefreshProgressRunnable localRefreshProgressRunnable = this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable;
    if (localRefreshProgressRunnable != null)
    {
      removeCallbacks(localRefreshProgressRunnable);
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView$RefreshProgressRunnable = null;
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
    boolean bool = this.b;
    int i = 1;
    if ((bool) || (paramBoolean != true)) {
      i = 0;
    }
    this.b = paramBoolean;
    if (i != 0) {
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.PicProgressView
 * JD-Core Version:    0.7.0.1
 */
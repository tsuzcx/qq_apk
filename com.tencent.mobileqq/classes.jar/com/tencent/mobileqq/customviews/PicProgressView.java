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
  private boolean D = false;
  public boolean a = false;
  PicProgressView.RefreshProgressRunnable b;
  public String c;
  int d = 0;
  private BaseTransProcessor e;
  
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
    Object localObject = this.e;
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
        this.e = null;
        return;
      }
    }
    this.e.setCurrentProgress(i);
    paramInt1 = Math.max(this.e.getRealProgress(), 0);
    long l = 25L;
    if (this.e.getRealProgress() < 0) {
      l = 1000L;
    }
    if (this.e.getCurrentProgress() <= paramInt1)
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
        ((StringBuilder)localObject).append(this.e.getKey());
        ((StringBuilder)localObject).append(" processor ");
        ((StringBuilder)localObject).append(this.e);
        QLog.d("PicProgressView", 2, ((StringBuilder)localObject).toString());
      }
      setProgress(i);
      localObject = this.b;
      if (localObject == null)
      {
        this.b = new PicProgressView.RefreshProgressRunnable(this, i, paramInt2);
        postDelayed(this.b, l);
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
        ((StringBuilder)localObject).append(this.e.getKey());
        ((StringBuilder)localObject).append(" processor ");
        ((StringBuilder)localObject).append(this.e);
        QLog.d("PicProgressView", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt1 >= this.d) {
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
      ((StringBuilder)localObject).append(this.e);
      QLog.d("PicProgressView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e;
    if (localObject != null) {
      a(((BaseTransProcessor)localObject).getCurrentProgress(), 1);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    BaseTransProcessor localBaseTransProcessor = this.e;
    if ((localBaseTransProcessor != null) && ((localBaseTransProcessor instanceof IPicTransFile.IPicUploadPro)) && (localBaseTransProcessor.getFileStatus() < 1001L)) {
      return;
    }
    super.a(paramCanvas);
  }
  
  public int getProgress()
  {
    BaseTransProcessor localBaseTransProcessor = this.e;
    if (localBaseTransProcessor != null) {
      return localBaseTransProcessor.getCurrentProgress();
    }
    return 0;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.b);
    super.onDetachedFromWindow();
  }
  
  public void setProcessor(BaseTransProcessor paramBaseTransProcessor)
  {
    if (this.e == paramBaseTransProcessor) {
      return;
    }
    PicProgressView.RefreshProgressRunnable localRefreshProgressRunnable = this.b;
    if (localRefreshProgressRunnable != null)
    {
      removeCallbacks(localRefreshProgressRunnable);
      this.b = null;
    }
    this.e = paramBaseTransProcessor;
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt == 100) {
      setProcessor(null);
    }
    this.d = paramInt;
    setDrawStatus(1);
    setAnimProgress(paramInt, this.c);
  }
  
  public void setProgressKey(String paramString)
  {
    this.c = paramString;
    a(paramString);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    boolean bool = this.D;
    int i = 1;
    if ((bool) || (paramBoolean != true)) {
      i = 0;
    }
    this.D = paramBoolean;
    if (i != 0) {
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.PicProgressView
 * JD-Core Version:    0.7.0.1
 */
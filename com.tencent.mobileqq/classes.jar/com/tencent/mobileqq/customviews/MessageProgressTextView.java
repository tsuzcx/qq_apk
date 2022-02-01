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
  private BaseTransProcessor a;
  private boolean b = true;
  private MessageProgressTextView.ProgressListener c;
  public boolean d = false;
  MessageProgressTextView.RefreshProgressRunnable e;
  int f;
  int g;
  public boolean h = true;
  int i = 0;
  
  public MessageProgressTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MessageProgressTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MessageProgressTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    int j;
    if ((((BaseTransProcessor)localObject).getCurrentProgress() < 100) && (paramInt1 >= 100))
    {
      j = 100;
    }
    else
    {
      j = paramInt1;
      if (paramInt1 >= 100)
      {
        this.a = null;
        return;
      }
    }
    this.a.setCurrentProgress(j);
    paramInt1 = Math.max(this.a.getRealProgress(), 0);
    long l = 25L;
    if (this.a.getRealProgress() < 0) {
      l = 1000L;
    }
    if (this.a.getCurrentProgress() <= paramInt1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("currentProgress ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" receiveProgress ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("addProgress");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" processor.getKey() ");
        ((StringBuilder)localObject).append(this.a.getKey());
        ((StringBuilder)localObject).append(" processor ");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("ProgressTextView", 2, ((StringBuilder)localObject).toString());
      }
      setProgress(j);
      localObject = this.e;
      if (localObject == null)
      {
        this.e = new MessageProgressTextView.RefreshProgressRunnable(this, j, paramInt2);
        postDelayed(this.e, l);
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
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" receiveProgress ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("addProgress");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" processor.getKey() ");
        ((StringBuilder)localObject).append(this.a.getKey());
        ((StringBuilder)localObject).append(" processor ");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("ProgressTextView", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt1 >= this.i) {
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
      ((StringBuilder)localObject).append(this.a);
      QLog.d("ProgressTextView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null) {
      a(((BaseTransProcessor)localObject).getCurrentProgress(), 1);
    }
  }
  
  public int getProgress()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return ((BaseTransProcessor)localObject).getCurrentProgress();
    }
    localObject = this.c;
    if (localObject != null) {
      ((MessageProgressTextView.ProgressListener)localObject).a();
    }
    return 0;
  }
  
  public MessageProgressTextView.ProgressListener getProgressListener()
  {
    return this.c;
  }
  
  public void setDisplayInTextView(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.h = paramBoolean;
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public void setProcessor(BaseTransProcessor paramBaseTransProcessor)
  {
    if (this.a == paramBaseTransProcessor) {
      return;
    }
    MessageProgressTextView.RefreshProgressRunnable localRefreshProgressRunnable = this.e;
    if (localRefreshProgressRunnable != null)
    {
      removeCallbacks(localRefreshProgressRunnable);
      this.e = null;
    }
    this.a = paramBaseTransProcessor;
  }
  
  public void setProgress(int paramInt)
  {
    this.i = paramInt;
    Object localObject = this.c;
    if (localObject != null) {
      ((MessageProgressTextView.ProgressListener)localObject).a(paramInt);
    }
    if ((this.b) && (this.h))
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
      if (((localObject instanceof AIOSendMask)) && (!this.h)) {
        ((AIOSendMask)localObject).a(this.f, this.g);
      }
    }
  }
  
  public void setProgressListener(MessageProgressTextView.ProgressListener paramProgressListener, boolean paramBoolean)
  {
    this.c = paramProgressListener;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.MessageProgressTextView
 * JD-Core Version:    0.7.0.1
 */
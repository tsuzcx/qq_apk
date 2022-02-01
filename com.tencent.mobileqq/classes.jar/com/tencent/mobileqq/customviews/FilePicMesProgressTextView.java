package com.tencent.mobileqq.customviews;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.item.AIOSendMask;
import com.tencent.mobileqq.transfile.BaseTransProcessor;

public class FilePicMesProgressTextView
  extends MessageProgressTextView
{
  int a;
  int b;
  public boolean c;
  private BaseTransProcessor j;
  private boolean k;
  
  public int getProgress()
  {
    BaseTransProcessor localBaseTransProcessor = this.j;
    if (localBaseTransProcessor != null) {
      return localBaseTransProcessor.getCurrentProgress();
    }
    return 0;
  }
  
  public void setDisplayInTextView(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.c = paramBoolean;
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void setProgress(int paramInt)
  {
    if ((this.k) && (this.c))
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
    Object localObject = getBackground();
    if (localObject != null)
    {
      ((Drawable)localObject).setLevel((100 - paramInt) * 100);
      if (((localObject instanceof AIOSendMask)) && (!this.c)) {
        ((AIOSendMask)localObject).a(this.a, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.FilePicMesProgressTextView
 * JD-Core Version:    0.7.0.1
 */
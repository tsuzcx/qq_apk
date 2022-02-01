package com.tencent.mobileqq.nearby.now;

import com.tencent.mobileqq.nearby.now.view.SplitedProgressBar;
import java.security.InvalidParameterException;

public class ProgressControler
{
  private SplitedProgressBar a;
  
  public ProgressControler(SplitedProgressBar paramSplitedProgressBar)
  {
    if (paramSplitedProgressBar != null)
    {
      this.a = paramSplitedProgressBar;
      return;
    }
    throw new InvalidParameterException("ProgressControler: progressBar is null");
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.a.setTotalCount(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.a.b) {
      this.a.setProgress(paramInt1, paramInt2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SplitedProgressBar localSplitedProgressBar = this.a;
    int i;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    localSplitedProgressBar.setVisibility(i);
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.a.setShowMaxCount(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.ProgressControler
 * JD-Core Version:    0.7.0.1
 */
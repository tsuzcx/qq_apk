package com.tencent.mobileqq.search.rich;

import android.content.Context;

public abstract class NativeRichNode
  extends RichNodeBase
{
  protected abstract IRichNodeView a(Context paramContext);
  
  public int d()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.NativeRichNode
 * JD-Core Version:    0.7.0.1
 */
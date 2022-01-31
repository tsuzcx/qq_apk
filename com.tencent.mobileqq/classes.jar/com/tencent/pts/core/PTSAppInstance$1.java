package com.tencent.pts.core;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;

class PTSAppInstance$1
  extends ThreadLocal<TextView>
{
  PTSAppInstance$1(PTSAppInstance paramPTSAppInstance, Context paramContext) {}
  
  @Nullable
  protected TextView initialValue()
  {
    return new TextView(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.core.PTSAppInstance.1
 * JD-Core Version:    0.7.0.1
 */
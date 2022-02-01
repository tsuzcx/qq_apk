package com.tencent.mobileqq.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;

public class ConversationContainer
  extends RelativeLayout
{
  private static final String TAG = "Bitmap_Crash";
  private boolean hasReport;
  
  public ConversationContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public ConversationContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ConversationContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
      if (!this.hasReport)
      {
        this.hasReport = true;
        QLog.d("Bitmap_Crash", 1, paramCanvas, new Object[0]);
        CaughtExceptionReport.a(paramCanvas);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.ui.ConversationContainer
 * JD-Core Version:    0.7.0.1
 */
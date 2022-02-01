package com.tencent.qqperf.monitor.crash;

import android.os.Handler;
import android.os.Looper;

final class ReportLog$1
  extends Handler
{
  ReportLog$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 19	android/os/Message:what	I
    //   4: ldc 20
    //   6: if_icmpne +69 -> 75
    //   9: getstatic 26	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   12: ldc 27
    //   14: invokevirtual 33	android/app/ProgressDialog:findViewById	(I)Landroid/view/View;
    //   17: checkcast 35	android/widget/ProgressBar
    //   20: astore_1
    //   21: getstatic 26	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   24: invokevirtual 39	android/app/ProgressDialog:getContext	()Landroid/content/Context;
    //   27: invokevirtual 45	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   30: ldc 46
    //   32: invokevirtual 52	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   35: astore_2
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 56	android/widget/ProgressBar:setIndeterminateDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual 59	android/widget/ProgressBar:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   46: getstatic 26	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   49: ldc 60
    //   51: invokevirtual 33	android/app/ProgressDialog:findViewById	(I)Landroid/view/View;
    //   54: checkcast 62	android/widget/TextView
    //   57: ldc 63
    //   59: invokevirtual 67	android/widget/TextView:setText	(I)V
    //   62: invokestatic 70	com/tencent/qqperf/monitor/crash/ReportLog:a	()Landroid/os/Handler;
    //   65: ldc 71
    //   67: ldc2_w 72
    //   70: invokevirtual 77	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   73: pop
    //   74: return
    //   75: aload_1
    //   76: getfield 19	android/os/Message:what	I
    //   79: ldc 71
    //   81: if_icmpne +42 -> 123
    //   84: getstatic 26	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   87: ifnull +36 -> 123
    //   90: iconst_0
    //   91: putstatic 80	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_Boolean	Z
    //   94: getstatic 26	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   97: invokevirtual 84	android/app/ProgressDialog:dismiss	()V
    //   100: goto +12 -> 112
    //   103: astore_1
    //   104: goto +13 -> 117
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   112: aconst_null
    //   113: putstatic 26	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   116: return
    //   117: aconst_null
    //   118: putstatic 26	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   121: aload_1
    //   122: athrow
    //   123: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	1
    //   0	124	1	paramMessage	android.os.Message
    //   35	8	2	localDrawable	android.graphics.drawable.Drawable
    // Exception table:
    //   from	to	target	type
    //   90	100	103	finally
    //   108	112	103	finally
    //   90	100	107	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.ReportLog.1
 * JD-Core Version:    0.7.0.1
 */
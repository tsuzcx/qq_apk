package com.tencent.mobileqq.gamecenter.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class CommUtils
{
  private static QQProgressDialog a;
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public static void a()
  {
    QQProgressDialog localQQProgressDialog = a;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        a.cancel();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    a = null;
  }
  
  /* Error */
  public static void a(android.app.Activity paramActivity)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +112 -> 113
    //   4: aload_0
    //   5: invokevirtual 47	android/app/Activity:isFinishing	()Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: getstatic 29	com/tencent/mobileqq/gamecenter/utils/CommUtils:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   15: ifnonnull +31 -> 46
    //   18: new 31	com/tencent/mobileqq/widget/QQProgressDialog
    //   21: dup
    //   22: aload_0
    //   23: aload_0
    //   24: invokevirtual 51	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   27: ldc 52
    //   29: invokevirtual 56	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   32: invokespecial 59	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   35: putstatic 29	com/tencent/mobileqq/gamecenter/utils/CommUtils:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   38: getstatic 29	com/tencent/mobileqq/gamecenter/utils/CommUtils:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   41: ldc 60
    //   43: invokevirtual 64	com/tencent/mobileqq/widget/QQProgressDialog:c	(I)V
    //   46: getstatic 29	com/tencent/mobileqq/gamecenter/utils/CommUtils:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   49: invokevirtual 67	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   52: getstatic 29	com/tencent/mobileqq/gamecenter/utils/CommUtils:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   55: astore_0
    //   56: aload_0
    //   57: ifnull +14 -> 71
    //   60: aload_0
    //   61: invokevirtual 35	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   64: ifne +7 -> 71
    //   67: aconst_null
    //   68: putstatic 29	com/tencent/mobileqq/gamecenter/utils/CommUtils:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   71: return
    //   72: astore_0
    //   73: getstatic 29	com/tencent/mobileqq/gamecenter/utils/CommUtils:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +14 -> 92
    //   81: aload_1
    //   82: invokevirtual 35	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   85: ifne +7 -> 92
    //   88: aconst_null
    //   89: putstatic 29	com/tencent/mobileqq/gamecenter/utils/CommUtils:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   92: aload_0
    //   93: athrow
    //   94: getstatic 29	com/tencent/mobileqq/gamecenter/utils/CommUtils:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull +14 -> 113
    //   102: aload_0
    //   103: invokevirtual 35	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   106: ifne +7 -> 113
    //   109: aconst_null
    //   110: putstatic 29	com/tencent/mobileqq/gamecenter/utils/CommUtils:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   113: return
    //   114: astore_0
    //   115: goto -21 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramActivity	android.app.Activity
    //   76	6	1	localQQProgressDialog	QQProgressDialog
    // Exception table:
    //   from	to	target	type
    //   12	46	72	finally
    //   46	52	72	finally
    //   12	46	114	java/lang/Exception
    //   46	52	114	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.CommUtils
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.mini.utils;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;

public class StatusBarUtil
{
  public static boolean FlymeSetStatusBarLightMode(Window paramWindow, boolean paramBoolean)
  {
    if (paramWindow != null) {
      try
      {
        WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
        Field localField1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
        Field localField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
        localField1.setAccessible(true);
        localField2.setAccessible(true);
        int i = localField1.getInt(null);
        int j = localField2.getInt(localLayoutParams);
        if (paramBoolean) {
          i |= j;
        }
        for (;;)
        {
          localField2.setInt(localLayoutParams, i);
          paramWindow.setAttributes(localLayoutParams);
          return true;
          i = (i ^ 0xFFFFFFFF) & j;
        }
        return false;
      }
      catch (Exception paramWindow)
      {
        return false;
      }
    }
  }
  
  /* Error */
  public static boolean MIUISetStatusBarLightMode(Activity paramActivity, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 57	android/app/Activity:getWindow	()Landroid/view/Window;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +146 -> 152
    //   9: aload_3
    //   10: invokevirtual 61	java/lang/Object:getClass	()Ljava/lang/Class;
    //   13: astore 4
    //   15: ldc 63
    //   17: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   20: astore 5
    //   22: aload 5
    //   24: ldc 69
    //   26: invokevirtual 72	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   29: aload 5
    //   31: invokevirtual 41	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   34: istore_2
    //   35: aload 4
    //   37: ldc 74
    //   39: iconst_2
    //   40: anewarray 25	java/lang/Class
    //   43: dup
    //   44: iconst_0
    //   45: getstatic 80	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: getstatic 80	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   54: aastore
    //   55: invokevirtual 84	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   58: astore 4
    //   60: iload_1
    //   61: ifeq +44 -> 105
    //   64: aload 4
    //   66: aload_3
    //   67: iconst_2
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: iload_2
    //   74: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: iload_2
    //   81: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aastore
    //   85: invokevirtual 94	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: getstatic 100	android/os/Build$VERSION:SDK_INT	I
    //   92: istore_2
    //   93: iload_2
    //   94: bipush 23
    //   96: if_icmplt +7 -> 103
    //   99: iload_1
    //   100: ifeq +36 -> 136
    //   103: iconst_1
    //   104: ireturn
    //   105: aload 4
    //   107: aload_3
    //   108: iconst_2
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: iconst_0
    //   115: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: iload_2
    //   122: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: aastore
    //   126: invokevirtual 94	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   129: pop
    //   130: goto -41 -> 89
    //   133: astore_0
    //   134: iconst_0
    //   135: ireturn
    //   136: aload_0
    //   137: invokevirtual 57	android/app/Activity:getWindow	()Landroid/view/Window;
    //   140: invokevirtual 104	android/view/Window:getDecorView	()Landroid/view/View;
    //   143: iconst_0
    //   144: invokevirtual 110	android/view/View:setSystemUiVisibility	(I)V
    //   147: iconst_1
    //   148: ireturn
    //   149: astore_0
    //   150: iconst_1
    //   151: ireturn
    //   152: iconst_0
    //   153: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramActivity	Activity
    //   0	154	1	paramBoolean	boolean
    //   34	88	2	i	int
    //   4	104	3	localWindow	Window
    //   13	93	4	localObject	Object
    //   20	10	5	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   15	60	133	java/lang/Exception
    //   64	89	133	java/lang/Exception
    //   105	130	133	java/lang/Exception
    //   89	93	149	java/lang/Exception
    //   136	147	149	java/lang/Exception
  }
  
  public static int StatusBarDarkMode(Activity paramActivity)
  {
    int j = 0;
    int i = j;
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (!MIUISetStatusBarLightMode(paramActivity, false)) {
        break label24;
      }
      i = 1;
    }
    label24:
    do
    {
      return i;
      if (FlymeSetStatusBarLightMode(paramActivity.getWindow(), false)) {
        return 2;
      }
      i = j;
    } while (Build.VERSION.SDK_INT < 23);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.StatusBarUtil
 * JD-Core Version:    0.7.0.1
 */
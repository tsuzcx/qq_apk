package com.tencent.mobileqq.listentogether.lyrics;

import aekt;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import atjk;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class FloatBaseLayout
  extends FrameLayout
{
  float jdField_a_of_type_Float;
  public int a;
  WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  atjk jdField_a_of_type_Atjk;
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float;
  public int b;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean = false;
  float d;
  float e = 6.0F;
  
  public FloatBaseLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.e = aekt.a(3.0F, getResources());
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getContext().getSystemService("window"));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = -3;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 808;
    if (Build.VERSION.SDK_INT >= 26) {}
    for (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2038;; this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 2002)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.systemUiVisibility = 5892;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 85;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.setTitle("FloatBaseLayout");
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = 0;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = 0;
      e();
      return;
    }
  }
  
  private void e()
  {
    try
    {
      int i = ((Integer)this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").get(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams)).intValue();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.getClass().getField("privateFlags").set(this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams, Integer.valueOf(i | 0x40));
      return;
    }
    catch (Exception localException) {}
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x + this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width / 2;
  }
  
  public WindowManager.LayoutParams a()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FloatBaseLayout", 1, "showOrUpdate updateViewLayout error: " + localThrowable.getMessage());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x) || (paramInt2 != this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y))
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = paramInt1;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = paramInt2;
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +31 -> 36
    //   8: ldc 90
    //   10: iconst_2
    //   11: new 150	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   18: ldc 176
    //   20: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 22	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:jdField_a_of_type_Boolean	Z
    //   27: invokevirtual 179	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 181	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 22	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:jdField_a_of_type_Boolean	Z
    //   42: ifne +103 -> 145
    //   45: aload_0
    //   46: getfield 24	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:jdField_c_of_type_Int	I
    //   49: istore_1
    //   50: iload_3
    //   51: istore_2
    //   52: iload_1
    //   53: iconst_4
    //   54: if_icmpge +29 -> 83
    //   57: aload_0
    //   58: getfield 61	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:jdField_a_of_type_AndroidViewWindowManager	Landroid/view/WindowManager;
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 68	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   66: invokeinterface 184 3 0
    //   71: aload_0
    //   72: iconst_1
    //   73: putfield 22	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:jdField_a_of_type_Boolean	Z
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 24	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:jdField_c_of_type_Int	I
    //   81: iload_3
    //   82: istore_2
    //   83: aload_0
    //   84: monitorexit
    //   85: iload_2
    //   86: ireturn
    //   87: astore 5
    //   89: aload_0
    //   90: aload_0
    //   91: getfield 24	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:jdField_c_of_type_Int	I
    //   94: iconst_1
    //   95: iadd
    //   96: putfield 24	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:jdField_c_of_type_Int	I
    //   99: ldc 90
    //   101: iconst_1
    //   102: new 150	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   109: ldc 186
    //   111: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_0
    //   115: getfield 24	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:jdField_c_of_type_Int	I
    //   118: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: ldc 191
    //   123: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 5
    //   128: invokevirtual 161	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   131: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: iconst_0
    //   141: istore_2
    //   142: goto -59 -> 83
    //   145: aload_0
    //   146: getfield 22	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:jdField_a_of_type_Boolean	Z
    //   149: istore 4
    //   151: iload_3
    //   152: istore_2
    //   153: iload 4
    //   155: ifeq -72 -> 83
    //   158: aload_0
    //   159: getfield 61	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:jdField_a_of_type_AndroidViewWindowManager	Landroid/view/WindowManager;
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 68	com/tencent/mobileqq/listentogether/lyrics/FloatBaseLayout:jdField_a_of_type_AndroidViewWindowManager$LayoutParams	Landroid/view/WindowManager$LayoutParams;
    //   167: invokeinterface 148 3 0
    //   172: iload_3
    //   173: istore_2
    //   174: goto -91 -> 83
    //   177: astore 5
    //   179: ldc 90
    //   181: iconst_1
    //   182: new 150	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   189: ldc 153
    //   191: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 5
    //   196: invokevirtual 161	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   199: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: iconst_0
    //   209: istore_2
    //   210: goto -127 -> 83
    //   213: astore 5
    //   215: aload_0
    //   216: monitorexit
    //   217: aload 5
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	FloatBaseLayout
    //   49	6	1	i	int
    //   51	159	2	bool1	boolean
    //   1	172	3	bool2	boolean
    //   149	5	4	bool3	boolean
    //   87	40	5	localThrowable1	Throwable
    //   177	18	5	localThrowable2	Throwable
    //   213	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   57	81	87	java/lang/Throwable
    //   158	172	177	java/lang/Throwable
    //   38	50	213	finally
    //   57	81	213	finally
    //   83	85	213	finally
    //   89	140	213	finally
    //   145	151	213	finally
    //   158	172	213	finally
    //   179	208	213	finally
    //   215	217	213	finally
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x + this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Atjk = null;
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    boolean bool1;
    try
    {
      boolean bool3 = this.jdField_a_of_type_Boolean;
      bool1 = bool2;
      if (bool3) {}
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this);
        this.jdField_a_of_type_Boolean = false;
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("FloatBaseLayout", 1, "showOrUpdate addView error: " + localThrowable.getMessage());
          bool1 = false;
        }
      }
      this.jdField_c_of_type_Int = 0;
      return bool1;
    }
    finally {}
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x;
  }
  
  protected void c() {}
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void d() {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
    case 0: 
    case 2: 
      for (;;)
      {
        this.jdField_a_of_type_Float = f1;
        this.jdField_b_of_type_Float = f2;
        return bool1;
        this.jdField_c_of_type_Float = f1;
        this.d = f2;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = true;
        bool1 = super.dispatchTouchEvent(paramMotionEvent);
        continue;
        if ((Math.abs(f1 - this.jdField_c_of_type_Float) > this.e) && (Math.abs(f2 - this.d) > this.e) && (this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_b_of_type_Boolean = true;
          c();
        }
        if ((this.jdField_a_of_type_Atjk != null) && (this.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_Atjk.a((int)(f1 - this.jdField_a_of_type_Float), (int)(f2 - this.jdField_b_of_type_Float));
        }
        if (!this.jdField_b_of_type_Boolean) {
          bool1 = super.dispatchTouchEvent(paramMotionEvent);
        }
      }
    }
    if ((this.jdField_a_of_type_Atjk != null) && (this.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_Atjk.a();
    }
    if (this.jdField_b_of_type_Boolean) {
      d();
    }
    for (bool1 = bool2;; bool1 = super.dispatchTouchEvent(paramMotionEvent))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      break;
    }
  }
  
  public int e()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int f()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x;
  }
  
  public int g()
  {
    return this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y;
  }
  
  public void setFloatLayoutCallback(atjk paramatjk)
  {
    this.jdField_a_of_type_Atjk = paramatjk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatBaseLayout
 * JD-Core Version:    0.7.0.1
 */
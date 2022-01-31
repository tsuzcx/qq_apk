package com.tencent.mqq.shared_file_accessor.a;

import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a
{
  private static final String a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/sp";
  private static volatile a b = null;
  private StringBuilder c = new StringBuilder(32768);
  private HandlerThread d = null;
  private Handler e = null;
  private String f = null;
  private FileWriter g = null;
  
  private a()
  {
    this.d.start();
    this.e = new b(this, this.d.getLooper());
    Object localObject = new Date();
    localObject = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format((Date)localObject);
    this.f = ("sp_rw_" + (String)localObject);
    try
    {
      localObject = new File(a);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      this.g = new FileWriter(a + "/" + this.f + ".csv");
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static a a()
  {
    if (b != null) {
      return b;
    }
    try
    {
      if (b == null) {
        b = new a();
      }
      a locala = b;
      return locala;
    }
    finally {}
  }
  
  /* Error */
  public final void a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: arraylength
    //   6: istore_3
    //   7: iload_2
    //   8: iload_3
    //   9: iconst_1
    //   10: isub
    //   11: if_icmpge +26 -> 37
    //   14: aload_0
    //   15: getfield 59	com/tencent/mqq/shared_file_accessor/a/a:c	Ljava/lang/StringBuilder;
    //   18: aload_1
    //   19: iload_2
    //   20: aaload
    //   21: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: bipush 9
    //   26: invokevirtual 129	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: iload_2
    //   31: iconst_1
    //   32: iadd
    //   33: istore_2
    //   34: goto -27 -> 7
    //   37: aload_0
    //   38: getfield 59	com/tencent/mqq/shared_file_accessor/a/a:c	Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: aload_1
    //   43: arraylength
    //   44: iconst_1
    //   45: isub
    //   46: aaload
    //   47: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: bipush 10
    //   52: invokevirtual 129	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_0
    //   57: getfield 59	com/tencent/mqq/shared_file_accessor/a/a:c	Ljava/lang/StringBuilder;
    //   60: invokevirtual 133	java/lang/StringBuilder:length	()I
    //   63: ldc 54
    //   65: if_icmple +58 -> 123
    //   68: aload_0
    //   69: getfield 59	com/tencent/mqq/shared_file_accessor/a/a:c	Ljava/lang/StringBuilder;
    //   72: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore_1
    //   76: aload_0
    //   77: getfield 63	com/tencent/mqq/shared_file_accessor/a/a:e	Landroid/os/Handler;
    //   80: iconst_1
    //   81: invokevirtual 139	android/os/Handler:hasMessages	(I)Z
    //   84: ifeq +11 -> 95
    //   87: aload_0
    //   88: getfield 63	com/tencent/mqq/shared_file_accessor/a/a:e	Landroid/os/Handler;
    //   91: iconst_1
    //   92: invokevirtual 142	android/os/Handler:removeMessages	(I)V
    //   95: aload_0
    //   96: getfield 63	com/tencent/mqq/shared_file_accessor/a/a:e	Landroid/os/Handler;
    //   99: aload_0
    //   100: getfield 63	com/tencent/mqq/shared_file_accessor/a/a:e	Landroid/os/Handler;
    //   103: iconst_0
    //   104: aload_1
    //   105: invokestatic 148	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   108: invokevirtual 152	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   111: pop
    //   112: aload_0
    //   113: getfield 59	com/tencent/mqq/shared_file_accessor/a/a:c	Ljava/lang/StringBuilder;
    //   116: iconst_0
    //   117: invokevirtual 155	java/lang/StringBuilder:setLength	(I)V
    //   120: aload_0
    //   121: monitorexit
    //   122: return
    //   123: aload_0
    //   124: getfield 63	com/tencent/mqq/shared_file_accessor/a/a:e	Landroid/os/Handler;
    //   127: iconst_1
    //   128: invokevirtual 139	android/os/Handler:hasMessages	(I)Z
    //   131: ifne -11 -> 120
    //   134: aload_0
    //   135: getfield 63	com/tencent/mqq/shared_file_accessor/a/a:e	Landroid/os/Handler;
    //   138: iconst_1
    //   139: ldc2_w 156
    //   142: invokevirtual 161	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   145: pop
    //   146: goto -26 -> 120
    //   149: astore_1
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	a
    //   0	154	1	paramArrayOfString	String[]
    //   1	33	2	i	int
    //   6	5	3	j	int
    // Exception table:
    //   from	to	target	type
    //   4	7	149	finally
    //   14	30	149	finally
    //   37	95	149	finally
    //   95	120	149	finally
    //   123	146	149	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.a.a
 * JD-Core Version:    0.7.0.1
 */
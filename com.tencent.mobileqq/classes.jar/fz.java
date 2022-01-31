import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.Vas.ColorFont.FreeTypeLib;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontManagerForTool.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResultCallback;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class fz
  extends Observable
{
  private static fz jdField_a_of_type_Fz;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public HandlerThread a;
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine;
  private EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new ga(this);
  private ConcurrentHashMap<Integer, fu> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private ETEngine jdField_b_of_type_ComEtrumpMixlayoutETEngine;
  private EIPCResultCallback jdField_b_of_type_EipcEIPCResultCallback = new gb(this);
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicBoolean c = new AtomicBoolean(false);
  private AtomicBoolean d = new AtomicBoolean(false);
  
  private fz()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("VasFont", 0);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
  }
  
  public static fz a()
  {
    try
    {
      if (jdField_a_of_type_Fz == null) {
        jdField_a_of_type_Fz = new fz();
      }
      fz localfz = jdField_a_of_type_Fz;
      return localfz;
    }
    finally {}
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    String str3 = "";
    String str4 = "";
    String str1 = str4;
    String str2 = str3;
    switch (paramInt)
    {
    default: 
      str2 = str3;
      str1 = str4;
    case 2: 
    case 3: 
      switch (bajo.a(bajo.a(), str2))
      {
      }
      break;
    }
    do
    {
      return false;
      str2 = "libvipfont808.so";
      str1 = gf.a;
      break;
      str2 = "libFounderColorFont_818.so";
      str1 = gf.b;
      break;
    } while (!paramBoolean);
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", str1, null, this.jdField_b_of_type_EipcEIPCResultCallback);
    return false;
    return true;
  }
  
  /* Error */
  private boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_0
    //   8: iconst_1
    //   9: iload_1
    //   10: invokespecial 132	fz:a	(IZ)Z
    //   13: ifeq +77 -> 90
    //   16: aload_0
    //   17: invokestatic 137	com/etrump/mixlayout/ETEngine:getInstance	()Lcom/etrump/mixlayout/ETEngine;
    //   20: putfield 139	fz:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   23: aload_0
    //   24: invokestatic 142	com/etrump/mixlayout/ETEngine:getInstanceForAnimation	()Lcom/etrump/mixlayout/ETEngine;
    //   27: putfield 144	fz:jdField_b_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   30: getstatic 147	com/etrump/mixlayout/ETEngine:isSOLoaded	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   33: iconst_1
    //   34: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   37: iload 4
    //   39: istore_2
    //   40: aload_0
    //   41: getfield 139	fz:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   44: iconst_5
    //   45: ldc 151
    //   47: invokevirtual 155	com/etrump/mixlayout/ETEngine:initEngine	(II)Z
    //   50: istore 4
    //   52: iload_3
    //   53: istore_1
    //   54: iload 4
    //   56: ifeq +22 -> 78
    //   59: aload_0
    //   60: getfield 144	fz:jdField_b_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   63: iconst_3
    //   64: ldc 156
    //   66: invokevirtual 155	com/etrump/mixlayout/ETEngine:initEngine	(II)Z
    //   69: istore_2
    //   70: iload_3
    //   71: istore_1
    //   72: iload_2
    //   73: ifeq +5 -> 78
    //   76: iconst_1
    //   77: istore_1
    //   78: iload_1
    //   79: istore_2
    //   80: aload_0
    //   81: getfield 27	fz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   84: iload_1
    //   85: invokevirtual 150	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   88: iload_1
    //   89: istore_2
    //   90: iload_2
    //   91: ireturn
    //   92: astore 5
    //   94: ldc 158
    //   96: iconst_1
    //   97: ldc 160
    //   99: aload 5
    //   101: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   104: iload_2
    //   105: ireturn
    //   106: astore 5
    //   108: iload 4
    //   110: istore_2
    //   111: goto -17 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	fz
    //   0	114	1	paramBoolean	boolean
    //   1	110	2	bool1	boolean
    //   6	65	3	bool2	boolean
    //   3	106	4	bool3	boolean
    //   92	8	5	localException1	java.lang.Exception
    //   106	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   40	52	92	java/lang/Exception
    //   80	88	92	java/lang/Exception
    //   59	70	106	java/lang/Exception
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = a(4, paramBoolean1);
    if (paramBoolean1)
    {
      g.a().a().a();
      this.c.set(true);
      if (paramBoolean2)
      {
        setChanged();
        notifyObservers(Integer.valueOf(1));
      }
    }
    return paramBoolean1;
  }
  
  private boolean b(boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new FontManagerForTool.3(this, paramBoolean));
      return false;
    }
    return a(paramBoolean, false);
  }
  
  public fu a(int paramInt1, int paramInt2)
  {
    int i = 1;
    fu localfu = (fu)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
    boolean bool;
    if (localfu == null)
    {
      bool = fv.a(paramInt1, paramInt2);
      localObject = fv.a(paramInt1, paramInt2);
      if (!bool)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("id", paramInt1);
        localBundle.putInt("font_type", paramInt2);
        QIPCClientHelper.getInstance().callServer("VasFontIPCModule", gf.c, localBundle, this.jdField_a_of_type_EipcEIPCResultCallback);
      }
      switch (paramInt2)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return localfu;
          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
            a(true);
          }
        } while ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!bool));
        if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont((String)localObject, paramInt1, false)) && (this.jdField_b_of_type_ComEtrumpMixlayoutETEngine.native_loadFont((String)localObject, paramInt1, false))) {}
        while (i != 0)
        {
          localObject = new fu(paramInt1, paramInt2, (String)localObject);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), localObject);
          return localObject;
          i = 0;
        }
      } while (!bool);
      localfu = new fu(paramInt1, paramInt2, (String)localObject);
      localfu.a = Typeface.createFromFile((String)localObject);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), localfu);
      return localfu;
      if (this.d.compareAndSet(false, true)) {
        b(true);
      }
    } while ((!this.c.get()) || (!bool));
    g.a().a(paramInt1, (String)localObject);
    Object localObject = new fu(paramInt1, 4, (String)localObject);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     fz
 * JD-Core Version:    0.7.0.1
 */
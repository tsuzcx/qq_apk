import android.view.SurfaceHolder;
import com.tencent.av.doodle.MySurfaceView;
import com.tencent.qphone.base.util.QLog;

public class jif
  extends Thread
{
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  public jif(MySurfaceView paramMySurfaceView)
  {
    this.jdField_a_of_type_AndroidViewSurfaceHolder = paramMySurfaceView.getHolder();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("MySurfaceView", 2, "WL_DEBUG MySurfaceViewThread.setRunning running = " + paramBoolean);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	jif:jdField_a_of_type_ComTencentAvDoodleMySurfaceView	Lcom/tencent/av/doodle/MySurfaceView;
    //   4: iconst_1
    //   5: invokevirtual 64	com/tencent/av/doodle/MySurfaceView:a	(Z)V
    //   8: aload_0
    //   9: getfield 30	jif:jdField_a_of_type_Boolean	Z
    //   12: ifeq +313 -> 325
    //   15: aload_0
    //   16: getfield 26	jif:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   19: aconst_null
    //   20: invokeinterface 70 2 0
    //   25: astore 6
    //   27: aload 6
    //   29: astore 5
    //   31: aload_0
    //   32: getfield 26	jif:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   35: astore 7
    //   37: aload 6
    //   39: astore 5
    //   41: aload 7
    //   43: monitorenter
    //   44: aload_0
    //   45: getfield 18	jif:b	Z
    //   48: ifeq +33 -> 81
    //   51: invokestatic 76	android/os/SystemClock:elapsedRealtime	()J
    //   54: lstore_1
    //   55: aload_0
    //   56: getfield 13	jif:jdField_a_of_type_ComTencentAvDoodleMySurfaceView	Lcom/tencent/av/doodle/MySurfaceView;
    //   59: getfield 79	com/tencent/av/doodle/MySurfaceView:a	J
    //   62: lstore_3
    //   63: aload_0
    //   64: getfield 13	jif:jdField_a_of_type_ComTencentAvDoodleMySurfaceView	Lcom/tencent/av/doodle/MySurfaceView;
    //   67: lload_1
    //   68: putfield 79	com/tencent/av/doodle/MySurfaceView:a	J
    //   71: aload_0
    //   72: getfield 13	jif:jdField_a_of_type_ComTencentAvDoodleMySurfaceView	Lcom/tencent/av/doodle/MySurfaceView;
    //   75: lload_1
    //   76: lload_3
    //   77: lsub
    //   78: invokevirtual 82	com/tencent/av/doodle/MySurfaceView:a	(J)V
    //   81: aload 6
    //   83: ifnull +12 -> 95
    //   86: aload_0
    //   87: getfield 13	jif:jdField_a_of_type_ComTencentAvDoodleMySurfaceView	Lcom/tencent/av/doodle/MySurfaceView;
    //   90: aload 6
    //   92: invokevirtual 85	com/tencent/av/doodle/MySurfaceView:a	(Landroid/graphics/Canvas;)V
    //   95: aload 7
    //   97: monitorexit
    //   98: aload 6
    //   100: ifnull -92 -> 8
    //   103: aload_0
    //   104: getfield 26	jif:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   107: aload 6
    //   109: invokeinterface 88 2 0
    //   114: goto -106 -> 8
    //   117: astore 5
    //   119: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq -114 -> 8
    //   125: ldc 39
    //   127: iconst_2
    //   128: new 41	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   135: ldc 90
    //   137: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 5
    //   142: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: goto -143 -> 8
    //   154: astore 8
    //   156: aload 7
    //   158: monitorexit
    //   159: aload 6
    //   161: astore 5
    //   163: aload 8
    //   165: athrow
    //   166: astore 7
    //   168: aload 6
    //   170: astore 5
    //   172: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +33 -> 208
    //   178: aload 6
    //   180: astore 5
    //   182: ldc 39
    //   184: iconst_2
    //   185: new 41	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   192: ldc 90
    //   194: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 7
    //   199: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload 6
    //   210: ifnull -202 -> 8
    //   213: aload_0
    //   214: getfield 26	jif:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   217: aload 6
    //   219: invokeinterface 88 2 0
    //   224: goto -216 -> 8
    //   227: astore 5
    //   229: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq -224 -> 8
    //   235: ldc 39
    //   237: iconst_2
    //   238: new 41	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   245: ldc 90
    //   247: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 5
    //   252: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: goto -253 -> 8
    //   264: astore 6
    //   266: aconst_null
    //   267: astore 5
    //   269: aload 5
    //   271: ifnull +14 -> 285
    //   274: aload_0
    //   275: getfield 26	jif:jdField_a_of_type_AndroidViewSurfaceHolder	Landroid/view/SurfaceHolder;
    //   278: aload 5
    //   280: invokeinterface 88 2 0
    //   285: aload 6
    //   287: athrow
    //   288: astore 5
    //   290: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   293: ifeq -8 -> 285
    //   296: ldc 39
    //   298: iconst_2
    //   299: new 41	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   306: ldc 90
    //   308: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload 5
    //   313: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: goto -37 -> 285
    //   325: aload_0
    //   326: getfield 13	jif:jdField_a_of_type_ComTencentAvDoodleMySurfaceView	Lcom/tencent/av/doodle/MySurfaceView;
    //   329: iconst_0
    //   330: invokevirtual 64	com/tencent/av/doodle/MySurfaceView:a	(Z)V
    //   333: return
    //   334: astore 6
    //   336: goto -67 -> 269
    //   339: astore 7
    //   341: aconst_null
    //   342: astore 6
    //   344: goto -176 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	jif
    //   54	22	1	l1	long
    //   62	15	3	l2	long
    //   29	11	5	localCanvas1	android.graphics.Canvas
    //   117	24	5	localException1	java.lang.Exception
    //   161	20	5	localCanvas2	android.graphics.Canvas
    //   227	24	5	localException2	java.lang.Exception
    //   267	12	5	localCanvas3	android.graphics.Canvas
    //   288	24	5	localException3	java.lang.Exception
    //   25	193	6	localCanvas4	android.graphics.Canvas
    //   264	22	6	localObject1	java.lang.Object
    //   334	1	6	localObject2	java.lang.Object
    //   342	1	6	localObject3	java.lang.Object
    //   35	122	7	localSurfaceHolder	SurfaceHolder
    //   166	32	7	localException4	java.lang.Exception
    //   339	1	7	localException5	java.lang.Exception
    //   154	10	8	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   103	114	117	java/lang/Exception
    //   44	81	154	finally
    //   86	95	154	finally
    //   95	98	154	finally
    //   156	159	154	finally
    //   31	37	166	java/lang/Exception
    //   41	44	166	java/lang/Exception
    //   163	166	166	java/lang/Exception
    //   213	224	227	java/lang/Exception
    //   15	27	264	finally
    //   274	285	288	java/lang/Exception
    //   31	37	334	finally
    //   41	44	334	finally
    //   163	166	334	finally
    //   172	178	334	finally
    //   182	208	334	finally
    //   15	27	339	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jif
 * JD-Core Version:    0.7.0.1
 */
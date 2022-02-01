import android.os.Environment;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.gaudio.QQGAudioCtrl;
import java.io.File;
import java.util.Calendar;

public class mrt
  implements mow
{
  private static volatile mrt jdField_a_of_type_Mrt;
  private int jdField_a_of_type_Int = 0;
  private VcControllerImpl jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
  private QQGAudioCtrl jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int c;
  
  public mrt()
  {
    c();
  }
  
  public static mrt a()
  {
    if (jdField_a_of_type_Mrt == null) {}
    try
    {
      if (jdField_a_of_type_Mrt == null) {
        jdField_a_of_type_Mrt = new mrt();
      }
      return jdField_a_of_type_Mrt;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Mrt != null) {
      try
      {
        if (jdField_a_of_type_Mrt != null) {
          jdField_a_of_type_Mrt.b();
        }
        jdField_a_of_type_Mrt = null;
        bjuc.c("AudioDump", "destroyInstance.", new Throwable("打印调用栈"));
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  private static void a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifgt +4 -> 5
    //   4: return
    //   5: new 64	java/io/DataOutputStream
    //   8: dup
    //   9: new 66	java/io/FileOutputStream
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 67	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 70	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: aload_3
    //   24: aload_0
    //   25: iconst_0
    //   26: iload_1
    //   27: invokevirtual 74	java/io/DataOutputStream:write	([BII)V
    //   30: aload_3
    //   31: astore_2
    //   32: ldc 43
    //   34: ldc 76
    //   36: invokestatic 80	bjuc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_3
    //   40: ifnull -36 -> 4
    //   43: aload_3
    //   44: invokevirtual 83	java/io/DataOutputStream:close	()V
    //   47: return
    //   48: astore_0
    //   49: return
    //   50: astore 4
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: astore_2
    //   56: ldc 43
    //   58: ldc 85
    //   60: aload 4
    //   62: invokestatic 87	bjuc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   65: aload_0
    //   66: ifnull -62 -> 4
    //   69: aload_0
    //   70: invokevirtual 83	java/io/DataOutputStream:close	()V
    //   73: return
    //   74: astore_0
    //   75: return
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_2
    //   79: aload_2
    //   80: ifnull +7 -> 87
    //   83: aload_2
    //   84: invokevirtual 83	java/io/DataOutputStream:close	()V
    //   87: aload_0
    //   88: athrow
    //   89: astore_2
    //   90: goto -3 -> 87
    //   93: astore_0
    //   94: goto -15 -> 79
    //   97: astore 4
    //   99: aload_3
    //   100: astore_0
    //   101: goto -47 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramArrayOfByte	byte[]
    //   0	104	1	paramInt	int
    //   0	104	2	paramString	String
    //   20	80	3	localDataOutputStream	java.io.DataOutputStream
    //   50	11	4	localException1	Exception
    //   97	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   43	47	48	java/io/IOException
    //   5	21	50	java/lang/Exception
    //   69	73	74	java/io/IOException
    //   5	21	76	finally
    //   83	87	89	java/io/IOException
    //   23	30	93	finally
    //   32	39	93	finally
    //   56	65	93	finally
    //   23	30	97	java/lang/Exception
    //   32	39	97	java/lang/Exception
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private static boolean a(int paramInt)
  {
    return false;
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    int i = -1;
    boolean bool = true;
    int j;
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      j = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.registerAudioDataCallback(paramInt, paramBoolean);
      i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.setAudioDataFormat(paramInt, 16000, 1, 16);
    }
    for (;;)
    {
      if (j == 0)
      {
        paramBoolean = bool;
        if (i == 0) {}
      }
      else
      {
        bjuc.a("AudioDump", "registerAudioDataCallback failed. srcType = " + paramInt + ", ret1 = " + j + ", ret2 = " + i);
        paramBoolean = false;
      }
      return paramBoolean;
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
      {
        j = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.registerAudioDataCallback(paramInt, paramBoolean);
        i = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAudioDataFormat(paramInt, 16000, 1, 16);
      }
      else
      {
        j = -1;
      }
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.enableDumpAudioData(paramBoolean);
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.enableDumpAudioData(paramBoolean);
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.unregisterAudioDataCallback(paramInt);
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.unregisterAudioDataCallback(paramInt);
      }
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.jdField_a_of_type_Boolean = true;
    bjuc.d("AudioDump", "init successfully.");
    return true;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != 1)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramInt1 == 0) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ArrayOfByte != null)
        {
          System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_Int, paramInt2);
          this.jdField_b_of_type_Int += paramInt2;
        }
        return;
      }
      finally {}
      if ((paramInt1 == 2) && (this.jdField_b_of_type_ArrayOfByte != null))
      {
        System.arraycopy(paramArrayOfByte, 0, this.jdField_b_of_type_ArrayOfByte, this.c, paramInt2);
        this.c += paramInt2;
      }
    }
  }
  
  public boolean a(VcControllerImpl arg1, QQGAudioCtrl paramQQGAudioCtrl)
  {
    if (!this.jdField_a_of_type_Boolean) {
      bjuc.a("AudioDump", "startSave failed. !mIsInited.");
    }
    for (;;)
    {
      return false;
      if (b()) {
        return true;
      }
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = ???;
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = paramQQGAudioCtrl;
      if (a(35))
      {
        a(true);
        a(0, false);
        a(2, false);
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        for (;;)
        {
          this.jdField_a_of_type_ArrayOfByte = new byte[52428800];
          this.jdField_b_of_type_ArrayOfByte = new byte[52428800];
          this.jdField_b_of_type_Int = 0;
          this.c = 0;
          paramQQGAudioCtrl = Calendar.getInstance();
          int i = paramQQGAudioCtrl.get(1);
          int j = paramQQGAudioCtrl.get(2) + 1;
          int k = paramQQGAudioCtrl.get(5);
          int m = paramQQGAudioCtrl.get(11);
          int n = paramQQGAudioCtrl.get(12);
          int i1 = paramQQGAudioCtrl.get(13);
          this.jdField_a_of_type_JavaLangString = (Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + String.format("trae-dump-%04d-%02d-%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }) + File.separator + String.format("%04d-%02d-%02d-%02d-%02d-%02d-%s-%d_%d.pcm", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), "after3A", Integer.valueOf(16000), Integer.valueOf(1) }));
          this.jdField_b_of_type_JavaLangString = (Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + String.format("trae-dump-%04d-%02d-%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }) + File.separator + String.format("%04d-%02d-%02d-%02d-%02d-%02d-%s-%d_%d.pcm", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), "afterVAD", Integer.valueOf(16000), Integer.valueOf(1) }));
          this.jdField_a_of_type_Int = 1;
          bjuc.d("AudioDump", "startSave successfully. ");
          return true;
          if (a(36))
          {
            a(true);
          }
          else
          {
            if (!a(37)) {
              break;
            }
            a(0, false);
          }
        }
        if (!a(38)) {
          continue;
        }
        a(2, false);
      }
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    c();
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = null;
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl = null;
    this.jdField_a_of_type_Boolean = false;
    bjuc.d("AudioDump", "uninit successfully.");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int != 0;
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (!b()) {
      return;
    }
    this.jdField_a_of_type_Int = 0;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      a(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
      a(this.jdField_b_of_type_ArrayOfByte, this.c, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ArrayOfByte = null;
      this.jdField_b_of_type_ArrayOfByte = null;
      this.jdField_b_of_type_Int = 0;
      this.c = 0;
      try
      {
        a(false);
        b(0);
        b(2);
        bjuc.d("AudioDump", "stopSave sucessfully.");
        return;
      }
      catch (Exception localException)
      {
        bjuc.a("AudioDump", "stopSave failed.", localException);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mrt
 * JD-Core Version:    0.7.0.1
 */
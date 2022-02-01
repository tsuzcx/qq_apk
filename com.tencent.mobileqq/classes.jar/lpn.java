import android.annotation.TargetApi;
import android.opengl.GLES20;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class lpn
{
  private static final String jdField_a_of_type_JavaLangString = AppConstants.SDCARD_ROOT + "/avdebug/";
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(500);
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "10.AV_SRC", "20.AV_PRE_RENDER", "30.AV_FILTER_NEW", "40.AV_FILTER", "50.AV_POST_RENDER", "60.AV_RETURN", "appleVideoDenoise", "appleLowLightEnhance", "applyBeauty30", "mInputTextureFbo", "applyBeauty20", "mirrorTextureIn", "mirrorTextureOut" };
  private static boolean jdField_b_of_type_Boolean;
  private int jdField_a_of_type_Int;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private lpo[] jdField_a_of_type_ArrayOfLpo;
  private String jdField_b_of_type_JavaLangString;
  private boolean c;
  
  static String a(int paramInt)
  {
    if (paramInt < jdField_a_of_type_ArrayOfJavaLangString.length) {
      return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    return "unknown";
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "UnKnown";
    switch (paramInt3)
    {
    }
    for (;;)
    {
      return "[w" + paramInt1 + "h" + paramInt2 + "f" + str + "]";
      str = "RGB32";
      continue;
      str = "NV21";
      continue;
      str = "YUV420";
      continue;
      str = "NV16";
    }
  }
  
  private lpo a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ArrayOfLpo != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfLpo.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfLpo[paramInt];
      }
    }
    return localObject1;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt2 * paramInt1 * 4;
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != paramInt1))
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramInt1];
      return;
    }
    Arrays.fill(this.jdField_a_of_type_ArrayOfByte, (byte)0);
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glFramebufferTexture2D(36160, paramInt2, 3553, paramInt1, 0);
    GLES20.glReadPixels(0, 0, paramInt3, paramInt4, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
  }
  
  /* Error */
  private static void a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 153	java/io/FileOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 156	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: aload_0
    //   25: invokestatic 142	lpn:b	(Ljava/io/FileOutputStream;[B)V
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 159	java/io/FileOutputStream:flush	()V
    //   34: aload_2
    //   35: astore_1
    //   36: aload_2
    //   37: invokevirtual 162	java/io/FileOutputStream:close	()V
    //   40: aload_2
    //   41: ifnull -30 -> 11
    //   44: aload_2
    //   45: invokevirtual 162	java/io/FileOutputStream:close	()V
    //   48: return
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   54: return
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: astore_1
    //   60: aload_3
    //   61: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   64: aload_0
    //   65: ifnull -54 -> 11
    //   68: aload_0
    //   69: invokevirtual 162	java/io/FileOutputStream:close	()V
    //   72: return
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   78: return
    //   79: astore_0
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 162	java/io/FileOutputStream:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   97: goto -7 -> 90
    //   100: astore_0
    //   101: goto -19 -> 82
    //   104: astore_3
    //   105: aload_2
    //   106: astore_0
    //   107: goto -49 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramArrayOfByte	byte[]
    //   0	110	1	paramString	String
    //   20	86	2	localFileOutputStream	FileOutputStream
    //   55	6	3	localException1	java.lang.Exception
    //   104	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   44	48	49	java/lang/Exception
    //   12	21	55	java/lang/Exception
    //   68	72	73	java/lang/Exception
    //   12	21	79	finally
    //   86	90	92	java/lang/Exception
    //   23	28	100	finally
    //   30	34	100	finally
    //   36	40	100	finally
    //   60	64	100	finally
    //   23	28	104	java/lang/Exception
    //   30	34	104	java/lang/Exception
    //   36	40	104	java/lang/Exception
  }
  
  private static void b(FileOutputStream paramFileOutputStream, byte[] paramArrayOfByte)
  {
    if ((paramFileOutputStream == null) || (paramArrayOfByte == null)) {
      return;
    }
    try
    {
      paramFileOutputStream.write(paramArrayOfByte);
      paramFileOutputStream.flush();
      return;
    }
    catch (Throwable paramFileOutputStream)
    {
      paramFileOutputStream.printStackTrace();
    }
  }
  
  private void b(lpl paramlpl, int paramInt, lox paramlox, lps paramlps)
  {
    int n = 17;
    lpo locallpo = a(paramInt);
    int k;
    int m;
    int i;
    int j;
    if (locallpo != null)
    {
      k = paramlpl.jdField_a_of_type_Int;
      m = paramlpl.b;
      if (paramInt != 0) {
        break label97;
      }
      i = m;
      j = k;
      if (paramlox == null) {
        break label525;
      }
      i = m;
      j = k;
      if (!paramlox.b()) {
        break label525;
      }
      paramlox = paramlox.jdField_a_of_type_ArrayOfByte;
      j = paramlpl.b;
      i = paramlpl.jdField_a_of_type_Int;
      paramlpl = paramlox;
      paramInt = n;
    }
    for (;;)
    {
      if (paramlpl != null) {
        locallpo.a(paramlpl, paramInt, j, i);
      }
      return;
      label97:
      if (paramInt == 5)
      {
        i = m;
        j = k;
        if (paramlox != null)
        {
          i = m;
          j = k;
          if (paramlox.b())
          {
            paramlox = paramlox.jdField_a_of_type_ArrayOfByte;
            j = paramlpl.b;
            i = paramlpl.jdField_a_of_type_Int;
            paramInt = n;
            paramlpl = paramlox;
          }
        }
      }
      else if (paramInt == 3)
      {
        i = m;
        j = k;
        if (paramlps != null)
        {
          i = m;
          j = k;
          if (paramlps.b != -1)
          {
            a(k, m);
            a(paramlps.b, 36064, k, m, this.jdField_a_of_type_ArrayOfByte);
            paramlpl = this.jdField_a_of_type_ArrayOfByte;
            paramInt = 42;
            i = m;
            j = k;
          }
        }
      }
      else if (paramInt == 2)
      {
        i = m;
        j = k;
        if (paramlps != null)
        {
          i = m;
          j = k;
          if (paramlps.b != -1)
          {
            a(k, m);
            a(paramlps.b, 36064, k, m, this.jdField_a_of_type_ArrayOfByte);
            paramlpl = this.jdField_a_of_type_ArrayOfByte;
            paramInt = 42;
            i = m;
            j = k;
          }
        }
      }
      else if (paramInt == 4)
      {
        paramInt = paramlpl.b;
        k = paramlpl.jdField_a_of_type_Int;
        i = k;
        j = paramInt;
        if (paramlpl.jdField_a_of_type_Lpw != null)
        {
          paramlox = paramlpl.jdField_a_of_type_Lpw.a();
          m = paramlpl.jdField_a_of_type_Lpw.a();
          i = k;
          j = paramInt;
          paramInt = m;
          paramlpl = paramlox;
        }
      }
      else
      {
        i = m;
        j = k;
        if (paramInt == 1)
        {
          if ((paramlps != null) && (paramlps.b != -1))
          {
            a(k, m);
            a(paramlps.b, 36064, k, m, this.jdField_a_of_type_ArrayOfByte);
            paramlpl = this.jdField_a_of_type_ArrayOfByte;
            paramInt = 42;
            i = m;
            j = k;
            continue;
          }
          i = m;
          j = k;
          if (paramlps != null)
          {
            i = m;
            j = k;
            if (paramlps.jdField_a_of_type_Int != -1)
            {
              a(k, m);
              lqj.a(paramlps.jdField_a_of_type_Int, k, m, this.jdField_a_of_type_ArrayOfByte);
              paramlpl = this.jdField_a_of_type_ArrayOfByte;
              paramInt = 42;
              i = m;
              j = k;
              continue;
            }
          }
        }
      }
      label525:
      paramInt = 0;
      paramlpl = null;
    }
  }
  
  public void a()
  {
    int j = 0;
    if (AudioHelper.a(24) == 1) {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
    }
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FilterProcessTest", 2, "startOneChat debug[" + this.jdField_a_of_type_Boolean + "]");
      }
      Object localObject1 = null;
      Object localObject2;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss/", Locale.getDefault());
        localObject2 = new Date(System.currentTimeMillis());
        localObject2 = jdField_a_of_type_JavaLangString + ((SimpleDateFormat)localObject1).format((Date)localObject2);
        File localFile = new File((String)localObject2);
        if (localFile.exists())
        {
          localObject1 = localObject2;
          if (localFile.isDirectory()) {}
        }
        else
        {
          localObject1 = localObject2;
          if (!localFile.mkdirs())
          {
            this.jdField_a_of_type_Boolean = false;
            localObject1 = localObject2;
            if (QLog.isDevelopLevel())
            {
              QLog.i("FilterProcessTest", 4, "startOneChat mkdir fail path: " + (String)localObject2);
              localObject1 = localObject2;
            }
          }
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      int i = j;
      if (this.jdField_a_of_type_ArrayOfLpo == null)
      {
        this.jdField_a_of_type_ArrayOfLpo = new lpo[6];
        i = j;
      }
      while (i < this.jdField_a_of_type_ArrayOfLpo.length)
      {
        localObject2 = (String)localObject1 + jdField_a_of_type_ArrayOfJavaLangString[i];
        if (this.jdField_a_of_type_ArrayOfLpo[i] != null) {
          this.jdField_a_of_type_ArrayOfLpo[i].a();
        }
        this.jdField_a_of_type_ArrayOfLpo[i] = new lpo((String)localObject2);
        i += 1;
      }
      break;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      b();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.c) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    int[] arrayOfInt = new int[1];
    GLES20.glBindFramebuffer(36160, paramInt2);
    GLES20.glGetFramebufferAttachmentParameteriv(36160, 36064, 36048, arrayOfInt, 0);
    GLES20.glGetFramebufferAttachmentParameteriv(36160, 36064, 36049, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, 0);
    QLog.w("FilterProcessRender", 1, "logFrameBuffer, action[" + a(paramInt1) + "], fbo[" + paramInt2 + "], textureid[" + paramInt3 + "], check[" + arrayOfInt[0] + "]");
  }
  
  @TargetApi(23)
  void a(lpl paramlpl, int paramInt, lox paramlox, lps paramlps)
  {
    int i = 0;
    if (this.jdField_a_of_type_Boolean) {
      b(paramlpl, paramInt, paramlox, paramlps);
    }
    if (!this.c) {
      return;
    }
    String str = this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Int + "_" + a(paramInt);
    int j = paramlpl.b * paramlpl.jdField_a_of_type_Int * 4;
    switch (paramInt)
    {
    default: 
      if ((paramlps != null) && (paramlps.b != -1))
      {
        paramlox = str + "_text_" + a(paramlpl.jdField_a_of_type_Int, paramlpl.b, 0) + ".jpg";
        lqe.a(paramlps.b, paramlpl.jdField_a_of_type_Int, paramlpl.b, paramlox);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int += 1;
      return;
      if ((paramlox != null) && (paramlox.b()))
      {
        paramlpl = str + "_yuvData_" + a(paramlpl.b, paramlpl.jdField_a_of_type_Int, 17) + ".yuv";
        a(paramlox.jdField_a_of_type_ArrayOfByte, paramlpl);
        continue;
        if ((paramlox != null) && (paramlox.b()))
        {
          paramlpl = str + "_beauty2D_" + a(paramlpl.b, paramlpl.jdField_a_of_type_Int, 17) + ".yuv";
          a(paramlox.jdField_a_of_type_ArrayOfByte, paramlpl);
          continue;
          if ((paramlox != null) && (paramlox.b()))
          {
            paramlpl = str + "_directReturn_" + a(paramlpl.b, paramlpl.jdField_a_of_type_Int, 17) + ".yuv";
            a(paramlox.jdField_a_of_type_ArrayOfByte, paramlpl);
            continue;
            if ((paramlps != null) && (paramlps.jdField_a_of_type_Int != -1))
            {
              if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != j)) {
                this.jdField_a_of_type_ArrayOfByte = new byte[j];
              }
              paramlox = str + "_rgbRotateCenterTextureFbo_" + paramlps.jdField_a_of_type_Int + "_" + a(paramlpl.b, paramlpl.jdField_a_of_type_Int, 42) + ".yuv";
              lqj.a(paramlps.jdField_a_of_type_Int, paramlpl.b, paramlpl.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
              a(this.jdField_a_of_type_ArrayOfByte, paramlox);
            }
            if ((paramlps != null) && (paramlps.b != -1))
            {
              paramlox = str + "_rgbRotateCenterTextureId_" + a(paramlpl.b, paramlpl.jdField_a_of_type_Int, 0) + ".jpg";
              lqe.a(paramlps.b, paramlpl.b, paramlpl.jdField_a_of_type_Int, paramlox);
            }
            paramlox = null;
            paramInt = i;
            if (paramlpl.jdField_a_of_type_Lpw != null)
            {
              paramlox = paramlpl.jdField_a_of_type_Lpw.a();
              paramInt = paramlpl.jdField_a_of_type_Lpw.a();
            }
            if ((paramlox != null) && (paramInt == 35))
            {
              a(paramlox, str + "_i420Data_" + a(paramlpl.b, paramlpl.jdField_a_of_type_Int, 17) + ".yuv");
            }
            else if ((paramlox != null) && (paramInt == 42))
            {
              a(paramlox, str + "_rgbaData_" + a(paramlpl.b, paramlpl.jdField_a_of_type_Int, 42) + ".yuv");
              continue;
              if ((paramlps != null) && (paramlps.jdField_a_of_type_Int != -1))
              {
                if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != j)) {
                  this.jdField_a_of_type_ArrayOfByte = new byte[j];
                }
                paramlox = str + "_fbo_" + a(paramlpl.jdField_a_of_type_Int, paramlpl.b, 42) + ".yuv";
                lqj.a(paramlps.jdField_a_of_type_Int, paramlpl.jdField_a_of_type_Int, paramlpl.b, this.jdField_a_of_type_ArrayOfByte);
                a(this.jdField_a_of_type_ArrayOfByte, paramlox);
              }
              else if ((paramlox != null) && (paramlox.b()))
              {
                paramlpl = str + "_data_" + a(paramlpl.b, paramlpl.jdField_a_of_type_Int, 17) + ".yuv";
                a(paramlox.jdField_a_of_type_ArrayOfByte, paramlpl);
              }
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FilterProcessTest", 2, "endOfOneChat");
    }
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ArrayOfLpo != null) && (this.jdField_a_of_type_ArrayOfLpo.length > 0))
      {
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfLpo.length)
        {
          if (this.jdField_a_of_type_ArrayOfLpo[i] != null)
          {
            this.jdField_a_of_type_ArrayOfLpo[i].a();
            this.jdField_a_of_type_ArrayOfLpo[i] = null;
          }
          i += 1;
        }
      }
    }
  }
  
  public void c()
  {
    this.c = jdField_b_of_type_Boolean;
    if (this.c)
    {
      this.jdField_a_of_type_Int = 0;
      Object localObject = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss/", Locale.getDefault());
      Date localDate = new Date(System.currentTimeMillis());
      this.jdField_b_of_type_JavaLangString = (jdField_a_of_type_JavaLangString + ((SimpleDateFormat)localObject).format(localDate));
      localObject = new File(this.jdField_b_of_type_JavaLangString);
      if (((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) && (!((File)localObject).mkdirs()))
      {
        this.c = false;
        if (QLog.isDevelopLevel()) {
          QLog.i("FilterProcessTest", 2, "beginTestSaveData mkdir fail path: " + this.jdField_b_of_type_JavaLangString);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("FilterProcessTest", 2, "beginTestSaveData path: " + this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public void d()
  {
    if (this.c) {
      AudioHelper.c("图片已经保存在日志目录下\n" + this.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lpn
 * JD-Core Version:    0.7.0.1
 */
import android.annotation.TargetApi;
import android.opengl.GLES20;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class lfo
{
  private static final String jdField_a_of_type_JavaLangString = ajed.aT + "/avdebug/";
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(500);
  private static boolean jdField_a_of_type_Boolean;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "10.AV_SRC", "20.AV_PRE_RENDER", "30.AV_FILTER_NEW", "40.AV_FILTER", "50.AV_POST_RENDER", "60.AV_RETURN", "appleVideoDenoise", "appleLowlightEnhance", "applyBeauty30", "yuvCenterTextureFbo", "rgbRotateCenterTextureFbo", "applyBeauty20" };
  private int jdField_a_of_type_Int;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private lfp[] jdField_a_of_type_ArrayOfLfp;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
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
  
  private lfp a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ArrayOfLfp != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_ArrayOfLfp.length) {
        localObject1 = this.jdField_a_of_type_ArrayOfLfp[paramInt];
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
    //   5: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 151	java/io/FileOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 154	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: aload_0
    //   25: invokestatic 140	lfo:b	(Ljava/io/FileOutputStream;[B)V
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 157	java/io/FileOutputStream:flush	()V
    //   34: aload_2
    //   35: astore_1
    //   36: aload_2
    //   37: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   40: aload_2
    //   41: ifnull -30 -> 11
    //   44: aload_2
    //   45: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   48: return
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   54: return
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: astore_1
    //   60: aload_3
    //   61: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   64: aload_0
    //   65: ifnull -54 -> 11
    //   68: aload_0
    //   69: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   72: return
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 163	java/lang/Exception:printStackTrace	()V
    //   78: return
    //   79: astore_0
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 163	java/lang/Exception:printStackTrace	()V
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
  
  public void a()
  {
    int j = 0;
    if (AudioHelper.a(24) == 1) {
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
    }
    for (this.jdField_b_of_type_Boolean = true;; this.jdField_b_of_type_Boolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FilterProcessTest", 2, "startOneChat debug[" + this.jdField_b_of_type_Boolean + "]");
      }
      Object localObject1 = null;
      Object localObject2;
      if (this.jdField_b_of_type_Boolean)
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
            this.jdField_b_of_type_Boolean = false;
            localObject1 = localObject2;
            if (QLog.isDevelopLevel())
            {
              QLog.i("FilterProcessTest", 4, "startOneChat mkdir fail path: " + (String)localObject2);
              localObject1 = localObject2;
            }
          }
        }
      }
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      int i = j;
      if (this.jdField_a_of_type_ArrayOfLfp == null)
      {
        this.jdField_a_of_type_ArrayOfLfp = new lfp[6];
        i = j;
      }
      while (i < this.jdField_a_of_type_ArrayOfLfp.length)
      {
        localObject2 = (String)localObject1 + jdField_a_of_type_ArrayOfJavaLangString[i];
        if (this.jdField_a_of_type_ArrayOfLfp[i] != null) {
          this.jdField_a_of_type_ArrayOfLfp[i].a();
        }
        this.jdField_a_of_type_ArrayOfLfp[i] = new lfp((String)localObject2);
        i += 1;
      }
      break;
      if (!this.jdField_b_of_type_Boolean) {
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
  void a(lfm paramlfm, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    lfp locallfp;
    Object localObject2;
    int i1;
    int m;
    int n;
    int j;
    int k;
    if (this.jdField_b_of_type_Boolean)
    {
      locallfp = a(paramInt1);
      if (locallfp != null)
      {
        localObject2 = null;
        i1 = 0;
        m = paramlfm.jdField_a_of_type_Int;
        n = paramlfm.jdField_b_of_type_Int;
        if ((paramInt1 != 0) && (paramInt1 != 5)) {
          break label91;
        }
        i = 17;
        j = paramlfm.jdField_b_of_type_Int;
        k = paramlfm.jdField_a_of_type_Int;
        localObject1 = paramArrayOfByte;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        locallfp.a((byte[])localObject1, i, j, k);
      }
      if (this.c) {
        break;
      }
      return;
      label91:
      if (paramInt1 == 3)
      {
        k = n;
        j = m;
        i = i1;
        localObject1 = localObject2;
        if (paramInt3 != -1)
        {
          a(m, n);
          a(paramInt3, 36064, m, n, this.jdField_a_of_type_ArrayOfByte);
          localObject1 = this.jdField_a_of_type_ArrayOfByte;
          i = 42;
          k = n;
          j = m;
        }
      }
      else if (paramInt1 == 2)
      {
        k = n;
        j = m;
        i = i1;
        localObject1 = localObject2;
        if (paramInt3 != -1)
        {
          a(m, n);
          a(paramInt3, 36064, m, n, this.jdField_a_of_type_ArrayOfByte);
          localObject1 = this.jdField_a_of_type_ArrayOfByte;
          i = 42;
          k = n;
          j = m;
        }
      }
      else if (paramInt1 == 4)
      {
        m = paramlfm.jdField_b_of_type_Int;
        n = paramlfm.jdField_a_of_type_Int;
        if (paramlfm.jdField_a_of_type_ArrayOfByte != null)
        {
          localObject1 = paramlfm.jdField_a_of_type_ArrayOfByte;
          i = 42;
          k = n;
          j = m;
        }
        else
        {
          k = n;
          j = m;
          i = i1;
          localObject1 = localObject2;
          if (paramlfm.jdField_b_of_type_ArrayOfByte != null)
          {
            localObject1 = paramlfm.jdField_b_of_type_ArrayOfByte;
            i = 35;
            k = n;
            j = m;
          }
        }
      }
      else
      {
        k = n;
        j = m;
        i = i1;
        localObject1 = localObject2;
        if (paramInt1 == 1) {
          if (paramInt3 != -1)
          {
            a(m, n);
            a(paramInt3, 36064, m, n, this.jdField_a_of_type_ArrayOfByte);
            localObject1 = this.jdField_a_of_type_ArrayOfByte;
            i = 42;
            k = n;
            j = m;
          }
          else
          {
            k = n;
            j = m;
            i = i1;
            localObject1 = localObject2;
            if (paramInt2 != -1)
            {
              a(m, n);
              lfm.a(paramInt2, m, n, this.jdField_a_of_type_ArrayOfByte);
              localObject1 = this.jdField_a_of_type_ArrayOfByte;
              i = 42;
              k = n;
              j = m;
            }
          }
        }
      }
    }
    Object localObject1 = this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Int + "_" + a(paramInt1);
    int i = paramlfm.jdField_b_of_type_Int * paramlfm.jdField_a_of_type_Int * 4;
    if (paramArrayOfByte != null) {
      a(paramArrayOfByte, (String)localObject1 + "_yuvData_" + a(paramlfm.jdField_b_of_type_Int, paramlfm.jdField_a_of_type_Int, 17) + ".yuv");
    }
    if (paramInt3 != -1)
    {
      paramArrayOfByte = (String)localObject1 + "_textureId_1_" + a(paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, 0) + ".jpg";
      lfm.a(paramInt3, paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, paramArrayOfByte);
    }
    if (paramInt2 != -1)
    {
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != i)) {
        this.jdField_a_of_type_ArrayOfByte = new byte[i];
      }
      paramArrayOfByte = (String)localObject1 + "_fbo_1_" + a(paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, 42) + ".yuv";
      lfm.a(paramInt2, paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
      a(this.jdField_a_of_type_ArrayOfByte, paramArrayOfByte);
    }
    if (paramInt1 == 1)
    {
      if (paramlfm.c != -1)
      {
        paramArrayOfByte = (String)localObject1 + "_mYuvTextureId_for_Y_1" + a(paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, 0) + ".jpg";
        lfm.a(paramlfm.c, paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, paramArrayOfByte);
        if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != i)) {
          this.jdField_a_of_type_ArrayOfByte = new byte[i];
        }
        paramArrayOfByte = (String)localObject1 + "_mYuvTextureId_for_Y_1" + a(paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, 42) + ".yuv";
        a(paramlfm.c, 6409, paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
        a(this.jdField_a_of_type_ArrayOfByte, paramArrayOfByte);
      }
      if (paramlfm.d != -1)
      {
        paramArrayOfByte = (String)localObject1 + "_mYuvTextureId_for_UV_1" + a(paramlfm.jdField_a_of_type_Int / 2, paramlfm.jdField_b_of_type_Int / 2, 0) + ".jpg";
        lfm.a(paramlfm.d, paramlfm.jdField_a_of_type_Int / 2, paramlfm.jdField_b_of_type_Int / 2, paramArrayOfByte);
        if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != i)) {
          this.jdField_a_of_type_ArrayOfByte = new byte[i];
        }
        paramArrayOfByte = (String)localObject1 + "_mYuvTextureId_for_UV_1" + a(paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, 42) + ".yuv";
        a(paramlfm.d, 6410, paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
        a(this.jdField_a_of_type_ArrayOfByte, paramArrayOfByte);
      }
    }
    for (;;)
    {
      if (paramlfm.f != -1)
      {
        paramArrayOfByte = (String)localObject1 + "_yuvCenterTextureFbo_1" + a(paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, 0) + ".jpg";
        lfm.a(paramlfm.f, paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, paramArrayOfByte);
      }
      if (paramlfm.e != -1)
      {
        paramArrayOfByte = (String)localObject1 + "_yuvCenterTextureId_1" + a(paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, 0) + ".jpg";
        lfm.a(paramlfm.e, paramlfm.jdField_a_of_type_Int, paramlfm.jdField_b_of_type_Int, paramArrayOfByte);
      }
      this.jdField_a_of_type_Int += 1;
      return;
      if (paramInt1 == 4)
      {
        if (paramlfm.h != -1)
        {
          if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != i)) {
            this.jdField_a_of_type_ArrayOfByte = new byte[i];
          }
          paramArrayOfByte = (String)localObject1 + "_rgbRotateCenterTextureFbo_" + paramlfm.h + "_" + a(paramlfm.jdField_b_of_type_Int, paramlfm.jdField_a_of_type_Int, 42) + ".yuv";
          lfm.a(paramlfm.h, paramlfm.jdField_b_of_type_Int, paramlfm.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
          a(this.jdField_a_of_type_ArrayOfByte, paramArrayOfByte);
        }
        if (paramlfm.g != -1)
        {
          paramArrayOfByte = (String)localObject1 + "_rgbRotateCenterTextureId_" + a(paramlfm.jdField_b_of_type_Int, paramlfm.jdField_a_of_type_Int, 0) + ".jpg";
          lfm.a(paramlfm.g, paramlfm.jdField_b_of_type_Int, paramlfm.jdField_a_of_type_Int, paramArrayOfByte);
        }
        if (paramlfm.jdField_b_of_type_ArrayOfByte != null)
        {
          paramArrayOfByte = (String)localObject1 + "_i420Data_" + a(paramlfm.jdField_b_of_type_Int, paramlfm.jdField_a_of_type_Int, 17) + ".yuv";
          a(paramlfm.jdField_b_of_type_ArrayOfByte, paramArrayOfByte);
        }
        else if (paramlfm.jdField_a_of_type_ArrayOfByte != null)
        {
          paramArrayOfByte = (String)localObject1 + "_rgbaData_" + a(paramlfm.jdField_b_of_type_Int, paramlfm.jdField_a_of_type_Int, 42) + ".yuv";
          a(paramlfm.jdField_a_of_type_ArrayOfByte, paramArrayOfByte);
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FilterProcessTest", 2, "endOfOneChat");
    }
    if (!this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ArrayOfLfp != null) && (this.jdField_a_of_type_ArrayOfLfp.length > 0))
      {
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfLfp.length)
        {
          if (this.jdField_a_of_type_ArrayOfLfp[i] != null)
          {
            this.jdField_a_of_type_ArrayOfLfp[i].a();
            this.jdField_a_of_type_ArrayOfLfp[i] = null;
          }
          i += 1;
        }
      }
    }
  }
  
  public void c()
  {
    this.c = jdField_a_of_type_Boolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfo
 * JD-Core Version:    0.7.0.1
 */
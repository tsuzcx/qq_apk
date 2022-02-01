package com.tencent.mobileqq.magicface.drawable;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class PngGifEngine
  implements IMessageHandler
{
  int jdField_a_of_type_Int = -1;
  Handler jdField_a_of_type_AndroidOsHandler;
  PngGifEngine.PngGifTaskParam jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam;
  Runnable jdField_a_of_type_JavaLangRunnable = new PngGifEngine.1(this);
  boolean jdField_a_of_type_Boolean = false;
  
  public PngGifEngine()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngGifEngine", 2, "func PngGifEngine 【Constructor】");
    }
    this.jdField_a_of_type_AndroidOsHandler = PngFrameManager.a(this);
  }
  
  /* Error */
  public static Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 58	android/graphics/BitmapFactory$Options
    //   5: dup
    //   6: invokespecial 59	android/graphics/BitmapFactory$Options:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: sipush 320
    //   14: putfield 62	android/graphics/BitmapFactory$Options:inDensity	I
    //   17: aload_2
    //   18: invokestatic 68	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: invokevirtual 72	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   24: invokevirtual 78	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   27: getfield 83	android/util/DisplayMetrics:densityDpi	I
    //   30: putfield 86	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   33: aload_2
    //   34: getfield 62	android/graphics/BitmapFactory$Options:inDensity	I
    //   37: aload_2
    //   38: getfield 86	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   41: if_icmpge +11 -> 52
    //   44: aload_2
    //   45: aload_2
    //   46: getfield 86	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   49: putfield 62	android/graphics/BitmapFactory$Options:inDensity	I
    //   52: new 88	java/io/BufferedInputStream
    //   55: dup
    //   56: new 90	java/io/FileInputStream
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 93	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   64: invokespecial 96	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore_1
    //   68: aload_1
    //   69: astore_0
    //   70: aload_1
    //   71: aconst_null
    //   72: aload_2
    //   73: invokestatic 102	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   76: astore_2
    //   77: aload_2
    //   78: astore_0
    //   79: aload_1
    //   80: ifnull +9 -> 89
    //   83: aload_1
    //   84: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   87: aload_2
    //   88: astore_0
    //   89: aload_0
    //   90: areturn
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   96: aload_2
    //   97: areturn
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: astore_0
    //   103: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +15 -> 121
    //   109: aload_1
    //   110: astore_0
    //   111: ldc 35
    //   113: iconst_2
    //   114: aload_2
    //   115: invokevirtual 112	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   118: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_3
    //   122: astore_0
    //   123: aload_1
    //   124: ifnull -35 -> 89
    //   127: aload_1
    //   128: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   131: aconst_null
    //   132: areturn
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   138: aconst_null
    //   139: areturn
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_1
    //   144: astore_0
    //   145: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +15 -> 163
    //   151: aload_1
    //   152: astore_0
    //   153: ldc 35
    //   155: iconst_2
    //   156: aload_2
    //   157: invokevirtual 113	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   160: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload_3
    //   164: astore_0
    //   165: aload_1
    //   166: ifnull -77 -> 89
    //   169: aload_1
    //   170: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   173: aconst_null
    //   174: areturn
    //   175: astore_0
    //   176: aload_0
    //   177: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   180: aconst_null
    //   181: areturn
    //   182: astore_1
    //   183: aconst_null
    //   184: astore_0
    //   185: aload_0
    //   186: ifnull +7 -> 193
    //   189: aload_0
    //   190: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   193: aload_1
    //   194: athrow
    //   195: astore_0
    //   196: aload_0
    //   197: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   200: goto -7 -> 193
    //   203: astore_1
    //   204: goto -19 -> 185
    //   207: astore_2
    //   208: goto -65 -> 143
    //   211: astore_2
    //   212: goto -111 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramString	String
    //   67	103	1	localBufferedInputStream	java.io.BufferedInputStream
    //   182	12	1	localObject1	Object
    //   203	1	1	localObject2	Object
    //   9	88	2	localObject3	Object
    //   98	17	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   140	17	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   207	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   211	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	163	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   83	87	91	java/io/IOException
    //   52	68	98	java/io/FileNotFoundException
    //   127	131	133	java/io/IOException
    //   52	68	140	java/lang/OutOfMemoryError
    //   169	173	175	java/io/IOException
    //   52	68	182	finally
    //   189	193	195	java/io/IOException
    //   70	77	203	finally
    //   103	109	203	finally
    //   111	121	203	finally
    //   145	151	203	finally
    //   153	163	203	finally
    //   70	77	207	java/lang/OutOfMemoryError
    //   70	77	211	java/io/FileNotFoundException
  }
  
  String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return "";
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam.jdField_a_of_type_ArrayOfJavaLangString == null)
    {
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam.jdField_a_of_type_JavaLangString;
    }
    int i = this.jdField_a_of_type_Int + 1;
    if (i >= this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      PngGifEngine.PngGifTaskParam localPngGifTaskParam = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam;
      localPngGifTaskParam.jdField_a_of_type_Int -= 1;
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam.jdField_a_of_type_Int <= 0)
      {
        this.jdField_a_of_type_Boolean = true;
        return this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_Int = -1;
      i = this.jdField_a_of_type_Int;
      return this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam.jdField_a_of_type_ArrayOfJavaLangString[(i + 1)];
    }
    return this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam.jdField_a_of_type_ArrayOfJavaLangString[i];
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngGifEngine", 2, "func start.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam == null) {
      throw new IllegalArgumentException("【PngGifEngine】 task is null.");
    }
    if (!a()) {
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
    }
  }
  
  public void a(PngGifEngine.PngGifTaskParam paramPngGifTaskParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam = paramPngGifTaskParam;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int > -1;
  }
  
  public void handleMsg(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawableIRedrawNotify != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawableIRedrawNotify.a((Bitmap)paramMessage.obj);
    }
    this.jdField_a_of_type_Int += 1;
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngGifEngine
 * JD-Core Version:    0.7.0.1
 */
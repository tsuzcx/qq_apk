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
    //   0: new 58	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 59	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: sipush 320
    //   12: putfield 62	android/graphics/BitmapFactory$Options:inDensity	I
    //   15: aload_2
    //   16: invokestatic 68	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   19: invokevirtual 72	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   22: invokevirtual 78	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   25: getfield 83	android/util/DisplayMetrics:densityDpi	I
    //   28: putfield 86	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   31: aload_2
    //   32: getfield 62	android/graphics/BitmapFactory$Options:inDensity	I
    //   35: aload_2
    //   36: getfield 86	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   39: if_icmpge +11 -> 50
    //   42: aload_2
    //   43: aload_2
    //   44: getfield 86	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   47: putfield 62	android/graphics/BitmapFactory$Options:inDensity	I
    //   50: aconst_null
    //   51: astore_3
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
    //   80: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   83: aload_2
    //   84: areturn
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   90: aload_0
    //   91: areturn
    //   92: astore_2
    //   93: goto +16 -> 109
    //   96: astore_2
    //   97: goto +47 -> 144
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_0
    //   103: goto +74 -> 177
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: astore_0
    //   111: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +15 -> 129
    //   117: aload_1
    //   118: astore_0
    //   119: ldc 35
    //   121: iconst_2
    //   122: aload_2
    //   123: invokevirtual 112	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   126: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: aload_1
    //   130: ifnull +44 -> 174
    //   133: aload_3
    //   134: astore_0
    //   135: aload_1
    //   136: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_2
    //   142: aconst_null
    //   143: astore_1
    //   144: aload_1
    //   145: astore_0
    //   146: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +15 -> 164
    //   152: aload_1
    //   153: astore_0
    //   154: ldc 35
    //   156: iconst_2
    //   157: aload_2
    //   158: invokevirtual 113	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   161: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_1
    //   165: ifnull +9 -> 174
    //   168: aload_3
    //   169: astore_0
    //   170: aload_1
    //   171: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   174: aconst_null
    //   175: areturn
    //   176: astore_1
    //   177: aload_0
    //   178: ifnull +15 -> 193
    //   181: aload_0
    //   182: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   185: goto +8 -> 193
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   193: aload_1
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramString	String
    //   67	13	1	localBufferedInputStream	java.io.BufferedInputStream
    //   85	2	1	localIOException	java.io.IOException
    //   100	1	1	localObject1	Object
    //   108	63	1	localObject2	Object
    //   176	18	1	localObject3	Object
    //   7	77	2	localObject4	Object
    //   92	1	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   96	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   106	17	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   141	17	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   51	118	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   79	83	85	java/io/IOException
    //   135	139	85	java/io/IOException
    //   170	174	85	java/io/IOException
    //   70	77	92	java/lang/OutOfMemoryError
    //   70	77	96	java/io/FileNotFoundException
    //   52	68	100	finally
    //   52	68	106	java/lang/OutOfMemoryError
    //   52	68	141	java/io/FileNotFoundException
    //   70	77	176	finally
    //   111	117	176	finally
    //   119	129	176	finally
    //   146	152	176	finally
    //   154	164	176	finally
    //   181	185	188	java/io/IOException
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
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam != null)
    {
      if (!a()) {
        ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
      }
      return;
    }
    throw new IllegalArgumentException("【PngGifEngine】 task is null.");
  }
  
  public void a(PngGifEngine.PngGifTaskParam paramPngGifTaskParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam = paramPngGifTaskParam;
  }
  
  public void a(String paramString)
  {
    PngGifEngine.PngGifTaskParam localPngGifTaskParam = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam;
    if (localPngGifTaskParam != null) {
      localPngGifTaskParam.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int > -1;
  }
  
  public void handleMsg(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawableIRedrawNotify != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawableIRedrawNotify.a((Bitmap)paramMessage.obj);
    }
    this.jdField_a_of_type_Int += 1;
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngGifEngine
 * JD-Core Version:    0.7.0.1
 */
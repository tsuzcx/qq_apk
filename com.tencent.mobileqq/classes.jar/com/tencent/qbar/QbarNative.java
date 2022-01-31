package com.tencent.qbar;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import bdsw;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class QbarNative
{
  private int a;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: invokestatic 16	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5: ifnull +87 -> 92
    //   8: invokestatic 16	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: ldc 18
    //   13: invokestatic 24	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   16: istore_0
    //   17: iload_0
    //   18: ifne +16 -> 34
    //   21: ldc 26
    //   23: iconst_1
    //   24: ldc 28
    //   26: invokestatic 34	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: ldc 18
    //   31: invokestatic 40	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   34: invokestatic 16	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   37: ifnull +83 -> 120
    //   40: invokestatic 16	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   43: ldc 42
    //   45: invokestatic 24	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   48: istore_0
    //   49: iload_0
    //   50: ifne +31 -> 81
    //   53: ldc 26
    //   55: iconst_1
    //   56: ldc 44
    //   58: invokestatic 34	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: ldc 42
    //   63: invokestatic 40	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   66: iload_1
    //   67: istore_0
    //   68: invokestatic 16	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   71: ifnull +10 -> 81
    //   74: invokestatic 49	aldn:a	()Laldn;
    //   77: iload_0
    //   78: invokevirtual 52	aldn:a	(Z)V
    //   81: return
    //   82: astore_2
    //   83: ldc 26
    //   85: iconst_1
    //   86: ldc 54
    //   88: aload_2
    //   89: invokestatic 58	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: iconst_0
    //   93: istore_0
    //   94: goto -77 -> 17
    //   97: astore_2
    //   98: ldc 26
    //   100: iconst_1
    //   101: ldc 60
    //   103: aload_2
    //   104: invokestatic 62	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: goto -73 -> 34
    //   110: astore_2
    //   111: ldc 26
    //   113: iconst_1
    //   114: ldc 64
    //   116: aload_2
    //   117: invokestatic 62	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: iconst_0
    //   121: istore_0
    //   122: goto -73 -> 49
    //   125: astore_2
    //   126: ldc 26
    //   128: iconst_1
    //   129: ldc 66
    //   131: aload_2
    //   132: invokestatic 62	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   135: iconst_0
    //   136: istore_0
    //   137: goto -69 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	121	0	bool1	boolean
    //   1	66	1	bool2	boolean
    //   82	7	2	localThrowable1	Throwable
    //   97	7	2	localThrowable2	Throwable
    //   110	7	2	localThrowable3	Throwable
    //   125	7	2	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	17	82	java/lang/Throwable
    //   29	34	97	java/lang/Throwable
    //   40	49	110	java/lang/Throwable
    //   61	66	125	java/lang/Throwable
  }
  
  public QbarNative()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  protected static native int Encode(byte[] paramArrayOfByte, int[] paramArrayOfInt, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3);
  
  protected static native int EncodeBitmap(String paramString1, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5);
  
  protected static native String GetVersion();
  
  public static Bitmap a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    if (EncodeBitmap(paramString1, localBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramString2, paramInt5) > 0) {
      return localBitmap;
    }
    return null;
  }
  
  public static String a()
  {
    return GetVersion();
  }
  
  public static native int nativeArrayConvert(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int[] paramArrayOfInt);
  
  public static native int nativeCropGray2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int nativeGrayRotateCropSub(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt7, int paramInt8);
  
  public static native int nativeTransBytes(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int nativeTransPixels(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int nativeYUVrotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native int nativeYUVrotateLess(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int nativeYuvToCropIntArray(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  protected native int GetCodeDetectInfo(QbarNative.QBarCodeDetectInfo[] paramArrayOfQBarCodeDetectInfo, QbarNative.QBarPoint[] paramArrayOfQBarPoint, int paramInt);
  
  protected native int GetOneResult(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int[] paramArrayOfInt, int paramInt);
  
  protected native int GetResults(QbarNative.QBarResultJNI[] paramArrayOfQBarResultJNI, int paramInt);
  
  protected native int GetZoomInfo(QbarNative.QBarZoomInfo paramQBarZoomInfo, int paramInt);
  
  protected native int Init(int paramInt1, int paramInt2, String paramString1, String paramString2, QbarNative.QbarAiModelParam paramQbarAiModelParam);
  
  protected native int Release(int paramInt);
  
  protected native int ScanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  protected native int SetReaders(int[] paramArrayOfInt, int paramInt1, int paramInt2);
  
  public int a()
  {
    int i = Release(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = -1;
    return i;
  }
  
  public int a(int paramInt1, int paramInt2, String paramString1, String paramString2, QbarNative.QbarAiModelParam paramQbarAiModelParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbarNative", 2, "QbarNative : init ");
    }
    if ((this.jdField_a_of_type_Int >= 0) || (paramQbarAiModelParam != null)) {}
    try
    {
      for (this.jdField_a_of_type_Int = Init(paramInt1, paramInt2, paramString1, paramString2, paramQbarAiModelParam); this.jdField_a_of_type_Int < 0; this.jdField_a_of_type_Int = Init(paramInt1, paramInt2, paramString1, paramString2, paramQbarAiModelParam))
      {
        return -1;
        paramQbarAiModelParam = new QbarNative.QbarAiModelParam();
        paramQbarAiModelParam.detect_model_bin_path_ = "";
        paramQbarAiModelParam.detect_model_param_path_ = "";
        paramQbarAiModelParam.superresolution_model_bin_path_ = "";
        paramQbarAiModelParam.superresolution_model_param_path_ = "";
      }
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        QLog.e("QbarNative", 1, "QbarNative init error:" + paramString1.getMessage());
      }
    }
    return 0;
  }
  
  public int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    List localList = a(3);
    if ((localList != null) && (localList.size() > 0))
    {
      paramStringBuilder1.append(((bdsw)localList.get(0)).jdField_a_of_type_JavaLangString);
      paramStringBuilder2.append(((bdsw)localList.get(0)).b);
      return 1;
    }
    return 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbarNative", 2, "QbarNative : scanImage ");
    }
    if (ScanImage(paramArrayOfByte, paramInt1, paramInt2, this.jdField_a_of_type_Int) < 0) {}
    while (a(3).size() <= 0) {
      return -1;
    }
    return 0;
  }
  
  public int a(int[] paramArrayOfInt, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbarNative", 2, "QbarNative : setReaders ");
    }
    return SetReaders(paramArrayOfInt, paramInt, this.jdField_a_of_type_Int);
  }
  
  public List<bdsw> a(int paramInt)
  {
    int i = 0;
    Object localObject;
    if ((paramInt <= 0) || (this.jdField_a_of_type_Int < 0))
    {
      localObject = null;
      return localObject;
    }
    QbarNative.QBarResultJNI[] arrayOfQBarResultJNI = new QbarNative.QBarResultJNI[paramInt];
    paramInt = 0;
    while (paramInt < arrayOfQBarResultJNI.length)
    {
      arrayOfQBarResultJNI[paramInt] = new QbarNative.QBarResultJNI();
      arrayOfQBarResultJNI[paramInt].charset = new String();
      arrayOfQBarResultJNI[paramInt].data = new byte[1024];
      arrayOfQBarResultJNI[paramInt].typeName = new String();
      paramInt += 1;
    }
    GetResults(arrayOfQBarResultJNI, this.jdField_a_of_type_Int);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        int j = arrayOfQBarResultJNI.length;
        paramInt = i;
        localObject = localArrayList;
        if (paramInt >= j) {
          break;
        }
        localObject = arrayOfQBarResultJNI[paramInt];
        if ((((QbarNative.QBarResultJNI)localObject).typeName != null) && (!((QbarNative.QBarResultJNI)localObject).typeName.isEmpty()))
        {
          bdsw localbdsw = new bdsw();
          localbdsw.c = ((QbarNative.QBarResultJNI)localObject).charset;
          localbdsw.jdField_a_of_type_Int = ((QbarNative.QBarResultJNI)localObject).typeID;
          localbdsw.jdField_a_of_type_JavaLangString = ((QbarNative.QBarResultJNI)localObject).typeName;
          localbdsw.jdField_a_of_type_ArrayOfByte = ((QbarNative.QBarResultJNI)localObject).data;
          if (localbdsw.c.equals("ANY"))
          {
            localbdsw.b = new String(((QbarNative.QBarResultJNI)localObject).data, "UTF-8");
            if (TextUtils.isEmpty(localbdsw.b)) {
              localbdsw.b = new String(((QbarNative.QBarResultJNI)localObject).data, "ASCII");
            }
            localArrayList.add(localbdsw);
          }
          else
          {
            localbdsw.b = new String(((QbarNative.QBarResultJNI)localObject).data, localbdsw.c);
            continue;
          }
        }
        paramInt += 1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        QLog.e("QbarNative", 1, "GetResults exp:" + localUnsupportedEncodingException.getMessage());
        return localArrayList;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.qbar.QbarNative
 * JD-Core Version:    0.7.0.1
 */
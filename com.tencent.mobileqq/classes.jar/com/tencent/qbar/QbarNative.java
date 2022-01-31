package com.tencent.qbar;

import amud;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import bfrt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QbarNative
{
  static boolean jdField_a_of_type_Boolean;
  static boolean b;
  private int jdField_a_of_type_Int = -1;
  
  static
  {
    if (BaseApplicationImpl.getContext() != null) {}
    try
    {
      b = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "c++_shared");
      if (!b) {
        QLog.e("QbarNative", 1, "Init load c++_shared fail, try system load.");
      }
    }
    catch (Throwable localThrowable3)
    {
      try
      {
        System.loadLibrary("c++_shared");
        b = true;
        if (BaseApplicationImpl.getContext() == null) {}
      }
      catch (Throwable localThrowable3)
      {
        try
        {
          jdField_a_of_type_Boolean = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "QBarMod");
          if (!jdField_a_of_type_Boolean) {
            QLog.e("QbarNative", 1, "Init load QBarMod fail, try system load.");
          }
        }
        catch (Throwable localThrowable3)
        {
          try
          {
            for (;;)
            {
              System.loadLibrary("QBarMod");
              jdField_a_of_type_Boolean = true;
              if (BaseApplicationImpl.getContext() != null) {
                amud.a().a(jdField_a_of_type_Boolean);
              }
              return;
              localThrowable1 = localThrowable1;
              b = false;
              QLog.w("QbarNative", 1, "loadSoByName, load libc++_shared.so failed:", localThrowable1);
              continue;
              localThrowable2 = localThrowable2;
              b = false;
              QLog.e("QbarNative", 1, "Init system load c++_shared fail:", localThrowable2);
            }
            localThrowable3 = localThrowable3;
            jdField_a_of_type_Boolean = false;
            QLog.e("QbarNative", 1, "loadSoByName, load libQBarMod.so failed:", localThrowable3);
          }
          catch (Throwable localThrowable4)
          {
            for (;;)
            {
              QLog.e("QbarNative", 1, "Init system load QBarMod fail:", localThrowable4);
              jdField_a_of_type_Boolean = false;
            }
          }
        }
      }
    }
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
    if (QLog.isColorLevel()) {
      QLog.i("QbarNative", 2, "QbarNative : release qbarId:" + this.jdField_a_of_type_Int + " hasSoLoad:" + jdField_a_of_type_Boolean);
    }
    try
    {
      if (this.jdField_a_of_type_Int < 0) {
        return 0;
      }
      int i = Release(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
      return i;
    }
    finally {}
  }
  
  public int a(int paramInt1, int paramInt2, String paramString1, String paramString2, QbarNative.QbarAiModelParam paramQbarAiModelParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbarNative", 2, "QbarNative : init qbarId:" + this.jdField_a_of_type_Int + " hasSoLoad:" + jdField_a_of_type_Boolean);
    }
    if (!jdField_a_of_type_Boolean) {
      return -1;
    }
    if (this.jdField_a_of_type_Int < 0) {}
    for (;;)
    {
      try
      {
        if (paramQbarAiModelParam == null) {}
      }
      catch (Throwable paramString1)
      {
        this.jdField_a_of_type_Int = -1;
        QLog.e("QbarNative", 1, "QbarNative init hasSoLoad:" + jdField_a_of_type_Boolean + " error:" + paramString1.getMessage());
        continue;
      }
      try
      {
        this.jdField_a_of_type_Int = Init(paramInt1, paramInt2, paramString1, paramString2, paramQbarAiModelParam);
        if (this.jdField_a_of_type_Int >= 0) {
          break label201;
        }
        return -1;
      }
      finally {}
      paramQbarAiModelParam = new QbarNative.QbarAiModelParam();
      paramQbarAiModelParam.detect_model_bin_path_ = "";
      paramQbarAiModelParam.detect_model_param_path_ = "";
      paramQbarAiModelParam.superresolution_model_bin_path_ = "";
      paramQbarAiModelParam.superresolution_model_param_path_ = "";
      this.jdField_a_of_type_Int = Init(paramInt1, paramInt2, paramString1, paramString2, paramQbarAiModelParam);
    }
    label201:
    return 0;
  }
  
  public int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    List localList = a(3);
    if ((localList != null) && (localList.size() > 0))
    {
      paramStringBuilder1.append(((bfrt)localList.get(0)).jdField_a_of_type_JavaLangString);
      paramStringBuilder2.append(((bfrt)localList.get(0)).b);
      return 1;
    }
    return 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.i("QbarNative", 2, "QbarNative : scanImage qbarId:" + this.jdField_a_of_type_Int + " hasSoLoad:" + jdField_a_of_type_Boolean);
    }
    try
    {
      if (this.jdField_a_of_type_Int < 0) {
        return -1;
      }
      if (ScanImage(paramArrayOfByte, paramInt1, paramInt2, this.jdField_a_of_type_Int) < 0) {
        return -1;
      }
    }
    finally {}
    paramInt1 = i;
    if (a(3).size() > 0) {
      paramInt1 = 0;
    }
    return paramInt1;
  }
  
  public int a(int[] paramArrayOfInt, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QbarNative", 2, "QbarNative : setReaders qbarId:" + this.jdField_a_of_type_Int + " hasSoLoad:" + jdField_a_of_type_Boolean);
    }
    try
    {
      if (this.jdField_a_of_type_Int < 0) {
        return -1;
      }
      paramInt = SetReaders(paramArrayOfInt, paramInt, this.jdField_a_of_type_Int);
      return paramInt;
    }
    finally {}
  }
  
  /* Error */
  public List<bfrt> a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +42 -> 47
    //   8: ldc 30
    //   10: iconst_2
    //   11: new 139	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   18: ldc 223
    //   20: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 78	com/tencent/qbar/QbarNative:jdField_a_of_type_Int	I
    //   27: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 151
    //   32: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 48	com/tencent/qbar/QbarNative:jdField_a_of_type_Boolean	Z
    //   38: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 160	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: iload_1
    //   48: ifle +10 -> 58
    //   51: aload_0
    //   52: getfield 78	com/tencent/qbar/QbarNative:jdField_a_of_type_Int	I
    //   55: ifge +9 -> 64
    //   58: aconst_null
    //   59: astore 4
    //   61: aload 4
    //   63: areturn
    //   64: iload_1
    //   65: anewarray 225	com/tencent/qbar/QbarNative$QBarResultJNI
    //   68: astore 6
    //   70: iconst_0
    //   71: istore_1
    //   72: iload_1
    //   73: aload 6
    //   75: arraylength
    //   76: if_icmpge +61 -> 137
    //   79: aload 6
    //   81: iload_1
    //   82: new 225	com/tencent/qbar/QbarNative$QBarResultJNI
    //   85: dup
    //   86: invokespecial 226	com/tencent/qbar/QbarNative$QBarResultJNI:<init>	()V
    //   89: aastore
    //   90: aload 6
    //   92: iload_1
    //   93: aaload
    //   94: new 228	java/lang/String
    //   97: dup
    //   98: invokespecial 229	java/lang/String:<init>	()V
    //   101: putfield 232	com/tencent/qbar/QbarNative$QBarResultJNI:charset	Ljava/lang/String;
    //   104: aload 6
    //   106: iload_1
    //   107: aaload
    //   108: sipush 1024
    //   111: newarray byte
    //   113: putfield 236	com/tencent/qbar/QbarNative$QBarResultJNI:data	[B
    //   116: aload 6
    //   118: iload_1
    //   119: aaload
    //   120: new 228	java/lang/String
    //   123: dup
    //   124: invokespecial 229	java/lang/String:<init>	()V
    //   127: putfield 239	com/tencent/qbar/QbarNative$QBarResultJNI:typeName	Ljava/lang/String;
    //   130: iload_1
    //   131: iconst_1
    //   132: iadd
    //   133: istore_1
    //   134: goto -62 -> 72
    //   137: aload_0
    //   138: monitorenter
    //   139: aload_0
    //   140: getfield 78	com/tencent/qbar/QbarNative:jdField_a_of_type_Int	I
    //   143: ifge +7 -> 150
    //   146: aload_0
    //   147: monitorexit
    //   148: aconst_null
    //   149: areturn
    //   150: aload_0
    //   151: aload 6
    //   153: aload_0
    //   154: getfield 78	com/tencent/qbar/QbarNative:jdField_a_of_type_Int	I
    //   157: invokevirtual 241	com/tencent/qbar/QbarNative:GetResults	([Lcom/tencent/qbar/QbarNative$QBarResultJNI;I)I
    //   160: pop
    //   161: aload_0
    //   162: monitorexit
    //   163: new 243	java/util/ArrayList
    //   166: dup
    //   167: invokespecial 244	java/util/ArrayList:<init>	()V
    //   170: astore 5
    //   172: aload 6
    //   174: arraylength
    //   175: istore_3
    //   176: iload_2
    //   177: istore_1
    //   178: aload 5
    //   180: astore 4
    //   182: iload_1
    //   183: iload_3
    //   184: if_icmpge -123 -> 61
    //   187: aload 6
    //   189: iload_1
    //   190: aaload
    //   191: astore 4
    //   193: aload 4
    //   195: getfield 239	com/tencent/qbar/QbarNative$QBarResultJNI:typeName	Ljava/lang/String;
    //   198: ifnull +138 -> 336
    //   201: aload 4
    //   203: getfield 239	com/tencent/qbar/QbarNative$QBarResultJNI:typeName	Ljava/lang/String;
    //   206: invokevirtual 247	java/lang/String:isEmpty	()Z
    //   209: ifne +127 -> 336
    //   212: new 206	bfrt
    //   215: dup
    //   216: invokespecial 248	bfrt:<init>	()V
    //   219: astore 7
    //   221: aload 7
    //   223: aload 4
    //   225: getfield 232	com/tencent/qbar/QbarNative$QBarResultJNI:charset	Ljava/lang/String;
    //   228: putfield 251	bfrt:c	Ljava/lang/String;
    //   231: aload 7
    //   233: aload 4
    //   235: getfield 254	com/tencent/qbar/QbarNative$QBarResultJNI:typeID	I
    //   238: putfield 255	bfrt:jdField_a_of_type_Int	I
    //   241: aload 7
    //   243: aload 4
    //   245: getfield 239	com/tencent/qbar/QbarNative$QBarResultJNI:typeName	Ljava/lang/String;
    //   248: putfield 208	bfrt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   251: aload 7
    //   253: aload 4
    //   255: getfield 236	com/tencent/qbar/QbarNative$QBarResultJNI:data	[B
    //   258: putfield 257	bfrt:jdField_a_of_type_ArrayOfByte	[B
    //   261: aload 7
    //   263: getfield 251	bfrt:c	Ljava/lang/String;
    //   266: ldc_w 259
    //   269: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   272: ifeq +78 -> 350
    //   275: aload 7
    //   277: new 228	java/lang/String
    //   280: dup
    //   281: aload 4
    //   283: getfield 236	com/tencent/qbar/QbarNative$QBarResultJNI:data	[B
    //   286: ldc_w 265
    //   289: invokespecial 268	java/lang/String:<init>	([BLjava/lang/String;)V
    //   292: putfield 210	bfrt:b	Ljava/lang/String;
    //   295: aload 7
    //   297: getfield 210	bfrt:b	Ljava/lang/String;
    //   300: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   303: ifeq +23 -> 326
    //   306: aload 7
    //   308: new 228	java/lang/String
    //   311: dup
    //   312: aload 4
    //   314: getfield 236	com/tencent/qbar/QbarNative$QBarResultJNI:data	[B
    //   317: ldc_w 275
    //   320: invokespecial 268	java/lang/String:<init>	([BLjava/lang/String;)V
    //   323: putfield 210	bfrt:b	Ljava/lang/String;
    //   326: aload 5
    //   328: aload 7
    //   330: invokeinterface 278 2 0
    //   335: pop
    //   336: iload_1
    //   337: iconst_1
    //   338: iadd
    //   339: istore_1
    //   340: goto -162 -> 178
    //   343: astore 4
    //   345: aload_0
    //   346: monitorexit
    //   347: aload 4
    //   349: athrow
    //   350: aload 7
    //   352: new 228	java/lang/String
    //   355: dup
    //   356: aload 4
    //   358: getfield 236	com/tencent/qbar/QbarNative$QBarResultJNI:data	[B
    //   361: aload 7
    //   363: getfield 251	bfrt:c	Ljava/lang/String;
    //   366: invokespecial 268	java/lang/String:<init>	([BLjava/lang/String;)V
    //   369: putfield 210	bfrt:b	Ljava/lang/String;
    //   372: goto -46 -> 326
    //   375: astore 4
    //   377: ldc 30
    //   379: iconst_1
    //   380: new 139	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 280
    //   390: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload 4
    //   395: invokevirtual 281	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   398: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 38	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: aload 5
    //   409: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	QbarNative
    //   0	410	1	paramInt	int
    //   1	176	2	i	int
    //   175	10	3	j	int
    //   59	254	4	localObject1	Object
    //   343	14	4	localObject2	Object
    //   375	19	4	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   170	238	5	localArrayList	java.util.ArrayList
    //   68	120	6	arrayOfQBarResultJNI	QbarNative.QBarResultJNI[]
    //   219	143	7	localbfrt	bfrt
    // Exception table:
    //   from	to	target	type
    //   139	148	343	finally
    //   150	163	343	finally
    //   345	347	343	finally
    //   172	176	375	java/io/UnsupportedEncodingException
    //   193	326	375	java/io/UnsupportedEncodingException
    //   326	336	375	java/io/UnsupportedEncodingException
    //   350	372	375	java/io/UnsupportedEncodingException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qbar.QbarNative
 * JD-Core Version:    0.7.0.1
 */
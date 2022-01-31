package com.tencent.qbar;

import aldo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class QbarNative
{
  private int a;
  public byte[] a;
  public int[] a;
  public byte[] b;
  public int[] b;
  public byte[] c = new byte[100];
  public byte[] d = new byte[300];
  
  static
  {
    boolean bool2 = true;
    if (BaseApplicationImpl.getContext() != null) {}
    for (boolean bool1 = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "QBarMod");; bool1 = false)
    {
      if (!bool1) {
        QLog.e("QbarNative", 1, "Init load QrMod fail, try system load.");
      }
      try
      {
        System.loadLibrary("QBarMod");
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("QbarNative", 1, "Init system load QrMod fail!", localException);
          bool1 = false;
        }
      }
      if (BaseApplicationImpl.getContext() != null) {
        aldo.a().a(bool1);
      }
      return;
    }
  }
  
  public QbarNative()
  {
    this.jdField_a_of_type_ArrayOfByte = new byte[100];
    this.jdField_b_of_type_ArrayOfByte = new byte[3000];
    this.jdField_a_of_type_ArrayOfInt = new int[4];
    this.jdField_b_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_Int = -1;
  }
  
  private native int AddBlackInternal(int paramInt1, int paramInt2);
  
  private native int AddBlackList(String paramString, int paramInt);
  
  private native int AddWhiteList(String paramString, int paramInt);
  
  private static native int Encode(byte[] paramArrayOfByte, int[] paramArrayOfInt, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3);
  
  private static native int EncodeBitmap(String paramString1, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5);
  
  public static native int FocusInit(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4);
  
  public static native boolean FocusPro(byte[] paramArrayOfByte, boolean paramBoolean, boolean[] paramArrayOfBoolean);
  
  public static native int FocusRelease();
  
  private native int GetCodeDetectInfo(QbarNative.QBarCodeDetectInfo[] paramArrayOfQBarCodeDetectInfo, QbarNative.QBarPoint[] paramArrayOfQBarPoint, int paramInt);
  
  private native int GetDetailResults(QbarNative.QBarResultJNI[] paramArrayOfQBarResultJNI, QbarNative.QBarPoint[] paramArrayOfQBarPoint, QbarNative.QBarReportMsg[] paramArrayOfQBarReportMsg, int paramInt);
  
  private native int GetDetectInfoByFrames(QbarNative.QBarCodeDetectInfo paramQBarCodeDetectInfo, QbarNative.QBarPoint paramQBarPoint, int paramInt);
  
  private native int GetOneResult(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int[] paramArrayOfInt, int paramInt);
  
  private native int GetOneResultReport(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt);
  
  private native int GetResults(QbarNative.QBarResultJNI[] paramArrayOfQBarResultJNI, int paramInt);
  
  private static native String GetVersion();
  
  private native int GetZoomInfo(QbarNative.QBarZoomInfo paramQBarZoomInfo, int paramInt);
  
  private native int Init(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  private native int Init(int paramInt1, int paramInt2, String paramString1, String paramString2, QbarNative.QbarAiModelParam paramQbarAiModelParam);
  
  public static native int QIPUtilYUVCrop(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private native int Release(int paramInt);
  
  private native int ScanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native int SetCenterCoordinate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private native int SetReaders(int[] paramArrayOfInt, int paramInt1, int paramInt2);
  
  public static int a(int paramInt, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfInt == null)) {
      return -1;
    }
    return nativeArrayConvert(paramInt, paramArrayOfByte.length, paramArrayOfByte, paramArrayOfInt);
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return -1;
    }
    return nativeYUVrotateLess(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return -1;
    }
    return nativeYUVrotate(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
  }
  
  public static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return -1;
    }
    return nativeCropGray2(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3);
  }
  
  public static int a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfInt == null)) {
      return -1;
    }
    return nativeYuvToCropIntArray(paramArrayOfByte, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public static int a(byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return -1;
    }
    return nativeGrayRotateCropSub(paramArrayOfByte2, paramInt1, paramInt2, 0, 0, paramInt1, paramInt2, paramArrayOfByte1, paramArrayOfInt, paramInt3, paramInt4);
  }
  
  public static int a(byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return -1;
    }
    return nativeGrayRotateCropSub(paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfByte1, paramArrayOfInt, paramInt7, paramInt8);
  }
  
  public static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfByte == null)) {
      return -1;
    }
    return nativeTransPixels(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
  }
  
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
  
  public static int b(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfByte == null)) {
      return -1;
    }
    return nativeTransBytes(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static native int focusedEngineForBankcardInit(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public static native int focusedEngineGetVersion();
  
  public static native int focusedEngineProcess(byte[] paramArrayOfByte);
  
  public static native int focusedEngineRelease();
  
  private static native int nativeArrayConvert(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int[] paramArrayOfInt);
  
  private static native int nativeCropGray2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  private static native int nativeGrayRotateCropSub(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt7, int paramInt8);
  
  public static native int nativeRelease();
  
  private static native int nativeTransBytes(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native int nativeTransPixels(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native int nativeYUVrotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  private static native int nativeYUVrotateLess(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native int nativeYuvToCropIntArray(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public int a()
  {
    int i = Release(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = -1;
    return i;
  }
  
  public int a(int paramInt1, int paramInt2, String paramString1, String paramString2, QbarNative.QbarAiModelParam paramQbarAiModelParam)
  {
    Log.i("QbarNative", "QBAR_ERR : init ");
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
  
  public int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, StringBuilder paramStringBuilder3, StringBuilder paramStringBuilder4, int[] paramArrayOfInt)
  {
    int i = GetOneResultReport(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.c, this.d, this.jdField_b_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_Int);
    try
    {
      paramArrayOfInt[0] = this.jdField_b_of_type_ArrayOfInt[0];
      paramArrayOfInt[1] = this.jdField_b_of_type_ArrayOfInt[1];
      paramArrayOfInt = new String(this.c, 0, this.jdField_a_of_type_ArrayOfInt[2], "UTF-8");
      paramStringBuilder3.append(paramArrayOfInt);
      if (paramArrayOfInt.equals("ANY"))
      {
        paramStringBuilder1.append(new String(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfInt[0], "UTF-8"));
        paramStringBuilder2.append(new String(this.jdField_b_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfInt[1], "UTF-8"));
        paramStringBuilder4.append(new String(this.d, 0, this.jdField_a_of_type_ArrayOfInt[3], "UTF-8"));
        if (paramStringBuilder2.length() == 0)
        {
          paramStringBuilder1.append(new String(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfInt[0], "ASCII"));
          paramStringBuilder2.append(new String(this.jdField_b_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfInt[1], "ASCII"));
          paramStringBuilder4.append(new String(this.d, 0, this.jdField_a_of_type_ArrayOfInt[3], "ASCII"));
          return i;
        }
      }
      else
      {
        paramStringBuilder1.append(new String(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfInt[0], paramArrayOfInt));
        paramStringBuilder2.append(new String(this.jdField_b_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfInt[1], paramArrayOfInt));
        paramStringBuilder4.append(new String(this.d, 0, this.jdField_a_of_type_ArrayOfInt[3], paramArrayOfInt));
        return i;
      }
    }
    catch (UnsupportedEncodingException paramStringBuilder1)
    {
      Log.e("QbarNative", "GetOneResult exp:" + paramStringBuilder1.getMessage());
    }
    return i;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.i("QbarNative", "QBAR_ERR scanimage ");
    ScanImage(paramArrayOfByte, paramInt1, paramInt2, paramInt3, this.jdField_a_of_type_Int);
    if (a(3).size() > 0) {
      return 0;
    }
    return -1;
  }
  
  public int a(int[] paramArrayOfInt, int paramInt)
  {
    Log.i("QbarNative", "QBAR_ERR : init ");
    return SetReaders(paramArrayOfInt, paramInt, this.jdField_a_of_type_Int);
  }
  
  public List<QbarNative.QBarResult> a(int paramInt)
  {
    int i = 0;
    Object localObject;
    if (paramInt <= 0)
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
        if (!TextUtils.isEmpty(((QbarNative.QBarResultJNI)localObject).typeName))
        {
          QbarNative.QBarResult localQBarResult = new QbarNative.QBarResult();
          localQBarResult.charset = ((QbarNative.QBarResultJNI)localObject).charset;
          localQBarResult.typeID = ((QbarNative.QBarResultJNI)localObject).typeID;
          localQBarResult.typeName = ((QbarNative.QBarResultJNI)localObject).typeName;
          localQBarResult.rawData = ((QbarNative.QBarResultJNI)localObject).data;
          if (localQBarResult.charset.equals("ANY"))
          {
            localQBarResult.data = new String(((QbarNative.QBarResultJNI)localObject).data, "UTF-8");
            if (localQBarResult.data.length() == 0) {
              localQBarResult.data = new String(((QbarNative.QBarResultJNI)localObject).data, "ASCII");
            }
            localArrayList.add(localQBarResult);
          }
          else
          {
            localQBarResult.data = new String(((QbarNative.QBarResultJNI)localObject).data, localQBarResult.charset);
            continue;
          }
        }
        paramInt += 1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Log.e("QbarNative", "GetResults exp:" + localUnsupportedEncodingException.getMessage());
        return localArrayList;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.qbar.QbarNative
 * JD-Core Version:    0.7.0.1
 */
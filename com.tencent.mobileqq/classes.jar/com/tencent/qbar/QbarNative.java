package com.tencent.qbar;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class QbarNative
{
  static boolean jdField_a_of_type_Boolean = false;
  static boolean jdField_b_of_type_Boolean = false;
  private int jdField_a_of_type_Int = -1;
  private int jdField_b_of_type_Int;
  private int c;
  
  static
  {
    if (BaseApplicationImpl.getContext() != null) {}
    try
    {
      jdField_b_of_type_Boolean = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "c++_shared");
      if (!jdField_b_of_type_Boolean) {
        QLog.e("QbarNative", 1, "Init load c++_shared fail, try system load.");
      }
    }
    catch (Throwable localThrowable3)
    {
      try
      {
        System.loadLibrary("c++_shared");
        jdField_b_of_type_Boolean = true;
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
                ScanEntranceReport.a().a(jdField_a_of_type_Boolean);
              }
              return;
              localThrowable1 = localThrowable1;
              jdField_b_of_type_Boolean = false;
              QLog.w("QbarNative", 1, "loadSoByName, load libc++_shared.so failed:", localThrowable1);
              continue;
              localThrowable2 = localThrowable2;
              jdField_b_of_type_Boolean = false;
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
  
  public static String a()
  {
    return GetVersion();
  }
  
  protected static native int nativeArrayConvert(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int[] paramArrayOfInt);
  
  protected static native int nativeCropGray2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  protected static native int nativeGrayRotateCropSub(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte2, int[] paramArrayOfInt, int paramInt7, int paramInt8);
  
  protected static native int nativeTransBytes(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  protected static native int nativeTransPixels(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  protected static native int nativeYUVrotate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  protected static native int nativeYUVrotateLess(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  protected static native int nativeYuvToCropIntArray(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
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
    this.jdField_b_of_type_Int = 0;
    this.c = 0;
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
        this.jdField_b_of_type_Int = 0;
        this.c = 0;
        if (this.jdField_a_of_type_Int >= 0) {
          break label211;
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
    label211:
    return 0;
  }
  
  public int a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    ArrayList localArrayList = a(1);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      paramStringBuilder1.append(((QBarResult)localArrayList.get(0)).jdField_a_of_type_JavaLangString);
      paramStringBuilder2.append(((QBarResult)localArrayList.get(0)).b);
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
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
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
    paramArrayOfByte = a(1);
    paramInt1 = i;
    if (paramArrayOfByte != null)
    {
      paramInt1 = i;
      if (paramArrayOfByte.size() > 0) {
        paramInt1 = 0;
      }
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
  
  public ArrayList<QBarResult> a(int paramInt)
  {
    ArrayList localArrayList3 = null;
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("QbarNative", 2, "QbarNative : GetResults qbarId:" + this.jdField_a_of_type_Int + " hasSoLoad:" + jdField_a_of_type_Boolean);
    }
    ArrayList localArrayList1 = localArrayList3;
    if (paramInt > 0)
    {
      if (this.jdField_a_of_type_Int < 0) {
        localArrayList1 = localArrayList3;
      }
    }
    else {
      return localArrayList1;
    }
    QbarNative.QBarResultJNI[] arrayOfQBarResultJNI = new QbarNative.QBarResultJNI[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfQBarResultJNI[i] = new QbarNative.QBarResultJNI();
      arrayOfQBarResultJNI[i].charset = new String();
      arrayOfQBarResultJNI[i].data = new byte[1024];
      arrayOfQBarResultJNI[i].typeName = new String();
      arrayOfQBarResultJNI[i].points = new QbarNative.QBarPoint();
      i += 1;
    }
    try
    {
      if (this.jdField_a_of_type_Int < 0) {
        return null;
      }
    }
    finally {}
    GetResults(arrayOfQBarResultJNI, this.jdField_a_of_type_Int);
    localArrayList3 = new ArrayList();
    i = j;
    for (;;)
    {
      ArrayList localArrayList2 = localArrayList3;
      if (i >= paramInt) {
        break;
      }
      localArrayList2 = arrayOfQBarResultJNI[i];
      for (;;)
      {
        QBarResult localQBarResult;
        float f1;
        try
        {
          if ((localArrayList2.typeName == null) || (localArrayList2.typeName.isEmpty())) {
            break;
          }
          localQBarResult = new QBarResult();
          localQBarResult.jdField_a_of_type_JavaLangString = localArrayList2.typeName;
          if (localArrayList2.charset.equals("ANY"))
          {
            localQBarResult.b = new String(localArrayList2.data, "UTF-8");
            if (TextUtils.isEmpty(localQBarResult.b)) {
              localQBarResult.b = new String(localArrayList2.data, "ASCII");
            }
            localQBarResult.jdField_a_of_type_Float = 1.0F;
            if ((this.jdField_b_of_type_Int <= 0) || (this.c <= 0)) {
              break label733;
            }
            if (localArrayList2.points.point_cnt > 2)
            {
              f1 = Math.min(localArrayList2.points.x0 / this.jdField_b_of_type_Int, localArrayList2.points.x2 / this.jdField_b_of_type_Int);
              f2 = Math.max(localArrayList2.points.x0 / this.jdField_b_of_type_Int, localArrayList2.points.x2 / this.jdField_b_of_type_Int);
              localQBarResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF(f1, Math.min(localArrayList2.points.y0 / this.c, localArrayList2.points.y2 / this.c), f2, Math.max(localArrayList2.points.y0 / this.c, localArrayList2.points.y2 / this.c));
              localArrayList3.add(localQBarResult);
              break;
            }
          }
          else
          {
            localQBarResult.b = new String(localArrayList2.data, localArrayList2.charset);
            continue;
          }
          f1 = Math.min(localUnsupportedEncodingException.points.x0 / this.jdField_b_of_type_Int, localUnsupportedEncodingException.points.x1 / this.jdField_b_of_type_Int);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          QLog.e("QbarNative", 1, "GetResults exp:" + localUnsupportedEncodingException.getMessage());
          return localArrayList3;
        }
        float f2 = Math.max(localUnsupportedEncodingException.points.x0 / this.jdField_b_of_type_Int, localUnsupportedEncodingException.points.x1 / this.jdField_b_of_type_Int);
        localQBarResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF(f1 - 0.01F, Math.min(localUnsupportedEncodingException.points.y0 / this.c, localUnsupportedEncodingException.points.y1 / this.c) - 0.01F, f2 + 0.01F, Math.max(localUnsupportedEncodingException.points.y0 / this.c, localUnsupportedEncodingException.points.y1 / this.c) + 0.01F);
        continue;
        label733:
        localQBarResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qbar.QbarNative
 * JD-Core Version:    0.7.0.1
 */
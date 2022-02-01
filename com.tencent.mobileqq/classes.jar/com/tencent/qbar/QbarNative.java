package com.tencent.qbar;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.api.IQRScanTempApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class QbarNative
{
  static boolean jdField_a_of_type_Boolean = false;
  static boolean jdField_b_of_type_Boolean = false;
  private int jdField_a_of_type_Int = -1;
  private int jdField_b_of_type_Int;
  private int c;
  
  static
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    if (localBaseApplication != null) {
      try
      {
        jdField_b_of_type_Boolean = SoLoadUtilNew.loadSoByName(localBaseApplication, "c++_shared");
      }
      catch (Throwable localThrowable1)
      {
        jdField_b_of_type_Boolean = false;
        QLog.w("QbarNative", 1, "loadSoByName, load libc++_shared.so failed:", localThrowable1);
      }
    }
    if (!jdField_b_of_type_Boolean)
    {
      QLog.e("QbarNative", 1, "Init load c++_shared fail, try system load.");
      try
      {
        System.loadLibrary("c++_shared");
        jdField_b_of_type_Boolean = true;
      }
      catch (Throwable localThrowable2)
      {
        jdField_b_of_type_Boolean = false;
        QLog.e("QbarNative", 1, "Init system load c++_shared fail:", localThrowable2);
      }
    }
    if (localBaseApplication != null) {
      try
      {
        jdField_a_of_type_Boolean = SoLoadUtilNew.loadSoByName(localBaseApplication, "QBarMod");
      }
      catch (Throwable localThrowable3)
      {
        jdField_a_of_type_Boolean = false;
        QLog.e("QbarNative", 1, "loadSoByName, load libQBarMod.so failed:", localThrowable3);
      }
    }
    if (!jdField_a_of_type_Boolean)
    {
      QLog.e("QbarNative", 1, "Init load QBarMod fail, try system load.");
      try
      {
        System.loadLibrary("QBarMod");
        jdField_a_of_type_Boolean = true;
      }
      catch (Throwable localThrowable4)
      {
        QLog.e("QbarNative", 1, "Init system load QBarMod fail:", localThrowable4);
        jdField_a_of_type_Boolean = false;
      }
      if (localBaseApplication != null) {
        ((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).reportQBarSoLoadFail(jdField_a_of_type_Boolean);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QbarNative : release qbarId:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" hasSoLoad:");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      QLog.i("QbarNative", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QbarNative : init qbarId:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" hasSoLoad:");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      QLog.i("QbarNative", 2, localStringBuilder.toString());
    }
    if (!jdField_a_of_type_Boolean) {
      return -1;
    }
    if (this.jdField_a_of_type_Int < 0) {
      try
      {
        if (paramQbarAiModelParam != null) {}
        label153:
        try
        {
          this.jdField_a_of_type_Int = Init(paramInt1, paramInt2, paramString1, paramString2, paramQbarAiModelParam);
          break label153;
          paramQbarAiModelParam = new QbarNative.QbarAiModelParam();
          paramQbarAiModelParam.detect_model_bin_path_ = "";
          paramQbarAiModelParam.detect_model_param_path_ = "";
          paramQbarAiModelParam.superresolution_model_bin_path_ = "";
          paramQbarAiModelParam.superresolution_model_param_path_ = "";
          this.jdField_a_of_type_Int = Init(paramInt1, paramInt2, paramString1, paramString2, paramQbarAiModelParam);
        }
        finally {}
        this.jdField_b_of_type_Int = 0;
      }
      catch (Throwable paramString1)
      {
        this.jdField_a_of_type_Int = -1;
        paramString2 = new StringBuilder();
        paramString2.append("QbarNative init hasSoLoad:");
        paramString2.append(jdField_a_of_type_Boolean);
        paramString2.append(" error:");
        paramString2.append(paramString1.getMessage());
        QLog.e("QbarNative", 1, paramString2.toString());
      }
    }
    this.c = 0;
    if (this.jdField_a_of_type_Int < 0) {
      return -1;
    }
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QbarNative : scanImage qbarId:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" hasSoLoad:");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      QLog.i("QbarNative", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    try
    {
      int j = this.jdField_a_of_type_Int;
      int i = -1;
      if (j < 0) {
        return -1;
      }
      if (ScanImage(paramArrayOfByte, paramInt1, paramInt2, this.jdField_a_of_type_Int) < 0) {
        return -1;
      }
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
    finally {}
  }
  
  public int a(int[] paramArrayOfInt, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QbarNative : setReaders qbarId:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" hasSoLoad:");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      QLog.i("QbarNative", 2, localStringBuilder.toString());
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
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QbarNative : GetResults qbarId:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append(" hasSoLoad:");
      ((StringBuilder)localObject1).append(jdField_a_of_type_Boolean);
      QLog.i("QbarNative", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt > 0)
    {
      if (this.jdField_a_of_type_Int < 0) {
        return null;
      }
      QbarNative.QBarResultJNI[] arrayOfQBarResultJNI = new QbarNative.QBarResultJNI[paramInt];
      int j = 0;
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
        GetResults(arrayOfQBarResultJNI, this.jdField_a_of_type_Int);
        localObject1 = new ArrayList();
        i = j;
        for (;;)
        {
          if (i < paramInt)
          {
            Object localObject3 = arrayOfQBarResultJNI[i];
            try
            {
              if ((((QbarNative.QBarResultJNI)localObject3).typeName != null) && (!((QbarNative.QBarResultJNI)localObject3).typeName.isEmpty()))
              {
                QBarResult localQBarResult = new QBarResult();
                localQBarResult.jdField_a_of_type_JavaLangString = ((QbarNative.QBarResultJNI)localObject3).typeName;
                if (((QbarNative.QBarResultJNI)localObject3).charset.equals("ANY"))
                {
                  localQBarResult.b = new String(((QbarNative.QBarResultJNI)localObject3).data, "UTF-8");
                  if (TextUtils.isEmpty(localQBarResult.b)) {
                    localQBarResult.b = new String(((QbarNative.QBarResultJNI)localObject3).data, "ASCII");
                  }
                }
                else
                {
                  localQBarResult.b = new String(((QbarNative.QBarResultJNI)localObject3).data, ((QbarNative.QBarResultJNI)localObject3).charset);
                }
                localQBarResult.jdField_a_of_type_Float = 1.0F;
                if ((this.jdField_b_of_type_Int > 0) && (this.c > 0))
                {
                  float f1;
                  float f2;
                  if (((QbarNative.QBarResultJNI)localObject3).points.point_cnt > 2)
                  {
                    f1 = Math.min(((QbarNative.QBarResultJNI)localObject3).points.x0 / this.jdField_b_of_type_Int, ((QbarNative.QBarResultJNI)localObject3).points.x2 / this.jdField_b_of_type_Int);
                    f2 = Math.max(((QbarNative.QBarResultJNI)localObject3).points.x0 / this.jdField_b_of_type_Int, ((QbarNative.QBarResultJNI)localObject3).points.x2 / this.jdField_b_of_type_Int);
                    localQBarResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF(f1, Math.min(((QbarNative.QBarResultJNI)localObject3).points.y0 / this.c, ((QbarNative.QBarResultJNI)localObject3).points.y2 / this.c), f2, Math.max(((QbarNative.QBarResultJNI)localObject3).points.y0 / this.c, ((QbarNative.QBarResultJNI)localObject3).points.y2 / this.c));
                  }
                  else
                  {
                    f1 = Math.min(((QbarNative.QBarResultJNI)localObject3).points.x0 / this.jdField_b_of_type_Int, ((QbarNative.QBarResultJNI)localObject3).points.x1 / this.jdField_b_of_type_Int);
                    f2 = Math.max(((QbarNative.QBarResultJNI)localObject3).points.x0 / this.jdField_b_of_type_Int, ((QbarNative.QBarResultJNI)localObject3).points.x1 / this.jdField_b_of_type_Int);
                    localQBarResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF(f1 - 0.01F, Math.min(((QbarNative.QBarResultJNI)localObject3).points.y0 / this.c, ((QbarNative.QBarResultJNI)localObject3).points.y1 / this.c) - 0.01F, f2 + 0.01F, Math.max(((QbarNative.QBarResultJNI)localObject3).points.y0 / this.c, ((QbarNative.QBarResultJNI)localObject3).points.y1 / this.c) + 0.01F);
                  }
                }
                else
                {
                  localQBarResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
                }
                ((ArrayList)localObject1).add(localQBarResult);
              }
              i += 1;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("GetResults exp:");
              ((StringBuilder)localObject3).append(localUnsupportedEncodingException.getMessage());
              QLog.e("QbarNative", 1, ((StringBuilder)localObject3).toString());
            }
          }
        }
        return localObject1;
      }
      finally {}
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qbar.QbarNative
 * JD-Core Version:    0.7.0.1
 */
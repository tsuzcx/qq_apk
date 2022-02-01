package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.qrscan.QBarConstants.Reader;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.api.IQRCodeApi;
import com.tencent.mobileqq.qrscan.qrcode.QbarNativeImpl;
import java.util.ArrayList;

public class QRCodeApiImpl
  implements IQRCodeApi
{
  public int getOneResult(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    return QbarNativeImpl.a(paramStringBuilder1, paramStringBuilder2);
  }
  
  public int getOneResultForCamera(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    return QbarNativeImpl.b(paramStringBuilder1, paramStringBuilder2);
  }
  
  public ArrayList<QBarResult> getResult()
  {
    return QbarNativeImpl.a();
  }
  
  public ArrayList<QBarResult> getResultForCamera()
  {
    return QbarNativeImpl.b();
  }
  
  public String getVersion()
  {
    return QbarNativeImpl.c();
  }
  
  public int init(int paramInt, String paramString1, String paramString2)
  {
    return QbarNativeImpl.a(paramInt, paramString1, paramString2);
  }
  
  public int initForCamera(int paramInt, String paramString1, String paramString2)
  {
    return QbarNativeImpl.b(paramInt, paramString1, paramString2);
  }
  
  public boolean isValidScanImageSize(int paramInt1, int paramInt2)
  {
    return QbarNativeImpl.a(paramInt1, paramInt2);
  }
  
  public int release()
  {
    return QbarNativeImpl.d();
  }
  
  public int releaseForCamera()
  {
    return QbarNativeImpl.e();
  }
  
  public int scanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return QbarNativeImpl.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int scanImageForCamera(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return QbarNativeImpl.b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int setReaders(QBarConstants.Reader paramReader)
  {
    return QbarNativeImpl.a(paramReader);
  }
  
  public int setReadersForCamera(QBarConstants.Reader paramReader)
  {
    return QbarNativeImpl.b(paramReader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.QRCodeApiImpl
 * JD-Core Version:    0.7.0.1
 */
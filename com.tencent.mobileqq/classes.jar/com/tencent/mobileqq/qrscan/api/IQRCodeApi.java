package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.QBarConstants.Reader;
import com.tencent.mobileqq.qrscan.QBarResult;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IQRCodeApi
  extends QRouteApi
{
  public abstract int getOneResult(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2);
  
  public abstract int getOneResultForCamera(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2);
  
  public abstract ArrayList<QBarResult> getResult();
  
  public abstract ArrayList<QBarResult> getResultForCamera();
  
  public abstract String getVersion();
  
  public abstract int init(int paramInt, String paramString1, String paramString2);
  
  public abstract int initForCamera(int paramInt, String paramString1, String paramString2);
  
  public abstract boolean isValidScanImageSize(int paramInt1, int paramInt2);
  
  public abstract int release();
  
  public abstract int releaseForCamera();
  
  public abstract int scanImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract int scanImageForCamera(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract int setReaders(QBarConstants.Reader paramReader);
  
  public abstract int setReadersForCamera(QBarConstants.Reader paramReader);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.IQRCodeApi
 * JD-Core Version:    0.7.0.1
 */
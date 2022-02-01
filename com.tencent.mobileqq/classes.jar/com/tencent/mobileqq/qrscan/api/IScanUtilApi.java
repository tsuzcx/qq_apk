package com.tencent.mobileqq.qrscan.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.ScannerResult;

@QAPI(process={"all"})
public abstract interface IScanUtilApi
  extends QRouteApi
{
  public abstract String buildQRScanReportParams(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt);
  
  public abstract Bitmap decodeBitmapFromFile(String paramString, int paramInt1, int paramInt2);
  
  public abstract Bitmap decodeBitmapFromYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract int decodeQQCodeFromBmp(Bitmap paramBitmap, int paramInt, SparseArray<Object> paramSparseArray);
  
  public abstract ScannerResult decodeQQCodeFromBmp(Bitmap paramBitmap, int paramInt);
  
  public abstract int decodeQQCodeFromFile(Uri paramUri, Context paramContext, int paramInt, SparseArray<Object> paramSparseArray);
  
  public abstract ScannerResult decodeQQCodeFromFile(Uri paramUri, Context paramContext, int paramInt, boolean paramBoolean);
  
  public abstract Pair<StringBuilder, StringBuilder> decodeQRCodeFromFile(Uri paramUri, Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.IScanUtilApi
 * JD-Core Version:    0.7.0.1
 */
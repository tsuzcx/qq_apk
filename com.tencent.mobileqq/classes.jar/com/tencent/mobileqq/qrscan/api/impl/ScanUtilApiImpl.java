package com.tencent.mobileqq.qrscan.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qrscan.utils.ScannerUtils;
import com.tencent.mobileqq.qrscan.utils.Util;

public class ScanUtilApiImpl
  implements IScanUtilApi
{
  public String buildQRScanReportParams(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    return ScannerUtils.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt);
  }
  
  public Bitmap decodeBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    return Util.a(paramString, paramInt1, paramInt2);
  }
  
  public Bitmap decodeBitmapFromYuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return Util.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int decodeQQCodeFromBmp(Bitmap paramBitmap, int paramInt, SparseArray<Object> paramSparseArray)
  {
    return ScannerUtils.a(paramBitmap, paramInt, paramSparseArray);
  }
  
  public ScannerResult decodeQQCodeFromBmp(Bitmap paramBitmap, int paramInt)
  {
    return ScannerUtils.a(paramBitmap, paramInt);
  }
  
  public int decodeQQCodeFromFile(Uri paramUri, Context paramContext, int paramInt, SparseArray<Object> paramSparseArray)
  {
    return ScannerUtils.a(paramUri, paramContext, paramInt, paramSparseArray);
  }
  
  public ScannerResult decodeQQCodeFromFile(Uri paramUri, Context paramContext, int paramInt, boolean paramBoolean)
  {
    return ScannerUtils.a(paramUri, paramContext, paramInt, paramBoolean);
  }
  
  public Pair<StringBuilder, StringBuilder> decodeQRCodeFromFile(Uri paramUri, Context paramContext)
  {
    return ScannerUtils.a(paramUri, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.ScanUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */
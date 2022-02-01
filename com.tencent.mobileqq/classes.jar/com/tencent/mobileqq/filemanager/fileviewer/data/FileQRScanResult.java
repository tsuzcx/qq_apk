package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qrscan.utils.QRUtils;

public class FileQRScanResult
{
  private final String a;
  private final int b;
  private final SparseArray<Object> c;
  
  public FileQRScanResult(String paramString, int paramInt, @NonNull SparseArray<Object> paramSparseArray)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramSparseArray;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public SparseArray<Object> b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return (QRUtils.a(this.b)) || (QRUtils.b(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.FileQRScanResult
 * JD-Core Version:    0.7.0.1
 */
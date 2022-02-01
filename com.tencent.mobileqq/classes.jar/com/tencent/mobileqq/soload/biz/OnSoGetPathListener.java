package com.tencent.mobileqq.soload.biz;

public abstract interface OnSoGetPathListener
{
  public static final int RES_FAIL = 1;
  public static final int RES_FAIL_MD5_NOT_MATCH = 2;
  public static final int RES_SUCC = 0;
  
  public abstract void onResult(int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.OnSoGetPathListener
 * JD-Core Version:    0.7.0.1
 */
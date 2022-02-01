package com.tencent.sveffects;

import java.util.HashMap;

public abstract interface Reporter
{
  public abstract void reportToBeacon(String paramString, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap);
  
  public abstract void reportToCompass(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sveffects.Reporter
 * JD-Core Version:    0.7.0.1
 */
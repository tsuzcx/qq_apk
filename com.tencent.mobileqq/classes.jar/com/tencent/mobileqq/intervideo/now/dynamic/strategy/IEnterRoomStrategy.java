package com.tencent.mobileqq.intervideo.now.dynamic.strategy;

import android.os.Bundle;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import java.util.Map;

public abstract interface IEnterRoomStrategy
{
  public abstract BusinessConfig a(Bundle paramBundle, String paramString);
  
  public abstract String a(Bundle paramBundle);
  
  public abstract void a(Bundle paramBundle, IDoneCallback paramIDoneCallback);
  
  public abstract boolean a(Bundle paramBundle);
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.strategy.IEnterRoomStrategy
 * JD-Core Version:    0.7.0.1
 */
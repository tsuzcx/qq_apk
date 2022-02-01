package com.tencent.qqlive.tvkplayer.tools.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;

public abstract interface ITVKHttpProcessor
{
  public abstract void deleteAsync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt, @NonNull ITVKHttpProcessor.ITVKHttpCallback paramITVKHttpCallback);
  
  public abstract ITVKHttpProcessor.HttpResponse deleteSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt);
  
  public abstract void getAsync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt, @NonNull ITVKHttpProcessor.ITVKHttpCallback paramITVKHttpCallback);
  
  public abstract ITVKHttpProcessor.HttpResponse getSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt);
  
  public abstract void httpGetCommonSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, int paramInt, @NonNull ITVKHttpProcessor.IWriteCallback paramIWriteCallback);
  
  public abstract void httpPostCommonSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, @NonNull ITVKHttpProcessor.IWriteCallback paramIWriteCallback);
  
  public abstract void postAsync(@NonNull String paramString, @Nullable Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte, int paramInt, @NonNull ITVKHttpProcessor.ITVKHttpCallback paramITVKHttpCallback);
  
  public abstract ITVKHttpProcessor.HttpResponse postSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte, int paramInt);
  
  public abstract void putAsync(@NonNull String paramString, @Nullable Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte, int paramInt, @NonNull ITVKHttpProcessor.ITVKHttpCallback paramITVKHttpCallback);
  
  public abstract void putSync(@NonNull String paramString, @Nullable Map<String, String> paramMap, @NonNull byte[] paramArrayOfByte, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor
 * JD-Core Version:    0.7.0.1
 */
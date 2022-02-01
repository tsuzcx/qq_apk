package com.tencent.mobileqq.dinifly.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.InputStream;

public abstract interface LottieFetchResult
  extends Closeable
{
  @NonNull
  public abstract InputStream bodyByteStream();
  
  @Nullable
  public abstract String contentType();
  
  @Nullable
  public abstract String error();
  
  public abstract boolean isSuccessful();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.network.LottieFetchResult
 * JD-Core Version:    0.7.0.1
 */
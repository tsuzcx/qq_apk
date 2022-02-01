package com.tencent.qqmusic.mediaplayer.upstream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface IDataSourceFactory
{
  @NonNull
  public abstract IDataSource createDataSource();
  
  @Nullable
  public abstract INativeDataSource createNativeDataSource();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
 * JD-Core Version:    0.7.0.1
 */
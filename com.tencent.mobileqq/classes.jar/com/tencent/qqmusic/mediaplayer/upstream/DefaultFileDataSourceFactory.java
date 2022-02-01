package com.tencent.qqmusic.mediaplayer.upstream;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DefaultFileDataSourceFactory
  implements IDataSourceFactory
{
  private final String filePath;
  
  public DefaultFileDataSourceFactory(String paramString)
  {
    this.filePath = paramString;
  }
  
  @NonNull
  public IDataSource createDataSource()
  {
    if (!TextUtils.isEmpty(this.filePath)) {
      return new FileDataSource(this.filePath);
    }
    throw new DataSourceException(-5, "filePath is empty!", null);
  }
  
  @Nullable
  public INativeDataSource createNativeDataSource()
  {
    return NativeDataSourceFactory.fileDataSource(this.filePath, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DefaultFileDataSourceFactory
 * JD-Core Version:    0.7.0.1
 */
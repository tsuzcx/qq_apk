package com.tencent.qqmusic.mediaplayer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;

class CommonPlayer$3
  implements IDataSourceFactory
{
  CommonPlayer$3(CommonPlayer paramCommonPlayer, UriLoader paramUriLoader) {}
  
  @NonNull
  public IDataSource createDataSource()
  {
    return CacheDataSource.Factory.createFromUriLoader(this.val$uriLoader);
  }
  
  @Nullable
  public INativeDataSource createNativeDataSource()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer.3
 * JD-Core Version:    0.7.0.1
 */
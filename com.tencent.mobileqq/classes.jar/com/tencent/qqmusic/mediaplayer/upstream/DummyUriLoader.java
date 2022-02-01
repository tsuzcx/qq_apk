package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.concurrent.TimeUnit;

public class DummyUriLoader
  implements UriLoader
{
  @Nullable
  private final Uri uri;
  
  public DummyUriLoader()
  {
    this(null);
  }
  
  public DummyUriLoader(@Nullable Uri paramUri)
  {
    this.uri = paramUri;
  }
  
  public void cancelLoading() {}
  
  public boolean isLoading()
  {
    return false;
  }
  
  public void startLoading(int paramInt, TimeUnit paramTimeUnit, UriLoader.Callback paramCallback)
  {
    paramTimeUnit = this.uri;
    if (paramTimeUnit == null)
    {
      paramCallback.onSucceed(null);
      return;
    }
    paramCallback.onSucceed(new StreamingRequest(paramTimeUnit, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DummyUriLoader
 * JD-Core Version:    0.7.0.1
 */
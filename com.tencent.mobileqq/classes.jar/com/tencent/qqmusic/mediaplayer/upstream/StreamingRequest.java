package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

public class StreamingRequest
{
  @Nullable
  public final Map<String, String> headers;
  @NonNull
  public final Uri uri;
  
  public StreamingRequest(@NonNull Uri paramUri, @Nullable Map<String, String> paramMap)
  {
    this.uri = paramUri;
    this.headers = paramMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StreamingRequest{uri='");
    localStringBuilder.append(this.uri);
    localStringBuilder.append('\'');
    localStringBuilder.append(", headers=");
    localStringBuilder.append(this.headers);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.StreamingRequest
 * JD-Core Version:    0.7.0.1
 */
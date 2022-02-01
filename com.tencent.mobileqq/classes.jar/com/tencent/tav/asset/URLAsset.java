package com.tencent.tav.asset;

import android.support.annotation.NonNull;
import java.net.URL;
import java.util.List;

public final class URLAsset
  extends Asset
{
  public String audiovisualMIMETypes;
  public String audiovisualTypes;
  
  public URLAsset(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public URLAsset(URL paramURL)
  {
    super(paramURL);
  }
  
  public String getAudiovisualMIMETypes()
  {
    return this.audiovisualMIMETypes;
  }
  
  public String getAudiovisualTypes()
  {
    return this.audiovisualTypes;
  }
  
  public void loadValuesAsynchronouslyForKeys(List<String> paramList, AsynchronousKeyValueLoading.loadCallback paramloadCallback) {}
  
  public int statusOfValueForKey(String paramString)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.asset.URLAsset
 * JD-Core Version:    0.7.0.1
 */
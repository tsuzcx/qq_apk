package com.tencent.shadow.core.runtime;

import android.net.Uri;
import android.os.Bundle;

public abstract interface UriParseDelegate
{
  public abstract Uri parse(String paramString);
  
  public abstract Uri parseCall(String paramString, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.UriParseDelegate
 * JD-Core Version:    0.7.0.1
 */
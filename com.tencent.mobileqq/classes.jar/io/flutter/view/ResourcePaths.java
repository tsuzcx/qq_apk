package io.flutter.view;

import android.content.Context;
import java.io.File;

class ResourcePaths
{
  public static final String TEMPORARY_RESOURCE_PREFIX = ".org.chromium.Chromium.";
  
  public static File createTempFile(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return File.createTempFile(".org.chromium.Chromium.", localStringBuilder.toString(), paramContext.getCacheDir());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.view.ResourcePaths
 * JD-Core Version:    0.7.0.1
 */
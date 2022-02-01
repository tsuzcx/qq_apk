package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import java.lang.ref.WeakReference;

public class MediaUtils
{
  private static final String TAG = "MediaUtils";
  
  public static void getImageForVideo(WeakReference<IMiniAppContext> paramWeakReference, String paramString, MediaUtils.OnLoadVideoImageListener paramOnLoadVideoImageListener)
  {
    new MediaUtils.LoadVideoImageTask(paramWeakReference, paramOnLoadVideoImageListener).execute(new String[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MediaUtils
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public class MediaUtils
{
  private static final String TAG = "MediaUtils";
  
  public static void getImageForVideo(IMiniAppContext paramIMiniAppContext, String paramString, MediaUtils.OnLoadVideoImageListener paramOnLoadVideoImageListener)
  {
    new MediaUtils.LoadVideoImageTask(paramIMiniAppContext, paramOnLoadVideoImageListener).execute(new String[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MediaUtils
 * JD-Core Version:    0.7.0.1
 */
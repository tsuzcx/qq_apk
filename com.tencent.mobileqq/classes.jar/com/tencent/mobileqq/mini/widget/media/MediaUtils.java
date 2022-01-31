package com.tencent.mobileqq.mini.widget.media;

public class MediaUtils
{
  private static final String TAG = "MediaUtils";
  
  public static void getImageForVideo(String paramString, MediaUtils.OnLoadVideoImageListener paramOnLoadVideoImageListener)
  {
    new MediaUtils.LoadVideoImageTask(paramOnLoadVideoImageListener).execute(new String[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MediaUtils
 * JD-Core Version:    0.7.0.1
 */
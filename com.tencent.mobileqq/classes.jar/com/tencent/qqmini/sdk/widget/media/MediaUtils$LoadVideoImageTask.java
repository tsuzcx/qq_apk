package com.tencent.qqmini.sdk.widget.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.util.Log;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

public class MediaUtils$LoadVideoImageTask
  extends AsyncTask<String, Integer, File>
{
  private MediaUtils.OnLoadVideoImageListener listener;
  private IMiniAppContext miniAppContext;
  
  public MediaUtils$LoadVideoImageTask(IMiniAppContext paramIMiniAppContext, MediaUtils.OnLoadVideoImageListener paramOnLoadVideoImageListener)
  {
    this.listener = paramOnLoadVideoImageListener;
    this.miniAppContext = paramIMiniAppContext;
  }
  
  protected File doInBackground(String... paramVarArgs)
  {
    MediaMetadataRetriever localMediaMetadataRetriever;
    Bitmap localBitmap;
    try
    {
      localMediaMetadataRetriever = new MediaMetadataRetriever();
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs.startsWith("http")) || (paramVarArgs.startsWith("https"))) {
        localMediaMetadataRetriever.setDataSource(paramVarArgs, new HashMap());
      }
      for (;;)
      {
        localBitmap = localMediaMetadataRetriever.getFrameAtTime();
        if (this.miniAppContext != null) {
          break;
        }
        return null;
        localMediaMetadataRetriever.setDataSource(paramVarArgs);
      }
      localFile = new File(((MiniAppFileManager)this.miniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("jpg"));
    }
    catch (Exception paramVarArgs)
    {
      QMLog.e("MediaUtils", "getImageForVideo error." + paramVarArgs);
      return null;
    }
    File localFile;
    if (localFile.exists()) {
      localFile.delete();
    }
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 90, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      localMediaMetadataRetriever.release();
      return localFile;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MediaUtils", "doInBackground: " + paramVarArgs, localException);
      }
    }
  }
  
  protected void onPostExecute(File paramFile)
  {
    super.onPostExecute(paramFile);
    if (this.listener != null) {
      this.listener.onLoadImage(paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MediaUtils.LoadVideoImageTask
 * JD-Core Version:    0.7.0.1
 */
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
import java.io.OutputStream;
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
    try
    {
      localObject1 = new MediaMetadataRetriever();
      paramVarArgs = paramVarArgs[0];
      if ((!paramVarArgs.startsWith("http")) && (!paramVarArgs.startsWith("https"))) {
        ((MediaMetadataRetriever)localObject1).setDataSource(paramVarArgs);
      } else {
        ((MediaMetadataRetriever)localObject1).setDataSource(paramVarArgs, new HashMap());
      }
      Bitmap localBitmap = ((MediaMetadataRetriever)localObject1).getFrameAtTime();
      if (this.miniAppContext == null) {
        return null;
      }
      File localFile = new File(((MiniAppFileManager)this.miniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("jpg"));
      if (localFile.exists()) {
        localFile.delete();
      }
      try
      {
        localObject2 = new FileOutputStream(localFile);
        localBitmap.compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)localObject2);
        ((FileOutputStream)localObject2).flush();
        ((FileOutputStream)localObject2).close();
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doInBackground: ");
        ((StringBuilder)localObject2).append(paramVarArgs);
        Log.i("MediaUtils", ((StringBuilder)localObject2).toString(), localException);
      }
      ((MediaMetadataRetriever)localObject1).release();
      return localFile;
    }
    catch (Exception paramVarArgs)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getImageForVideo error.");
      ((StringBuilder)localObject1).append(paramVarArgs);
      QMLog.e("MediaUtils", ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  protected void onPostExecute(File paramFile)
  {
    super.onPostExecute(paramFile);
    MediaUtils.OnLoadVideoImageListener localOnLoadVideoImageListener = this.listener;
    if (localOnLoadVideoImageListener != null) {
      localOnLoadVideoImageListener.onLoadImage(paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MediaUtils.LoadVideoImageTask
 * JD-Core Version:    0.7.0.1
 */
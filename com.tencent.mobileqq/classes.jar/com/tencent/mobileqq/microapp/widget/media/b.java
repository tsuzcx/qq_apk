package com.tencent.mobileqq.microapp.widget.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public final class b
  extends AsyncTask
{
  private c a;
  
  public b(c paramc)
  {
    this.a = paramc;
  }
  
  protected File a(String... paramVarArgs)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    paramVarArgs = paramVarArgs[0];
    if ((!paramVarArgs.startsWith("http")) && (!paramVarArgs.startsWith("https"))) {
      localMediaMetadataRetriever.setDataSource(paramVarArgs);
    } else {
      localMediaMetadataRetriever.setDataSource(paramVarArgs, new HashMap());
    }
    Bitmap localBitmap = localMediaMetadataRetriever.getFrameAtTime();
    paramVarArgs = new File(com.tencent.mobileqq.microapp.appbrand.b.b.a().a("jpg"));
    if (paramVarArgs.exists()) {
      paramVarArgs.delete();
    }
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramVarArgs);
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 90, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
    localMediaMetadataRetriever.release();
    return paramVarArgs;
  }
  
  protected void a(File paramFile)
  {
    super.onPostExecute(paramFile);
    c localc = this.a;
    if (localc != null) {
      localc.a(paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.b
 * JD-Core Version:    0.7.0.1
 */
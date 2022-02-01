package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.app.ThreadManagerExecutor;

public class SavePicTask
  extends AsyncTask<Void, Void, Boolean>
{
  private URLDrawable.DownloadListener a;
  private Bitmap b;
  private String c;
  
  public SavePicTask(Bitmap paramBitmap, String paramString)
  {
    this.b = paramBitmap;
    this.c = paramString;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    return Boolean.valueOf(BitmapUtils.a(this.b, this.c));
  }
  
  public void a()
  {
    executeOnExecutor(ThreadManagerExecutor.getExecutorService(64), null);
  }
  
  public void a(URLDrawable.DownloadListener paramDownloadListener)
  {
    this.a = paramDownloadListener;
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    if (this.a == null) {
      return;
    }
    if (paramBoolean.booleanValue())
    {
      this.a.onFileDownloadSucceed(0L);
      return;
    }
    this.a.onFileDownloadFailed(0);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    URLDrawable.DownloadListener localDownloadListener = this.a;
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadStarted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SavePicTask
 * JD-Core Version:    0.7.0.1
 */
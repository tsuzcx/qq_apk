package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.app.ThreadManagerExecutor;

public class SavePicTask
  extends AsyncTask<Void, Void, Boolean>
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private URLDrawable.DownloadListener jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener;
  private String jdField_a_of_type_JavaLangString;
  
  public SavePicTask(Bitmap paramBitmap, String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    return Boolean.valueOf(BitmapUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_JavaLangString));
  }
  
  public void a()
  {
    executeOnExecutor(ThreadManagerExecutor.getExecutorService(64), null);
  }
  
  public void a(URLDrawable.DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener = paramDownloadListener;
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener == null) {
      return;
    }
    if (paramBoolean.booleanValue())
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener.onFileDownloadSucceed(0L);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener.onFileDownloadFailed(0);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    URLDrawable.DownloadListener localDownloadListener = this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener;
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadStarted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SavePicTask
 * JD-Core Version:    0.7.0.1
 */
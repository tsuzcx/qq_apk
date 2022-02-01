package org.light.utils;

import android.os.AsyncTask;
import java.io.InputStream;

class FileUtils$FileCopyTask
  extends AsyncTask<String, String, Boolean>
{
  String mDestPath;
  FileUtils.OnFileCopyListener mListener;
  InputStream mSrcInputStream;
  
  FileUtils$FileCopyTask(InputStream paramInputStream, String paramString)
  {
    this.mSrcInputStream = paramInputStream;
    this.mDestPath = paramString;
  }
  
  protected Boolean doInBackground(String... paramVarArgs)
  {
    return Boolean.valueOf(FileUtils.copyFile(this.mSrcInputStream, this.mDestPath));
  }
  
  protected void onPostExecute(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    if (this.mListener != null)
    {
      if (paramBoolean.booleanValue())
      {
        this.mListener.onCopySuccess();
        return;
      }
      this.mListener.onCopyFailed();
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    FileUtils.OnFileCopyListener localOnFileCopyListener = this.mListener;
    if (localOnFileCopyListener != null) {
      localOnFileCopyListener.onCopyStart();
    }
  }
  
  public void setOnFileCopyListener(FileUtils.OnFileCopyListener paramOnFileCopyListener)
  {
    this.mListener = paramOnFileCopyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.utils.FileUtils.FileCopyTask
 * JD-Core Version:    0.7.0.1
 */
package io.flutter.view;

import android.os.AsyncTask;
import java.io.File;

class ResourceCleaner$CleanTask
  extends AsyncTask<Void, Void, Void>
{
  private final File[] mFilesToDelete;
  
  ResourceCleaner$CleanTask(File[] paramArrayOfFile)
  {
    this.mFilesToDelete = paramArrayOfFile;
  }
  
  private void deleteRecursively(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        deleteRecursively(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = this.mFilesToDelete;
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Void localVoid = paramVarArgs[i];
      if (localVoid.exists()) {
        deleteRecursively(localVoid);
      }
      i += 1;
    }
    return null;
  }
  
  boolean hasFilesToDelete()
  {
    return (this.mFilesToDelete != null) && (this.mFilesToDelete.length > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.view.ResourceCleaner.CleanTask
 * JD-Core Version:    0.7.0.1
 */
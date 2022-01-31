package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import java.io.File;

class ResourceCleaner
{
  private static final long DELAY_MS = 5000L;
  private static final String TAG = "ResourceCleaner";
  private final Context mContext;
  
  ResourceCleaner(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  void start()
  {
    Object localObject = this.mContext.getCacheDir();
    if (localObject == null) {}
    do
    {
      return;
      localObject = new ResourceCleaner.CleanTask(((File)localObject).listFiles(new ResourceCleaner.1(this)));
    } while (!((ResourceCleaner.CleanTask)localObject).hasFilesToDelete());
    new Handler().postDelayed(new ResourceCleaner.2(this, (ResourceCleaner.CleanTask)localObject), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.view.ResourceCleaner
 * JD-Core Version:    0.7.0.1
 */
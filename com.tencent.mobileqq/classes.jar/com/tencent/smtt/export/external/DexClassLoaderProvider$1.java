package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.ArrayList;
import java.util.TimerTask;

final class DexClassLoaderProvider$1
  extends TimerTask
{
  DexClassLoaderProvider$1(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(4);
      localArrayList.add(0, this.val$dexName);
      localArrayList.add(1, this.val$dexPath);
      localArrayList.add(2, this.val$optimizedDirectory);
      localArrayList.add(3, this.val$libraryPath);
      Intent localIntent = new Intent(DexClassLoaderProvider.access$000(), DexClassLoaderProviderService.class);
      localIntent.putStringArrayListExtra("dex2oat", localArrayList);
      DexClassLoaderProvider.access$000().startService(localIntent);
      Log.d("dexloader", "shouldUseDexLoaderService(" + this.val$dexName + ", " + localIntent + ")");
      return;
    }
    catch (SecurityException localSecurityException)
    {
      Log.e("dexloader", "start DexLoaderService exception", localSecurityException);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("dexloader", "after shouldUseDexLoaderService exception: " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProvider.1
 * JD-Core Version:    0.7.0.1
 */
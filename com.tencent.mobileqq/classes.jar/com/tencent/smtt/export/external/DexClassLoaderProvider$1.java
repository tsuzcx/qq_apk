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
      localObject = new ArrayList(4);
      ((ArrayList)localObject).add(0, this.val$dexName);
      ((ArrayList)localObject).add(1, this.val$dexPath);
      ((ArrayList)localObject).add(2, this.val$optimizedDirectory);
      ((ArrayList)localObject).add(3, this.val$libraryPath);
      Intent localIntent = new Intent(DexClassLoaderProvider.access$000(), DexClassLoaderProviderService.class);
      localIntent.putStringArrayListExtra("dex2oat", (ArrayList)localObject);
      DexClassLoaderProvider.access$000().startService(localIntent);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shouldUseDexLoaderService(");
      ((StringBuilder)localObject).append(this.val$dexName);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(localIntent);
      ((StringBuilder)localObject).append(")");
      Log.d("dexloader", ((StringBuilder)localObject).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("after shouldUseDexLoaderService exception: ");
      ((StringBuilder)localObject).append(localThrowable);
      Log.e("dexloader", ((StringBuilder)localObject).toString());
      return;
    }
    catch (SecurityException localSecurityException)
    {
      Log.e("dexloader", "start DexLoaderService exception", localSecurityException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProvider.1
 * JD-Core Version:    0.7.0.1
 */
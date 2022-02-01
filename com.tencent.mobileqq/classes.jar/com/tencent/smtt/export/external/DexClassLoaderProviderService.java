package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;

public class DexClassLoaderProviderService
  extends Service
{
  private static final String LOGTAG = "dexloader";
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    Log.d("dexloader", "DexClassLoaderProviderService -- onCreate()");
    DexClassLoaderProvider.setForceLoadDexFlag(true, this);
  }
  
  public void onDestroy()
  {
    Log.d("dexloader", "DexClassLoaderProviderService -- onDestroy()");
    System.exit(0);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("DexClassLoaderProviderService -- onStartCommand(");
    ((StringBuilder)localObject1).append(paramIntent);
    ((StringBuilder)localObject1).append(")");
    Log.d("dexloader", ((StringBuilder)localObject1).toString());
    if (paramIntent == null) {
      return 1;
    }
    try
    {
      Object localObject2 = paramIntent.getStringArrayListExtra("dex2oat");
      if (localObject2 == null) {
        return 1;
      }
      Object localObject3 = (String)((ArrayList)localObject2).get(0);
      paramIntent = (String)((ArrayList)localObject2).get(1);
      localObject1 = (String)((ArrayList)localObject2).get(2);
      localObject2 = (String)((ArrayList)localObject2).get(3);
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("DexClassLoaderProviderService -- onStartCommand(");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(")");
      Log.d("dexloader", ((StringBuilder)localObject4).toString());
      localObject3 = getClassLoader();
      localObject4 = new File((String)localObject1);
      if (!((File)localObject4).exists()) {
        ((File)localObject4).mkdirs();
      }
      DexClassLoaderProvider.createDexClassLoader(paramIntent, (String)localObject1, (String)localObject2, (ClassLoader)localObject3, getApplicationContext());
      return 1;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProviderService
 * JD-Core Version:    0.7.0.1
 */
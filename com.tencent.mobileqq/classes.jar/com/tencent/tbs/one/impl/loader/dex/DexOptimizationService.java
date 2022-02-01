package com.tencent.tbs.one.impl.loader.dex;

import android.app.Service;
import android.content.Intent;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.optional.TBSOneStandaloneService.ServiceImpl;

public class DexOptimizationService
  extends TBSOneStandaloneService.ServiceImpl
{
  public static final String DEX_NAME_KEY = "dexName";
  public static final String DEX_PATH_KEY = "dexPath";
  public static final String LIBRARY_SEARCH_PATH_KEY = "librarySearchPath";
  public static final String OPTIMIZED_DIRECTORY_KEY = "optimizedDirectory";
  
  public void onDestroy()
  {
    super.onDestroy();
    System.exit(0);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      String str1 = paramIntent.getStringExtra("dexPath");
      String str2 = paramIntent.getStringExtra("dexName");
      String str3 = paramIntent.getStringExtra("optimizedDirectory");
      paramIntent = paramIntent.getStringExtra("librarySearchPath");
      long l = System.currentTimeMillis();
      Logging.i("Optimizing dex %s in standalone service", new Object[] { str1 });
      DexUtils.optimizeDex(str2, str1, str3, paramIntent, this.mBaseService.getClassLoader());
      Logging.i("Optimized dex %s in standalone service, cost %dms", new Object[] { str1, Long.valueOf(System.currentTimeMillis() - l) });
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.dex.DexOptimizationService
 * JD-Core Version:    0.7.0.1
 */
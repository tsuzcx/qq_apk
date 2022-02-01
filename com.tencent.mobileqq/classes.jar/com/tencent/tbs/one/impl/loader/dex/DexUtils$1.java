package com.tencent.tbs.one.impl.loader.dex;

import android.content.Context;
import android.content.Intent;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.optional.TBSOneStandaloneService;
import java.io.File;

final class DexUtils$1
  implements Runnable
{
  DexUtils$1(File paramFile, Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    Logging.i("Starting standalone service to optimize dex %s", new Object[] { this.val$dexFile.getAbsolutePath() });
    Intent localIntent = new Intent(this.val$context, TBSOneStandaloneService.class);
    localIntent.putExtra("implClassName", DexOptimizationService.class.getName());
    localIntent.putExtra("dexPath", this.val$dexFile.getAbsolutePath());
    localIntent.putExtra("dexName", this.val$dexFile.getName());
    localIntent.putExtra("optimizedDirectory", this.val$optimizedDirectory);
    localIntent.putExtra("librarySearchPath", this.val$librarySearchPath);
    this.val$context.startService(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.dex.DexUtils.1
 * JD-Core Version:    0.7.0.1
 */
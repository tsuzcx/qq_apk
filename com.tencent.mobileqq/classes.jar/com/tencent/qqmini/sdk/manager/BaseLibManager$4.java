package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.util.List;
import java.util.Map;

class BaseLibManager$4
  implements DownloaderProxy.DownloadListener
{
  BaseLibManager$4(BaseLibManager paramBaseLibManager, BaseLibManager.UpdateListener paramUpdateListener, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    QMLog.i("miniapp-process_BaseLibManager", "ApkgManager--onDownloadFailed");
    if (this.val$listener != null) {
      this.val$listener.onUpdateResult(1101);
    }
    for (;;)
    {
      MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 617, null, null, null, 1101);
      return;
      BaseLibManager.access$400(this.this$0, 1101);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  /* Error */
  public void onDownloadSucceed(int paramInt, String paramString, com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: ldc 40
    //   2: ldc 84
    //   4: invokestatic 48	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: invokestatic 60	com/tencent/qqmini/sdk/core/ReportConst:miniAppConfigForPreload	()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   10: iconst_5
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: iconst_0
    //   15: invokestatic 66	com/tencent/qqmini/sdk/report/MiniReportManager:reportEventType	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   18: invokestatic 60	com/tencent/qqmini/sdk/core/ReportConst:miniAppConfigForPreload	()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   21: bipush 6
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: iconst_0
    //   27: invokestatic 66	com/tencent/qqmini/sdk/report/MiniReportManager:reportEventType	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   30: aload_0
    //   31: getfield 20	com/tencent/qqmini/sdk/manager/BaseLibManager$4:this$0	Lcom/tencent/qqmini/sdk/manager/BaseLibManager;
    //   34: aload_0
    //   35: getfield 24	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$url	Ljava/lang/String;
    //   38: aload_0
    //   39: getfield 26	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$version	Ljava/lang/String;
    //   42: invokevirtual 88	com/tencent/qqmini/sdk/manager/BaseLibManager:getBaseLibDir	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_2
    //   46: new 90	java/io/File
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore_3
    //   55: aload_0
    //   56: getfield 20	com/tencent/qqmini/sdk/manager/BaseLibManager$4:this$0	Lcom/tencent/qqmini/sdk/manager/BaseLibManager;
    //   59: aload_3
    //   60: invokevirtual 97	com/tencent/qqmini/sdk/manager/BaseLibManager:isBaseLibDirValid	(Ljava/io/File;)Z
    //   63: ifeq +189 -> 252
    //   66: ldc 40
    //   68: ldc 99
    //   70: invokestatic 48	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 26	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$version	Ljava/lang/String;
    //   77: aload_0
    //   78: getfield 28	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$oldVersion	Ljava/lang/String;
    //   81: invokestatic 105	com/tencent/qqmini/sdk/launcher/model/BaseLibInfo:needUpdateVersion	(Ljava/lang/String;Ljava/lang/String;)Z
    //   84: ifeq +92 -> 176
    //   87: ldc 40
    //   89: new 107	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   96: ldc 110
    //   98: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: getfield 28	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$oldVersion	Ljava/lang/String;
    //   105: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 116
    //   110: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 26	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$version	Ljava/lang/String;
    //   117: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 48	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: invokestatic 126	com/tencent/qqmini/sdk/launcher/utils/StorageUtil:getPreference	()Landroid/content/SharedPreferences;
    //   129: invokeinterface 132 1 0
    //   134: ldc 134
    //   136: aload_0
    //   137: getfield 24	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$url	Ljava/lang/String;
    //   140: invokeinterface 140 3 0
    //   145: invokeinterface 144 1 0
    //   150: pop
    //   151: invokestatic 126	com/tencent/qqmini/sdk/launcher/utils/StorageUtil:getPreference	()Landroid/content/SharedPreferences;
    //   154: invokeinterface 132 1 0
    //   159: ldc 146
    //   161: aload_0
    //   162: getfield 26	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$version	Ljava/lang/String;
    //   165: invokeinterface 140 3 0
    //   170: invokeinterface 144 1 0
    //   175: pop
    //   176: aload_0
    //   177: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   180: ifnull +23 -> 203
    //   183: aload_0
    //   184: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   187: iconst_0
    //   188: invokeinterface 54 2 0
    //   193: aload_0
    //   194: getfield 30	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$downloadZipPath	Ljava/lang/String;
    //   197: iconst_1
    //   198: invokestatic 152	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   201: pop2
    //   202: return
    //   203: aload_0
    //   204: getfield 20	com/tencent/qqmini/sdk/manager/BaseLibManager$4:this$0	Lcom/tencent/qqmini/sdk/manager/BaseLibManager;
    //   207: iconst_0
    //   208: invokestatic 72	com/tencent/qqmini/sdk/manager/BaseLibManager:access$400	(Lcom/tencent/qqmini/sdk/manager/BaseLibManager;I)V
    //   211: goto -18 -> 193
    //   214: astore_2
    //   215: ldc 154
    //   217: ldc 156
    //   219: aload_2
    //   220: invokestatic 160	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   223: aload_0
    //   224: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   227: ifnull +68 -> 295
    //   230: aload_0
    //   231: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   234: sipush 1103
    //   237: invokeinterface 54 2 0
    //   242: aload_0
    //   243: getfield 30	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$downloadZipPath	Ljava/lang/String;
    //   246: iconst_1
    //   247: invokestatic 152	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   250: pop2
    //   251: return
    //   252: aload_0
    //   253: getfield 20	com/tencent/qqmini/sdk/manager/BaseLibManager$4:this$0	Lcom/tencent/qqmini/sdk/manager/BaseLibManager;
    //   256: aload_2
    //   257: aload_3
    //   258: aload_0
    //   259: getfield 30	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$downloadZipPath	Ljava/lang/String;
    //   262: aload_0
    //   263: getfield 24	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$url	Ljava/lang/String;
    //   266: aload_0
    //   267: getfield 26	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$version	Ljava/lang/String;
    //   270: aload_0
    //   271: getfield 32	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$oldUrl	Ljava/lang/String;
    //   274: aload_0
    //   275: getfield 28	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$oldVersion	Ljava/lang/String;
    //   278: aload_0
    //   279: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   282: invokestatic 164	com/tencent/qqmini/sdk/manager/BaseLibManager:access$500	(Lcom/tencent/qqmini/sdk/manager/BaseLibManager;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;)V
    //   285: aload_0
    //   286: getfield 30	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$downloadZipPath	Ljava/lang/String;
    //   289: iconst_1
    //   290: invokestatic 152	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   293: pop2
    //   294: return
    //   295: aload_0
    //   296: getfield 20	com/tencent/qqmini/sdk/manager/BaseLibManager$4:this$0	Lcom/tencent/qqmini/sdk/manager/BaseLibManager;
    //   299: sipush 1103
    //   302: invokestatic 72	com/tencent/qqmini/sdk/manager/BaseLibManager:access$400	(Lcom/tencent/qqmini/sdk/manager/BaseLibManager;I)V
    //   305: goto -63 -> 242
    //   308: astore_2
    //   309: aload_0
    //   310: getfield 30	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$downloadZipPath	Ljava/lang/String;
    //   313: iconst_1
    //   314: invokestatic 152	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   317: pop2
    //   318: aload_2
    //   319: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	4
    //   0	320	1	paramInt	int
    //   0	320	2	paramString	String
    //   0	320	3	paramDownloadResult	com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult
    // Exception table:
    //   from	to	target	type
    //   30	176	214	java/lang/Exception
    //   176	193	214	java/lang/Exception
    //   203	211	214	java/lang/Exception
    //   252	285	214	java/lang/Exception
    //   30	176	308	finally
    //   176	193	308	finally
    //   203	211	308	finally
    //   215	242	308	finally
    //   252	285	308	finally
    //   295	305	308	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.4
 * JD-Core Version:    0.7.0.1
 */
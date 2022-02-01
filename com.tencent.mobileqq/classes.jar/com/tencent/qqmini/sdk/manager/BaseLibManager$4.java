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
    paramString = this.val$listener;
    if (paramString != null) {
      paramString.onUpdateResult(1101);
    } else {
      BaseLibManager.access$400(this.this$0, 1101);
    }
    MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 617, null, null, null, 1101);
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
    //   7: invokestatic 66	com/tencent/qqmini/sdk/core/ReportConst:miniAppConfigForPreload	()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   10: iconst_5
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: iconst_0
    //   15: invokestatic 72	com/tencent/qqmini/sdk/report/MiniReportManager:reportEventType	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   18: invokestatic 66	com/tencent/qqmini/sdk/core/ReportConst:miniAppConfigForPreload	()Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   21: bipush 6
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: iconst_0
    //   27: invokestatic 72	com/tencent/qqmini/sdk/report/MiniReportManager:reportEventType	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
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
    //   63: ifeq +161 -> 224
    //   66: ldc 40
    //   68: ldc 99
    //   70: invokestatic 48	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 26	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$version	Ljava/lang/String;
    //   77: aload_0
    //   78: getfield 28	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$oldVersion	Ljava/lang/String;
    //   81: invokestatic 105	com/tencent/qqmini/sdk/launcher/model/BaseLibInfo:needUpdateVersion	(Ljava/lang/String;Ljava/lang/String;)Z
    //   84: ifeq +102 -> 186
    //   87: new 107	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   94: astore_2
    //   95: aload_2
    //   96: ldc 110
    //   98: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_2
    //   103: aload_0
    //   104: getfield 28	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$oldVersion	Ljava/lang/String;
    //   107: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_2
    //   112: ldc 116
    //   114: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_2
    //   119: aload_0
    //   120: getfield 26	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$version	Ljava/lang/String;
    //   123: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc 40
    //   129: aload_2
    //   130: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 48	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: invokestatic 126	com/tencent/qqmini/sdk/launcher/utils/StorageUtil:getPreference	()Landroid/content/SharedPreferences;
    //   139: invokeinterface 132 1 0
    //   144: ldc 134
    //   146: aload_0
    //   147: getfield 24	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$url	Ljava/lang/String;
    //   150: invokeinterface 140 3 0
    //   155: invokeinterface 144 1 0
    //   160: pop
    //   161: invokestatic 126	com/tencent/qqmini/sdk/launcher/utils/StorageUtil:getPreference	()Landroid/content/SharedPreferences;
    //   164: invokeinterface 132 1 0
    //   169: ldc 146
    //   171: aload_0
    //   172: getfield 26	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$version	Ljava/lang/String;
    //   175: invokeinterface 140 3 0
    //   180: invokeinterface 144 1 0
    //   185: pop
    //   186: aload_0
    //   187: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   190: ifnull +16 -> 206
    //   193: aload_0
    //   194: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   197: iconst_0
    //   198: invokeinterface 54 2 0
    //   203: goto +11 -> 214
    //   206: aload_0
    //   207: getfield 20	com/tencent/qqmini/sdk/manager/BaseLibManager$4:this$0	Lcom/tencent/qqmini/sdk/manager/BaseLibManager;
    //   210: iconst_0
    //   211: invokestatic 60	com/tencent/qqmini/sdk/manager/BaseLibManager:access$400	(Lcom/tencent/qqmini/sdk/manager/BaseLibManager;I)V
    //   214: aload_0
    //   215: getfield 30	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$downloadZipPath	Ljava/lang/String;
    //   218: iconst_1
    //   219: invokestatic 152	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   222: pop2
    //   223: return
    //   224: aload_0
    //   225: getfield 20	com/tencent/qqmini/sdk/manager/BaseLibManager$4:this$0	Lcom/tencent/qqmini/sdk/manager/BaseLibManager;
    //   228: aload_2
    //   229: aload_3
    //   230: aload_0
    //   231: getfield 30	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$downloadZipPath	Ljava/lang/String;
    //   234: aload_0
    //   235: getfield 24	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$url	Ljava/lang/String;
    //   238: aload_0
    //   239: getfield 26	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$version	Ljava/lang/String;
    //   242: aload_0
    //   243: getfield 32	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$oldUrl	Ljava/lang/String;
    //   246: aload_0
    //   247: getfield 28	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$oldVersion	Ljava/lang/String;
    //   250: aload_0
    //   251: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   254: invokestatic 156	com/tencent/qqmini/sdk/manager/BaseLibManager:access$500	(Lcom/tencent/qqmini/sdk/manager/BaseLibManager;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;)V
    //   257: goto +48 -> 305
    //   260: astore_2
    //   261: goto +54 -> 315
    //   264: astore_2
    //   265: ldc 158
    //   267: ldc 160
    //   269: aload_2
    //   270: invokestatic 164	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   273: aload_0
    //   274: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   277: ifnull +18 -> 295
    //   280: aload_0
    //   281: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   284: sipush 1103
    //   287: invokeinterface 54 2 0
    //   292: goto +13 -> 305
    //   295: aload_0
    //   296: getfield 20	com/tencent/qqmini/sdk/manager/BaseLibManager$4:this$0	Lcom/tencent/qqmini/sdk/manager/BaseLibManager;
    //   299: sipush 1103
    //   302: invokestatic 60	com/tencent/qqmini/sdk/manager/BaseLibManager:access$400	(Lcom/tencent/qqmini/sdk/manager/BaseLibManager;I)V
    //   305: aload_0
    //   306: getfield 30	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$downloadZipPath	Ljava/lang/String;
    //   309: iconst_1
    //   310: invokestatic 152	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   313: pop2
    //   314: return
    //   315: aload_0
    //   316: getfield 30	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$downloadZipPath	Ljava/lang/String;
    //   319: iconst_1
    //   320: invokestatic 152	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   323: pop2
    //   324: aload_2
    //   325: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	this	4
    //   0	326	1	paramInt	int
    //   0	326	2	paramString	String
    //   0	326	3	paramDownloadResult	com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult
    // Exception table:
    //   from	to	target	type
    //   30	186	260	finally
    //   186	203	260	finally
    //   206	214	260	finally
    //   224	257	260	finally
    //   265	292	260	finally
    //   295	305	260	finally
    //   30	186	264	java/lang/Exception
    //   186	203	264	java/lang/Exception
    //   206	214	264	java/lang/Exception
    //   224	257	264	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.4
 * JD-Core Version:    0.7.0.1
 */
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
    //   63: ifeq +153 -> 216
    //   66: ldc 40
    //   68: ldc 99
    //   70: invokestatic 48	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 26	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$version	Ljava/lang/String;
    //   77: aload_0
    //   78: getfield 28	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$oldVersion	Ljava/lang/String;
    //   81: invokestatic 105	com/tencent/qqmini/sdk/launcher/model/BaseLibInfo:needUpdateVersion	(Ljava/lang/String;Ljava/lang/String;)Z
    //   84: ifeq +94 -> 178
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
    //   144: astore_2
    //   145: aload_2
    //   146: ldc 134
    //   148: aload_0
    //   149: getfield 24	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$url	Ljava/lang/String;
    //   152: invokeinterface 140 3 0
    //   157: pop
    //   158: aload_2
    //   159: ldc 142
    //   161: aload_0
    //   162: getfield 26	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$version	Ljava/lang/String;
    //   165: invokeinterface 140 3 0
    //   170: pop
    //   171: aload_2
    //   172: invokeinterface 146 1 0
    //   177: pop
    //   178: aload_0
    //   179: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   182: ifnull +16 -> 198
    //   185: aload_0
    //   186: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   189: iconst_0
    //   190: invokeinterface 54 2 0
    //   195: goto +11 -> 206
    //   198: aload_0
    //   199: getfield 20	com/tencent/qqmini/sdk/manager/BaseLibManager$4:this$0	Lcom/tencent/qqmini/sdk/manager/BaseLibManager;
    //   202: iconst_0
    //   203: invokestatic 60	com/tencent/qqmini/sdk/manager/BaseLibManager:access$400	(Lcom/tencent/qqmini/sdk/manager/BaseLibManager;I)V
    //   206: aload_0
    //   207: getfield 30	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$downloadZipPath	Ljava/lang/String;
    //   210: iconst_1
    //   211: invokestatic 152	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   214: pop2
    //   215: return
    //   216: aload_0
    //   217: getfield 20	com/tencent/qqmini/sdk/manager/BaseLibManager$4:this$0	Lcom/tencent/qqmini/sdk/manager/BaseLibManager;
    //   220: aload_2
    //   221: aload_3
    //   222: aload_0
    //   223: getfield 30	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$downloadZipPath	Ljava/lang/String;
    //   226: aload_0
    //   227: getfield 24	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$url	Ljava/lang/String;
    //   230: aload_0
    //   231: getfield 26	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$version	Ljava/lang/String;
    //   234: aload_0
    //   235: getfield 32	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$oldUrl	Ljava/lang/String;
    //   238: aload_0
    //   239: getfield 28	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$oldVersion	Ljava/lang/String;
    //   242: aload_0
    //   243: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   246: invokestatic 156	com/tencent/qqmini/sdk/manager/BaseLibManager:access$500	(Lcom/tencent/qqmini/sdk/manager/BaseLibManager;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;)V
    //   249: goto +48 -> 297
    //   252: astore_2
    //   253: goto +54 -> 307
    //   256: astore_2
    //   257: ldc 158
    //   259: ldc 160
    //   261: aload_2
    //   262: invokestatic 164	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   265: aload_0
    //   266: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   269: ifnull +18 -> 287
    //   272: aload_0
    //   273: getfield 22	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$listener	Lcom/tencent/qqmini/sdk/manager/BaseLibManager$UpdateListener;
    //   276: sipush 1103
    //   279: invokeinterface 54 2 0
    //   284: goto +13 -> 297
    //   287: aload_0
    //   288: getfield 20	com/tencent/qqmini/sdk/manager/BaseLibManager$4:this$0	Lcom/tencent/qqmini/sdk/manager/BaseLibManager;
    //   291: sipush 1103
    //   294: invokestatic 60	com/tencent/qqmini/sdk/manager/BaseLibManager:access$400	(Lcom/tencent/qqmini/sdk/manager/BaseLibManager;I)V
    //   297: aload_0
    //   298: getfield 30	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$downloadZipPath	Ljava/lang/String;
    //   301: iconst_1
    //   302: invokestatic 152	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   305: pop2
    //   306: return
    //   307: aload_0
    //   308: getfield 30	com/tencent/qqmini/sdk/manager/BaseLibManager$4:val$downloadZipPath	Ljava/lang/String;
    //   311: iconst_1
    //   312: invokestatic 152	com/tencent/qqmini/sdk/core/utils/FileUtils:delete	(Ljava/lang/String;Z)J
    //   315: pop2
    //   316: aload_2
    //   317: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	4
    //   0	318	1	paramInt	int
    //   0	318	2	paramString	String
    //   0	318	3	paramDownloadResult	com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult
    // Exception table:
    //   from	to	target	type
    //   30	178	252	finally
    //   178	195	252	finally
    //   198	206	252	finally
    //   216	249	252	finally
    //   257	284	252	finally
    //   287	297	252	finally
    //   30	178	256	java/lang/Exception
    //   178	195	256	java/lang/Exception
    //   198	206	256	java/lang/Exception
    //   216	249	256	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.4
 * JD-Core Version:    0.7.0.1
 */
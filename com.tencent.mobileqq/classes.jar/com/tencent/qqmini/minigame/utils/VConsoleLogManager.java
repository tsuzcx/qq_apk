package com.tencent.qqmini.minigame.utils;

import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import com.tencent.qqmini.minigame.ui.VConsoleDragView;
import com.tencent.qqmini.minigame.ui.VConsoleDragView.Listener;
import com.tencent.qqmini.minigame.ui.VConsoleView;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.concurrent.ArrayBlockingQueue;

public class VConsoleLogManager
  implements VConsoleDragView.Listener
{
  public static final String ERROR = "error";
  public static final String INFO = "info";
  public static final String LOG = "log";
  private static final int MAX_QUEUE_CAPACITY = 1000;
  public static final String TAG = "[minigame] VConsoleLogManager";
  public static final String WARN = "warn";
  private boolean hasRequestedToOpenPanel = false;
  private boolean isLogSystemReady = false;
  private boolean isPrintingLogs = false;
  private boolean isVConsoleOpened;
  private View.OnClickListener mOnvConsoleBtn = new VConsoleLogManager.1(this);
  private ArrayBlockingQueue queue = new ArrayBlockingQueue(1000);
  String url = "file:///android_asset/mini/mini_vconsole.html";
  private VConsoleDragView vConsoleBtn;
  private View vConsoleGap;
  private VConsoleView vConsoleLayout;
  private WebView vConsoleWebView;
  
  private void evaluateJavascript(String paramString)
  {
    ThreadManager.getUIHandler().post(new VConsoleLogManager.4(this, paramString));
  }
  
  private void injectLogInterface(String paramString1, String paramString2)
  {
    if (this.vConsoleWebView == null)
    {
      QMLog.e("[minigame] VConsoleLogManager", "consoleWebView is not ready");
      return;
    }
    ThreadManager.getUIHandler().post(new VConsoleLogManager.3(this, paramString1, paramString2));
  }
  
  private void invokeHideOrShowPanel()
  {
    if (this.vConsoleWebView != null)
    {
      VConsoleView localVConsoleView = this.vConsoleLayout;
      if (localVConsoleView == null) {
        return;
      }
      if (this.isLogSystemReady)
      {
        int i;
        if (this.isVConsoleOpened) {
          i = 8;
        } else {
          i = 0;
        }
        localVConsoleView.setVisibility(i);
        this.isVConsoleOpened ^= true;
      }
      else
      {
        this.hasRequestedToOpenPanel = (this.isVConsoleOpened ^ true);
      }
      this.vConsoleBtn.bringToFront();
    }
  }
  
  private void printLog()
  {
    this.isPrintingLogs = true;
    for (Pair localPair = (Pair)this.queue.poll(); localPair != null; localPair = (Pair)this.queue.poll()) {
      injectLogInterface((String)localPair.first, (String)localPair.second);
    }
    this.isPrintingLogs = false;
  }
  
  private void setLogSystemReady(boolean paramBoolean)
  {
    this.isLogSystemReady = paramBoolean;
    evaluateJavascript("javascript:showPannel()");
    if (this.hasRequestedToOpenPanel)
    {
      VConsoleView localVConsoleView = this.vConsoleLayout;
      int i;
      if (this.isVConsoleOpened) {
        i = 8;
      } else {
        i = 0;
      }
      localVConsoleView.setVisibility(i);
      this.isVConsoleOpened ^= true;
    }
    printLog();
  }
  
  /* Error */
  public void injectLog(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 165
    //   3: ldc 167
    //   5: invokevirtual 171	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8: ldc 173
    //   10: ldc 175
    //   12: invokevirtual 171	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   15: ldc 175
    //   17: ldc 173
    //   19: invokevirtual 171	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   22: astore_3
    //   23: aload_3
    //   24: astore_2
    //   25: aload_3
    //   26: ldc 177
    //   28: invokevirtual 181	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   31: ifeq +29 -> 60
    //   34: new 183	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 184	java/lang/StringBuilder:<init>	()V
    //   41: astore_2
    //   42: aload_2
    //   43: aload_3
    //   44: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: ldc 177
    //   51: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_2
    //   56: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_2
    //   60: ldc 2
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 58	com/tencent/qqmini/minigame/utils/VConsoleLogManager:queue	Ljava/util/concurrent/ArrayBlockingQueue;
    //   67: ifnonnull +17 -> 84
    //   70: aload_0
    //   71: new 53	java/util/concurrent/ArrayBlockingQueue
    //   74: dup
    //   75: sipush 1000
    //   78: invokespecial 56	java/util/concurrent/ArrayBlockingQueue:<init>	(I)V
    //   81: putfield 58	com/tencent/qqmini/minigame/utils/VConsoleLogManager:queue	Ljava/util/concurrent/ArrayBlockingQueue;
    //   84: aload_0
    //   85: getfield 58	com/tencent/qqmini/minigame/utils/VConsoleLogManager:queue	Ljava/util/concurrent/ArrayBlockingQueue;
    //   88: invokevirtual 196	java/util/concurrent/ArrayBlockingQueue:size	()I
    //   91: sipush 1000
    //   94: if_icmpne +11 -> 105
    //   97: aload_0
    //   98: getfield 58	com/tencent/qqmini/minigame/utils/VConsoleLogManager:queue	Ljava/util/concurrent/ArrayBlockingQueue;
    //   101: invokevirtual 143	java/util/concurrent/ArrayBlockingQueue:poll	()Ljava/lang/Object;
    //   104: pop
    //   105: aload_0
    //   106: getfield 58	com/tencent/qqmini/minigame/utils/VConsoleLogManager:queue	Ljava/util/concurrent/ArrayBlockingQueue;
    //   109: new 145	android/util/Pair
    //   112: dup
    //   113: aload_1
    //   114: aload_2
    //   115: invokespecial 199	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   118: invokevirtual 203	java/util/concurrent/ArrayBlockingQueue:add	(Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_0
    //   123: getfield 62	com/tencent/qqmini/minigame/utils/VConsoleLogManager:isLogSystemReady	Z
    //   126: ifeq +30 -> 156
    //   129: aload_0
    //   130: getfield 60	com/tencent/qqmini/minigame/utils/VConsoleLogManager:isPrintingLogs	Z
    //   133: ifne +23 -> 156
    //   136: aload_0
    //   137: invokespecial 160	com/tencent/qqmini/minigame/utils/VConsoleLogManager:printLog	()V
    //   140: goto +16 -> 156
    //   143: astore_1
    //   144: goto +16 -> 160
    //   147: astore_1
    //   148: ldc 22
    //   150: ldc 205
    //   152: aload_1
    //   153: invokestatic 208	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   156: ldc 2
    //   158: monitorexit
    //   159: return
    //   160: ldc 2
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	VConsoleLogManager
    //   0	165	1	paramString1	String
    //   0	165	2	paramString2	String
    //   22	22	3	str	String
    // Exception table:
    //   from	to	target	type
    //   63	84	143	finally
    //   84	105	143	finally
    //   105	140	143	finally
    //   148	156	143	finally
    //   156	159	143	finally
    //   160	163	143	finally
    //   63	84	147	java/lang/Throwable
    //   84	105	147	java/lang/Throwable
    //   105	140	147	java/lang/Throwable
  }
  
  public void onVConsoleMoveUp()
  {
    invokeHideOrShowPanel();
  }
  
  public void updateVconsoleView(VConsoleView paramVConsoleView, VConsoleDragView paramVConsoleDragView, boolean paramBoolean)
  {
    this.vConsoleLayout = paramVConsoleView;
    this.vConsoleBtn = paramVConsoleDragView;
    this.vConsoleBtn.bringToFront();
    this.vConsoleBtn.setListener(this);
    this.vConsoleWebView = paramVConsoleView.vConsoleWebView;
    this.vConsoleWebView.loadUrl(this.url);
    this.vConsoleWebView.setWebViewClient(new VConsoleLogManager.2(this));
    this.isVConsoleOpened = false;
    paramVConsoleView.setOnClickListener(this.mOnvConsoleBtn);
    this.vConsoleGap = paramVConsoleView.vConsoleGap;
    this.vConsoleGap.setOnClickListener(this.mOnvConsoleBtn);
    if (paramBoolean) {
      invokeHideOrShowPanel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.VConsoleLogManager
 * JD-Core Version:    0.7.0.1
 */
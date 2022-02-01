package com.tencent.mobileqq.minigame.utils;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.minigame.ui.VConsoleDragView;
import com.tencent.mobileqq.minigame.ui.VConsoleDragView.Listener;
import com.tencent.mobileqq.minigame.ui.VConsoleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.concurrent.ArrayBlockingQueue;
import mqq.os.MqqHandler;

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
  private View.OnClickListener mOnvConsoleBtn = new VConsoleLogManager.2(this);
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
      QLog.e("[minigame] VConsoleLogManager", 2, "consoleWebView is not ready");
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
    //   1: ldc 166
    //   3: ldc 168
    //   5: invokevirtual 172	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   8: ldc 174
    //   10: ldc 176
    //   12: invokevirtual 172	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   15: ldc 176
    //   17: ldc 174
    //   19: invokevirtual 172	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   22: astore_3
    //   23: aload_3
    //   24: astore_2
    //   25: aload_3
    //   26: ldc 178
    //   28: invokevirtual 182	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   31: ifeq +29 -> 60
    //   34: new 184	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   41: astore_2
    //   42: aload_2
    //   43: aload_3
    //   44: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: ldc 178
    //   51: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_2
    //   56: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_2
    //   60: ldc 2
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 54	com/tencent/mobileqq/minigame/utils/VConsoleLogManager:queue	Ljava/util/concurrent/ArrayBlockingQueue;
    //   67: ifnonnull +17 -> 84
    //   70: aload_0
    //   71: new 49	java/util/concurrent/ArrayBlockingQueue
    //   74: dup
    //   75: sipush 1000
    //   78: invokespecial 52	java/util/concurrent/ArrayBlockingQueue:<init>	(I)V
    //   81: putfield 54	com/tencent/mobileqq/minigame/utils/VConsoleLogManager:queue	Ljava/util/concurrent/ArrayBlockingQueue;
    //   84: aload_0
    //   85: getfield 54	com/tencent/mobileqq/minigame/utils/VConsoleLogManager:queue	Ljava/util/concurrent/ArrayBlockingQueue;
    //   88: invokevirtual 197	java/util/concurrent/ArrayBlockingQueue:size	()I
    //   91: sipush 1000
    //   94: if_icmpne +11 -> 105
    //   97: aload_0
    //   98: getfield 54	com/tencent/mobileqq/minigame/utils/VConsoleLogManager:queue	Ljava/util/concurrent/ArrayBlockingQueue;
    //   101: invokevirtual 144	java/util/concurrent/ArrayBlockingQueue:poll	()Ljava/lang/Object;
    //   104: pop
    //   105: aload_0
    //   106: getfield 54	com/tencent/mobileqq/minigame/utils/VConsoleLogManager:queue	Ljava/util/concurrent/ArrayBlockingQueue;
    //   109: new 146	com/tencent/util/Pair
    //   112: dup
    //   113: aload_1
    //   114: aload_2
    //   115: invokespecial 200	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   118: invokevirtual 204	java/util/concurrent/ArrayBlockingQueue:add	(Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_0
    //   123: getfield 58	com/tencent/mobileqq/minigame/utils/VConsoleLogManager:isLogSystemReady	Z
    //   126: ifeq +31 -> 157
    //   129: aload_0
    //   130: getfield 56	com/tencent/mobileqq/minigame/utils/VConsoleLogManager:isPrintingLogs	Z
    //   133: ifne +24 -> 157
    //   136: aload_0
    //   137: invokespecial 161	com/tencent/mobileqq/minigame/utils/VConsoleLogManager:printLog	()V
    //   140: goto +17 -> 157
    //   143: astore_1
    //   144: goto +17 -> 161
    //   147: astore_1
    //   148: ldc 22
    //   150: iconst_1
    //   151: ldc 206
    //   153: aload_1
    //   154: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   157: ldc 2
    //   159: monitorexit
    //   160: return
    //   161: ldc 2
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	VConsoleLogManager
    //   0	166	1	paramString1	String
    //   0	166	2	paramString2	String
    //   22	22	3	str	String
    // Exception table:
    //   from	to	target	type
    //   63	84	143	finally
    //   84	105	143	finally
    //   105	140	143	finally
    //   148	157	143	finally
    //   157	160	143	finally
    //   161	164	143	finally
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
    this.vConsoleWebView.setWebViewClient(new VConsoleLogManager.1(this));
    this.isVConsoleOpened = false;
    paramVConsoleView.setOnClickListener(this.mOnvConsoleBtn);
    this.vConsoleGap = paramVConsoleView.vConsoleGap;
    this.vConsoleGap.setOnClickListener(this.mOnvConsoleBtn);
    if (paramBoolean) {
      invokeHideOrShowPanel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.VConsoleLogManager
 * JD-Core Version:    0.7.0.1
 */
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
  private boolean hasRequestedToOpenPanel;
  private boolean isLogSystemReady;
  private boolean isPrintingLogs;
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
    boolean bool1 = true;
    boolean bool2 = false;
    if ((this.vConsoleWebView == null) || (this.vConsoleLayout == null)) {
      return;
    }
    if (this.isLogSystemReady)
    {
      VConsoleView localVConsoleView = this.vConsoleLayout;
      if (this.isVConsoleOpened) {}
      for (int i = 8;; i = 0)
      {
        localVConsoleView.setVisibility(i);
        bool1 = bool2;
        if (!this.isVConsoleOpened) {
          bool1 = true;
        }
        this.isVConsoleOpened = bool1;
        this.vConsoleBtn.bringToFront();
        return;
      }
    }
    if (!this.isVConsoleOpened) {}
    for (;;)
    {
      this.hasRequestedToOpenPanel = bool1;
      break;
      bool1 = false;
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
    boolean bool = false;
    this.isLogSystemReady = paramBoolean;
    evaluateJavascript("javascript:showPannel()");
    VConsoleView localVConsoleView;
    if (this.hasRequestedToOpenPanel)
    {
      localVConsoleView = this.vConsoleLayout;
      if (!this.isVConsoleOpened) {
        break label63;
      }
    }
    label63:
    for (int i = 8;; i = 0)
    {
      localVConsoleView.setVisibility(i);
      paramBoolean = bool;
      if (!this.isVConsoleOpened) {
        paramBoolean = true;
      }
      this.isVConsoleOpened = paramBoolean;
      printLog();
      return;
    }
  }
  
  public void injectLog(String paramString1, String paramString2)
  {
    String str = paramString2.replace("\n", "\\r\\n").replace("\\\"", "\"").replace("\"", "\\\"");
    paramString2 = str;
    if (str.endsWith("\\")) {
      paramString2 = str + "\\";
    }
    try
    {
      if (this.queue == null) {
        this.queue = new ArrayBlockingQueue(1000);
      }
      if (this.queue.size() == 1000) {
        this.queue.poll();
      }
      this.queue.add(new Pair(paramString1, paramString2));
      if ((this.isLogSystemReady) && (!this.isPrintingLogs)) {
        printLog();
      }
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        QLog.e("[minigame] VConsoleLogManager", 1, "injectLog error", paramString1);
      }
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.VConsoleLogManager
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qmethodmonitor.monitor;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import androidx.annotation.RequiresApi;

public class ClipboardMonitor
{
  private static final String TAG = "ClipboardMonitor";
  public static final int THRESHOLD = 30;
  public static final int TIMEOUT = 10000;
  
  @RequiresApi(api=28)
  public static void clearPrimaryClip(ClipboardManager paramClipboardManager)
  {
    paramClipboardManager.clearPrimaryClip();
    InvokeMonitor.onMethodInvoke("ClipboardMonitor", "clearPrimaryClip", "");
  }
  
  public static ClipData getPrimaryClip(ClipboardManager paramClipboardManager)
  {
    InvokeMonitor.onMethodInvoke("ClipboardMonitor", "getPrimaryClip", "");
    return paramClipboardManager.getPrimaryClip();
  }
  
  public static ClipDescription getPrimaryClipDescription(ClipboardManager paramClipboardManager)
  {
    InvokeMonitor.onMethodInvoke("ClipboardMonitor", "getPrimaryClipDescription", "");
    return paramClipboardManager.getPrimaryClipDescription();
  }
  
  public static CharSequence getText(ClipboardManager paramClipboardManager)
  {
    InvokeMonitor.onMethodInvoke("ClipboardMonitor", "getText", "");
    return paramClipboardManager.getText();
  }
  
  public static boolean hasPrimaryClip(ClipboardManager paramClipboardManager)
  {
    InvokeMonitor.onMethodInvoke("ClipboardMonitor", "hasPrimaryClip", "");
    return paramClipboardManager.hasPrimaryClip();
  }
  
  public static boolean hasText(ClipboardManager paramClipboardManager)
  {
    InvokeMonitor.onMethodInvoke("ClipboardMonitor", "hasText", "");
    return paramClipboardManager.hasText();
  }
  
  public static void setPrimaryClip(ClipboardManager paramClipboardManager, ClipData paramClipData)
  {
    paramClipboardManager.setPrimaryClip(paramClipData);
    InvokeMonitor.onMethodInvoke("ClipboardMonitor", "setPrimaryClip", "");
  }
  
  public static void setText(ClipboardManager paramClipboardManager, CharSequence paramCharSequence)
  {
    InvokeMonitor.onMethodInvoke("ClipboardMonitor", "setText", "");
    paramClipboardManager.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor
 * JD-Core Version:    0.7.0.1
 */
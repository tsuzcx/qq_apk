package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

final class ThreadedInputConnectionProxyAdapterView
  extends View
{
  private InputConnection cachedConnection;
  final View containerView;
  final Handler imeHandler;
  private boolean isLocked = false;
  final View rootView;
  final View targetView;
  private boolean triggerDelayed = true;
  final IBinder windowToken;
  
  ThreadedInputConnectionProxyAdapterView(View paramView1, View paramView2, Handler paramHandler)
  {
    super(paramView1.getContext());
    this.imeHandler = paramHandler;
    this.containerView = paramView1;
    this.targetView = paramView2;
    this.windowToken = paramView1.getWindowToken();
    this.rootView = paramView1.getRootView();
    setFocusable(true);
    setFocusableInTouchMode(true);
    setVisibility(0);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    return true;
  }
  
  public Handler getHandler()
  {
    return this.imeHandler;
  }
  
  public View getRootView()
  {
    return this.rootView;
  }
  
  public IBinder getWindowToken()
  {
    return this.windowToken;
  }
  
  public boolean hasWindowFocus()
  {
    return true;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  boolean isTriggerDelayed()
  {
    return this.triggerDelayed;
  }
  
  public boolean onCheckIsTextEditor()
  {
    return true;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    this.triggerDelayed = false;
    if (this.isLocked) {
      paramEditorInfo = this.cachedConnection;
    } else {
      paramEditorInfo = this.targetView.onCreateInputConnection(paramEditorInfo);
    }
    this.triggerDelayed = true;
    this.cachedConnection = paramEditorInfo;
    return paramEditorInfo;
  }
  
  void setLocked(boolean paramBoolean)
  {
    this.isLocked = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.ThreadedInputConnectionProxyAdapterView
 * JD-Core Version:    0.7.0.1
 */
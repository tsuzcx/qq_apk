package com.tencent.turingfd.sdk.xq;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public abstract class Lacerta
  implements Window.Callback
{
  public final Window.Callback a;
  
  public Lacerta(Window.Callback paramCallback)
  {
    if (paramCallback != null)
    {
      this.a = paramCallback;
      return;
    }
    throw new IllegalArgumentException("Window callback may not be null");
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return this.a.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return this.a.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return this.a.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return this.a.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  /* Error */
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 41	com/tencent/turingfd/sdk/xq/Leo
    //   4: astore 5
    //   6: aload 5
    //   8: getfield 45	com/tencent/turingfd/sdk/xq/Leo:b	Lcom/tencent/turingfd/sdk/xq/LeoMinor;
    //   11: astore 4
    //   13: aload 5
    //   15: getfield 49	com/tencent/turingfd/sdk/xq/Leo:c	Ljava/lang/String;
    //   18: astore 5
    //   20: aload 4
    //   22: checkcast 51	com/tencent/turingfd/sdk/xq/Draco$if
    //   25: invokevirtual 55	java/lang/Object:getClass	()Ljava/lang/Class;
    //   28: pop
    //   29: getstatic 60	com/tencent/turingfd/sdk/xq/Equuleus:c	Ljava/lang/Object;
    //   32: astore 6
    //   34: aload 6
    //   36: monitorenter
    //   37: getstatic 63	com/tencent/turingfd/sdk/xq/Equuleus:b	I
    //   40: istore_2
    //   41: iload_2
    //   42: ifle +40 -> 82
    //   45: getstatic 66	com/tencent/turingfd/sdk/xq/Equuleus:a	Lcom/tencent/turingfd/sdk/xq/Equuleus;
    //   48: astore 4
    //   50: aload 4
    //   52: getfield 69	com/tencent/turingfd/sdk/xq/Equuleus:d	Lcom/tencent/turingfd/sdk/xq/Equuleus;
    //   55: putstatic 66	com/tencent/turingfd/sdk/xq/Equuleus:a	Lcom/tencent/turingfd/sdk/xq/Equuleus;
    //   58: aload 4
    //   60: aconst_null
    //   61: putfield 69	com/tencent/turingfd/sdk/xq/Equuleus:d	Lcom/tencent/turingfd/sdk/xq/Equuleus;
    //   64: aload 4
    //   66: iconst_0
    //   67: putfield 73	com/tencent/turingfd/sdk/xq/Equuleus:e	Z
    //   70: iload_2
    //   71: iconst_1
    //   72: isub
    //   73: putstatic 63	com/tencent/turingfd/sdk/xq/Equuleus:b	I
    //   76: aload 6
    //   78: monitorexit
    //   79: goto +15 -> 94
    //   82: new 57	com/tencent/turingfd/sdk/xq/Equuleus
    //   85: dup
    //   86: invokespecial 74	com/tencent/turingfd/sdk/xq/Equuleus:<init>	()V
    //   89: astore 4
    //   91: aload 6
    //   93: monitorexit
    //   94: aload 4
    //   96: aload 5
    //   98: putfield 77	com/tencent/turingfd/sdk/xq/Equuleus:m	Ljava/lang/String;
    //   101: aload 4
    //   103: aload_1
    //   104: invokevirtual 83	android/view/MotionEvent:getAction	()I
    //   107: putfield 86	com/tencent/turingfd/sdk/xq/Equuleus:f	I
    //   110: aload 4
    //   112: aload_1
    //   113: invokevirtual 89	android/view/MotionEvent:getDeviceId	()I
    //   116: putfield 92	com/tencent/turingfd/sdk/xq/Equuleus:g	I
    //   119: aload 4
    //   121: aload_1
    //   122: iconst_0
    //   123: invokevirtual 96	android/view/MotionEvent:getToolType	(I)I
    //   126: putfield 99	com/tencent/turingfd/sdk/xq/Equuleus:h	I
    //   129: aload 4
    //   131: aload_1
    //   132: invokevirtual 103	android/view/MotionEvent:getRawX	()F
    //   135: putfield 107	com/tencent/turingfd/sdk/xq/Equuleus:i	F
    //   138: aload 4
    //   140: aload_1
    //   141: invokevirtual 110	android/view/MotionEvent:getRawY	()F
    //   144: putfield 113	com/tencent/turingfd/sdk/xq/Equuleus:j	F
    //   147: aload 4
    //   149: aload_1
    //   150: invokevirtual 116	android/view/MotionEvent:getPressure	()F
    //   153: putfield 119	com/tencent/turingfd/sdk/xq/Equuleus:k	F
    //   156: aload 4
    //   158: aload_1
    //   159: invokevirtual 122	android/view/MotionEvent:getSize	()F
    //   162: putfield 125	com/tencent/turingfd/sdk/xq/Equuleus:l	F
    //   165: getstatic 130	com/tencent/turingfd/sdk/xq/Draco:b	Landroid/os/Handler;
    //   168: iconst_1
    //   169: aload 4
    //   171: invokevirtual 136	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   174: invokevirtual 141	android/os/Message:sendToTarget	()V
    //   177: aload_0
    //   178: getfield 15	com/tencent/turingfd/sdk/xq/Lacerta:a	Landroid/view/Window$Callback;
    //   181: aload_1
    //   182: invokeinterface 143 2 0
    //   187: istore_3
    //   188: iload_3
    //   189: ireturn
    //   190: astore_1
    //   191: aload 6
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    //   196: astore_1
    //   197: iconst_1
    //   198: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	Lacerta
    //   0	199	1	paramMotionEvent	MotionEvent
    //   40	33	2	i	int
    //   187	2	3	bool	boolean
    //   11	159	4	localObject1	Object
    //   4	93	5	localObject2	Object
    //   32	160	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	41	190	finally
    //   45	79	190	finally
    //   82	94	190	finally
    //   191	194	190	finally
    //   177	188	196	finally
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return this.a.dispatchTrackballEvent(paramMotionEvent);
  }
  
  public void onActionModeFinished(ActionMode paramActionMode)
  {
    this.a.onActionModeFinished(paramActionMode);
  }
  
  public void onActionModeStarted(ActionMode paramActionMode)
  {
    this.a.onActionModeStarted(paramActionMode);
  }
  
  public void onAttachedToWindow()
  {
    this.a.onAttachedToWindow();
  }
  
  public void onContentChanged()
  {
    this.a.onContentChanged();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return this.a.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    return this.a.onCreatePanelView(paramInt);
  }
  
  public void onDetachedFromWindow()
  {
    this.a.onDetachedFromWindow();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return this.a.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return this.a.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    this.a.onPanelClosed(paramInt, paramMenu);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean)
  {
    this.a.onPointerCaptureChanged(paramBoolean);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return this.a.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
  {
    this.a.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
  }
  
  public boolean onSearchRequested()
  {
    return this.a.onSearchRequested();
  }
  
  public boolean onSearchRequested(SearchEvent paramSearchEvent)
  {
    return this.a.onSearchRequested(paramSearchEvent);
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    try
    {
      this.a.onWindowAttributesChanged(paramLayoutParams);
      return;
    }
    finally {}
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    this.a.onWindowFocusChanged(paramBoolean);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    return this.a.onWindowStartingActionMode(paramCallback);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    return this.a.onWindowStartingActionMode(paramCallback, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Lacerta
 * JD-Core Version:    0.7.0.1
 */
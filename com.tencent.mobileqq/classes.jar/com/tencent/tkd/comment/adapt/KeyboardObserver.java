package com.tencent.tkd.comment.adapt;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class KeyboardObserver
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private static final int DEFAULT_PANEL_HEIGHT = Util.dp2px(300.0F);
  private static final String KEY_PENEL_HEIGHT = "keyPanelHeight";
  private static final int MAX_PANEL_HEIGHT;
  private static final int MIN_PANEL_HEIGHT;
  private static final String PREF_NAME = "tkd_public_comment_keyboardPref";
  private static final int SCREEN_HEIGHT;
  private static final int THRESHOLD = Util.dp2px(100.0F);
  private boolean isKeyboardShowing;
  private int keyboardHeight;
  private OnKeyboardChangeListener listener;
  private int maxBottom;
  private int minBottom;
  private int panelHeight = DEFAULT_PANEL_HEIGHT;
  private SharedPreferences sp;
  private View vTarget;
  
  static
  {
    SCREEN_HEIGHT = Util.getScreenHeight();
    MIN_PANEL_HEIGHT = Util.dp2px(220.0F);
    MAX_PANEL_HEIGHT = Util.dp2px(380.0F);
  }
  
  private void dispatchKeyboardVisibilityChange(boolean paramBoolean)
  {
    if (paramBoolean != this.isKeyboardShowing)
    {
      this.isKeyboardShowing = paramBoolean;
      if (this.listener != null) {
        this.listener.onVisibilityChange(paramBoolean);
      }
    }
  }
  
  private void dispatchPanelHeightChange(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = getPanelHeight();
      if (i != this.panelHeight)
      {
        this.panelHeight = i;
        this.sp.edit().putInt("keyPanelHeight", i).apply();
        if (this.listener != null) {
          this.listener.onPanelHeightChange(i);
        }
      }
    }
  }
  
  private static int getBottomOnScreen(View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 16) && (paramView.getFitsSystemWindows()))
    {
      localObject = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject);
      return ((Rect)localObject).bottom;
    }
    int i = paramView.getHeight();
    Object localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    return i + localObject[1];
  }
  
  private int getPanelHeight()
  {
    if (this.keyboardHeight < MIN_PANEL_HEIGHT) {
      return MIN_PANEL_HEIGHT;
    }
    if (this.keyboardHeight > MAX_PANEL_HEIGHT) {
      return MAX_PANEL_HEIGHT;
    }
    return this.keyboardHeight;
  }
  
  int getDefaultPanelHeight()
  {
    return this.sp.getInt("keyPanelHeight", DEFAULT_PANEL_HEIGHT);
  }
  
  public void onGlobalLayout()
  {
    int i = getBottomOnScreen(this.vTarget);
    boolean bool;
    if (i < SCREEN_HEIGHT - THRESHOLD)
    {
      bool = true;
      this.minBottom = i;
    }
    for (;;)
    {
      if ((this.minBottom > 0) && (this.maxBottom > 0)) {
        this.keyboardHeight = (this.maxBottom - this.minBottom);
      }
      dispatchPanelHeightChange(bool);
      dispatchKeyboardVisibilityChange(bool);
      return;
      bool = false;
      this.maxBottom = i;
    }
  }
  
  void setTarget(View paramView, OnKeyboardChangeListener paramOnKeyboardChangeListener)
  {
    if (paramView == null)
    {
      if (this.vTarget != null) {
        this.vTarget.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      }
      this.listener = null;
      this.sp = null;
      return;
    }
    this.sp = paramView.getContext().getSharedPreferences("tkd_public_comment_keyboardPref", 0);
    this.vTarget = paramView;
    this.listener = paramOnKeyboardChangeListener;
    this.vTarget.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.KeyboardObserver
 * JD-Core Version:    0.7.0.1
 */
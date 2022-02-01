package com.tencent.mtt.hippy.views.modal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class HippyModalHostView
  extends HippyViewGroup
  implements HippyInstanceLifecycleEventListener
{
  static boolean hasCheckStatusBarHeight = false;
  static int mStatusBarHeight = -1;
  private static int statusBarHeight = -1;
  private final int STYLE_THEME_ANIMATED_FADE_DIALOG = 1;
  private final int STYLE_THEME_ANIMATED_SLIDE_DIALOG = 2;
  private final int STYLE_THEME_ANIMATED_SLIDE_FADE_DIALOG = 3;
  private final int STYLE_THEME_FULL_SCREEN_DIALOG = 0;
  private int mAniType = 0;
  private View mContentView;
  private Dialog mDialog;
  private boolean mEnterImmersionStatusBar = false;
  private final HippyModalHostView.DialogRootViewGroup mHostView;
  HippyModalHostView.OnRequestCloseListener mOnRequestCloseListener;
  private DialogInterface.OnShowListener mOnShowListener;
  private boolean mPropertyRequiresNewDialog;
  private boolean mStatusBarTextDarkColor = false;
  private boolean mTransparent = true;
  
  public HippyModalHostView(Context paramContext)
  {
    super(paramContext);
    ((HippyInstanceContext)paramContext).getEngineContext().addInstanceLifecycleEventListener(this);
    this.mHostView = new HippyModalHostView.DialogRootViewGroup(paramContext);
  }
  
  private void dismiss()
  {
    if (isActivityFinishing()) {
      return;
    }
    Dialog localDialog = this.mDialog;
    if (localDialog != null)
    {
      localDialog.dismiss();
      this.mDialog = null;
      ((ViewGroup)this.mHostView.getParent()).removeViewAt(0);
    }
  }
  
  private int getScreenHeight()
  {
    try
    {
      WindowManager localWindowManager = (WindowManager)ContextHolder.getAppContext().getSystemService("window");
      if (localWindowManager.getDefaultDisplay() != null)
      {
        int i = localWindowManager.getDefaultDisplay().getHeight();
        return i;
      }
    }
    catch (SecurityException localSecurityException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getScreenHeight: ");
      localStringBuilder.append(localSecurityException.getMessage());
      LogUtils.d("HippyModalHostView", localStringBuilder.toString());
    }
    return -1;
  }
  
  public static int getStatusBarHeightFromSystem()
  {
    int i = statusBarHeight;
    if (i > 0) {
      return i;
    }
    Object localObject;
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      localObject = localClass.newInstance();
      i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      statusBarHeight = ContextHolder.getAppContext().getResources().getDimensionPixelSize(i);
    }
    catch (Exception localException)
    {
      statusBarHeight = -1;
      localException.printStackTrace();
    }
    if (statusBarHeight < 1) {
      try
      {
        i = ContextHolder.getAppContext().getResources().getIdentifier("statebar_height", "dimen", ContextHolder.getAppContext().getPackageName());
        statusBarHeight = Math.round(ContextHolder.getAppContext().getResources().getDimension(i));
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getStatusBarHeightFromSystem: ");
        ((StringBuilder)localObject).append(localNotFoundException.getMessage());
        LogUtils.d("HippyModalHostView", ((StringBuilder)localObject).toString());
        statusBarHeight = 0;
      }
    }
    return statusBarHeight;
  }
  
  private boolean isActivityFinishing()
  {
    Object localObject = (HippyInstanceContext)getContext();
    if (localObject == null) {
      return true;
    }
    localObject = ((HippyInstanceContext)localObject).getBaseContext();
    if (!(localObject instanceof Activity)) {
      return true;
    }
    return ((Activity)localObject).isFinishing();
  }
  
  private void updateProperties()
  {
    if (this.mTransparent)
    {
      this.mDialog.getWindow().clearFlags(2);
      return;
    }
    this.mDialog.getWindow().setDimAmount(0.5F);
    this.mDialog.getWindow().setFlags(2, 2);
  }
  
  public void addChildrenForAccessibility(ArrayList<View> paramArrayList) {}
  
  public void addView(View paramView, int paramInt)
  {
    this.mHostView.addView(paramView, paramInt);
  }
  
  protected View createContentView(View paramView)
  {
    HippyModalHostView.4 local4 = new HippyModalHostView.4(this, getContext());
    if ((this.mEnterImmersionStatusBar) && (Build.VERSION.SDK_INT < 16))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = (getStatusBarHeightFixed() * -1);
      local4.addView(paramView, localLayoutParams);
    }
    else
    {
      local4.addView(paramView);
    }
    local4.setFitsSystemWindows(false);
    return local4;
  }
  
  protected Dialog createDialog(Context paramContext)
  {
    int i;
    if (paramContext != null) {
      i = paramContext.getResources().getIdentifier("HippyFullScreenDialog", "style", paramContext.getPackageName());
    } else {
      i = 0;
    }
    paramContext = new ReportDialog(paramContext, i);
    if (i == 0)
    {
      Window localWindow = paramContext.getWindow();
      if (localWindow != null)
      {
        localWindow.requestFeature(1);
        localWindow.setBackgroundDrawableResource(17170445);
        localWindow.setLayout(-1, -1);
      }
    }
    return paramContext;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public View getChildAt(int paramInt)
  {
    return this.mHostView.getChildAt(paramInt);
  }
  
  public int getChildCount()
  {
    return this.mHostView.getChildCount();
  }
  
  public Dialog getDialog()
  {
    return this.mDialog;
  }
  
  public int getStatusBarHeightFixed()
  {
    if (mStatusBarHeight == -1)
    {
      mStatusBarHeight = getStatusBarHeightFromSystem();
      hasCheckStatusBarHeight = true;
    }
    return mStatusBarHeight;
  }
  
  public void onInstanceDestroy(int paramInt)
  {
    ((HippyInstanceContext)getContext()).getEngineContext().removeInstanceLifecycleEventListener(this);
    dismiss();
  }
  
  public void onInstanceLoad(int paramInt)
  {
    showOrUpdate();
  }
  
  public void onInstancePause(int paramInt)
  {
    dismiss();
  }
  
  public void onInstanceResume(int paramInt)
  {
    showOrUpdate();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void removeView(View paramView)
  {
    this.mHostView.removeView(paramView);
  }
  
  public void removeViewAt(int paramInt)
  {
    View localView = getChildAt(paramInt);
    this.mHostView.removeView(localView);
  }
  
  public void requestClose()
  {
    HippyModalHostView.OnRequestCloseListener localOnRequestCloseListener = this.mOnRequestCloseListener;
    if (localOnRequestCloseListener != null) {
      localOnRequestCloseListener.onRequestClose(this.mDialog);
    }
  }
  
  protected void setAnimationType(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = -1;
      int j = paramString.hashCode();
      if (j != 3135100)
      {
        if (j != 109526449)
        {
          if ((j == 1089157194) && (paramString.equals("slide_fade"))) {
            i = 2;
          }
        }
        else if (paramString.equals("slide")) {
          i = 1;
        }
      }
      else if (paramString.equals("fade")) {
        i = 0;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            this.mAniType = 0;
          } else {
            this.mAniType = 3;
          }
        }
        else {
          this.mAniType = 2;
        }
      }
      else {
        this.mAniType = 1;
      }
    }
    this.mPropertyRequiresNewDialog = true;
  }
  
  public void setDialogBar(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Window localWindow = this.mDialog.getWindow();
        int j = localWindow.getDecorView().getSystemUiVisibility();
        if (paramBoolean)
        {
          i = 8192;
          localWindow.getDecorView().setSystemUiVisibility(i | j & 0xFFFFDFFF & 0xFFFFFEFF | 0x400);
          if (Build.VERSION.SDK_INT >= 21)
          {
            localWindow.addFlags(-2147483648);
            localWindow.clearFlags(67108864);
            localWindow.setStatusBarColor(0);
            return;
          }
          localWindow.addFlags(67108864);
          localWindow.clearFlags(-2147483648);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      int i = 256;
    }
  }
  
  protected void setEnterImmersionStatusBar(boolean paramBoolean)
  {
    this.mEnterImmersionStatusBar = paramBoolean;
  }
  
  protected void setImmersionStatusBarTextDarkColor(boolean paramBoolean)
  {
    this.mStatusBarTextDarkColor = paramBoolean;
  }
  
  public void setOnRequestCloseListener(HippyModalHostView.OnRequestCloseListener paramOnRequestCloseListener)
  {
    this.mOnRequestCloseListener = paramOnRequestCloseListener;
  }
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    this.mOnShowListener = paramOnShowListener;
  }
  
  protected void setTransparent(boolean paramBoolean)
  {
    this.mTransparent = paramBoolean;
  }
  
  protected void showOrUpdate()
  {
    if (isActivityFinishing()) {
      return;
    }
    if (this.mDialog != null) {
      if (this.mPropertyRequiresNewDialog)
      {
        dismiss();
      }
      else
      {
        updateProperties();
        return;
      }
    }
    this.mPropertyRequiresNewDialog = false;
    this.mDialog = createDialog(getContext());
    this.mContentView = createContentView(this.mHostView);
    this.mDialog.setContentView(this.mContentView);
    updateProperties();
    Dialog localDialog = this.mDialog;
    if ((localDialog != null) && (localDialog.getWindow() != null) && (this.mEnterImmersionStatusBar)) {
      setDialogBar(this.mStatusBarTextDarkColor);
    }
    this.mDialog.setOnShowListener(new HippyModalHostView.1(this));
    this.mDialog.setOnDismissListener(new HippyModalHostView.2(this));
    this.mDialog.setOnKeyListener(new HippyModalHostView.3(this));
    this.mDialog.getWindow().setSoftInputMode(16);
    this.mDialog.show();
    int i = getScreenHeight();
    int j = this.mAniType;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3) {
          return;
        }
        this.mContentView.setAlpha(0.0F);
        if (i == -1) {
          return;
        }
      }
      else if (i == -1)
      {
        return;
      }
      this.mContentView.setTranslationY(i);
    }
    else
    {
      this.mContentView.setAlpha(0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.HippyModalHostView
 * JD-Core Version:    0.7.0.1
 */
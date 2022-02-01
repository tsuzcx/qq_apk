package com.tencent.mtt.hippy.views.modal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
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
  private final int STYLE_THEME_FULL_SCREEN_DIALOG = 0;
  private int mAniType;
  private String mAnimationType;
  private View mContentView;
  private Dialog mDialog;
  private boolean mEnterImmersionStatusBar = false;
  private HippyModalHostView.DialogRootViewGroup mHostView;
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
    if (this.mDialog != null)
    {
      this.mDialog.dismiss();
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
    catch (SecurityException localSecurityException) {}
    return -1;
  }
  
  public static int getStatusBarHeightFromSystem()
  {
    if (statusBarHeight > 0) {
      return statusBarHeight;
    }
    try
    {
      Class localClass = Class.forName("com.android.internal.R$dimen");
      Object localObject = localClass.newInstance();
      i = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
      statusBarHeight = ContextHolder.getAppContext().getResources().getDimensionPixelSize(i);
      if (statusBarHeight >= 1) {}
    }
    catch (Exception localException1)
    {
      try
      {
        int i = ContextHolder.getAppContext().getResources().getIdentifier("statebar_height", "dimen", ContextHolder.getAppContext().getPackageName());
        statusBarHeight = Math.round(ContextHolder.getAppContext().getResources().getDimension(i));
        return statusBarHeight;
        localException1 = localException1;
        statusBarHeight = -1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          statusBarHeight = -1;
          localException2.printStackTrace();
        }
      }
    }
  }
  
  private void updateProperties()
  {
    Object localObject = (HippyInstanceContext)getContext();
    if ((localObject != null) && ((((HippyInstanceContext)localObject).getBaseContext() instanceof Activity)))
    {
      localObject = (Activity)((HippyInstanceContext)localObject).getBaseContext();
      if ((localObject != null) && (((Activity)localObject).isFinishing())) {
        return;
      }
    }
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
    for (;;)
    {
      local4.setFitsSystemWindows(false);
      return local4;
      local4.addView(paramView);
    }
  }
  
  protected Dialog createDialog(Context paramContext)
  {
    int i = 0;
    if (paramContext != null) {
      i = paramContext.getResources().getIdentifier("HippyFullScreenDialog", "style", paramContext.getPackageName());
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
  
  protected String getAnimationType()
  {
    return this.mAnimationType;
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
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
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
    if (this.mOnRequestCloseListener != null) {
      this.mOnRequestCloseListener.onRequestClose(this.mDialog);
    }
  }
  
  protected void setAnimationType(String paramString)
  {
    this.mAnimationType = paramString;
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
    if (this.mDialog != null)
    {
      if (this.mPropertyRequiresNewDialog) {
        dismiss();
      }
    }
    else
    {
      this.mPropertyRequiresNewDialog = false;
      this.mAniType = 0;
      if ((TextUtils.isEmpty(this.mAnimationType)) || (!this.mAnimationType.equals("fade"))) {
        break label213;
      }
      this.mAniType = 1;
      this.mDialog = createDialog(getContext());
      this.mContentView = createContentView(this.mHostView);
      this.mDialog.setContentView(this.mContentView);
      updateProperties();
      if ((this.mDialog != null) && (this.mDialog.getWindow() != null) && (this.mEnterImmersionStatusBar)) {
        setDialogBar(this.mStatusBarTextDarkColor);
      }
      this.mDialog.setOnShowListener(new HippyModalHostView.1(this));
      this.mDialog.setOnDismissListener(new HippyModalHostView.2(this));
      this.mDialog.setOnKeyListener(new HippyModalHostView.3(this));
      this.mDialog.getWindow().setSoftInputMode(16);
      this.mDialog.show();
      if (this.mAniType != 1) {
        break label244;
      }
      this.mContentView.setAlpha(0.0F);
    }
    label213:
    label244:
    int i;
    do
    {
      do
      {
        return;
        updateProperties();
        return;
        if ((TextUtils.isEmpty(this.mAnimationType)) || (!this.mAnimationType.equals("slide"))) {
          break;
        }
        this.mAniType = 2;
        break;
      } while (this.mAniType != 2);
      i = getScreenHeight();
    } while (i == -1);
    this.mContentView.setTranslationY(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.modal.HippyModalHostView
 * JD-Core Version:    0.7.0.1
 */
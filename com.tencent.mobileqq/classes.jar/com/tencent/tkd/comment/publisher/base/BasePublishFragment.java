package com.tencent.tkd.comment.publisher.base;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.tkd.comment.util.CommonUtil;

public abstract class BasePublishFragment
  extends DialogFragment
{
  public static final int STATUS_HIDE_HOLDER = 0;
  public static final int STATUS_SHOW_EXPRESSION = 1;
  public static final int STATUS_SHOW_GIF = 2;
  public static final int STATUS_SHOW_KEYBOARD = 3;
  private int gravityCache;
  private View vRoot;
  
  protected abstract int getContentLayoutId();
  
  public void lockCurrentHeight(Context paramContext)
  {
    if ((getDialog() != null) && (getDialog().getWindow() != null))
    {
      Object localObject = new int[2];
      this.vRoot.getLocationOnScreen((int[])localObject);
      int i = localObject[1];
      localObject = getDialog();
      ((Dialog)localObject).getWindow().setGravity(176);
      WindowManager.LayoutParams localLayoutParams = ((Dialog)localObject).getWindow().getAttributes();
      localLayoutParams.y = (i - CommonUtil.getStatusBarHeight(paramContext));
      ((Dialog)localObject).getWindow().setAttributes(localLayoutParams);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getDialog().getWindow().setSoftInputMode(21);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setShowsDialog(true);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = new BasePublishFragment.1(this, getActivity(), R.style.b);
    this.vRoot = LayoutInflater.from(getActivity()).inflate(getContentLayoutId(), null);
    paramBundle.setContentView(this.vRoot);
    paramBundle.getWindow().setLayout(-1, -2);
    paramBundle.getWindow().setGravity(80);
    paramBundle.getWindow().setWindowAnimations(R.style.a);
    this.gravityCache = paramBundle.getWindow().getAttributes().gravity;
    return paramBundle;
  }
  
  protected void onDialogCancel() {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    dismissAllowingStateLoss();
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    paramFragmentManager = paramFragmentManager.beginTransaction();
    if (isAdded())
    {
      paramFragmentManager.show(this);
      getDialog().show();
    }
    else
    {
      paramFragmentManager.add(this, paramString);
    }
    paramFragmentManager.commitAllowingStateLoss();
  }
  
  public void unLockCurrentHeight()
  {
    this.vRoot.postDelayed(new BasePublishFragment.2(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.base.BasePublishFragment
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tkd.comment.adapt;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;
import com.tencent.tkd.comment.util.CommonUtil;

public class BaseBottomSheetDialogFragment
  extends ReportDialogFragment
{
  private DialogInterface.OnDismissListener dismissListener;
  private boolean isShowing;
  private View vRoot;
  
  private void slideToDown(BaseBottomSheetDialogFragment.MyDialog paramMyDialog, View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setFillEnabled(true);
    localTranslateAnimation.setAnimationListener(new BaseBottomSheetDialogFragment.2(this, paramMyDialog));
    paramView.clearAnimation();
    paramView.startAnimation(localTranslateAnimation);
  }
  
  private void slideToUp(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setFillEnabled(true);
    paramView.clearAnimation();
    paramView.startAnimation(localTranslateAnimation);
  }
  
  protected boolean allowDismissWhenTouchOutside()
  {
    return true;
  }
  
  public void dismiss()
  {
    if (!this.isShowing) {}
    Dialog localDialog;
    do
    {
      return;
      localDialog = getDialog();
    } while (localDialog == null);
    CommonUtil.hideInputMethod(getActivity(), localDialog.getCurrentFocus());
    this.isShowing = false;
    getDialog().dismiss();
  }
  
  public void dismissAllowingStateLoss()
  {
    dismiss();
  }
  
  public boolean isShowing()
  {
    return this.isShowing;
  }
  
  protected boolean needHideNavigationBar()
  {
    return false;
  }
  
  protected boolean needTransparentBackground()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getDialog().getWindow();
    if (paramBundle != null)
    {
      paramBundle.setGravity(80);
      paramBundle.setLayout(-1, -2);
      paramBundle.setBackgroundDrawable(new ColorDrawable(0));
      paramBundle.getDecorView().setPadding(0, 0, 0, 0);
      if (allowDismissWhenTouchOutside()) {
        paramBundle.getDecorView().setOnTouchListener(new BaseBottomSheetDialogFragment.WindowTouchListener(this, null));
      }
      if (needTransparentBackground())
      {
        WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
        localLayoutParams.dimAmount = 0.0F;
        paramBundle.setAttributes(localLayoutParams);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Util.init(getActivity().getApplication());
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    setStyle(1, 0);
    return new BaseBottomSheetDialogFragment.MyDialog(this, getActivity(), getTheme());
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.isShowing = false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    this.isShowing = false;
    if (this.dismissListener != null) {
      this.dismissListener.onDismiss(paramDialogInterface);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.vRoot = paramView;
    this.vRoot.setOnClickListener(new BaseBottomSheetDialogFragment.1(this));
    slideToUp(paramView);
    this.isShowing = true;
  }
  
  public void setDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.dismissListener = paramOnDismissListener;
  }
  
  @Deprecated
  public final int show(FragmentTransaction paramFragmentTransaction, String paramString)
  {
    throw new UnsupportedOperationException("not support");
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    if (this.isShowing) {}
    String str;
    do
    {
      return;
      this.isShowing = true;
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = getClass().getSimpleName();
      }
    } while (paramFragmentManager.findFragmentByTag(str) != null);
    try
    {
      super.show(paramFragmentManager, str);
      return;
    }
    catch (Exception paramString)
    {
      paramFragmentManager = paramFragmentManager.beginTransaction();
      paramFragmentManager.add(this, str);
      paramFragmentManager.commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.BaseBottomSheetDialogFragment
 * JD-Core Version:    0.7.0.1
 */
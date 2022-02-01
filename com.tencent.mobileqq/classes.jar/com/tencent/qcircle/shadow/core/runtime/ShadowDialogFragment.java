package com.tencent.qcircle.shadow.core.runtime;

import android.content.DialogInterface;
import android.os.Bundle;

public class ShadowDialogFragment
  extends ShadowFragment
{
  private ContainerDialogFragment getContainerDialogFragment()
  {
    return (ContainerDialogFragment)this.mContainerFragment;
  }
  
  public void dismiss()
  {
    getContainerDialogFragment().dismiss();
  }
  
  public void dismissAllowingStateLoss()
  {
    getContainerDialogFragment().dismissAllowingStateLoss();
  }
  
  public ShadowDialog getDialog()
  {
    return (ShadowDialog)getContainerDialogFragment().getDialog();
  }
  
  public boolean getShowsDialog()
  {
    return getContainerDialogFragment().getShowsDialog();
  }
  
  public int getTheme()
  {
    return getContainerDialogFragment().getTheme();
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public ShadowDialog onCreateDialog(Bundle paramBundle)
  {
    return new ShadowDialog(getActivity(), getTheme());
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    getContainerDialogFragment().superOnDismiss(paramDialogInterface);
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    if (this.mIsAppCreateFragment) {
      getContainerDialogFragment().setCancelable(paramBoolean);
    }
  }
  
  public void setShowsDialog(boolean paramBoolean)
  {
    getContainerDialogFragment().setShowsDialog(paramBoolean);
  }
  
  public void setStyle(int paramInt1, int paramInt2)
  {
    if (this.mIsAppCreateFragment) {
      getContainerDialogFragment().setStyle(paramInt1, paramInt2);
    }
  }
  
  public void show(PluginFragmentManager paramPluginFragmentManager, String paramString)
  {
    getContainerDialogFragment().show(paramPluginFragmentManager.mBase, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowDialogFragment
 * JD-Core Version:    0.7.0.1
 */
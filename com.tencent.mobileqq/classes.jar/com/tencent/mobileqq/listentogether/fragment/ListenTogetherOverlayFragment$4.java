package com.tencent.mobileqq.listentogether.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;

class ListenTogetherOverlayFragment$4
  implements DialogInterface.OnClickListener
{
  ListenTogetherOverlayFragment$4(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = BaseApplicationImpl.getContext();
    if (((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).requestPermission(paramDialogInterface))
    {
      ListenTogetherOverlayFragment.a(this.a, true);
      return;
    }
    ListenTogetherOverlayFragment.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.4
 * JD-Core Version:    0.7.0.1
 */
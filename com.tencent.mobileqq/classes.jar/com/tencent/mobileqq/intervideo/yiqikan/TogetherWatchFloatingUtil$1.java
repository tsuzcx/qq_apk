package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenReporter;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;

final class TogetherWatchFloatingUtil$1
  implements DialogInterface.OnClickListener
{
  TogetherWatchFloatingUtil$1(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FloatingScreenReporter.c();
    ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).requestPermission(this.a);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil.1
 * JD-Core Version:    0.7.0.1
 */